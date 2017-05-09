package org.yakindu.base.generator

import com.google.inject.Inject
import org.eclipse.xtend.lib.annotations.Accessors
import org.yakindu.base.generator.templates.VariableTemplate
import org.yakindu.sct.model.stext.stext.VariableDefinition

class VariableGen extends CodeElement implements ClassMember {
	@Accessors protected VariableDefinition varDef 
	@Accessors protected String visibility
	@Accessors protected boolean isStatic
	
	@Inject VariableTemplate template
	
	new() {
		visibility = ""
	}
	
	def isConstant() {
		varDef.isConst
	}
	
	def setIsConstant(boolean const) {
		varDef.const = const
	}
	
	override generate() {
		template.generate(this).toString
	}
}