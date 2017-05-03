package org.yakindu.base.generator.test;

import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.base.generator.ParameterGen;
import org.yakindu.base.generator.Visibility;
import org.yakindu.base.generator.test.AbstractGeneratorTest;
import org.yakindu.base.generator.test.util.GeneratorInjectorProvider;
import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.TypeSpecifier;

@RunWith(XtextRunner.class)
@InjectWith(GeneratorInjectorProvider.class)
@SuppressWarnings("all")
public class MethodGenTest extends AbstractGeneratorTest {
  @Test
  public void methodLayoutTest() {
    this.testMethod.setMethodName("myFunc");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("myFunc() {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String exp = _builder.toString();
    this.generatesTo(exp, this.testMethod);
  }
  
  @Test
  public void methodVisibilityTest() {
    this.testMethod.setMethodName("myFunc");
    this.testMethod.setVisibility(Visibility.PUBLIC);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public myFunc() {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String exp = _builder.toString();
    this.generatesTo(exp, this.testMethod);
  }
  
  @Test
  public void methodParamTest1() {
    this.testMethod.setMethodName("paramFunc");
    final List<ParameterGen> params = this.createTestParameters();
    ParameterGen _get = params.get(0);
    this.testMethod.addParameter(_get);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("paramFunc(integer p1) {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String exp = _builder.toString();
    this.generatesTo(exp, this.testMethod);
  }
  
  @Test
  public void methodParamTest2() {
    this.testMethod.setMethodName("paramFunc");
    final List<ParameterGen> params = this.createTestParameters();
    ParameterGen _get = params.get(0);
    this.testMethod.addParameter(_get);
    ParameterGen _get_1 = params.get(1);
    this.testMethod.addParameter(_get_1);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("paramFunc(integer p1, boolean p2) {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String exp = _builder.toString();
    this.generatesTo(exp, this.testMethod);
  }
  
  @Test
  public void methodParamTest3() {
    this.testMethod.setMethodName("paramFunc");
    final List<ParameterGen> params = this.createTestParameters();
    ParameterGen _get = params.get(3);
    this.testMethod.addParameter(_get);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("paramFunc(cmplx<string> p4) {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String exp = _builder.toString();
    this.generatesTo(exp, this.testMethod);
  }
  
  public List<ParameterGen> createTestParameters() {
    final List<ParameterGen> params = CollectionLiterals.<ParameterGen>newArrayList();
    TypeSpecifier ts = this.typesFactory.toTypeSpecifier("integer");
    ParameterGen p = this.createParameterGen(ts, "p1");
    params.add(p);
    TypeSpecifier _typeSpecifier = this.typesFactory.toTypeSpecifier("boolean");
    ts = _typeSpecifier;
    ParameterGen _createParameterGen = this.createParameterGen(ts, "p2");
    p = _createParameterGen;
    params.add(p);
    TypeSpecifier _typeSpecifier_1 = this.typesFactory.toTypeSpecifier("string");
    ts = _typeSpecifier_1;
    ParameterGen _createParameterGen_1 = this.createParameterGen(ts, "p3");
    p = _createParameterGen_1;
    params.add(p);
    ComplexType _createComplexType = this.typesFactory.createComplexType("cmplx");
    TypeSpecifier cmplx = this.typesFactory.toTypeSpecifier(_createComplexType);
    EList<TypeSpecifier> _typeArguments = cmplx.getTypeArguments();
    _typeArguments.add(ts);
    ParameterGen _createParameterGen_2 = this.createParameterGen(cmplx, "p4");
    p = _createParameterGen_2;
    params.add(p);
    return params;
  }
}
