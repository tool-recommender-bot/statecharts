package org.yakindu.base.generator;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.yakindu.base.generator.CodeElement;
import org.yakindu.base.generator.templates.ClassTemplate;

@SuppressWarnings("all")
public class ClassGen implements CodeElement {
  @Accessors
  protected String className;
  
  @Accessors
  protected String namespace;
  
  @Accessors
  protected String visibility;
  
  @Accessors
  protected ClassGen superClass;
  
  @Accessors
  protected List<ClassGen> interfaces;
  
  @Inject
  private ClassTemplate template;
  
  public ClassGen() {
    this.className = "";
    this.namespace = "";
    this.visibility = "";
    this.superClass = null;
    ArrayList<ClassGen> _newArrayList = CollectionLiterals.<ClassGen>newArrayList();
    this.interfaces = _newArrayList;
  }
  
  @Override
  public CharSequence generate() {
    CharSequence _generate = this.template.generate(this);
    return _generate.toString();
  }
  
  @Pure
  public String getClassName() {
    return this.className;
  }
  
  public void setClassName(final String className) {
    this.className = className;
  }
  
  @Pure
  public String getNamespace() {
    return this.namespace;
  }
  
  public void setNamespace(final String namespace) {
    this.namespace = namespace;
  }
  
  @Pure
  public String getVisibility() {
    return this.visibility;
  }
  
  public void setVisibility(final String visibility) {
    this.visibility = visibility;
  }
  
  @Pure
  public ClassGen getSuperClass() {
    return this.superClass;
  }
  
  public void setSuperClass(final ClassGen superClass) {
    this.superClass = superClass;
  }
  
  @Pure
  public List<ClassGen> getInterfaces() {
    return this.interfaces;
  }
  
  public void setInterfaces(final List<ClassGen> interfaces) {
    this.interfaces = interfaces;
  }
}
