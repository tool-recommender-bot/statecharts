package org.yakindu.sct.generator.pax

import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.base.base.NamedElement
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sexec.ExecutionFlow

class PaxNamingService implements INamingService{
	
	override asEscapedIdentifier(String string) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override asIdentifier(String string) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getMaxLength() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getSeparator() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getShortName(NamedElement element) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getShortNameMap(Statechart statechart) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getShortNameMap(ExecutionFlow flow) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override initializeNamingService(Statechart statechart) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override initializeNamingService(ExecutionFlow flow) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override isKeyword(String string) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override setMaxLength(int length) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override setSeparator(char sep) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}