package org.yakindu.sct.examples.wizard.search;

import static org.junit.Assert.*;

import java.io.IOException;

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
}
