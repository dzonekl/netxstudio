/*******************************************************************************
 * Copyright (c) 14 okt. 2014 NetXForge.
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
package com.netxforge.oss2.jobs;

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import com.netxforge.base.osgi.AbstractCommandProcessor;

/**
 * The OSS2 Job Handler, which controls our Quartz Scheduler.
 * 
 * @author Christophe Bouhier
 * 
 */
@Component
public class JobHandler implements CommandProvider, IJobHandler {

	private QuartzImplementation quartzImplementation;

	@Activate
	public void activate() {
		System.out.println("OSS2 Jobs booting..hehe");
		quartzImplementation = new QuartzImplementation();
		quartzImplementation.initialize();
	}

	@Override
	public String getHelp() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("---OSS2 Job commands---\n");
		buffer.append("\tjob status - status of the scheduler \n");
		buffer.append("\tjob start - start the scheduler \n");
		buffer.append("\tjob stop - stop the scheduler \n");
		buffer.append("\tjob schedule - list the scheduled jobs \n");
		buffer.append("\tjob list - list the existing jobs \n");
		buffer.append("\tjob activate [Job name/index] | 'all' - activate a job \n");
		buffer.append("\tjob deactivate [Job name/index] | 'all' - de-activate a job \n");
		buffer.append("\tjob pause - pause the scheduled jobs (Running jobs are not interrupted) \n");
		buffer.append("\tjob resume - resume the schduled jobs \n");
		buffer.append("\tjob clean - clean job progress data\n");
		return buffer.toString();
	}

	public Object _job(CommandInterpreter interpreter) {
		final StringBuilder sb = new StringBuilder();

		AbstractCommandProcessor cp = new AbstractCommandProcessor() {
			@SuppressWarnings("unused")
			public void _argument_status(String argument) {
				sb.append(quartzImplementation.statusScheduler());
			}

			@SuppressWarnings("unused")
			public void _argument_start(String argument) {
				sb.append(quartzImplementation.startScheduler());
			}

			@SuppressWarnings("unused")
			public void _argument_stop(String argument) {
				sb.append(quartzImplementation.stopScheduler());
			}
			
			@SuppressWarnings("unused")
			public void _argument_schedule(String argument) {
				sb.append(quartzImplementation.listScheduler());
			}
			
		};

		cp.processCommands(interpreter);

		return sb.length() > 0 ? sb.toString() : "Session complete";

		// try {
		// String cmd = interpreter.nextArgument();
		// if ("schedule".equals(cmd)) {
		// JobHandler.scheduled(interpreter); // we could be initializing!
		// return null;
		// }
		// if ("list".equals(cmd)) {
		// JobHandler.list(interpreter); // we could be initializing!
		// return null;
		// }
		// if ("activate".equals(cmd)) {
		// JobHandler.activate(interpreter); // we could be initializing!
		// return null;
		// }
		// if ("deactivate".equals(cmd)) {
		// JobHandler.deActivate(interpreter); // we could be initializing!
		// return null;
		// }
		// if ("start".equals(cmd)) {
		// JobHandler.start(interpreter); // we could be initializing!
		// return null;
		// }
		// if ("stop".equals(cmd)) {
		// JobHandler.stop(interpreter); // we could be initializing!
		// return null;
		// }
		// if ("pause".equals(cmd)) {
		// JobHandler.pauseAll(interpreter); // we could be initializing!
		// return null;
		// }
		// if ("resume".equals(cmd)) {
		// JobHandler.resumeAll(interpreter); // we could be initializing!
		// return null;
		// }
		// if ("clean".equals(cmd)) {
		// JobHandler.clean(interpreter); // We could be initializing and
		// // running jobs!
		// return null;
		// }
		//
		// interpreter.println(getHelp());
		// } catch (Exception ex) {
		// interpreter.printStackTrace(ex);
		// }

	}

	@Override
	public void addJob(Object job) {
		// TODO Auto-generated method stub
	}
}
