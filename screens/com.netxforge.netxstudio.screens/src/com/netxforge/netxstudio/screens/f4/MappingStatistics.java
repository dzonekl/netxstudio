/*******************************************************************************
 * Copyright (c) Apr 21, 2012 NetXForge.
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
package com.netxforge.netxstudio.screens.f4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.databinding.observable.value.ComputedValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.util.CommitException;
import org.eclipse.emf.cdo.view.CDOView;
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
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
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
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.window.ToolTip;
import org.eclipse.net4j.util.concurrent.IRWLockManager.LockType;
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
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.data.importer.IMetricValueImporter;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MappingRecord;
import com.netxforge.netxstudio.metrics.MappingStatistic;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.CDOElementComparer;
import com.netxforge.netxstudio.screens.editing.actions.BaseSelectionListenerAction;
import com.netxforge.netxstudio.screens.editing.actions.WarningDeleteCommand;
import com.netxforge.netxstudio.screens.editing.actions.clipboard.ClipboardService;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;

/**
 * A screen presenting {@link MetricSource} mapping statistics
 * 
 * @author Christophe Bouhier
 */
public class MappingStatistics extends AbstractScreen implements
		IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Form frmMappingStatistics;
	private MetricSource metricSource;
	private Text txtTotalRecords;
	private Text txtStartDateTime;
	private Text txtEndDateTime;
	private Text txtTotalValues;
	private Text txtTotalFailedValues;
	private Text txtMessage;

	private TableViewer tblViewerRecords;

	private CleanStatsAction cleanStatsAction;
	private TreeViewer statisticsTreeViewer;
	private Tree statisticsTree;
	private Table recordsTable;

	@Inject
	private ClipboardService clipboard;

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

	/**
	 * Copies the selected records as text to the clipboard....
	 * 
	 * @author Christophe
	 * 
	 */
	class CopyMappingErrorAction extends BaseSelectionListenerAction {

		protected CopyMappingErrorAction(String text) {
			super(text);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.netxforge.netxstudio.screens.editing.actions.
		 * BaseSelectionListenerAction
		 * #updateSelection(org.eclipse.jface.viewers.IStructuredSelection)
		 */
		@Override
		protected boolean updateSelection(IStructuredSelection selection) {
			Object firstElement = selection.getFirstElement();
			return firstElement instanceof MappingRecord;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.action.Action#run()
		 */
		@Override
		public void run() {
			IStructuredSelection structuredSelection = this
					.getStructuredSelection();
			Object firstElement = structuredSelection.getFirstElement();
			if (firstElement instanceof MappingRecord) {
				System.out.println(" yeah valid action for this object");
			}

		}

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
		statisticsTreeViewer.setUseHashlookup(true);
		statisticsTreeViewer.setComparer(new CDOElementComparer());
		statisticsTree = statisticsTreeViewer.getTree();
		toolkit.paintBordersFor(statisticsTree);

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
									.valuesForIntervalKindAndPeriod(res,
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
									.valuesForIntervalKindAndPeriod(res,
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

		Label lblTotalRecordsProcessed = toolkit.createLabel(composite,
				"Total rows processed: ", SWT.NONE);
		lblTotalRecordsProcessed.setLayoutData(new GridData(SWT.RIGHT,
				SWT.CENTER, false, false, 1, 1));

		txtTotalRecords = toolkit.createText(composite, "New Text",
				SWT.READ_ONLY);
		txtTotalRecords.setText("");
		txtTotalRecords.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Label lblTotalExpectedValues = toolkit.createLabel(composite,
				"Total values:", SWT.NONE);

		lblTotalExpectedValues.setLayoutData(new GridData(SWT.RIGHT,
				SWT.CENTER, false, false, 1, 1));
		txtTotalValues = toolkit.createText(composite, "New Text",
				SWT.READ_ONLY);
		txtTotalValues.setText("");
		txtTotalValues.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		txtTotalValues
				.setToolTipText("Total values is the # of metrics * the number of rows");

		Label lblTotalFailedValues = toolkit.createLabel(composite,
				"Total Failed Values", SWT.NONE);
		lblTotalFailedValues.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));
		txtTotalFailedValues = toolkit.createText(composite, "New Text",
				SWT.READ_ONLY);
		txtTotalFailedValues.setText("");
		txtTotalFailedValues.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1));

		// Composite filler = toolkit.createComposite(composite, SWT.NONE);
		// GridData gd_filler = new GridData(SWT.LEFT, SWT.CENTER, false, false,
		// 2, 1);
		// gd_filler.heightHint = 30;
		// filler.setLayoutData(gd_filler);
		// toolkit.paintBordersFor(filler);

		tblViewerRecords = new TableViewer(composite, SWT.BORDER
				| SWT.FULL_SELECTION | SWT.MULTI);

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

				CDOView cdoView = metricSource.cdoView();
				if (cdoView instanceof CDOTransaction) {
					CDOTransaction cdoTransaction = (CDOTransaction) cdoView;
					try {
						cdoTransaction.lockObjects(
								metricSource.getStatistics(), LockType.WRITE,
								1000);
						metricSource.getStatistics().clear();
						cdoTransaction.unlockObjects(
								metricSource.getStatistics(), LockType.WRITE);
						cdoTransaction.commit();

					} catch (InterruptedException e) {
						// we are interrupted.
						e.printStackTrace();
					} catch (CommitException e) {
						// we can not commit.
						e.printStackTrace();
					}
				}

				// DeleteCommand dc = new DeleteCommand(
				// editingService.getEditingDomain(),
				// metricSource.getStatistics());
				// editingService.getEditingDomain().getCommandStack().execute(dc);
				//
				// if (editingService.isDirty()) {
				// editingService.doSave(new NullProgressMonitor());
				// }
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
							return ((MappingStatistic) element)
									.getSubStatistics().size() > 0 ? Boolean.TRUE
									: null;

						}
						return super.hasChildren(element);
					}
				});

		statisticsTreeViewer.setContentProvider(treeContentProvider);

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

		/**
		 * Set a comparator to sort our columns, only sort the objects of type
		 * 
		 */
		statisticsTreeViewer.setComparator(new ViewerComparator() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.jface.viewers.ViewerComparator#category(java.lang
			 * .Object)
			 */
			@Override
			public int category(Object element) {

				// Set categories for our objects, only interrested in Service
				// flows for now.
				if (element instanceof MappingStatistic)
					return 1;
				return super.category(element);
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.jface.viewers.ViewerComparator#compare(org.eclipse
			 * .jface.viewers.Viewer, java.lang.Object, java.lang.Object)
			 */
			@Override
			public int compare(Viewer viewer, Object e1, Object e2) {
				int cat1 = category(e1);
				int cat2 = category(e2);

				if (cat1 != cat2) {
					return cat1 - cat2;
				}

				if (e1 instanceof MappingStatistic
						&& e2 instanceof MappingStatistic) {
					MappingStatistic ms1 = (MappingStatistic) e1;
					MappingStatistic ms2 = (MappingStatistic) e2;

					if (ms1.eIsSet(MetricsPackage.Literals.MAPPING_STATISTIC__MAPPING_DURATION)
							&& ms2.eIsSet(MetricsPackage.Literals.MAPPING_STATISTIC__MAPPING_DURATION)) {
						return ms2.getMappingDuration().getBegin()
								.compare(ms1.getMappingDuration().getBegin());
					}
				}
				return 0; // Do not compare other types.
				// return super.compare(viewer, e1, e2);
			}

		});

		final IObservableValue selectionObservable = ViewerProperties
				.singleSelection().observe(statisticsTreeViewer);

		// Observables for a single selection.

		IObservableValue messageObservable = SWTObservables.observeText(
				this.txtMessage, SWT.None);
		IObservableValue totalRecordsObservable = SWTObservables.observeText(
				this.txtTotalRecords, SWT.None);
		IObservableValue startTimeObservable = SWTObservables.observeText(
				this.txtStartDateTime, SWT.None);
		IObservableValue endTimeObservable = SWTObservables.observeText(
				this.txtEndDateTime, SWT.None);
		IObservableValue totalExpectedValuesObservable = SWTObservables
				.observeText(this.txtTotalValues, SWT.None);
		IObservableValue totalFailedValuesObservable = SWTObservables
				.observeText(this.txtTotalFailedValues, SWT.None);

		IEMFValueProperty messageProperty = EMFProperties
				.value(MetricsPackage.Literals.MAPPING_STATISTIC__MESSAGE);

		final IEMFValueProperty totalRecordsProperty = EMFProperties
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

		ComputedValue computedTotalExpectedValue = new ComputedValue() {

			@Override
			protected Object calculate() {
				Object value = totalRecordsProperty.observeDetail(
						selectionObservable).getValue();
				if (value instanceof Integer) {

					return new Integer(modelUtils.metricsInMetricSource(
							metricSource).size()
							* (Integer) value).toString();
				}
				return 0;
			}

		};

		ComputedValue computedTotalFailedValue = new ComputedValue() {

			@Override
			protected Object calculate() {
				Object selectedObject = selectionObservable.getValue();
				// recursively compute for sub-statistics.
				if (selectedObject instanceof MappingStatistic) {
					return new Integer(
							modelUtils
									.mappingFailedCount((MappingStatistic) selectedObject))
							.toString();
				}
				return 0;
			}
		};

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

		bindingContext.bindValue(totalExpectedValuesObservable,
				computedTotalExpectedValue);

		bindingContext.bindValue(totalFailedValuesObservable,
				computedTotalFailedValue);

		// bindingContext.bindValue(totalExpectedValuesObservable,
		// computedTotalExpectedValue, new UpdateValueStrategy(false,
		// UpdateValueStrategy.POLICY_NEVER), null);
		//
		// bindingContext.bindValue(totalFailedValuesObservable,
		// computedTotalFailedValue, new UpdateValueStrategy(false,
		// UpdateValueStrategy.POLICY_NEVER), null);

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

		public abstract class MappingRecordErrorProcessor {

			String errorDescription;

			public String lookupError(String code) {
				try {
					Integer codeAsInt = new Integer(code);
					return IMetricValueImporter.IMPORT_ERROR_TEXT[codeAsInt];
				} catch (NumberFormatException nfe) {
					return "Mapping error code not supported (Old Format)";
				}
			}

			/**
			 * @param mr
			 * @param sb
			 */
			public String spiltMappingRecordMsg(MappingRecord mr,
					StringBuilder sb) {
				StringReader stringReader = new StringReader(mr.getMessage());
				BufferedReader bufferedReader = new BufferedReader(stringReader);
				try {
					String line;
					boolean firstLine = true;
					while ((line = bufferedReader.readLine()) != null) {
						String[] split = line.split(":");
						if (firstLine) {
							// This should be the error code.
							String string = split[0];
							errorDescription = lookupError(string);
							String[] reducedWithoutError = Arrays.copyOfRange(
									split, 1, split.length - 1);

							processErrorDescription(sb, errorDescription);
							processLines(sb, reducedWithoutError);

							firstLine = false;
						} else {
							processLines(sb, split);
						}

					}
				} catch (IOException e) {
				}
				return sb.toString();

			}

			protected abstract void processErrorDescription(StringBuilder sb,
					String errorDescription);

			protected abstract void processLines(StringBuilder sb,
					String[] splits);

			public String getErrorDescription() {
				return errorDescription;
			}
		}

		public String getToolTipText(Object element) {

			if (element instanceof MappingRecord) {
				MappingRecord mr = (MappingRecord) element;

				StringBuilder sb = new StringBuilder();
				sb.append("<html><body>");
				sb.append("<table>");
				new MappingRecordErrorProcessor() {
					@Override
					protected void processErrorDescription(StringBuilder sb,
							String errorDescription) {
						sb.append("<tr>" + errorDescription + "</tr>");
					}

					@Override
					protected void processLines(StringBuilder sb,
							String[] splits) {
						sb.append("<tr>");
						for (int i = 0; i < splits.length; i++) {
							String s = splits[i];
							sb.append("<td>" + s + "</td>");
						}
						sb.append("</tr>");
					}

				}.spiltMappingRecordMsg(mr, sb);
				sb.append("</table>");
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
			return 10000;
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
					if (column != null) {
						if (column.equals("-1")) {
							cell.setText("N/A");
						} else {
							cell.setText(column);
						}
					}
				}
					break;
				case 2: {
					StringBuilder sb = new StringBuilder();
					new MappingRecordErrorProcessor() {
						@Override
						protected void processErrorDescription(
								StringBuilder sb, String errorDescription) {
							sb.append(errorDescription + " ");
						}

						@Override
						protected void processLines(StringBuilder sb,
								String[] splits) {
							for (String s : splits) {
								sb.append(s + " - ");
							}
						}

					}.spiltMappingRecordMsg(mr, sb);

					cell.setText(sb.toString());
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

			String tooltipText = getText(event);
			// System.out.println(tooltipText.length());

			comp.setLayout(l);
			Browser browser = new Browser(comp, SWT.BORDER);
			browser.setText(tooltipText);
			browser.setLayoutData(new GridData(400, 300));

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
		registerFocus(this);
		this.initDataBindings_();
	}

	public void addData() {
		// N/A Read-only view.

	}

	public Viewer getViewer() {
		return this.statisticsTreeViewer;
	}

	@Override
	public Viewer[] getViewers() {
		return new Viewer[] { statisticsTreeViewer, tblViewerRecords };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.screens.AbstractScreenImpl#
	 * resolveSelectionProviderFromWidget(java.lang.Object)
	 */
	@Override
	protected ISelectionProvider resolveSelectionProviderFromWidget(
			Object widget) {

		if (widget == statisticsTree) {
			return statisticsTreeViewer;
		} else if (widget == recordsTable) {
			return tblViewerRecords;
		}

		return super.resolveSelectionProviderFromWidget(widget);
	}

	List<IAction> actionList = Lists.newArrayList();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.screens.AbstractScreenImpl#getActions()
	 */
	@Override
	public IAction[] getActions() {
		if (actionList.size() == 0) {
			actionList.add(new CopyMappingErrorAction("Copy error..."));
		}

		IAction[] actions = new IAction[actionList.size()];
		actionList.toArray(actions);
		return actions;
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
