package org.yakindu.sct.generator.core.submodules.lifecycle;

import org.yakindu.sct.model.sexec.ExecutionFlow;

public interface IsActive {
	public CharSequence isActive(ExecutionFlow flow);
}
