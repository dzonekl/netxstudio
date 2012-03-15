package com.netxforge.netxstudio.screens.f4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.window.ToolTip;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.google.common.collect.Iterables;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MappingRecord;
import com.netxforge.netxstudio.metrics.MappingStatistic;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.screens.common.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.actions.WarningDeleteCommand;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;

public class MappingStatistics extends AbstractScreen implements
		IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table recordsTable;
	private Form frmMappingStatistics;
	private MetricSource metricSource;
	// private ListViewer statisticsListViewer;
	private Text txtTotalRecords;
	private Text txtStartDateTime;
	private Text txtEndDateTime;

	private TableViewer tblViewerRecords;
	private Text txtMessage;
	private CleanStatsAction cleanStatsAction;
	private TreeViewer statisticsTreeViewer;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public MappingStatistics(Composite parent, int style) {
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

		frmMappingStatistics = toolkit.createForm(this);
		frmMappingStatistics.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmMappingStatistics);
		frmMappingStatistics.setText("Mapping Statistics: "
				+ metricSource.getName());
		frmMappingStatistics.getBody().setLayout(new FormLayout());

		cleanStatsAction = new CleanStatsAction("Clean up...");

		frmMappingStatistics.getMenuManager().add(cleanStatsAction);

		SashForm sashForm = new SashForm(frmMappingStatistics.getBody(),
				SWT.NONE);
		FormData fd_sashForm = new FormData();
		fd_sashForm.bottom = new FormAttachment(100, -12);
		fd_sashForm.right = new FormAttachment(100, -12);
		fd_sashForm.top = new FormAttachment(0, 12);
		fd_sashForm.left = new FormAttachment(0, 12);
		sashForm.setLayoutData(fd_sashForm);
		toolkit.adapt(sashForm);
		toolkit.paintBordersFor(sashForm);

		Section sctnStatistics = toolkit.createSection(sashForm,
				Section.EXPANDED | Section.TITLE_BAR);
		toolkit.paintBordersFor(sctnStatistics);
		sctnStatistics.setText("Statistics");

		Composite cmpSelector = toolkit.createComposite(sctnStatistics,
				SWT.NONE);
		toolkit.paintBordersFor(cmpSelector);
		sctnStatistics.setClient(cmpSelector);
		cmpSelector.setLayout(new FillLayout(SWT.HORIZONTAL));

		statisticsTreeViewer = new TreeViewer(cmpSelector, SWT.BORDER
				| SWT.MULTI);
		Tree tree = statisticsTreeViewer.getTree();
		toolkit.paintBordersFor(tree);

		// statisticsListViewer = new ListViewer(cmpSelector, SWT.BORDER
		// | SWT.V_SCROLL);

		// TODO, convert to an action.
		Menu menu = new Menu(statisticsTreeViewer.getTree());
		statisticsTreeViewer.getTree().setMenu(menu);

		MenuItem mntmMore = new MenuItem(menu, SWT.NONE);
		mntmMore.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Show the period etc..
				ISelection selection = statisticsTreeViewer.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object o = ((IStructuredSelection) selection)
							.getFirstElement();
					if (o instanceof MappingStatistic) {

						// Create a predicate for filtering the values within a
						// range.
						MappingStatistic mappingStatistics = (MappingStatistic) o;

						final int targetIntervalHint = mappingStatistics
								.getIntervalEstimate();

						Resource metricResource = editingService
								.getData(MetricsPackage.Literals.METRIC);
						List<NetXResource> resourcesInMetricSource = modelUtils
								.resourcesInMetricSource(
										metricResource.getContents(),
										metricSource);
						if (resourcesInMetricSource.isEmpty()) {
							System.out
									.println("No resources for this metricsource");
							return;
						}

						DateTimeRange dtr = mappingStatistics
								.getPeriodEstimate();

						System.out.println("VALUES FOR PERIOD:");

						System.out.println("FROM="
								+ modelUtils.dateAndTime(dtr.getBegin()));
						System.out.println("TO="
								+ modelUtils.dateAndTime(dtr.getEnd()));

						int valueCount = 0;
						for (NetXResource res : resourcesInMetricSource) {
							System.out.println("values for resource: "
									+ res.getShortName() + "on Component"
									+ res.getComponentRef().getName());

							List<Value> values = modelUtils
									.valueRangeForIntervalKindAndPeriod(res,
											targetIntervalHint, null, dtr);
							if (values.size() > 0) {
								valueCount += values.size();
								System.out.println("number of values "
										+ Iterables.size(values));
								for (Value v : values) {
									System.out.println(modelUtils.fromXMLDate(v
											.getTimeStamp())
											+ ":"
											+ v.getValue());
								}
							}
						}
						System.out.println("total values for this import = "
								+ valueCount);

					}
				}
			}
		});
		mntmMore.setText("Values...");

		MenuItem mntmDelete = new MenuItem(menu, SWT.NONE);
		mntmDelete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Show the period etc..
				ISelection selection = statisticsTreeViewer.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object o = ((IStructuredSelection) selection)
							.getFirstElement();
					if (o instanceof MappingStatistic) {
						MappingStatistic mappingStatistics = (MappingStatistic) o;
						final int targetIntervalHint = mappingStatistics
								.getIntervalEstimate();
						Resource metricResource = editingService
								.getData(MetricsPackage.Literals.METRIC);
						List<NetXResource> resourcesInMetricSource = modelUtils
								.resourcesInMetricSource(
										metricResource.getContents(),
										metricSource);
						DateTimeRange dtr = mappingStatistics
								.getPeriodEstimate();

						for (NetXResource res : resourcesInMetricSource) {
							List<Value> values = modelUtils
									.valueRangeForIntervalKindAndPeriod(res,
											targetIntervalHint, null, dtr);
							if (values.size() > 0) {
								WarningDeleteCommand dc = new WarningDeleteCommand(
										editingService.getEditingDomain(),
										values);
								editingService.getEditingDomain()
										.getCommandStack().execute(dc);
							}
						}
					}
				}
			}
		});
		mntmDelete.setText("Purge import...");

		Section sctnSummary = toolkit.createSection(sashForm, Section.EXPANDED
				| Section.TITLE_BAR);
		toolkit.paintBordersFor(sctnSummary);
		sctnSummary.setText("Summary");

		Composite composite = toolkit.createComposite(sctnSummary, SWT.NONE);
		toolkit.paintBordersFor(composite);
		sctnSummary.setClient(composite);
		composite.setLayout(new GridLayout(2, false));

		Label lblStatus = toolkit.createLabel(composite, "Status:", SWT.NONE);
		lblStatus.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false,
				1, 1));

		txtMessage = toolkit.createText(composite, "New Text", SWT.READ_ONLY
				| SWT.WRAP | SWT.MULTI | SWT.V_SCROLL);
		txtMessage.setText("");
		GridData gd_txtMessage = new GridData(SWT.FILL, SWT.TOP, true, false,
				1, 1);
		gd_txtMessage.heightHint = 93;
		txtMessage.setLayoutData(gd_txtMessage);

		Label lblTotalRecordsProcessed = toolkit.createLabel(composite,
				"Total rows processed: ", SWT.NONE);
		lblTotalRecordsProcessed.setLayoutData(new GridData(SWT.RIGHT,
				SWT.CENTER, false, false, 1, 1));

		txtTotalRecords = toolkit.createText(composite, "New Text",
				SWT.READ_ONLY);
		txtTotalRecords.setText("");
		txtTotalRecords.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1));

		Label lblStartDatetime = toolkit.createLabel(composite,
				"Start Date/Time:", SWT.NONE);
		lblStartDatetime.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));

		txtStartDateTime = toolkit.createText(composite, "New Text",
				SWT.READ_ONLY);
		txtStartDateTime.setText("");
		txtStartDateTime.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Label lblEndDatetime = toolkit.createLabel(composite, "End Date/Time:",
				SWT.NONE);
		lblEndDatetime.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		txtEndDateTime = toolkit.createText(composite, "New Text",
				SWT.READ_ONLY);
		txtEndDateTime.setText("");
		txtEndDateTime.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Composite filler = toolkit.createComposite(composite, SWT.NONE);
		GridData gd_filler = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				2, 1);
		gd_filler.heightHint = 30;
		filler.setLayoutData(gd_filler);
		toolkit.paintBordersFor(filler);

		tblViewerRecords = new TableViewer(composite, SWT.BORDER
				| SWT.FULL_SELECTION);
		recordsTable = tblViewerRecords.getTable();
		recordsTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false,
				true, 2, 1));
		recordsTable.setLinesVisible(true);
		recordsTable.setHeaderVisible(true);
		toolkit.paintBordersFor(recordsTable);

		MappingRecordErrorToolTipSupport.enableFor(tblViewerRecords,
				ToolTip.NO_RECREATE);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				tblViewerRecords, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(40);
		tblclmnNewColumn.setText("Count");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				tblViewerRecords, SWT.NONE);
		TableColumn tblclmnColumn = tableViewerColumn_1.getColumn();
		tblclmnColumn.setWidth(40);
		tblclmnColumn.setText("Column");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(
				tblViewerRecords, SWT.NONE);
		TableColumn tblclmnMessage = tableViewerColumn_2.getColumn();
		tblclmnMessage.setWidth(400);
		tblclmnMessage.setText("Message");
		sashForm.setWeights(new int[] { 3, 7 });
	}

	class CleanStatsAction extends Action {

		public CleanStatsAction(String text) {
			super(text);
		}

		@Override
		public void run() {

			if (metricSource.getStatistics().isEmpty()) {
				return;
			}

			boolean openQuestion = MessageDialog
					.openQuestion(
							MappingStatistics.this.getShell(),
							"Clean previous statistics",
							"When pressing OK, the statistics for this metric source will be cleared\nThis action can not be reverted");

			if (openQuestion) {
				// yes selected.
				// Should also delete all contained objects like
				// MappingRecord etc..

				DeleteCommand dc = new DeleteCommand(
						editingService.getEditingDomain(),
						metricSource.getStatistics());
				editingService.getEditingDomain().getCommandStack().execute(dc);

				if (editingService.isDirty()) {
					editingService.doSave(new NullProgressMonitor());
				}
			}
		}
	}

	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext bindingContext = new EMFDataBindingContext();

		ObservableListTreeContentProvider treeContentProvider = new ObservableListTreeContentProvider(
				new IObservableFactory() {

					private IEMFListProperty subStatisticsObservableProperty = EMFEditProperties
							.list(editingService.getEditingDomain(),
									MetricsPackage.Literals.MAPPING_STATISTIC__SUB_STATISTICS);

					public IObservable createObservable(Object target) {
						IObservable ol = null;

						if (target instanceof IObservableList) {
							ol = (IObservable) target;
						} else if (target instanceof MappingStatistic) {
							ol = subStatisticsObservableProperty
									.observe(target);
						}
						return ol;
					}

				}, new TreeStructureAdvisor() {
					@Override
					public Object getParent(Object element) {

						if (element instanceof EObject) {
							EObject eo = (EObject) element;
							if (eo.eContainer() != null) {
								return eo.eContainer();
							}
						}
						return null;
					}

					@Override
					public Boolean hasChildren(Object element) {

						if (element instanceof MappingStatistic) {
							// TODO.
							return ((MappingStatistic) element)
									.getSubStatistics().size() > 0 ? Boolean.TRUE
									: null;

						}
						return super.hasChildren(element);
					}
				});

		statisticsTreeViewer.setContentProvider(treeContentProvider);

		// ObservableListContentProvider listContentProvider = new
		// ObservableListContentProvider();
		// statisticsListViewer.setContentProvider(listContentProvider);

		IObservableMap[] observeMaps = EMFObservables
				.observeMaps(
						treeContentProvider.getKnownElements(),
						new EStructuralFeature[] { MetricsPackage.Literals.MAPPING_STATISTIC__MESSAGE });
		statisticsTreeViewer
				.setLabelProvider(new StatisticObservableMapLabelProvider(
						observeMaps));

		// Cool, observer the whole resource.
		IEMFListProperty l = EMFProperties
				.list(MetricsPackage.Literals.METRIC_SOURCE__STATISTICS);

		IObservableList metricSourceObservableList = l.observe(metricSource);

		statisticsTreeViewer.setInput(metricSourceObservableList);

		IObservableValue selectionObservable = ViewerProperties
				.singleSelection().observe(statisticsTreeViewer);

		// Observables for a single selection.

		IObservableValue messageObservable = SWTObservables.observeText(
				this.txtMessage, SWT.Modify);
		IObservableValue totalRecordsObservable = SWTObservables.observeText(
				this.txtTotalRecords, SWT.Modify);
		IObservableValue startTimeObservable = SWTObservables.observeText(
				this.txtStartDateTime, SWT.Modify);
		IObservableValue endTimeObservable = SWTObservables.observeText(
				this.txtEndDateTime, SWT.Modify);

		IEMFValueProperty messageProperty = EMFProperties
				.value(MetricsPackage.Literals.MAPPING_STATISTIC__MESSAGE);

		IEMFValueProperty totalRecordsProperty = EMFProperties
				.value(MetricsPackage.Literals.MAPPING_STATISTIC__TOTAL_RECORDS);

		IEMFValueProperty startDateTimeProperty = EMFProperties
				.value(FeaturePath
						.fromList(
								MetricsPackage.Literals.MAPPING_STATISTIC__MAPPING_DURATION,
								GenericsPackage.Literals.DATE_TIME_RANGE__BEGIN));

		IEMFValueProperty endDateTimeProperty = EMFProperties
				.value(FeaturePath
						.fromList(
								MetricsPackage.Literals.MAPPING_STATISTIC__MAPPING_DURATION,
								GenericsPackage.Literals.DATE_TIME_RANGE__END));

		EMFUpdateValueStrategy modelToTargetStrategy = new EMFUpdateValueStrategy();
		modelToTargetStrategy.setConverter(new ModelDateConverter());

		bindingContext.bindValue(messageObservable,
				messageProperty.observeDetail(selectionObservable));

		bindingContext.bindValue(totalRecordsObservable,
				totalRecordsProperty.observeDetail(selectionObservable));

		bindingContext.bindValue(startTimeObservable,
				startDateTimeProperty.observeDetail(selectionObservable), null,
				modelToTargetStrategy);

		bindingContext.bindValue(endTimeObservable,
				endDateTimeProperty.observeDetail(selectionObservable), null,
				modelToTargetStrategy);

		ObservableListContentProvider recordsContentProvider = new ObservableListContentProvider();
		tblViewerRecords.setContentProvider(recordsContentProvider);

		// IObservableMap[] recordsObserveMaps = EMFObservables.observeMaps(
		// listContentProvider.getKnownElements(),
		// new EStructuralFeature[] {
		// MetricsPackage.Literals.MAPPING_RECORD__ROW,
		// MetricsPackage.Literals.MAPPING_RECORD__COLUMN,
		// MetricsPackage.Literals.MAPPING_RECORD__MESSAGE, });
		tblViewerRecords
				.setLabelProvider(new RecordsObservableMapLabelProvider());

		IEMFListProperty recordsProperty = EMFProperties
				.list(MetricsPackage.Literals.MAPPING_STATISTIC__FAILED_RECORDS);

		tblViewerRecords.setInput(recordsProperty
				.observeDetail(selectionObservable));

		return bindingContext;
	}

	class ModelDateConverter implements IConverter {

		public Object getFromType() {
			return XMLGregorianCalendar.class;
		}

		public Object getToType() {
			return String.class;
		}

		public Object convert(Object fromObject) {
			if (fromObject instanceof XMLGregorianCalendar) {
				Date d = modelUtils
						.fromXMLDate((XMLGregorianCalendar) fromObject);
				return modelUtils.date(d) + " @ " + modelUtils.time(d);
			}

			return null;
		}
	}

	class RecordsObservableMapLabelProvider extends CellLabelProvider {

		public String getToolTipText(Object element) {

			if (element instanceof MappingRecord) {
				MappingRecord mr = (MappingRecord) element;

				StringBuilder sb = new StringBuilder();
				sb.append("<html><body>");
				StringReader stringReader = new StringReader(mr.getMessage());
				BufferedReader bufferedReader = new BufferedReader(stringReader);
				String line;
				try {
					while ((line = bufferedReader.readLine()) != null) {
						sb.append("line: " + line);
					}
				} catch (IOException e) {
				}
				sb.append("</body></html>");

				return sb.toString();
			} else {
				return null;
			}

		}

		public Point getToolTipShift(Object object) {
			return new Point(5, 5);
		}

		public int getToolTipDisplayDelayTime(Object object) {
			return 500;
		}

		public int getToolTipTimeDisplayed(Object object) {
			return 5000;
		}

		@Override
		public void update(ViewerCell cell) {

			int columnIndex = cell.getColumnIndex();
			Object element = cell.getElement();

			if (element instanceof MappingRecord) {

				MappingRecord mr = (MappingRecord) element;
				switch (columnIndex) {
				case 0: {
					String count = new Long(mr.getCount()).toString();
					cell.setText(count);
				}
					break;
				case 1: {
					String column = mr.getColumn();
					if (column.equals("-1")) {
						cell.setText("N/A");
					} else {
						cell.setText(column);
					}
				}
					break;
				case 2: {
					cell.setText(mr.getMessage());
				}
					break;
				}
			}
		}
	}

	private static class MappingRecordErrorToolTipSupport extends
			ColumnViewerToolTipSupport {

		protected MappingRecordErrorToolTipSupport(ColumnViewer viewer,
				int style, boolean manualActivation) {
			super(viewer, style, manualActivation);
		}

		protected Composite createToolTipContentArea(Event event,
				Composite parent) {
			Composite comp = new Composite(parent, SWT.NONE);
			GridLayout l = new GridLayout(1, false);
			l.horizontalSpacing = 0;
			l.marginWidth = 0;
			l.marginHeight = 0;
			l.verticalSpacing = 0;

			comp.setLayout(l);
			Browser browser = new Browser(comp, SWT.BORDER);
			browser.setText(getText(event));
			browser.setLayoutData(new GridData(200, 150));

			return comp;
		}

		public boolean isHideOnMouseDown() {
			return false;
		}

		public static final void enableFor(ColumnViewer viewer, int style) {
			new MappingRecordErrorToolTipSupport(viewer, style, false);
		}
	}

	class StatisticObservableMapLabelProvider extends
			ObservableMapLabelProvider {

		// public StatisticObservableMapLabelProvider(
		// IObservableMap[] attributeMaps) {
		// super(attributeMaps);
		// }
		//
		// public StatisticObservableMapLabelProvider(IObservableMap
		// attributeMap) {
		// super(attributeMap);
		// }
		//
		// public String getToolTipText(Object element) {
		// return "<html><body>Tooltip (" + element + ")</body></html>";
		// }
		//
		// public Point getToolTipShift(Object object) {
		// return new Point(5, 5);
		// }
		//
		// public int getToolTipDisplayDelayTime(Object object) {
		// return 2000;
		// }
		//
		// public int getToolTipTimeDisplayed(Object object) {
		// return 5000;
		// }
		//
		// public void update(ViewerCell cell) {
		//
		// Object element = cell.getElement();
		//
		// if (element instanceof MappingStatistic) {
		// MappingStatistic s = (MappingStatistic) element;
		// cell.setText(s.getMessage() + "[" + s.getTotalRecords() + "]");
		// }
		// }

		public StatisticObservableMapLabelProvider(
				IObservableMap[] attributeMaps) {
			super(attributeMaps);
		}

		@Override
		public String getText(Object element) {

			if (element instanceof MappingStatistic) {
				MappingStatistic s = (MappingStatistic) element;

				StringBuilder sb = new StringBuilder();

				if (s.eIsSet(MetricsPackage.Literals.MAPPING_STATISTIC__MAPPING_DURATION)) {
					DateTimeRange durationEstimate = s.getMappingDuration();
					if (durationEstimate.getBegin() != null
							&& durationEstimate.getEnd() != null) {
						Date start = modelUtils.begin(durationEstimate);
						Date end = modelUtils.end(durationEstimate);

						if (s.eContainer() != null
								&& !(s.eContainer() instanceof MappingStatistic)) {
							// we are the parent.
							sb.append("Scan started on: "
									+ modelUtils.date(start) + " @ "
									+ modelUtils.time(start));
						} else {

							long ms = (end.getTime() - start.getTime());

							sb.append("Duration : "
									+ (ms > 1000 ? (ms / 1000 + " (sec) : ")
											: ms + " (ms) ") + "ended on "
									+ modelUtils.date(start) + " @ "
									+ modelUtils.timeAndSeconds(end));
						}
					}
				} else {
					sb.append(s.getMessage());
				}
				sb.append(" , Total rows=[" + s.getTotalRecords() + "]");
				return sb.toString();
			}
			return super.getText(element);
		}
	}

	public void disposeData() {
		// N/A
	}

	public void injectData(Object owner, Object object) {
		if (object instanceof MetricSource) {
			metricSource = (MetricSource) object;
		}

		buildUI();
		this.initDataBindings_();
	}

	public void addData() {
		// N/A Read-only view.

	}

	public Viewer getViewer() {
		// return this.statisticsListViewer;
		return this.statisticsTreeViewer;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	public Form getScreenForm() {
		return this.frmMappingStatistics;
	}

	public String getScreenName() {
		return "Mapping Statistics";
	}
}
