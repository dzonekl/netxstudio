package com.netxforge.netxstudio.screens.editing.selector;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Form;

import com.netxforge.netxstudio.screens.editing.IEditingService;


/**
 * Convenience implementation of a screen, sharing commonality like the 
 * screen operation, and the supporting services. 
 *  
 * @author dzonekl
 */
public abstract class AbstractScreen extends Composite implements IScreen {
	
	private int operation;
	
	protected IEditingService editingService;

	protected IScreenFormService screenService;
	
	public AbstractScreen(Composite parent, int style) {
		this(parent, style, null, null);
	}
	
	public AbstractScreen(Composite parent, int style, IEditingService eService) {
		this(parent, style, null, eService);
	}
	
	public AbstractScreen(Composite parent, int style, IScreenFormService sService, IEditingService eService) {
		super(parent, style);
		operation = style & 0xFF00; // Ignore first bits, as we piggy back on
		// the SWT style.
		screenService = sService;
		editingService = eService;
		
	}

	public abstract Viewer getViewer();

	public int getOperation() {
		return operation;
	}

	public  abstract boolean isValid();

	public abstract Form getScreenForm();

}
