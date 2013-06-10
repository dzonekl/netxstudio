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
package com.netxforge.netxstudio.screens.xtext.embedded;

import java.util.Set;

import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.CDOState;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
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
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Injector;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.screens.editing.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.xtext.EmbeddedXtextService;
import com.netxforge.netxstudio.screens.xtext.internal.ScreensXtextActivator;

/**
 * 
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public class EmbeddedLineExpression implements IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private EmbeddedXtextEditor xtextEditor;

	private Expression expression;

	private EmbeddedXtextService xtextService;

	private Text txtExpressionName;

	public Text getTxtExpressionName() {
		return txtExpressionName;
	}

	private int operation;

	protected IEditingService editingService;
	private Composite keyPadComposite;

	private Resource expressionsResource;

	private EObject target;

	private EReference feature;

	/*
	 * The Injector
	 */
	private Injector injector;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public EmbeddedLineExpression() {
	}

	public void setInjector(Injector injector) {
		this.injector = injector;

	}

	public void configure(IEditingService editingService, int operation) {
		this.editingService = editingService;
		this.operation = operation;
	}

	public void buildExpression(int widgetStyle, Composite parent,
			Object layoutData) {

		parent.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				// dispose prior to disposing the widget.
				xtextEditor.getSourceViewerDecorationSupport(
						xtextEditor.getViewer()).dispose();
			}

		});

		// Composite editorComposite = toolkit.createComposite(parent,
		// SWT.BORDER);
		// editorComposite.setLayoutData(layoutData);
		//
		// GridLayout gl_editorComposite = new GridLayout();
		// gl_editorComposite.marginHeight = 0;
		// gl_editorComposite.marginWidth = 0;
		// editorComposite.setLayout(gl_editorComposite);

		xtextEditor = new EmbeddedXtextEditor(parent, injector, SWT.BORDER
				| widgetStyle | SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);

		xtextEditor.getDocument().addModelListener(new IXtextModelListener() {
			public void modelChanged(XtextResource resource) {
				if (expression != null) {
					xtextService.reconcileChangedModel(expression, xtextEditor);

					if (ScreensXtextActivator.DEBUG) {
						ScreensXtextActivator.TRACE
								.trace(ScreensXtextActivator.TRACE_SCREENS_XTEXT_OPTION,
										" model changed Expr="
												+ expression.getName());
					}

					if (xtextEditor.getDocument().getLength() > 0
							&& expression.cdoState() == CDOState.TRANSIENT) {
						addData();
					} else if (xtextEditor.getDocument().getLength() == 0) {
						// We can remove, only in state CLEAN or DIRTY.
						if (expression.cdoState() == CDOState.CLEAN
								|| expression.cdoState() == CDOState.DIRTY) {

							// removeData();
						}
					}
				}
			}
		});

		// this.createKeyPad(parent);
	}

	public void injectData(Object... params) {
		// optional params;
		// 0 = Resource
		// 1 = Expression
		// 2 = target reference object
		// 3 = target EReference

		if (xtextService == null) {
			xtextService = new EmbeddedXtextService(editingService);
		}

		if (params[0] instanceof Resource) {
			expressionsResource = (Resource) params[0];
		}

		if (params.length >= 2 && params[1] instanceof Expression) {
			final Expression tmpExpression = (Expression) params[1];

			String asString = xtextService.getAsString(tmpExpression);

			if (ScreensXtextActivator.DEBUG) {
				ScreensXtextActivator.TRACE.trace(
						ScreensXtextActivator.TRACE_SCREENS_XTEXT_OPTION,
						"start loading, Expr=" + tmpExpression.getName());
			}
			// add a call back, to know when the expression for this screen can
			// be set.
			EmbeddedXtextEditor.ExpressionLoadingJob job = xtextEditor.update(
					null, asString == null ? "" : asString);
			job.addNotifier(new JobChangeAdapter() {
				@Override
				public void done(IJobChangeEvent event) {
					super.done(event);

					// CB We might have switched screen, for all we know.
					// which will dispose the transaction.
					EmbeddedLineExpression.this.expression = tmpExpression;

					if (ScreensXtextActivator.DEBUG) {
						ScreensXtextActivator.TRACE
								.trace(ScreensXtextActivator.TRACE_SCREENS_XTEXT_OPTION,
										"done loading, Expr="
												+ expression.getName());
					}
				}
			});
		}

		if (params.length >= 3 && params[2] instanceof EObject) {
			target = (EObject) params[2];
		}
		if (params.length == 4 && params[3] instanceof EReference) {
			feature = (EReference) params[3];
		}

	}

	public void injectData() {

	}

	/**
	 * Inject the expression to work with. Do not use when enabling the
	 * selector.
	 */
	public void injectData(Object parent, Object object) {
		injectData(new Object[] { parent, object });
	}

	public void clearData() {
		// Make sure no updates to the editor are reconciled with the expression
		// object.
		expression = null;
		// Set an empty string in the editor.
		xtextEditor.update("// Select a tolerance expression");

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
		gc.setFont(xtextEditor.getViewer().getTextWidget().getFont());

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
		IXtextDocument doc = xtextEditor.getDocument();
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

	public void setEnabled(boolean enable) {
		this.xtextEditor.getViewer().setEditable(enable);
		this.xtextEditor.getViewer().getControl().setEnabled(enable);

		if (keyPadComposite != null) {
			this.keyPadComposite.setEnabled(enable);
		}
	}

	public void addData() {

		Command c = new AddCommand(editingService.getEditingDomain(),
				expressionsResource.getContents(), expression);
		editingService.getEditingDomain().getCommandStack().execute(c);

		if (target != null && feature != null) {
			// We also set the reference to this expression, we need to
			// referee and a feature for this.
			Command cSetRef = null;
			cSetRef = new SetCommand(editingService.getEditingDomain(), target,
					feature, expression);
			if (cSetRef != null) {
				editingService.getEditingDomain().getCommandStack()
						.execute(cSetRef);
			}
		}
	}

	public void removeData() {

		if (target != null && feature != null) {
			// We also remove the reference to this expression, we need to
			// referee and a feature for this.
			Command cSetRef = null;
			cSetRef = new SetCommand(editingService.getEditingDomain(), target,
					feature, null);
			if (cSetRef != null) {
				editingService.getEditingDomain().getCommandStack()
						.execute(cSetRef);
			}
		}

		Command c = new RemoveCommand(editingService.getEditingDomain(),
				expressionsResource.getContents(), expression);
		editingService.getEditingDomain().getCommandStack().execute(c);

	}

	/**
	 * @return the xtextEditor
	 */
	public EmbeddedXtextEditor getXtextEditor() {
		return xtextEditor;
	}

	public boolean shouldInjectForObject(Set<CDOObject> injectionSet) {
		return false;
	}

}
