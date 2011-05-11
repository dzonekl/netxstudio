package com.netxforge.netxstudio.emf.teneo.ui.handlers;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.netxforge.netxstudio.emf.teneo.TeneoService;
import com.netxforge.netxstudio.emf.teneo.ui.TeneoUI;


public class DisconnectHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		if(TeneoService.getInstance().initialized()){
			TeneoUI.INSTANCE.closeDataStore();
		}
		
		// Static reference, as we don't have access to the plugin holding the editors. 
		String ID = "com.netxforge.netxstudio.editors.librarysingledomain"; //$NON-NLS-1$
		
		// Close the editor from active editors in the active workbench page. 
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		IEditorReference[] refs = window.getActivePage().getEditorReferences();
		List<IEditorReference> editors = Arrays.asList(refs);
		for (IEditorReference eRef : editors) {
			if( eRef.getId().equals(ID)){
				window.getActivePage().closeEditor(eRef.getEditor(false), true);
			}
		}
		return null;
	}

}
