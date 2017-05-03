package org.yakindu.base.generator.templates

import java.util.List
import org.yakindu.base.generator.CodeElement
import org.eclipse.xtend.lib.annotations.Accessors

class ContentTemplate extends Template {
	@Accessors(PUBLIC_GETTER, PROTECTED_SETTER) protected List<CodeElement> content;
	
	new() {
		content = newArrayList
	}
	
	def addContent(CodeElement ce) {
		content.add(ce);
	}
	
	def protected generateContent() {
		val sb = new StringBuilder()
		var first = true
		for(ce : content) {
			if(first) {
				first = false
				sb.append(ce.generate())
			} else {
				sb.append("\n")
				sb.append(ce.generate())
			}
		}
		sb.toString
	}
}