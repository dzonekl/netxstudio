/*******************************************************************************
 * Copyright (c) May 20, 2011 NetXForge.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Martin Taal - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.server.logic.reporting;

import com.netxforge.netxstudio.common.model.NodesSummmary;
import com.netxforge.netxstudio.server.logic.BaseExpressionEngine;
import com.netxforge.netxstudio.services.Service;

/**
 * Adds a component context to the expression engine. 
 * 
 * @author Christophe Bouhier
 */
public abstract class BaseServiceEngine extends BaseExpressionEngine {

	private Service Service;
	private NodesSummmary summary;

	public Service getService() {
		return Service;
	}

	public void setService(Service service) {
		Service = service;
	}

	public NodesSummmary getServiceSummary() {
		return summary;
	}

	public void setServiceSummary(NodesSummmary summary) {
		this.summary = summary;
	}

}
