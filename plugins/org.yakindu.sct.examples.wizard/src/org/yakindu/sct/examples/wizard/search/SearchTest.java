package org.yakindu.sct.examples.wizard.search;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.apache.lucene.store.Directory;
import org.junit.Test;

public class SearchTest {

	private final String EXAMPLE_REPO = "/Users/kutz/sct_examples";
	
	@Test
	public void testIndex() {
		Indexer indexer = new Indexer();
		try {
			indexer.index(EXAMPLE_REPO, EXAMPLE_REPO+"/.index");
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testSearch() {
		Indexer indexer = new Indexer();
		Searcher searcher = new Searcher();
		try {
			Directory index = indexer.index(EXAMPLE_REPO, EXAMPLE_REPO+"/.index");
			searcher.search(index, "java");
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}
}
