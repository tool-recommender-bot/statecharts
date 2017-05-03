package org.yakindu.base.generator.attributes;

import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.yakindu.base.generator.ClassGen;
import org.yakindu.base.generator.Visibility;
import org.yakindu.base.generator.attributes.Attributes;

@SuppressWarnings("all")
public class ClassAttributes extends Attributes {
  @Accessors
  protected String className;
  
  @Accessors
  protected String namespace;
  
  @Accessors
  protected Visibility visibility;
  
  @Accessors
  protected ClassGen superClass;
  
  @Accessors
  protected List<ClassGen> interfaces;
  
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
  public Visibility getVisibility() {
    return this.visibility;
  }
  
  public void setVisibility(final Visibility visibility) {
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
