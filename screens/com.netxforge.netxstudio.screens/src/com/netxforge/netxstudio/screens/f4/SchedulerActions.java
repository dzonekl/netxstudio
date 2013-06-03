/*******************************************************************************
 * Copyright (c) Apr 27, 2012 NetXForge.
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
package com.netxforge.netxstudio.screens.f4;

import org.eclipse.jface.action.Action;

import com.netxforge.netxstudio.data.actions.ServerRequest;

public class SchedulerActions {
	
	
	private ServerRequest serverActions;
	
	private ListScheduleAction listScheduleAction;
	
	public SchedulerActions(ServerRequest serverActions){
		this.serverActions = serverActions;
		createActions();
	}
	
	private void createActions() {
		listScheduleAction = new ListScheduleAction("list");
	}

	/**
	 * List all scheduled actions
	 * @author Christophe
	 *
	 */
	public class ListScheduleAction extends Action {

		public ListScheduleAction(String text) {
			super(text);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.action.Action#run()
		 */
		@Override
		public void run() {
			try {
				serverActions.callJobAction(ServerRequest.COMMAND_SCHEDULER_LIST);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @return the listScheduleAction
	 */
	public ListScheduleAction getListScheduleAction() {
		return listScheduleAction;
	}
}
