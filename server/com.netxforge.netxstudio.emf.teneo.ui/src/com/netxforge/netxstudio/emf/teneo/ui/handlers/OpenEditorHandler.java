package com.netxforge.netxstudio.emf.teneo.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import com.netxforge.netxstudio.emf.teneo.TeneoService;

/**
 * Sets the corresponding view in the library editor.
 * 
 * @author dzonekl
 */
public class OpenEditorHandler extends AbstractHandler {


	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// Set a filter on the library view depending on...

		// Depending on what we edit, we select the appropriate editor.
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		IEditorPart ePart = window.getActivePage().getActiveEditor();

		String LIB_ID = "com.netxforge.netxstudio.editors.librarysingledomain"; //$NON-NLS-1$
		String DESIGN_ID = "com.netxforge.netxstudio.editors.designsingledomain"; //$NON-NLS-1$
		String METRIC_ID = "com.netxforge.netxstudio.editors.metricsingledomain"; //$NON-NLS-1$
		
		if (ePart == null
				|| !(ePart.getSite().getId().equals(LIB_ID)
						|| ePart.getSite().getId().equals(DESIGN_ID) || ePart
						.getSite().getId().equals(METRIC_ID))) {

			final IWorkbenchPage page = HandlerUtil.getActiveWorkbenchWindow(
					event).getActivePage();
			try {
				
				// Note the target is the target/focus element for editing, even
				// tough the editor
				// accepts the complete model from the URI.
				// Filters etc.. are used to hide non-relevant model
				// information.
				URIEditorInput input = new URIEditorInput(
						TeneoService.DATABASE_LIBRARY_URI);

				// Selection based on the perspective:
				String p = window.getActivePage().getPerspective().getId();
				if (p.equals("com.netxforge.netxstudio.ui.library")) //$NON-NLS-1$
					page.openEditor(input, LIB_ID);
				if (p.equals("com.netxforge.netxstudio.ui.networkdesign")) //$NON-NLS-1$
					page.openEditor(input, DESIGN_ID);
				
				input = new URIEditorInput(TeneoService.DATABASE_URI);
				if (p.equals("com.netxforge.netxstudio.ui.monitoring")) //$NON-NLS-1$
					page.openEditor(input, METRIC_ID);

			} catch (PartInitException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
