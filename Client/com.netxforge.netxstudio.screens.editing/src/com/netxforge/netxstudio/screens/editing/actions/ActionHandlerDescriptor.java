package com.netxforge.netxstudio.screens.editing.actions;

import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPart;

import com.google.common.collect.Lists;

/**
 * A context menu descriptor which can turn on and of menu sections.
 * <ul>
 * <li>Child creation</li>
 * <li>Sibling creation</li>
 * <li>Editing</li>
 * <li>etc..</li>
 * </ul>
 * 
 * It also acts as a repository or all Handlers and dispatches API calls to 
 * all registered IActionHandler implementations. 
 * 
 * @author dzonekl
 */
public class ActionHandlerDescriptor implements IActionHandler {

	private static final ActionHandlerDescriptor self = new ActionHandlerDescriptor();

	boolean enableChildCreationActions = false;

	boolean enableSiblingCreationActions = false;

	boolean enableEditActions = false;
	
	EStructuralFeature[] permittedChildCreationFeatures = null;
	public EStructuralFeature[] getPermittedChildCreationFeatures() {
		return permittedChildCreationFeatures;
	}

	public void setPermittedChildCreationFeatures(
			EStructuralFeature[] permittedChildCreationFeatures) {
		this.permittedChildCreationFeatures = permittedChildCreationFeatures;
	}

	public EStructuralFeature[] getPermittedChildrenCreationFeatures() {
		return permittedChildrenCreationFeatures;
	}

	public void setPermittedChildrenCreationFeatures(
			EStructuralFeature[] permittedChildrenCreationFeatures) {
		this.permittedChildrenCreationFeatures = permittedChildrenCreationFeatures;
	}

	EStructuralFeature[] permittedChildrenCreationFeatures = null;
	

	IMenuManager menuManager;

	List<IActionHandler> handlers = Lists.newArrayList();

	/**
	 * Returns a singleton.
	 * 
	 * @return
	 */
	public static ActionHandlerDescriptor INSTANCE() {
		return self;
	}

	public boolean isEnableChildCreationActions() {
		return enableChildCreationActions;
	}

	public void setEnableChildCreationActions(boolean enableChildCreationActions) {
		this.enableChildCreationActions = enableChildCreationActions;
	}

	public boolean isEnableSiblingCreationActions() {
		return enableSiblingCreationActions;
	}

	public void setEnableSiblingCreationActions(
			boolean enableSiblingCreationActions) {
		this.enableSiblingCreationActions = enableSiblingCreationActions;
	}

	public IMenuManager getMenuManager() {
		return menuManager;
	}

	public void setMenuManager(IMenuManager menuManager) {
		this.menuManager = menuManager;
	}

	public boolean isEnableEditActions() {
		return enableEditActions;
	}

	public void setEnableEditActions(boolean enableEditActions) {
		this.enableEditActions = enableEditActions;
	}

	public void addHandler(IActionHandler handler) {
		if (!handlers.contains(handler)) {
			handlers.add(handler);
		}
	}

	public void removeHandler(IActionHandler handler) {
		if (handlers.contains(handler)) {
			handlers.remove(handler);
		}
	}

	public void propertyChanged(Object source, int propId) {
		if (source instanceof IWorkbenchPart) {
			update((IWorkbenchPart) source);
		}

	}

	public void initActions(IActionBars actionBars) {
		for (IActionHandler handler : handlers) {
			handler.initActions(actionBars);
		}
	}

	public void setActivePart(IWorkbenchPart part) {
		for (IActionHandler handler : handlers) {
			handler.setActivePart(part);
		}

	}

	public void showMenu() {
		for (IActionHandler handler : handlers) {
			handler.showMenu(this);
		}
	}
	
	public void showMenu(ActionHandlerDescriptor descriptor) {
		for (IActionHandler handler : handlers) {
			handler.showMenu(descriptor);
		}
	}

	public void update(IWorkbenchPart part) {
		for (IActionHandler handler : handlers) {
			handler.update(part);
		}

	}



}