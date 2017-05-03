package org.yakindu.base.generator

import org.eclipse.xtend.lib.annotations.Data
import org.yakindu.base.types.TypeSpecifier

@Data class Parameter extends CodeElement {
	TypeSpecifier parameterType
	String parameterName
}