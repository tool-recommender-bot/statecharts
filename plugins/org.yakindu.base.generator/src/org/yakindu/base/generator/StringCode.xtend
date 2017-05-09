package org.yakindu.base.generator

import org.eclipse.xtend.lib.annotations.Accessors

class StringCode extends CodeElement {
	@Accessors protected String content
	
	override generate() {
		content
	}
}