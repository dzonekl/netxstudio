package com.netxforge.netxstudio.screens.f2;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.google.inject.Inject;
import com.netxforge.netxstudio.library.LevelKind;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.Tolerance;
import com.netxforge.netxstudio.screens.common.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;
import com.netxforge.netxstudio.screens.xtext.IInjectorProxy;
import com.netxforge.netxstudio.screens.xtext.embedded.EmbeddedSelectionExpression;

public class NewEditTolerance extends AbstractScreen implements
		IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtName;
	private Form frmNewTolerance;
	private Resource owner;
	private Tolerance tolerance;
	@SuppressWarnings("unused")
	private EMFDataBindingContext m_bindingContext;
	private ComboViewer cmbLevelViewer;
//	private Text txtExpression;
	private EmbeddedSelectionExpression embeddedExpression;
	
	@Inject
	private IInjectorProxy injectorProxy;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public NewEditTolerance(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		// buildUI();
	}

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		// Readonlyness.
		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		frmNewTolerance = toolkit.createForm(this);
		frmNewTolerance.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmNewTolerance);

		frmNewTolerance.setText(this.getOperationText() + " Tolerance");
		frmNewTolerance.getBody().setLayout(new ColumnLayout());

		Section sctnMappings = toolkit.createSection(frmNewTolerance.getBody(),
				Section.EXPANDED | Section.TITLE_BAR);
//		FormData fd_sctnMappings = new FormData();
//		fd_sctnMappings.bottom = new FormAttachment(100, -10);
//		fd_sctnMappings.left = new FormAttachment(0, 10);
//		fd_sctnMappings.top = new FormAttachment(0, 10);
//		fd_sctnMappings.right = new FormAttachment(100, -14);
//		sctnMappings.setLayoutData(fd_sctnMappings);
		toolkit.paintBordersFor(sctnMappings);
		sctnMappings.setText("Info");

		Composite composite_1 = toolkit.createComposite(sctnMappings, SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnMappings.setClient(composite_1);
		composite_1.setLayout(new GridLayout(4, false));

		Label lblName = toolkit.createLabel(composite_1, "Name:", SWT.NONE);
		lblName.setAlignment(SWT.RIGHT);
		GridData gd_lblName = new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1);
		gd_lblName.widthHint = 83;
		lblName.setLayoutData(gd_lblName);

		txtName = toolkit.createText(composite_1, "New Text", widgetStyle);
		txtName.setText("");
		GridData gd_txtName = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_txtName.widthHint = 150;
		txtName.setLayoutData(gd_txtName);
		new Label(composite_1, SWT.NONE);
		new Label(composite_1, SWT.NONE);

		Label lblLevel = toolkit.createLabel(composite_1, "Level:", SWT.NONE);
		lblLevel.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false,
				1, 1));

		cmbLevelViewer = new ComboViewer(composite_1, widgetStyle);
		Combo cmbToleranceLevel = cmbLevelViewer.getCombo();
		cmbToleranceLevel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1,
				1));
		toolkit.paintBordersFor(cmbToleranceLevel);
		new Label(composite_1, SWT.NONE);
		new Label(composite_1, SWT.NONE);
		
	
		
		
//		Label lblExpression = toolkit.createLabel(composite_1, "Expression:",
//				SWT.NONE);
//		lblExpression.setAlignment(SWT.RIGHT);
//		lblExpression.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
//				false, 1, 1));
		
		
		embeddedExpression = new EmbeddedSelectionExpression(this.editingService,
				frmNewTolerance.getBody(), null, getOperation());
		embeddedExpression.setXtextInjector(injectorProxy.getInjector("com.netxforge.Netxscript"));
		embeddedExpression.injectData("Tolerance", tolerance,
				LibraryPackage.Literals.TOLERANCE__EXPRESSION_REF);
		
//		txtExpression = toolkit.createText(composite_1, "New Text",
//				SWT.READ_ONLY);
//		txtExpression.setText("");
//		txtExpression.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
//				false, 1, 1));
//
//		ImageHyperlink imageHyperlink = toolkit.createImageHyperlink(
//				composite_1, SWT.NONE);
//		imageHyperlink.addHyperlinkListener(new IHyperlinkListener() {
//			public void linkActivated(HyperlinkEvent e) {
//				Expression exp = tolerance.getExpressionRef();
//				if(exp != null){
//					// sort of history.
//					Command rc = new SetCommand(editingService.getEditingDomain(),
//							tolerance,
//							LibraryPackage.Literals.TOLERANCE__EXPRESSION_REF, null);
//					editingService.getEditingDomain().getCommandStack().execute(rc);
//				}
//			}
//
//			public void linkEntered(HyperlinkEvent e) {
//			}
//
//			public void linkExited(HyperlinkEvent e) {
//			}
//		});
//		GridData gd_imageHyperlink = new GridData(SWT.LEFT, SWT.CENTER, false,
//				false, 1, 1);
//		gd_imageHyperlink.widthHint = 18;
//		imageHyperlink.setLayoutData(gd_imageHyperlink);
//		imageHyperlink.setImage(ResourceManager.getPluginImage(
//				"org.eclipse.ui", "/icons/full/etool16/delete.gif"));
//		toolkit.paintBordersFor(imageHyperlink);
//		imageHyperlink.setText("");
//
//		Button btnSelect = toolkit.createButton(composite_1, "Select...",
//				SWT.NONE);
//		btnSelect.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				Resource expressionResource = editingService
//						.getData(LibraryPackage.Literals.EXPRESSION);
//				ExpressionFilterDialog dialog = new ExpressionFilterDialog(
//						NewEditTolerance.this.getShell(), expressionResource);
//				if (dialog.open() == IDialogConstants.OK_ID) {
//					Expression expression = (Expression) dialog
//							.getFirstResult();
//					Command c = new SetCommand(editingService
//							.getEditingDomain(), tolerance,
//							LibraryPackage.Literals.TOLERANCE__EXPRESSION_REF,
//							expression);
//					editingService.getEditingDomain().getCommandStack()
//							.execute(c);
//				}
//			}
//		});
		
		
		if(readonly){
			cmbToleranceLevel.setEnabled(false);
		}
		
		
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = new EMFDataBindingContext();

		IObservableValue nameObservable = SWTObservables.observeText(txtName,
				SWT.Modify);

//		IObservableValue expressionObservable = SWTObservables.observeText(
//				this.txtExpression, SWT.Modify);

		IEMFValueProperty nameProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.TOLERANCE__NAME);

//		IEMFValueProperty expressionProperty = EMFEditProperties.value(
//				editingService.getEditingDomain(), FeaturePath.fromList(
//						LibraryPackage.Literals.TOLERANCE__EXPRESSION_REF,
//						LibraryPackage.Literals.EXPRESSION__NAME));

		context.bindValue(nameObservable, nameProperty.observe(tolerance),
				null, null);

//		context.bindValue(expressionObservable,
//				expressionProperty.observe(tolerance), null, null);

		// Also bind the embedded expression. 
		embeddedExpression.bind(context);
		
		
		cmbLevelViewer.setContentProvider(new ArrayContentProvider());
		cmbLevelViewer.setLabelProvider(new LabelProvider());
		cmbLevelViewer.setInput(LevelKind.VALUES);

		IEMFValueProperty toleranceLevelProperty = EMFEditProperties
				.value(editingService.getEditingDomain(), LibraryPackage.Literals.TOLERANCE__LEVEL);
		IValueProperty selectionProperty = ViewerProperties.singleSelection();
		
		context.bindValue(selectionProperty.observe(cmbLevelViewer),
				toleranceLevelProperty.observe(tolerance), null, null);

		// And something for the expressions.

		return context;
	}

	public void injectData(Object owner, Object object) {
		if (owner instanceof Resource) {
			this.owner = (Resource) owner;
		} else {
			// We need the right type of object for this screen.
			throw new java.lang.IllegalArgumentException();
		}
		if (object != null && object instanceof Tolerance) {
			tolerance = (Tolerance) object;
		} else {
			// We need the right type of object for this screen.
			throw new java.lang.IllegalArgumentException();
		}
		buildUI();
		m_bindingContext = initDataBindings_();
	}

	public void addData() {
		if (ScreenUtil.isNewOperation(getOperation()) && owner != null) {
			// If new, we have been operating on an object not added yet.
			Command c;

			c = new AddCommand(editingService.getEditingDomain(),
					owner.getContents(), tolerance);

			editingService.getEditingDomain().getCommandStack().execute(c);
		} else if (ScreenUtil.isEditOperation(getOperation())) {
			// If edit, we have been operating on a copy of the object, so we
			// have to replace. However if our original object is invalid, this
			// will
			// cause invalidity, so the action will not occure in case the
			// original is
			// invalid, and we should cancel the action and warn the user.
			if (tolerance.cdoInvalid()) {
				MessageDialog
						.openWarning(Display.getDefault().getActiveShell(),
								"Conflict",
								"There is a conflict with another user. Your changes can't be saved.");
				return;
			}
			System.out.println(tolerance.cdoID() + "" + tolerance.cdoState());

		}
		// After our edit, we shall be dirty
		if (editingService.isDirty()) {
			editingService.doSave(new NullProgressMonitor());
		}
	}

	public Viewer getViewer() {
		return null;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	public Form getScreenForm() {
		return frmNewTolerance;
	}

	public void disposeData() {
		// N/A
	}

	public String getScreenName() {
		return "Tolerance";
	}

}
