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
import java.util.Map;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.nebula.widgets.cdatetime.CDT;
import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.netxforge.base.NonModelUtils;
import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.LibraryPackage.Literals;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.ScreenUtil;
import com.netxforge.netxstudio.screens.editing.util.IValidationListener;
import com.netxforge.netxstudio.screens.editing.util.ValidationService;
import com.netxforge.netxstudio.screens.xtext.embedded.AbstractEmbeddedExpression;
import com.netxforge.netxstudio.screens.xtext.embedded.EmbeddedNonSelectionExpression;

/**
 * <ul>
 * <li>Can edit various related expression references from the injected object</li>
 * <li>Can test the expression, with (at least) the component as context.</li>
 * </ul>
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class ObjectExpressions extends AbstractScreen implements
		IDataScreenInjection, IValidationListener {
	private DataBindingContext bindingContext;

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtExpressionName;

	private Resource owner;

	private EObject primaryContextObject;

	private Form frmExpressionTester;
	private AbstractEmbeddedExpression exp;

	private Label lblExpressionName;

	private Binding bindValue;
	private Text txtCurrentContext;
	private Text txtInterpreterLog;

	private CDateTime dateTimeTo;
	private CDateTime dateTimeFrom;

	private final DateTimeRange periodContext = GenericsFactory.eINSTANCE
			.createDateTimeRange();

	/*
	 * A list of objects, which will form the context for executing the
	 * expression. the inject object, will always be the first entry in this
	 * list.
	 */
	protected final List<Object> objects = Lists.newArrayList();

	/*
	 * A map of expression and a presentation name for the selector.
	 */
	protected final Map<String, EReference> expressionEntries = Maps
			.newHashMap();

	private TableViewer tableViewer;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public ObjectExpressions(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				validationService.dispose();
				validationService
						.removeValidationListener(ObjectExpressions.this);
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		// buildUI();
	}

	private void buildUI() {

		// Readonlyness.
		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmExpressionTester = toolkit.createForm(this);
		frmExpressionTester.setSeparatorVisible(true);
		frmExpressionTester.setText(this.getOperationText() + "Expression");

		toolkit.paintBordersFor(frmExpressionTester);

		frmExpressionTester.getBody().setLayout(new FillLayout());

		SashForm sashForm = new SashForm(frmExpressionTester.getBody(),
				SWT.VERTICAL);
		// sashForm.setLayoutData(new FormData());
		toolkit.adapt(sashForm);
		toolkit.paintBordersFor(sashForm);

		Composite cmpExpressionChoice = toolkit.createComposite(sashForm,
				SWT.NONE);
		cmpExpressionChoice.setLayout(new FormLayout());

		Label introLabel = toolkit.createLabel(cmpExpressionChoice, "",
				SWT.WRAP);

		FormData fd_formText = new FormData();

		fd_formText.bottom = new FormAttachment(0, 60);
		fd_formText.top = new FormAttachment(0, 10);
		fd_formText.left = new FormAttachment(0, 10);
		fd_formText.right = new FormAttachment(100, -12);

		introLabel.setLayoutData(fd_formText);
		introLabel
				.setText("Select the expression to edit. If an expression is not attached yet it can also be attached from here. The expression can be tested against a context. The context being edited is selected by default.");

		// SELECTOR SECTION

		Section sctnSelector = toolkit.createSection(cmpExpressionChoice,
				Section.TITLE_BAR);

		FormData fd_sctnSelector = new FormData();
		fd_sctnSelector.left = new FormAttachment(0, 10);
		fd_sctnSelector.top = new FormAttachment(introLabel, 6);
		fd_sctnSelector.bottom = new FormAttachment(100, -10);

		sctnSelector.setLayoutData(fd_sctnSelector);
		toolkit.paintBordersFor(sctnSelector);
		sctnSelector.setText("Expressions");

		Composite cmpSelector = toolkit.createComposite(sctnSelector, SWT.NONE);
		toolkit.paintBordersFor(cmpSelector);
		sctnSelector.setClient(cmpSelector);
		cmpSelector.setLayout(new FillLayout(SWT.HORIZONTAL));

		tableViewer = new TableViewer(cmpSelector, SWT.BORDER | SWT.V_SCROLL);

		Table expSelectorTable = tableViewer.getTable();

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnName = tableViewerColumn.getColumn();
		tblclmnName.setWidth(200);
		tblclmnName.setText("name");

		expSelectorTable.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// update the expression part.
				ISelection selection = tableViewer.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object firstElement = ((IStructuredSelection) selection)
							.getFirstElement();
					if (firstElement != null
							&& expressionEntries.containsKey(firstElement)) {

						EReference eref = expressionEntries.get(firstElement);
						Expression expr = (Expression) primaryContextObject
								.eGet(eref);
						if (expr != null) {
							bindExpression(bindingContext, expr);
							exp.injectData(expr);
						} else {
							// TODO, give the option to select, replace the
							// composite?
						}
					}
				}
			}
		});

		// INFO SECTION

		Section sctnInfo = toolkit.createSection(cmpExpressionChoice,
				Section.EXPANDED | Section.TITLE_BAR);
		fd_sctnSelector.right = new FormAttachment(sctnInfo, -6);
		FormData fd_sctnInfo = new FormData();
		fd_sctnInfo.top = new FormAttachment(introLabel, 6);
		fd_sctnInfo.left = new FormAttachment(0, 196);
		fd_sctnInfo.right = new FormAttachment(100, -10);
		fd_sctnInfo.bottom = new FormAttachment(0, 133);

		sctnInfo.setLayoutData(fd_sctnInfo);
		toolkit.paintBordersFor(sctnInfo);
		sctnInfo.setText("Info");

		Composite cmpInfo = toolkit.createComposite(sctnInfo, SWT.NONE);
		toolkit.paintBordersFor(cmpInfo);
		sctnInfo.setClient(cmpInfo);
		GridLayout gl_composite_1 = new GridLayout(2, false);
		gl_composite_1.horizontalSpacing = 8;
		cmpInfo.setLayout(gl_composite_1);

		lblExpressionName = toolkit.createLabel(cmpInfo, "Name:", SWT.NONE);
		lblExpressionName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));

		txtExpressionName = toolkit.createText(cmpInfo, "New Text", SWT.NONE
				| widgetStyle);
		txtExpressionName.setText("");
		GridData gd_txtName = new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1);
		// gd_txtName.widthHint = 200;
		txtExpressionName.setLayoutData(gd_txtName);

		// FORM DATA FOR EXPRESSION EDITOR

		FormData fd_sctnExpressionEditor = new FormData();
		fd_sctnExpressionEditor.top = new FormAttachment(sctnInfo, 6);
		fd_sctnExpressionEditor.bottom = new FormAttachment(100, -10);
		fd_sctnExpressionEditor.left = new FormAttachment(0, 196);
		fd_sctnExpressionEditor.right = new FormAttachment(100, -10);

		exp = new EmbeddedNonSelectionExpression(this.editingService,
				cmpExpressionChoice, fd_sctnExpressionEditor, getOperation());

		// SECTION TESTING.

		Composite cmpSashLowerPart = toolkit
				.createComposite(sashForm, SWT.NONE);
		FillLayout fl_cmpSashLowerPart = new FillLayout(SWT.HORIZONTAL);
		fl_cmpSashLowerPart.marginHeight = 10;
		fl_cmpSashLowerPart.marginWidth = 10;
		cmpSashLowerPart.setLayout(fl_cmpSashLowerPart);

		Section sctnTesting = toolkit.createSection(cmpSashLowerPart,
				Section.TITLE_BAR | Section.TWISTIE);

		toolkit.paintBordersFor(sctnTesting);
		sctnTesting.setText("Test");

		Composite cmpTesting = toolkit.createComposite(sctnTesting, SWT.NONE);
		toolkit.paintBordersFor(cmpTesting);
		sctnTesting.setClient(cmpTesting);
		cmpTesting.setLayout(new GridLayout(2, false));

		// PERIOD CONTEXT.

		buildPeriodContext(cmpTesting);

		// OBJECT CONTEXT....

		Label lblTestingContext = toolkit.createLabel(cmpTesting, "Context:",
				SWT.NONE);
		lblTestingContext.setAlignment(SWT.RIGHT);
		lblTestingContext.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));

		txtCurrentContext = toolkit.createText(cmpTesting, "New Text",
				SWT.READ_ONLY);
		txtCurrentContext.setText("");
		txtCurrentContext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1));
		new Label(cmpTesting, SWT.NONE);
		new Label(cmpTesting, SWT.NONE);

		txtInterpreterLog = new Text(cmpTesting, SWT.BORDER | SWT.WRAP
				| SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL | SWT.MULTI);
		txtInterpreterLog.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true, 2, 1));
		toolkit.adapt(txtInterpreterLog, true, true);

		Button btnRunExression = toolkit.createButton(cmpTesting, "Go!",
				SWT.NONE);
		btnRunExression.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// call the interpreter.

				// CB, replate with an Expression Service.
				// exp.testExpression(periodContext, objects.toArray());
			}
		});
		new Label(cmpTesting, SWT.NONE);

	}

	private void buildPeriodContext(Composite cmpTesting) {

		Label lblStart = toolkit.createLabel(cmpTesting, "From:", SWT.NONE);
		GridData gd_lblStart = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_lblStart.widthHint = 70;
		lblStart.setLayoutData(gd_lblStart);
		lblStart.setAlignment(SWT.RIGHT);

		dateTimeFrom = new CDateTime(cmpTesting, CDT.BORDER | CDT.DROP_DOWN
				| CDT.DATE_SHORT);
		GridData gd_dateTimeFrom = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_dateTimeFrom.widthHint = 120;
		dateTimeFrom.setLayoutData(gd_dateTimeFrom);
		dateTimeFrom.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updatePeriodContext();
			}
		});

		toolkit.adapt(dateTimeFrom);
		toolkit.paintBordersFor(dateTimeFrom);

		Label lblTo = toolkit.createLabel(cmpTesting, "To:", SWT.NONE);
		lblTo.setAlignment(SWT.RIGHT);
		GridData gd_lblTo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1,
				1);
		gd_lblTo.widthHint = 70;
		lblTo.setLayoutData(gd_lblTo);

		dateTimeTo = new CDateTime(cmpTesting, CDT.BORDER | CDT.DROP_DOWN
				| CDT.DATE_SHORT);
		GridData gd_dateTimeTo = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_dateTimeTo.widthHint = 120;
		dateTimeTo.setLayoutData(gd_dateTimeTo);
		dateTimeTo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				updatePeriodContext();
			}
		});

		toolkit.adapt(dateTimeTo);
		toolkit.paintBordersFor(dateTimeTo);
	}

	protected void updatePeriodContext() {
		periodContext.setBegin(NonModelUtils.toXMLDate(this.dateTimeFrom
				.getSelection()));
		periodContext.setEnd(NonModelUtils.toXMLDate(this.dateTimeTo
				.getSelection()));
	}

	public void injectData(Object owner, Object object) {

		if (owner != null && owner instanceof Resource) {
			this.owner = (Resource) owner;
		}

		if (object != null && object instanceof EObject) {
			primaryContextObject = (EObject) object;
			objects.add(primaryContextObject);
		} else {
			throw new IllegalArgumentException("Valid argument required");
		}

		buildUI();

		bindingContext = initDataBindings_();
		validationService.registerBindingContext(bindingContext);
		validationService.addValidationListener(this);

		if (!ScreenUtil.isReadOnlyOperation(getOperation())) {
			// validationService.registerAllDecorators(txtExpressionName,
			// lblExpressionName);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.data.IDataScreenInjection#addData()
	 */
	public void addData() {
		if (ScreenUtil.isNewOperation(getOperation()) && owner != null) {
		} else if (ScreenUtil.isEditOperation(getOperation())) {
			// invalid, and we should cancel the action and warn the user.
			if (primaryContextObject instanceof CDOObject
					&& ((CDOObject) primaryContextObject).cdoInvalid()) {
				MessageDialog
						.openWarning(Display.getDefault().getActiveShell(),
								"Conflict",
								"There is a conflict with another user. Your changes can't be saved.");
				return;
			}
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
		EMFDataBindingContext bindingContext = new EMFDataBindingContext();

		// Expression selector binding
		bindExpressionSelector(bindingContext);
		// period context binding
		bindPeriodContext(bindingContext);
		// object context binding.
		bindObjectsContext(bindingContext);

		return bindingContext;
	}

	private void bindObjectsContext(EMFDataBindingContext bindingContext2) {

	}

	private void bindExpressionSelector(EMFDataBindingContext bindingContext) {

		List<EReference> expressionEReferences = StudioUtils
				.expressionEReferences(primaryContextObject);
		for (EReference eref : expressionEReferences) {
			expressionEntries.put(eref.getName(), eref);
		}

		// set the content provider and label provider for the listviewer.
		tableViewer.setContentProvider(new ArrayContentProvider());
		tableViewer.setLabelProvider(new StyledCellLabelProvider() {

			@Override
			public void update(ViewerCell cell) {
				Object element = cell.getElement();
				EReference eReference = expressionEntries.get(element);
				Expression exp = (Expression) primaryContextObject
						.eGet(eReference);

				// Strip some words from the ref name.
				String refName = (String) element;
				String replaceAll = refName.replaceAll("(Expression|Ref)", "");
				StyledString styledString = new StyledString(
						(String) replaceAll);

				if (exp == null) {
					styledString.append(" (not set)",
							StyledString.COUNTER_STYLER);
				}

				cell.setText(styledString.getString());
				cell.setStyleRanges(styledString.getStyleRanges());

				super.update(cell);
			}
		});

		tableViewer.setInput(expressionEntries.keySet().toArray());

	}

	private void bindPeriodContext(EMFDataBindingContext bindingContext) {
		// no real databinding here.
		this.dateTimeFrom.setSelection(NonModelUtils.twoMonthsAgo());
		this.dateTimeTo.setSelection(NonModelUtils.todayAndNow());
	}

	private void bindExpression(DataBindingContext context,
			Expression expression) {

		if (bindValue != null) {
			context.removeBinding(bindValue);
		}

		EMFUpdateValueStrategy expressionStrategy = ValidationService
				.getStrategyfactory().strategyBeforeSetStringNotEmpty(
						"Expression name is required");

		IObservableValue txtNameObserveTextObserveWidget = SWTObservables
				.observeDelayedValue(400, SWTObservables.observeText(
						txtExpressionName, SWT.Modify));

		IEMFValueProperty expressionNameObserveValue_1 = EMFEditProperties
				.value(editingService.getEditingDomain(),
						Literals.EXPRESSION__NAME);
		bindValue = context.bindValue(txtNameObserveTextObserveWidget,
				expressionNameObserveValue_1.observe(expression),
				expressionStrategy, null);
		context.updateTargets();
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

	// public void handleValidationStateChange(ValidationEvent event) {
	// if (event instanceof FormValidationEvent) {
	// int type = ((FormValidationEvent) event).getMsgType();
	// List<IMessage> list = ((FormValidationEvent) event).getMessages();
	// if (frmExpressionTester.isDisposed()
	// || frmExpressionTester.getHead().isDisposed()) {
	// return;
	// }
	//
	// if (type != IMessage.NONE) {
	//
	// String errorType = "";
	// if (type == IMessage.ERROR) {
	// errorType = "Error:";
	// }
	// if (type == IMessage.WARNING) {
	// errorType = "Required:";
	// }
	//
	// StringBuffer msgBuffer = new StringBuffer();
	// msgBuffer.append(errorType + "(" + list.size() + "), "
	// + list.get(0).getMessage());
	// frmExpressionTester.setMessage(msgBuffer.toString(), type,
	// list.toArray(new IMessage[list.size()]));
	//
	// } else {
	// frmExpressionTester.setMessage(null);
	// }
	// }
	// }

	public Form getScreenForm() {
		return frmExpressionTester;
	}

	public boolean documentHasErrors(final IXtextDocument xtextDocument) {
		return (xtextDocument
				.readOnly(new IUnitOfWork<Boolean, XtextResource>() {
					public Boolean exec(XtextResource state) throws Exception {
						IParseResult parseResult = state.getParseResult();
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
		return "Expression Dialog";
	}
}
