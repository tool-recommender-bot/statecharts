package org.yakindu.base.generator.extensions

import com.google.inject.Inject
import org.yakindu.base.expressions.expressions.ExpressionsFactory
import org.yakindu.base.generator.GeneratorHelper

class GeneratorExtensions {
	@Inject protected extension GeneratorHelper helper
	protected extension ExpressionsFactory expressionsFactory = ExpressionsFactory.eINSTANCE
}