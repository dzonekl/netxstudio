package com.netxforge.netxstudio.callflow.screens;

import java.util.List;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.ComputedList;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.ResourceManager;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.callflow.screens.referenceNetwork.ComboBoxCellEditingSupport;
import com.netxforge.netxstudio.callflow.screens.referenceNetwork.TextCellEditingSupport;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.ReferenceNetwork;
import com.netxforge.netxstudio.protocols.Message;
import com.netxforge.netxstudio.protocols.ProtocolsFactory;
import com.netxforge.netxstudio.protocols.ProtocolsPackage;
import com.netxforge.netxstudio.screens.editing.actions.BaseSelectionListenerAction;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;
import com.netxforge.netxstudio.services.ServiceFlow;
import com.netxforge.netxstudio.services.ServiceFlowDirection;
import com.netxforge.netxstudio.services.ServiceFlowRelationship;
import com.netxforge.netxstudio.services.ServicesFactory;
import com.netxforge.netxstudio.services.ServicesPackage;

public class CallFlows extends AbstractScreen implements IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Form frmCallFlows;
	private ReferenceNetwork refNet;
	private TreeViewer callFlowTreeViewer;
	private Resource cdoResourceCallFlows;
	private TreeViewerColumn treeViewerColumnLink;
	private Tree callFlowTree;
	private TreeViewerColumn treeViewerColumnProtocol;
	private TreeViewerColumn treeViewerColumnA;
	private TreeViewerColumn treeViewerColumnB;
	private TreeViewerColumn treeViewerColumnName;
	private TreeViewerColumn treeViewerColumnDirection;
	private TreeViewerColumn treeViewerColumnMessage;

	public CallFlows(Composite parent, int style) {
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

	public Form getScreenForm() {
		return frmCallFlows;
	}

	public Viewer getViewer() {
		return this.callFlowTreeViewer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.common.AbstractScreenImpl#injectData()
	 */
	@Override
	public void injectData() {

		cdoResourceCallFlows = editingService
				.getData(ServicesPackage.Literals.SERVICE_FLOW);

		// get the CDOResource for the reference network.
		Resource cdoResourceReferenceNetworks = editingService
				.getData(LibraryPackage.Literals.REFERENCE_NETWORK);

		// For now hard code to a single entry.
		if (cdoResourceReferenceNetworks.getContents().size() == 1) {
			refNet = (ReferenceNetwork) cdoResourceReferenceNetworks
					.getContents().get(0);
		} else {
			refNet = LibraryFactory.eINSTANCE.createReferenceNetwork();
			refNet.setName("generated_ref_network");
			refNet.setDescription("generated_ref_network");
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
		frmCallFlows = toolkit.createForm(this);
		frmCallFlows.setSeparatorVisible(true);

		frmCallFlows.setText("Call Flows");

		frmCallFlows.getToolBarManager().add(
				new EditCallFlowsAction("Visual Editor"));
		frmCallFlows.getToolBarManager().add(new NewCallFlowAction(""));

		// frmCallFlows.getToolBarManager().add(
		// new EditCallFlowsAction("Visual Editor"));

		frmCallFlows.getToolBarManager().update(true);
		frmCallFlows.setToolBarVerticalAlignment(SWT.TOP);

		toolkit.decorateFormHeading(frmCallFlows);
		toolkit.paintBordersFor(frmCallFlows);

		// Body of the form.
		FillLayout fl = new FillLayout();
		frmCallFlows.getBody().setLayout(fl);

		Composite cmpCallFlows = new Composite(frmCallFlows.getBody(), SWT.NONE);
		toolkit.adapt(cmpCallFlows);
		toolkit.paintBordersFor(cmpCallFlows);
		TreeColumnLayout treeColumnLayout = new TreeColumnLayout();
		cmpCallFlows.setLayout(treeColumnLayout);

		callFlowTreeViewer = new TreeViewer(cmpCallFlows, SWT.BORDER | SWT.MULTI);
		callFlowTree = callFlowTreeViewer.getTree();
		callFlowTree.setHeaderVisible(true);
		callFlowTree.setLinesVisible(true);
		toolkit.paintBordersFor(callFlowTree);

		TreeViewerColumn treeViewerColumnIndex = new TreeViewerColumn(
				callFlowTreeViewer, SWT.NONE);
		TreeColumn trclmnIndex = treeViewerColumnIndex.getColumn();
		treeColumnLayout.setColumnData(trclmnIndex, new ColumnPixelData(107,
				true, true));
		trclmnIndex.setText("Index");

		treeViewerColumnName = new TreeViewerColumn(callFlowTreeViewer,
				SWT.NONE);
		TreeColumn trclmnName = treeViewerColumnName.getColumn();
		treeColumnLayout.setColumnData(trclmnName, new ColumnPixelData(107,
				true, true));
		trclmnName.setText("Name");

		treeViewerColumnLink = new TreeViewerColumn(callFlowTreeViewer,
				SWT.NONE);
		TreeColumn trclmnLink = treeViewerColumnLink.getColumn();
		treeColumnLayout.setColumnData(trclmnLink, new ColumnPixelData(100,
				true, true));
		trclmnLink.setText("Link");

		treeViewerColumnA = new TreeViewerColumn(callFlowTreeViewer, SWT.NONE);
		TreeColumn trclmnA = treeViewerColumnA.getColumn();
		treeColumnLayout.setColumnData(trclmnA, new ColumnPixelData(100, true,
				true));
		trclmnA.setText("A");

		treeViewerColumnDirection = new TreeViewerColumn(callFlowTreeViewer,
				SWT.NONE);
		TreeColumn trclmnDirection = treeViewerColumnDirection.getColumn();
		treeColumnLayout.setColumnData(trclmnDirection, new ColumnPixelData(
				100, true, true));
		trclmnDirection.setText("Direction");

		treeViewerColumnB = new TreeViewerColumn(callFlowTreeViewer, SWT.NONE);
		TreeColumn trclmnB = treeViewerColumnB.getColumn();
		treeColumnLayout.setColumnData(trclmnB, new ColumnPixelData(100, true,
				true));
		trclmnB.setText("B");

		treeViewerColumnProtocol = new TreeViewerColumn(callFlowTreeViewer,
				SWT.NONE);

		TreeColumn trclmnProtocol = treeViewerColumnProtocol.getColumn();
		treeColumnLayout.setColumnData(trclmnProtocol, new ColumnPixelData(150,
				true, true));
		trclmnProtocol.setText("Protocol");
		
		treeViewerColumnMessage = new TreeViewerColumn(callFlowTreeViewer,
				SWT.NONE);

		TreeColumn trclmnMessage = treeViewerColumnMessage.getColumn();
		treeColumnLayout.setColumnData(trclmnMessage, new ColumnPixelData(100,
				true, true));
		trclmnMessage.setText("Message");

	}

	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext context = new EMFDataBindingContext();

		// Bind a tree viewer to call flows and reference interfaces in the call
		// flow.
		ObservableListTreeContentProvider cp = new ObservableListTreeContentProvider(
				new CallFlowsTreeFactoryImpl(editingService.getEditingDomain()),
				new CallFlowsTreeStructureAdvisorImpl());
		callFlowTreeViewer.setContentProvider(cp);

		{
			IObservableSet set = cp.getKnownElements();
			List<IObservableMap> observeMaps = Lists.newArrayList();

			observeMaps.add(EMFEditProperties.value(
					editingService.getEditingDomain(),
					ServicesPackage.Literals.SERVICE_FLOW__NAME).observeDetail(
					set));

			observeMaps
					.add(EMFEditProperties
							.value(editingService.getEditingDomain(),
									ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__DIRECTION)
							.observeDetail(set));
			
			observeMaps
			.add(EMFEditProperties
					.value(editingService.getEditingDomain(),
							ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__PROTOCOL)
					.observeDetail(set));

			observeMaps
					.add(EMFEditProperties
							.value(editingService.getEditingDomain(),
									FeaturePath
											.fromList(
													ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__MESSAGE,
													ProtocolsPackage.Literals.MESSAGE__NAME))
							.observeDetail(set));

			FeaturePath refRelationshipPath = FeaturePath
					.fromList(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__REFERENCE_RELATIONSHIP);

			observeMaps.add(EMFEditProperties.value(
					editingService.getEditingDomain(), refRelationshipPath)
					.observeDetail(set));

			// Don't bind the protocol yet.
			IObservableMap[] map = new IObservableMap[observeMaps.size()];
			observeMaps.toArray(map);

			callFlowTreeViewer.setLabelProvider(new CallFlowsTreeLabelProvider(
					map));
		}

		IEMFListProperty callFlowsListProperty = EMFProperties.resource();
		callFlowTreeViewer.setInput(callFlowsListProperty
				.observe(cdoResourceCallFlows));

		{
			FeaturePath namePath = FeaturePath
					.fromList(ServicesPackage.Literals.SERVICE_FLOW__NAME);

			TextCellEditingSupport txtCellEditingSupportName = new TextCellEditingSupport(
					callFlowTreeViewer, context, callFlowTree,
					editingService.getEditingDomain(), namePath);

			treeViewerColumnName.setEditingSupport(txtCellEditingSupportName);
		}

		// Get the data to observe and set as input to our combo.
		IEMFListProperty refRelationshipsProperties = EMFEditProperties
				.multiList(
						editingService.getEditingDomain(),
						LibraryPackage.Literals.REFERENCE_NETWORK__REF_RELATIONSHIPS);
		//
		// ComputedList computedList = new ComputedList() {
		//
		// @Override
		// protected List<Object> calculate() {
		// List<Object> refRelationshipsAndServiceFlows = Lists
		// .newArrayList();
		// refRelationshipsAndServiceFlows.addAll(refNet
		// .getRefRelationships());
		// refRelationshipsAndServiceFlows.addAll(cdoResourceCallFlows
		// .getContents());
		// return refRelationshipsAndServiceFlows;
		// }
		// };

		// Set the binding for the cell editors.

		FeaturePath linkPath = FeaturePath
				.fromList(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__REFERENCE_RELATIONSHIP);

		ComboBoxCellEditingSupport cmbCellEditingSupportLink = new ComboBoxCellEditingSupport(
				callFlowTreeViewer, context, callFlowTree,
				editingService.getEditingDomain(), linkPath) {

			/*
			 * (non-Javadoc)
			 * 
			 * @see com.netxforge.netxstudio.callflow.screens.referenceNetwork.
			 * ComboBoxCellEditingSupport#getCellEditor(java.lang.Object)
			 */
			@Override
			protected CellEditor getCellEditor(Object element) {
				if (element instanceof ServiceFlowRelationship) {
					ServiceFlowRelationship sfRelationship = (ServiceFlowRelationship) element;
					if (sfRelationship
							.eIsSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__SERVICE_FLOW)) {
						return null; // we can't edit if the relationship is a service flow. 
					}
					return super.getCellEditor(element);
				}
				return null;
			}
		};

		treeViewerColumnLink.setEditingSupport(cmbCellEditingSupportLink);

		cmbCellEditingSupportLink.setInput(refRelationshipsProperties
				.observe(refNet));

		// Populate with an enum
		IObservableList directionsObservableList = new ComputedList() {
			@Override
			protected List<Object> calculate() {
				List<Object> result = Lists.newArrayList();
				result.addAll(ServiceFlowDirection.VALUES);
				return result;
			}
		};
		FeaturePath directionPath = FeaturePath
				.fromList(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__DIRECTION);

		ComboBoxCellEditingSupport cmbCellEditingSupportDirection = new ComboBoxCellEditingSupport(
				callFlowTreeViewer, context, callFlowTree,
				editingService.getEditingDomain(), directionPath);

		treeViewerColumnDirection
				.setEditingSupport(cmbCellEditingSupportDirection);
		cmbCellEditingSupportDirection.setInput(directionsObservableList);
		
		// The protocol column
		{
			
			Resource cdoResProtocols = editingService
					.getData(ProtocolsPackage.Literals.PROTOCOL);

			IEMFListProperty protocolsPropertyList = EMFEditProperties.resource(editingService
					.getEditingDomain());
			
			FeaturePath protocolPath = FeaturePath
					.fromList(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__PROTOCOL);

			ComboBoxCellEditingSupport cmbCellEditingSupportProtocol = new ComboBoxCellEditingSupport(
					callFlowTreeViewer, context, callFlowTree,
					editingService.getEditingDomain(), protocolPath);

			treeViewerColumnProtocol
					.setEditingSupport(cmbCellEditingSupportProtocol);
			cmbCellEditingSupportProtocol.setInput(protocolsPropertyList.observe(cdoResProtocols));
		}
		
		// The message column.
		{
			FeaturePath messagePath = FeaturePath
					.fromList(
							ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__MESSAGE,
							ProtocolsPackage.Literals.MESSAGE__NAME);

			TextCellEditingSupport txtCellEditingMessage = new TextCellEditingSupport(
					callFlowTreeViewer, context, callFlowTree,
					editingService.getEditingDomain(), messagePath) {

				/*
				 * (non-Javadoc)
				 * 
				 * @see
				 * com.netxforge.netxstudio.callflow.screens.referenceNetwork
				 * .TextCellEditingSupport
				 * #doCreateElementObservable(java.lang.Object,
				 * org.eclipse.jface.viewers.ViewerCell)
				 */
				@Override
				protected IObservableValue doCreateElementObservable(
						Object element, ViewerCell cell) {
					// make sure we have a message object for this service flow
					// relationship.
					if (element instanceof ServiceFlowRelationship) {
						if (!((ServiceFlowRelationship) element)
								.eIsSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__MESSAGE)) {
							Message createMessage = ProtocolsFactory.eINSTANCE
									.createMessage();
							createMessage.setName("new*");
							((ServiceFlowRelationship) element)
									.setMessage(createMessage);
						}
					}
					return super.doCreateElementObservable(element, cell);
				}

			};

			treeViewerColumnMessage.setEditingSupport(txtCellEditingMessage);
		}

		return context;
	}

	class CallFlowsTreeFactoryImpl implements IObservableFactory {

		EditingDomain domain;

		private IEMFListProperty callFlowObservableProperty = EMFEditProperties
				.list(domain,
						ServicesPackage.Literals.SERVICE_FLOW__SERVICE_FLOW_RELATIONSHIPS);

		CallFlowsTreeFactoryImpl(EditingDomain domain) {
			this.domain = domain;
		}

		public IObservable createObservable(final Object target) {

			IObservable ol = null;
			if (target instanceof IObservableList) {
				ol = (IObservable) target;
			}
			// else if (target instanceof Operator) {
			// ol = operatorObservableProperty.observe(target);
			// }
			else if (target instanceof ServiceFlow) {
				ol = callFlowObservableProperty.observe(target);
			}
			return ol;
		}
	}

	class CallFlowsTreeStructureAdvisorImpl extends TreeStructureAdvisor {
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
			if (element instanceof ServiceFlow) {
				return ((ServiceFlow) element).getServiceFlowRelationships()
						.size() > 0 ? Boolean.TRUE : null;
			} else if (element instanceof ServiceFlowRelationship) {
				// Allow expansion of the nested service
				if (((ServiceFlowRelationship) element)
						.eIsSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__SERVICE_FLOW)) {

				}
			}

			return false;
		}
	}

	class AddCallFlowAction extends BaseSelectionListenerAction {

		public AddCallFlowAction(String text, int style) {
			super(text);
		}

		@Override
		public void run() {
			// Add to the current selection.
			IStructuredSelection structuredSelection = this
					.getStructuredSelection();
			Object firstElement = structuredSelection.getFirstElement();
			if (firstElement instanceof ServiceFlow) {
				ServiceFlow sf = (ServiceFlow) firstElement;

				ServiceFlowFilterDialog serviceFlowFilterDialog = new ServiceFlowFilterDialog(
						CallFlows.this.getShell(), cdoResourceCallFlows);
				int open = serviceFlowFilterDialog.open();
				if (open == Window.OK) {
					Object firstResult = serviceFlowFilterDialog
							.getFirstResult();
					if (firstResult instanceof ServiceFlow) {

						ServiceFlowRelationship createServiceFlowRelationship = ServicesFactory.eINSTANCE
								.createServiceFlowRelationship();
						createServiceFlowRelationship
								.setServiceFlow((ServiceFlow) firstResult);
						AddCommand ac = new AddCommand(
								editingService.getEditingDomain(),
								sf.getServiceFlowRelationships(),
								createServiceFlowRelationship);

						editingService.getEditingDomain().getCommandStack()
								.execute(ac);
					}
				}
				// Create a new relationship, with the selected object.

			}

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.ui.actions.BaseSelectionListenerAction#updateSelection
		 * (org.eclipse.jface.viewers.IStructuredSelection)
		 */
		@Override
		protected boolean updateSelection(IStructuredSelection selection) {
			return selection.getFirstElement() instanceof ServiceFlow;
		}
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

	class NewCallFlowAction extends Action {

		public NewCallFlowAction(String text) {
			super(text, ResourceManager.getPluginImageDescriptor(
					"com.netxforge.netxstudio.models.edit",
					"icons/full/ctool16/Service_E.png"));
		}

		@Override
		public void run() {

			// 1. Create a new CallFlow.
			// 2. Add it to the resource.
			ServiceFlow createServiceFlow = ServicesFactory.eINSTANCE
					.createServiceFlow();
			createServiceFlow.setName("new*");
			Command add = new AddCommand(editingService.getEditingDomain(),
					cdoResourceCallFlows.getContents(), createServiceFlow);
			editingService.getEditingDomain().getCommandStack().execute(add);
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
		if (actions.size() == 0) {
			actions.add(new AddCallFlowAction("Add Existing Call Flow...",
					SWT.PUSH));
		}
		return actions.toArray(new IAction[actions.size()]);
	}
}
