package org.yakindu.sct.generator.pax.types;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.xtext.xbase.lib.Extension;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypeSpecifier;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess;

@SuppressWarnings("all")
public class PaxTypeSystemAccess implements ICodegenTypeSystemAccess {
  @Inject
  @Extension
  private ITypeSystem _iTypeSystem;
  
  @Override
  public String getTargetLanguageName(final Type type) {
    String _xblockexpression = null;
    {
      Type _originType = null;
      if (type!=null) {
        _originType=type.getOriginType();
      }
      final Type originalType = _originType;
      String _switchResult = null;
      boolean _matched = false;
      if ((Objects.equal(originalType, null) || this._iTypeSystem.isSame(originalType, this._iTypeSystem.getType(ITypeSystem.VOID)))) {
        _matched=true;
        _switchResult = "void";
      }
      if (!_matched) {
        boolean _isSame = this._iTypeSystem.isSame(originalType, this._iTypeSystem.getType(ITypeSystem.INTEGER));
        if (_isSame) {
          _matched=true;
          _switchResult = "sc_integer";
        }
      }
      if (!_matched) {
        boolean _isSame_1 = this._iTypeSystem.isSame(originalType, this._iTypeSystem.getType(ITypeSystem.REAL));
        if (_isSame_1) {
          _matched=true;
          _switchResult = "sc_real";
        }
      }
      if (!_matched) {
        boolean _isSame_2 = this._iTypeSystem.isSame(originalType, this._iTypeSystem.getType(ITypeSystem.BOOLEAN));
        if (_isSame_2) {
          _matched=true;
          _switchResult = "sc_boolean";
        }
      }
      if (!_matched) {
        boolean _isSame_3 = this._iTypeSystem.isSame(originalType, this._iTypeSystem.getType(ITypeSystem.STRING));
        if (_isSame_3) {
          _matched=true;
          _switchResult = "sc_string";
        }
      }
      if (!_matched) {
        throw new IllegalArgumentException(("Target language name could not be inferred for type " + type));
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  @Override
  public String getTargetLanguageName(final TypeSpecifier typeSpecifier) {
    Type _type = null;
    if (typeSpecifier!=null) {
      _type=typeSpecifier.getType();
    }
    return this.getTargetLanguageName(_type);
  }
}
