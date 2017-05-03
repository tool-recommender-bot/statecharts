package org.yakindu.base.generator

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.yakindu.base.generator.templates.MethodTemplate

class MethodGen extends CodeElement {
	@Accessors protected String methodName
	@Accessors protected String visibility
	@Accessors protected List<ParameterGen> parameters
	@Accessors protected List<CodeElement> methodBody
	
	@Inject MethodTemplate template
	
	override generate() {
		template.generate(this)
	}
	
	def addParameter(ParameterGen parameter) {
		if(parameters == null) {
			parameters = newArrayList
		}
		parameters.add(parameter)
	}
	
	def addToBody(CodeElement elem) {
		if(methodBody == null) {
			methodBody = newArrayList
		}
		methodBody.add(elem)
	}
}