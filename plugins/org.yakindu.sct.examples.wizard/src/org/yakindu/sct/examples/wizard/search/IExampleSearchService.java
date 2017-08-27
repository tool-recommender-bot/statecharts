/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.examples.wizard.search;

import java.util.List;

import org.yakindu.sct.examples.wizard.service.ExampleData;

/**
 * 
 * @author Thomas Kutz - Initial contribution and API
 * 
 */
public interface IExampleSearchService {

	void index(List<ExampleData> examples);

	List<ExampleData> search(String query);

	List<String> suggest(String query);
}
