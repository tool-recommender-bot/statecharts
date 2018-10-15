/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 *
 */

package org.yakindu.sct.simulation.core.sexec.container;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.xtext.EcoreUtil2;
import org.yakindu.base.types.Direction;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sruntime.ExecutionContext;
import org.yakindu.sct.model.sruntime.ExecutionEvent;
import org.yakindu.sct.model.sruntime.SRuntimePackage;
import org.yakindu.sct.simulation.core.engine.ISimulationEngine;
import org.yakindu.sct.simulation.core.sexec.interpreter.IExecutionFlowInterpreter;
import org.yakindu.sct.simulation.core.util.ExecutionContextExtensions;

import com.google.inject.Inject;

/**
 * Event Driven implementation of the {@link ISimulationEngine}.
 *
 * @author andreas muelder - Initial contribution and API
 *
 */
public class EventDrivenSimulationEngine extends AbstractExecutionFlowSimulationEngine {

	@Inject
	protected ExecutionContextExtensions extensions;

	protected EventDrivenCycleAdapter cycleAdapter;

	public EventDrivenSimulationEngine(Statechart statechart) {
		super(statechart);
	}

	@Override
	public void init() {
		super.init();
		cycleAdapter = new EventDrivenCycleAdapter(interpreter);
		context.eAdapters().add(cycleAdapter);
	}

	@Override
	public void terminate() {
		context.eAdapters().remove(cycleAdapter);
		super.terminate();
	}

	@Override
	public void suspend() {
		cycleAdapter.suspend();
		super.suspend();
	}

	@Override
	public void resume() {
		super.resume();
		cycleAdapter.resume();
	}

	@Override
	public void stepForward() {
		try {
			interpreter.runCycle();
		} catch (Exception ex) {
			handleException(ex);
		}
		super.stepForward();
	}

	@Override
	protected boolean useInternalEventQueue() {
		return true;
	}

	public static class EventDrivenCycleAdapter extends EContentAdapter {

		private IExecutionFlowInterpreter interpreter;

		private boolean suspended = false;
		private boolean cycleAfterResume = false;

		public EventDrivenCycleAdapter(IExecutionFlowInterpreter interpreter) {
			this.interpreter = interpreter;
		}

		@Override
		public void notifyChanged(Notification notification) {
			super.notifyChanged(notification);
			if (notification.getNotifier() instanceof ExecutionEvent
					&& notification.getFeature() == SRuntimePackage.Literals.EXECUTION_EVENT__RAISED) {
				ExecutionEvent event = (ExecutionEvent) notification.getNotifier();
				if (notification.getNewBooleanValue() != notification.getOldBooleanValue()) {
					if (notification.getNewBooleanValue()
							&& (event.getDirection() != Direction.OUT || isSubContext(event))) {
						if (!suspended) {
							System.out.println(
									"Raised " + event + " runcycle on " + interpreter.getExecutionContext().getName());
							interpreter.runCycle();
						} else {
							cycleAfterResume = true;
						}
					}
				}
			}
		}

		protected boolean isSubContext(ExecutionEvent event) {
			return EcoreUtil2.getContainerOfType(event, ExecutionContext.class) != interpreter.getExecutionContext();
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return type == EventDrivenCycleAdapter.class;
		}

		public void suspend() {
			suspended = true;
		}

		public void resume() {
			suspended = false;
			if (cycleAfterResume)
				interpreter.runCycle();
			cycleAfterResume = false;
		}
	}

	public boolean isSubContext(ExecutionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
}
