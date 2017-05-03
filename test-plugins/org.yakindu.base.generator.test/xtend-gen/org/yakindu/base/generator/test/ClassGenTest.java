package org.yakindu.base.generator.test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.yakindu.base.generator.ClassGen;
import org.yakindu.base.generator.Visibility;

@SuppressWarnings("all")
public class ClassGenTest {
  private ClassGen testclass;
  
  @Before
  public void setUp() {
    final Injector injector = Guice.createInjector(new AbstractModule() {
      @Override
      public void configure() {
        this.<ClassGen>bind(ClassGen.class);
      }
    });
    ClassGen _instance = injector.<ClassGen>getInstance(ClassGen.class);
    this.testclass = _instance;
  }
  
  @Test
  public void testSimpleClassLayout() {
    this.testclass.setClassName("testClass");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class testClass {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String exp = _builder.toString();
    CharSequence _generate = this.testclass.generate();
    Assert.assertEquals(exp, _generate);
  }
  
  @Test
  public void testVisibility() {
    this.testclass.setClassName("PrivateClass");
    this.testclass.setVisibility(Visibility.PRIVATE);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private class PrivateClass {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String exp = _builder.toString();
    CharSequence _generate = this.testclass.generate();
    Assert.assertEquals(exp, _generate);
  }
}
