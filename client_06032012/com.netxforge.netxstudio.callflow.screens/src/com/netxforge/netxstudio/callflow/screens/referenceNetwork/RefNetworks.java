package com.netxforge.netxstudio.callflow.screens.referenceNetwork;

import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.ResourceManager;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.callflow.screens.CallFlowsTreeLabelProvider;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.ReferenceNetwork;
import com.netxforge.netxstudio.library.ReferenceRelationship;
import com.netxforge.netxstudio.protocols.ProtocolsPackage;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;

public class RefNetworks extends AbstractScreen implements
		IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Form frmRefNetwork;
	private ReferenceNetwork refNet;
	private TableViewer relationshipsTableViewer;
	private Table relationshipTable;
	private TableViewerColumn tableViewerColumnA;
	private TableViewerColumn tableViewerColumnB;
	private TableViewerColumn tableViewerColumnName;
	private TableViewerColumn tableViewerProtocol;

	public RefNetworks(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
	}

	public Form getScreenForm() {
		return frmRefNetwork;
	}

	public Viewer getViewer() {
		return this.relationshipsTableViewer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.common.AbstractScreenImpl#injectData()
	 */
	@Override
	public void injectData() {
		// get the CDOResource for the reference network.
		Resource cdoResourceReferenceNetworks = editingService
				.getData(LibraryPackage.Literals.REFERENCE_NETWORK);

		// For now hard code to a single entry.
		if (cdoResourceReferenceNetworks.getContents().size() > 0) {
			refNet = (ReferenceNetwork) cdoResourceReferenceNetworks
					.getContents().get(0);
		} else {
			refNet = LibraryFactory.eINSTANCE.createReferenceNetwork();
			refNet.setName("generated_ref_network");
			refNet.setDescription("generated_ref_network");
			cdoResourceReferenceNetworks.getContents().add(refNet);
			// cdoResourceReferenceNetworks.h
		}

		buildUI();
		this.initDataBindings_();

	}

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		@SuppressWarnings("unused")
		int widgetStyle = SWT.None;
		if (ScreenUtil.isReadOnlyOperation(getOperation())) {
			widgetStyle |= SWT.READ_ONLY;
		}

		// Create the form.
		frmRefNetwork = toolkit.createForm(this);
		frmRefNetwork.setSeparatorVisible(true);

		frmRefNetwork.setText(this.getScreenName());

		frmRefNetwork.getToolBarManager().add(new NewReferenceAction(""));

		frmRefNetwork.getToolBarManager().update(true);
		frmRefNetwork.setToolBarVerticalAlignment(SWT.TOP);

		toolkit.decorateFormHeading(frmRefNetwork);
		toolkit.paintBordersFor(frmRefNetwork);

		// Body of the form.
		FillLayout fl = new FillLayout();
		frmRefNetwork.getBody().setLayout(fl);

		Composite cmpCallFlows = new Composite(frmRefNetwork.getBody(),
				SWT.NONE);
		toolkit.adapt(cmpCallFlows);
		toolkit.paintBordersFor(cmpCallFlows);

		TableColumnLayout treeColumnLayout = new TableColumnLayout();
		cmpCallFlows.setLayout(treeColumnLayout);

		relationshipsTableViewer = new TableViewer(cmpCallFlows, SWT.BORDER
				| SWT.MULTI);
		relationshipTable = relationshipsTableViewer.getTable();
		relationshipTable.setHeaderVisible(true);
		relationshipTable.setLinesVisible(true);
		toolkit.paintBordersFor(relationshipTable);

		//
		TableViewerColumn tableViewerColumnIndex = new TableViewerColumn(
				relationshipsTableViewer, SWT.NONE);
		TableColumn trclmnIndex = tableViewerColumnIndex.getColumn();

		treeColumnLayout.setColumnData(trclmnIndex, new ColumnPixelData(107,
				true, true));
		trclmnIndex.setText("Index");

		tableViewerColumnName = new TableViewerColumn(relationshipsTableViewer,
				SWT.NONE);
		TableColumn trclmnName = tableViewerColumnName.getColumn();
		treeColumnLayout.setColumnData(trclmnName, new ColumnPixelData(107,
				true, true));
		trclmnName.setText("Name");

		tableViewerColumnA = new TableViewerColumn(relationshipsTableViewer,
				SWT.NONE);
		TableColumn trclmnA = tableViewerColumnA.getColumn();
		treeColumnLayout.setColumnData(trclmnA, new ColumnPixelData(150, true,
				true));
		trclmnA.setText("A");

		tableViewerColumnB = new TableViewerColumn(relationshipsTableViewer,
				SWT.NONE);
		TableColumn trclmnB = tableViewerColumnB.getColumn();
		treeColumnLayout.setColumnData(trclmnB, new ColumnPixelData(150, true,
				true));
		trclmnB.setText("B");

		tableViewerProtocol = new TableViewerColumn(
				relationshipsTableViewer, SWT.NONE);

		TableColumn trclmnProtocol = tableViewerProtocol.getColumn();
		treeColumnLayout.setColumnData(trclmnProtocol, new ColumnPixelData(150,
				true, true));
		trclmnProtocol.setText("Protocol");

	}

	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext context = new EMFDataBindingContext();

		// Bind a tree viewer to call flows and reference interfaces in the call
		// flow.
		ObservableListContentProvider cp = new ObservableListContentProvider();
		relationshipsTableViewer.setContentProvider(cp);

		{
			IObservableSet set = cp.getKnownElements();
			List<IObservableMap> observeMaps = Lists.newArrayList();

			observeMaps.add(EMFEditProperties.value(
					editingService.getEditingDomain(),
					LibraryPackage.Literals.REFERENCE_RELATIONSHIP__NAME)
					.observeDetail(set));

			FeaturePath aName = FeaturePath
					.fromList(
							LibraryPackage.Literals.REFERENCE_RELATIONSHIP__REF_INTERFACE1_REF,
							LibraryPackage.Literals.NODE_TYPE__NAME);

			FeaturePath bName = FeaturePath
					.fromList(
							LibraryPackage.Literals.REFERENCE_RELATIONSHIP__REF_INTERFACE2_REF,
							LibraryPackage.Literals.NODE_TYPE__NAME);

			observeMaps.add(EMFEditProperties.value(
					editingService.getEditingDomain(), aName)
					.observeDetail(set));

			observeMaps.add(EMFEditProperties.value(
					editingService.getEditingDomain(), bName)
					.observeDetail(set));
			

			observeMaps.add(EMFEditProperties.value(
					editingService.getEditingDomain(),
					LibraryPackage.Literals.REFERENCE_RELATIONSHIP__PROTOCOL_REF)
					.observeDetail(set));

			IObservableMap[] map = new IObservableMap[observeMaps.size()];
			observeMaps.toArray(map);

			relationshipsTableViewer
					.setLabelProvider(new CallFlowsTreeLabelProvider(map));
		}

		IEMFListProperty relationshipsListProperty = EMFProperties
				.list(LibraryPackage.Literals.REFERENCE_NETWORK__REF_RELATIONSHIPS);
		relationshipsTableViewer.setInput(relationshipsListProperty
				.observe(refNet));

		// Set the binding for the cell editors.

		{
			FeaturePath namePath = FeaturePath
					.fromList(LibraryPackage.Literals.REFERENCE_RELATIONSHIP__NAME);

			TextCellEditingSupport txtCellEditingSupportName = new TextCellEditingSupport(
					relationshipsTableViewer, context, relationshipTable,
					editingService.getEditingDomain(), namePath);

			tableViewerColumnName.setEditingSupport(txtCellEditingSupportName);
		}

		// Get the data to observe and set as input to our combo.
		Resource cdoResNodeType = editingService
				.getData(LibraryPackage.Literals.NODE_TYPE);

		IEMFListProperty nodeTypesProperties = EMFEditProperties.resource(editingService
				.getEditingDomain());
		IObservableList nodeTypesObservableList = nodeTypesProperties.observe(cdoResNodeType);

		// Column A, NODE TYPE selector
		{
			FeaturePath aNodeTypePath = FeaturePath
					.fromList(LibraryPackage.Literals.REFERENCE_RELATIONSHIP__REF_INTERFACE1_REF);

			ComboBoxCellEditingSupport cmbCellEditingSupportA = new ComboBoxCellEditingSupport(
					relationshipsTableViewer, context, relationshipTable,
					editingService.getEditingDomain(), aNodeTypePath);

			tableViewerColumnA.setEditingSupport(cmbCellEditingSupportA);
			cmbCellEditingSupportA.setInput(nodeTypesObservableList);
		}

		// Column B, NODE TYPE selector
		{

			FeaturePath bNodeTypePath = FeaturePath
					.fromList(LibraryPackage.Literals.REFERENCE_RELATIONSHIP__REF_INTERFACE2_REF);

			ComboBoxCellEditingSupport cmbCellEditingSupportB = new ComboBoxCellEditingSupport(
					relationshipsTableViewer, context, relationshipTable,
					editingService.getEditingDomain(), bNodeTypePath);

			tableViewerColumnB.setEditingSupport(cmbCellEditingSupportB);

			cmbCellEditingSupportB.setInput(nodeTypesObservableList);
		}

		// Column Protocol selector

		// Get the data to observe and set as input to our combo.
		Resource cdoResProtocols = editingService
				.getData(ProtocolsPackage.Literals.PROTOCOL);

		IEMFListProperty protocolsPropertyList = EMFEditProperties.resource(editingService
				.getEditingDomain());
		{

			FeaturePath protocolPath = FeaturePath
					.fromList(LibraryPackage.Literals.REFERENCE_RELATIONSHIP__PROTOCOL_REF);

			ComboBoxCellEditingSupport cmbCellEditingSupportProtocol = new ComboBoxCellEditingSupport(
					relationshipsTableViewer, context, relationshipTable,
					editingService.getEditingDomain(), protocolPath);

			tableViewerProtocol.setEditingSupport(cmbCellEditingSupportProtocol);

			cmbCellEditingSupportProtocol.setInput(protocolsPropertyList.observe(cdoResProtocols));
		}

		return context;
	}

	class EditCallFlowsAction extends Action {

		private URIEditorInput uriEditorInput;

		public EditCallFlowsAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			if (refNet == null) {
				return;
			}

			String uriFragment = refNet.cdoResource().getURIFragment(refNet);

			uriEditorInput = new URIEditorInput(URI.createURI(uriFragment),
					uriFragment);
			try {
				PlatformUI
						.getWorkbench()
						.getActiveWorkbenchWindow()
						.getActivePage()
						.openEditor(uriEditorInput,
								"com.netxforge.netxstudio.callflow.editor");

			} catch (PartInitException e) {
				e.printStackTrace();
			}

		}
	}

	private final List<IAction> actions = Lists.newArrayList();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.callflow.screens.AbstractScreenImpl#getActions()
	 */
	@Override
	public IAction[] getActions() {

		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());
		@SuppressWarnings("unused")
		String actionText = readonly ? "View..." : "Edit...";

		// actionList.add(new MonitorResourceAction("Monitor...", SWT.PUSH));
		return actions.toArray(new IAction[actions.size()]);
	}

	class NewReferenceAction extends Action {

		public NewReferenceAction(String text) {
			super(text, ResourceManager.getPluginImageDescriptor(
					"com.netxforge.netxstudio.models.edit",
					"icons/full/ctool16/FunctionRelationship_E.png"));
		}

		@Override
		public void run() {

			// 1. Create a new ReferenceRelationship.

			CompoundCommand cc = new CompoundCommand();

			ReferenceRelationship relationship = LibraryFactory.eINSTANCE
					.createReferenceRelationship();

			Command add = new AddCommand(editingService.getEditingDomain(),
					refNet.getRefRelationships(), relationship);

			cc.append(add);

			editingService.getEditingDomain().getCommandStack().execute(cc);

		}
	}

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.callflow.screens.AbstractScreenImpl#getScreenName()
	 */
	@Override
	public String getScreenName() {
		return "Reference Interfaces";
	}
	
	
	
}
