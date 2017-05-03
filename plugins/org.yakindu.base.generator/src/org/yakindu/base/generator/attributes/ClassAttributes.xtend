package org.yakindu.base.generator.attributes

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.yakindu.base.generator.ClassGen
import org.yakindu.base.generator.Visibility

class ClassAttributes extends Attributes {
	@Accessors protected String className;
	@Accessors protected String namespace;
	@Accessors protected Visibility visibility;
	@Accessors protected ClassGen superClass;
	@Accessors protected List<ClassGen> interfaces;
}