package org.yakindu.base.generator

import com.google.inject.Inject
import org.eclipse.xtend.lib.annotations.Accessors
import org.yakindu.base.generator.templates.ParameterTemplate
import org.yakindu.base.types.TypeSpecifier

class ParameterGen extends CodeElement {
	@Accessors protected TypeSpecifier parameterType
	@Accessors protected String parameterName
	@Accessors protected boolean isConst
	
	@Inject ParameterTemplate template
	
	new() {
	}
	
	new(TypeSpecifier ts, String name) {
		parameterType = ts
		parameterName = name
	}
	
	override generate() {
		template.generate(this)
	}
}