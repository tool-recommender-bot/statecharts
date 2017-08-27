package org.yakindu.sct.examples.wizard.search;

import java.util.List;

import org.yakindu.sct.examples.wizard.service.ExampleData;

public interface IExampleSearchService {

	void index(List<ExampleData> examples);

	List<ExampleData> search(String query);

	List<String> suggest(String query);
}
