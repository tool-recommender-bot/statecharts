package org.yakindu.sct.generator.pax

import org.yakindu.sct.model.sexec.ExecutionFlow

class PaxNaming {
	
//	@Inject extension PaxNavigation
	
	def enumName(ExecutionFlow it) {
		'States'
	}
	
	def application(ExecutionFlow it){
		'application'
	}
	
	def x(String it) { it + ".x" }
}