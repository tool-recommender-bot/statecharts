package org.yakindu.base.generator

import org.yakindu.base.generator.ICodeElement
import org.eclipse.xtend.lib.annotations.Accessors

class CodeElement implements ICodeElement {
	@Accessors(PROTECTED_SETTER, PUBLIC_GETTER) protected CodeElement parent;
	override generate() ''''''
}