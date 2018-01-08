package org.yakindu.sct.model.stext.resource;

import com.google.common.collect.Iterables;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.Declaration;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.PackageMember;
import org.yakindu.base.types.Property;
import org.yakindu.base.types.TypeSpecifier;
import org.yakindu.base.types.TypesFactory;
import org.yakindu.base.types.typesystem.GenericTypeSystem;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.stext.InterfaceScope;

@SuppressWarnings("all")
public class TypeResourceDescriptionStrategy extends DefaultResourceDescriptionStrategy {
  @Extension
  private TypesFactory factory = TypesFactory.eINSTANCE;
  
  @Extension
  private ITypeSystem ts = GenericTypeSystem.getInstance();
  
  @Override
  public boolean createEObjectDescriptions(final EObject eObject, final IAcceptor<IEObjectDescription> acceptor) {
    if ((eObject instanceof Statechart)) {
      final org.yakindu.base.types.Package pack = this.createTypeDescription(((Statechart) eObject));
      final Consumer<PackageMember> _function = (PackageMember it) -> {
        acceptor.accept(EObjectDescription.create(it.getName(), it));
      };
      pack.getMember().forEach(_function);
      return false;
    }
    return false;
  }
  
  protected org.yakindu.base.types.Package createTypeDescription(final Statechart sc) {
    org.yakindu.base.types.Package _createPackage = this.factory.createPackage();
    final Procedure1<org.yakindu.base.types.Package> _function = (org.yakindu.base.types.Package it) -> {
      it.setName(TypeResourceDescriptionStrategy.computePackageName(WorkspaceSynchronizer.getFile(sc.eResource())));
      EList<PackageMember> _member = it.getMember();
      ComplexType _createComplexType = this.factory.createComplexType();
      final Procedure1<ComplexType> _function_1 = (ComplexType scType) -> {
        scType.setName(sc.getName());
        final Function1<InterfaceScope, Boolean> _function_2 = (InterfaceScope it_1) -> {
          String _name = it_1.getName();
          return Boolean.valueOf((_name != null));
        };
        final Consumer<InterfaceScope> _function_3 = (InterfaceScope iface) -> {
          EList<Declaration> _features = scType.getFeatures();
          Property _createProperty = this.factory.createProperty();
          final Procedure1<Property> _function_4 = (Property prop) -> {
            prop.setName(iface.getName());
            TypeSpecifier _createTypeSpecifier = this.factory.createTypeSpecifier();
            final Procedure1<TypeSpecifier> _function_5 = (TypeSpecifier it_1) -> {
              ComplexType _createComplexType_1 = this.factory.createComplexType();
              final Procedure1<ComplexType> _function_6 = (ComplexType it_2) -> {
                it_2.setName(iface.getName());
                final Consumer<Declaration> _function_7 = (Declaration decl) -> {
                  EList<Declaration> _features_1 = it_2.getFeatures();
                  Declaration _copy = EcoreUtil.<Declaration>copy(decl);
                  _features_1.add(_copy);
                };
                iface.getDeclarations().forEach(_function_7);
              };
              ComplexType _doubleArrow = ObjectExtensions.<ComplexType>operator_doubleArrow(_createComplexType_1, _function_6);
              it_1.setType(_doubleArrow);
            };
            TypeSpecifier _doubleArrow = ObjectExtensions.<TypeSpecifier>operator_doubleArrow(_createTypeSpecifier, _function_5);
            prop.setTypeSpecifier(_doubleArrow);
          };
          Property _doubleArrow = ObjectExtensions.<Property>operator_doubleArrow(_createProperty, _function_4);
          _features.add(_doubleArrow);
        };
        IterableExtensions.<InterfaceScope>filter(Iterables.<InterfaceScope>filter(sc.getScopes(), InterfaceScope.class), _function_2).forEach(_function_3);
        final Function1<InterfaceScope, Boolean> _function_4 = (InterfaceScope it_1) -> {
          String _name = it_1.getName();
          return Boolean.valueOf((_name == null));
        };
        final Consumer<InterfaceScope> _function_5 = (InterfaceScope iface) -> {
          final Consumer<Declaration> _function_6 = (Declaration decl) -> {
            EList<Declaration> _features = scType.getFeatures();
            Declaration _copy = EcoreUtil.<Declaration>copy(decl);
            _features.add(_copy);
          };
          iface.getDeclarations().forEach(_function_6);
        };
        IterableExtensions.<InterfaceScope>filter(Iterables.<InterfaceScope>filter(sc.getScopes(), InterfaceScope.class), _function_4).forEach(_function_5);
        EList<Declaration> _features = scType.getFeatures();
        Operation _createOperation = this.factory.createOperation();
        final Procedure1<Operation> _function_6 = (Operation it_1) -> {
          it_1.setName("init");
          TypeSpecifier _createTypeSpecifier = this.factory.createTypeSpecifier();
          final Procedure1<TypeSpecifier> _function_7 = (TypeSpecifier it_2) -> {
            it_2.setType(this.ts.getType(ITypeSystem.VOID));
          };
          TypeSpecifier _doubleArrow = ObjectExtensions.<TypeSpecifier>operator_doubleArrow(_createTypeSpecifier, _function_7);
          it_1.setTypeSpecifier(_doubleArrow);
        };
        Operation _doubleArrow = ObjectExtensions.<Operation>operator_doubleArrow(_createOperation, _function_6);
        _features.add(_doubleArrow);
        EList<Declaration> _features_1 = scType.getFeatures();
        Operation _createOperation_1 = this.factory.createOperation();
        final Procedure1<Operation> _function_7 = (Operation it_1) -> {
          it_1.setName("enter");
          TypeSpecifier _createTypeSpecifier = this.factory.createTypeSpecifier();
          final Procedure1<TypeSpecifier> _function_8 = (TypeSpecifier it_2) -> {
            it_2.setType(this.ts.getType(ITypeSystem.VOID));
          };
          TypeSpecifier _doubleArrow_1 = ObjectExtensions.<TypeSpecifier>operator_doubleArrow(_createTypeSpecifier, _function_8);
          it_1.setTypeSpecifier(_doubleArrow_1);
        };
        Operation _doubleArrow_1 = ObjectExtensions.<Operation>operator_doubleArrow(_createOperation_1, _function_7);
        _features_1.add(_doubleArrow_1);
        EList<Declaration> _features_2 = scType.getFeatures();
        Operation _createOperation_2 = this.factory.createOperation();
        final Procedure1<Operation> _function_8 = (Operation it_1) -> {
          it_1.setName("exit");
          TypeSpecifier _createTypeSpecifier = this.factory.createTypeSpecifier();
          final Procedure1<TypeSpecifier> _function_9 = (TypeSpecifier it_2) -> {
            it_2.setType(this.ts.getType(ITypeSystem.VOID));
          };
          TypeSpecifier _doubleArrow_2 = ObjectExtensions.<TypeSpecifier>operator_doubleArrow(_createTypeSpecifier, _function_9);
          it_1.setTypeSpecifier(_doubleArrow_2);
        };
        Operation _doubleArrow_2 = ObjectExtensions.<Operation>operator_doubleArrow(_createOperation_2, _function_8);
        _features_2.add(_doubleArrow_2);
        EList<Declaration> _features_3 = scType.getFeatures();
        Operation _createOperation_3 = this.factory.createOperation();
        final Procedure1<Operation> _function_9 = (Operation it_1) -> {
          it_1.setName("isActive");
          TypeSpecifier _createTypeSpecifier = this.factory.createTypeSpecifier();
          final Procedure1<TypeSpecifier> _function_10 = (TypeSpecifier it_2) -> {
            it_2.setType(this.ts.getType(ITypeSystem.BOOLEAN));
          };
          TypeSpecifier _doubleArrow_3 = ObjectExtensions.<TypeSpecifier>operator_doubleArrow(_createTypeSpecifier, _function_10);
          it_1.setTypeSpecifier(_doubleArrow_3);
        };
        Operation _doubleArrow_3 = ObjectExtensions.<Operation>operator_doubleArrow(_createOperation_3, _function_9);
        _features_3.add(_doubleArrow_3);
        EList<Declaration> _features_4 = scType.getFeatures();
        Operation _createOperation_4 = this.factory.createOperation();
        final Procedure1<Operation> _function_10 = (Operation it_1) -> {
          it_1.setName("isFinal");
          TypeSpecifier _createTypeSpecifier = this.factory.createTypeSpecifier();
          final Procedure1<TypeSpecifier> _function_11 = (TypeSpecifier it_2) -> {
            it_2.setType(this.ts.getType(ITypeSystem.BOOLEAN));
          };
          TypeSpecifier _doubleArrow_4 = ObjectExtensions.<TypeSpecifier>operator_doubleArrow(_createTypeSpecifier, _function_11);
          it_1.setTypeSpecifier(_doubleArrow_4);
        };
        Operation _doubleArrow_4 = ObjectExtensions.<Operation>operator_doubleArrow(_createOperation_4, _function_10);
        _features_4.add(_doubleArrow_4);
        EList<Declaration> _features_5 = scType.getFeatures();
        Operation _createOperation_5 = this.factory.createOperation();
        final Procedure1<Operation> _function_11 = (Operation it_1) -> {
          it_1.setName("runCycle");
          TypeSpecifier _createTypeSpecifier = this.factory.createTypeSpecifier();
          final Procedure1<TypeSpecifier> _function_12 = (TypeSpecifier it_2) -> {
            it_2.setType(this.ts.getType(ITypeSystem.BOOLEAN));
          };
          TypeSpecifier _doubleArrow_5 = ObjectExtensions.<TypeSpecifier>operator_doubleArrow(_createTypeSpecifier, _function_12);
          it_1.setTypeSpecifier(_doubleArrow_5);
        };
        Operation _doubleArrow_5 = ObjectExtensions.<Operation>operator_doubleArrow(_createOperation_5, _function_11);
        _features_5.add(_doubleArrow_5);
      };
      ComplexType _doubleArrow = ObjectExtensions.<ComplexType>operator_doubleArrow(_createComplexType, _function_1);
      _member.add(_doubleArrow);
    };
    return ObjectExtensions.<org.yakindu.base.types.Package>operator_doubleArrow(_createPackage, _function);
  }
  
  public static String computePackageName(final IFile headerFile) {
    String _xblockexpression = null;
    {
      final IPath pathToHeader = headerFile.getProjectRelativePath().removeFileExtension();
      final Function1<String, String> _function = (String it) -> {
        return it;
      };
      final String result = QualifiedName.create(ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(pathToHeader.segments())), _function)).toString();
      InputOutput.<String>println(result);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
}
