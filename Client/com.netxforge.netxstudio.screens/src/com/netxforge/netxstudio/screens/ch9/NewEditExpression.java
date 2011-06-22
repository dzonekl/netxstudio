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

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.ReplaceCommand;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IMessage;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
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
import com.netxforge.netxstudio.library.LibraryPackage.Literals;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.observables.FormValidationEvent;
import com.netxforge.netxstudio.screens.editing.observables.IValidationListener;
import com.netxforge.netxstudio.screens.editing.observables.ValidationEvent;
import com.netxforge.netxstudio.screens.editing.observables.ValidationService;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;
import com.netxforge.netxstudio.screens.xtext.EmbeddedXtextService;
import com.netxforge.netxstudio.screens.xtext.InjectorProxy;
import com.netxforge.netxstudio.screens.xtext.embedded.EmbeddedXtextEditor;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class NewEditExpression extends AbstractScreen implements
		IDataScreenInjection, IValidationListener {
	private DataBindingContext m_bindingContext;

	private ValidationService validationService = new ValidationService();
	
	IInterpreterContextFactory interpreterContextFactory;
	
	@Inject
	ModelUtils modelUtils;
	
	
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtExpressionName;
	private EmbeddedXtextEditor editor;

	private Object owner;
	private Expression expression;
	private EObject evaluationObject = NetxscriptFactory.eINSTANCE.createMod();

	private Text txtOwner;
	private EmbeddedXtextService xtextService;

	private Form frmNewForm;

	private Expression original;

	private final Injector netxScriptInjector;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public NewEditExpression(Composite parent, int style) {
		super(parent, style);

		int widgetStyle = SWT.None;
		if (Screens.isReadOnlyOperation(getOperation())) {
			widgetStyle |= SWT.READ_ONLY;
		}

		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				validationService.dispose();
				validationService
						.removeValidationListener(NewEditExpression.this);
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);

		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmNewForm = toolkit.createForm(this);
		frmNewForm.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmNewForm);

		// Screen title
		String title = "";
		if (Screens.isNewOperation(getOperation())) {
			title = "New";
		} else if (Screens.isEditOperation(style)) {
			title = "Edit";
		} else if (Screens.isReadOnlyOperation(style)) {
			title = "Read-Only";
		}
		frmNewForm.setText(title);
		frmNewForm.getBody().setLayout(new FormLayout());

		Section sctnInfo = toolkit.createSection(frmNewForm.getBody(),
				Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnInfo = new FormData();
		fd_sctnInfo.top = new FormAttachment(0, 12);
		fd_sctnInfo.bottom = new FormAttachment(0, 102);
		fd_sctnInfo.right = new FormAttachment(100, -12);
		fd_sctnInfo.left = new FormAttachment(0, 12);
		sctnInfo.setLayoutData(fd_sctnInfo);
		toolkit.paintBordersFor(sctnInfo);
		sctnInfo.setText("Info");

		Composite composite_1 = toolkit.createComposite(sctnInfo, SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnInfo.setClient(composite_1);
		GridLayout gl_composite_1 = new GridLayout(2, false);
		gl_composite_1.horizontalSpacing = 8;
		composite_1.setLayout(gl_composite_1);

		Label lblExpressionName = toolkit.createLabel(composite_1, "Name:",
				SWT.NONE);
		lblExpressionName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));

		txtExpressionName = toolkit.createText(composite_1, "New Text",
				SWT.NONE | widgetStyle);
		txtExpressionName.setText("");
		GridData gd_txtName = new GridData(SWT.LEFT, SWT.CENTER, true, false,
				1, 1);
		gd_txtName.widthHint = 200;
		txtExpressionName.setLayoutData(gd_txtName);

		Hyperlink hprlnkAddTo = toolkit.createHyperlink(composite_1,
				"Select Owner:", SWT.NONE);
		hprlnkAddTo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		toolkit.paintBordersFor(hprlnkAddTo);

		txtOwner = toolkit.createText(composite_1, "New Text", SWT.NONE
				| widgetStyle);
		txtOwner.setText("");
		GridData gd_txtOwner = new GridData(SWT.LEFT, SWT.CENTER, true, false,
				1, 1);
		gd_txtOwner.widthHint = 200;
		txtOwner.setLayoutData(gd_txtOwner);

		Section sctnNewSection = toolkit.createSection(frmNewForm.getBody(),
				Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnNewSection = new FormData();
		fd_sctnNewSection.top = new FormAttachment(sctnInfo, 6);
		fd_sctnNewSection.bottom = new FormAttachment(100, -12);
		fd_sctnNewSection.left = new FormAttachment(0, 12);
		fd_sctnNewSection.right = new FormAttachment(100, -12);
		sctnNewSection.setLayoutData(fd_sctnNewSection);
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
		
		interpreterContextFactory = netxScriptInjector.getInstance(IInterpreterContextFactory.class);
		
		
		// Injector injector =
		// ArithmeticsActivator.getInstance().getInjector("org.eclipse.xtext.example.arithmetics.Arithmetics");
		Composite editorComposite = toolkit.createComposite(client, SWT.BORDER);
		GridLayout gl_editorComposite = new GridLayout();
		gl_editorComposite.marginHeight = 0;
		gl_editorComposite.marginWidth = 0;
		editorComposite.setLayout(gl_editorComposite);
		editor = new EmbeddedXtextEditor(editorComposite, netxScriptInjector, SWT.BORDER
				| widgetStyle);
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
		
		ImageHyperlink mghprlnkTest = toolkit.createImageHyperlink(sctnNewSection, SWT.NONE);
		mghprlnkTest.addHyperlinkListener(new IHyperlinkListener() {
			
			// FIXME, PROPER, ERROR HANDLING. 
			
			public void linkActivated(HyperlinkEvent e) {
				// Launch the interpreter, with a given context.
				
				// NOTE, for testing, the period context is always last week. 
				DateTimeRange timeRange = GenericsFactory.eINSTANCE.createDateTimeRange();
				
				XMLGregorianCalendar t0 = modelUtils.toXMLDate(modelUtils.todayAndNow());
				XMLGregorianCalendar t1 = modelUtils.toXMLDate(modelUtils.lastWeek());
				
				timeRange.setBegin(t1);
				timeRange.setEnd(t0);
				
				IInterpreterContext periodContext = interpreterContextFactory.createPeriodContext(timeRange);
				
				List<IInterpreterContext> contextList = ImmutableList.of(periodContext);
				IInterpreterContext[] contextArray = new IInterpreterContext[contextList.size()];
				final IInterpreter i = netxScriptInjector.getInstance(IInterpreter.class);
				i.setContext(contextList.toArray(contextArray));
				
				IXtextDocument doc = editor.getDocument();
				if (documentHasErrors(doc)) {
					System.out
							.println("Intepreter cancelled, as errors exist in script: "
									+ doc.get());
				}
				@SuppressWarnings("unused")
				String rootElementName = doc
						.readOnly(new IUnitOfWork<String, XtextResource>() {
							
							// Note: Expression scoping i.e. 'mod' or 'def' are optional.  
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
									Function root = (Function) resource.getContents().get(0);
									i.evaluate(root);
								}
								
								
								return null;
							}
						});
				
			}
			public void linkEntered(HyperlinkEvent e) {
			}
			public void linkExited(HyperlinkEvent e) {
			}
		});
		toolkit.paintBordersFor(mghprlnkTest);
		sctnNewSection.setTextClient(mghprlnkTest);
		mghprlnkTest.setText("Test Run");
		xtextService = new EmbeddedXtextService(editingService);

		// Conditional

		if (!Screens.isReadOnlyOperation(getOperation())) {
			validationService.registerAllDecorators(txtExpressionName,
					lblExpressionName);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.data.IDataScreenInjection#injectData(java.lang
	 * .Object, java.lang.Object)
	 */
	public void injectData(Object owner, Object object) {
		this.owner = owner;
		if (object != null && object instanceof Expression) {
			if (Screens.isEditOperation(getOperation())) {
				Expression copy = EcoreUtil.copy((Expression) object);
				expression = copy;
				original = (Expression) object;
			} else {
				if (Screens.isNewOperation(getOperation())
						|| Screens.isReadOnlyOperation(getOperation())) {
					expression = (Expression) object;
				}
			}

			String asString = xtextService.getAsString(expression);
			editor.update(this.evaluationObject, asString == null ? ""
					: asString);
		}

		m_bindingContext = initDataBindings_();
		validationService.registerBindingContext(m_bindingContext);
		validationService.addValidationListener(this);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.data.IDataScreenInjection#addData()
	 */
	public void addData() {
		if (Screens.isNewOperation(getOperation()) && owner != null) {
			Command c = new AddCommand(editingService.getEditingDomain(),
					(EList<?>) owner, expression);
			editingService.getEditingDomain().getCommandStack().execute(c);
		} else if (Screens.isEditOperation(getOperation())) {
			// If edit, we have been operating on a copy of the object, so we
			// have
			// to replace.

			// invalid, and we should cancel the action and warn the user.
			if (original.cdoInvalid()) {
				MessageDialog
						.openWarning(Display.getDefault().getActiveShell(),
								"Conflict",
								"There is a conflict with another user. Your changes can't be saved.");
				return;
			}

			Command c = new ReplaceCommand(editingService.getEditingDomain(),
					(EList<?>) owner, original, expression);
			editingService.getEditingDomain().getCommandStack().execute(c);

		}
		// After our edit, we shall be dirty
		if (editingService.isDirty()) {
			editingService.doSave(new NullProgressMonitor());
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

		Button button = toolkit.createButton(keyPadComposite, "+", SWT.NONE);
		GridData gd_button = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_button.widthHint = 18;
		gd_button.heightHint = 18;
		button.setLayoutData(gd_button);

		Button btnTrue = toolkit
				.createButton(keyPadComposite, "TRUE", SWT.NONE);
		btnTrue.setFont(SWTResourceManager.getFont("Lucida Grande", 9,
				SWT.NORMAL));
		GridData gd_btnTrue = new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1);
		gd_btnTrue.widthHint = 36;
		gd_btnTrue.heightHint = 18;
		btnTrue.setLayoutData(gd_btnTrue);

		Button button_6 = toolkit.createButton(keyPadComposite, "==", SWT.NONE);
		GridData gd_button_6 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_button_6.widthHint = 24;
		gd_button_6.heightHint = 18;
		button_6.setLayoutData(gd_button_6);
		new Label(keyPadComposite, SWT.NONE);

		Composite composite = toolkit.createComposite(keyPadComposite,
				SWT.NO_BACKGROUND | SWT.NO_FOCUS);
		GridData gd_composite = new GridData(SWT.LEFT, SWT.FILL, false, false,
				1, 3);
		gd_composite.widthHint = 18;
		gd_composite.heightHint = 18;
		composite.setLayoutData(gd_composite);
		toolkit.paintBordersFor(composite);

		Button button_1 = toolkit.createButton(keyPadComposite, "-", SWT.NONE);
		GridData gd_button_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_button_1.widthHint = 18;
		gd_button_1.heightHint = 18;
		button_1.setLayoutData(gd_button_1);

		Button btnFalse = toolkit.createButton(keyPadComposite, "FALSE",
				SWT.NONE);
		GridData gd_btnFalse = new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1);
		gd_btnFalse.widthHint = 36;
		gd_btnFalse.heightHint = 18;
		btnFalse.setLayoutData(gd_btnFalse);
		btnFalse.setFont(SWTResourceManager.getFont("Lucida Grande", 9,
				SWT.NORMAL));

		Button button_11 = toolkit
				.createButton(keyPadComposite, "!=", SWT.NONE);
		GridData gd_button_11 = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_button_11.widthHint = 24;
		gd_button_11.heightHint = 18;
		button_11.setLayoutData(gd_button_11);
		new Label(keyPadComposite, SWT.NONE);

		Button button_3 = toolkit.createButton(keyPadComposite, "/", SWT.NONE);
		GridData gd_button_3 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_button_3.widthHint = 18;
		gd_button_3.heightHint = 18;
		button_3.setLayoutData(gd_button_3);

		Button btnAnd = toolkit.createButton(keyPadComposite, "AND", SWT.NONE);
		btnAnd.setFont(SWTResourceManager.getFont("Lucida Grande", 9,
				SWT.NORMAL));
		GridData gd_btnAnd = new GridData(SWT.CENTER, SWT.CENTER, false, false,
				1, 1);
		gd_btnAnd.widthHint = 36;
		gd_btnAnd.heightHint = 18;
		btnAnd.setLayoutData(gd_btnAnd);

		Button button_9 = toolkit.createButton(keyPadComposite, ">=", SWT.NONE);
		GridData gd_button_9 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_button_9.widthHint = 24;
		gd_button_9.heightHint = 18;
		button_9.setLayoutData(gd_button_9);
		new Label(keyPadComposite, SWT.NONE);

		Button button_2 = toolkit.createButton(keyPadComposite, "*", SWT.NONE);
		GridData gd_button_2 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_button_2.widthHint = 18;
		gd_button_2.heightHint = 18;
		button_2.setLayoutData(gd_button_2);

		Button btnOr = toolkit.createButton(keyPadComposite, "OR", SWT.NONE);
		btnOr.setFont(SWTResourceManager
				.getFont("Lucida Grande", 9, SWT.NORMAL));
		GridData gd_btnOr = new GridData(SWT.CENTER, SWT.CENTER, false, false,
				1, 1);
		gd_btnOr.widthHint = 36;
		gd_btnOr.heightHint = 18;
		btnOr.setLayoutData(gd_btnOr);

		Button button_10 = toolkit
				.createButton(keyPadComposite, "<=", SWT.NONE);
		GridData gd_button_10 = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_button_10.widthHint = 24;
		gd_button_10.heightHint = 18;
		button_10.setLayoutData(gd_button_10);
		new Label(keyPadComposite, SWT.NONE);
		new Label(keyPadComposite, SWT.NONE);

		Button button_4 = toolkit.createButton(keyPadComposite, "%", SWT.NONE);
		GridData gd_button_4 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_button_4.heightHint = 18;
		gd_button_4.widthHint = 18;
		button_4.setLayoutData(gd_button_4);

		Button btnNot = toolkit.createButton(keyPadComposite, "NOT", SWT.NONE);
		btnNot.setFont(SWTResourceManager.getFont("Lucida Grande", 9,
				SWT.NORMAL));
		GridData gd_btnNot = new GridData(SWT.CENTER, SWT.CENTER, false, false,
				1, 1);
		gd_btnNot.widthHint = 36;
		gd_btnNot.heightHint = 18;
		btnNot.setLayoutData(gd_btnNot);

		Button button_7 = toolkit.createButton(keyPadComposite, ">", SWT.NONE);
		GridData gd_button_7 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_button_7.widthHint = 24;
		gd_button_7.heightHint = 18;
		button_7.setLayoutData(gd_button_7);
		new Label(keyPadComposite, SWT.NONE);
		new Label(keyPadComposite, SWT.NONE);

		Button button_5 = toolkit.createButton(keyPadComposite, "=", SWT.NONE);
		GridData gd_button_5 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_button_5.widthHint = 18;
		gd_button_5.heightHint = 18;
		button_5.setLayoutData(gd_button_5);
		new Label(keyPadComposite, SWT.NONE);

		Button button_8 = toolkit.createButton(keyPadComposite, "<", SWT.NONE);
		GridData gd_button_8 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_button_8.widthHint = 24;
		gd_button_8.heightHint = 18;
		button_8.setLayoutData(gd_button_8);
		new Label(keyPadComposite, SWT.NONE);
		new Label(keyPadComposite, SWT.NONE);

	}

	/**
	 * Converted to new EMF API.
	 * 
	 * @return
	 */
	public EMFDataBindingContext initDataBindings_() {

		EMFUpdateValueStrategy expressionStrategy = validationService
				.getUpdateValueStrategyBeforeSet("Expression name is required");

		EMFDataBindingContext bindingContext = new EMFDataBindingContext();

		IObservableValue txtNameObserveTextObserveWidget = SWTObservables
				.observeDelayedValue(400, SWTObservables.observeText(
						txtExpressionName, SWT.Modify));

		IEMFValueProperty expressionNameObserveValue_1 = EMFEditProperties
				.value(editingService.getEditingDomain(),
						Literals.EXPRESSION__NAME);
		bindingContext.bindValue(txtNameObserveTextObserveWidget,
				expressionNameObserveValue_1.observe(expression),
				expressionStrategy, null);

		// TODO, For the references, we need some sort of custom binding.
		// The .edit label provider would need.
		return bindingContext;
	}

	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue txtNameObserveTextObserveWidget = SWTObservables
				.observeDelayedValue(400, SWTObservables.observeText(
						txtExpressionName, SWT.Modify));
		IObservableValue expressionNameObserveValue = EMFObservables
				.observeValue(expression, Literals.EXPRESSION__NAME);
		bindingContext.bindValue(txtNameObserveTextObserveWidget,
				expressionNameObserveValue, null, null);
		//
		return bindingContext;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.ui.viewer.IViewerProvider#getViewer()
	 */
	public Viewer getViewer() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.screens.editing.selector.IScreen#isValid()
	 */
	public boolean isValid() {
		return validationService.isValid();
	}

	public void handleValidationStateChange(ValidationEvent event) {
		if (event instanceof FormValidationEvent) {
			int type = ((FormValidationEvent) event).getMsgType();
			List<IMessage> list = ((FormValidationEvent) event).getMessages();
			if (frmNewForm.isDisposed() || frmNewForm.getHead().isDisposed()) {
				return;
			}

			if (type != IMessage.NONE) {

				String errorType = "";
				if (type == IMessage.ERROR) {
					errorType = "Error:";
				}
				if (type == IMessage.WARNING) {
					errorType = "Required:";
				}

				StringBuffer msgBuffer = new StringBuffer();
				msgBuffer.append(errorType + "(" + list.size() + "), "
						+ list.get(0).getMessage());
				frmNewForm.setMessage(msgBuffer.toString(), type,
						list.toArray(new IMessage[list.size()]));

			} else {
				frmNewForm.setMessage(null);
			}
		}
	}

	@Override
	public Form getScreenForm() {
		// TODO Auto-generated method stub
		return null;
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
	
}
