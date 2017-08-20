package org.yakindu.sct.examples.wizard.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.util.Version;

public class Searcher {

	public Iterable<Document> search(Directory index, String input) throws IOException {
		int hitsPerPage = 100;
		IndexReader reader = DirectoryReader.open(index);
		IndexSearcher is = new IndexSearcher(reader);
		
		Query query = createQuery(input);
		if (query != null) {
			TopDocs hits = is.search(query, hitsPerPage);
			List<Document> docs = new ArrayList<Document>();
			for (int i = 0; i < hits.totalHits; ++i) {
				int docId = hits.scoreDocs[i].doc;
				Document d = is.doc(docId);
				docs.add(d);
			}
			return docs;
		}
		return Collections.emptyList();
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
