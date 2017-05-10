package org.yakindu.base.generator

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.yakindu.base.expressions.expressions.Expression
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
	@Accessors protected List<ClassMember> classMembers
	protected String thisScope;
	protected String scope;

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
		classMembers = newArrayList
		thisScope = "interface this: "
		scope = "internal: "
	}
	
	override generate() {
		template.generate(this).toString
	}
	
	def addMember(ClassMember member) {
		if(classMembers == null) {
			classMembers = newArrayList
		}
		classMembers.add(member)
	}
	
	def protected getScope() {
		return thisScope + " " + scope
	}
	
	def addConstructor(List<ParameterGen> parameters) {
		val constructorMethod = injector.getInstance(MethodGen)
		if(parameters == null) {
			constructorMethod.parameters = newArrayList
		} else {
			constructorMethod.parameters = parameters
		}
		constructorMethod.visibility = Visibility.PUBLIC
		constructorMethod.methodName = this.className
		for(p : parameters) {
			addMemberVariable(p.parameterName, p.parameterType.type.name)
			val assignment = parser.parseExpression('''this.«p.parameterName» = «p.parameterName»''', typeof(Expression).simpleName, getScope)
			val exp = injector.getInstance(ExpressionGen)
			exp.expression = assignment as Expression
			constructorMethod.addToBody(exp)
		}
		addMember(constructorMethod)
	}
	
	def addMemberVariable(String name, String type) {
		val newScopeMember = '''var «name»: «type» '''
		thisScope += newScopeMember
		scope += newScopeMember
	}
}