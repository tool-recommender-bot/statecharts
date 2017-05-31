package org.yakindu.base.generator.java.templates

import com.google.inject.Inject
import org.yakindu.base.generator.generator.AccessRestricted
import org.yakindu.base.generator.generator.CodeElement
import org.yakindu.base.generator.templates.ITemplate
import org.yakindu.base.generator.templates.TemplateProvider

abstract class Template implements ITemplate {
	@Inject protected TemplateProvider templateProvider

	/**
	 * Dispatch function that gets extended by the child classes.
	 */
	def dispatch String generate(CodeElement it) {
		throw new UnsupportedOperationException(
			"Trying to generate a  " + it.class.simpleName + "with a " + this.class.simpleName
		)
	}

	def generateVisibility(AccessRestricted it) {
		switch (visibility) {
			case null:
				""
			case NONE:
				""
			case PRIVATE: {
				"private "
			}
			case PROTECTED: {
				"protected "
			}
			case PUBLIC: {
				"public "
			}
		}
	}
	
	def CharSequence generateDocumentation(CodeElement it) {
		if(documentation.nullOrEmpty) {
			return ''''''
		}
		if(documentation.multiline) {
			return 
			''' 
			/**
			 «FOR line : documentation.split("\n")»
			 * «line.trim»
			 «ENDFOR»
			 */
			'''
		}
		'''/** «documentation» */'''
	}
	
	def isMultiline(String doc) {
		if(doc.contains("\n")) {
			return true
		}
		return false
	}
	
	def generateContent(CodeElement it) {
		'''
		«FOR c:children»
		«templateProvider.get(c).generate(c)»
		«ENDFOR»
		'''
	}
}
