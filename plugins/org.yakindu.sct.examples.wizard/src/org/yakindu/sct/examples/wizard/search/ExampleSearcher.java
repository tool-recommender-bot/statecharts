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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.NullFragmenter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.TokenSources;
import org.apache.lucene.store.Directory;
import org.apache.lucene.util.Version;

/**
 * 
 * @author Thomas Kutz - Initial contribution and API
 * 
 */
public class ExampleSearcher {

	private static final String CSS_CLASS_HIGHLIGHT = "highlight";

	public static class SearchResult {
		private String exampleId;
		private String highlightedText;

		public SearchResult(String exampleId, String highlightedText) {
			this.exampleId = exampleId;
			this.highlightedText = highlightedText;
		}
		public String getExampleId() {
			return exampleId;
		}
		public String getHighlightedText() {
			return highlightedText;
		}
	}

	public Collection<SearchResult> search(Directory index, String input) throws IOException {
		IndexReader reader = getDirectoryReader(index);
		IndexSearcher is = getIndexSearcher(reader);

		Query query = createQuery(input);
		if (query == null) {
			return Collections.emptyList();
		}

		List<SearchResult> results = new ArrayList<SearchResult>();
		TopDocs hits = is.search(query, Integer.MAX_VALUE);
		for (int i = 0; i < hits.scoreDocs.length; i++) {
			int docId = hits.scoreDocs[i].doc;
			Document d = is.doc(docId);
			String highlightedContents = getHighlightedContents(query, d);
			SearchResult result = new SearchResult(d.get(ExampleIndexer.FIELD_ID), highlightedContents);
			results.add(result);
		}
		return results;
	}

	protected String getHighlightedContents(Query query, Document d) throws IOException {
		Highlighter highlighter = getHighlighter(query);
		String contents = d.get(ExampleIndexer.FIELD_SOURCE);
		TokenStream stream = TokenSources.getTokenStream(ExampleIndexer.FIELD_SOURCE, contents,
				new StandardAnalyzer(Version.LUCENE_46));
		try {
			return highlighter.getBestFragment(stream, contents);
		} catch (InvalidTokenOffsetsException e) {
			e.printStackTrace();
			return "";
		}
	}

	protected IndexSearcher getIndexSearcher(IndexReader reader) {
		return new IndexSearcher(reader);
	}

	protected DirectoryReader getDirectoryReader(Directory index) throws IOException {
		return DirectoryReader.open(index);
	}

	protected Highlighter getHighlighter(Query query) {
		Highlighter h = new Highlighter(new CssHtmlFormatter(CSS_CLASS_HIGHLIGHT), new QueryScorer(query));
		h.setTextFragmenter(new NullFragmenter());
		return h;
	}

	protected Query createQuery(String input) {
		QueryParser parser = new QueryParser(Version.LUCENE_46, ExampleIndexer.FIELD_CONTENTS,
				new StandardAnalyzer(Version.LUCENE_46));
		Query query = null;
		try {
			query = parser.parse(input);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return query;
	}
}
