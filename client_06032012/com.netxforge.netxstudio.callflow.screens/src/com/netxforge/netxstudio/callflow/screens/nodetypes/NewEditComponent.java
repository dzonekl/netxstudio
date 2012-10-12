package com.netxforge.netxstudio.callflow.screens.nodetypes;

import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.swt.widgets.Composite;

import com.netxforge.netxstudio.callflow.screens.AbstractDetailsScreen;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;

/**
 * Abstract Component screen implementation, which can deliver various sections.
 * 
 * @author Christophe Bouhier
 * 
 */
public abstract class NewEditComponent extends AbstractDetailsScreen implements
		IDataScreenInjection {

	final IEditingService editingService;

	protected Component comp;

	public NewEditComponent(Composite parent, int style,
			final IEditingService editingService) {
		super(parent, style);
		this.editingService = editingService;
		// buildUI();
	}

	public void injectData(Object owner, Object object) {
		if (object instanceof Component) {
			this.comp = (Component) object;
		} else {
			return;
		}
		buildUI();
		initDataBindings_();
	}

	public abstract void buildUI();

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = new EMFDataBindingContext();
		return context;
	}

}
