package com.netxforge.netxstudio.screens.f2;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.TableViewerColumnSorter;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.BaseResource;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.screens.CDOElementComparer;
import com.netxforge.netxstudio.screens.editing.selector.IScreenFormService;
import com.netxforge.netxstudio.screens.tables.TableHelper;
import com.netxforge.netxstudio.screens.tables.TableHelper.TBVCSorterValueProvider;

/**
 * Holds all needed to build a component showing NetXResource values.
 * 
 * @author Christophe
 * 
 */
public class ValueComponentII {

	private Table table;
	private TableViewer valuesTableViewer;

	private ModelUtils modelUtils;
	private TableHelper tableHelper;

	@Inject
	public ValueComponentII(ModelUtils modelUtils, TableHelper tableHelper) {
		this.modelUtils = modelUtils;
		this.tableHelper = tableHelper;
	}

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private BaseResource res;

	@SuppressWarnings("unused")
	private IScreenFormService screenService;

	public void configure(IScreenFormService screenService) {
		this.screenService = screenService;
	}

	public TableViewer getValuesTableViewer() {
		return valuesTableViewer;
	}

	public void buildValuesUI(Composite parent, Object layoutData) {

//		Composite valuesComposite = toolkit.createComposite(parent, SWT.NONE);
//		valuesComposite.setLayoutData(layoutData);
//		toolkit.adapt(valuesComposite);
//		GridLayout gridLayout = new GridLayout(3, false);
//		
//		valuesComposite.setLayout(gridLayout);

		valuesTableViewer = new TableViewer(parent, SWT.BORDER
				| SWT.FULL_SELECTION | SWT.VIRTUAL | SWT.MULTI);
		valuesTableViewer.setUseHashlookup(true);
		valuesTableViewer.setComparer(new CDOElementComparer());
		valuesTableViewer.addFilter(new PeriodFilter());

		table = valuesTableViewer.getTable();
		table.setLayoutData(layoutData);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		toolkit.paintBordersFor(table);

	}

	private void buildColumns() {

		table.setRedraw(false);

		while (table.getColumnCount() > 0) {
			table.getColumns()[0].dispose();
		}

		if (res instanceof NetXResource) {

			// timestamp column
			TableViewerColumn tbvcFor = tableHelper.new TBVC<Date>(
					new NetXResourceValueLabelProvider()).tbvcFor(
					valuesTableViewer, "Time Stamp", 185);
			ObjectArraySorter objectArraySorter = new ObjectArraySorter(tbvcFor);
			objectArraySorter.setSorter(TableViewerColumnSorter.DESC);

			// metric value ranges....
			NetXResource resource = (NetXResource) res;
			for (MetricValueRange mvr : resource.getMetricValueRanges()) {
				int intervalHint = mvr.getIntervalHint();
				String columnName = new Integer(intervalHint).toString()
						+ " (min)";
				tableHelper.new TBVC<Double>(
						new NetXResourceValueLabelProvider()).tbvcFor(
						valuesTableViewer, columnName,
						"Metric value range with " + columnName + " values.",
						100);
			}

			tableHelper.new TBVC<Double>(new NetXResourceValueLabelProvider())
					.tbvcFor(valuesTableViewer, "Capacity",
							"Capacity value range", 100);
			tableHelper.new TBVC<Double>(new NetXResourceValueLabelProvider())
					.tbvcFor(valuesTableViewer, "Utilization",
							"Utilization value range", 100);

			// TODO, dynamicly build the tolerance value ranges.
		}
		table.setRedraw(true);
	}
	
	public void injectData(BaseResource object) {
		res = object;
		try {
			buildColumns();
			valuesTableViewer.setInput(res);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/*
	 * The object array position correspond to the columns.
	 * 
	 * @author Christophe Bouhier
	 */
	class ObjectArraySorter extends TableViewerColumnSorter implements
			TBVCSorterValueProvider {

		private TableViewerColumn column;

		public ObjectArraySorter(TableViewerColumn column) {
			super(column);
			this.column = column;
		}

		@Override
		protected int doCompare(Viewer viewer, Object e1, Object e2) {
			int cIndex = -1;
			if (viewer instanceof TableViewer) {
				cIndex = ((TableViewer) viewer).getTable().indexOf(
						column.getColumn());
			} else {
				return 0;
			}

			Object value1 = valueOf((Object[]) e1, cIndex);
			Object value2 = valueOf((Object[]) e2, cIndex);
			if (value1 != null && value2 != null) {
				return modelUtils.dateComparator().compare((Date) value1,
						(Date) value2);
			} else {
				return super.doCompare(viewer, e1, e2);
			}
		}

		public Object valueOf(Object rowObject, int columnIndex) {
			assert rowObject instanceof Object[];
			Object[] array = (Object[]) rowObject;
			assert columnIndex >= 0 && columnIndex < array.length;
			return array[columnIndex];
		}
	}

	public void bindValues() {

		/*
		 * Builds an Object[] array, the first column is the NetXResource Time
		 * Stamps. the remaining are the NetXResource ranges. (Metric, Capacity,
		 * Utilization).
		 */
		valuesTableViewer.setContentProvider(new ArrayContentProvider() {

			@Override
			public Object[] getElements(Object inputElement) {

				if (inputElement instanceof NetXResource) {

					NetXResource res = (NetXResource) inputElement;
					// determine the size of the array.
					int arraySize = 0;
					Object[] rangeArray;
					arraySize = res.getMetricValueRanges().size();
					arraySize += 2; // Cap, Utilization.
					rangeArray = new Object[arraySize];

					// populate the array, in a set of indexed lists.
					// later create an object matrix from the list.

					List<Date> existingDates = Lists.newArrayList();

					int rangeIndex = 0;
					for (MetricValueRange mvr : res.getMetricValueRanges()) {
						List<Double> doubles = modelUtils.merge(existingDates,
								mvr.getMetricValues());
						// check if the date exist, add if not and add the value
						rangeArray[rangeIndex++] = doubles;
					}

					{
						List<Double> doubles = modelUtils.merge(existingDates,
								res.getCapacityValues());
						rangeArray[rangeIndex++] = doubles;
					}
					{
						List<Double> doubles = modelUtils.merge(existingDates,
								res.getUtilizationValues());
						rangeArray[rangeIndex++] = doubles;
					}

					// reverse t
					List<Object[]> result = Lists.newArrayList();

					for (Date date : existingDates) {
						if (date == null)
							continue;
						int indexOfDate = existingDates.indexOf(date);
						if (indexOfDate != -1) {
							Object[] row = new Object[arraySize + 1];
							row[0] = date;
							for (int i = 0; i < rangeArray.length; i++) {
								// ranges can be safely casted.
								@SuppressWarnings("unchecked")
								List<Double> range = (List<Double>) rangeArray[i];
								// Should not be index out of bound, as we have
								// grown the lists to the size of the dates.
								if (indexOfDate < range.size()) {
									row[i + 1] = range.get(indexOfDate);
								} else {
									row[i + 1] = new Object();
								}

							}
							result.add(row);
						}
					}

					return result.toArray();
				}
				return null;
			}

		});

		valuesTableViewer
				.setLabelProvider(new NetXResourceValueLabelProvider());
	}

	/*
	 * A table filter which can be update with a from/to date.
	 */
	public class PeriodFilter extends ViewerFilter {

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

			if (element instanceof Object[]) {
				Object[] array = (Object[]) element;
				Date ts = (Date) array[0];
				// date is the first column.
				long target = ts != null ? ts.getTime() : 0;
				return from <= target && to >= target;
			}
			return false;
		}
	}

	
	public void applyDateFilter(DateTimeRange dtr) {
		// Do not update on empty date selectors.
		if (dtr == null) {
			return;
		}
		;
		this.applyDateFilter(modelUtils.begin(dtr), modelUtils.end(dtr));
	}
	
	/**
	 * call to apply the period filter on the table viewer.
	 * 
	 * @param from
	 * @param to
	 */
	public void applyDateFilter(Date from, Date to) {
		// Do not update on empty date selectors.
		if (from == null || to == null) {
			return;
		}

		ViewerFilter[] filters = valuesTableViewer.getFilters();
		for (ViewerFilter viewerFilter : filters) {
			if (viewerFilter instanceof PeriodFilter) {
				((PeriodFilter) viewerFilter).updateDates(from, to);
			}
		}
		valuesTableViewer.refresh();
	}

	public class NetXResourceValueLabelProvider extends StyledCellLabelProvider {

		public NetXResourceValueLabelProvider() {
			super();
		}

		@Override
		public void update(ViewerCell cell) {
			Object element = cell.getElement();

			if (element instanceof Object[]) {
				Object[] array = (Object[]) element;
				int columnIndex = cell.getColumnIndex();
				if (columnIndex < array.length) {
					switch (columnIndex) {
					case 0: {
						Object object = array[columnIndex];
						if (object instanceof Date) {
							Date d = (Date) object;
							String ts = new String(modelUtils.date(d) + " @ "
									+ modelUtils.time(d));
							cell.setText(ts);
						}
					}
						break;
					// All other indexes are values.
					default: {
						Object object = array[columnIndex];
						if (object instanceof Double) {
							double value = (Double) object;
							if (value != -1) {
								DecimalFormat numberFormatter = new DecimalFormat(
										"###,###,##0.00");
								numberFormatter
										.setDecimalSeparatorAlwaysShown(true);
								cell.setText(numberFormatter.format(value));
							}
						}
					}
					}

				}
			}

			super.update(cell);
		}
	}

	public void clearData() {

	}

}
