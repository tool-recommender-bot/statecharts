/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.examples.wizard.pages;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.yakindu.sct.examples.wizard.ExampleActivator;
import org.yakindu.sct.examples.wizard.ExampleWizardImages;
import org.yakindu.sct.examples.wizard.preferences.ExamplesPreferenceConstants;
import org.yakindu.sct.examples.wizard.search.IExampleSearchService;
import org.yakindu.sct.examples.wizard.service.ExampleData;
import org.yakindu.sct.examples.wizard.service.ExampleWizardConstants;
import org.yakindu.sct.examples.wizard.service.IExampleService;

import com.google.inject.Inject;

/**
 * 
 * @author t00manysecretss
 * @author andreas muelder - Replace Image Gallery with Browser widget
 * 
 */
public class SelectExamplePage extends WizardPage
		implements ExampleWizardConstants, ISelectionChangedListener, SelectionListener, IPropertyChangeListener {

	private static final String PRO_BUNDLE = "com.yakindu.sct.domain.c";
	private static final String PRO_UPDATE_SITE = "https://info.itemis.com/yakindu/statecharts/pro/";
	
	@Inject
	private IExampleService exampleService;
	
	@Inject
	private IExampleSearchService searchService;
	
	private TableViewer viewer;
	private ExampleData selection;
	private Browser browser;
	private MessageArea messageArea;
	
	/** ID of example to be installed */
	private String exampleIdToInstall;
	private Text searchField;

	public SelectExamplePage() {
		super(SELECT_PAGE_TITLE);
		setTitle(SELECT_PAGE_TITLE);
		setDescription(SELECT_PAGE_DESCRIPTION);
		setImageDescriptor(ExampleWizardImages.YAKINDU_LOGO.imageDescriptor());
		setPageComplete(false);
		ExampleActivator.getDefault().getPreferenceStore().addPropertyChangeListener(this);
	}

	@Override
	public void dispose() {
		ExampleActivator.getDefault().getPreferenceStore().removePropertyChangeListener(this);
		super.dispose();
	}

	public void createControl(Composite parent) {
		Composite root = new Composite(parent, SWT.NONE);
		root.setLayout(new GridLayout(1, true));
		createUpdateGroup(root);
		createSearchGroup(root);
		SashForm container = new SashForm(root, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(container);
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);
		createTreeViewer(container);
		createDetailsPane(container);
		container.setWeights(new int[] { 1, 2 });
		setControl(root);
	}

	private void createUpdateGroup(Composite root) {
		messageArea = new MessageArea(root);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(messageArea);
		messageArea.addSelectionListener(this);
		messageArea.hide();
	}
	
	private void createSearchGroup(Composite root) {
		Composite searchContainer = new Composite(root, SWT.NONE);
		GridLayout layout = new GridLayout(1, false);
		searchContainer.setLayout(layout);
		searchContainer.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		
        Label wizardLabel = new Label(searchContainer, SWT.NONE);
        wizardLabel.setFont(root.getFont());
        wizardLabel.setText("Examples:");
		
		searchField = new Text(searchContainer, SWT.SINGLE | SWT.BORDER | SWT.SEARCH | SWT.ICON_CANCEL);
		searchField.setText("type search keywords");
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).applyTo(searchField);
		searchField.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				if (searchField.getText().isEmpty()) {
					cancelSearch();
				} else {
					List<ExampleData> results = searchService.search(searchField.getText());
					showSearchResults(results);
				}
			}
		});
		searchField.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				if (e.detail == SWT.ICON_CANCEL)
					cancelSearch();
			}
		});
	}
	
	protected void cancelSearch() {
		setInput(getExamples(new NullProgressMonitor()));
	}

	protected void showSearchResults(final List<ExampleData> examples) {
		setInput(examples);
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			initAsync();
		} else {
			viewer.setInput(null);
			browser.setUrl("about:blank");
		}
	}

	private boolean revealExamplesAutomatically() {
		return (exampleIdToInstall != null) && (!exampleService.exists() || !exampleService.isUpToDate(null));
	}

	private void initAsync() {
		try {
			getWizard().getContainer().run(true, false, new IRunnableWithProgress() {
				@Override
				public void run(final IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					init(monitor);
				}
			});

			if (revealExamplesAutomatically()) {
				Display.getCurrent().asyncExec(new Runnable() {
					@Override
					public void run() {
						messageArea.button.setEnabled(false);
						revealExamples();
					}
				});
			}
		} catch (InvocationTargetException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void init(final IProgressMonitor monitor) {
		if (!exampleService.exists()) {
			Display.getDefault().syncExec(new Runnable() {
				@Override
				public void run() {
					messageArea.showDownload();
					messageArea.getParent().layout(true);
				}
			});
		} else if (!exampleService.isUpToDate(monitor)) {
			Display.getDefault().syncExec(new Runnable() {

				@Override
				public void run() {
					List<ExampleData> examples = getExamples(monitor);
					setInput(examples);
					searchService.index(examples);
					messageArea.showUpdate();
					messageArea.getParent().layout(true);
				}
			});
		} else {
			Display.getDefault().syncExec(new Runnable() {
				@Override
				public void run() {
					List<ExampleData> examples = getExamples(monitor);
					setInput(examples);
					searchService.index(examples);
				}
			});
		}

	}

	protected void setInput(List<ExampleData> input) {
		messageArea.hide();
		viewer.setInput(input);
		// explicit layouting required for Unix systems
		viewer.getControl().getParent().getParent().layout(true);
		filterAndSelectExampleToInstall(viewer, input);
	}

	protected List<ExampleData> getExamples(final IProgressMonitor monitor) {
		return exampleService.getExamples(monitor);
	}

	protected void filterAndSelectExampleToInstall(TableViewer viewer, List<ExampleData> input) {
		final Optional<ExampleData> exampleToInstall = input.stream()
				.filter(i -> exampleIdToInstall == null || exampleIdToInstall.equals(i.getId())).findFirst();

		if (exampleToInstall.isPresent()) {
			viewer.addFilter(new ViewerFilter() {

				@Override
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if (exampleIdToInstall == null) {
						return true;
					}
					if (element instanceof ExampleData) {
						return exampleIdToInstall.equals(((ExampleData) element).getId());
					}
					if (element instanceof ExampleContentProvider.Category) {
						return ((ExampleContentProvider.Category) element).getChildren().contains(exampleToInstall.get());
					}
					return true;
				}
			});
			viewer.setSelection(new StructuredSelection(exampleToInstall.get()), true);
		}
	}

	protected void createTreeViewer(Composite container) {
		viewer = new TableViewer(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.SINGLE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(viewer.getControl());
		viewer.setContentProvider(new ArrayContentProvider());
		viewer.setLabelProvider(new DelegatingStyledCellLabelProvider(new ExampleLabelProvider()));
		viewer.addSelectionChangedListener(this);
	}

	protected void updateSelection(ExampleData data) {
		selection = data;
		setDetailPaneContent(data);
		setPageComplete(true);
		setErrorMessage(null);
		checkInstalledPlugins(data);
		viewer.refresh();
	}

	private void checkInstalledPlugins(ExampleData data) {
		if (data.isProfessional() && Platform.getBundle(PRO_BUNDLE) == null) {
			messageArea.showProInstall();
		} else {
			messageArea.hide();
		}
		messageArea.getParent().layout(true);
		this.getControl().update();
	}

	protected void setDetailPaneContent(ExampleData exampleData) {
		browser.setUrl(exampleData.getDetailsUrl());
	}

	protected void createDetailsPane(Composite parent) {
		final Composite composite = new Composite(parent, SWT.BORDER);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new FillLayout());
		browser = new Browser(composite, SWT.NONE);
	}

	public ExampleData getSelection() {
		return selection;
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		Object firstElement = ((StructuredSelection) event.getSelection()).getFirstElement();
		if (firstElement instanceof ExampleData)
			updateSelection((ExampleData) firstElement);
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		switch (messageArea.getState()) {
		case DOWNLOAD:
		case UPDATE:
			revealExamples();
			break;
		case INSTALL:
			Program.launch(PRO_UPDATE_SITE);
			break;
		default:
			break;
		}
	}

	protected void revealExamples() {
		try {
			getWizard().getContainer().run(true, true, new IRunnableWithProgress() {
				@Override
				public void run(final IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					final IStatus status = exampleService.fetchAllExamples(monitor);
					Display.getDefault().asyncExec(new Runnable() {
						@Override
						public void run() {
							if (status.isOK()) {
								List<ExampleData> examples = getExamples(monitor);
								SelectExamplePage.this.setInput(examples);
								searchService.index(examples);
							} else {
								messageArea.showError();
							}
						}
					});
				}
			});

		} catch (InvocationTargetException | InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		widgetSelected(e);
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (ExamplesPreferenceConstants.STORAGE_LOCATION.equals(event.getProperty())) {
			initAsync();
		}
	}

	public void setInstallExampleId(String exampleId) {
		this.exampleIdToInstall = exampleId;
	}

}