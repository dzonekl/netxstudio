/*******************************************************************************
 * Copyright (c) Oct 10, 2012 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.screens.f3;

import java.util.List;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.util.CDOMementoUtil;
import com.netxforge.netxstudio.screens.f2.DisconnectedResourcesComponent;
import com.netxforge.netxstudio.screens.f2.NewEditResource;
import com.netxforge.screens.editing.base.IDataServiceInjection;
import com.netxforge.screens.editing.base.ScreenUtil;
import com.netxforge.screens.editing.base.actions.BaseSelectionListenerAction;
import com.netxforge.screens.editing.base.actions.SeparatorAction;

/**
 * 
 * @author Christophe Bouhier
 * 
 */
public class DisconnectedResources extends AbstractScreen implements
		IDataServiceInjection {

	/*
	 * Memento keys.
	 */
	private static final String MEM_KEY_NODERESOURCEADVANCED_SELECTION_RESOURCE = "MEM_KEY_VIEWER_SELECTION";

	@Inject
	private DisconnectedResourcesComponent cmpResources;

	private CDOResource operatorResource;

	private boolean readOnly;

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	private Form frmResources;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public DisconnectedResources(Composite parent, int style) {

		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		// buildUI();
	}

	protected void buildUI() {

		// Readonlyness.
		readOnly = ScreenUtil.isReadOnlyOperation(this.getOperation());

		@SuppressWarnings("unused")
		int widgetStyle = readOnly ? SWT.READ_ONLY : SWT.NONE;

		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmResources = toolkit.createForm(this);
		frmResources.setSeparatorVisible(true);

//		ImageDescriptor refreshDescriptor = ResourceManager
//				.getPluginImageDescriptor(
//						"com.netxforge.netxstudio.screens.editing",
//						"/icons/full/elcl16/refresh.gif");
//
//		frmResources.getToolBarManager().add(
//				new RefreshDisconnectedResourcesAction("", refreshDescriptor));
//		frmResources.getToolBarManager().update(true);

		toolkit.paintBordersFor(frmResources);

		frmResources.getBody().setLayout(new FillLayout());
		frmResources.setText(this.getOperationText() + "Orphan Resources");

		cmpResources.configure(screenService);
		cmpResources.buildUI(frmResources.getBody(), null);

	}

	class EditResourceAction extends BaseSelectionListenerAction {

		public EditResourceAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			IStructuredSelection structuredSelection = super
					.getStructuredSelection();

			Object o = structuredSelection.getFirstElement();
			NewEditResource resourceScreen = new NewEditResource(
					screenService.getScreenContainer(), SWT.NONE);
			resourceScreen.setOperation(getOperation());
			resourceScreen.setScreenService(screenService);

			// CB, the parent is the container resource.
			if (o instanceof CDOObject) {
				resourceScreen.injectData(null, o);
				screenService.setActiveScreen(resourceScreen);
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.netxforge.netxstudio.screens.editing.actions.
		 * BaseSelectionListenerAction
		 * #updateSelection(org.eclipse.jface.viewers.IStructuredSelection)
		 */
		@Override
		protected boolean updateSelection(IStructuredSelection selection) {
			Object firstElement = selection.getFirstElement();
			return firstElement instanceof NetXResource;
		}
	}

	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext bindingContext = new EMFDataBindingContext();
		cmpResources.initDataBindings_();
		return bindingContext;
	}

	public void injectData() {
		operatorResource = (CDOResource) editingService
				.getData(OperatorsPackage.Literals.OPERATOR);

		buildUI();
		registerFocus(this);
		initDataBindings_();

	}

	public void disposeData() {
	}

	public Viewer getViewer() {
		return cmpResources.getViewer();
	}

	@Override
	public boolean isValid() {
		return true;
	}

	List<IAction> actionList = Lists.newArrayList();

	@Override
	public IAction[] getActions() {
		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());
		String actionText = readonly ? "View..." : "Edit...";

		if (actionList.size() == 0) {

			actionList.add(new EditResourceAction(actionText));
			actionList.add(new SeparatorAction());
		}
		return actionList.toArray(new IAction[actionList.size()]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.AbstractScreenImpl#saveState(org.eclipse
	 * .ui.IMemento)
	 */
	@Override
	public void saveState(IMemento memento) {

		super.saveState(memento);

		// sash state vertical.
		// combo operator.
		CDOMementoUtil.rememberStructuredViewerSelection(memento,
				(StructuredViewer) cmpResources.getViewer(),
				MEM_KEY_NODERESOURCEADVANCED_SELECTION_RESOURCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.AbstractScreenImpl#init(org.eclipse.
	 * ui.IMemento)
	 */
	@Override
	public void restoreState(IMemento memento) {
		if (memento != null) {
			super.restoreState(memento);

			CDOMementoUtil.retrieveStructuredViewerSelection(memento,
					(StructuredViewer) cmpResources.getViewer(),
					MEM_KEY_NODERESOURCEADVANCED_SELECTION_RESOURCE,
					operatorResource.cdoView());
		}
	}

	/*
	 * Refreshs the UI with disconnected resources
	 */
	class RefreshDisconnectedResourcesAction extends Action {

		public RefreshDisconnectedResourcesAction(String text) {
			super(text);
		}

		public RefreshDisconnectedResourcesAction(String text,
				ImageDescriptor image) {
			super(text, image);
			this.setToolTipText("Refresh disconnected resources");
		}

		@Override
		public void run() {
			((StructuredViewer) cmpResources.getViewer()).refresh(true);

		}

	}

	public Form getScreenForm() {
		return frmResources;
	}

}
