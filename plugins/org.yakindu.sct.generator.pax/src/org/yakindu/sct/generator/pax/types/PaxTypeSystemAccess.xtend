package org.yakindu.sct.generator.pax.types

import com.google.inject.Inject
import org.yakindu.base.types.Type
import org.yakindu.base.types.TypeSpecifier
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess

import static org.yakindu.base.types.typesystem.ITypeSystem.*

class PaxTypeSystemAccess  implements ICodegenTypeSystemAccess{
	
	@Inject
	extension ITypeSystem

	override getTargetLanguageName(Type type) {
		val originalType = type?.originType
		switch (originalType) {
			case originalType == null || isSame(originalType, getType(VOID)) : 'void'
			case isSame(originalType, getType(INTEGER)): 'sc_integer'
			case isSame(originalType, getType(REAL)): 'sc_real'
			case isSame(originalType, getType(BOOLEAN)): 'sc_boolean'
			case isSame(originalType, getType(STRING)): 'sc_string'
			default: throw new IllegalArgumentException("Target language name could not be inferred for type " + type)
		}
	}
	
	override getTargetLanguageName(TypeSpecifier typeSpecifier) {
		return getTargetLanguageName(typeSpecifier?.type)
	}
	
}