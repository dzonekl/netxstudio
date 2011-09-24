package com.netxforge.netxstudio.models.importer.ui;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EClassImpl;
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
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.geo.Country;
import com.netxforge.netxstudio.geo.Site;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.models.importer.MasterDataImporterJob;
import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServicesPackage;

public abstract class AbstractImportWizard extends Wizard implements
		IImportWizard {

	private IStructuredSelection selection;
	private ImportResourceWizardPage dbImportResourcePage;

	public AbstractImportWizard() {
	}

	@Inject
	private IDataProvider dataProvider;

	@Inject
	private IEditingService editingService;

	abstract EPackage[] getEPackages();

	@Override
	public boolean performFinish() {

		final IPath inFilePath = dbImportResourcePage.getPath();
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
								storeForSameEClass(selections);
							}
						} else {
							System.out.println("No import results");
						}
					}
				});
			}
		});
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

	@SuppressWarnings("unchecked")
	private void storeForSameEClass(Object[] selection) {

		// PrintObject po = new PrintObject(editingService.getAdapterFactory());

		System.out
				.println("Storing objects, check if contained in the set to store. ");

		List<Object> originalList = ImmutableList.of(selection);
		List<EObject> listToStore = Lists.newArrayList();

		// De-flat, by checking if an object is contained in another
		// from the same list.

		for (Object o : originalList) {
			if (o instanceof EClassImpl) {
				listToStore.add((EObject) o);
				continue;
			}

			boolean contained = false;
			for (Object original : originalList) {
				if (original.equals(o)) {
					continue;
				}
				if (contains(o, original)) {
					contained = true;
					break;
				}
			}
			if (!contained) {
				listToStore.add((EObject) o);
			}
		}

		// Create a map from the tree, with the class name as a key. and a list
		// of objects as the content for each key.
		Map<EClass, List<EObject>> map = Maps.newHashMap();
		for (EObject current : listToStore) {
			if (current instanceof EClassImpl) {
				continue;
			}
			List<EObject> currentList = map.get(current.eClass());
			if (currentList == null) {
				currentList = Lists.newArrayList();
				map.put(current.eClass(), currentList);
			}
			currentList.add(current);
		}

		// Store in the EClass CDO store, minding exceptions...
		Iterator<EClass> keys = map.keySet().iterator();
		while (keys.hasNext()) {
			EClass key = keys.next();
			List<EObject> list = map.get(key);
			EList<EObject> parentList = null;
			// CompoundCommand c = new CompoundCommand();
			for (EObject object : list) {
				if (parentList == null) {
					parentList = (EList<EObject>) getParentList(object.eClass());
				}
				parentList.add(object);
			}
			try {
				Resource res = getResource(key);
				res.save(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private List<?> getParentList(EClass key) {

		Resource res = getResource(key);

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
		if (eClass.equals(ServicesPackage.eINSTANCE.getRFSService())) {
			return dataProvider.getResource(OperatorsPackage.eINSTANCE
					.getOperator());
		}
		return dataProvider.getResource(eClass);
	}

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
			} else if (parentElement instanceof NodeType) {
				children.addAll(((NodeType) parentElement).getFunctions());
				children.addAll(((NodeType) parentElement).getEquipments());
			} else if (parentElement instanceof Function) {
				children.addAll(((Function) parentElement).getFunctions());
			} else if (parentElement instanceof Equipment) {
				children.addAll(((Equipment) parentElement).getEquipments());
			} else if (parentElement instanceof Component) {
				children.addAll(((Component) parentElement).getResourceRefs());
			}
			return children.toArray();
		}
	}
}
