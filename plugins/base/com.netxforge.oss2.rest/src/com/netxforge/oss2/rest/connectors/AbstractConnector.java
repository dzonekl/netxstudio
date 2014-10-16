/*******************************************************************************
 * Copyright (c) 30 sep. 2014 NetXForge.
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
package com.netxforge.oss2.rest.connectors;

import restSession.RestSession;

import com.netxforge.oss2.files.IFilesProcessor;

/**
 * 
 * @author Christophe Bouhier
 * 
 */
public abstract class AbstractConnector implements IRestConnector {

	private RestSession restsourceConfiguration;

	private IEntityProcessr<?> processor;

	private IFilesProcessor filesProcessor;

	public IFilesProcessor getFilesProcessor() {
		return filesProcessor;
	}

	public void setFilesProcessor(IFilesProcessor filesProcessor) {
		this.filesProcessor = filesProcessor;
	}

	public RestSession getRestSession() {
		return restsourceConfiguration;
	}

	public void setRestSession(RestSession restsourceConfiguration) {
		this.restsourceConfiguration = restsourceConfiguration;
	}

	@SuppressWarnings("rawtypes")
	public void setEntityProcessor(IEntityProcessr processor) {
		this.processor = processor;
	}

	@SuppressWarnings("rawtypes")
	public IEntityProcessr getEntityProcessor() {
		return processor;
	}

}
