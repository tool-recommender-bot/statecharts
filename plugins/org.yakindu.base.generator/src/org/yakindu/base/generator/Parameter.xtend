package org.yakindu.base.generator

import com.google.inject.Inject
import org.eclipse.xtend.lib.annotations.Data
import org.yakindu.base.generator.templates.ParameterTemplate
import org.yakindu.base.types.TypeSpecifier

@Data class Parameter extends CodeElement {
	TypeSpecifier parameterType
	String parameterName
	
	@Inject ParameterTemplate template
	
	override generate() {
		template.generate(this)
	}
}