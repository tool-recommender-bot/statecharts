package org.yakindu.base.generator.test;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;
import org.yakindu.base.generator.MethodGen;
import org.yakindu.base.generator.Visibility;
import org.yakindu.base.generator.test.AbstractGeneratorTest;
import org.yakindu.base.types.TypesFactory;

@SuppressWarnings("all")
public class MethodGenTest extends AbstractGeneratorTest {
  private final TypesFactory typesFactory = TypesFactory.eINSTANCE;
  
  @Test
  public void methodLayoutTest() {
    final MethodGen testMethod = this.createMethodGen();
    testMethod.setMethodName("myFunc");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("myFunc() {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String exp = _builder.toString();
    this.generatesTo(exp, testMethod);
  }
  
  @Test
  public void methodVisibilityTest() {
    final MethodGen testMethod = this.createMethodGen();
    testMethod.setMethodName("myFunc");
    testMethod.setVisibility(Visibility.PUBLIC);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public myFunc() {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String exp = _builder.toString();
  }
  
  public void createTestParameters() {
    throw new Error("Unresolved compilation problems:"
      + "\nno viable alternative at input \'}\'");
  }
}
