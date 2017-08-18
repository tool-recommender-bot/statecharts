package org.yakindu.sct.examples.wizard.search;

import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.util.Version;

public class Searcher {

	public void search(Directory index, String input) throws IOException {
		int hitsPerPage = 10;
		IndexReader reader = DirectoryReader.open(index);
		IndexSearcher is = new IndexSearcher(reader);
		TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage, true);
		
		Query query = createQuery(input);
		if (query != null) {
			is.search(query, collector);
			ScoreDoc[] hits = collector.topDocs().scoreDocs;
			// Code to display the results of search
			System.out.println("Found " + hits.length + " hits.");
			for (int i = 0; i < hits.length; ++i) {
				int docId = hits[i].doc;
				float score = hits[i].score;
				Document d = is.doc(docId);
				System.out.println((i + 1) + ". " + d.get("name") + " Score: " + score);
			}
		}
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
