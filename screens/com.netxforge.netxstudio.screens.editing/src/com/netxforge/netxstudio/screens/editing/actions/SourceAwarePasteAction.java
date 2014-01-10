/*******************************************************************************
 * Copyright (c) 9 jan. 2014 NetXForge.
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
package com.netxforge.netxstudio.screens.editing.actions;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.ui.action.PasteAction;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * 
 * @author Christophe
 * 
 */
public class SourceAwarePasteAction extends PasteAction {

	class PasteStrategy {

		public static final int PASTE_INTO_TABLE = 100;
		public static final int PASTE_INTO_TREE = 200;
		
		public void source(Object source) {

		}

		public void applyStrategy() {

		}

	}

	private Object source;
	
	private String strategy;

	@Override
	public boolean updateSelection(IStructuredSelection selection) {
		System.out.println("Updating paste Action for ");
		return super.updateSelection(selection);
	}

	public void updateSource(Object o) {
		source = o;
	}

	@Override
	public Command createCommand(Collection<?> selection) {
		System.out.println("Creating paste command for strategy: " + strategy); 
		return super.createCommand(selection);
	}
	
	
	

}
