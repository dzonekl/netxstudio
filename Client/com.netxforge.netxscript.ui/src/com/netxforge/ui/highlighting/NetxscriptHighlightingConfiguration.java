package com.netxforge.ui.highlighting;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

/**
 * Adapt some of the default highlighting colors, and add highlighting styles
 * for c cross references.
 * 
 * @author Christophe
 * 
 */
public class NetxscriptHighlightingConfiguration extends
		DefaultHighlightingConfiguration {

	public final static String CROSS_REF = "CrossReference";
	public final static String VALUE_RANGE = "ValueRange";
	public final static String NATIVE_FUNCTION = "NativeFunction";
	public final static String MODEL_REFS = "ModelRefs";
	public  final static String INTERVAL_KIND = "IntervalKind";

	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.acceptDefaultHighlighting(CROSS_REF, "Cross-References",
				crossReferenceTextStyle());
		acceptor.acceptDefaultHighlighting(VALUE_RANGE, "Value-Range",
				valueRangeReferenceTextStyle());
		acceptor.acceptDefaultHighlighting(NATIVE_FUNCTION, "Native-Function",
				nativeFunctionTextStyle());
		acceptor.acceptDefaultHighlighting(MODEL_REFS, "Model-Refs",
				modelRefsTextStyle());
		acceptor.acceptDefaultHighlighting(INTERVAL_KIND, "Interval-Kind",
				intervalKindTextStyle());
		
	}

	private TextStyle intervalKindTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(128,128, 128));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	private TextStyle modelRefsTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(79, 98, 40));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	private TextStyle nativeFunctionTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(102, 0, 102));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	private TextStyle valueRangeReferenceTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(147, 43, 20));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	public TextStyle crossReferenceTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setStyle(SWT.ITALIC);
		return textStyle;
	}

	@Override
	public TextStyle numberTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(0, 87, 170));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

}
