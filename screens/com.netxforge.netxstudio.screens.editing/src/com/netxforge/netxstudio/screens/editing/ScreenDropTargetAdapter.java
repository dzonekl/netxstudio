/*******************************************************************************
 * Copyright (c) 7 feb. 2014 NetXForge.
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
package com.netxforge.netxstudio.screens.editing;

import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;

/**
 * A Simple {@link DropTargetAdapter} which converts a drop to an IScreen
 * injection.
 * 
 * @author Christophe
 * 
 */
public abstract class ScreenDropTargetAdapter extends DropTargetAdapter {

	/**
	 * The target IScreen. TODO Decide if the default can apply a drop operation
	 * to the IScreen.
	 */
	protected IScreen screen;

	public ScreenDropTargetAdapter(IScreen screen) {
		this.screen = screen;
	}

	@Override
	public void drop(DropTargetEvent event) {
		screenDrop(event);
	}

	@Override
	public void dropAccept(DropTargetEvent event) {
		super.dropAccept(event);
	}

	protected abstract void screenDrop(DropTargetEvent event);

	protected abstract void screenAccept(DropTargetEvent event);

	public Object extractData(DropTargetEvent event) {

		LocalTransfer localTransfer = LocalTransfer.getInstance();
		if (localTransfer.isSupportedType(event.currentDataType)) {
			// Transfer the data and, if non-null, extract it.
			Object object = localTransfer.nativeToJava(event.currentDataType);
			return object;
		}
		
		//  A-non supported transfer...
		return null;
	}

	public IScreen getScreen() {
		return screen;
	}
	

}
