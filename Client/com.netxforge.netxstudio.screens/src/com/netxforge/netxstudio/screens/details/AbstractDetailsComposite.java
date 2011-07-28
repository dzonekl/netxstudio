package com.netxforge.netxstudio.screens.details;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Form;

import com.netxforge.netxstudio.screens.editing.selector.IScreen;
import com.netxforge.netxstudio.screens.editing.selector.IScreenFormService;

public abstract class AbstractDetailsComposite extends Composite implements IScreen {
	
	
	private int operation;
	protected IScreenFormService screenService;
	
	public AbstractDetailsComposite(Composite parent, int style){
		super(parent, style);
		super.setLayout(new FormLayout());
	}
	
	
	public int getOperation() {
		return operation;
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}
	
	
	public void disposeData() {
		// N/A for mini screens. 
	}

	public void setScreenService(IScreenFormService screenService) {
		this.screenService = screenService;
	}
	
	public void addData() {
		// N/A for mini screens.
	}

	public Form getScreenForm() {
		return null; // N/A for mini screens. 
	}
	
	public Viewer getViewer() {
		return null; // N/A
	}
	
	public IAction[] getActions(){
		return null; // N/A for a mini screen. 
	}


	public EStructuralFeature[] permittedCreationFeatures() {
		return null;
	}

	
}
