package org.yakindu.sct.examples.wizard.search;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.spell.Dictionary;
import org.apache.lucene.search.spell.LuceneDictionary;
import org.apache.lucene.search.suggest.Lookup;
import org.apache.lucene.search.suggest.analyzing.FuzzySuggester;
import org.apache.lucene.store.Directory;
import org.apache.lucene.util.Version;

public class Suggester {
	
	public List<String> suggest(Directory index, String query) throws IOException {
		IndexReader indexReader = DirectoryReader.open(index);
        Dictionary dictionary = new LuceneDictionary(indexReader, ExampleIndexer.FIELD_CONTENTS);
        FuzzySuggester fuzzySuggester = new FuzzySuggester(new StandardAnalyzer(Version.LUCENE_46));
        fuzzySuggester.build(dictionary);
        List<Lookup.LookupResult> lookupResultList = fuzzySuggester.lookup(query, false, 10);
        return lookupResultList.stream().map(r -> r.key.toString()).collect(Collectors.toList());
	}
	
}
