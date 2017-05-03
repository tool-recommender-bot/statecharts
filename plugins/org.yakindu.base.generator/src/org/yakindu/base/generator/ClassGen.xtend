package org.yakindu.base.generator

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.yakindu.base.generator.templates.ClassTemplate

/**
 * Generator class to build classes in different languages.
 * This class holds the data, while the injected
 * template cares about the layout and the target language.
 */
class ClassGen extends CodeElement {
	@Accessors protected String className
	@Accessors protected String namespace
	@Accessors protected String visibility
	@Accessors protected ClassGen superClass
	@Accessors protected List<ClassGen> interfaces

	/*
	 * The template gets injected, so this class is language independent.
	 */	
	@Inject ClassTemplate template;
	
	new() {
		className = ""
		namespace = ""
		visibility = ""
		superClass = null
		interfaces = newArrayList
	}
	
	override generate() {
		template.generate(this).toString
	}
}