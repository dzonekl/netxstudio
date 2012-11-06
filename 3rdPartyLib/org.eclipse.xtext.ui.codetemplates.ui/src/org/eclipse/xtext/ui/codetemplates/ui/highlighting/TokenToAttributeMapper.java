/*******************************************************************************
 * Copyright (c) 2008,2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.highlighting;

import java.util.Set;

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;

import com.google.common.collect.ImmutableSet;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TokenToAttributeMapper extends DefaultAntlrTokenToAttributeIdMapper {

	private final Set<String> keywords = ImmutableSet.of(
			"KEYWORD_TEMPLATES",
			"KEYWORD_FOR");

	@Override
	protected String calculateId(String tokenName, int tokenType) {
		if (keywords.contains(tokenName)) {
			return DefaultHighlightingConfiguration.KEYWORD_ID;
		}
		if (tokenName.startsWith("KEYWORD_"))
			return DefaultHighlightingConfiguration.PUNCTUATION_ID;
		if (tokenName.equals("RULE_BODY"))
			return TemplatesHighlightingConfiguration.TEMPLATE_BODY;
		return super.calculateId(tokenName, tokenType);
	}

}
