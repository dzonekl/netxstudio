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
package com.netxforge.base.log;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.log.LogEntry;
import org.osgi.service.log.LogListener;
import org.osgi.service.log.LogReaderService;
import org.osgi.service.log.LogService;

/**
 * Both produce and consume logging events.
 * 
 * @author Christophe Bouhier
 */
@Component(name = "OSS2 Simple console logger", immediate=true)
public class ConsoleLogger implements LogListener {

	private LogReaderService lrs;
	private LogService logService;

	@Activate
	public void activate() {
		lrs.addLogListener(this);
		logService.log(LogService.LOG_INFO, "OSS2 Console loggin service booting...");
	}

	@Deactivate
	public void deactivate() {
		logService.log(LogService.LOG_INFO, "OSS2 Console loggin service shutdown...");
		lrs.removeLogListener(this);
	}

	@Reference
	public void setLogReaderService(LogReaderService lrs) {
		this.lrs = lrs;
	}

	public void logged(LogEntry entry) {
		System.out.println("b:" + entry.getBundle() + " m:"
				+ entry.getMessage());
	}

	@Reference
	public void setLogService(LogService logService) {
		this.logService = logService;
	}

}
