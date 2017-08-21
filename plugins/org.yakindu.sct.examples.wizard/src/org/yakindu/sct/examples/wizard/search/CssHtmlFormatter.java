package org.yakindu.sct.examples.wizard.search;

import org.apache.lucene.search.highlight.SimpleHTMLFormatter;

public class CssHtmlFormatter extends SimpleHTMLFormatter {
	
	public CssHtmlFormatter(String cssClass) {
		super(getPreTag(cssClass), getPostTag());
	}

	protected static String getPreTag(String cssClass) {
		return "<span class=\"" + cssClass + "\">";
	}

	protected static String getPostTag() {
		return "</span>";
	}
}
