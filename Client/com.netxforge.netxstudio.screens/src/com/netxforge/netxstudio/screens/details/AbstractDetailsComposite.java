package com.netxforge.netxstudio.screens.details;

import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.Form;

import com.google.common.collect.Maps;
import com.netxforge.netxstudio.screens.editing.selector.IScreen;
import com.netxforge.netxstudio.screens.editing.selector.IScreenFormService;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;

public abstract class AbstractDetailsComposite extends Composite implements IScreen {
	
	
	private int operation;
	protected IScreenFormService screenService;
	protected ViewerFocusManager focusMgr = new ViewerFocusManager();



	public AbstractDetailsComposite(Composite parent, int style){
		super(parent, style);
		super.setLayout(new FormLayout());
		ScreensActivator.getDefault().getInjector().injectMembers(this);
	}
	
	
	public ViewerFocusManager getFocusMgr() {
		return focusMgr;
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
		return this.getFocusMgr().getViewer();
	}
	
	public IAction[] getActions(){
		return null; // N/A for a mini screen. 
	}

	public EStructuralFeature[] permittedCreationFeatures() {
		return null;
	}
	
	class ViewerFocusManager implements FocusListener{
		
		
		Control currentControl;
		Map<Control, Viewer> m = Maps.newHashMap();
		
		
		public void addControl(Viewer v, Control c){
			m.put(c, v);
			c.addFocusListener(this);
			
		}

		public void removeControl(Control c){
			m.remove(c);
			c.removeFocusListener(this);
		}
		
		public Viewer getViewer(){
			if(currentControl != null && m.containsKey(currentControl)){
				return m.get(currentControl);
			}
			return null;
		}
		
		public void focusGained(FocusEvent e) {
			if(e.getSource() instanceof Control){
				System.out.println("AbstractDetailsComposite: focus gained : " + e.getSource());
				if(m.containsKey(e.getSource())){
					this.currentControl = (Control) e.getSource();
					screenService.fireScreenChangedExternal(AbstractDetailsComposite.this);
				}
			}
		}

		public void focusLost(FocusEvent e) {
			if(e.getSource() instanceof Control){
				System.out.println("AbstractDetailsComposite: focus lost : " + e.getSource());
				currentControl = null;
			}
		}
	}
	
}
