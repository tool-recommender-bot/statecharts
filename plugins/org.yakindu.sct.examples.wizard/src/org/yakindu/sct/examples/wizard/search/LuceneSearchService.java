package org.yakindu.sct.examples.wizard.search;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.lucene.store.Directory;
import org.yakindu.sct.examples.wizard.ExampleActivator;
import org.yakindu.sct.examples.wizard.preferences.ExamplesPreferenceConstants;
import org.yakindu.sct.examples.wizard.search.ExampleSearcher.SearchResult;
import org.yakindu.sct.examples.wizard.service.ExampleData;

import com.google.inject.Inject;

public class LuceneSearchService implements IExampleSearchService {

	@Inject
	protected ExampleIndexer indexer;

	@Inject
	protected ExampleSearcher searcher;
	
	@Inject
	protected Suggester suggester;

	private Directory index;

	private List<ExampleData> indexedExamples;
	
	@Override
	public void index(List<ExampleData> examples) {
		if (examples == null) {
			throw new IllegalArgumentException("Cannot build index for null argument.");
		}
		try {
			indexedExamples = examples;
			index = indexer.index(examples, getIndexLocation());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ExampleData> search(String query) {
		ensureIndexExists();
		if (query.isEmpty()) {
			return Collections.emptyList();
		}
		try {
			Collection<SearchResult> results = searcher.search(index, query);
			return mapToExampleData(results);
		} catch (IOException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	@Override
	public List<String> suggest(String query) {
		ensureIndexExists();
		if (query.isEmpty()) {
			return Collections.emptyList();
		}
		try {
			return suggester.suggest(index, query);
		} catch (IOException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	protected void ensureIndexExists() {
		if (index == null) {
			throw new IllegalStateException("Index must be created before.");
		}
	}

	protected List<ExampleData> mapToExampleData(Collection<SearchResult> results) {
		return results.stream().map(res -> {
			ExampleData e = exampleDataFor(res).get();
			addHighlighting(e, res);
			return e;
		}).collect(Collectors.toList());
	}

	protected Optional<ExampleData> exampleDataFor(SearchResult result) {
		return indexedExamples.stream().filter(e -> e.getId().equals(result.getExampleId())).findFirst();
	}

	protected Path getIndexLocation() {
		return Paths.get(ExampleActivator.getDefault().getPreferenceStore()
				.getString(ExamplesPreferenceConstants.STORAGE_LOCATION) + "/.index");
	}

	protected void addHighlighting(ExampleData example, SearchResult searchResult) {
		String highlightedContents = searchResult.getHighlightedText();
		Path highlightedHtml = getHighlightedIndexHtml(example);
		FileUtil.writeFile(highlightedHtml, highlightedContents);
		example.setDetailsUrl(highlightedHtml.toString());
	}

	protected Path getHighlightedIndexHtml(ExampleData example) {
		return Paths.get(example.getProjectDir().getAbsolutePath() + File.separator + ".index_highlighted.html");
	}

}
