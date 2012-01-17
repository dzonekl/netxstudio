package com.netxforge.netxstudio.models.importer.ui;

import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.CheckedTreeSelectionDialog;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.cdo.NonStatic;
import com.netxforge.netxstudio.geo.Country;
import com.netxforge.netxstudio.geo.Site;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.metrics.DataKind;
import com.netxforge.netxstudio.metrics.Mapping;
import com.netxforge.netxstudio.metrics.MappingColumn;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.models.importer.MasterDataImporterJob;
import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServiceUser;
import com.netxforge.netxstudio.services.ServicesPackage;

public abstract class AbstractImportWizard extends Wizard implements
		IImportWizard {

	private IStructuredSelection selection;
	private ImportResourceWizardPage dbImportResourcePage;

	public AbstractImportWizard() {
	}

	@Inject
	@NonStatic
	private IDataProvider dataProvider;

	@Inject
	private IDataProvider uiDataProvider;

	@Inject
	private IEditingService editingService;
	
	@Inject 
	private ModelUtils modelUtils;
	
	abstract EPackage[] getEPackages();

	abstract boolean useIndexed();

	@Override
	public boolean performFinish() {

		final IPath inFilePath = dbImportResourcePage.getPath();
		boolean indexed = dbImportResourcePage.isIndexed();
		// Implement the import.

		final MasterDataImporterJob job = new MasterDataImporterJob(
				dataProvider, getEPackages());

		job.addNotifier(new JobChangeAdapter() {
			@Override
			public void done(IJobChangeEvent event) {
				super.done(event);
				Display.getDefault().syncExec(new Runnable() {
					public void run() {
						List<EObject> results = job.getResults();
						// present the result to the user.

						if (results != null && results.size() > 0) {

							CheckedTreeSelectionDialog dialog = new CheckedTreeSelectionDialog(
									Display.getDefault().getActiveShell(),
									new ImportResultLabelProvider(
											editingService.getAdapterFactory()),
									new ImportResultTreeContentProvider());
							dialog.setTitle("Result of the import");
							dialog.setMessage("Select which items to import");
							dialog.setBlockOnOpen(true);
							dialog.setInput(results);
							dialog.setContainerMode(true);
							int result = dialog.open();
							if (result == Window.OK) {
								Object[] selections = dialog.getResult();
								// Write the result, in a single command, per
								// resource.
								storeForSameEClass(results, selections);
							}
						} else {
							System.out.println("No import results");
						}
					}
				});
			}
		});
		job.setIndexed(indexed);
		job.setIPathToProcess(inFilePath);
		job.go(); // Should spawn a job processing the import file.
		return true;
	}

	class PrintObject {
		ComposedAdapterFactory af;
		AdapterFactoryLabelProvider lp;

		PrintObject(ComposedAdapterFactory af) {
			this.af = af;
			lp = new AdapterFactoryLabelProvider(af);
		}

		String getPrint(Object object) {
			return lp.getText(object);
		}
	}

	/**
	 * Store the selection of items. As each root object will be of type EClass,
	 * we deflat the
	 * 
	 * @param results
	 * 
	 * 
	 * @param selection
	 */
	@SuppressWarnings("unchecked")
	private void storeForSameEClass(List<EObject> results, Object[] selection) {

		String server;
		if (uiDataProvider != null) {
			server = uiDataProvider.getServer();
		} else {
			return;
		}

		dataProvider.setDoGetResourceFromOwnTransaction(false);
		// FIXME THIS WILL OPEN WITH CURRENT CREDENTIALS,
		// REGARDLESS ALL IS PERMITTED NOW.
		dataProvider.openSession("admin", "admin", server);
		dataProvider.getTransaction();

		System.out
				.println("Storing objects, check if contained in the set to store. ");

		List<Object> selectionList = ImmutableList.of(selection);
		List<EObject> listOfObjectsToStore = Lists.newArrayList();

		// Get the result object tree, matching the selection.
		for (Object sel : selectionList) {
			if (sel instanceof EClass) {
				for (EObject rootObject : results) {
					if (rootObject.eClass().getName()
							.equalsIgnoreCase(((EClass) sel).getName())) {
						listOfObjectsToStore.add(rootObject);
					}
				}
			}
		}

		for (EObject object : listOfObjectsToStore) {
			
			if(object instanceof NetXResource){
				NetXResource res = (NetXResource) object;
				Component componentRef = res.getComponentRef();
				if(componentRef != null){
					String cdoResourcePath = modelUtils.cdoCalculateResourcePathII(componentRef);
					Resource resource = dataProvider.getResource(cdoResourcePath);
					if(resource != null ){
						resource.getContents().add(res);
					}
				}
			}
			EList<EObject> parentList = (EList<EObject>) getParentList(object
					.eClass());
			parentList.add(object);
		}

		@SuppressWarnings("unused")
		List<EObject> danglingList = Lists.newArrayList();

		// Check dangling.
		for (EObject object : listOfObjectsToStore) {
			TreeIterator<EObject> eAllContents = object.eAllContents();
			while (eAllContents.hasNext()) {
				EObject next = eAllContents.next();
				EList<EReference> eAllReferences = next.eClass()
						.getEAllReferences();
				for (EReference eRef : eAllReferences) {
					if (!next.eIsSet(eRef)) {
						// continue, only filled ERefs.
						continue;
					}
					if (eRef.isMany()) {
						Object eGet = next.eGet(eRef);
						List<? extends EObject> collection = (List<? extends EObject>) eGet;
						List<EObject> toRemove = Lists.newArrayList();
						for (EObject eo : collection) {
							if (isDangling(eo, eRef)) {
								int index = collection.indexOf(eo);
								toRemove.add(collection.get(index));
							}
						}

						for (EObject eo : toRemove) {
							collection.remove(eo);
						}

					} else {
						Object eGet = next.eGet(eRef);
						EObject eo = (EObject) eGet;
						if (isDangling(eo, eRef)) {
							this.unsetDangling(next, eRef);
						}
					}
				}
			}
		}

		dataProvider.commitTransaction();
		dataProvider.setDoGetResourceFromOwnTransaction(true);
		dataProvider.closeSession();
	}

	public boolean isDangling(EObject eo, EReference eRef) {
		if (eo.eResource() == null) {
			System.out.println("Dangling object: " + eo.eClass()
					+ " from ref: " + eRef);
			return true;
		}
		return false;
	}

	public void unsetDangling(EObject eo, EReference eRef) {
		if (eo.eIsSet(eRef)) {
			eo.eUnset(eRef);
		}
	}

	@SuppressWarnings("unused")
	private boolean equalObject(EList<EObject> parentList, EObject targetObject) {

		boolean already = false;
		for (EObject object : parentList) {
			if (EcoreUtil.equals(object, targetObject)) {
				already = true;
				break;
			}
		}
		return already;
	}

	private List<?> getParentList(EClass key) {

		Resource res = getResource(key);

		// ResourceSet set = res.getResourceSet();
		// if (set != null) {
		// System.out.println("importing in set: " + set.toString());
		//
		// }

		// RFSService objects are stored in an Operator.
		if (key.equals(ServicesPackage.eINSTANCE.getRFSService())) {
			if (res.getContents().size() > 0) {
				// Store in the first one.
				Operator op = (Operator) res.getContents().get(0);
				return op.getServices();
			}
		}
		return res.getContents();
	}

	private Resource getResource(EClass eClass) {

		if (eClass.equals(ServicesPackage.Literals.RFS_SERVICE)) {

			// return dataProvider.getTransaction().createResource("/" +
			// OperatorsPackage.eINSTANCE
			// .getOperator().getName());
			return dataProvider.getResource(OperatorsPackage.eINSTANCE
					.getOperator());
		}

		return dataProvider.getResource(eClass);
	}

	@SuppressWarnings("unused")
	private boolean contains(Object targetObject, Object original) {
		return EcoreUtil.isAncestor((EObject) original, (EObject) targetObject);
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		setWindowTitle(Messages.ImportWizard_4);
		//		setDefaultPageImageDescriptor(Activator.getImageDescriptor("icons/wizban/ExportDBWizard.gif")); //$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}

	@Override
	public void addPages() {

		dbImportResourcePage = new ImportResourceWizardPage(
				Messages.ImportWizard_5);
		dbImportResourcePage.setTitle(Messages.ImportWizard_0);
		dbImportResourcePage.setDescription(Messages.ImportWizard_6);
		dbImportResourcePage.init(selection);
		this.addPage(dbImportResourcePage);

	}

	class ImportResultLabelProvider extends AdapterFactoryLabelProvider {
		public ImportResultLabelProvider(AdapterFactory adapterFactory) {
			super(adapterFactory);
		}

		@Override
		public String getText(Object object) {
			return super.getText(object);
		}
	}

	/**
	 * A tree content provider, which creates a root object of type EClass and
	 * places items under it having this EClass.
	 * 
	 * @author dzonekl
	 * 
	 */
	class ImportResultTreeContentProvider implements ITreeContentProvider {

		List<EObject> originalList;

		public void dispose() {
			// Do nothing.
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// Do nothing.
		}

		@SuppressWarnings("unchecked")
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof List<?>) {
				this.originalList = (List<EObject>) inputElement;
				List<EClass> uniqueClasses = Lists.newArrayList();
				// Convert to an object array containing the EClass of the
				// Objects.
				for (EObject o : originalList) {
					EClass eClass = o.eClass();
					if (!uniqueClasses.contains(eClass)) {
						uniqueClasses.add(eClass);
					}
				}
				return uniqueClasses.toArray();
			}
			return null;
		}

		public Object[] getChildren(Object parentElement) {
			return childrenEObjects(parentElement);
		}

		public Object getParent(Object element) {
			return null; // Not required.
		}

		public boolean hasChildren(Object element) {
			return this.childrenEObjects(element).length > 0;
		}

		private Object[] childrenEObjects(Object parentElement) {
			List<EObject> children = Lists.newArrayList();
			if (parentElement instanceof EClass) {
				for (EObject o : originalList) {
					if (o.eClass().equals(parentElement)) {
						children.add(o);
					}
				}
			} else if (parentElement instanceof Service) {
				children.addAll(((Service) parentElement).getServices());
			} else if (parentElement instanceof ServiceUser) {
				if (((ServiceUser) parentElement).getServiceProfile() != null) {
					children.add(((ServiceUser) parentElement)
							.getServiceProfile());
				}
			} else if (parentElement instanceof Country) {
				children.addAll(((Country) parentElement).getSites());
			} else if (parentElement instanceof Site) {
				children.addAll(((Site) parentElement).getRooms());
			} else if (parentElement instanceof Operator) {
				children.addAll(((Operator) parentElement).getNetworks());
				children.addAll(((Operator) parentElement).getServices());
				children.addAll(((Operator) parentElement).getServiceUsers());
				children.addAll(((Operator) parentElement).getWarehouses());
			} else if (parentElement instanceof Network) {
				children.addAll(((Network) parentElement).getNetworks());
				children.addAll(((Network) parentElement).getNodes());
				children.addAll(((Network) parentElement)
						.getEquipmentRelationships());
				children.addAll(((Network) parentElement)
						.getFunctionRelationships());
			} else if (parentElement instanceof Node) {
				NodeType nodeType = ((Node) parentElement).getNodeType();
				if (nodeType != null) {
					children.add(nodeType);
				}
			} else if (parentElement instanceof NetXResource) {
				NetXResource res = (NetXResource) parentElement;
				children.addAll(res.getMetricValueRanges());
			} else if ( parentElement instanceof MetricValueRange) {
				children.addAll(((MetricValueRange) parentElement).getMetricValues());
			}else if (parentElement instanceof NodeType) {
				children.addAll(((NodeType) parentElement).getFunctions());
				children.addAll(((NodeType) parentElement).getEquipments());
			} else if (parentElement instanceof Function) {
				children.addAll(((Function) parentElement).getFunctions());
			} else if (parentElement instanceof Equipment) {
				children.addAll(((Equipment) parentElement).getEquipments());
			} else if (parentElement instanceof Component) {
				children.addAll(((Component) parentElement).getResourceRefs());
			} else if (parentElement instanceof MetricSource) {

				Mapping metricMapping = ((MetricSource) parentElement)
						.getMetricMapping();
				if (metricMapping != null) {
					children.add(metricMapping);
				}
			} else if (parentElement instanceof Mapping) {
				children.addAll(((Mapping) parentElement)
						.getHeaderMappingColumns());
				children.addAll(((Mapping) parentElement)
						.getDataMappingColumns());
			} else if (parentElement instanceof MappingColumn) {

				DataKind dataType = ((MappingColumn) parentElement)
						.getDataType();
				if (dataType != null) {
					children.add(dataType);
				}

			}

			return children.toArray();
		}
	}
}
