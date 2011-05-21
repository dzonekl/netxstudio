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

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.jface.databinding.swt.SWTObservables;
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
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;

import com.google.inject.Injector;
import com.netxforge.netxscript.NetxscriptFactory;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.LibraryPackage.Literals;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.observables.ValidationService;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.IScreen;
import com.netxforge.netxstudio.screens.editing.selector.Screens;
import com.netxforge.netxstudio.screens.xtext.EmbeddedXtextService;
import com.netxforge.netxstudio.screens.xtext.InjectorProxy;
import com.netxforge.netxstudio.screens.xtext.embedded.EmbeddedXtextEditor;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class NewEditExpression extends Composite implements
		IDataScreenInjection, IScreen {
	@SuppressWarnings("unused")
	private DataBindingContext m_bindingContext;
	
	private ValidationService validationService = new ValidationService(); 
	
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtName;
	private EmbeddedXtextEditor editor;

	private int operation;
	private IEditingService editingService;
	private Object owner;
	private Expression expression;
	private EObject evaluationObject = NetxscriptFactory.eINSTANCE.createModel();
	
	private Text txtOwner;
	private EmbeddedXtextService xtextService;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public NewEditExpression(Composite parent, int style) {
		this(parent, style, null);
	}

	public NewEditExpression(Composite parent, int style,
			IEditingService eService) {
		super(parent, SWT.BORDER);

		operation = style & 0xFF00; // Ignore first bits, as we piggy back on
									// the SWT style.
		this.editingService = eService;

		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);

		setLayout(new FillLayout(SWT.HORIZONTAL));

		Form frmNewForm = toolkit.createForm(this);
		frmNewForm.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmNewForm);

		String title = Screens.isNewOperation(operation) ? "New" : "Edit";

		frmNewForm.setText(title);
		frmNewForm.getBody().setLayout(new FormLayout());

		Composite composite = toolkit.createComposite(frmNewForm.getBody(),
				SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		FormData fd_composite = new FormData();
		fd_composite.bottom = new FormAttachment(0, 16);
		fd_composite.right = new FormAttachment(100);
		fd_composite.top = new FormAttachment(0);
		fd_composite.left = new FormAttachment(0);
		composite.setLayoutData(fd_composite);
		toolkit.paintBordersFor(composite);

		Label lblNewLabel = toolkit.createLabel(composite,
				"Data Entry Feedback", SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(154, 205, 50));
		lblNewLabel.setAlignment(SWT.CENTER);

		Section sctnInfo = toolkit.createSection(frmNewForm.getBody(),
				Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnInfo = new FormData();
		fd_sctnInfo.top = new FormAttachment(composite, 12);
		fd_sctnInfo.bottom = new FormAttachment(0, 120);
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

		Label lblLogin = toolkit.createLabel(composite_1, "Name:", SWT.NONE);
		lblLogin.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		txtName = toolkit.createText(composite_1, "New Text", SWT.NONE);
		txtName.setText("");
		GridData gd_txtName = new GridData(SWT.LEFT, SWT.CENTER, true, false,
				1, 1);
		gd_txtName.widthHint = 200;
		txtName.setLayoutData(gd_txtName);

		Hyperlink hprlnkAddTo = toolkit.createHyperlink(composite_1,
				"Select Owner:", SWT.NONE);
		hprlnkAddTo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		toolkit.paintBordersFor(hprlnkAddTo);

		txtOwner = toolkit.createText(composite_1, "New Text", SWT.NONE);
		txtOwner.setText("");
		GridData gd_txtOwner = new GridData(SWT.LEFT, SWT.CENTER, true, false,
				1, 1);
		gd_txtOwner.widthHint = 200;
		txtOwner.setLayoutData(gd_txtOwner);

		Section sctnNewSection = toolkit.createSection(frmNewForm.getBody(),
				Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnNewSection = new FormData();
		fd_sctnNewSection.bottom = new FormAttachment(100, -12);
		fd_sctnNewSection.right = new FormAttachment(sctnInfo, 0, SWT.RIGHT);
		fd_sctnNewSection.top = new FormAttachment(sctnInfo);
		fd_sctnNewSection.left = new FormAttachment(0, 12);
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

		Injector injector = InjectorProxy
				.getInjector("com.netxforge.Netxscript");
		// Injector injector =
		// ArithmeticsActivator.getInstance().getInjector("org.eclipse.xtext.example.arithmetics.Arithmetics");
		Composite editorComposite = toolkit.createComposite(client, SWT.BORDER);
		GridLayout gl_editorComposite = new GridLayout();
		gl_editorComposite.marginHeight = 0;
		gl_editorComposite.marginWidth = 0;
		editorComposite.setLayout(gl_editorComposite);
		editor = new EmbeddedXtextEditor(editorComposite, injector, SWT.BORDER);
		editor.getDocument().addModelListener(new IXtextModelListener() {
			public void modelChanged(XtextResource resource) {
				evaluationObject = xtextService.reconcileChangedModel(expression, editor);
			}
		});
		editorComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true));
		this.createKeyPad(client);
		sctnNewSection.setClient(client);
		xtextService = new EmbeddedXtextService(editingService);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.editing.selector.IScreen#getOperation()
	 */
	public int getOperation() {
		return operation;
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
			expression = (Expression) object;
			String asString = xtextService.getAsString(expression);
			editor.update(this.evaluationObject,
					asString == null ? "" : asString);

		}
		 m_bindingContext = initDataBindings_();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.data.IDataScreenInjection#addData()
	 */
	public void addData() {
		if (Screens.isNewOperation(operation) && owner != null) {
			Command c = new AddCommand(editingService.getEditingDomain(),
					(EList<?>) owner, expression);
			editingService.getEditingDomain().getCommandStack().execute(c);
		}else{
			// Databinding has done it's work. Don't need to do anything. 
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
		GridLayout gl_composite_3 = new GridLayout(2, false);
		gl_composite_3.marginRight = 5;
		gl_composite_3.marginLeft = 5;
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

		Button button_1 = toolkit.createButton(keyPadComposite, "-", SWT.NONE);
		GridData gd_button_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_button_1.widthHint = 18;
		gd_button_1.heightHint = 18;
		button_1.setLayoutData(gd_button_1);

		Button button_2 = toolkit.createButton(keyPadComposite, "*", SWT.NONE);
		GridData gd_button_2 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_button_2.widthHint = 18;
		gd_button_2.heightHint = 18;
		button_2.setLayoutData(gd_button_2);
		new Label(keyPadComposite, SWT.NONE);
		
	}
	
	/**
	 * Converted to new EMF API. 
	 * @return
	 */
	protected DataBindingContext initDataBindings_() {
		DataBindingContext bindingContext = new DataBindingContext();
		
		IObservableValue txtNameObserveTextObserveWidget = SWTObservables.observeDelayedValue(400, SWTObservables.observeText(txtName, SWT.Modify));
		
		IEMFValueProperty expressionNameObserveValue_1 = EMFEditProperties.value(
				editingService.getEditingDomain(), Literals.EXPRESSION__NAME);
		bindingContext.bindValue(txtNameObserveTextObserveWidget, expressionNameObserveValue_1.observe(expression), null, null);
	
		// TODO, For the references, we need some sort of custom binding.
		// The .edit label provider would need. 
		return bindingContext;
	}
	
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue txtNameObserveTextObserveWidget = SWTObservables.observeDelayedValue(400, SWTObservables.observeText(txtName, SWT.Modify));
		IObservableValue expressionNameObserveValue = EMFObservables.observeValue(expression, Literals.EXPRESSION__NAME);
		bindingContext.bindValue(txtNameObserveTextObserveWidget, expressionNameObserveValue, null, null);
		//
		return bindingContext;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.ui.viewer.IViewerProvider#getViewer()
	 */
	public Viewer getViewer() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.screens.editing.selector.IScreen#isValid()
	 */
	public boolean isValid() {
		return validationService.isValid();
	}
}
