package org.yakindu.sct.model.sgraph.validation;

import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.EValidatorRegistrar;

import com.google.inject.Inject;

public abstract class AbstractSGraphJavaValidator extends AbstractDeclarativeValidator{
	@Override
	@Inject
	public void register(EValidatorRegistrar registrar) {
		// Do not register because this validator is only a composite #398987
	}
}
