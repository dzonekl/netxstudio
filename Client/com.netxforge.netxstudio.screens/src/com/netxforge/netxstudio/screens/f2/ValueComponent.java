package com.netxforge.netxstudio.screens.f2;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.nebula.widgets.cdatetime.CDT;
import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.TableViewerColumnSorter;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.BaseResource;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.KindHintType;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.screens.CDOElementComparer;
import com.netxforge.netxstudio.screens.editing.actions.BaseSelectionListenerAction;
import com.netxforge.netxstudio.screens.editing.selector.IScreenFormService;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;
import com.netxforge.netxstudio.screens.f4.ResourceMonitorScreen;

/**
 * Holds all needed to build a component showing NetXResource values.
 * 
 * @author Christophe
 * 
 */
public class ValueComponent {

	private CTabFolder tabFolder;
	
	private CDateTime dateTimeFrom;
	private CDateTime dateTimeTo;
	
	private Table table;
	private TableViewer valuesTableViewer;

	private ModelUtils modelUtils;

	@Inject
	public ValueComponent(ModelUtils modelUtils) {
		this.modelUtils = modelUtils;
	}

	/*
	 * The current values.
	 */
	private List<Value> currentValues;

	/*
	 * Either a metric interval, CAPACITIES, UTILIZATION
	 */
	private int targetInterval;

	private static final int CAPACITIES = -100;
	private static final int UTILIZATION = -200;

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private BaseResource res;
	private IScreenFormService screenService;

	public void configure(IScreenFormService screenService) {
		this.screenService = screenService;
	}

	public TableViewer getValuesTableViewer() {
		return valuesTableViewer;
	}

	public void buildValuesUI(Composite parent, Object layoutData) {

		Composite valuesComposite = toolkit.createComposite(parent, SWT.NONE);
		valuesComposite.setLayoutData(layoutData);
		toolkit.adapt(valuesComposite);

		valuesComposite.setLayout(new GridLayout(3, false));

		tabFolder = new CTabFolder(valuesComposite, SWT.FLAT);
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
				updateTabSelection();
			}
		});
		
		Label lblStart = toolkit
				.createLabel(valuesComposite, "From:", SWT.NONE);
		GridData gd_lblStart = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_lblStart.widthHint = 70;
		lblStart.setLayoutData(gd_lblStart);
		lblStart.setAlignment(SWT.RIGHT);

		dateTimeFrom = new CDateTime(valuesComposite, CDT.BORDER
				| CDT.DROP_DOWN | CDT.DATE_SHORT);
		GridData gd_dateTimeFrom = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_dateTimeFrom.widthHint = 120;
		dateTimeFrom.setLayoutData(gd_dateTimeFrom);
		dateTimeFrom.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				updateFilter();
			}

		});

		toolkit.adapt(dateTimeFrom);
		toolkit.paintBordersFor(dateTimeFrom);
		new Label(valuesComposite, SWT.NONE);

		Label lblTo = toolkit.createLabel(valuesComposite, "To:", SWT.NONE);
		lblTo.setAlignment(SWT.RIGHT);
		GridData gd_lblTo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1,
				1);
		gd_lblTo.widthHint = 70;
		lblTo.setLayoutData(gd_lblTo);

		dateTimeTo = new CDateTime(valuesComposite, CDT.BORDER | CDT.DROP_DOWN
				| CDT.DATE_SHORT);
		GridData gd_dateTimeTo = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_dateTimeTo.widthHint = 120;
		dateTimeTo.setLayoutData(gd_dateTimeTo);
		dateTimeTo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				updateFilter();
			}

		});

		toolkit.adapt(dateTimeTo);
		toolkit.paintBordersFor(dateTimeTo);
		new Label(valuesComposite, SWT.NONE);

		valuesTableViewer = new TableViewer(valuesComposite, SWT.BORDER
				| SWT.FULL_SELECTION | SWT.VIRTUAL | SWT.MULTI);
		valuesTableViewer.setUseHashlookup(true);
		valuesTableViewer.setComparer(new CDOElementComparer());
		valuesTableViewer.addFilter(new ValueFilter());

		table = valuesTableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		// tabItem.setControl(table);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		toolkit.paintBordersFor(table);

		TableViewerColumn tableViewerColumnTimeStamp = new TableViewerColumn(
				valuesTableViewer, SWT.NONE);
		TableColumn tblclmnTimeStamp = tableViewerColumnTimeStamp.getColumn();
		tblclmnTimeStamp.setWidth(185);
		tblclmnTimeStamp.setText("Time Stamp");

		TableViewerColumnSorter dateTimeColumnSorter = new TableViewerColumnSorter(
				tableViewerColumnTimeStamp) {
			protected int doCompare(Viewer viewer, Object e1, Object e2) {
				if (e1 instanceof Value && e2 instanceof Value) {

					Value re1 = (Value) e1;
					Value re2 = (Value) e2;

					if (re1.eIsSet(GenericsPackage.Literals.VALUE__TIME_STAMP)
							&& re2.eIsSet(GenericsPackage.Literals.VALUE__TIME_STAMP))

						return Long.valueOf(
								re2.getTimeStamp().toGregorianCalendar()
										.getTimeInMillis()).compareTo(
								Long.valueOf(re1.getTimeStamp()
										.toGregorianCalendar()
										.getTimeInMillis()));
				}
				return 0;
			}

		};
		dateTimeColumnSorter.setSorter(TableViewerColumnSorter.ASC);

		TableViewerColumn tableViewerColumnValue = new TableViewerColumn(
				valuesTableViewer, SWT.NONE);
		TableColumn tblclmnValue = tableViewerColumnValue.getColumn();
		tblclmnValue.setWidth(88);
		tblclmnValue.setText("Value");
		tblclmnValue.setAlignment(SWT.RIGHT);

	}

	public void injectData(BaseResource object) {
			res = object;
			createTabs();
			tabFolder.setSelection(0);
			this.updateTabSelection();
	}

	public void bindValues() {

		this.dateTimeTo.setSelection(modelUtils.todayAndNow());
		
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		valuesTableViewer.setContentProvider(listContentProvider);

		List<IObservableMap> observeMaps = Lists.newArrayList();
		IObservableSet set = listContentProvider.getKnownElements();
		observeMaps.add(EMFEditProperties.value(
				screenService.getEditingService().getEditingDomain(),
				LibraryPackage.Literals.NET_XRESOURCE__CAPACITY_VALUES)
				.observeDetail(set));

		observeMaps.add(EMFEditProperties.value(
				screenService.getEditingService().getEditingDomain(),
				LibraryPackage.Literals.NET_XRESOURCE__UTILIZATION_VALUES)
				.observeDetail(set));

		observeMaps.add(EMFEditProperties.value(
				screenService.getEditingService().getEditingDomain(),
				MetricsPackage.Literals.METRIC_VALUE_RANGE__METRIC_VALUES)
				.observeDetail(set));

		IObservableMap[] map = new IObservableMap[observeMaps.size()];
		observeMaps.toArray(map);

		valuesTableViewer.setLabelProvider(new NetXResourceValueLabelProvider(
				map));
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

	private void updateTabSelection() {
		if (tabFolder.getItemCount() == 0) {
			return;
		}
		CTabItem item = tabFolder.getSelection();
		RangeSection section = (RangeSection) item.getData();
		// Update "from" based on the oldest value:
		this.targetInterval = section.interval;
		IObservableList l = values(targetInterval);
		valuesTableViewer.setInput(l);
	}

	private IObservableList values(int targetInterval) {

		// The target containing the range.
		Object target = null;
		currentValues = null;
		EStructuralFeature feature = null;

		if (res instanceof NetXResource) {
			NetXResource resource = (NetXResource) res;

			if (targetInterval == CAPACITIES) {
				currentValues = modelUtils.sortByTimeStampAndReverse(resource
						.getCapacityValues());
				target = res;
				feature = LibraryPackage.Literals.NET_XRESOURCE__CAPACITY_VALUES;

			}

			if (targetInterval == UTILIZATION) {
				currentValues = modelUtils.sortByTimeStampAndReverse(resource
						.getUtilizationValues());
				target = res;
				feature = LibraryPackage.Literals.NET_XRESOURCE__UTILIZATION_VALUES;
			}

			for (MetricValueRange mvr : resource.getMetricValueRanges()) {

				if (mvr.getIntervalHint() == targetInterval) {
					currentValues = modelUtils.sortByTimeStampAndReverse(mvr
							.getMetricValues());
					target = mvr;
					feature = MetricsPackage.Literals.METRIC_VALUE_RANGE__METRIC_VALUES;
					break;
				}
			}

			if (currentValues != null && target != null) {
				if (currentValues.size() > 0) {
					Value oldestValue = modelUtils.oldestValue(currentValues);
					this.dateTimeFrom.setSelection(oldestValue.getTimeStamp()
							.toGregorianCalendar().getTime());
					this.updateFilter();
				}

				// Unsorted..., delegate to the viewer.
				return EMFEditProperties.list(
						screenService.getEditingService().getEditingDomain(),
						feature).observe(target);
			}

			// DEBUG.
			System.out.println("Target interval: " + targetInterval
					+ " not found for resource: " + resource.getShortName());

		}
		return new WritableList();
	}

	public class MonitorAction extends BaseSelectionListenerAction {

		public MonitorAction(String text, int style) {
			super(text);
		}

		@Override
		protected boolean updateSelection(IStructuredSelection selection) {

			if (currentValues == null || currentValues.size() == 0) {
				return false;
			}
			// Don't allow monitoring for
			if (targetInterval == CAPACITIES || targetInterval == UTILIZATION) {
				return false;
			} else {
				return true;
			}
		}

		@Override
		public void run() {
			if (res instanceof NetXResource && targetInterval > 0) {
				MetricValueRange mvr = modelUtils.valueRangeForInterval(
						(NetXResource) res, targetInterval);
				if (mvr != null) {

					// XMLGregorianCalendar start = mvr.getMetricValues()
					// .get(0).getTimeStamp();
					// XMLGregorianCalendar end = mvr.getMetricValues()
					// .get(mvr.getMetricValues().size() - 1)
					// .getTimeStamp();

					XMLGregorianCalendar to = modelUtils.toXMLDate(dateTimeTo
							.getSelection());
					XMLGregorianCalendar from = modelUtils
							.toXMLDate(dateTimeFrom.getSelection());

					DateTimeRange timerange = GenericsFactory.eINSTANCE
							.createDateTimeRange();

					timerange.setBegin(from);
					timerange.setEnd(to);

					ResourceMonitorScreen monitorScreen = new ResourceMonitorScreen(
							screenService.getScreenContainer(), SWT.NONE);
					monitorScreen.setOperation(ScreenUtil.OPERATION_READ_ONLY);
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
	}

	private void createTabs() {
		
		// remove all previous. 
		CTabItem[] tabList = tabFolder.getItems();
		for(CTabItem c: tabList){
			c.dispose();
		}
		if (res instanceof NetXResource) {
			NetXResource netxResource = (NetXResource) res;
			for (MetricValueRange mvr : netxResource.getMetricValueRanges()) {
				createTab(mvr.getIntervalHint(), mvr.getKindHint());
			}
			
			createTab(CAPACITIES, "Capacity");
			createTab(UTILIZATION, "Utilization");

		}
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

	class NetXResourceValueLabelProvider extends ObservableMapLabelProvider
			implements ITableLabelProvider {

		public NetXResourceValueLabelProvider(IObservableMap[] attributeMaps) {
			super(attributeMaps);
		}

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

	public void clearData() {
		
		
	}

}
