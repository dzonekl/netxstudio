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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.netxforge.interpreter.IInterpreter;
import com.netxforge.interpreter.IInterpreterContext;
import com.netxforge.interpreter.IInterpreterContextFactory;
import com.netxforge.netxscript.Mod;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.BaseExpressionResult;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.screens.ExpressionFilterDialog;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;
import com.netxforge.netxstudio.screens.xtext.EmbeddedXtextService;
import com.netxforge.netxstudio.screens.xtext.InjectorProxy;
import com.netxforge.netxstudio.screens.xtext.embedded.EmbeddedXtextEditor;

/**
 * 
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public class EmbeddedLineExpression {

	IInterpreterContextFactory interpreterContextFactory;

	@Inject
	ModelUtils modelUtils;

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	protected EmbeddedXtextEditor editor;

	private Expression expression;
	private EmbeddedXtextService xtextService;
	private Text txtExpressionName;

	public Text getTxtExpressionName() {
		return txtExpressionName;
	}

	private Injector netxScriptInjector;

	private int operation;

	protected IEditingService editingService;
	private Composite keyPadComposite;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public EmbeddedLineExpression() {
	}

	public void configure(IEditingService editingService, int operation) {
		this.editingService = editingService;
		this.operation = operation;
	}

	public void buildExpressionSelector(int widgetStyle, Composite parent,
			Object layoutData) {

		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());

		Composite selectionComposite = toolkit.createComposite(parent);
		selectionComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 2, 1));
		toolkit.adapt(selectionComposite);
		GridLayout gl = new GridLayout();
		gl.numColumns = 5;
		selectionComposite.setLayout(gl);

		ImageHyperlink imageHyperlink_2 = toolkit.createImageHyperlink(
				selectionComposite, SWT.NONE);
		GridData gd_imageHyperlink_2 = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_imageHyperlink_2.widthHint = 18;
		imageHyperlink_2.setLayoutData(gd_imageHyperlink_2);
		imageHyperlink_2.setImage(ResourceManager.getPluginImage(
				"com.netxforge.netxstudio.models.edit",
				"icons/full/obj16/Expression_H.png"));
		toolkit.paintBordersFor(imageHyperlink_2);
		imageHyperlink_2.setText("");

		@SuppressWarnings("unused")
		Label lblExpression = toolkit.createLabel(selectionComposite,
				"Expression", SWT.NONE);

		txtExpressionName = toolkit.createText(selectionComposite, "New Text",
				SWT.READ_ONLY);
		GridData gd_txtCapExpression = new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1);
		gd_txtCapExpression.widthHint = 150;
		txtExpressionName.setLayoutData(gd_txtCapExpression);
		txtExpressionName.setText("");

		if (!readonly) {

			ImageHyperlink imageHyperlink = toolkit.createImageHyperlink(
					selectionComposite, SWT.NONE);
			imageHyperlink.addHyperlinkListener(new IHyperlinkListener() {
				public void linkActivated(HyperlinkEvent e) {

					// TODO moigrate.
					// clearExpression(expression);
					// expression = null;
					// clearData();
					// setEnabled(false);

				}

				public void linkEntered(HyperlinkEvent e) {
				}

				public void linkExited(HyperlinkEvent e) {
				}
			});
			imageHyperlink.setImage(ResourceManager.getPluginImage(
					"org.eclipse.ui", "/icons/full/etool16/delete.gif"));
			toolkit.paintBordersFor(imageHyperlink);
			imageHyperlink.setText("");

			Button btnSelectCapExpression = toolkit.createButton(
					selectionComposite, "Select", SWT.NONE);
			btnSelectCapExpression.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					Resource expressionResource = editingService
							.getData(LibraryPackage.Literals.EXPRESSION);
					ExpressionFilterDialog dialog = new ExpressionFilterDialog(
							Display.getDefault().getActiveShell(),
							expressionResource);
					if (dialog.open() == IDialogConstants.OK_ID) {

						// TODO moigrate.
						// Expression expression = (Expression) dialog
						// .getFirstResult();
						// setExpression(expression);
						// injectData(expression);
					}
				}
			});
		}

	}

	public void buildExpression(int widgetStyle, Composite parent,
			Object layoutData) {

		parent.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				// dispose prior to disposing the widget.
				editor.getSourceViewerDecorationSupport(editor.getViewer())
						.dispose();
			}

		});

		netxScriptInjector = InjectorProxy
				.getInjector("com.netxforge.Netxscript");

		interpreterContextFactory = netxScriptInjector
				.getInstance(IInterpreterContextFactory.class);

		// Composite editorComposite = toolkit.createComposite(parent,
		// SWT.BORDER);
		// editorComposite.setLayoutData(layoutData);
		//
		// GridLayout gl_editorComposite = new GridLayout();
		// gl_editorComposite.marginHeight = 0;
		// gl_editorComposite.marginWidth = 0;
		// editorComposite.setLayout(gl_editorComposite);

		editor = new EmbeddedXtextEditor(parent, netxScriptInjector, SWT.BORDER
				| widgetStyle | SWT.SINGLE);
		editor.getDocument().addModelListener(new IXtextModelListener() {
			public void modelChanged(XtextResource resource) {
				if (expression != null) {
					xtextService.reconcileChangedModel(expression, editor);
				}
			}
		});

		// this.createKeyPad(parent);
	}

	public List<BaseExpressionResult> testExpression(DateTimeRange timeRange,
			Object... objects) {

		List<BaseExpressionResult> result = null;

		if (timeRange == null)
			throw new IllegalArgumentException("Should set a period context");

		if (objects == null || objects.length < 1)
			throw new IllegalArgumentException(
					"Should have one or more context objects");

		assert interpreterContextFactory != null : "Context factory is not initialized (check guice binding)";

		final IXtextDocument doc = editor.getDocument();
		assert !documentHasErrors(doc) : "Intepreter cancelled, as errors exist in script: "
				+ doc.get();

		// Context initialization.
		final IInterpreterContext periodContext = interpreterContextFactory
				.createPeriodContext(timeRange);
		final List<IInterpreterContext> contextList = Lists
				.newArrayList(periodContext);

		for (Object o : objects) {
			final IInterpreterContext objectContext = interpreterContextFactory
					.createContext(o);
			contextList.add(objectContext);
		}

		final IInterpreterContext[] contextArray = new IInterpreterContext[contextList
				.size()];

		final IInterpreter i = netxScriptInjector
				.getInstance(IInterpreter.class);

		i.setContext(contextList.toArray(contextArray));

		result = doc
				.readOnly(new IUnitOfWork<List<BaseExpressionResult>, XtextResource>() {
					public List<BaseExpressionResult> exec(
							XtextResource resource) throws Exception {
						if (resource.getContents().isEmpty()) {
							return null;
						}
						try {
							EObject rootASTElement = resource.getParseResult()
									.getRootASTElement();

							if ((rootASTElement instanceof Mod)) {
								Mod root = (Mod) resource.getContents().get(0);
								i.evaluate(root);
								return i.getResult();
							}
						} catch (Throwable t) {
							// something with t.
							t.printStackTrace();
						}
						return null;
					}
				});

		return result;
	}

	/**
	 * Inject the expression to work with. Do not use when enabling the
	 * selector.
	 */
	public void injectData(Object object) {

		if (xtextService == null) {
			xtextService = new EmbeddedXtextService(editingService);
		}

		if (object != null && object instanceof Expression) {
			expression = (Expression) object;

			String asString = xtextService.getAsString(expression);
			setEnabled(true);
			// Update with both the eval. object as a well as the string,
			// the editor will process either one....
			editor.update(expression, asString == null ? "" : asString);
		}

		if (object == null) {
			editor.update("");
		}
	}

	public void clearData() {
		// Set an empty string in the editor.
		editor.update("");
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
	public void createKeyPad(Composite parent) {

		keyPadComposite = toolkit.createComposite(parent, SWT.BORDER);

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

	public void setEnabled(boolean state) {
		this.editor.getViewer().setEditable(state);
		this.editor.getViewer().getControl().setEnabled(state);
		if (keyPadComposite != null) {
			this.keyPadComposite.setEnabled(state);
		}
	}

}
