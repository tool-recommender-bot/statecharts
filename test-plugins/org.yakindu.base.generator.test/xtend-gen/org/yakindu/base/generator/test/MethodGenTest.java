package org.yakindu.base.generator.test;

import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.base.generator.ParameterGen;
import org.yakindu.base.generator.Visibility;
import org.yakindu.base.generator.test.AbstractGeneratorTest;
import org.yakindu.base.generator.test.util.GeneratorInjectorProvider;
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
  
  @Test
  public void methodConstParamTest1() {
    this.testMethod.setMethodName("paramFunc");
    List<ParameterGen> _createTestParameters = this.createTestParameters();
    final Function1<ParameterGen, ParameterGen> _function = (ParameterGen it) -> {
      ParameterGen _xblockexpression = null;
      {
        it.setIsConst(true);
        _xblockexpression = it;
      }
      return _xblockexpression;
    };
    final List<ParameterGen> params = ListExtensions.<ParameterGen, ParameterGen>map(_createTestParameters, _function);
    ParameterGen _get = params.get(0);
    this.testMethod.addParameter(_get);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("paramFunc(const integer p1) {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String exp = _builder.toString();
    this.generatesTo(exp, this.testMethod);
  }
  
  @Test
  public void methodConstParamTest2() {
    this.testMethod.setMethodName("paramFunc");
    List<ParameterGen> _createTestParameters = this.createTestParameters();
    final Function1<ParameterGen, ParameterGen> _function = (ParameterGen it) -> {
      ParameterGen _xblockexpression = null;
      {
        it.setIsConst(true);
        _xblockexpression = it;
      }
      return _xblockexpression;
    };
    final List<ParameterGen> params = ListExtensions.<ParameterGen, ParameterGen>map(_createTestParameters, _function);
    ParameterGen _get = params.get(0);
    this.testMethod.addParameter(_get);
    ParameterGen _get_1 = params.get(1);
    this.testMethod.addParameter(_get_1);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("paramFunc(const integer p1, const boolean p2) {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String exp = _builder.toString();
    this.generatesTo(exp, this.testMethod);
  }
  
  @Test
  public void methodConstParamTest3() {
    this.testMethod.setMethodName("paramFunc");
    List<ParameterGen> _createTestParameters = this.createTestParameters();
    final Function1<ParameterGen, ParameterGen> _function = (ParameterGen it) -> {
      ParameterGen _xblockexpression = null;
      {
        it.setIsConst(true);
        _xblockexpression = it;
      }
      return _xblockexpression;
    };
    final List<ParameterGen> params = ListExtensions.<ParameterGen, ParameterGen>map(_createTestParameters, _function);
    ParameterGen _get = params.get(3);
    this.testMethod.addParameter(_get);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("paramFunc(const cmplx<string> p4) {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String exp = _builder.toString();
    this.generatesTo(exp, this.testMethod);
  }
  
  @Test
  public void methodReturnTypeTest() {
    this.testMethod.setMethodName("returnFunc");
    final TypeSpecifier returnType = this.typesFactory.toTypeSpecifier("integer");
    this.testMethod.setReturnType(returnType);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("integer returnFunc() {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String exp = _builder.toString();
    this.generatesTo(exp, this.testMethod);
  }
  
  @Test
  public void methodVisibilityReturnTypeTest() {
    this.testMethod.setMethodName("returnFunc");
    final TypeSpecifier returnType = this.typesFactory.toTypeSpecifier("integer");
    this.testMethod.setReturnType(returnType);
    this.testMethod.setVisibility(Visibility.PRIVATE);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private integer returnFunc() {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String exp = _builder.toString();
    this.generatesTo(exp, this.testMethod);
  }
}
