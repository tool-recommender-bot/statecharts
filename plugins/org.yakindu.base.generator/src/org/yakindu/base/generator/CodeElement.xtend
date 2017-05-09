package org.yakindu.base.generator

import com.google.inject.Inject
import com.google.inject.Injector
import org.eclipse.xtend.lib.annotations.Accessors
import org.yakindu.sct.model.stext.expressions.IExpressionParser

class CodeElement implements ICodeElement {
	@Accessors(PROTECTED_SETTER, PUBLIC_GETTER) protected CodeElement parent;
	@Inject protected Injector injector;
	@Inject protected IExpressionParser parser
	
	override generate() ''''''
}