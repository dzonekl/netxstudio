package com.netxforge.ui.highlighting;

import java.util.regex.Pattern;

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;

/**
 * token Names tend to be wrapped in single quotes ', so expressions should get
 * rid of those.
 * 
 * 
 */
public class NetxscriptAntlrTokenToAttributeIdMapper extends
		DefaultAntlrTokenToAttributeIdMapper {

	// pattern for native functions, keywords ending with ()
	private static final Pattern NATIVE_FUNCTION = Pattern
			.compile("(?:^'\\w*\\(\\)'$)");

	private static final Pattern MODEL_REFS = Pattern
			.compile("(?:^'(FUNCTION|EQUIPMENT|NE|NETYPE|RESOURCE|PARAM)'$)");
	
	@Override
	protected String calculateId(String tokenName, int tokenType) {
		if (MODEL_REFS.matcher(tokenName).matches()) {
			return NetxscriptHighlightingConfiguration.MODEL_REFS;
		} else if (NATIVE_FUNCTION.matcher(tokenName).matches()) {
			return NetxscriptHighlightingConfiguration.NATIVE_FUNCTION;
		} else if ("RULE_NUMBER".equals(tokenName)) {
			return DefaultHighlightingConfiguration.NUMBER_ID;
		} else
			return super.calculateId(tokenName, tokenType);
	}

}
