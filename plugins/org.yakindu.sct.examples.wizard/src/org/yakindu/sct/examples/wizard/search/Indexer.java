package org.yakindu.sct.examples.wizard.search;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.FieldInfo.IndexOptions;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.html.HtmlParser;
import org.apache.tika.sax.BodyContentHandler;

public class Indexer {

	public static final String FIELD_CONTENTS = "contents";
	public static final String FIELD_NAME = "name";

	/* Indexed, tokenized, not stored. */
	public static final FieldType TYPE_CONTENTS = new FieldType();

	/* Indexed, tokenized, stored. */
	public static final FieldType TYPE_NAME = new FieldType();

	static {
		TYPE_CONTENTS.setIndexed(true);
		TYPE_CONTENTS.setIndexOptions(IndexOptions.DOCS_ONLY);
		TYPE_CONTENTS.setTokenized(true);
		TYPE_CONTENTS.setStoreTermVectors(true);
		// TYPE_CONTENTS.setStoreTermVectorPositions(true);
		TYPE_CONTENTS.freeze();

		TYPE_NAME.setIndexed(false);
		TYPE_NAME.setTokenized(false);
		TYPE_NAME.setStored(true);
		TYPE_NAME.freeze();
	}
	
	public Directory index(String dataPath, String indexPath) throws IOException {
		File dataFolder = new File(dataPath);
		if (!dataFolder.exists() || !dataFolder.isDirectory()) {
			throw new IOException(dataPath + " does not exist or is not a directory");
		}
		File indexFolder = new File(indexPath);
		if (indexFolder.exists()) {
			FileUtil.deleteDirectory(indexFolder);
		}
		if (!indexFolder.exists()) {
			Files.createDirectory(indexFolder.toPath());
		}

		// create Lucene index
		StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_35);

		// Directory index = new RAMDirectory();
		Directory index = FSDirectory.open(new File(indexPath));
		IndexWriter indexWriter = new IndexWriter(index, new IndexWriterConfig(Version.LUCENE_35, analyzer));

		indexDirectory(indexWriter, dataFolder);

		indexWriter.close();
		return index;
	}
	
	private void indexDirectory(IndexWriter writer, File dir) throws IOException {
		File[] files = dir.listFiles();

		for (File f : files) {
			if (f.isDirectory()) {
				indexDirectory(writer, f);
			} else {
				indexFile(writer, f);
			}
		}
	}

	private void indexFile(IndexWriter writer, File file) throws IOException {
		if (file.isHidden() || !file.exists() || !file.canRead()) {
			return;
		}

		try {
			BodyContentHandler handler = new BodyContentHandler();
			Metadata metadata = new Metadata();
			InputStream inputstream = new FileInputStream(file);
			HtmlParser htmlparser = new HtmlParser();
		    htmlparser.parse(inputstream, handler);
		    String contents = handler.toString();
//			Tika tika = new Tika();
//			String contents = tika.parseToString(stream);
//			Document doc = new Document();
//			doc.add(new Field(FIELD_CONTENTS, contents, TYPE_CONTENTS));
//			doc.add(new Field(FIELD_NAME, file.getCanonicalPath(), TYPE_NAME));
//			writer.addDocument(doc);

		      System.out.println("Contents of the document:" + handler.toString());
		      System.out.println("Metadata of the document:");
		      String[] metadataNames = metadata.names();
		      
		      for(String name : metadataNames) {
		         System.out.println(name + ":   " + metadata.get(name));  
		      }

		} catch (IOException e) {
			e.printStackTrace();
//		} catch (TikaException e) {
//			e.printStackTrace();
		}

	}
}
