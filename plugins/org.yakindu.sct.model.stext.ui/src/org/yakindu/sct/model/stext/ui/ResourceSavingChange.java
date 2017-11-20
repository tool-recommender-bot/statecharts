package org.yakindu.sct.model.stext.ui;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.xtext.resource.SaveOptions;

/**
 * Used to composes changes for a resource and save once.
 */
public final class ResourceSavingChange extends CompositeChange {

    private static final Logger LOGGER = Logger.getLogger(ResourceSavingChange.class);

    private final URI changedResource;
    private final ResourceSet resourceSet;

    ResourceSavingChange(final String name, final URI changedResource, final ResourceSet resourceSet) {
        super(name);
        this.changedResource = changedResource;
        this.resourceSet = resourceSet;
    }

    @Override
    public Change perform(final IProgressMonitor pm) throws CoreException {
        final Change undoCompositeChange = super.perform(pm);
        try {
            resourceSet.getResource(changedResource, false)
                    .save(SaveOptions.newBuilder().format().getOptions().toOptionsMap());
        } catch (final IOException e) {
            LOGGER.error(String.format("Failed to save resource '%s' after applying changes : %s",
                    changedResource.toFileString(), getName()), e);
        }
        return createUndoChange(undoCompositeChange);
    }

    private ResourceSavingChange createUndoChange(final Change undoCompositeChange) {
        ResourceSavingChange undoResourceSavingChange =
                new ResourceSavingChange(getName(), changedResource, resourceSet);
        undoResourceSavingChange.add(undoCompositeChange);
        return undoResourceSavingChange;
    }
}