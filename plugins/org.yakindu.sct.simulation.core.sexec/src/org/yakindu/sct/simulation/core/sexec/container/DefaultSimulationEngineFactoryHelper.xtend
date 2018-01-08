package org.yakindu.sct.simulation.core.sexec.container

import org.yakindu.base.types.Declaration
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.stext.ImportScope

class DefaultSimulationEngineFactoryHelper {

	def getStatechartImports(Statechart it){
		scopes.filter(ImportScope).map[imports].flatten.filter[it.endsWith("sct")]
	}
	
}