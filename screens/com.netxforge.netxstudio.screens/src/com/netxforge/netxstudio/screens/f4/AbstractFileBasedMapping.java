/*******************************************************************************
 * Copyright (c) 17 mei 2013 NetXForge.
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

import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.IViewerObservableValue;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.ColumnLayoutData;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.Section;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.netxforge.base.Tuple;
import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.metrics.DataKind;
import com.netxforge.netxstudio.metrics.IdentifierDataKind;
import com.netxforge.netxstudio.metrics.Mapping;
import com.netxforge.netxstudio.metrics.MappingColumn;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricsFactory;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.metrics.ObjectKindType;
import com.netxforge.netxstudio.metrics.ValueDataKind;
import com.netxforge.netxstudio.metrics.ValueKindType;
import com.netxforge.netxstudio.metrics.impl.IdentifierDataKindImpl;
import com.netxforge.netxstudio.metrics.impl.ValueDataKindImpl;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.f4.support.CSVServiceJob;
import com.netxforge.netxstudio.screens.f4.support.XLSServiceJob;
import com.netxforge.netxstudio.screens.ide.WorkspaceUtil;
import com.netxforge.screens.editing.base.IScreen;
import com.netxforge.screens.editing.base.ScreenUtil;

public abstract class AbstractFileBasedMapping extends AbstractScreen {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	protected MetricSource metricSource;
	protected Mapping mapping;
	protected Form frmMappings;

	/*
	 * Header mappings.
	 */
	protected Text txtFirstHeaderRow;
	protected TableViewer tblViewerHeaderColumnMapping;
	protected Table tblHeaderColumnMapping;

	protected Text txtFirstDataRow;
	protected TableViewer tblViewerDataColumnMapping;
	protected Table tblDataColumnMapping;

	/*
	 * Data mappings.
	 */
	protected Text txtInterval;
	protected Composite rightComposite;
	protected Composite leftComposite;

	/*
	 * A map of class and name of a mapping column.
	 */
	ImmutableMap<?, String> dataKindMap = ImmutableMap.of(
			IdentifierDataKindImpl.class, "Identifier",
			ValueDataKindImpl.class, "Value");
	private Section sctnHeaderMapping;
	private Button btnEnableHeaderMapping;
	private Text txtFilePattern;
	private Button dataMappingUpButton;
	private Button dataMappingDownButton;
	private Button dataMappingNewButton;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public AbstractFileBasedMapping(Composite parent, int style) {
		super(parent, style);

		// this.buildSashComposites();
		// this.buildIntervalSection(leftComposite);
		// this.buildHeaderMappingSection(leftComposite);
		// this.buildDataMappingSection(leftComposite);

	}

	public void injectData(Object owner, Object object) {
		if (owner instanceof MetricSource) {
			this.metricSource = (MetricSource) owner;
		} else {
			// We need the right type of object for this screen.
			throw new java.lang.IllegalArgumentException();
		}

		if (object != null && object instanceof Mapping) {
			mapping = (Mapping) object;
		} else {
			// We need the right type of object for this screen.
			throw new java.lang.IllegalArgumentException();
		}
		buildUI();
		initDataBindings_();

	}

	protected abstract void buildUI();

	protected void buildSashComposites() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		// New or Edit.
		boolean edit = ScreenUtil.isEditOperation(getOperation());
		String actionText = edit ? "Edit: " : "New: ";

		frmMappings = toolkit.createForm(this);
		frmMappings.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmMappings);
		frmMappings.setText(actionText + " Mapping: " + metricSource.getName());
		frmMappings.getBody().setLayout(new FillLayout());

		SashForm sashFormMappings = new SashForm(frmMappings.getBody(),
				SWT.SMOOTH);
		toolkit.adapt(sashFormMappings);
		toolkit.paintBordersFor(sashFormMappings);

		leftComposite = toolkit.createComposite(sashFormMappings, SWT.NONE);
		toolkit.paintBordersFor(leftComposite);
		ColumnLayout cl_leftComposite = new ColumnLayout();
		cl_leftComposite.rightMargin = 10;
		cl_leftComposite.leftMargin = 10;
		cl_leftComposite.topMargin = 10;
		cl_leftComposite.maxNumColumns = 1;
		leftComposite.setLayout(cl_leftComposite);

		rightComposite = toolkit.createComposite(sashFormMappings, SWT.NONE);
		toolkit.paintBordersFor(rightComposite);

		FillLayout fLayout = new FillLayout();
		fLayout.marginHeight = 10;
		fLayout.marginWidth = 10;
		rightComposite.setLayout(fLayout);
		sashFormMappings.setWeights(new int[] { 4, 6 });

	}

	protected void buildGeneralSection(Composite leftComposite) {

		Section sctnGeneral = toolkit.createSection(leftComposite,
				Section.TWISTIE | Section.TITLE_BAR | Section.COMPACT);
		sctnGeneral.setLayoutData(new ColumnLayoutData());
		toolkit.paintBordersFor(sctnGeneral);
		sctnGeneral.setText("General");

		Composite generalComposite = toolkit.createComposite(sctnGeneral,
				SWT.NONE);
		toolkit.paintBordersFor(generalComposite);
		sctnGeneral.setClient(generalComposite);
		generalComposite.setLayout(new GridLayout(2, false));

		Label lblFilePattern = toolkit.createLabel(generalComposite,
				"File Pattern:", SWT.NONE);
		lblFilePattern.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		txtFilePattern = toolkit.createText(generalComposite, "New Text",
				SWT.NONE);
		txtFilePattern.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Label lblIntervalHint = toolkit.createLabel(generalComposite,
				"Interval (min):", SWT.NONE);
		GridData gd_lblIntervalHint = new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1);
		gd_lblIntervalHint.widthHint = 80;
		lblIntervalHint.setLayoutData(gd_lblIntervalHint);
		lblIntervalHint.setAlignment(SWT.RIGHT);

		txtInterval = toolkit
				.createText(generalComposite, "New Text", SWT.NONE);
		GridData gd_text = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_text.widthHint = 60;
		txtInterval.setLayoutData(gd_text);
		txtInterval.setText("");

		btnEnableHeaderMapping = toolkit.createButton(generalComposite,
				"Enable Header Mapping", SWT.CHECK);
		btnEnableHeaderMapping.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setHeaderMappingStateVisible();
			}
		});
		btnEnableHeaderMapping.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 2, 1));

		FormText formText = toolkit.createFormText(generalComposite, false);
		formText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2,
				1));
		toolkit.paintBordersFor(formText);
		formText.setText(
				"The header mapping, is an additional mapping at the top of the table",
				false, false);
	}

	protected void buildHeaderMappingSection(Composite leftComposite) {

		sctnHeaderMapping = toolkit.createSection(leftComposite,
				Section.TWISTIE | Section.TITLE_BAR | Section.COMPACT);
		toolkit.paintBordersFor(sctnHeaderMapping);
		sctnHeaderMapping.setText("Header Mapping");
		// sctnHeaderMapping.setExpanded(true);

		Composite headerMappingComposite = toolkit.createComposite(
				sctnHeaderMapping, SWT.NONE);
		toolkit.paintBordersFor(headerMappingComposite);
		sctnHeaderMapping.setClient(headerMappingComposite);
		headerMappingComposite.setLayout(new GridLayout(2, false));

		Label lblHeaderrow = toolkit.createLabel(headerMappingComposite,
				"Header row:", SWT.RIGHT);
		GridData gd_lblHeaderrow = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblHeaderrow.widthHint = 80;
		lblHeaderrow.setLayoutData(gd_lblHeaderrow);

		txtFirstHeaderRow = toolkit.createText(headerMappingComposite,
				"New Text", SWT.NONE);
		txtFirstHeaderRow.setText("");
		GridData gd_txtFirstHeaderRow = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_txtFirstHeaderRow.widthHint = 20;
		txtFirstHeaderRow.setLayoutData(gd_txtFirstHeaderRow);
		new Label(headerMappingComposite, SWT.NONE);

		ImageHyperlink mghprlnkNewHeaderMappingColumn = toolkit
				.createImageHyperlink(headerMappingComposite, SWT.NONE);
		mghprlnkNewHeaderMappingColumn
				.addHyperlinkListener(new IHyperlinkListener() {
					public void linkActivated(HyperlinkEvent e) {
						newColumnMappingScreenDialog(false,
								ScreenUtil.OPERATION_NEW,
								mapping.getHeaderMappingColumns(),
								MetricsFactory.eINSTANCE.createMappingColumn());
					}

					public void linkEntered(HyperlinkEvent e) {
					}

					public void linkExited(HyperlinkEvent e) {
					}
				});
		mghprlnkNewHeaderMappingColumn.setLayoutData(new GridData(SWT.RIGHT,
				SWT.CENTER, false, false, 1, 1));
		toolkit.paintBordersFor(mghprlnkNewHeaderMappingColumn);
		mghprlnkNewHeaderMappingColumn.setText("New");

		tblViewerHeaderColumnMapping = new TableViewer(headerMappingComposite,
				SWT.BORDER | SWT.FULL_SELECTION);
		tblHeaderColumnMapping = tblViewerHeaderColumnMapping.getTable();
		tblHeaderColumnMapping.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = tblViewerHeaderColumnMapping
						.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object mappingColumn = ((IStructuredSelection) selection)
							.getFirstElement();
					int row = mapping.getHeaderRow();
					setGridSelection((MappingColumn) mappingColumn, row);
				}
			}
		});
		tblHeaderColumnMapping.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = tblViewerHeaderColumnMapping
						.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object mappingColumn = ((IStructuredSelection) selection)
							.getFirstElement();
					int row = mapping.getHeaderRow();
					setGridSelection((MappingColumn) mappingColumn, row);
				}
			}
		});
		tblHeaderColumnMapping.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = tblViewerHeaderColumnMapping
						.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object mappingColumn = ((IStructuredSelection) selection)
							.getFirstElement();
					int row = mapping.getHeaderRow();
					setGridSelection((MappingColumn) mappingColumn, row);
				}
			}
		});

		tblHeaderColumnMapping.setLinesVisible(true);
		tblHeaderColumnMapping.setHeaderVisible(true);
		GridData gd_tblHeaderColumnMapping = new GridData(SWT.FILL, SWT.FILL,
				true, true, 2, 1);
		gd_tblHeaderColumnMapping.heightHint = 100;
		tblHeaderColumnMapping.setLayoutData(gd_tblHeaderColumnMapping);
		toolkit.paintBordersFor(tblHeaderColumnMapping);

		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(
				tblViewerHeaderColumnMapping, SWT.NONE);
		TableColumn tblclmnType = tableViewerColumn_3.getColumn();
		tblclmnType.setWidth(80);
		tblclmnType.setText("Type");

		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(
				tblViewerHeaderColumnMapping, SWT.NONE);
		TableColumn tblclmnColumnNum = tableViewerColumn_4.getColumn();
		tblclmnColumnNum.setWidth(80);
		tblclmnColumnNum.setText("Column Num");

		TableViewerColumn tableViewerColumn_5 = new TableViewerColumn(
				tblViewerHeaderColumnMapping, SWT.NONE);
		TableColumn tblclmnValueType_1 = tableViewerColumn_5.getColumn();
		tblclmnValueType_1.setWidth(100);
		tblclmnValueType_1.setText("Value Type");

		TableViewerColumn tblViewerColumnValue = new TableViewerColumn(
				tblViewerHeaderColumnMapping, SWT.NONE);
		TableColumn tblclmnValue = tblViewerColumnValue.getColumn();
		tblclmnValue.setWidth(120);
		tblclmnValue.setText("Value");

		Menu headerColumnMappingMenu = new Menu(tblHeaderColumnMapping);
		tblHeaderColumnMapping.setMenu(headerColumnMappingMenu);

		MenuItem mntmEdit_1 = new MenuItem(headerColumnMappingMenu, SWT.NONE);
		mntmEdit_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = tblViewerHeaderColumnMapping
						.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object mappingColumn = ((IStructuredSelection) selection)
							.getFirstElement();
					newColumnMappingScreenDialog(false,
							ScreenUtil.OPERATION_EDIT,
							mapping.getHeaderMappingColumns(), mappingColumn);
				}

			}
		});
		mntmEdit_1.setText("Edit...");

		MenuItem mntmRemove = new MenuItem(headerColumnMappingMenu, SWT.NONE);
		mntmRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = tblViewerHeaderColumnMapping
						.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object mappingColumn = ((IStructuredSelection) selection)
							.getFirstElement();
					RemoveCommand rc = new RemoveCommand(editingService
							.getEditingDomain(), mapping
							.getHeaderMappingColumns(), mappingColumn);
					editingService.getEditingDomain().getCommandStack()
							.execute(rc);
				}

			}
		});
		mntmRemove.setText("Remove");

		sctnHeaderMapping.setVisible(false);

	}

	protected void buildDataMappingSection(Composite composite) {

		Section sctnMappingColumns = toolkit.createSection(composite,
				Section.TITLE_BAR);
		toolkit.paintBordersFor(sctnMappingColumns);
		sctnMappingColumns.setText("Data Mapping");

		Composite parentComposite = toolkit.createComposite(sctnMappingColumns,
				SWT.NONE);
		toolkit.paintBordersFor(parentComposite);
		sctnMappingColumns.setClient(parentComposite);
		parentComposite.setLayout(new GridLayout(3, false));

		Label lblstDataRow = toolkit.createLabel(parentComposite, "Data row:",
				SWT.RIGHT);
		GridData gd_lblstDataRow = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblstDataRow.widthHint = 80;
		lblstDataRow.setLayoutData(gd_lblstDataRow);

		txtFirstDataRow = toolkit.createText(parentComposite, "New Text",
				SWT.NONE);
		GridData gd_txtFirstDataRow = new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 2, 1);
		gd_txtFirstDataRow.widthHint = 20;
		txtFirstDataRow.setLayoutData(gd_txtFirstDataRow);
		txtFirstDataRow.setText("");
		// new Label(parentComposite, SWT.NONE);
		//
		// ImageHyperlink mghprlnkNew = toolkit.createImageHyperlink(
		// parentComposite, SWT.NONE);
		// mghprlnkNew.addHyperlinkListener(new IHyperlinkListener() {
		// public void linkActivated(HyperlinkEvent e) {
		// newColumnMappingScreenDialog(true, ScreenUtil.OPERATION_NEW,
		// mapping.getDataMappingColumns(),
		// MetricsFactory.eINSTANCE.createMappingColumn());
		// }
		//
		// public void linkEntered(HyperlinkEvent e) {
		// }
		//
		// public void linkExited(HyperlinkEvent e) {
		// }
		// });
		//
		// mghprlnkNew.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
		// false, 3, 1));
		// toolkit.paintBordersFor(mghprlnkNew);
		// mghprlnkNew.setText("New");

		// The table viewer.

		tblViewerDataColumnMapping = new TableViewer(parentComposite,
				SWT.BORDER | SWT.FULL_SELECTION);
		tblDataColumnMapping = tblViewerDataColumnMapping.getTable();
		tblDataColumnMapping.setLinesVisible(true);
		tblDataColumnMapping.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = tblViewerDataColumnMapping
						.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object mappingColumn = ((IStructuredSelection) selection)
							.getFirstElement();
					int row = mapping.getFirstDataRow();
					setGridSelection((MappingColumn) mappingColumn, row);
				}
			}
		});

		GridData gd_table = new GridData(GridData.FILL_BOTH);
		 gd_table.horizontalSpan = 2;
		// gd_table.heightHint = 300;
		tblDataColumnMapping.setLayoutData(gd_table);
		tblDataColumnMapping.setHeaderVisible(true);
		toolkit.paintBordersFor(tblDataColumnMapping);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				tblViewerDataColumnMapping, SWT.NONE);
		TableColumn tblclmnDatHeader = tableViewerColumn.getColumn();
		tblclmnDatHeader.setWidth(80);
		tblclmnDatHeader.setText("Type");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(
				tblViewerDataColumnMapping, SWT.NONE);
		TableColumn tblclmnRowNum = tableViewerColumn_2.getColumn();
		tblclmnRowNum.setWidth(80);
		tblclmnRowNum.setText("Column Num");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				tblViewerDataColumnMapping, SWT.NONE);
		TableColumn tblclmnValueType = tableViewerColumn_1.getColumn();
		tblclmnValueType.setWidth(100);
		tblclmnValueType.setText("Value Type");

		TableViewerColumn tblViewerColumnValue = new TableViewerColumn(
				tblViewerDataColumnMapping, SWT.NONE);
		TableColumn tblclmnValue = tblViewerColumnValue.getColumn();
		tblclmnValue.setWidth(120);
		tblclmnValue.setText("Value");

		// The up down buttons.

		Composite buttonColumn = toolkit.createComposite(parentComposite,
				SWT.None);
		GridLayout buttonLayout = new GridLayout();
		buttonLayout.numColumns = 1;

		// buttonLayout.marginLeft = 0;
		// buttonLayout.marginRight = 0;
		buttonLayout.marginTop = 20;
		buttonLayout.marginWidth = 0;

		buttonColumn.setLayout(buttonLayout);

		GridData buttonColumnLayoutData = new GridData(SWT.FILL, SWT.FILL,
				false, true);
		buttonColumnLayoutData.widthHint = 50;
		buttonColumnLayoutData.horizontalSpan = 1;
		buttonColumn.setLayoutData(buttonColumnLayoutData);

		{
			dataMappingNewButton = toolkit.createButton(buttonColumn, "New",
					SWT.PUSH);
			GridData buttonLayoutData = new GridData(SWT.FILL, SWT.FILL, true,
					false, 1, 1);
			dataMappingNewButton.setLayoutData(buttonLayoutData);

		}

		{
			dataMappingUpButton = toolkit.createButton(buttonColumn, "Up",
					SWT.PUSH);
			GridData buttonLayoutData = new GridData(SWT.FILL, SWT.FILL, true,
					false, 1, 1);
			dataMappingUpButton.setLayoutData(buttonLayoutData);
			dataMappingUpButton.setEnabled(false);

		}
		{
			dataMappingDownButton = toolkit.createButton(buttonColumn, "Down",
					SWT.PUSH);
			GridData buttonLayoutData = new GridData(SWT.FILL, SWT.FILL, true,
					false, 1, 1);
			dataMappingDownButton.setLayoutData(buttonLayoutData);
			dataMappingDownButton.setEnabled(false);
		}

		// buttons
		dataMappingNewButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				newColumnMappingScreenDialog(true, ScreenUtil.OPERATION_NEW,
						mapping.getDataMappingColumns(),
						MetricsFactory.eINSTANCE.createMappingColumn());
			}
		});

		dataMappingUpButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = tblViewerDataColumnMapping
						.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object object = ((IStructuredSelection) selection)
							.getFirstElement();
					if (object instanceof MappingColumn) {
						MappingColumn mappingColumn = (MappingColumn) object;

						@SuppressWarnings("unchecked")
						List<MappingColumn> dataMappingColumns = (List<MappingColumn>) mappingColumn
								.eContainer()
								.eGet(MetricsPackage.Literals.MAPPING__DATA_MAPPING_COLUMNS);

						int indexOf = dataMappingColumns.indexOf(mappingColumn);

						RemoveCommand rc = new RemoveCommand(editingService
								.getEditingDomain(), mapping
								.getDataMappingColumns(), mappingColumn);

						AddCommand ac = new AddCommand(editingService
								.getEditingDomain(), mapping
								.getDataMappingColumns(), mappingColumn,
								indexOf - 1);

						CompoundCommand cc = new CompoundCommand();
						cc.append(rc);
						cc.append(ac);

						editingService.getEditingDomain().getCommandStack()
								.execute(cc);

						// Set the selection to the moved object.

						tblViewerDataColumnMapping
								.setSelection(new StructuredSelection(
										mappingColumn));

						// Command moveUp = new
						// MoveCommand(editingService.getEditingDomain(),
						// mapping.getDataMappingColumns(),indexOf, indexOf-1);
						//
						// Command moveUp = MoveCommand.create(
						// editingService.getEditingDomain(),
						// mapping,
						// MetricsPackage.Literals.MAPPING__DATA_MAPPING_COLUMNS,
						// mappingColumn, indexOf - 1);
						//
						// editingService.getEditingDomain().getCommandStack()
						// .execute(moveUp);

					}

				}

			}

		});

		dataMappingDownButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = tblViewerDataColumnMapping
						.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object object = ((IStructuredSelection) selection)
							.getFirstElement();
					if (object instanceof MappingColumn) {
						MappingColumn mappingColumn = (MappingColumn) object;

						@SuppressWarnings("unchecked")
						List<MappingColumn> dataMappingColumns = (List<MappingColumn>) mappingColumn
								.eContainer()
								.eGet(MetricsPackage.Literals.MAPPING__DATA_MAPPING_COLUMNS);

						int indexOf = dataMappingColumns.indexOf(mappingColumn);

						RemoveCommand rc = new RemoveCommand(editingService
								.getEditingDomain(), mapping
								.getDataMappingColumns(), mappingColumn);

						AddCommand ac = new AddCommand(editingService
								.getEditingDomain(), mapping
								.getDataMappingColumns(), mappingColumn,
								indexOf + 1);

						CompoundCommand cc = new CompoundCommand();
						cc.append(rc);
						cc.append(ac);

						editingService.getEditingDomain().getCommandStack()
								.execute(cc);

						// Set the selection to the moved object.

						tblViewerDataColumnMapping
								.setSelection(new StructuredSelection(
										mappingColumn));

						// Command moveUp = new
						// MoveCommand(editingService.getEditingDomain(),
						// mapping.getDataMappingColumns(),indexOf, indexOf-1);
						//
						// Command moveUp = MoveCommand.create(
						// editingService.getEditingDomain(),
						// mapping,
						// MetricsPackage.Literals.MAPPING__DATA_MAPPING_COLUMNS,
						// mappingColumn, indexOf - 1);
						//
						// editingService.getEditingDomain().getCommandStack()
						// .execute(moveUp);

					}

				}

			}

		});

		// The menu

		Menu dataColumnMappingMenu = new Menu(tblDataColumnMapping);
		tblDataColumnMapping.setMenu(dataColumnMappingMenu);

		MenuItem mntmEdit = new MenuItem(dataColumnMappingMenu, SWT.NONE);
		mntmEdit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = tblViewerDataColumnMapping
						.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object mappingColumn = ((IStructuredSelection) selection)
							.getFirstElement();
					newColumnMappingScreenDialog(true,
							ScreenUtil.OPERATION_EDIT,
							mapping.getDataMappingColumns(), mappingColumn);
				}
			}
		});
		mntmEdit.setText("Edit...");

		MenuItem mntmRemove_1 = new MenuItem(dataColumnMappingMenu, SWT.NONE);
		mntmRemove_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = tblViewerDataColumnMapping
						.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object mappingColumn = ((IStructuredSelection) selection)
							.getFirstElement();
					RemoveCommand rc = new RemoveCommand(editingService
							.getEditingDomain(), mapping
							.getDataMappingColumns(), mappingColumn);
					editingService.getEditingDomain().getCommandStack()
							.execute(rc);
				}

			}
		});
		mntmRemove_1.setText("Remove");
	}

	protected void initGeneralBinding(EMFDataBindingContext context) {

		IObservableValue intervalObservableValue = SWTObservables.observeText(
				txtInterval, SWT.Modify);

		IEMFValueProperty intervalHintProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				MetricsPackage.Literals.MAPPING__INTERVAL_HINT);

		context.bindValue(intervalObservableValue,
				intervalHintProperty.observe(mapping));

		IObservableValue filePatternObservable = SWTObservables.observeText(
				this.txtFilePattern, SWT.Modify);

		IEMFValueProperty filePatternProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				MetricsPackage.Literals.METRIC_SOURCE__FILTER_PATTERN);

		context.bindValue(filePatternObservable,
				filePatternProperty.observe(metricSource));

	}

	protected void initHeaderMappingBinding(EMFDataBindingContext context) {
		// HEADER MAPPING COLUMN

		setHeaderMappingEnabledState();
		setHeaderMappingStateVisible();

		// header row mapping.
		IObservableValue headerRowObservableValue = SWTObservables.observeText(
				txtFirstHeaderRow, SWT.Modify);

		IEMFValueProperty headerRowProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				MetricsPackage.Literals.MAPPING__HEADER_ROW);

		context.bindValue(headerRowObservableValue,
				headerRowProperty.observe(mapping), null, null);

		// header columns mapping.

		{
			ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
			this.tblViewerHeaderColumnMapping
					.setContentProvider(listContentProvider);

			IObservableSet set = listContentProvider.getKnownElements();

			List<IObservableMap> mapList = Lists.newArrayList();

			mapList.add(EMFEditProperties
					.value(editingService.getEditingDomain(),
							FeaturePath
									.fromList(
											MetricsPackage.Literals.MAPPING_COLUMN__DATA_TYPE,
											MetricsPackage.Literals.VALUE_DATA_KIND__METRIC_REF))
					.observeDetail(set));

			mapList.add(EMFEditProperties
					.value(editingService.getEditingDomain(),
							FeaturePath
									.fromList(
											MetricsPackage.Literals.MAPPING_COLUMN__DATA_TYPE,
											MetricsPackage.Literals.VALUE_DATA_KIND__VALUE_KIND))
					.observeDetail(set));

			mapList.add(EMFEditProperties.value(
					editingService.getEditingDomain(),
					FeaturePath.fromList(
							MetricsPackage.Literals.MAPPING_COLUMN__DATA_TYPE,
							MetricsPackage.Literals.VALUE_DATA_KIND__FORMAT))
					.observeDetail(set));

			mapList.add(EMFEditProperties
					.value(editingService.getEditingDomain(),
							FeaturePath
									.fromList(
											MetricsPackage.Literals.MAPPING_COLUMN__DATA_TYPE,
											MetricsPackage.Literals.IDENTIFIER_DATA_KIND__OBJECT_PROPERTY))
					.observeDetail(set));

			mapList.add(EMFEditProperties.value(
					editingService.getEditingDomain(),
					MetricsPackage.Literals.MAPPING_COLUMN__COLUMN)
					.observeDetail(set));

			IObservableMap[] map = new IObservableMap[mapList.size()];
			mapList.toArray(map);

			tblViewerHeaderColumnMapping
					.setLabelProvider(new ColumnObservableMapLabelProvider(map));
			IEMFListProperty l = EMFEditProperties.list(
					editingService.getEditingDomain(),
					MetricsPackage.Literals.MAPPING__HEADER_MAPPING_COLUMNS);

			IObservableList dataColumnMappingObservableList = l
					.observe(mapping);
			dataColumnMappingObservableList
					.addChangeListener(new IChangeListener() {
						public void handleChange(ChangeEvent event) {
							// We have a special change listener, to know if the
							// header mapping visual
							// can be disabled.
							setHeaderMappingEnabledState();
							setHeaderMappingStateVisible();
						}
					});
			// obm.addObservable(dataColumnMappingObservableList);
			tblViewerHeaderColumnMapping
					.setInput(dataColumnMappingObservableList);
		}
	}

	private void setHeaderMappingEnabledState() {
		int numOfHeaderMappingColumns = mapping.getHeaderMappingColumns()
				.size();

		if (numOfHeaderMappingColumns > 0) {
			btnEnableHeaderMapping.setSelection(true);
		} else {
			if (!sctnHeaderMapping.isVisible()) {
				btnEnableHeaderMapping.setSelection(false);
			}
		}

		if (numOfHeaderMappingColumns <= 0) {
			btnEnableHeaderMapping.setEnabled(true);
		} else {
			btnEnableHeaderMapping.setEnabled(false);
		}

	}

	private void setHeaderMappingStateVisible() {
		boolean selection = btnEnableHeaderMapping.getSelection();
		// Do not allow disabling when header mapping columns exist.
		if (mapping.getHeaderMappingColumns().size() > 0 && !selection) {
			return;
		} else {
			sctnHeaderMapping.setVisible(selection);
			sctnHeaderMapping.setExpanded(selection);
			AbstractFileBasedMapping.this.leftComposite.layout(true);

		}
	}

	protected void initDataMappingBinding(EMFDataBindingContext context) {
		// DATA MAPPING COLUMN

		// data row mapping

		IObservableValue firstDataRowObservableValue = SWTObservables
				.observeText(txtFirstDataRow, SWT.Modify);

		IEMFValueProperty firstDataRowProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				MetricsPackage.Literals.MAPPING__FIRST_DATA_ROW);
		context.bindValue(firstDataRowObservableValue,
				firstDataRowProperty.observe(mapping), null, null);

		// data columns mapping.
		{
			ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
			this.tblViewerDataColumnMapping
					.setContentProvider(listContentProvider);

			IObservableSet set = listContentProvider.getKnownElements();

			List<IObservableMap> mapList = Lists.newArrayList();

			mapList.add(EMFEditProperties
					.value(editingService.getEditingDomain(),
							FeaturePath
									.fromList(
											MetricsPackage.Literals.MAPPING_COLUMN__DATA_TYPE,
											MetricsPackage.Literals.VALUE_DATA_KIND__METRIC_REF))
					.observeDetail(set));

			mapList.add(EMFEditProperties
					.value(editingService.getEditingDomain(),
							FeaturePath
									.fromList(
											MetricsPackage.Literals.MAPPING_COLUMN__DATA_TYPE,
											MetricsPackage.Literals.VALUE_DATA_KIND__KIND_HINT))
					.observeDetail(set));

			mapList.add(EMFEditProperties
					.value(editingService.getEditingDomain(),
							FeaturePath
									.fromList(
											MetricsPackage.Literals.MAPPING_COLUMN__DATA_TYPE,
											MetricsPackage.Literals.VALUE_DATA_KIND__VALUE_KIND))
					.observeDetail(set));

			mapList.add(EMFEditProperties.value(
					editingService.getEditingDomain(),
					FeaturePath.fromList(
							MetricsPackage.Literals.MAPPING_COLUMN__DATA_TYPE,
							MetricsPackage.Literals.VALUE_DATA_KIND__FORMAT))
					.observeDetail(set));

			mapList.add(EMFEditProperties
					.value(editingService.getEditingDomain(),
							FeaturePath
									.fromList(
											MetricsPackage.Literals.MAPPING_COLUMN__DATA_TYPE,
											MetricsPackage.Literals.IDENTIFIER_DATA_KIND__OBJECT_PROPERTY))
					.observeDetail(set));

			mapList.add(EMFEditProperties.value(
					editingService.getEditingDomain(),
					MetricsPackage.Literals.MAPPING_COLUMN__COLUMN)
					.observeDetail(set));

			IObservableMap[] map = new IObservableMap[mapList.size()];
			mapList.toArray(map);

			this.tblViewerDataColumnMapping
					.setLabelProvider(new ColumnObservableMapLabelProvider(map));
			IEMFListProperty l = EMFEditProperties.list(
					editingService.getEditingDomain(),
					MetricsPackage.Literals.MAPPING__DATA_MAPPING_COLUMNS);

			IObservableList dataColumnMappingObservableList = l
					.observe(mapping);
			this.tblViewerDataColumnMapping
					.setInput(dataColumnMappingObservableList);
		}

		IViewerObservableValue observeSingleSelection = ViewersObservables
				.observeSingleSelection(tblViewerDataColumnMapping);

		ISWTObservableValue observeEnabled = SWTObservables
				.observeEnabled(dataMappingUpButton);

		context.bindValue(observeSingleSelection, observeEnabled,
				new UpdateValueStrategy() {

					@Override
					protected IStatus doSet(IObservableValue observableValue,
							Object value) {

						if (value instanceof MappingColumn) {

							// Find the index of our object on the parent
							@SuppressWarnings("unchecked")
							List<MappingColumn> dataMappingColumns = (List<MappingColumn>) ((MappingColumn) value)
									.eContainer()
									.eGet(MetricsPackage.Literals.MAPPING__DATA_MAPPING_COLUMNS);

							int indexOf = dataMappingColumns.indexOf(value);

							DataKind dataType = ((MappingColumn) value)
									.getDataType();
							if (dataType instanceof IdentifierDataKind
									&& indexOf > 0) {
								return super.doSet(observableValue, true);
							}
						}

						return super.doSet(observableValue, false);
					}

				}, null);

		ISWTObservableValue observeEnabledDown = SWTObservables
				.observeEnabled(dataMappingDownButton);

		context.bindValue(observeSingleSelection, observeEnabledDown,
				new UpdateValueStrategy() {

					@Override
					protected IStatus doSet(IObservableValue observableValue,
							Object value) {

						if (value instanceof MappingColumn) {

							// Find the index of our object on the parent
							@SuppressWarnings("unchecked")
							List<MappingColumn> dataMappingColumns = (List<MappingColumn>) ((MappingColumn) value)
									.eContainer()
									.eGet(MetricsPackage.Literals.MAPPING__DATA_MAPPING_COLUMNS);

							int indexOf = dataMappingColumns.indexOf(value);

							DataKind dataType = ((MappingColumn) value)
									.getDataType();
							if (dataType instanceof IdentifierDataKind
									&& indexOf < dataMappingColumns.size() - 1) {
								return super.doSet(observableValue, true);
							}
						}

						return super.doSet(observableValue, false);
					}

				}, null);

	}

	private class ColumnObservableMapLabelProvider extends
			ObservableMapLabelProvider {

		public ColumnObservableMapLabelProvider(IObservableMap attributeMap) {
			super(attributeMap);
		}

		public ColumnObservableMapLabelProvider(IObservableMap[] observeMaps) {
			super(observeMaps);
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {

			MappingColumn c = (MappingColumn) element;
			DataKind k = c.getDataType();

			switch (columnIndex) {
			case 0: {
				// This is the type Column.
				if (k != null) {
					return dataKindMap.get(k.getClass());
				}
			}
				break;
			case 1: {
				return new Integer(c.getColumn()).toString();
			}
			case 2: {
				if (k instanceof ValueDataKind) {
					ValueKindType vkt = ((ValueDataKind) k).getValueKind();
					return vkt.getName();
				}
				if (k instanceof IdentifierDataKind) {
					IdentifierDataKind idk = (IdentifierDataKind) k;
					ObjectKindType okt = idk.getObjectKind();

					if (okt == ObjectKindType.NODE) {
						return "Network Element";
					} else {
						return okt.getName();
					}
				}
			}
				break;
			case 3: {
				if (k instanceof ValueDataKind) {
					ValueKindType vkt = ((ValueDataKind) k).getValueKind();
					switch (vkt.getValue()) {
					case ValueKindType.METRIC_VALUE: {

						StringBuilder sb = new StringBuilder();
						if (k.eIsSet(MetricsPackage.Literals.VALUE_DATA_KIND__METRIC_REF)) {
							sb.append(((ValueDataKind) k).getMetricRef()
									.getName());
						}
						sb.append(" : "
								+ ((ValueDataKind) k).getKindHint().getName());

						return sb.toString();
					}
					case ValueKindType.DATE_VALUE:
					case ValueKindType.DATETIME_VALUE:
					case ValueKindType.TIME_VALUE: {
						if (k.eIsSet(MetricsPackage.Literals.VALUE_DATA_KIND__FORMAT)) {
							return ((ValueDataKind) k).getFormat();
						}
					}
					case ValueKindType.INTERVAL_VALUE: {
						return "";
					}
					default: {
						return "<not set>!!";
					}
					}

				}
				if (k instanceof IdentifierDataKind) {
					if (k.eIsSet(MetricsPackage.Literals.IDENTIFIER_DATA_KIND__OBJECT_PROPERTY)) {
						String property = ((IdentifierDataKind) k)
								.getObjectProperty();

						if (StudioUtils.NODE_ID.equals(property)) {
							return StudioUtils.NETWORK_ELEMENT_ID;
						}
						return property;
					}
				} else {
					return "<not set>!!";
				}
			}

			}

			return super.getColumnText(element, columnIndex);
		}
	}

	protected void newColumnMappingScreen(boolean showDataMapping, int op,
			Object owner, Object target) {
		NewEditMappingColumn mappingColumnScreen = new NewEditMappingColumn(
				screenService.getScreenContainer(), SWT.NONE);
		mappingColumnScreen.setOperation(op);
		mappingColumnScreen.setScreenService(screenService);
		mappingColumnScreen.injectData(metricSource, showDataMapping, owner,
				target);
		screenService.setActiveScreen(mappingColumnScreen);
	}

	public void newColumnMappingScreenDialog(boolean showDataMapping, int op,
			Object owner, Object target) {
		NewEditMappingColumnDialogII dialog = new NewEditMappingColumnDialogII(
				screenService.getActiveComposite().getShell());
		dialog.create();
		NewEditMappingColumn mappingColumnScreen = dialog
				.getMappingColumnScreen();
		mappingColumnScreen.setOperation(op);
		mappingColumnScreen.setScreenService(screenService);
		mappingColumnScreen.injectData(metricSource, showDataMapping, owner,
				target);
		dialog.getShell().layout(true, true);
		dialog.open();

		screenService.fireScreenChangedExternal((IScreen) screenService
				.getActiveScreen());
	}

	public Form getScreenForm() {
		return frmMappings;
	}

	/**
	 * The key is the name of the metricsource.
	 * 
	 * @param key
	 * @param file
	 */
	public boolean storeMetricSourceSampleFile(MetricSource source, IFile file) {
		IPath path = file.getFullPath();
		return storePreference(source.getName(), path.toPortableString());
	}

	public IFile getMetricSourceSampleFile(MetricSource source) {
		String entry = findPreference(source.getName());
		if (entry != null) {
			IPath path = Path.fromPortableString(entry);
			IFile file = WorkspaceUtil.INSTANCE.createFileHandle(path);
			if (file.exists()) {
				return file;
			}
		}
		return null;
	}

	protected void loadXLSSampleFile(final MetricSource metricSource,
			final IFile f) {

		final XLSServiceJob job = new XLSServiceJob();
		job.addNotifier(new JobChangeAdapter() {
			@Override
			public void done(IJobChangeEvent event) {
				super.done(event);
				List<List<Map<Integer, Tuple>>> records = job.getRecords();
				if (records != null) {
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							if (AbstractFileBasedMapping.this
									.storeMetricSourceSampleFile(metricSource,
											f)) {
								// Succesfully storing.
							} else {
								System.out
										.println("failed to store the sample file : "
												+ f.toString());
							}

							if (job.getRecords().size() > 0) {
								fillGrid(job.getRecords().get(0));
							}
						}

					});
				}
			}
		});
		job.setResourceToProcess(f);
		job.go(); // Should spawn a job processing the xls.
	}

	protected void loadCSVSampleFile(final MetricSource metricSource,
			final IFile f) {

		final CSVServiceJob job = new CSVServiceJob();
		job.addNotifier(new JobChangeAdapter() {
			@Override
			public void done(IJobChangeEvent event) {
				super.done(event);
				String[][] records = job.getRecords();
				if (records != null) {
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							if (AbstractFileBasedMapping.this
									.storeMetricSourceSampleFile(metricSource,
											f)) {
								// Succesfully storing.
							} else {
								System.out
										.println("failed to store the sample file : "
												+ f.toString());
							}
							fillCSVGrid(job.getRecords());
						}

					});
				}
			}
		});
		job.setResourceToProcess(f);
		job.go(); // Should spawn a job processing the xls.
	}

	protected abstract void setGridSelection(MappingColumn mc, int row);

	public abstract void fillGrid(List<Map<Integer, Tuple>> records);

	public abstract void fillCSVGrid(String[][] records);

	/*
	 * Update UI Widgets.
	 */
	// public void updateUI(){
	// this.tblViewerDataColumnMapping.refresh();
	// this.tblViewerHeaderColumnMapping.refresh();
	// }

}
