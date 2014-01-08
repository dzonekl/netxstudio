/*******************************************************************************
 * Copyright (c) 6 jan. 2014 NetXForge.
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
package com.netxforge.netxstudio.screens.editing.actions.handlers;

import java.util.List;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPart;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.netxforge.netxstudio.screens.editing.actions.IActionHandler;

/**
 * A context menu descriptor which can turn on and of menu sections.
 * <ul>
 * <li>Child creation</li>
 * <li>Sibling creation</li>
 * <li>Editing</li>
 * <li>etc..</li>
 * </ul>
 * 
 * It also acts as a repository or all Handlers and dispatches API calls to all
 * registered IActionHandler implementations.
 * 
 * @author Christophe Bouhier
 */
public class ActionHandlerDescriptor implements IActionHandler {

	private static final ActionHandlerDescriptor self = new ActionHandlerDescriptor();

	boolean enableChildCreationActions = false;

	boolean enableSiblingCreationActions = false;

	boolean enableEditActions = false;

//	private IScreen screen;

	// Not used.
	//
	// EStructuralFeature[] permittedChildCreationFeatures = null;
	//
	// public EStructuralFeature[] getPermittedChildCreationFeatures() {
	// return permittedChildCreationFeatures;
	// }
	//
	// public void setPermittedChildCreationFeatures(
	// EStructuralFeature[] permittedChildCreationFeatures) {
	// this.permittedChildCreationFeatures = permittedChildCreationFeatures;
	// }
	//
	// public EStructuralFeature[] getPermittedChildrenCreationFeatures() {
	// return permittedChildrenCreationFeatures;
	// }
	//
	// public void setPermittedChildrenCreationFeatures(
	// EStructuralFeature[] permittedChildrenCreationFeatures) {
	// this.permittedChildrenCreationFeatures =
	// permittedChildrenCreationFeatures;
	// }
	//
	// EStructuralFeature[] permittedChildrenCreationFeatures = null;

	IMenuManager menuManager;

	List<IActionHandler> handlers = Lists.newArrayList();

	private IWorkbenchPart part;

	private IActionBars actionBars;

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

	public void clearDynamicHandlers() {

		ImmutableList<IActionHandler> copyOfHandlers = ImmutableList
				.copyOf(handlers);
		for (IActionHandler handler : copyOfHandlers) {
			if (handler instanceof DynamicScreensActionHandler) {
				handler.deactivate();
				handlers.remove(handler);
			}
		}
	}

	public void clearHandlers() {
		ImmutableList<IActionHandler> copyOfHandlers = ImmutableList
				.copyOf(handlers);
		for (IActionHandler handler : copyOfHandlers) {
			handler.deactivate();
			handlers.remove(handler);
		}
	}

	public void addHandler(IActionHandler handler) {
		if (!handlers.contains(handler)) {
			handlers.add(handler);
			// Try to initialize and activate the handler.
			if (actionBars != null) {
				handler.initActions(actionBars);
			}
			if (part != null) {
				handler.setActivePart(part);
			}
		}
	}

	public void removeHandler(IActionHandler handler) {
		if (handlers.contains(handler)) {
			handlers.remove(handler);
			handler.deactivate();

		}
	}

	public boolean hasHandler(IActionHandler handler) {
		return handlers.contains(handler);
	}

	public void propertyChanged(Object source, int propId) {
		if (source instanceof IWorkbenchPart) {
			update((IWorkbenchPart) source);
		}

	}

	public void initActions(IActionBars actionBars) {
		this.actionBars = actionBars;
		for (IActionHandler handler : handlers) {
			handler.initActions(actionBars);
		}
	}

	public void setActivePart(IWorkbenchPart part) {
		this.part = part;
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

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Registered handlers: ");
		for (IActionHandler h : this.handlers) {
			sb.append(h.toString() + "\n");
		}
		return sb.toString();
	}

	public void deactivate() {
		// Ignore, we de-activate when removing handlers.
	}

}
