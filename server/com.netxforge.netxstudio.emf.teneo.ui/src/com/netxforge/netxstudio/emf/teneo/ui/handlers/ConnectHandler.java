package com.netxforge.netxstudio.emf.teneo.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.handlers.HandlerUtil;

import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.emf.teneo.TeneoService;
import com.netxforge.netxstudio.emf.teneo.ui.TeneoUI;
import com.netxforge.netxstudio.emf.teneo.ui.internal.Activator;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.protocols.ProtocolsPackage;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * Initialize our persistence datastore. Get the resource with:
 * [domain].getResourceSet().getResource(StoreController.DATABASE_LIBRARY_URI,
 * true);
 * 
 * @author dzonekl
 */
public class ConnectHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		if (TeneoService.getInstance().initialized())
			return null;

		IRunnableWithProgress operation = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) {
				try {
					monitor.beginTask(Messages.ConnectHandler_0, 5);
					TeneoUI.INSTANCE
							.initializeDataStore(new EPackage[] {
									NetxstudioPackage.eINSTANCE,
									OperatorsPackage.eINSTANCE,
									ServicesPackage.eINSTANCE,
									GenericsPackage.eINSTANCE,
									MetricsPackage.eINSTANCE,
									LibraryPackage.eINSTANCE,
									ProtocolsPackage.eINSTANCE
									});
					monitor.worked(3);
					// monitor.setTaskName("Initializing data");
					monitor.worked(5);

					monitor.done();

				} catch (Exception e) {
					throw new IllegalStateException(e);
				}
			}
		};

		try {
			// This runs the options, and shows progress.
			new ProgressMonitorDialog(HandlerUtil.getActiveShell(event)).run(
					true, false, operation);

		} catch (Exception exception) {
			// Something went wrong that shouldn't.
			Activator.logError(Messages.ConnectHandler_1, exception);
		}
		
		
		
		// Don't Open the editor, we have an action for this. 
//		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
//		IEditorPart ePart = window.getActivePage().getActiveEditor();
//
//		String ID = "com.netxforge.netxstudio.editors.librarysingledomain";
//		if (ePart == null || !(ePart.getSite().getId() == ID)) {
//
//			final IWorkbenchPage page = HandlerUtil.getActiveWorkbenchWindow(
//					event).getActivePage();
//			try {
//				// Note the target is the target/focus element for editing, even
//				// tough the editor
//				// accepts the complete model from the URI.
//				// Filters etc.. are used to hide non-relevant model
//				// information.
//
//				URIEditorInput input = new URIEditorInput(
//						TeneoService.DATABASE_LIBRARY_URI);
//
//				page.openEditor(input, ID);
//
//			} catch (PartInitException e) {
//				e.printStackTrace();
//			}
//		}

		return null;
	}
}
