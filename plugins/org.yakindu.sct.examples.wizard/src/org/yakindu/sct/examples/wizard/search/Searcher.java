package org.yakindu.sct.examples.wizard.search;

import java.io.IOException;
import java.util.ArrayList;
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
import org.apache.lucene.search.highlight.Formatter;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.NullFragmenter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.TokenSources;
import org.apache.lucene.store.Directory;
import org.apache.lucene.util.Version;

public class Searcher {

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
	
	public Iterable<SearchResult> search(Directory index, String input) throws IOException {
		int hitsPerPage = 100;
		IndexReader reader = DirectoryReader.open(index);
		IndexSearcher is = new IndexSearcher(reader);
		
		Query query = createQuery(input);
		if (query == null) {
			return Collections.emptyList();
		}
		TopDocs hits = is.search(query, hitsPerPage);
		Formatter formatter = new CssHtmlFormatter("highlight");
		QueryScorer scorer = new QueryScorer(query);
		Highlighter highlighter = new Highlighter(formatter, scorer);
		Fragmenter fragmenter = new NullFragmenter();
		highlighter.setTextFragmenter(fragmenter);
		
		List<SearchResult> results = new ArrayList<SearchResult>();
		for (int i = 0; i < hits.scoreDocs.length; i++) {
			int docId = hits.scoreDocs[i].doc;
			Document d = is.doc(docId);
			
			String contents = d.get(Indexer.FIELD_SOURCE);
			TokenStream stream = TokenSources.getAnyTokenStream(reader, docId, Indexer.FIELD_SOURCE, new StandardAnalyzer(Version.LUCENE_46));
			String highlightedContents = "";
			try {
				highlightedContents = highlighter.getBestFragment(stream, contents);
			} catch (InvalidTokenOffsetsException e) {
				e.printStackTrace();
			}
			SearchResult result = new SearchResult(d.get(Indexer.FIELD_ID), highlightedContents);
			results.add(result);
		}
		return results;
	}

	protected Query createQuery(String input) {
		QueryParser parser = new QueryParser(Version.LUCENE_46, Indexer.FIELD_CONTENTS, new StandardAnalyzer(Version.LUCENE_46));
		Query query = null;
		try {
			query = parser.parse(input);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return query;
	}
}
