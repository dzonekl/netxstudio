/*******************************************************************************
 * Copyright (c) 26 nov. 2012 NetXForge.
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
package com.netxforge.netxstudio.screens.f4.smarts;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.ResourceManager;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.base.NonModelUtils;
import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.data.actions.ServerRequest;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricsFactory;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.JobState;
import com.netxforge.netxstudio.scheduling.MetricSourceJob;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.screens.AbstractSmartTableScreen;
import com.netxforge.netxstudio.screens.actions.ScreenAction;
import com.netxforge.netxstudio.screens.f4.MappingStatistics;
import com.netxforge.netxstudio.screens.f4.MetricSourceLabelProvider;
import com.netxforge.netxstudio.screens.f4.NewEditJob;
import com.netxforge.netxstudio.screens.f4.NewEditMetricSource;
import com.netxforge.screens.editing.base.ScreenUtil;
import com.netxforge.screens.editing.base.actions.SeparatorAction;

public class SmartMetricSources extends AbstractSmartTableScreen {

	private Form frmMetricSources;
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private CDOResource cdoResource;

	@Inject
	ServerRequest serverActions;

	public SmartMetricSources(Composite parent, int style) {
		super(parent, style);

		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
	}

	public void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmMetricSources = toolkit.createForm(this);
		frmMetricSources.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmMetricSources);
		frmMetricSources.setText("Metric Sources");
		frmMetricSources.getBody().setLayout(new GridLayout(3, false));

		frmMetricSources.getToolBarManager().add(
				new EditMetricSourceAction("", ResourceManager
						.getPluginImageDescriptor(
								"com.netxforge.netxstudio.models.edit",
								"icons/full/ctool16/Metricsource_E.png"),
						ScreenAction.NEW_MODE));

		frmMetricSources.getToolBarManager().update(true);
		super.buildUI(frmMetricSources.getBody(), "?");
	}

	public Form getScreenForm() {
		return frmMetricSources;
	}
	
	@Override
	public String getScreenName() {
		return "Metric Sources";
	}

	public EMFDataBindingContext initDataBindings_() {
		return null;
	}

	@Override
	public void injectData() {
		buildUI();
		cdoResource = (CDOResource) editingService
				.getData(MetricsPackage.Literals.METRIC_SOURCE);
		super.injectData();
		this.getLazyTableViewer().setPattern("?");
	}

	@Override
	protected List<?> delegateGetItems() {
		return cdoResource.getContents();
	}

	protected void delegateBuildColumns(TableViewer viewer) {

		TableViewerColumn tableViewerColumn = new TableViewerColumn(viewer,
				SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(300);
		tblclmnNewColumn.setText("Name");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(viewer,
				SWT.NONE);
		TableColumn tblclmnLocationUrl = tableViewerColumn_1.getColumn();
		tblclmnLocationUrl.setWidth(300);
		tblclmnLocationUrl.setText("Location URL");


		TableViewerColumn tableViewerType = new TableViewerColumn(
				viewer, SWT.NONE);
		TableColumn tblclmnType = tableViewerType.getColumn();
		tblclmnType.setWidth(60);
		tblclmnType.setText("Mapping Type");

		TableViewerColumn tableViewerFilterPattern = new TableViewerColumn(
				viewer, SWT.NONE);
		TableColumn tblclmnFilterPattern = tableViewerFilterPattern.getColumn();
		tblclmnFilterPattern.setWidth(300);
		tblclmnFilterPattern.setText("File pattern");
		
		
	}

	@Override
	protected IBaseLabelProvider delegateGetListLabelProvider() {
		return new MetricSourceLabelProvider();
	}

	@Override
	protected boolean delegateMatchItem(Object item) {

		if (item instanceof MetricSource) {
			MetricSource t = (MetricSource) item;
			if (t.eIsSet(MetricsPackage.Literals.METRIC_SOURCE__NAME)) {
				String match = (String) t
						.eGet(MetricsPackage.Literals.METRIC_SOURCE__NAME);
				return lazyItemsFilter.matches(match);
			}
		}

		return false;
	}

	private final List<IAction> actions = Lists.newArrayList();

	@Override
	public IAction[] getActions() {
		if (actions.isEmpty()) {
			boolean readonly = ScreenUtil.isReadOnlyOperation(getOperation());
			String actionText = readonly ? "View" : "Edit";
			actions.add(new EditMetricSourceAction(actionText + "...",
					ResourceManager
					.getPluginImageDescriptor(
							"com.netxforge.netxstudio.models.edit",
							"icons/full/obj16/Metricsource_H.png"), ScreenAction.EDIT_OR_VIEW_MODE));
			actions.add(new SeparatorAction());
			if (!readonly) {

				actions.add(new ScheduleCollectionJobAction(
						"Schedule Collection Job..."));
				CollectNowAction collectNowAction = new CollectNowAction(
						"Collect Now (sorry disabled)...");
				collectNowAction.setEnabled(false);
				actions.add(collectNowAction);

			}
			actions.add(new StatisticsAction("Statistics..."));
			actions.add(new SeparatorAction());
			actions.addAll(Arrays.asList(super.getActions()));
		}

		return actions.toArray(new IAction[actions.size()]);
	}

	class ScheduleCollectionJobAction extends Action {
		public ScheduleCollectionJobAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			if (screenService != null) {
				ISelection selection = getViewer().getSelection();
				if (selection instanceof IStructuredSelection) {

					// Object o = ((IStructuredSelection) selection)
					// .getFirstElement();

					if (((IStructuredSelection) selection).size() > 0) {
						@SuppressWarnings("unchecked")
						Iterator<MetricSource> iterator = ((IStructuredSelection) selection)
								.iterator();

						List<MetricSource> metricSources = Lists
								.newArrayList(iterator);
						int operation = -1;
						boolean showJobScreen = false;
						// CB Replaced by model util.
						// List<Job> matchingJobs = editingService
						// .getDataService().getQueryService()
						// .getJobWithMetricSource((MetricSource) o);

						Resource jobResource = editingService
								.getData(SchedulingPackage.Literals.JOB);

						Job job = StudioUtils
								.jobForMultipleObjects(
										jobResource,
										SchedulingPackage.Literals.METRIC_SOURCE_JOB,
										SchedulingPackage.Literals.METRIC_SOURCE_JOB__METRIC_SOURCES,
										metricSources);

						// Edit or New if the MetricSource has a job or not.
						if (job != null) {
							operation = ScreenUtil.OPERATION_EDIT;
							showJobScreen = true;
						} else {
							// We could be dealing with a partial match.
							boolean yes = MessageDialog
									.openQuestion(
											SmartMetricSources.this.getShell(),
											"No existing job found ",
											"No existing job was found for the selected Metric Sources\n"
													+ "Do you wish to create a new job for these sources?");

							if (yes) {
								operation = ScreenUtil.OPERATION_NEW;
								job = SchedulingFactory.eINSTANCE
										.createMetricSourceJob();

								MetricSource first = metricSources.get(0);
								job.setName(first.getName()
										+ (metricSources.size() > 1 ? ",..."
												: ""));

								job.setInterval(NonModelUtils.SECONDS_IN_A_WEEK);
								job.setStartTime(NonModelUtils
										.toXMLDate(NonModelUtils.todayAndNow()));
								job.setJobState(JobState.IN_ACTIVE);
								if (job instanceof MetricSourceJob) {
									((MetricSourceJob) job).getMetricSources()
											.addAll(metricSources);
								}
								showJobScreen = true;
							} else {
								// Abort.
							}
						}
						if (showJobScreen) {
							NewEditJob newEditJob = new NewEditJob(
									screenService.getScreenContainer(),
									SWT.NONE);
							newEditJob.setOperation(operation);
							newEditJob.setScreenService(screenService);
							newEditJob.injectData(jobResource, job);
							screenService.setActiveScreen(newEditJob);
						}
					}
				}
			}
		}
	}

	class StatisticsAction extends Action {
		public StatisticsAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			ISelection selection = getViewer().getSelection();
			if (selection instanceof IStructuredSelection) {
				Object o = ((IStructuredSelection) selection).getFirstElement();

				// Reading the stats to update?
				if (o instanceof MetricSource) {
					System.out.println("stats size = "
							+ ((MetricSource) o).getStatistics().size());
				}

				MappingStatistics stats = new MappingStatistics(
						screenService.getScreenContainer(), SWT.NONE);
				stats.setOperation(ScreenUtil.OPERATION_READ_ONLY);
				stats.setScreenService(screenService);
				stats.injectData(null, o);
				screenService.setActiveScreen(stats);
			}
		}
	}

	class CollectNowAction extends Action {
		public CollectNowAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			ISelection selection = getViewer().getSelection();
			if (selection instanceof IStructuredSelection) {
				Object o = ((IStructuredSelection) selection).getFirstElement();
				if (o instanceof MetricSource) {
					final MetricSource ms = (MetricSource) o;
					try {
						serverActions.setCDOServer(getCDOEditingService().getServer());

						@SuppressWarnings("unused")
						String result = serverActions
								.callMetricImportAction(ms);

						// @SuppressWarnings("unused")
						// WorkflowRunJob workflowRunJob = serverActions
						// .jobFromRequest(result);

						MessageDialog
								.openInformation(
										SmartMetricSources.this.getShell(),
										"Collect now succeeded:",
										"Collection of data from metric source: "
												+ ms.getName()
												+ "\n has been initiated on the server.");

						// TODO, Disable for now, requires more testing.
						// workflowRunJob.addNotifier(new JobChangeAdapter() {
						//
						// @Override
						// public void done(IJobChangeEvent event) {
						// MessageDialog.openInformation(
						// MetricSources.this.getShell(),
						// "Collect now completed:",
						// "Collection of data from metric source: "
						// + ms.getName()
						// + "\n has been initiated on the server.");
						// }
						// });
						// workflowRunJob.go();

					} catch (Exception e1) {
						e1.printStackTrace();
						MessageDialog
								.openError(
										SmartMetricSources.this.getShell(),
										"Collect now failed:",
										"Collection of data from metric source: "
												+ ms.getName()
												+ "\n failed. Consult the log for information on the failure");

					}

				}
			}
		}
	}

	class FindResourcesAction extends Action {
		public FindResourcesAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			ISelection selection = getViewer().getSelection();
			if (selection instanceof IStructuredSelection) {
				Object o = ((IStructuredSelection) selection).getFirstElement();
				if (o instanceof MetricSource) {
					MetricSource ms = (MetricSource) o;
					Resource metricResource = editingService
							.getData(MetricsPackage.Literals.METRIC);
					List<NetXResource> resourcesInMetricSource = StudioUtils
							.resourcesInMetricSource(
									metricResource.getContents(), ms);
					if (resourcesInMetricSource.isEmpty()) {
						System.out
								.println("No resources for this metricsource");
					}
					for (NetXResource res : resourcesInMetricSource) {
						System.out.println("resource: " + res.getShortName());
					}
				}
			}
		}
	}

	/**
	 * Wrap in an action, to contribute to a menu manager.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	class EditMetricSourceAction extends ScreenAction {

		public EditMetricSourceAction(String text, ImageDescriptor image,
				int mode) {
			super(text, image, mode);
		}

		@Override
		protected boolean updateSelection(IStructuredSelection selection) {
			return selection.getFirstElement() instanceof MetricSource;
		}

		@Override
		public void run() {
			super.run();
			if (screenService != null) {

				if (this.getMode() == ScreenAction.EDIT_OR_VIEW_MODE) {
					ISelection selection = getViewer().getSelection();
					if (selection instanceof IStructuredSelection) {
						Object o = ((IStructuredSelection) selection)
								.getFirstElement();
						// We are going to edit this object, add it to the
						// history.
						getLazyTableViewer().addToHistory(o);

						if (o != null) {
							NewEditMetricSource editMetricSourceScreen = new NewEditMetricSource(
									screenService.getScreenContainer(),
									SWT.NONE);
							editMetricSourceScreen
									.setOperation(ScreenUtil.OPERATION_EDIT);
							editMetricSourceScreen
									.setScreenService(screenService);
							editMetricSourceScreen.injectData(cdoResource, o);
							screenService
									.setActiveScreen(editMetricSourceScreen);
						}
					}
				} else if (this.getMode() == ScreenAction.NEW_MODE) {
					NewEditMetricSource msScreen = new NewEditMetricSource(
							screenService.getScreenContainer(), SWT.NONE);
					msScreen.setOperation(ScreenUtil.OPERATION_NEW);
					msScreen.setScreenService(screenService);
					msScreen.injectData(cdoResource,
							MetricsFactory.eINSTANCE.createMetricSource());
					screenService.setActiveScreen(msScreen);
				}
			}

		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> Comparator<T> delegateGetItemsComparator() {
		Comparator<MetricSource> objectEAttributeComparator = NonModelUtils
				.<MetricSource, String> objectEAttributeComparator(MetricsPackage.Literals.METRIC_SOURCE__NAME);
		return (Comparator<T>) objectEAttributeComparator;
	}

	@Override
	public CDOView delegateGetCDOView() {
		return cdoResource.cdoView();
	}

	@Override
	protected Resource delegateGetResource() {
		return cdoResource;
	}

	@Override
	protected void delegateHandleDoubleClick() {
		getActions()[0].run();

	}
	
}
