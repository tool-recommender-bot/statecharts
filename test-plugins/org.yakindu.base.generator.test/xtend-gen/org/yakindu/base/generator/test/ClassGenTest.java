package org.yakindu.base.generator.test;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;
import org.yakindu.base.generator.ClassGen;
import org.yakindu.base.generator.Visibility;
import org.yakindu.base.generator.test.AbstractGeneratorTest;

@SuppressWarnings("all")
public class ClassGenTest extends AbstractGeneratorTest {
  @Test
  public void testSimpleClassLayout() {
    final ClassGen testClass = this.createClassGen();
    testClass.setClassName("testClass");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class testClass {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String exp = _builder.toString();
    this.generatesTo(exp, testClass);
  }
  
  @Test
  public void testVisibility() {
    final ClassGen testClass = this.createClassGen();
    testClass.setClassName("PrivateClass");
    testClass.setVisibility(Visibility.PRIVATE);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private class PrivateClass {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String exp = _builder.toString();
    this.generatesTo(exp, testClass);
  }
}
