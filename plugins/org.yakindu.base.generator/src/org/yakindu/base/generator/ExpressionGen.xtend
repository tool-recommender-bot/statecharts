package org.yakindu.base.generator

import com.google.inject.Inject
import org.eclipse.xtend.lib.annotations.Accessors
import org.yakindu.base.expressions.expressions.Expression
import org.yakindu.base.generator.templates.ExpressionTemplate

class ExpressionGen extends CodeElement {
	@Accessors protected Expression expression
	
	@Inject ExpressionTemplate template
	
	override generate() {
		template.generate(this).toString
	}
}