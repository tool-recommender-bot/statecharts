package org.yakindu.base.generator.templates;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.yakindu.base.generator.ClassGen;
import org.yakindu.base.generator.templates.ContentTemplate;

@SuppressWarnings("all")
public class ClassTemplate extends ContentTemplate {
  public CharSequence generate(final ClassGen it) {
    StringConcatenation _builder = new StringConcatenation();
    String _generateVisibility = this.generateVisibility(it);
    _builder.append(_generateVisibility, "");
    _builder.append("class ");
    String _className = it.getClassName();
    _builder.append(_className, "");
    _builder.append(" ");
    CharSequence _generateExtends = this.generateExtends(it);
    _builder.append(_generateExtends, "");
    String _generateImplements = this.generateImplements(it);
    _builder.append(_generateImplements, "");
    _builder.append("{");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _generateContent = this.generateContent();
    _builder.append(_generateContent, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public String generateImplements(final ClassGen it) {
    String _xblockexpression = null;
    {
      String ret = "";
      String _xifexpression = null;
      List<ClassGen> _interfaces = it.getInterfaces();
      boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(_interfaces);
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        String _xblockexpression_1 = null;
        {
          ret = "implements ";
          boolean first = true;
          List<ClassGen> _interfaces_1 = it.getInterfaces();
          for (final ClassGen i : _interfaces_1) {
            if (first) {
              first = false;
              String _ret = ret;
              String _className = i.getClassName();
              ret = (_ret + _className);
            } else {
              String _ret_1 = ret;
              String _className_1 = i.getClassName();
              String _plus = (", " + _className_1);
              ret = (_ret_1 + _plus);
            }
          }
          String _ret_2 = ret;
          _xblockexpression_1 = ret = (_ret_2 + " ");
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public String generateVisibility(final ClassGen it) {
    String _xblockexpression = null;
    {
      String _visibility = it.getVisibility();
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_visibility);
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        String _visibility_1 = it.getVisibility();
        return (_visibility_1 + " ");
      }
      _xblockexpression = "";
    }
    return _xblockexpression;
  }
  
  public CharSequence generateExtends(final ClassGen it) {
    CharSequence _xifexpression = null;
    ClassGen _superClass = it.getSuperClass();
    boolean _equals = Objects.equal(_superClass, null);
    if (_equals) {
      _xifexpression = "";
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("extends ");
      ClassGen _superClass_1 = it.getSuperClass();
      String _className = _superClass_1.getClassName();
      _builder.append(_className, "");
      _builder.append(" ");
      _xifexpression = _builder;
    }
    return _xifexpression;
  }
}
