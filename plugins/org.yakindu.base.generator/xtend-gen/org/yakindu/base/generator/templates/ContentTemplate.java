package org.yakindu.base.generator.templates;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.yakindu.base.generator.CodeElement;
import org.yakindu.base.generator.templates.Template;

@SuppressWarnings("all")
public class ContentTemplate extends Template {
  @Accessors({ AccessorType.PUBLIC_GETTER, AccessorType.PROTECTED_SETTER })
  protected List<CodeElement> content;
  
  public ContentTemplate() {
    ArrayList<CodeElement> _newArrayList = CollectionLiterals.<CodeElement>newArrayList();
    this.content = _newArrayList;
  }
  
  public boolean addContent(final CodeElement ce) {
    return this.content.add(ce);
  }
  
  protected String generateContent() {
    String _xblockexpression = null;
    {
      final StringBuilder sb = new StringBuilder();
      boolean first = true;
      for (final CodeElement ce : this.content) {
        if (first) {
          first = false;
          CharSequence _generate = ce.generate();
          sb.append(_generate);
        } else {
          sb.append("\n");
          CharSequence _generate_1 = ce.generate();
          sb.append(_generate_1);
        }
      }
      _xblockexpression = sb.toString();
    }
    return _xblockexpression;
  }
  
  @Pure
  public List<CodeElement> getContent() {
    return this.content;
  }
  
  protected void setContent(final List<CodeElement> content) {
    this.content = content;
  }
}
