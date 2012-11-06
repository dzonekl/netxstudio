/*******************************************************************************
 * Copyright (c) May 16, 2011 NetXForge.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 * Contributors:
 *    Christophe Bouhier - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.screens.ch9;

import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.netxforge.interpreter.IInterpreter;
import com.netxforge.interpreter.IInterpreterContext;
import com.netxforge.interpreter.IInterpreterContextFactory;
import com.netxforge.netxscript.Function;
import com.netxforge.netxscript.Mod;
import com.netxforge.netxscript.NetxscriptFactory;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.selector.Screens;
import com.netxforge.netxstudio.screens.xtext.EmbeddedXtextService;
import com.netxforge.netxstudio.screens.xtext.InjectorProxy;
import com.netxforge.netxstudio.screens.xtext.embedded.EmbeddedXtextEditor;

/**
 * 
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public class EmbeddedExpression {

	IInterpreterContextFactory interpreterContextFactory;

	@Inject
	ModelUtils modelUtils;

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private EmbeddedXtextEditor editor;

	private Expression expression;
	private EObject evaluationObject = NetxscriptFactory.eINSTANCE.createMod();
	private EmbeddedXtextService xtextService;

	private final Injector netxScriptInjector;

	private int operation;

	@SuppressWarnings("unused")
	private IEditingService editingService;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public EmbeddedExpression(IEditingService editingService, Composite parent,
			FormData fd, int operation) {

		this.operation = operation;

		this.editingService = editingService;

		int widgetStyle = SWT.None;
		if (Screens.isReadOnlyOperation(getOperation())) {
			widgetStyle |= SWT.READ_ONLY;
		}

		Section sctnNewSection = toolkit.createSection(parent, Section.EXPANDED
				| Section.TITLE_BAR);
		sctnNewSection.setLayoutData(fd);
		toolkit.paintBordersFor(sctnNewSection);
		sctnNewSection.setText("NetXScript");

		Composite client = toolkit.createComposite(sctnNewSection);

		GridLayout editorLayout = new GridLayout();
		editorLayout.marginHeight = 0;
		editorLayout.marginWidth = 0;
		editorLayout.numColumns = 2;
		editorLayout.marginLeft = 0;
		editorLayout.marginRight = 0;

		client.setLayout(editorLayout);

		netxScriptInjector = InjectorProxy
				.getInjector("com.netxforge.Netxscript");

		interpreterContextFactory = netxScriptInjector
				.getInstance(IInterpreterContextFactory.class);

		// Injector injector =
		// ArithmeticsActivator.getInstance().getInjector("org.eclipse.xtext.example.arithmetics.Arithmetics");
		Composite editorComposite = toolkit.createComposite(client, SWT.BORDER);
		GridLayout gl_editorComposite = new GridLayout();
		gl_editorComposite.marginHeight = 0;
		gl_editorComposite.marginWidth = 0;
		editorComposite.setLayout(gl_editorComposite);
		editor = new EmbeddedXtextEditor(editorComposite, netxScriptInjector,
				SWT.BORDER | widgetStyle);
		editor.getDocument().addModelListener(new IXtextModelListener() {
			public void modelChanged(XtextResource resource) {
				evaluationObject = xtextService.reconcileChangedModel(
						expression, editor);
			}
		});
		editorComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true));
		this.createKeyPad(client);
		sctnNewSection.setClient(client);

//		ImageHyperlink mghprlnkTest = toolkit.createImageHyperlink(
//				sctnNewSection, SWT.NONE);
//		mghprlnkTest.addHyperlinkListener(new IHyperlinkListener() {
//
//			public void linkActivated(HyperlinkEvent e) {
//				// Launch the interpreter, with a given context.
//				testExpression();
//
//			}
//
//			public void linkEntered(HyperlinkEvent e) {
//			}
//
//			public void linkExited(HyperlinkEvent e) {
//			}
//		});
//		toolkit.paintBordersFor(mghprlnkTest);
//		sctnNewSection.setTextClient(mghprlnkTest);
//		mghprlnkTest.setText("Test Run");
		xtextService = new EmbeddedXtextService(editingService);
	}

	@SuppressWarnings("unused")
	// Disable for now, we don't have a context in the expression screen. 
	private void testExpression() {
		// NOTE, for testing, the period context is always last week.
		DateTimeRange timeRange = GenericsFactory.eINSTANCE
				.createDateTimeRange();

		XMLGregorianCalendar t0 = modelUtils
				.toXMLDate(modelUtils.todayAndNow());
		XMLGregorianCalendar t1 = modelUtils.toXMLDate(modelUtils.lastWeek());

		timeRange.setBegin(t1);
		timeRange.setEnd(t0);

		IInterpreterContext periodContext = interpreterContextFactory
				.createPeriodContext(timeRange);

		List<IInterpreterContext> contextList = ImmutableList.of(periodContext);
		IInterpreterContext[] contextArray = new IInterpreterContext[contextList
				.size()];
		final IInterpreter i = netxScriptInjector
				.getInstance(IInterpreter.class);
		i.setContext(contextList.toArray(contextArray));

		IXtextDocument doc = editor.getDocument();
		if (documentHasErrors(doc)) {
			System.out
					.println("Intepreter cancelled, as errors exist in script: "
							+ doc.get());
		}
		String rootElementName = doc
				.readOnly(new IUnitOfWork<String, XtextResource>() {

					// Note: Expression scoping i.e. 'mod' or 'def' are
					// optional.
					public String exec(XtextResource resource) throws Exception {
						if (resource.getContents().isEmpty()) {
							return null;
						}

						// TODO, Consider validating the resource here.
						if ((resource.getContents().get(0) instanceof Mod)) {
							Mod root = (Mod) resource.getContents().get(0);
							i.evaluate(root);
						}
						if ((resource.getContents().get(0) instanceof Function)) {
							Function root = (Function) resource.getContents()
									.get(0);
							i.evaluate(root);
						}

						return null;
					}
				});
	}

	/**
	 * Inject the expression to work with.
	 */
	public void injectData(Object object) {
		if (object != null && object instanceof Expression) {
			expression = (Expression) object;

			String asString = xtextService.getAsString(expression);
			editor.update(this.evaluationObject, asString == null ? ""
					: asString);
		}
	}

	/**
	 * Use for single row expressions.
	 * 
	 * @param i
	 * @return
	 */
	public int convertHeightInCharsToPixels(int i) {
		// Create a GC to calculate font's dimensions
		GC gc = new GC(Display.getDefault());
		gc.setFont(editor.getViewer().getTextWidget().getFont());

		// Determine string's dimensions
		FontMetrics fontMetrics = gc.getFontMetrics();

		int ret = (fontMetrics.getHeight() + fontMetrics.getAscent()
				+ fontMetrics.getDescent() + fontMetrics.getLeading())
				* i;

		// Dispose that gc
		gc.dispose();

		return ret;
	}

	/**
	 * Our keypad component.
	 * 
	 * @param parent
	 */
	private void createKeyPad(Composite parent) {

		Composite keyPadComposite = toolkit.createComposite(parent, SWT.BORDER);
		keyPadComposite.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		GridLayout gl_composite_3 = new GridLayout(5, false);
		gl_composite_3.verticalSpacing = 2;
		gl_composite_3.marginHeight = 2;
		gl_composite_3.horizontalSpacing = 2;
		gl_composite_3.marginRight = 2;
		gl_composite_3.marginLeft = 2;
		gl_composite_3.marginWidth = 0;
		keyPadComposite.setLayout(gl_composite_3);
		GridData gd_composite_3 = new GridData(SWT.FILL, SWT.FILL, false, true,
				1, 1);
		gd_composite_3.widthHint = 100;
		keyPadComposite.setLayoutData(gd_composite_3);
		toolkit.paintBordersFor(keyPadComposite);

		Button plusButton = toolkit
				.createButton(keyPadComposite, "+", SWT.NONE);
		GridData gd_button = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_button.widthHint = 18;
		gd_button.heightHint = 18;
		plusButton.setLayoutData(gd_button);
		plusButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				insertKeyPadText("+");
			}
		});

		Button btnTrue = toolkit
				.createButton(keyPadComposite, "true", SWT.NONE);
		btnTrue.setFont(SWTResourceManager.getFont("Lucida Grande", 9,
				SWT.NORMAL));
		GridData gd_btnTrue = new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1);
		gd_btnTrue.widthHint = 36;
		gd_btnTrue.heightHint = 18;
		btnTrue.setLayoutData(gd_btnTrue);
		btnTrue.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				insertKeyPadText("true");
			}
		});

		Button btnEquals = toolkit
				.createButton(keyPadComposite, "==", SWT.NONE);
		GridData gd_button_6 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_button_6.widthHint = 24;
		gd_button_6.heightHint = 18;
		btnEquals.setLayoutData(gd_button_6);
		new Label(keyPadComposite, SWT.NONE);
		btnEquals.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				insertKeyPadText("==");
			}
		});

		Composite composite = toolkit.createComposite(keyPadComposite,
				SWT.NO_BACKGROUND | SWT.NO_FOCUS);
		GridData gd_composite = new GridData(SWT.LEFT, SWT.FILL, false, false,
				1, 3);
		gd_composite.widthHint = 18;
		gd_composite.heightHint = 18;
		composite.setLayoutData(gd_composite);
		toolkit.paintBordersFor(composite);

		Button btnMinus = toolkit.createButton(keyPadComposite, "-", SWT.NONE);
		GridData gd_button_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_button_1.widthHint = 18;
		gd_button_1.heightHint = 18;
		btnMinus.setLayoutData(gd_button_1);
		btnMinus.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				insertKeyPadText("-");
			}
		});

		Button btnFalse = toolkit.createButton(keyPadComposite, "false",
				SWT.NONE);
		GridData gd_btnFalse = new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1);
		gd_btnFalse.widthHint = 36;
		gd_btnFalse.heightHint = 18;
		btnFalse.setLayoutData(gd_btnFalse);
		btnFalse.setFont(SWTResourceManager.getFont("Lucida Grande", 9,
				SWT.NORMAL));
		btnFalse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				insertKeyPadText("false");
			}
		});

		Button btnUnequal = toolkit.createButton(keyPadComposite, "!=",
				SWT.NONE);
		GridData gd_button_11 = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_button_11.widthHint = 24;
		gd_button_11.heightHint = 18;
		btnUnequal.setLayoutData(gd_button_11);
		new Label(keyPadComposite, SWT.NONE);
		btnUnequal.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				insertKeyPadText("!=");
			}
		});

		Button btnDiv = toolkit.createButton(keyPadComposite, "/", SWT.NONE);
		GridData gd_button_3 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_button_3.widthHint = 18;
		gd_button_3.heightHint = 18;
		btnDiv.setLayoutData(gd_button_3);
		btnDiv.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				insertKeyPadText("/");
			}
		});

		Button btnAnd = toolkit.createButton(keyPadComposite, "&&", SWT.NONE);
		btnAnd.setFont(SWTResourceManager.getFont("Lucida Grande", 9,
				SWT.NORMAL));
		GridData gd_btnAnd = new GridData(SWT.CENTER, SWT.CENTER, false, false,
				1, 1);
		gd_btnAnd.widthHint = 36;
		gd_btnAnd.heightHint = 18;
		btnAnd.setLayoutData(gd_btnAnd);
		btnAnd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				insertKeyPadText("&&");
			}
		});

		Button btnGreaterOrEqual = toolkit.createButton(keyPadComposite, ">=",
				SWT.NONE);
		GridData gd_button_9 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_button_9.widthHint = 24;
		gd_button_9.heightHint = 18;
		btnGreaterOrEqual.setLayoutData(gd_button_9);
		new Label(keyPadComposite, SWT.NONE);
		btnGreaterOrEqual.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				insertKeyPadText(">=");
			}
		});

		Button btnMultiply = toolkit.createButton(keyPadComposite, "*",
				SWT.NONE);
		GridData gd_button_2 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_button_2.widthHint = 18;
		gd_button_2.heightHint = 18;
		btnMultiply.setLayoutData(gd_button_2);
		btnMultiply.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				insertKeyPadText("*");
			}
		});

		Button btnOr = toolkit.createButton(keyPadComposite, "||", SWT.NONE);
		btnOr.setFont(SWTResourceManager
				.getFont("Lucida Grande", 9, SWT.NORMAL));
		GridData gd_btnOr = new GridData(SWT.CENTER, SWT.CENTER, false, false,
				1, 1);
		gd_btnOr.widthHint = 36;
		gd_btnOr.heightHint = 18;
		btnOr.setLayoutData(gd_btnOr);
		btnOr.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				insertKeyPadText("||");
			}
		});

		Button btnSmallOrEqual = toolkit.createButton(keyPadComposite, "<=",
				SWT.NONE);
		GridData gd_button_10 = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_button_10.widthHint = 24;
		gd_button_10.heightHint = 18;
		btnSmallOrEqual.setLayoutData(gd_button_10);
		new Label(keyPadComposite, SWT.NONE);
		new Label(keyPadComposite, SWT.NONE);
		btnSmallOrEqual.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				insertKeyPadText("<=");
			}
		});

		Button btnMod = toolkit.createButton(keyPadComposite, "%", SWT.NONE);
		GridData gd_button_4 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_button_4.heightHint = 18;
		gd_button_4.widthHint = 18;
		btnMod.setLayoutData(gd_button_4);
		btnMod.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				insertKeyPadText("%");
			}
		});

		Button btnNot = toolkit.createButton(keyPadComposite, "!", SWT.NONE);
		btnNot.setFont(SWTResourceManager.getFont("Lucida Grande", 9,
				SWT.NORMAL));
		GridData gd_btnNot = new GridData(SWT.CENTER, SWT.CENTER, false, false,
				1, 1);
		gd_btnNot.widthHint = 36;
		gd_btnNot.heightHint = 18;
		btnNot.setLayoutData(gd_btnNot);
		btnNot.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				insertKeyPadText("!");
			}
		});

		Button btnGreater = toolkit
				.createButton(keyPadComposite, ">", SWT.NONE);
		GridData gd_button_7 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_button_7.widthHint = 24;
		gd_button_7.heightHint = 18;
		btnGreater.setLayoutData(gd_button_7);
		new Label(keyPadComposite, SWT.NONE);
		new Label(keyPadComposite, SWT.NONE);
		btnGreater.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				insertKeyPadText(">");
			}
		});

		Button btnAssign = toolkit.createButton(keyPadComposite, "=", SWT.NONE);
		GridData gd_button_5 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_button_5.widthHint = 18;
		gd_button_5.heightHint = 18;
		btnAssign.setLayoutData(gd_button_5);
		new Label(keyPadComposite, SWT.NONE);
		btnAssign.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				insertKeyPadText("=");
			}
		});

		Button btnLesser = toolkit.createButton(keyPadComposite, "<", SWT.NONE);
		GridData gd_button_8 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_button_8.widthHint = 24;
		gd_button_8.heightHint = 18;
		btnLesser.setLayoutData(gd_button_8);
		new Label(keyPadComposite, SWT.NONE);
		new Label(keyPadComposite, SWT.NONE);
		btnAssign.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				insertKeyPadText("<");
			}
		});
	}

	private void insertKeyPadText(String toInsert) {
		IXtextDocument doc = editor.getDocument();
		int len = doc.getLength();
		try {
			doc.replace(len, 0, toInsert);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	public boolean documentHasErrors(final IXtextDocument xtextDocument) {
		return (xtextDocument
				.readOnly(new IUnitOfWork<Boolean, XtextResource>() {
					public Boolean exec(XtextResource state) throws Exception {
						IParseResult parseResult = state.getParseResult();
						// CB Change.
						return !state.getErrors().isEmpty()
								|| parseResult == null
								|| parseResult.getSyntaxErrors().iterator()
										.hasNext();
					}
				}));
	}

	public void disposeData() {
		// N/A
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}

	public int getOperation() {
		return this.operation;
	}

}
