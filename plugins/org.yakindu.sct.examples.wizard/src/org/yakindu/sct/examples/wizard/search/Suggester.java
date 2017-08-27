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

/**
 * 
 * @author Thomas Kutz - Initial contribution and API
 * 
 */
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
