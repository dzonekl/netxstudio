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
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.models.importer.MasterDataImporterJob;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.screens.editing.IEditingService;
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

	private ITreeContentProvider importContentProvider;

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
							// Does our injector proxy work?
							if (importContentProvider == null) {
								importContentProvider = new ImportResultTreeContentProvider();
							}

							CheckedTreeSelectionDialog dialog = new CheckedTreeSelectionDialog(
									Display.getDefault().getActiveShell(),
									new ImportResultLabelProvider(
											editingService.getAdapterFactory()),
									importContentProvider);
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

			if (object instanceof NetXResource) {
				NetXResource res = (NetXResource) object;
				Component componentRef = res.getComponentRef();
				if (componentRef != null) {
					String cdoResourcePath = modelUtils
							.cdoCalculateResourcePathII(componentRef);
					Resource resource = dataProvider
							.getResource(cdoResourcePath);
					if (resource != null) {
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

	public class ImportResultLabelProvider extends AdapterFactoryLabelProvider {
		public ImportResultLabelProvider(AdapterFactory adapterFactory) {
			super(adapterFactory);
		}

		@Override
		public String getText(Object object) {
			return super.getText(object);
		}
	}
}
