package com.netxforge.netxstudio.models.importer.ui;

import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
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

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.models.importer.MasterDataImporterJob;
import com.netxforge.netxstudio.screens.editing.IEditingService;

public class ImportWizard extends Wizard implements IImportWizard {

	private IStructuredSelection selection;
	private ImportResourceWizardPage dbImportResourcePage;

	public ImportWizard() {
	}

	@Inject
	private IDataProvider dataProvider;

	@Inject
	private IEditingService editingService;

	@Override
	public boolean performFinish() {

		final IPath inFilePath = dbImportResourcePage.getPath();
		// Implement the import.

		final MasterDataImporterJob job = new MasterDataImporterJob(
				dataProvider);
		
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
									new ImportResultLabelProvider(editingService.getAdapterFactory()),
									new ImportResultTreeContentProvider());
							dialog.setTitle("Result of the import");
							dialog.setMessage("Select which items to import");
							dialog.setBlockOnOpen(true);
							dialog.setInput(results);
							int result = dialog.open();
							if (result == Window.OK) {
								Object[] selections = dialog.getResult();
								// Write the result, not sure how this is
								System.err.println(selections);
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
			if(parentElement instanceof EClass){
				for(EObject o : originalList){
					if(o.eClass().equals(parentElement)){
						children.add(o);
					}
				}
			}
			if (parentElement instanceof NodeType) {
				children.addAll(((NodeType) parentElement).getFunctions());
				children.addAll(((NodeType) parentElement).getEquipments());
			}
			if (parentElement instanceof Function) {
				children.addAll(((Function) parentElement).getFunctions());
			}
			if (parentElement instanceof Equipment) {
				children.addAll(((Equipment) parentElement).getEquipments());
			}
			if (parentElement instanceof Component) {
				children.addAll(((Component) parentElement).getResources());
			}
			return children.toArray();
		}
	}
}
