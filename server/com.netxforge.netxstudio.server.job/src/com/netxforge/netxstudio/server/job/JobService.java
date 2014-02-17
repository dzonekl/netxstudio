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

import com.netxforge.netxstudio.data.actions.ServerRequest;
import com.netxforge.netxstudio.server.service.NetxForgeService;

/**
 * Run a command for our Jobs API.
 * 
 * @author Christophe Bouhier
 */
public class JobService implements NetxForgeService {

	public Object run(Map<String, String> parameters) {

		final String command = parameters.get(COMMAND_PARAM_NAME);
		runCommand(command);
		if (result == null) {
			return "command done";
		} else {
			return result;
		}
	}

	/**
	 * The result of the action.
	 */
	String result;

	/**
	 * Various additional commands can be run from OSGI console.
	 * 
	 */
	private void runCommand(String command) {

		result = null;
		if (command.equals(ServerRequest.COMMAND_SCHEDULER_LIST)) {
			result = JobHandler.scheduledStructured();
		} else if (command.equals(ServerRequest.COMMAND_SCHEDULER_START)) {
			JobHandler.start();
			result = JobHandler.status();
		} else if (command.equals(ServerRequest.COMMAND_SCHEDULER_STOP)) {
			JobHandler.stop();
			result = JobHandler.status();
		} else if (command.equals(ServerRequest.COMMAND_SCHEDULER_STATUS)) {
			result = JobHandler.status();
		}
//		System.out.println("Job action result for command: " + command + " : "
//				+ result);

	};
}
