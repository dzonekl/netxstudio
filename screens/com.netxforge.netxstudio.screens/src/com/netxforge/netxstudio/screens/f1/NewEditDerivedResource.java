/*******************************************************************************
 * Copyright (c) Jul 11, 2011 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.screens.f1;

import java.util.Date;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
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
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.Section;

import com.netxforge.base.NonModelUtils;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.Unit;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.dialog.UnitFilterDialog;
import com.netxforge.netxstudio.services.DerivedResource;
import com.netxforge.netxstudio.services.ServiceProfile;
import com.netxforge.screens.editing.base.IDataScreenInjection;
import com.netxforge.screens.editing.base.ScreenUtil;

public class NewEditDerivedResource extends AbstractScreen implements
		IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtShortName;
	private Text txtLongName;
	private Text txtExpressionName;
	private Text txtUnit;
	private DerivedResource derivedResource;
	private Form frmResource;
	private ServiceProfile owner;
	private Table table;
	private TableViewer valuesTableViewer;
//	private Hyperlink hprlnkDaily;
//	private Hyperlink hprlnkWeekly;
//	private Hyperlink hprlnkMonthly;
	private Hyperlink hprlnkValues;
//	private static final int CAPACITIES = -100;
//	private static final int UTILIZATION = -200;
//	private Hyperlink hprlnkCapcity;
//	private Hyperlink hprlnkUtilization;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public NewEditDerivedResource(Composite parent, int style) {
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

		// Readonlyness.
		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmResource = toolkit.createForm(this);
		frmResource.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmResource);
		frmResource.setText(this.getOperationText() + "Resource");
		frmResource.getBody().setLayout(new FormLayout());

////		FormText formText = toolkit
////				.createFormText(frmResource.getBody(), false);
////		FormData fd_formText = new FormData();
////		fd_formText.right = new FormAttachment(0, 820);
////		fd_formText.top = new FormAttachment(0, 5);
////		fd_formText.left = new FormAttachment(0, 5);
////		formText.setLayoutData(fd_formText);
//		// FormData fd_formText = new FormData();
//		// fd_formText.bottom = new FormAttachment(0, 46);
//		// fd_formText.right = new FormAttachment(100, -12);
//		// fd_formText.top = new FormAttachment(0, 12);
//		// fd_formText.left = new FormAttachment(0, 12);
//		// formText.setLayoutData(fd_formText);
//		toolkit.paintBordersFor(formText);
//		formText.setText(
//				"<form><p> A resource is either created from a Metric by the <b>M</b>etric <b>C</b>ollection <b>E</b>ngine or a resource is defined manually and populated by an Expression</p></form>",
//				true, false);

		Section sctnInfo = toolkit.createSection(frmResource.getBody(),
				Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnInfo = new FormData();
		fd_sctnInfo.right = new FormAttachment(100, -10);
		fd_sctnInfo.top = new FormAttachment(0, 23);
		fd_sctnInfo.left = new FormAttachment(0, 5);
		sctnInfo.setLayoutData(fd_sctnInfo);
		// FormData fd_sctnInfo = new FormData();
		// fd_sctnInfo.top = new FormAttachment(formText, 15);
		// fd_sctnInfo.bottom = new FormAttachment(100, -12);
		// fd_sctnInfo.right = new FormAttachment(0, 370);
		// fd_sctnInfo.left = new FormAttachment(0, 12);
		// sctnInfo.setLayoutData(fd_sctnInfo);
		toolkit.paintBordersFor(sctnInfo);
		sctnInfo.setText("Info");

		Composite composite = toolkit.createComposite(sctnInfo, SWT.NONE);
		toolkit.paintBordersFor(composite);
		sctnInfo.setClient(composite);
		composite.setLayout(new GridLayout(3, false));

		Label lblShortName = toolkit.createLabel(composite, "Short Name:",
				SWT.NONE);
		lblShortName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		txtShortName = toolkit.createText(composite, "New Text", SWT.NONE
				| widgetStyle);
		GridData gd_txtShortName = new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 2, 1);
		gd_txtShortName.widthHint = 300;
		txtShortName.setLayoutData(gd_txtShortName);
		txtShortName.setText("");

		Label lblLongName = toolkit.createLabel(composite, "Long Name:",
				SWT.NONE);
		lblLongName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		txtLongName = toolkit.createText(composite, "New Text", SWT.NONE
				| widgetStyle);
		txtLongName.setText(" ");
		GridData gd_txtLongName = new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 2, 1);
		gd_txtLongName.widthHint = 300;
		txtLongName.setLayoutData(gd_txtLongName);

		Label lblNameInExpression = toolkit.createLabel(composite,
				"Name In Expression:", SWT.NONE);
		lblNameInExpression.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));

		txtExpressionName = toolkit.createText(composite, "New Text", SWT.NONE
				| widgetStyle);
		GridData gd_txtExpressionName = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 2, 1);
		gd_txtExpressionName.widthHint = 300;
		txtExpressionName.setLayoutData(gd_txtExpressionName);
		txtExpressionName.setText("");

		Label lblUnit = toolkit.createLabel(composite, "Unit:", SWT.NONE);
		lblUnit.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));

		txtUnit = toolkit.createText(composite, "New Text", SWT.READ_ONLY);
		txtUnit.setText("");

		Button btnSelect = toolkit.createButton(composite, "Select...",
				SWT.NONE);
		btnSelect.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Resource unitResource = editingService
						.getData(LibraryPackage.Literals.UNIT);
				UnitFilterDialog dialog = new UnitFilterDialog(
						NewEditDerivedResource.this.getShell(),
						unitResource);
				if (dialog.open() == IDialogConstants.OK_ID) {
					Unit u = (Unit) dialog.getFirstResult();
					derivedResource.setUnitRef(u); // Should now show with
													// databinding.
				}
			}
		});

		// This section is optional, if the resource is actually part of a
		// component, from
		// real node.

		if (readonly) {
			btnSelect.setEnabled(false);
		}
		buildValuesUI();
	}

	private void buildValuesUI() {
		
		Section sctnContents = toolkit.createSection(frmResource.getBody(),
				Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnContents = new FormData();
		fd_sctnContents.bottom = new FormAttachment(100, -10);
		fd_sctnContents.right = new FormAttachment(100, -10);
		fd_sctnContents.top = new FormAttachment(0, 155);
		fd_sctnContents.left = new FormAttachment(0, 5);
		sctnContents.setLayoutData(fd_sctnContents);
		toolkit.paintBordersFor(sctnContents);
		sctnContents.setText("Contents");

		Composite composite_2 = toolkit.createComposite(sctnContents, SWT.NONE);
		toolkit.paintBordersFor(composite_2);
		sctnContents.setClient(composite_2);
		composite_2.setLayout(new GridLayout(7, false));

		hprlnkValues = toolkit.createHyperlink(composite_2, "Values", SWT.NONE);
		hprlnkValues.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				updateValues();
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});
		toolkit.paintBordersFor(hprlnkValues);
//
//		hprlnkDaily = toolkit.createHyperlink(composite_2, "Daily", SWT.NONE);
//		hprlnkDaily.addHyperlinkListener(new IHyperlinkListener() {
//			public void linkActivated(HyperlinkEvent e) {
//				updateValues(60 * 24);
//			}
//
//			public void linkEntered(HyperlinkEvent e) {
//			}
//
//			public void linkExited(HyperlinkEvent e) {
//			}
//		});
//		toolkit.paintBordersFor(hprlnkDaily);
//		hprlnkWeekly = toolkit.createHyperlink(composite_2, "Weekly", SWT.NONE);
//		hprlnkWeekly.addHyperlinkListener(new IHyperlinkListener() {
//			public void linkActivated(HyperlinkEvent e) {
//				updateValues(60 * 24 * 7);
//			}
//
//			public void linkEntered(HyperlinkEvent e) {
//			}
//
//			public void linkExited(HyperlinkEvent e) {
//			}
//		});
		
		
		
//		toolkit.paintBordersFor(hprlnkWeekly);
//		hprlnkMonthly = toolkit.createHyperlink(composite_2, "Monthly",
//				SWT.NONE);
//		hprlnkMonthly.addHyperlinkListener(new IHyperlinkListener() {
//			public void linkActivated(HyperlinkEvent e) {
//				updateValues(60 * 24 * 30);
//			}
//
//			public void linkEntered(HyperlinkEvent e) {
//			}
//
//			public void linkExited(HyperlinkEvent e) {
//			}
//		});
//		toolkit.paintBordersFor(hprlnkMonthly);
//
//		Composite composite = toolkit.createComposite(composite_2, SWT.NONE);
//		GridData gd_composite = new GridData(SWT.LEFT, SWT.CENTER, false,
//				false, 1, 1);
//		gd_composite.heightHint = 10;
//		composite.setLayoutData(gd_composite);
//		toolkit.paintBordersFor(composite);
//
//		hprlnkCapcity = toolkit.createHyperlink(composite_2, "Capacity",
//				SWT.NONE);
//		hprlnkCapcity.addHyperlinkListener(new IHyperlinkListener() {
//			public void linkActivated(HyperlinkEvent e) {
//				updateCapacityValues();
//			}
//
//			public void linkEntered(HyperlinkEvent e) {
//			}
//
//			public void linkExited(HyperlinkEvent e) {
//			}
//		});
//		toolkit.paintBordersFor(hprlnkCapcity);
//
//		hprlnkUtilization = toolkit.createHyperlink(composite_2, "Utilization",
//				SWT.NONE);
//		hprlnkUtilization.addHyperlinkListener(new IHyperlinkListener() {
//			public void linkActivated(HyperlinkEvent e) {
//				updateUtilizationValues();
//			}
//
//			public void linkEntered(HyperlinkEvent e) {
//			}
//
//			public void linkExited(HyperlinkEvent e) {
//			}
//		});
//		toolkit.paintBordersFor(hprlnkUtilization);

		valuesTableViewer = new TableViewer(composite_2, SWT.BORDER
				| SWT.FULL_SELECTION | SWT.VIRTUAL);
		valuesTableViewer.setUseHashlookup(true);

		table = valuesTableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		GridData gd_table = new GridData(SWT.FILL, SWT.FILL, true, true, 7, 1);
		gd_table.heightHint = 400;
		table.setLayoutData(gd_table);
		toolkit.paintBordersFor(table);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				valuesTableViewer, SWT.NONE);
		TableColumn tblclmnTimeStamp = tableViewerColumn.getColumn();
		tblclmnTimeStamp.setWidth(185);
		tblclmnTimeStamp.setText("Time Stamp");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				valuesTableViewer, SWT.NONE);
		TableColumn tblclmnHourly = tableViewerColumn_1.getColumn();
		tblclmnHourly.setWidth(88);
		tblclmnHourly.setText("Metric");
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);

		Composite composite_3 = toolkit.createComposite(composite_2, SWT.NONE);
		GridData gd_composite_3 = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_composite_3.widthHint = 14;
		gd_composite_3.heightHint = 14;
		composite_3.setLayoutData(gd_composite_3);
		toolkit.paintBordersFor(composite_3);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
	}

	private void updateValues() {

		valuesTableViewer
				.setContentProvider(new DerivedResourceValueContentProvider(
						));
		valuesTableViewer
				.setLabelProvider(new NetXResourceValueLabelProvider());
		valuesTableViewer.setInput(derivedResource);

	}

//	private void updateCapacityValues() {
//
//		valuesTableViewer
//				.setContentProvider(new NetXResourceValueContentProvider(
//						CAPACITIES));
//		valuesTableViewer
//				.setLabelProvider(new NetXResourceValueLabelProvider());
//		valuesTableViewer.setInput(derivedResource);
//
//	}

//	private void updateUtilizationValues() {
//
//		valuesTableViewer
//				.setContentProvider(new NetXResourceValueContentProvider(
//						UTILIZATION));
//		valuesTableViewer
//				.setLabelProvider(new NetXResourceValueLabelProvider());
//		valuesTableViewer.setInput(derivedResource);
//
//	}

	class NetXResourceValueLabelProvider extends StyledCellLabelProvider {

		@Override
		public void update(ViewerCell cell) {

			if (cell.getElement() instanceof Value) {
				Value v = (Value) cell.getElement();
				switch (cell.getColumnIndex()) {
				case 0: {
					Date d = NonModelUtils.fromXMLDate(v.getTimeStamp());
					String ts = new StyledString(NonModelUtils.date(d) + " @ "
							+ NonModelUtils.time(d)).toString();
					cell.setText(ts);
				}
					break;
				case 1: {
					cell.setText(new StyledString(new Double(v.getValue())
							.toString()).toString());
				}

				}
			}
			super.update(cell);
		}

	}

	class DerivedResourceValueContentProvider implements
			IStructuredContentProvider {

		DerivedResourceValueContentProvider() {
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// TODO Auto-generated method stub

		}

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof DerivedResource) {
				DerivedResource resource = (DerivedResource) inputElement;
				return resource.getValues().toArray();

			} else {
				throw new java.lang.IllegalArgumentException(
						"Expected a Derived Resource");
			}
		}

	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = new EMFDataBindingContext();

		// Widget observables.
		IObservableValue shortNameTargetObservable = SWTObservables
				.observeDelayedValue(400, SWTObservables.observeText(
						this.txtShortName, SWT.Modify));
		IObservableValue longNameTargetObservable = SWTObservables
				.observeDelayedValue(400, SWTObservables.observeText(
						this.txtLongName, SWT.Modify));
		IObservableValue expressionNameTargetObservable = SWTObservables
				.observeDelayedValue(400, SWTObservables.observeText(
						this.txtExpressionName, SWT.Modify));
		IObservableValue unitTargetObservable = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(this.txtUnit, SWT.Modify));

		IEMFValueProperty shortNameProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.BASE_RESOURCE__SHORT_NAME);
		IEMFValueProperty longNameProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.BASE_RESOURCE__LONG_NAME);
		IEMFValueProperty expressionNameProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.BASE_RESOURCE__EXPRESSION_NAME);

		IEMFValueProperty unitProperty = EMFEditProperties.value(editingService
				.getEditingDomain(), FeaturePath.fromList(
				LibraryPackage.Literals.BASE_RESOURCE__UNIT_REF,
				LibraryPackage.Literals.UNIT__CODE));

		context.bindValue(shortNameTargetObservable,
				shortNameProperty.observe(derivedResource), null, null);
		context.bindValue(longNameTargetObservable,
				longNameProperty.observe(derivedResource), null, null);
		context.bindValue(expressionNameTargetObservable,
				expressionNameProperty.observe(derivedResource), null, null);
		context.bindValue(unitTargetObservable,
				unitProperty.observe(derivedResource), null, null);

		// Set enablement for interval links.

//		hprlnkDaily.setEnabled(false);
//		hprlnkWeekly.setEnabled(false);
//		hprlnkMonthly.setEnabled(false);
		hprlnkValues.setEnabled(false);
//		hprlnkCapcity.setEnabled(false);
//		hprlnkUtilization.setEnabled(false);

		
		if (derivedResource.getValues().size() > 0) {
			hprlnkValues.setEnabled(true);
			hprlnkValues.setText(hprlnkValues.getText() + " ("
					+ derivedResource.getValues().size() + ")");
		}
		
		return context;
	}

	public void disposeData() {
		// N/A
	}

	public void injectData(Object owner, Object object) {
		if (owner instanceof ServiceProfile) {
			this.owner = (ServiceProfile) owner;
		}else{
			throw new java.lang.IllegalArgumentException("wrong argument or this screen");
			
		}
		if (object instanceof DerivedResource) {
			derivedResource = (DerivedResource) object;
		}

		buildUI();
		this.initDataBindings_();
	}

	public void addData() {
		if (ScreenUtil.isNewOperation(getOperation()) && owner != null) {
			// If new, we have been operating on an object not added yet.
			// We also set the reference to this expression, we need to
			// referee and a feature for this.
			Command ac = new AddCommand(editingService.getEditingDomain(),
					owner.getProfileResources(), this.derivedResource);

			editingService.getEditingDomain().getCommandStack().execute(ac);

			// We can't add this resource now, we need a referee.
		} else if (ScreenUtil.isEditOperation(getOperation())) {
			// If edit, we have been operating on a copy of the object, so we
			// have to replace. However if our original object is invalid, this
			// will
			// cause invalidity, so the action will not occure in case the
			// original is
			// invalid, and we should cancel the action and warn the user.
			if (derivedResource.cdoInvalid()) {
				MessageDialog
						.openWarning(Display.getDefault().getActiveShell(),
								"Conflict",
								"There is a conflict with another user. Your changes can't be saved.");
				return;
			}
			System.out.println(derivedResource.cdoID() + ""
					+ derivedResource.cdoState());

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
		return this.frmResource;
	}
	
	public String getScreenName() {
		return "Service User Profile";
	}

}
