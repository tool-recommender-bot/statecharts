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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.index.FieldInfo.IndexOptions;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.html.HtmlParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;
import org.yakindu.sct.examples.wizard.service.ExampleData;

/**
 * 
 * @author Thomas Kutz - Initial contribution and API
 * 
 */
public class ExampleIndexer {

	public static final String FIELD_CONTENTS = "contents";
	public static final String FIELD_SOURCE = "source";
	public static final String FIELD_ID = "id";
	public static final String FIELD_TITLE = "title";
	public static final String FIELD_PATH = "path";

	public static final FieldType TYPE_CONTENTS = new FieldType();
	public static final FieldType TYPE_ID = new FieldType();
	public static final FieldType TYPE_TITLE = new FieldType();
	public static final FieldType TYPE_PATH = new FieldType();
	public static final FieldType TYPE_SOURCE = new FieldType();

	static {
		TYPE_CONTENTS.setIndexed(true);
		TYPE_CONTENTS.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS);
		TYPE_CONTENTS.setTokenized(true);
		TYPE_CONTENTS.setStoreTermVectors(true);
		TYPE_CONTENTS.setStoreTermVectorOffsets(true);
		TYPE_CONTENTS.setStoreTermVectorPositions(true);
		TYPE_CONTENTS.setStored(true);
		TYPE_CONTENTS.freeze();
		
		TYPE_SOURCE.setIndexed(false);
		TYPE_SOURCE.setTokenized(false);
		TYPE_SOURCE.setStored(true);
		TYPE_SOURCE.freeze();

		TYPE_ID.setIndexed(false);
		TYPE_ID.setTokenized(false);
		TYPE_ID.setStored(true);
		TYPE_ID.freeze();
		
		TYPE_PATH.setIndexed(false);
		TYPE_PATH.setTokenized(false);
		TYPE_PATH.setStored(true);
		TYPE_PATH.freeze();
		
		TYPE_TITLE.setIndexed(true);
		TYPE_TITLE.setTokenized(false);
		TYPE_TITLE.setStored(false);
		TYPE_TITLE.freeze();
	}
	
	public Directory index(Iterable<ExampleData> examples, Path indexPath) throws IOException {
		File indexFolder = indexPath.toFile();
		if (indexFolder.exists()) {
			FileUtil.deleteDirectory(indexPath);
		}
		if (!indexFolder.exists()) {
			Files.createDirectory(indexPath);
		}

		StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_46);

		Directory index = FSDirectory.open(indexFolder);
		IndexWriter indexWriter = new IndexWriter(index, new IndexWriterConfig(Version.LUCENE_46, analyzer));

		indexExamples(indexWriter, examples);

		indexWriter.close();
		return index;
	}
	
	protected void indexExamples(IndexWriter writer, Iterable<ExampleData> examples) {
		for (ExampleData example : examples) {
			indexExample(writer, example);
		}
	}
	
	protected void indexExample(IndexWriter writer, ExampleData example) {
		try {
			File indexHtml = getIndexHtml(example);
			String contents = parseBodyContents(indexHtml);
			String id = example.getId();
			String title = example.getTitle();
			String path = example.getProjectDir().getAbsolutePath();
			String source = FileUtil.readFile(indexHtml.toPath());
			writer.addDocument(createDocument(id, title, path, contents, source));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected File getIndexHtml(ExampleData example) {
		File dir = example.getProjectDir();
		return FileUtil.findFirst(dir, f -> f.getName().toLowerCase().equals("index.html"));
	}

	protected String parseBodyContents(File file) {
		if (file == null) {
			return "";
		}
		try {
			BodyContentHandler handler = new BodyContentHandler();
			Metadata metadata = new Metadata();
			InputStream inputstream = new FileInputStream(file);
			HtmlParser htmlparser = new HtmlParser();
			ParseContext context = new ParseContext();

			htmlparser.parse(inputstream, handler, metadata, context);

			return handler.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TikaException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		return "";
	}

	protected Document createDocument(String id, String title, String path, String contents, String source) {
		Document doc = new Document();
		doc.add(new Field(FIELD_ID, id, TYPE_ID));
		doc.add(new Field(FIELD_TITLE, id, TYPE_TITLE));
		doc.add(new Field(FIELD_PATH, id, TYPE_PATH));
		doc.add(new Field(FIELD_CONTENTS, contents, TYPE_CONTENTS));
		doc.add(new Field(FIELD_SOURCE, source, TYPE_SOURCE));
		return doc;
	}
}
