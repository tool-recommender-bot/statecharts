package org.yakindu.sct.model.stext.resource;

import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
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
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.Declaration;
import org.yakindu.base.types.EnumerationType;
import org.yakindu.base.types.Enumerator;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.PackageMember;
import org.yakindu.base.types.Parameter;
import org.yakindu.base.types.Property;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypeSpecifier;
import org.yakindu.base.types.TypesFactory;
import org.yakindu.base.types.typesystem.GenericTypeSystem;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.model.sgraph.RegularState;
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
    final Procedure1<org.yakindu.base.types.Package> _function = (org.yakindu.base.types.Package package_) -> {
      package_.setName(TypeResourceDescriptionStrategy.computePackageName(WorkspaceSynchronizer.getFile(sc.eResource())));
      EList<PackageMember> _member = package_.getMember();
      EnumerationType _createEnumerationType = this.factory.createEnumerationType();
      final Procedure1<EnumerationType> _function_1 = (EnumerationType it) -> {
        it.setName("States");
        final Procedure1<RegularState> _function_2 = (RegularState state) -> {
          EList<Enumerator> _enumerator = it.getEnumerator();
          Enumerator _createEnumerator = this.factory.createEnumerator();
          final Procedure1<Enumerator> _function_3 = (Enumerator it_1) -> {
            it_1.setName(state.getName());
          };
          Enumerator _doubleArrow = ObjectExtensions.<Enumerator>operator_doubleArrow(_createEnumerator, _function_3);
          _enumerator.add(_doubleArrow);
        };
        IteratorExtensions.<RegularState>forEach(Iterators.<RegularState>filter(sc.eAllContents(), RegularState.class), _function_2);
      };
      EnumerationType _doubleArrow = ObjectExtensions.<EnumerationType>operator_doubleArrow(_createEnumerationType, _function_1);
      _member.add(_doubleArrow);
      EList<PackageMember> _member_1 = package_.getMember();
      ComplexType _createComplexType = this.factory.createComplexType();
      final Procedure1<ComplexType> _function_2 = (ComplexType scType) -> {
        scType.setName(sc.getName());
        EList<Type> _superTypes = scType.getSuperTypes();
        ComplexType _createStatemachineType = this.createStatemachineType();
        _superTypes.add(_createStatemachineType);
        final Function1<InterfaceScope, Boolean> _function_3 = (InterfaceScope it) -> {
          String _name = it.getName();
          return Boolean.valueOf((_name != null));
        };
        final Consumer<InterfaceScope> _function_4 = (InterfaceScope iface) -> {
          EList<Declaration> _features = scType.getFeatures();
          Property _createProperty = this.factory.createProperty();
          final Procedure1<Property> _function_5 = (Property prop) -> {
            prop.setName(iface.getName());
            TypeSpecifier _createTypeSpecifier = this.factory.createTypeSpecifier();
            final Procedure1<TypeSpecifier> _function_6 = (TypeSpecifier it) -> {
              ComplexType _createComplexType_1 = this.factory.createComplexType();
              final Procedure1<ComplexType> _function_7 = (ComplexType it_1) -> {
                it_1.setName(iface.getName());
                final Consumer<Declaration> _function_8 = (Declaration decl) -> {
                  EList<Declaration> _features_1 = it_1.getFeatures();
                  Declaration _copy = EcoreUtil.<Declaration>copy(decl);
                  _features_1.add(_copy);
                };
                iface.getDeclarations().forEach(_function_8);
              };
              ComplexType _doubleArrow_1 = ObjectExtensions.<ComplexType>operator_doubleArrow(_createComplexType_1, _function_7);
              it.setType(_doubleArrow_1);
            };
            TypeSpecifier _doubleArrow_1 = ObjectExtensions.<TypeSpecifier>operator_doubleArrow(_createTypeSpecifier, _function_6);
            prop.setTypeSpecifier(_doubleArrow_1);
          };
          Property _doubleArrow_1 = ObjectExtensions.<Property>operator_doubleArrow(_createProperty, _function_5);
          _features.add(_doubleArrow_1);
        };
        IterableExtensions.<InterfaceScope>filter(Iterables.<InterfaceScope>filter(sc.getScopes(), InterfaceScope.class), _function_3).forEach(_function_4);
        final Function1<InterfaceScope, Boolean> _function_5 = (InterfaceScope it) -> {
          String _name = it.getName();
          return Boolean.valueOf((_name == null));
        };
        final Consumer<InterfaceScope> _function_6 = (InterfaceScope iface) -> {
          final Consumer<Declaration> _function_7 = (Declaration decl) -> {
            EList<Declaration> _features = scType.getFeatures();
            Declaration _copy = EcoreUtil.<Declaration>copy(decl);
            _features.add(_copy);
          };
          iface.getDeclarations().forEach(_function_7);
        };
        IterableExtensions.<InterfaceScope>filter(Iterables.<InterfaceScope>filter(sc.getScopes(), InterfaceScope.class), _function_5).forEach(_function_6);
        EList<Declaration> _features = scType.getFeatures();
        Operation _createOperation = this.factory.createOperation();
        final Procedure1<Operation> _function_7 = (Operation it) -> {
          it.setName("isStateActive");
          EList<Parameter> _parameters = it.getParameters();
          Parameter _createParameter = this.factory.createParameter();
          final Procedure1<Parameter> _function_8 = (Parameter it_1) -> {
            it_1.setName("state");
            TypeSpecifier _createTypeSpecifier = this.factory.createTypeSpecifier();
            final Procedure1<TypeSpecifier> _function_9 = (TypeSpecifier it_2) -> {
              PackageMember _head = IterableExtensions.<PackageMember>head(package_.getMember());
              it_2.setType(((Type) _head));
            };
            TypeSpecifier _doubleArrow_1 = ObjectExtensions.<TypeSpecifier>operator_doubleArrow(_createTypeSpecifier, _function_9);
            it_1.setTypeSpecifier(_doubleArrow_1);
          };
          Parameter _doubleArrow_1 = ObjectExtensions.<Parameter>operator_doubleArrow(_createParameter, _function_8);
          _parameters.add(_doubleArrow_1);
          TypeSpecifier _createTypeSpecifier = this.factory.createTypeSpecifier();
          final Procedure1<TypeSpecifier> _function_9 = (TypeSpecifier it_1) -> {
            it_1.setType(this.ts.getType(ITypeSystem.BOOLEAN));
          };
          TypeSpecifier _doubleArrow_2 = ObjectExtensions.<TypeSpecifier>operator_doubleArrow(_createTypeSpecifier, _function_9);
          it.setTypeSpecifier(_doubleArrow_2);
        };
        Operation _doubleArrow_1 = ObjectExtensions.<Operation>operator_doubleArrow(_createOperation, _function_7);
        _features.add(_doubleArrow_1);
      };
      ComplexType _doubleArrow_1 = ObjectExtensions.<ComplexType>operator_doubleArrow(_createComplexType, _function_2);
      _member_1.add(_doubleArrow_1);
    };
    return ObjectExtensions.<org.yakindu.base.types.Package>operator_doubleArrow(_createPackage, _function);
  }
  
  public ComplexType createStatemachineType() {
    ComplexType _createComplexType = this.factory.createComplexType();
    final Procedure1<ComplexType> _function = (ComplexType it) -> {
      it.setName("Statemachine");
      EList<Declaration> _features = it.getFeatures();
      Operation _createOperation = this.factory.createOperation();
      final Procedure1<Operation> _function_1 = (Operation it_1) -> {
        it_1.setName("init");
        TypeSpecifier _createTypeSpecifier = this.factory.createTypeSpecifier();
        final Procedure1<TypeSpecifier> _function_2 = (TypeSpecifier it_2) -> {
          it_2.setType(this.ts.getType(ITypeSystem.VOID));
        };
        TypeSpecifier _doubleArrow = ObjectExtensions.<TypeSpecifier>operator_doubleArrow(_createTypeSpecifier, _function_2);
        it_1.setTypeSpecifier(_doubleArrow);
      };
      Operation _doubleArrow = ObjectExtensions.<Operation>operator_doubleArrow(_createOperation, _function_1);
      _features.add(_doubleArrow);
      EList<Declaration> _features_1 = it.getFeatures();
      Operation _createOperation_1 = this.factory.createOperation();
      final Procedure1<Operation> _function_2 = (Operation it_1) -> {
        it_1.setName("enter");
        TypeSpecifier _createTypeSpecifier = this.factory.createTypeSpecifier();
        final Procedure1<TypeSpecifier> _function_3 = (TypeSpecifier it_2) -> {
          it_2.setType(this.ts.getType(ITypeSystem.VOID));
        };
        TypeSpecifier _doubleArrow_1 = ObjectExtensions.<TypeSpecifier>operator_doubleArrow(_createTypeSpecifier, _function_3);
        it_1.setTypeSpecifier(_doubleArrow_1);
      };
      Operation _doubleArrow_1 = ObjectExtensions.<Operation>operator_doubleArrow(_createOperation_1, _function_2);
      _features_1.add(_doubleArrow_1);
      EList<Declaration> _features_2 = it.getFeatures();
      Operation _createOperation_2 = this.factory.createOperation();
      final Procedure1<Operation> _function_3 = (Operation it_1) -> {
        it_1.setName("exit");
        TypeSpecifier _createTypeSpecifier = this.factory.createTypeSpecifier();
        final Procedure1<TypeSpecifier> _function_4 = (TypeSpecifier it_2) -> {
          it_2.setType(this.ts.getType(ITypeSystem.VOID));
        };
        TypeSpecifier _doubleArrow_2 = ObjectExtensions.<TypeSpecifier>operator_doubleArrow(_createTypeSpecifier, _function_4);
        it_1.setTypeSpecifier(_doubleArrow_2);
      };
      Operation _doubleArrow_2 = ObjectExtensions.<Operation>operator_doubleArrow(_createOperation_2, _function_3);
      _features_2.add(_doubleArrow_2);
      EList<Declaration> _features_3 = it.getFeatures();
      Operation _createOperation_3 = this.factory.createOperation();
      final Procedure1<Operation> _function_4 = (Operation it_1) -> {
        it_1.setName("isActive");
        TypeSpecifier _createTypeSpecifier = this.factory.createTypeSpecifier();
        final Procedure1<TypeSpecifier> _function_5 = (TypeSpecifier it_2) -> {
          it_2.setType(this.ts.getType(ITypeSystem.BOOLEAN));
        };
        TypeSpecifier _doubleArrow_3 = ObjectExtensions.<TypeSpecifier>operator_doubleArrow(_createTypeSpecifier, _function_5);
        it_1.setTypeSpecifier(_doubleArrow_3);
      };
      Operation _doubleArrow_3 = ObjectExtensions.<Operation>operator_doubleArrow(_createOperation_3, _function_4);
      _features_3.add(_doubleArrow_3);
      EList<Declaration> _features_4 = it.getFeatures();
      Operation _createOperation_4 = this.factory.createOperation();
      final Procedure1<Operation> _function_5 = (Operation it_1) -> {
        it_1.setName("isFinal");
        TypeSpecifier _createTypeSpecifier = this.factory.createTypeSpecifier();
        final Procedure1<TypeSpecifier> _function_6 = (TypeSpecifier it_2) -> {
          it_2.setType(this.ts.getType(ITypeSystem.BOOLEAN));
        };
        TypeSpecifier _doubleArrow_4 = ObjectExtensions.<TypeSpecifier>operator_doubleArrow(_createTypeSpecifier, _function_6);
        it_1.setTypeSpecifier(_doubleArrow_4);
      };
      Operation _doubleArrow_4 = ObjectExtensions.<Operation>operator_doubleArrow(_createOperation_4, _function_5);
      _features_4.add(_doubleArrow_4);
      EList<Declaration> _features_5 = it.getFeatures();
      Operation _createOperation_5 = this.factory.createOperation();
      final Procedure1<Operation> _function_6 = (Operation it_1) -> {
        it_1.setName("runCycle");
        TypeSpecifier _createTypeSpecifier = this.factory.createTypeSpecifier();
        final Procedure1<TypeSpecifier> _function_7 = (TypeSpecifier it_2) -> {
          it_2.setType(this.ts.getType(ITypeSystem.BOOLEAN));
        };
        TypeSpecifier _doubleArrow_5 = ObjectExtensions.<TypeSpecifier>operator_doubleArrow(_createTypeSpecifier, _function_7);
        it_1.setTypeSpecifier(_doubleArrow_5);
      };
      Operation _doubleArrow_5 = ObjectExtensions.<Operation>operator_doubleArrow(_createOperation_5, _function_6);
      _features_5.add(_doubleArrow_5);
    };
    return ObjectExtensions.<ComplexType>operator_doubleArrow(_createComplexType, _function);
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
