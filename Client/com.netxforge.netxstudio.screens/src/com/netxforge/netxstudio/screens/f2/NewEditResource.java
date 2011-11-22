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
package com.netxforge.netxstudio.screens.f2;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.nebula.widgets.cdatetime.CDT;
import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.BaseResource;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.library.Unit;
import com.netxforge.netxstudio.metrics.KindHintType;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.UnitFilterDialog;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;
import com.netxforge.netxstudio.screens.f4.ResourceMonitorScreen;

public class NewEditResource extends AbstractScreen implements
		IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtShortName;
	private Text txtLongName;
	private Text txtExpressionName;
	private Text txtUnit;
	private BaseResource res;
	private Form frmResource;
	private Resource owner;
	private Component whoRefers;
	private Table table;
	private TableViewer valuesTableViewer;

	private static final int CAPACITIES = -100;
	private static final int UTILIZATION = -200;
	private Text txtComponent;

	private Text txtNode;
	private int targetInterval;
	private CTabFolder tabFolder;
	private CDateTime dateTimeFrom;
	private CDateTime dateTimeTo;
	private Label lblNode;
	private MenuItem mntmMonitor;
	private List<Value> currentValues;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public NewEditResource(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		// buildUI();
		// buildValuesUI();
	}

	private void buildUI() {

		// Readonlyness.
		boolean readonly = Screens.isReadOnlyOperation(this.getOperation());
		String actionText = readonly ? "View: " : "Edit: ";
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmResource = toolkit.createForm(this);
		frmResource.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmResource);
		frmResource.setText(actionText + "Resource");
		buildInfoSection(readonly, widgetStyle);

	}

	private void buildInfoSection(boolean readonly, int widgetStyle) {
		frmResource.getBody().setLayout(new GridLayout(3, false));

		Section sctnInfo = toolkit.createSection(frmResource.getBody(),
				Section.EXPANDED | Section.TITLE_BAR);
		sctnInfo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				3, 1));
		// FormData fd_sctnInfo = new FormData();
		// fd_sctnInfo.right = new FormAttachment(100, -10);
		// fd_sctnInfo.top = new FormAttachment(0, 10);
		// fd_sctnInfo.left = new FormAttachment(0, 5);
		// sctnInfo.setLayoutData(fd_sctnInfo);
		toolkit.paintBordersFor(sctnInfo);
		sctnInfo.setText("Info");

		Composite composite = toolkit.createComposite(sctnInfo, SWT.NONE);
		toolkit.paintBordersFor(composite);
		sctnInfo.setClient(composite);
		composite.setLayout(new GridLayout(3, false));

		lblNode = toolkit.createLabel(composite, "<Dynamic>:", SWT.NONE);
		lblNode.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));

		txtNode = toolkit.createText(composite, "New Text", SWT.READ_ONLY);
		txtNode.setText("");
		GridData gd_txtNode = new GridData(SWT.LEFT, SWT.CENTER, true, false,
				2, 1);
		gd_txtNode.widthHint = 300;
		txtNode.setLayoutData(gd_txtNode);

		Label lblComponent = toolkit.createLabel(composite, "Component:",
				SWT.NONE);
		lblComponent.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblComponent.setAlignment(SWT.RIGHT);

		txtComponent = toolkit.createText(composite, "New Text", SWT.READ_ONLY);
		GridData gd_txtComponent = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 2, 1);
		gd_txtComponent.widthHint = 300;
		txtComponent.setLayoutData(gd_txtComponent);
		txtComponent.setText("");

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
		GridData gd_txtUnit = new GridData(SWT.FILL, SWT.CENTER, false, false,
				1, 1);
		gd_txtUnit.widthHint = 50;
		txtUnit.setLayoutData(gd_txtUnit);

		Button btnSelect = toolkit.createButton(composite, "Select...",
				SWT.NONE);
		btnSelect.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Resource unitResource = editingService
						.getData(LibraryPackage.Literals.UNIT);
				UnitFilterDialog dialog = new UnitFilterDialog(
						NewEditResource.this.getShell(), unitResource);
				if (dialog.open() == IDialogConstants.OK_ID) {
					Unit u = (Unit) dialog.getFirstResult();

					SetCommand cmd = new SetCommand(editingService
							.getEditingDomain(), res,
							LibraryPackage.Literals.BASE_RESOURCE__UNIT_REF, u);
					editingService.getEditingDomain().getCommandStack()
							.execute(cmd);
				}
			}
		});

		// This section is optional, if the resource is actually part of a
		// component, from
		// real node.

		if (readonly) {
			btnSelect.setEnabled(false);
		}
	}

	private void buildValuesUI() {

		tabFolder = new CTabFolder(frmResource.getBody(), SWT.FLAT);
		tabFolder.setMRUVisible(true);
		toolkit.adapt(tabFolder, true, true);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 3;
		gd.heightHint = 0;
		tabFolder.setLayoutData(gd);
		toolkit.paintBordersFor(tabFolder);

		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(
				SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));

		tabFolder.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				updateSelection();
			}
		});

		Label lblStart = toolkit.createLabel(frmResource.getBody(), "From:",
				SWT.NONE);
		GridData gd_lblStart = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_lblStart.widthHint = 70;
		lblStart.setLayoutData(gd_lblStart);
		lblStart.setAlignment(SWT.RIGHT);

		dateTimeFrom = new CDateTime(frmResource.getBody(), CDT.BORDER
				| CDT.DROP_DOWN | CDT.DATE_MEDIUM);
		GridData gd_dateTimeFrom = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_dateTimeFrom.widthHint = 100;
		dateTimeFrom.setLayoutData(gd_dateTimeFrom);
		dateTimeFrom.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				updateFilter();
			}

		});

		toolkit.adapt(dateTimeFrom);
		toolkit.paintBordersFor(dateTimeFrom);
		new Label(frmResource.getBody(), SWT.NONE);

		Label lblTo = toolkit.createLabel(frmResource.getBody(), "To:",
				SWT.NONE);
		lblTo.setAlignment(SWT.RIGHT);
		GridData gd_lblTo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1,
				1);
		gd_lblTo.widthHint = 70;
		lblTo.setLayoutData(gd_lblTo);

		dateTimeTo = new CDateTime(frmResource.getBody(), CDT.BORDER
				| CDT.DROP_DOWN | CDT.DATE_MEDIUM);
		GridData gd_dateTimeTo = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_dateTimeTo.widthHint = 100;
		dateTimeTo.setLayoutData(gd_dateTimeTo);
		dateTimeTo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				updateFilter();
			}

		});

		toolkit.adapt(dateTimeTo);
		toolkit.paintBordersFor(dateTimeTo);
		new Label(frmResource.getBody(), SWT.NONE);

		valuesTableViewer = new TableViewer(frmResource.getBody(), SWT.BORDER
				| SWT.FULL_SELECTION | SWT.VIRTUAL);
		valuesTableViewer.setUseHashlookup(true);
		valuesTableViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent event) {
						ISelection selection = event.getSelection();
						if (selection instanceof IStructuredSelection) {
							if (targetInterval == CAPACITIES
									|| targetInterval == UTILIZATION) {
								mntmMonitor.setEnabled(false);
							} else if (currentValues == null
									| currentValues.size() == 0) {
								mntmMonitor.setEnabled(false);
							} else{
								mntmMonitor.setEnabled(true);
							}	
						}
					}

				});
		valuesTableViewer.addFilter(new ValueFilter());

		table = valuesTableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		// tabItem.setControl(table);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		toolkit.paintBordersFor(table);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				valuesTableViewer, SWT.NONE);
		TableColumn tblclmnTimeStamp = tableViewerColumn.getColumn();
		tblclmnTimeStamp.setWidth(185);
		tblclmnTimeStamp.setText("Time Stamp");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				valuesTableViewer, SWT.NONE);
		TableColumn tblclmnValue = tableViewerColumn_1.getColumn();
		tblclmnValue.setWidth(88);
		tblclmnValue.setText("Value");
		tblclmnValue.setAlignment(SWT.RIGHT);

		// TableViewerColumn tableViewerColumnCapacity = new TableViewerColumn(
		// valuesTableViewer, SWT.NONE);
		// TableColumn tblclmnCapacity = tableViewerColumnCapacity.getColumn();
		// tblclmnCapacity.setWidth(88);
		// tblclmnCapacity.setText("Capacity");
		//
		// TableViewerColumn tableViewerColumnUtilization = new
		// TableViewerColumn(
		// valuesTableViewer, SWT.NONE);
		// TableColumn tblclmnUtilization = tableViewerColumnUtilization
		// .getColumn();
		// tblclmnUtilization.setWidth(88);
		// tblclmnUtilization.setText("Utilization");

		Menu menu = new Menu(table);
		table.setMenu(menu);

		mntmMonitor = new MenuItem(menu, SWT.NONE);
		mntmMonitor.setEnabled(false);
		mntmMonitor.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				if (res instanceof NetXResource && targetInterval > 0) {
					MetricValueRange mvr = modelUtils.valueRangeForInterval(
							(NetXResource) res, targetInterval);
					if (mvr != null) {

						// XMLGregorianCalendar start = mvr.getMetricValues()
						// .get(0).getTimeStamp();
						// XMLGregorianCalendar end = mvr.getMetricValues()
						// .get(mvr.getMetricValues().size() - 1)
						// .getTimeStamp();

						XMLGregorianCalendar to = modelUtils
								.toXMLDate(dateTimeTo.getSelection());
						XMLGregorianCalendar from = modelUtils
								.toXMLDate(dateTimeFrom.getSelection());

						DateTimeRange timerange = GenericsFactory.eINSTANCE
								.createDateTimeRange();

						timerange.setBegin(from);
						timerange.setEnd(to);

						ResourceMonitorScreen monitorScreen = new ResourceMonitorScreen(
								screenService.getScreenContainer(), SWT.NONE);
						monitorScreen.setOperation(Screens.OPERATION_READ_ONLY);
						monitorScreen.setScreenService(screenService);
						monitorScreen.injectData(null, res, timerange,
								targetInterval);
						screenService.setActiveScreen(monitorScreen);
					}
				} else {
					System.out
							.println("Invalid target interval <= 0, perhaps the interval was not set properly in the mapping");
				}

			}
		});
		mntmMonitor.setText("Monitor...");
	}

	private void updateSelection() {
		CTabItem item = tabFolder.getSelection();
		RangeSection section = (RangeSection) item.getData();
		this.updateValues(section.interval);
	}

	private void updateValues(int targetInterval) {

		// Update "from" based on the oldest value:
		this.targetInterval = targetInterval;
		valuesTableViewer
				.setContentProvider(new NetXResourceValueContentProvider());
		valuesTableViewer
				.setLabelProvider(new NetXResourceValueLabelProvider());
		currentValues = this.values(targetInterval);
		if (currentValues.size() > 0) {
			Value oldestValue = modelUtils.oldestValue(currentValues);
			this.dateTimeFrom.setSelection(oldestValue.getTimeStamp()
					.toGregorianCalendar().getTime());
			this.updateFilter();
			valuesTableViewer.setInput(currentValues.toArray());
		} else {

			valuesTableViewer.setInput(Collections.EMPTY_LIST.toArray());
		}
	}

	private void updateFilter() {

		Date from = dateTimeFrom.getSelection();
		Date to = dateTimeTo.getSelection();

		// Do not update on empty date selectors.
		if (from == null || to == null) {
			return;
		}

		ViewerFilter[] filters = valuesTableViewer.getFilters();
		for (ViewerFilter viewerFilter : filters) {
			if (viewerFilter instanceof ValueFilter) {
				((ValueFilter) viewerFilter).updateDates(from, to);
			}
		}
		valuesTableViewer.refresh();
	}

	/*
	 * A table filter which can be update with a from/to date.
	 */
	public class ValueFilter extends ViewerFilter {

		private long from = -1;
		private long to = -1;

		public void updateDates(Date from, Date to) {
			assert from != null && to != null;
			this.from = from.getTime();
			this.to = to.getTime();
		}

		@Override
		public boolean select(Viewer viewer, Object parentElement,
				Object element) {

			if (from <= 0 && to <= 0) {
				return true;
			}

			System.out.println("Updating filter with from=" + from + ", to="
					+ to);

			if (element instanceof Value) {
				long target = ((Value) element).getTimeStamp()
						.toGregorianCalendar().getTimeInMillis();
				return from <= target && to >= target;
			}
			return false;
		}

	}

	class NetXResourceValueLabelProvider extends LabelProvider implements
			ITableLabelProvider {

		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof Value) {
				Value v = (Value) element;
				switch (columnIndex) {
				case 0: {
					Date d = modelUtils.fromXMLDate(v.getTimeStamp());
					String ts = new String(modelUtils.date(d) + " @ "
							+ modelUtils.time(d));
					return ts;
				}
				case 1: {
					double value = v.getValue();
					DecimalFormat numberFormatter = new DecimalFormat(
							"###,###,##0.00");
					numberFormatter.setDecimalSeparatorAlwaysShown(true);
					return numberFormatter.format(value);
				}

				}
			}
			return null;
		}
	}

	class NetXResourceValueContentProvider implements
			IStructuredContentProvider {

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof Object[]) {
				return (Object[]) inputElement;
			}
			return null;
		}

	}

	private List<Value> values(int targetInterval) {
		if (res instanceof NetXResource) {
			NetXResource resource = (NetXResource) res;

			if (targetInterval == CAPACITIES) {
				return resource.getCapacityValues();
			}

			if (targetInterval == UTILIZATION) {
				return resource.getUtilizationValues();
			}

			for (MetricValueRange mvr : resource.getMetricValueRanges()) {

				if (mvr.getIntervalHint() == targetInterval) {
					return modelUtils.sortByTimeStampAndReverse(mvr
							.getMetricValues());
				}
			}
			// DEBUG.
			System.out.println("Target interval: " + targetInterval
					+ " not found for resource: " + resource.getShortName());

		} else {
			throw new java.lang.IllegalArgumentException(
					"Expected a NetXResource");
		}
		return null;
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = new EMFDataBindingContext();

		// Widget observables.

		IObservableValue componentTargetObservable = SWTObservables
				.observeDelayedValue(400, SWTObservables.observeText(
						this.txtComponent, SWT.Modify));

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

		IEMFValueProperty componentProperty = EMFEditProperties.value(
				editingService.getEditingDomain(), FeaturePath.fromList(
						LibraryPackage.Literals.NET_XRESOURCE__COMPONENT_REF,
						LibraryPackage.Literals.COMPONENT__NAME));

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

		context.bindValue(componentTargetObservable,
				componentProperty.observe(res), null, null);
		context.bindValue(shortNameTargetObservable,
				shortNameProperty.observe(res), null, null);
		context.bindValue(longNameTargetObservable,
				longNameProperty.observe(res), null, null);
		context.bindValue(expressionNameTargetObservable,
				expressionNameProperty.observe(res), null, null);
		context.bindValue(unitTargetObservable, unitProperty.observe(res),
				null, null);

		if (whoRefers != null) {
			NodeType nt = modelUtils.resolveParentNodeType((EObject) whoRefers);
			if (nt != null) {
				Node n = null;
				if ((n = modelUtils.resolveParentNode(nt)) != null) {
					this.lblNode.setText("NE Instance:");
					this.txtNode.setText(n.getNodeID());
				} else {
					this.lblNode.setText("NE Type:");
					this.txtNode.setText(nt.getName());
				}
			}
		}
		return context;
	}

	private void bindValues() {
		this.dateTimeTo.setSelection(modelUtils.todayAndNow());
		createTabs(toolkit);
		tabFolder.setSelection(0);
		updateSelection();
	}

	private void createTab(int interval, KindHintType kh) {
		createTab(interval, kh, null);
	}

	private void createTab(int interval, String text) {
		createTab(interval, null, text);
	}

	private void createTab(int interval, KindHintType kh, String text) {
		CTabItem item = new CTabItem(tabFolder, SWT.NULL);

		StringBuilder sb = new StringBuilder();
		if (text != null) {
			sb.append(text);
		} else if (interval > 0) {
			String fromMinutes = modelUtils.fromMinutes(interval);
			sb.append(fromMinutes);
			item.setText(fromMinutes);
		}
		if (kh != null) {
			sb.append(" (" + kh.getName() + ")");
		}

		item.setText(sb.toString());
		item.setData(new RangeSection(interval));
	}

	class RangeSection {

		int interval;

		public RangeSection(int interval) {
			this.interval = interval;
		}

	}

	private void createTabs(FormToolkit toolkit2) {
		if (res instanceof NetXResource) {
			NetXResource netxResource = (NetXResource) res;
			for (MetricValueRange mvr : netxResource.getMetricValueRanges()) {
				createTab(mvr.getIntervalHint(), mvr.getKindHint());
			}

			createTab(CAPACITIES, "Capacity");
			createTab(UTILIZATION, "Utilization");
		}
	}

	public void disposeData() {
		// N/A
	}

	public void injectData(Object owner, Object object) {
		injectData(owner, null, object);
	}

	public void injectData(Object owner, Object whoRefers, Object object) {
		if (owner instanceof Resource) {
			this.owner = (Resource) owner;
		}
		if (object instanceof BaseResource) {
			res = (BaseResource) object;
		}

		if (res instanceof NetXResource
				&& res.eIsSet(LibraryPackage.Literals.NET_XRESOURCE__COMPONENT_REF)) {
			this.whoRefers = ((NetXResource) res).getComponentRef();
		} else {
			// Determine the ownership if not a resource.
			if (whoRefers != null && whoRefers instanceof Component) {
				this.whoRefers = (Component) whoRefers;
			}
		}

		buildUI();
		this.initDataBindings_();
		if (this.whoRefers != null
				&& modelUtils.resolveParentNode((EObject) this.whoRefers) != null) {
			buildValuesUI();
			bindValues();
		}
	}

	public void addData() {
		if (Screens.isNewOperation(getOperation()) && owner != null) {
			// If new, we have been operating on an object not added yet.
			CompoundCommand c = new CompoundCommand();
			if (whoRefers != null) {
				if (res instanceof NetXResource) {

					// NetXResource netxRes = (NetXResource) res;
					// netxRes.setComponentRef(whoRefers);
					// whoRefers.getResourceRefs().add(netxRes);
					// owner.getContents().add(netxRes);
					//
					Command addResource = new AddCommand(
							editingService.getEditingDomain(),
							owner.getContents(), (NetXResource) res);
					//
					c.append(addResource);

					Command refBidiCommand = new AddCommand(
							editingService.getEditingDomain(),
							((Component) whoRefers).getResourceRefs(),
							(NetXResource) res);

					c.append(refBidiCommand);

					// Command refBidiCommand = new SetCommand(
					// editingService.getEditingDomain(),
					// ((NetXResource) res).getComponentRef(),
					// LibraryPackage.Literals.NET_XRESOURCE__COMPONENT_REF,
					// (Component) whoRefers);

				}
				editingService.getEditingDomain().getCommandStack().execute(c);

			}

		} else if (Screens.isEditOperation(getOperation())) {
			// If edit, we have been operating on a copy of the object, so we
			// have to replace. However if our original object is invalid, this
			// will
			// cause invalidity, so the action will not occure in case the
			// original is
			// invalid, and we should cancel the action and warn the user.
			if (res.cdoInvalid()) {
				MessageDialog
						.openWarning(Display.getDefault().getActiveShell(),
								"Conflict",
								"There is a conflict with another user. Your changes can't be saved.");
				return;
			}
			System.out.println(res.cdoID() + "" + res.cdoState());

		}
		// After our edit, we shall be dirty
		if (editingService.isDirty()) {
			editingService.doSave(new NullProgressMonitor());
		}

	}

	@Override
	public Viewer getViewer() {
		return null;
	}

	@Override
	public void setOperation(int operation) {
		this.operation = operation;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public Form getScreenForm() {
		return this.frmResource;
	}

	public String getScreenName() {
		return "Resource";
	}
}
