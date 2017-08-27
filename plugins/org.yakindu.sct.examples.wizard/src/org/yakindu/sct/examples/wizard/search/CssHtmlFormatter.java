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

import org.apache.lucene.search.highlight.SimpleHTMLFormatter;

/**
 * 
 * @author Thomas Kutz - Initial contribution and API
 * 
 */
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
