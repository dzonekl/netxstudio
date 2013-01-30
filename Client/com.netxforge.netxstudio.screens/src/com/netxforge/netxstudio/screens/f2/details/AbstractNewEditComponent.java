/*******************************************************************************
 * Copyright (c) 11 dec. 2012 NetXForge.
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
package com.netxforge.netxstudio.screens.f2.details;

import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.nebula.widgets.datechooser.DateChooserCombo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wb.swt.ResourceManager;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Lifecycle;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.Tolerance;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.screens.AbstractDetailsScreen;
import com.netxforge.netxstudio.screens.ch9.NewEditExpression;
import com.netxforge.netxstudio.screens.common.util.DateChooserComboObservableValue;
import com.netxforge.netxstudio.screens.dialog.ExpressionFilterDialog;
import com.netxforge.netxstudio.screens.dialog.MetricFilterDialog;
import com.netxforge.netxstudio.screens.dialog.ToleranceFilterDialog;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;
import com.netxforge.netxstudio.screens.f2.NewEditResource;
import com.netxforge.netxstudio.screens.f2.support.ToleranceObservableMapLabelProvider;
import com.netxforge.netxstudio.screens.f4.support.MetricTreeLabelProvider;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;

/**
 * Abstract Component screen implementation, which can deliver various sections.
 * 
 * @author Christophe Bouhier
 * 
 */
public abstract class AbstractNewEditComponent extends AbstractDetailsScreen
		implements IDataScreenInjection {

	/**
	 * Validates the {@link Lifecycle} feature of a {@link Component}
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	private final class LifecycleValidator implements IValidator {
		public IStatus validate(Object value) {

			IStatus status = null;

			// It's OK to clear the value.
			if (value == null) {
				status = new Status(IStatus.OK, ScreensActivator.PLUGIN_ID,
						"Feature can be unset.");
			} else {
				// TODO Check if date is befoe it's predecessor.
				// Nice, chronological order of lifecycle dates.
				status = new Status(IStatus.WARNING,
						ScreensActivator.PLUGIN_ID,
						"testing warning when setting");
				// System.out.println(status + ", value=" + value.toString());
			}
			return status;
		}
	}

	final IEditingService editingService;

	// Resource section.
	private Text txtCapExpression;
	private Text txtUtilExpression;
	private TableViewer resourceTableViewer;

	// Tolerances section.
	private TableViewer tolerancesTableViewer;

	// Metrics Section
	private TableViewer metricsTableViewer;

	private DateChooserCombo dcProposed;
	private DateChooserCombo dcPlanned;
	private DateChooserCombo dcConstruction;
	private DateChooserCombo dcInService;
	private DateChooserCombo dcOutOfService;

	// private CDateTime cdProposed;
	// private CDateTime cdPlanned;
	// private CDateTime cdConstruction;
	// private CDateTime cdInService;
	// private CDateTime cdOutOfService;

	protected Component comp;

	// If the screen is in read-only mode.
	protected boolean readOnly;

	// The corresponding widget style for the operation mode.
	protected int widgetStyle;

	public AbstractNewEditComponent(Composite parent, int style,
			final IEditingService editingService) {
		super(parent, style);
		this.editingService = editingService;
		// buildUI();
	}

	@SuppressWarnings("unused")
	private void editUtilizationExpression() {
		NewEditExpression expressionScreen = new NewEditExpression(
				screenService.getScreenContainer(), SWT.NONE);
		expressionScreen.setScreenService(screenService);
		Expression expression = comp.getUtilizationExpressionRef();
		if (expression != null) {
			expressionScreen.setOperation(ScreenUtil.OPERATION_EDIT);
			expressionScreen
					.injectData(
							null,
							comp,
							LibraryPackage.Literals.COMPONENT__UTILIZATION_EXPRESSION_REF,
							expression);
		} else {
			Resource expressionResource = editingService
					.getData(LibraryPackage.Literals.EXPRESSION);
			expressionScreen.setOperation(ScreenUtil.OPERATION_NEW);
			expressionScreen
					.injectData(
							expressionResource,
							comp,
							LibraryPackage.Literals.COMPONENT__UTILIZATION_EXPRESSION_REF,
							LibraryFactory.eINSTANCE.createExpression());
		}
		screenService.setActiveScreen(expressionScreen);
	}

	@SuppressWarnings("unused")
	private void editCapacityExpression() {
		NewEditExpression expressionScreen = new NewEditExpression(
				screenService.getScreenContainer(), SWT.NONE);
		expressionScreen.setScreenService(screenService);
		Expression expression = comp.getCapacityExpressionRef();
		if (expression != null) {
			expressionScreen.setOperation(ScreenUtil.OPERATION_EDIT);

			// CB, can't create expressions from here.... Should be supported
			// with adaption on IDataScreenInjection
			// expressionScreen.injectData(null, comp,
			// LibraryPackage.Literals.COMPONENT__CAPACITY_EXPRESSION_REF,
			// expression);
		} else {
			Resource expressionResource = editingService
					.getData(LibraryPackage.Literals.EXPRESSION);
			expressionScreen.setOperation(ScreenUtil.OPERATION_NEW);
			expressionScreen.injectData(expressionResource, comp,
					LibraryPackage.Literals.COMPONENT__CAPACITY_EXPRESSION_REF,
					LibraryFactory.eINSTANCE.createExpression());

		}
		screenService.setActiveScreen(expressionScreen);
	}

	protected Section buildToleranceSection() {

		Section sctnTolerances = toolkit.createSection(this, Section.TWISTIE
				| Section.TITLE_BAR);

		toolkit.paintBordersFor(sctnTolerances);
		sctnTolerances.setText("Tolerances");
		sctnTolerances.setExpanded(false);

		Composite cmpTolerances = toolkit.createComposite(sctnTolerances,
				SWT.NONE);
		toolkit.paintBordersFor(cmpTolerances);
		sctnTolerances.setClient(cmpTolerances);
		cmpTolerances.setLayout(new GridLayout(1, false));

		ImageHyperlink hypLnkAddTolerance = toolkit.createImageHyperlink(
				cmpTolerances, SWT.NONE);
		hypLnkAddTolerance.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				Resource toleranceResource = editingService
						.getData(LibraryPackage.Literals.TOLERANCE);
				ToleranceFilterDialog dialog = new ToleranceFilterDialog(
						AbstractNewEditComponent.this.getShell(),
						toleranceResource);
				if (dialog.open() == IDialogConstants.OK_ID) {
					Tolerance u = (Tolerance) dialog.getFirstResult();
					if (!comp.getToleranceRefs().contains(u)) {
						Command c = new AddCommand(editingService
								.getEditingDomain(), comp.getToleranceRefs(), u);
						editingService.getEditingDomain().getCommandStack()
								.execute(c);
					}
				}
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});
		hypLnkAddTolerance.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));
		toolkit.paintBordersFor(hypLnkAddTolerance);
		hypLnkAddTolerance.setText("Add");

		tolerancesTableViewer = new TableViewer(cmpTolerances, SWT.BORDER
				| SWT.FULL_SELECTION);
		Table metricsTable = tolerancesTableViewer.getTable();
		metricsTable.setHeaderVisible(true);
		metricsTable.setLinesVisible(true);

		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd.heightHint = 100;
		metricsTable.setLayoutData(gd);
		toolkit.paintBordersFor(metricsTable);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				tolerancesTableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("Name");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				tolerancesTableViewer, SWT.NONE);
		TableColumn tblclmnLevel = tableViewerColumn_1.getColumn();
		tblclmnLevel.setWidth(70);
		tblclmnLevel.setText("Level");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(
				tolerancesTableViewer, SWT.NONE);
		TableColumn tblclmnExpression = tableViewerColumn_2.getColumn();
		tblclmnExpression.setWidth(100);
		tblclmnExpression.setText("Expression");

		Menu menu = new Menu(metricsTable);
		metricsTable.setMenu(menu);

		MenuItem mntmRemoveTolerance = new MenuItem(menu, SWT.NONE);
		mntmRemoveTolerance.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection s = tolerancesTableViewer.getSelection();
				if (s instanceof IStructuredSelection) {
					Object o = ((IStructuredSelection) s).getFirstElement();
					Command rc = new RemoveCommand(editingService
							.getEditingDomain(), comp.getToleranceRefs(), o);
					editingService.getEditingDomain().getCommandStack()
							.execute(rc);
				}
			}
		});
		mntmRemoveTolerance.setText("Remove");

		if (readOnly) {
			hypLnkAddTolerance.setVisible(false);
			mntmRemoveTolerance.setEnabled(false);
		}
		return sctnTolerances;
	}

	protected void buildLifeCycleSection() {

		Section sctnLifecycle = toolkit.createSection(this, Section.TITLE_BAR
				| Section.TWISTIE);
		toolkit.paintBordersFor(sctnLifecycle);
		sctnLifecycle.setText("Lifecycle");

		Composite cmpLifeCycle = toolkit.createComposite(sctnLifecycle,
				SWT.NONE);
		toolkit.paintBordersFor(cmpLifeCycle);
		sctnLifecycle.setClient(cmpLifeCycle);
		cmpLifeCycle.setLayout(new GridLayout(3, false));

		// PROPOSED.

		Label lblProposed = toolkit.createLabel(cmpLifeCycle, "Proposed:",
				SWT.NONE);
		lblProposed.setAlignment(SWT.RIGHT);
		GridData gd_lblProposed = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblProposed.widthHint = 70;
		lblProposed.setLayoutData(gd_lblProposed);

		//
		// cdProposed = new CDateTime(cmpLifeCycle, CDT.BORDER | CDT.DROP_DOWN
		// | CDT.DATE_MEDIUM);
		// GridData gd_Proposed = new GridData(SWT.FILL, SWT.CENTER, false,
		// false,
		// 1, 1);
		// // gd_Proposed.widthHint = 100;
		// cdProposed.setLayoutData(gd_Proposed);
		//
		// toolkit.adapt(cdProposed);
		// toolkit.paintBordersFor(cdProposed);

		dcProposed = new DateChooserCombo(cmpLifeCycle, SWT.BORDER | SWT.FLAT);
		GridData gd_dcProposed = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_dcProposed.heightHint = 20;
		dcProposed.setLayoutData(gd_dcProposed);
		toolkit.adapt(dcProposed);
		toolkit.paintBordersFor(dcProposed);

		buildClearLifeCycleDate(cmpLifeCycle,
				GenericsPackage.Literals.LIFECYCLE__PROPOSED, readOnly);

		// PLANNED

		Label lblPlanned = toolkit.createLabel(cmpLifeCycle, "Planned:",
				SWT.NONE);
		lblPlanned.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblPlanned.setAlignment(SWT.RIGHT);

		// cdPlanned = new CDateTime(cmpLifeCycle, CDT.BORDER | CDT.DROP_DOWN
		// | CDT.DATE_MEDIUM);
		// GridData gd_Planned = new GridData(SWT.FILL, SWT.CENTER, false,
		// false,
		// 1, 1);
		// // gd_Planned.widthHint = 100;
		// cdPlanned.setLayoutData(gd_Planned);
		//
		// toolkit.adapt(cdPlanned);
		// toolkit.paintBordersFor(cdPlanned);

		dcPlanned = new DateChooserCombo(cmpLifeCycle, SWT.BORDER | SWT.FLAT);
		GridData gd_dcPlanned = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_dcPlanned.heightHint = 20;
		dcPlanned.setLayoutData(gd_dcPlanned);
		toolkit.adapt(dcPlanned);
		toolkit.paintBordersFor(dcPlanned);

		buildClearLifeCycleDate(cmpLifeCycle,
				GenericsPackage.Literals.LIFECYCLE__PLANNED_DATE, readOnly);

		// CONSTRUCTION
		Label lblConstruction = toolkit.createLabel(cmpLifeCycle,
				"Construction:", SWT.NONE);
		lblConstruction.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));

		// cdConstruction = new CDateTime(cmpLifeCycle, CDT.BORDER |
		// CDT.DROP_DOWN
		// | CDT.DATE_MEDIUM);
		// GridData gd_Construction = new GridData(SWT.FILL, SWT.CENTER, false,
		// false, 1, 1);
		// // gd_Construction.widthHint = 100;
		// cdConstruction.setLayoutData(gd_Construction);
		//
		// toolkit.adapt(cdConstruction);
		// toolkit.paintBordersFor(cdConstruction);

		dcConstruction = new DateChooserCombo(cmpLifeCycle, SWT.BORDER
				| SWT.FLAT);
		GridData gd_dcConstruction = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_dcConstruction.heightHint = 20;
		dcConstruction.setLayoutData(gd_dcConstruction);
		toolkit.adapt(dcConstruction);
		toolkit.paintBordersFor(dcConstruction);

		buildClearLifeCycleDate(cmpLifeCycle,
				GenericsPackage.Literals.LIFECYCLE__CONSTRUCTION_DATE, readOnly);

		// IN SERVICE.
		Label lblInService = toolkit.createLabel(cmpLifeCycle, "In Service:",
				SWT.NONE);
		lblInService.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblInService.setAlignment(SWT.RIGHT);

		// cdInService = new CDateTime(cmpLifeCycle, CDT.BORDER | CDT.DROP_DOWN
		// | CDT.DATE_MEDIUM);
		// GridData gd_InService = new GridData(SWT.FILL, SWT.CENTER, false,
		// false, 1, 1);
		// // gd_InService.widthHint = 100;
		// cdInService.setLayoutData(gd_InService);
		//
		// toolkit.adapt(cdInService);
		// toolkit.paintBordersFor(cdInService);

		dcInService = new DateChooserCombo(cmpLifeCycle, SWT.BORDER | SWT.FLAT);
		GridData gd_dcInService = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_dcInService.heightHint = 20;
		dcInService.setLayoutData(gd_dcInService);
		toolkit.adapt(dcInService);
		toolkit.paintBordersFor(dcInService);

		buildClearLifeCycleDate(cmpLifeCycle,
				GenericsPackage.Literals.LIFECYCLE__IN_SERVICE_DATE, readOnly);

		// OUT OF SERVICE
		Label lblOutOfService = toolkit.createLabel(cmpLifeCycle,
				"Out of Service:", SWT.NONE);
		GridData gd_lblOutOfService = new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1);
		gd_lblOutOfService.widthHint = 80;
		lblOutOfService.setLayoutData(gd_lblOutOfService);

		// cdOutOfService = new CDateTime(cmpLifeCycle, CDT.BORDER |
		// CDT.DROP_DOWN
		// | CDT.DATE_MEDIUM);
		// GridData gd_OutOfService = new GridData(SWT.FILL, SWT.CENTER, false,
		// false, 1, 1);
		// // gd_OutOfService.widthHint = 100;
		// cdOutOfService.setLayoutData(gd_OutOfService);
		//
		// toolkit.adapt(cdOutOfService);
		// toolkit.paintBordersFor(cdOutOfService);

		dcOutOfService = new DateChooserCombo(cmpLifeCycle, SWT.BORDER
				| SWT.FLAT);
		GridData gd_dcOutOfService = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_dcOutOfService.heightHint = 20;
		dcOutOfService.setLayoutData(gd_dcOutOfService);
		dcOutOfService.setWeeksVisible(true);
		toolkit.adapt(dcOutOfService);
		toolkit.paintBordersFor(dcOutOfService);

		buildClearLifeCycleDate(cmpLifeCycle,
				GenericsPackage.Literals.LIFECYCLE__OUT_OF_SERVICE_DATE,
				readOnly);

		if (readOnly) {
			dcProposed.setEditable(false);
			dcPlanned.setEditable(false);
			dcConstruction.setEditable(false);
			dcInService.setEditable(false);
			dcOutOfService.setEditable(false);
		}
	}

	/*
	 * An hyperlink which sets a Lifecycle , of the target component to null
	 */
	private void buildClearLifeCycleDate(Composite cmpLifeCycle,
			final EAttribute ea, boolean readOnly) {
		ImageHyperlink clearDate = toolkit.createImageHyperlink(cmpLifeCycle,
				SWT.NONE);
		clearDate.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				if (comp.eIsSet(LibraryPackage.Literals.COMPONENT__LIFECYCLE)) {
					Lifecycle lc = (Lifecycle) comp
							.eGet(LibraryPackage.Literals.COMPONENT__LIFECYCLE);
					if (lc.eIsSet(ea)) {
						Command c = new SetCommand(editingService
								.getEditingDomain(), lc, ea, null);
						editingService.getEditingDomain().getCommandStack()
								.execute(c);
					}
				}
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});
		clearDate.setImage(ResourceManager.getPluginImage("org.eclipse.ui",
				"/icons/full/etool16/delete.gif"));
		toolkit.paintBordersFor(clearDate);
		clearDate.setText("");

		if (readOnly) {
			clearDate.setEnabled(false);
		}
	}

	protected Section buildMetricSection() {

		Section sctnMetrics = toolkit.createSection(this, Section.TWISTIE
				| Section.TITLE_BAR);

		toolkit.paintBordersFor(sctnMetrics);
		sctnMetrics.setText("Metrics");
		sctnMetrics.setExpanded(false);

		Composite cmpMetrics = toolkit.createComposite(sctnMetrics, SWT.NONE);
		toolkit.paintBordersFor(cmpMetrics);
		sctnMetrics.setClient(cmpMetrics);
		cmpMetrics.setLayout(new GridLayout(1, false));

		ImageHyperlink hypLnkAddMetric = toolkit.createImageHyperlink(
				cmpMetrics, SWT.NONE);
		hypLnkAddMetric.addHyperlinkListener(new HyperlinkAdapter() {
			public void linkActivated(HyperlinkEvent e) {
				Resource metriceResource = editingService
						.getData(MetricsPackage.Literals.METRIC);

				MetricFilterDialog dialog = new MetricFilterDialog(
						AbstractNewEditComponent.this.getShell(),
						metriceResource);
				if (dialog.open() == IDialogConstants.OK_ID) {
					Object[] metricResult = dialog.getResult();
					final List<Object> metricResultList = Lists
							.newArrayList(metricResult);
					// only add the delta of selected and already set metrics.
					final List<Metric> deltaMetrics = Lists.newArrayList();
					for (Object ro : metricResultList) {
						boolean found = false;
						for (Metric m : comp.getMetricRefs()) {
							if (m.equals(ro)) {
								found = true;
								break;
							}
						}
						if (!found) {
							deltaMetrics.add((Metric) ro);
						}
					}
					final Command c = new AddCommand(editingService
							.getEditingDomain(), comp.getMetricRefs(),
							deltaMetrics);
					editingService.getEditingDomain().getCommandStack()
							.execute(c);
				}
			}
		});
		hypLnkAddMetric.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));
		toolkit.paintBordersFor(hypLnkAddMetric);
		hypLnkAddMetric.setText("Add");

		metricsTableViewer = new TableViewer(cmpMetrics, SWT.BORDER
				| SWT.FULL_SELECTION);
		Table metricsTable = metricsTableViewer.getTable();
		metricsTable.setHeaderVisible(true);
		metricsTable.setLinesVisible(true);

		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd.heightHint = 100;
		metricsTable.setLayoutData(gd);
		toolkit.paintBordersFor(metricsTable);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				metricsTableViewer, SWT.NONE);
		TableColumn tblclmnNewName = tableViewerColumn.getColumn();
		tblclmnNewName.setWidth(150);
		tblclmnNewName.setText("Name");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				metricsTableViewer, SWT.NONE);
		TableColumn tblclmnDescription = tableViewerColumn_1.getColumn();
		tblclmnDescription.setWidth(250);
		tblclmnDescription.setText("Description");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(
				metricsTableViewer, SWT.NONE);
		TableColumn tblclmnUnit = tableViewerColumn_2.getColumn();
		tblclmnUnit.setWidth(90);
		tblclmnUnit.setText("Unit");

		Menu menu = new Menu(metricsTable);
		metricsTable.setMenu(menu);

		MenuItem mntmRemoveMetric = new MenuItem(menu, SWT.NONE);
		mntmRemoveMetric.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection s = metricsTableViewer.getSelection();
				if (s instanceof IStructuredSelection) {
					Object o = ((IStructuredSelection) s).getFirstElement();
					Command rc = new RemoveCommand(editingService
							.getEditingDomain(), comp.getMetricRefs(), o);
					editingService.getEditingDomain().getCommandStack()
							.execute(rc);
				}
			}
		});
		mntmRemoveMetric.setText("Remove");

		if (readOnly) {
			hypLnkAddMetric.setVisible(false);
			mntmRemoveMetric.setEnabled(false);
		}
		return sctnMetrics;
	}

	protected Section buildResourceSection() {
		Section sctnResources = toolkit.createSection(this, Section.TWISTIE
				| Section.TITLE_BAR);
		toolkit.paintBordersFor(sctnResources);
		sctnResources.setText("Resources");

		Composite composite_2 = toolkit
				.createComposite(sctnResources, SWT.NONE);
		toolkit.paintBordersFor(composite_2);
		sctnResources.setClient(composite_2);
		composite_2.setLayout(new GridLayout(7, false));
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);

		ImageHyperlink mghprlnkNewResource = toolkit.createImageHyperlink(
				composite_2, SWT.NONE);
		mghprlnkNewResource.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));
		mghprlnkNewResource.addHyperlinkListener(new HyperlinkAdapter() {
			public void linkActivated(HyperlinkEvent e) {
				NewEditResource resourceScreen = new NewEditResource(
						screenService.getScreenContainer(), SWT.NONE);
				resourceScreen.setOperation(ScreenUtil.OPERATION_NEW);
				resourceScreen.setScreenService(screenService);
				
				
				Resource cdoResourceForNetXResource = modelUtils.cdoResourceForNetXResource(comp, (CDOTransaction) comp.cdoView());
				
//				String computedName = null;
//				try {
//					computedName = modelUtils.cdoCalculateResourceName(comp);
//				} catch (IllegalAccessException e1) {
//					if (ScreensActivator.DEBUG) {
//						ScreensActivator.TRACE.trace(
//								ScreensActivator.TRACE_SCREENS_OPTION,
//								"Attempt to deduce a name with invalid object: "
//										+ comp, e1);
//					}
//				}
//				if (computedName == null) {
//					MessageDialog.openError(
//							AbstractNewEditComponent.this.getShell(),
//							"Part name should be set",
//							"Resources can only be created on fully specified parts. Please specify the name");
//
//					return; // Can't calculate path for empty names.
//				}
//
//				final Resource resourcesResource = editingService
//						.getDataService()
//						.getProvider()
//						.getResource(
//								editingService.getEditingDomain()
//										.getResourceSet(), computedName);

				resourceScreen.injectData(cdoResourceForNetXResource, comp,
						LibraryFactory.eINSTANCE.createNetXResource());
				screenService.setActiveScreen(resourceScreen);

			}
		});
		toolkit.paintBordersFor(mghprlnkNewResource);
		mghprlnkNewResource.setText("New");

		resourceTableViewer = new TableViewer(composite_2, SWT.BORDER
				| SWT.FULL_SELECTION);
		final Table resourcesTable = resourceTableViewer.getTable();
		resourcesTable.setLinesVisible(true);
		resourcesTable.setHeaderVisible(true);

		final GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true, 8, 3);
		gd.heightHint = 100;
		resourcesTable.setLayoutData(gd);
		toolkit.paintBordersFor(resourcesTable);

		final TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(
				resourceTableViewer, SWT.NONE);

		final TableColumn tblclmnShortName = tableViewerColumn_3.getColumn();
		tblclmnShortName.setWidth(100);
		tblclmnShortName.setText("Short Name");

		final TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(
				resourceTableViewer, SWT.NONE);

		final TableColumn tblclmnExpressionName = tableViewerColumn_4
				.getColumn();
		tblclmnExpressionName.setWidth(100);
		tblclmnExpressionName.setText("Expression Name");

		final Menu resourcesMenu = new Menu(resourcesTable);
		resourcesTable.setMenu(resourcesMenu);

		final MenuItem mntmEditResource = new MenuItem(resourcesMenu, SWT.NONE);
		mntmEditResource.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection s = resourceTableViewer.getSelection();
				if (s instanceof IStructuredSelection) {
					Object object = ((IStructuredSelection) s)
							.getFirstElement();
					final NewEditResource editResourceScreen = new NewEditResource(
							screenService.getScreenContainer(), SWT.NONE);
					editResourceScreen.setScreenService(screenService);
					editResourceScreen.setOperation(getOperation());
					// We can probably get away without the resource....
					editResourceScreen.injectData(null, object);
					screenService.setActiveScreen(editResourceScreen);
				}
			}
		});
		mntmEditResource.setText(this.getOperationTextAction());

		final MenuItem mntmRemoveResource = new MenuItem(resourcesMenu,
				SWT.NONE);
		mntmRemoveResource.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection s = resourceTableViewer.getSelection();
				if (s instanceof IStructuredSelection) {

					final CompoundCommand cc = new CompoundCommand();

					final Object o = ((IStructuredSelection) s)
							.getFirstElement();
					{
						final Command rc = new RemoveCommand(editingService
								.getEditingDomain(), comp.getResourceRefs(), o);

						cc.append(rc);
					}
					if (o instanceof NetXResource) {

						final NetXResource res = (NetXResource) o;

						final Resource resource = res.eResource();
						if (resource != null) {
							final Command rc = new RemoveCommand(editingService
									.getEditingDomain(), res.eResource()
									.getContents(), o);
							cc.append(rc);
						}
					}
					editingService.getEditingDomain().getCommandStack()
							.execute(cc);

				}
			}
		});
		mntmRemoveResource.setText("Remove");

		final ImageHyperlink imageHyperlink_2 = toolkit.createImageHyperlink(
				composite_2, SWT.NONE);
		final GridData gd_imageHyperlink_2 = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_imageHyperlink_2.widthHint = 18;
		imageHyperlink_2.setLayoutData(gd_imageHyperlink_2);
		imageHyperlink_2.setImage(ResourceManager.getPluginImage(
				"com.netxforge.netxstudio.models.edit",
				"icons/full/obj16/Expression_H.png"));
		toolkit.paintBordersFor(imageHyperlink_2);
		imageHyperlink_2.setText("");

		@SuppressWarnings("unused")
		final Label lblCapacityExpression = toolkit.createLabel(composite_2,
				"Capacity", SWT.NONE);

		txtCapExpression = toolkit.createText(composite_2, "New Text",
				SWT.READ_ONLY);
		final GridData gd_txtCapExpression = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_txtCapExpression.widthHint = 150;
		txtCapExpression.setLayoutData(gd_txtCapExpression);
		txtCapExpression.setText("");

		final ImageHyperlink mghprlnkRemoveCapacityExpression = toolkit
				.createImageHyperlink(composite_2, SWT.NONE);
		mghprlnkRemoveCapacityExpression
				.addHyperlinkListener(new HyperlinkAdapter() {
					public void linkActivated(HyperlinkEvent e) {
						if (comp.getCapacityExpressionRef() != null) {
							Command c = new SetCommand(
									editingService.getEditingDomain(),
									comp,
									LibraryPackage.Literals.COMPONENT__CAPACITY_EXPRESSION_REF,
									null);
							editingService.getEditingDomain().getCommandStack()
									.execute(c);
						}
					}
				});
		mghprlnkRemoveCapacityExpression.setImage(ResourceManager
				.getPluginImage("org.eclipse.ui",
						"/icons/full/etool16/delete.gif"));
		toolkit.paintBordersFor(mghprlnkRemoveCapacityExpression);
		mghprlnkRemoveCapacityExpression.setText("");

		final Button btnSelectCapExpression = toolkit.createButton(composite_2,
				"Select", SWT.NONE);
		btnSelectCapExpression.setLayoutData(new GridData(SWT.RIGHT,
				SWT.CENTER, false, false, 1, 1));
		btnSelectCapExpression.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Resource expressionResource = editingService
						.getData(LibraryPackage.Literals.EXPRESSION);
				ExpressionFilterDialog dialog = new ExpressionFilterDialog(
						AbstractNewEditComponent.this.getShell(),
						expressionResource);
				if (dialog.open() == IDialogConstants.OK_ID) {
					Expression expression = (Expression) dialog
							.getFirstResult();
					Command c = new SetCommand(
							editingService.getEditingDomain(),
							comp,
							LibraryPackage.Literals.COMPONENT__CAPACITY_EXPRESSION_REF,
							expression);
					editingService.getEditingDomain().getCommandStack()
							.execute(c);
				}
			}
		});

		final Label label = new Label(composite_2, SWT.NONE);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));
		new Label(composite_2, SWT.NONE);

		ImageHyperlink imageHyperlink_3 = toolkit.createImageHyperlink(
				composite_2, SWT.NONE);
		final GridData gd_imageHyperlink_3 = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_imageHyperlink_3.widthHint = 18;
		imageHyperlink_3.setLayoutData(gd_imageHyperlink_3);
		imageHyperlink_3.setImage(ResourceManager.getPluginImage(
				"com.netxforge.netxstudio.models.edit",
				"icons/full/obj16/Expression_H.png"));
		toolkit.paintBordersFor(imageHyperlink_3);
		imageHyperlink_3.setText("");

		@SuppressWarnings("unused")
		Label lblUtilizationExpression = toolkit.createLabel(composite_2,
				"Utilization", SWT.NONE);

		txtUtilExpression = toolkit.createText(composite_2, "New Text",
				SWT.NONE | SWT.READ_ONLY);
		final GridData gd_txtUtilExpression = new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 1, 1);
		gd_txtUtilExpression.widthHint = 150;
		txtUtilExpression.setLayoutData(gd_txtUtilExpression);
		txtUtilExpression.setText("");

		final ImageHyperlink mghprlnkRemoveUtilizationExpression = toolkit
				.createImageHyperlink(composite_2, SWT.NONE);
		mghprlnkRemoveUtilizationExpression
				.addHyperlinkListener(new HyperlinkAdapter() {
					public void linkActivated(HyperlinkEvent e) {
						if (comp.getUtilizationExpressionRef() != null) {
							Command c = new SetCommand(
									editingService.getEditingDomain(),
									comp,
									LibraryPackage.Literals.COMPONENT__UTILIZATION_EXPRESSION_REF,
									null);
							editingService.getEditingDomain().getCommandStack()
									.execute(c);
						}
					}
				});
		mghprlnkRemoveUtilizationExpression.setImage(ResourceManager
				.getPluginImage("org.eclipse.ui",
						"/icons/full/etool16/delete.gif"));
		toolkit.paintBordersFor(mghprlnkRemoveUtilizationExpression);
		mghprlnkRemoveUtilizationExpression.setText("");

		final Button btnSelectUtilExpression = toolkit.createButton(
				composite_2, "Select", SWT.NONE);
		btnSelectUtilExpression.setLayoutData(new GridData(SWT.RIGHT,
				SWT.CENTER, false, false, 1, 1));

		btnSelectUtilExpression.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Resource expressionResource = editingService
						.getData(LibraryPackage.Literals.EXPRESSION);
				ExpressionFilterDialog dialog = new ExpressionFilterDialog(
						AbstractNewEditComponent.this.getShell(),
						expressionResource);
				if (dialog.open() == IDialogConstants.OK_ID) {
					Expression expression = (Expression) dialog
							.getFirstResult();
					Command c = new SetCommand(
							editingService.getEditingDomain(),
							comp,
							LibraryPackage.Literals.COMPONENT__UTILIZATION_EXPRESSION_REF,
							expression);
					editingService.getEditingDomain().getCommandStack()
							.execute(c);
				}
			}
		});
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);

		if (readOnly) {

			mghprlnkNewResource.setVisible(false);
			mntmRemoveResource.setEnabled(false);

			mghprlnkRemoveCapacityExpression.setVisible(false);
			mghprlnkRemoveUtilizationExpression.setVisible(false);

			btnSelectCapExpression.setVisible(false);
			btnSelectUtilExpression.setVisible(false);

		}
		return sctnResources;
	}

	public void injectData(Object owner, Object object) {
		if (object instanceof Component) {
			this.comp = (Component) object;
		} else {
			return;
		}
		buildUI();
		initDataBindings_();
	}

	public void buildUI() {
		// Readonlyness.
		readOnly = ScreenUtil.isReadOnlyOperation(this.getOperation());
		widgetStyle = readOnly ? SWT.READ_ONLY : SWT.NONE;
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = new EMFDataBindingContext();
		return context;
	}

	public EMFDataBindingContext bindResourcesSection(
			EMFDataBindingContext context) {
		IObservableValue capExpressionObservable = SWTObservables.observeText(
				this.txtCapExpression, SWT.Modify);

		IObservableValue utilExpressionObservable = SWTObservables.observeText(
				this.txtUtilExpression, SWT.Modify);

		IEMFValueProperty capacityExpressionProperty = EMFEditProperties
				.value(editingService.getEditingDomain(),
						FeaturePath
								.fromList(
										LibraryPackage.Literals.COMPONENT__CAPACITY_EXPRESSION_REF,
										LibraryPackage.Literals.EXPRESSION__NAME));

		IEMFValueProperty utilExpressionProperty = EMFEditProperties
				.value(editingService.getEditingDomain(),
						FeaturePath
								.fromList(
										LibraryPackage.Literals.COMPONENT__UTILIZATION_EXPRESSION_REF,
										LibraryPackage.Literals.EXPRESSION__NAME));
		context.bindValue(capExpressionObservable,
				capacityExpressionProperty.observe(comp), null, null);
		context.bindValue(utilExpressionObservable,
				utilExpressionProperty.observe(comp), null, null);

		// binding of resources

		ObservableListContentProvider resourceListContentProvider = new ObservableListContentProvider();
		resourceTableViewer.setContentProvider(resourceListContentProvider);
		IObservableMap[] observeResourceMaps = EMFObservables
				.observeMaps(
						resourceListContentProvider.getKnownElements(),
						new EStructuralFeature[] {
								LibraryPackage.Literals.BASE_RESOURCE__SHORT_NAME,
								LibraryPackage.Literals.BASE_RESOURCE__EXPRESSION_NAME });
		resourceTableViewer.setLabelProvider(new ObservableMapLabelProvider(
				observeResourceMaps));
		IEMFListProperty resourcesListProperty = EMFEditProperties.list(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.COMPONENT__RESOURCE_REFS);
		resourceTableViewer.setInput(resourcesListProperty.observe(comp));

		return context;
	}

	public void bindToleranceSection() {
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		tolerancesTableViewer.setContentProvider(listContentProvider);
		IObservableMap[] observeMaps = EMFObservables.observeMaps(
				listContentProvider.getKnownElements(),
				new EStructuralFeature[] {
						LibraryPackage.Literals.TOLERANCE__NAME,
						LibraryPackage.Literals.TOLERANCE__LEVEL,
						LibraryPackage.Literals.TOLERANCE__EXPRESSION_REF });
		tolerancesTableViewer
				.setLabelProvider(new ToleranceObservableMapLabelProvider(
						observeMaps));
		IEMFListProperty l = EMFEditProperties.list(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.COMPONENT__TOLERANCE_REFS);

		tolerancesTableViewer.setInput(l.observe(comp));
	}

	protected void bindLifeCycle(EMFDataBindingContext context) {

		// CDatetime migration.
		// CDateTimeObservableValue dcProposedObservable = new
		// CDateTimeObservableValue(
		// this.cdProposed);
		// CDateTimeObservableValue dcPlannedObservable = new
		// CDateTimeObservableValue(
		// this.cdPlanned);
		// CDateTimeObservableValue dcConstructionObservable = new
		// CDateTimeObservableValue(
		// this.cdConstruction);
		// CDateTimeObservableValue dcInServiceObservable = new
		// CDateTimeObservableValue(
		// this.cdInService);
		// CDateTimeObservableValue dcOutOfServiceObservable = new
		// CDateTimeObservableValue(
		// this.cdOutOfService);

		IObservableValue dcProposedObservable = new DateChooserComboObservableValue(
				dcProposed, SWT.Modify);

		IObservableValue dcPlannedObservable = new DateChooserComboObservableValue(
				dcPlanned, SWT.Modify);

		IObservableValue dcConstructionObservable = new DateChooserComboObservableValue(
				dcConstruction, SWT.Modify);

		IObservableValue dcInServiceObservable = new DateChooserComboObservableValue(
				dcInService, SWT.Modify);

		IObservableValue dcOutOfServiceObservable = new DateChooserComboObservableValue(
				dcOutOfService, SWT.Modify);

		IEMFValueProperty proposedProperty = EMFEditProperties.value(
				editingService.getEditingDomain(), FeaturePath.fromList(
						LibraryPackage.Literals.COMPONENT__LIFECYCLE,
						GenericsPackage.Literals.LIFECYCLE__PROPOSED));

		IEMFValueProperty plannedProperty = EMFEditProperties.value(
				editingService.getEditingDomain(), FeaturePath.fromList(
						LibraryPackage.Literals.COMPONENT__LIFECYCLE,
						GenericsPackage.Literals.LIFECYCLE__PLANNED_DATE));

		IEMFValueProperty constructionProperty = EMFEditProperties.value(
				editingService.getEditingDomain(), FeaturePath.fromList(
						LibraryPackage.Literals.COMPONENT__LIFECYCLE,
						GenericsPackage.Literals.LIFECYCLE__CONSTRUCTION_DATE));

		IEMFValueProperty inServiceProperty = EMFEditProperties.value(
				editingService.getEditingDomain(), FeaturePath.fromList(
						LibraryPackage.Literals.COMPONENT__LIFECYCLE,
						GenericsPackage.Literals.LIFECYCLE__IN_SERVICE_DATE));

		IEMFValueProperty outOfServiceProperty = EMFEditProperties
				.value(editingService.getEditingDomain(),
						FeaturePath
								.fromList(
										LibraryPackage.Literals.COMPONENT__LIFECYCLE,
										GenericsPackage.Literals.LIFECYCLE__OUT_OF_SERVICE_DATE));

		EMFUpdateValueStrategy modelToTargetUpdateStrategy = new EMFUpdateValueStrategy();
		modelToTargetUpdateStrategy.setConverter(new IConverter() {

			public Object getFromType() {
				return XMLGregorianCalendar.class;
			}

			public Object getToType() {
				return Date.class;
			}

			public Object convert(Object fromObject) {
				if (fromObject == null) {
					return null;
				} else {
					return modelUtils
							.fromXMLDate((XMLGregorianCalendar) fromObject);
				}
			}
		});

		EMFUpdateValueStrategy targetToModelUpdateStrategy = new EMFUpdateValueStrategy();
		targetToModelUpdateStrategy.setConverter(new IConverter() {

			public Object getFromType() {
				return Date.class;
			}

			public Object getToType() {
				return XMLGregorianCalendar.class;
			}

			public Object convert(Object fromObject) {
				if (fromObject == null) {
					return null;
				}
				return modelUtils.toXMLDate((Date) fromObject);
			}
		});

		// Set a validator, after target->model conversion() and after
		// model->target get().
		LifecycleValidator lifecycleValidator = new LifecycleValidator();

		targetToModelUpdateStrategy
				.setAfterConvertValidator(lifecycleValidator);
		// targetToModelUpdateStrategy.setAfterGetValidator(lifecycleValidator);

		// Create a new lifecycle if non-existent.
		// Note this will make the function dirty, we should never really get
		// here, as our creators should create an lc.
		if (comp.getLifecycle() == null) {
			Lifecycle newLC = GenericsFactory.eINSTANCE.createLifecycle();

			SetCommand setCommand = new SetCommand(
					editingService.getEditingDomain(), comp,
					LibraryPackage.Literals.COMPONENT__LIFECYCLE, newLC);
			if (setCommand.canExecute()) {
				editingService.getEditingDomain().getCommandStack()
						.execute(setCommand);

				MessageDialog.openInformation(
						AbstractNewEditComponent.this.getShell(),
						"Created lifecycle entry",
						"Created a lifecycle entry for: \"" + comp.getName()
								+ "\"\n Please save (File->Save)");
			}
		}

		context.bindValue(dcProposedObservable, proposedProperty.observe(comp),
				targetToModelUpdateStrategy, modelToTargetUpdateStrategy);

		context.bindValue(dcPlannedObservable, plannedProperty.observe(comp),
				targetToModelUpdateStrategy, modelToTargetUpdateStrategy);

		context.bindValue(dcConstructionObservable,
				constructionProperty.observe(comp),
				targetToModelUpdateStrategy, modelToTargetUpdateStrategy);

		context.bindValue(dcInServiceObservable,
				inServiceProperty.observe(comp), targetToModelUpdateStrategy,
				modelToTargetUpdateStrategy);

		context.bindValue(dcOutOfServiceObservable,
				outOfServiceProperty.observe(comp),
				targetToModelUpdateStrategy, modelToTargetUpdateStrategy);
	}

	public void bindMetricSection() {

		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		metricsTableViewer.setContentProvider(listContentProvider);
		IObservableMap[] observeMaps = EMFObservables.observeMaps(
				listContentProvider.getKnownElements(),
				new EStructuralFeature[] {
						MetricsPackage.Literals.METRIC__NAME,
						MetricsPackage.Literals.METRIC__DESCRIPTION,
						MetricsPackage.Literals.METRIC__UNIT_REF });
		metricsTableViewer.setLabelProvider(new MetricTreeLabelProvider(
				observeMaps));
		IEMFListProperty l = EMFEditProperties.list(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.COMPONENT__METRIC_REFS);
		
		metricsTableViewer.setInput(l.observe(comp));

		// ObservableListTreeContentProvider listTreeContentProvider = new
		// ObservableListTreeContentProvider(
		// new MetricTreeFactory(editingService.getEditingDomain()), new
		// MetricTreeStructureAdvisor());
		// metricsTreeViewer.setContentProvider(listTreeContentProvider);
		// IObservableSet set = listTreeContentProvider.getKnownElements();
		//
		// IObservableMap[] map = new IObservableMap[2];
		//
		// map[0] = EMFProperties.value(MetricsPackage.Literals.METRIC__NAME)
		// .observeDetail(set);
		//
		// map[1] = EMFProperties.value(
		// MetricsPackage.Literals.METRIC__DESCRIPTION).observeDetail(set);
		// metricsTreeViewer.setLabelProvider(new MetricTreeLabelProvider(map));
		//
		// IEMFListProperty metricsProperty =
		// EMFEditProperties.list(editingService.getEditingDomain(),
		// LibraryPackage.Literals.COMPONENT__METRIC_REFS);
		// IObservableList metricsObservableList =
		// metricsProperty.observe(comp);
		// metricsTreeViewer.setInput(metricsObservableList);
	}

}
