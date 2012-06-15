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

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IMessage;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.netxforge.netxstudio.common.guice.IInjectorProxy;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.LibraryPackage.Literals;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.observables.FormValidationEvent;
import com.netxforge.netxstudio.screens.editing.observables.IValidationListener;
import com.netxforge.netxstudio.screens.editing.observables.ValidationEvent;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;
import com.netxforge.netxstudio.screens.xtext.embedded.AbstractEmbeddedExpression;
import com.netxforge.netxstudio.screens.xtext.embedded.EmbeddedNonSelectionExpression;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class NewEditExpression extends AbstractScreen implements
		IDataScreenInjection, IValidationListener {
	private DataBindingContext m_bindingContext;

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtExpressionName;

	private Resource owner;
	private Expression expression;
	private Form frmExpression;
	private AbstractEmbeddedExpression exp;

	private Label lblExpressionName;

	private Object whoRefers;

	@Inject
	@Named("Netxscript")
	private IInjectorProxy injectorProxy; 
	
	/**
	 * A feature which can be passed for which this expression should be added.
	 */
	private EStructuralFeature feature;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public NewEditExpression(Composite parent, int style) {
		super(parent, style);
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

//		buildUI();
	}

	private void buildUI() {
		
		// Readonlyness.
		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmExpression = toolkit.createForm(this);
		frmExpression.setSeparatorVisible(true);
		frmExpression.setText(this.getOperationText() + "Expression");
		
		toolkit.paintBordersFor(frmExpression);

		frmExpression.getBody().setLayout(new FormLayout());

		Section sctnInfo = toolkit.createSection(frmExpression.getBody(),
				Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnInfo = new FormData();
		fd_sctnInfo.top = new FormAttachment(0, 12);
		fd_sctnInfo.bottom = new FormAttachment(0, 75);
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

		lblExpressionName = toolkit.createLabel(composite_1, "Name:", SWT.NONE);
		lblExpressionName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));

		txtExpressionName = toolkit.createText(composite_1, "New Text",
				SWT.NONE | widgetStyle);
		txtExpressionName.setText("");
		GridData gd_txtName = new GridData(SWT.LEFT, SWT.CENTER, true, false,
				1, 1);
		gd_txtName.widthHint = 200;
		txtExpressionName.setLayoutData(gd_txtName);

		FormData fd_sctnNewSection = new FormData();
		fd_sctnNewSection.top = new FormAttachment(0, 81);
		fd_sctnNewSection.bottom = new FormAttachment(100, -12);
		fd_sctnNewSection.left = new FormAttachment(0, 12);
		fd_sctnNewSection.right = new FormAttachment(100, -12);

		exp = new EmbeddedNonSelectionExpression(this.editingService,
				frmExpression.getBody(), fd_sctnNewSection, getOperation());
		exp.setXtextInjector(injectorProxy.getInjector("com.netxforge.Netxscript"));
	}

	public void injectData(Object owner, Object object) {
		injectData(owner, null, null, object);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.data.IDataScreenInjection#injectData(java.lang
	 * .Object, java.lang.Object)
	 */
	private void injectData(Object owner, Object whoRefers,
			EStructuralFeature f, Object object) {

		if (owner != null && owner instanceof Resource) {
			this.owner = (Resource) owner;
		}
		// Determine the ownership if not a resource.
		if (whoRefers != null) {
			this.whoRefers = whoRefers;
		}

		if (f != null) {
			feature = f;
		}

		if (object != null && object instanceof Expression) {
			expression = (Expression) object;
		} else {
			throw new IllegalArgumentException("Valid argument required");
		}
		
		buildUI();
		m_bindingContext = initDataBindings_();
		validationService.registerBindingContext(m_bindingContext);
		validationService.addValidationListener(this);
		exp.injectData(expression);

		if (!ScreenUtil.isReadOnlyOperation(getOperation())) {
			validationService.registerAllDecorators(txtExpressionName,
					lblExpressionName);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.data.IDataScreenInjection#addData()
	 */
	public void addData() {
		if (ScreenUtil.isNewOperation(getOperation()) && owner != null) {
			Command c = new AddCommand(editingService.getEditingDomain(),
					owner.getContents(), expression);
			editingService.getEditingDomain().getCommandStack().execute(c);
			if (whoRefers != null && feature != null) {
				// We also set the reference to this expression, we need to
				// referee and a feature for this.
				Command cSetRef = null;
				if (whoRefers instanceof EObject) {
					cSetRef = new SetCommand(editingService.getEditingDomain(),
							(EObject) whoRefers, feature, expression);
				}
				if (cSetRef != null) {
					editingService.getEditingDomain().getCommandStack()
							.execute(cSetRef);
				}
			}
		} else if (ScreenUtil.isEditOperation(getOperation())) {
			// If edit, we have been operating on a copy of the object, so we
			// have
			// to replace.

			// invalid, and we should cancel the action and warn the user.
			if (expression.cdoInvalid()) {
				MessageDialog
						.openWarning(Display.getDefault().getActiveShell(),
								"Conflict",
								"There is a conflict with another user. Your changes can't be saved.");
				return;
			}

			// Command c = new ReplaceCommand(editingService.getEditingDomain(),
			// owner.getContents(), original, expression);
			// editingService.getEditingDomain().getCommandStack().execute(c);
		}
		// After our edit, we shall be dirty
		if (editingService.isDirty()) {
			editingService.doSave(new NullProgressMonitor());
		}
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
			if (frmExpression.isDisposed()
					|| frmExpression.getHead().isDisposed()) {
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
				frmExpression.setMessage(msgBuffer.toString(), type,
						list.toArray(new IMessage[list.size()]));

			} else {
				frmExpression.setMessage(null);
			}
		}
	}

	public Form getScreenForm() {
		return frmExpression;
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

	public String getScreenName() {
		return "Expression";
	}


}
