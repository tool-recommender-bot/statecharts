package org.yakindu.base.generator

import com.google.inject.Inject
import com.google.inject.Injector
import org.eclipse.xtend.lib.annotations.Accessors

class CodeElement implements ICodeElement {
	@Accessors(PROTECTED_SETTER, PUBLIC_GETTER) protected CodeElement parent;
	@Inject protected Injector injector;
	
	override generate() ''''''
}