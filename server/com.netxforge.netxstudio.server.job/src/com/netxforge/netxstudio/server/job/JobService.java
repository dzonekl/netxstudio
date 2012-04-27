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
package com.netxforge.netxstudio.server.job;

import java.util.Map;

import com.netxforge.netxstudio.server.service.NetxForgeService;

/**
 * Run a command for our Jobs API. 
 * 
 * @author Christophe
 */
public class JobService implements NetxForgeService {
	
	
	// List all scheduled and running jobs. 
	public static final String COMMAND_SCHEDULER_LIST = "scheduler_list";

	// Stop the scheduler and abort all running jobs, for jobs in progress, we set the status to aborted. 
	public static final String COMMAND_SCHEDULER_STOP = "scheduler_stop";

	// Start the scheduler.
	public static final String COMMAND_SCHEDULER_START = "scheduler_start";
	
	public Object run(Map<String, String> parameters) {
		
		final String command = parameters.get(COMMAND_PARAM_NAME);
		
		// run in a separate thread
		new Thread() {
			@Override
			public void run() {
				// sleep to give the system
				// time to return
				try {
					sleep(100);
				} catch (final Exception e) {
					// do nothing, ignore
				}
				runCommand(command);
			}

		}.start();
		
		return "command done";
	}
	
	
	private void runCommand(String command) {
		if(command.equals(COMMAND_SCHEDULER_LIST)){
			JobHandler.list();
		}else if( command.equals(COMMAND_SCHEDULER_START)){
			// TODO, implement. 
		}else if( command.equals(COMMAND_SCHEDULER_STOP)){
			// TODO, implement.
		}
	};
}
