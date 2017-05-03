package org.yakindu.base.generator

interface ICodeElement {
	def CharSequence generate()
	def ICodeElement getParent()
}