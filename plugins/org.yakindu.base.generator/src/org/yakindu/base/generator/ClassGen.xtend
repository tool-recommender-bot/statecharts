package org.yakindu.base.generator

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.yakindu.base.generator.templates.ClassTemplate

class ClassGen implements CodeElement {
	@Accessors protected String className;
	@Accessors protected String namespace;
	@Accessors protected String visibility;
	@Accessors protected ClassGen superClass;
	@Accessors protected List<ClassGen> interfaces;
	
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