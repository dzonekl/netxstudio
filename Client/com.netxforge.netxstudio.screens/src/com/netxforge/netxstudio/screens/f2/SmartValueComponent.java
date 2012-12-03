/*******************************************************************************
 * Copyright (c) Oct 13, 2012 NetXForge.
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
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.wb.swt.TableViewerColumnSorter;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.BaseResource;
import com.netxforge.netxstudio.library.LevelKind;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.operators.Marker;
import com.netxforge.netxstudio.operators.ToleranceMarker;
import com.netxforge.netxstudio.screens.AbstractCachedViewerComponent;
import com.netxforge.netxstudio.screens.IItemsFilter;
import com.netxforge.netxstudio.screens.ISearchPattern;
import com.netxforge.netxstudio.screens.PeriodItemsFilter;
import com.netxforge.netxstudio.screens.PeriodItemsFilter.PeriodPattern;
import com.netxforge.netxstudio.screens.common.tables.TableHelper;
import com.netxforge.netxstudio.screens.common.tables.TableHelper.TBVCSorterValueProvider;
import com.netxforge.netxstudio.screens.editing.selector.IScreenFormService;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;

/**
 * Holds all needed to build a component showing NetXResource values. The data
 * is pre-processed using a background job, which populates a source list.
 * 
 * 
 * 
 * @author Christophe
 * 
 */
public class SmartValueComponent {

	private ModelUtils modelUtils;
	private TableHelper tableHelper;

	@Inject
	public SmartValueComponent(ModelUtils modelUtils, TableHelper tableHelper) {
		this.modelUtils = modelUtils;
		this.tableHelper = tableHelper;
	}

	private BaseResource baseResource;

	private IScreenFormService screenService;

	private AbstractCachedViewerComponent viewerComponent;

	private List<Marker> markers;
	private Date from;
	private Date to;

	public void configure(IScreenFormService screenService) {
		this.screenService = screenService;
	}

	public TableViewer getValuesTableViewer() {
		return viewerComponent.getTableViewer();
	}

	public void buildUI(Composite parent, Object layoutData) {

		viewerComponent = new AbstractCachedViewerComponent(parent.getShell(),
				true) {

			@Override
			protected Control createExtendedContentArea(Composite parent) {
				return null;
			}

			@Override
			protected void buildColumns(TableViewer viewer) {
				SmartValueComponent.this.delegateBuildColumns();
			}

			@Override
			public void handleDoubleClick() {

			}

			@Override
			protected IStatus validateItem(Object item) {
				return Status.OK_STATUS;
			}

			@Override
			protected IItemsFilter createFilter() {

				PeriodItemsFilter periodItemsFilter = new PeriodItemsFilter(
						modelUtils) {

					/**
					 * Match on the first array of the item, which is a Value
					 * with a timestamp.
					 */
					@Override
					public boolean matchItem(Object item) {

						if (item instanceof Object[]) {
							Date d = (Date) ((Object[]) item)[0];
							ISearchPattern pattern = this.getPattern();
							if (pattern instanceof PeriodPattern) {
								return ((PeriodPattern) pattern).matches(d);
							}
						}
						//
						return false;
					}

				};
				ISearchPattern pattern = periodItemsFilter.getPattern();
				// set the current period.
				if (pattern instanceof PeriodPattern) {
					((PeriodPattern) pattern).updateDates(from, to);
				}
				return periodItemsFilter;

			}

			@Override
			protected <T> Comparator<T> getItemsComparator() {
				
				
				/**
				 * Compare on the first array in the matrix, which are dates. 
				 */
				return new Comparator<T>() {

					public int compare(T o1, T o2) {

						if (o1 instanceof Object[] && o1 instanceof Object[]) {
							Date d1 = (Date) ((Object[]) o1)[0];
							Date d2 = (Date) ((Object[]) o2)[0];
							return modelUtils.dateComparator().compare(d1, d2);
						}
						return 0;
					}
				};
			}

			@Override
			protected void fillContentProvider(
					AbstractContentProvider contentProvider,
					IItemsFilter itemsFilter, IProgressMonitor progressMonitor)
					throws CoreException {

				if (ScreensActivator.DEBUG) {
					ScreensActivator.TRACE.trace(
							ScreensActivator.TRACE_SCREENS_OPTION,
							"filling content provider");
					ScreensActivator.TRACE
							.trace(ScreensActivator.TRACE_SCREENS_OPTION,
									"items filter pattern: "
											+ itemsFilter.getPattern());

				}

				// Will be collection of Object[], each array corresponding to
				// the column index.
				List<?> delegateGetItems = delegateGetItems();
				// Add unfiltered, we depend on Viewer filter.
				contentProvider.addCollection(delegateGetItems, itemsFilter);
			}

			@Override
			public String getElementName(Object item) {
				return null;
			}

		};
		viewerComponent.buildUI(parent);
		viewerComponent
				.setListLabelProvider(new NetXResourceValueLabelProvider());
	}

	protected List<?> delegateGetItems() {
		return Arrays.asList(itemsForNetXResource());
	}

	protected void delegateBuildColumns() {
		this.buildColumns();
	}

	private void buildColumns() {

		Table table = this.getValuesTableViewer().getTable();
		table.setRedraw(false);

		for (TableColumn tc : table.getColumns()) {
			tc.dispose();
		}

		if (baseResource instanceof NetXResource) {

			// The time stamp column
			tableHelper.new TBVC<Date>(new NetXResourceValueLabelProvider())
					.tbvcFor(this.getValuesTableViewer(), "Time Stamp", 185);

			{
				ColumnRangeFeedback columnRangeFeedback = new ColumnRangeFeedback(
						MetricsPackage.Literals.METRIC_VALUE_RANGE__METRIC_VALUES);

				// ObjectArraySorter objectArraySorter = new ObjectArraySorter(
				// tbvcFor);
				// objectArraySorter.setSorter(TableViewerColumnSorter.DESC);

				// metric value ranges....
				NetXResource resource = (NetXResource) baseResource;

				List<MetricValueRange> mvrList = Lists.newArrayList(resource
						.getMetricValueRanges());
				Collections.sort(mvrList, modelUtils.mvrCompare());
				for (MetricValueRange mvr : mvrList) {

					int intervalHint = mvr.getIntervalHint();

					// CB 14-07-2012, interpret the interval.
					String columnName = modelUtils.fromMinutes(intervalHint)
							+ " [" + mvr.getKindHint().getName() + "]";
					// String columnName = new Integer(intervalHint).toString()
					// + " (min), " + mvr.getKindHint().getName();

					TableViewerColumn tbvc = tableHelper.new TBVC<Double>(
							new NetXResourceValueLabelProvider()).tbvcFor(
							this.getValuesTableViewer(), columnName,
							"Metric value range with " + columnName
									+ " values.", 100);

					setColumnData(mvr, tbvc);
					setRangeFeedback(columnRangeFeedback, tbvc);

				}
			}
			{
				ColumnRangeFeedback columnRangeFeedback = new ColumnRangeFeedback(
						LibraryPackage.Literals.NET_XRESOURCE__CAPACITY_VALUES);

				TableViewerColumn tbvc = tableHelper.new TBVC<Double>(
						new NetXResourceValueLabelProvider()).tbvcFor(
						this.getValuesTableViewer(), "Capacity",
						"Capacity value range", 100);
				setColumnData(baseResource, tbvc);
				setRangeFeedback(columnRangeFeedback, tbvc);
			}
			{
				ColumnRangeFeedback columnRangeFeedback = new ColumnRangeFeedback(
						LibraryPackage.Literals.NET_XRESOURCE__UTILIZATION_VALUES);
				TableViewerColumn tbvc = tableHelper.new TBVC<Double>(
						new NetXResourceValueLabelProvider()).tbvcFor(
						this.getValuesTableViewer(), "Utilization",
						"Utilization value range", 100);
				setColumnData(baseResource, tbvc);
				setRangeFeedback(columnRangeFeedback, tbvc);
			}

		}
		this.getValuesTableViewer().getTable().setRedraw(true);
	}

	private void setRangeFeedback(ColumnRangeFeedback columnRangeFeedback,
			TableViewerColumn tbvc) {
		tbvc.getColumn().addListener(SWT.Selection, columnRangeFeedback);
	}

	private void setColumnData(CDOObject mvr, TableViewerColumn tbvc) {
		CDOID cdoIDOfMVR = mvr.cdoID();
		tbvc.getColumn().setData(cdoIDOfMVR);
	}

	public void injectData(BaseResource object) {

		baseResource = object;
		markers = null; // reset the markers.

		buildColumns();

		// Re-apply the filter.
		viewerComponent.applyFilter();

		// try {
		// buildColumns();
		// if (!valuesTableViewer.getTable().isVisible()) {
		// valuesTableViewer.getTable().setVisible(true);
		// }
		// } catch (Exception e) {
		// System.out.println(e);
		// }
	}

	/**
	 * The Value component as the option to show the markers. We will apply only
	 * markers, as per
	 */
	public void applyMarkers(List<Marker> markers) {
		this.markers = markers;
	}

	/*
	 * Return a feedback for a table column data, which needs to be a CDOID
	 * object. the provided EReference is used to produce the correct feedback.
	 */
	private final class ColumnRangeFeedback implements Listener {

		// The feature which we want feedback on.
		private EReference reference;

		public ColumnRangeFeedback(EReference reference) {
			super();
			this.reference = reference;
		}

		public void handleEvent(Event event) {

			// absolute positions
			@SuppressWarnings("unused")
			int x = event.x;
			@SuppressWarnings("unused")
			int y = event.y;

			Widget widget = event.widget;
			if (widget instanceof TableColumn) {
				TableColumn tc = (TableColumn) widget;
				Object data = tc.getData();
				if (data instanceof CDOID) {
					String valuesQuery = screenService.getEditingService()
							.getDataService().getQueryService()
							.getValuesQuery((CDOID) data, reference);
					System.out.println(valuesQuery);
					MessageDialog.openInformation(Display.getCurrent()
							.getActiveShell(), "SQL Query", valuesQuery);
				}
			}
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

			// System.out.println("Updating filter with from=" + from + ", to="
			// + to);

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

	/*
	 * get the content for this resource.
	 */
	private Object[] itemsForNetXResource() {
		if (this.baseResource instanceof NetXResource) {

			NetXResource res = (NetXResource) this.baseResource;
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

			List<MetricValueRange> mvrList = Lists.newArrayList(res
					.getMetricValueRanges());
			Collections.sort(mvrList, modelUtils.mvrCompare());
			for (MetricValueRange mvr : mvrList) {
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
		return new Object[0];
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

		this.from = from;
		this.to = to;

		viewerComponent.applyFilter();

	}

	/**
	 * 
	 * Refer to the content provider, we assume an array of Objects with defined
	 * object types for each index.
	 * 
	 * <ul>
	 * <li>Column 0 => should be a a Date object</li>
	 * <li>Column > 0 => should be a a Double object</li>
	 * </ul>
	 * 
	 * If we have a marker for the date, we will style the cell according to the
	 * marker type.
	 * 
	 * @author Christophe
	 */
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
							// find a marker for this date.
							Styler markerStyle = null;
							if (d != null && markers != null
									&& markers.size() > 0) {

								try {
									Marker marker = Iterables.find(markers,
											modelUtils.markerForDate(d));

									if (marker != null
											&& marker instanceof ToleranceMarker) {
										ToleranceMarker tm = (ToleranceMarker) marker;
										LevelKind level = tm.getLevel();
										switch (level.getValue()) {
										case LevelKind.RED_VALUE: {
											markerStyle = StyledString
													.createColorRegistryStyler(
															ScreenUtil.RED_MARKER,
															null);
										}
											break;
										case LevelKind.AMBER_VALUE: {
											markerStyle = StyledString
													.createColorRegistryStyler(
															ScreenUtil.AMBER_MARKER,
															null);
										}
											break;
										case LevelKind.YELLOW_VALUE: {
											markerStyle = StyledString
													.createColorRegistryStyler(
															ScreenUtil.YELLOW_MARKER,
															null);
										}
										}
									}
								} catch (NoSuchElementException nsee) {
									// interresting API, from Iterables.find
									// @!@##
								}
							}
							StyledString styledString = new StyledString();
							if (markerStyle != null) {
								styledString.append(ts, markerStyle);
							} else {
								styledString.append(ts);
							}
							cell.setText(styledString.getString());
							cell.setStyleRanges(styledString.getStyleRanges());
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
		// Leaves behind an empty table with no columns etc..

		// FIXME, Do empty in the underlying component.
		// this.valuesTableViewer.setInput(Collections.EMPTY_LIST);
		// res = null;
		// buildColumns();
	}

	// public class MonitorAction extends BaseSelectionListenerAction {
	//
	// public MonitorAction(String text, int style) {
	// super(text);
	// }
	//
	// @Override
	// protected boolean updateSelection(IStructuredSelection selection) {
	//
	// // if (currentValues == null || currentValues.size() == 0) {
	// // return false;
	// // }
	// // // Don't allow monitoring for
	// // if (targetInterval == CAPACITIES || targetInterval == UTILIZATION) {
	// // return false;
	// // } else {
	// // return true;
	// // }
	//
	// return true;
	//
	// }
	//
	// @Override
	// public void run() {
	//
	//
	//
	// if (res instanceof NetXResource && targetInterval > 0) {
	// MetricValueRange mvr = modelUtils.valueRangeForInterval(
	// (NetXResource) res, targetInterval);
	// if (mvr != null) {
	//
	// // XMLGregorianCalendar start = mvr.getMetricValues()
	// // .get(0).getTimeStamp();
	// // XMLGregorianCalendar end = mvr.getMetricValues()
	// // .get(mvr.getMetricValues().size() - 1)
	// // .getTimeStamp();
	//
	// XMLGregorianCalendar to = modelUtils.toXMLDate(dateTimeTo
	// .getSelection());
	// XMLGregorianCalendar from = modelUtils
	// .toXMLDate(dateTimeFrom.getSelection());
	//
	// DateTimeRange timerange = GenericsFactory.eINSTANCE
	// .createDateTimeRange();
	//
	// timerange.setBegin(from);
	// timerange.setEnd(to);
	//
	// ResourceMonitorScreen monitorScreen = new ResourceMonitorScreen(
	// screenService.getScreenContainer(), SWT.NONE);
	// monitorScreen.setOperation(ScreenUtil.OPERATION_READ_ONLY);
	// monitorScreen.setScreenService(screenService);
	// monitorScreen.injectData(null, res, timerange,
	// targetInterval);
	// screenService.setActiveScreen(monitorScreen);
	// }
	// } else {
	// System.out
	// .println("Invalid target interval <= 0, perhaps the interval was not set properly in the mapping");
	// }
	// }
	// }

}
