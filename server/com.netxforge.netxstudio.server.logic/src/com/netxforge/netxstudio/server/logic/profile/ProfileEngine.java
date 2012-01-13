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
package com.netxforge.netxstudio.server.logic.profile;

import java.util.Date;
import java.util.List;

import com.netxforge.netxstudio.library.BaseExpressionResult;
import com.netxforge.netxstudio.scheduling.Failure;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.server.logic.BaseExpressionEngine;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.ServiceUser;

/**
 * Performs the profile execution for a service user. Context = ServiceUser
 * Context = DateTimeRange
 * 
 * Expression should calculate for all resources of the ServiceUser profile.
 * 
 * 
 * @author Christophe Bouhier
 */
public class ProfileEngine extends BaseExpressionEngine {

	private ServiceUser serviceUser;
	private RFSService service;

	@Override
	public void doExecute() {
		getExpressionEngine().getContext().clear();
		getExpressionEngine().getContext().add(getPeriod());
		getExpressionEngine().getContext().add(getService());
		System.err.println("Executing engine for" + serviceUser.getName());
		getExpressionEngine().getContext().add(this.getServiceUser());
		setEngineContextInfo("DerivedResource: " + serviceUser.getName()
				+ " - profile expression -");
		System.err.println("Run:" + this.getEngineContextInfo());
		runForExpression(serviceUser.getExpressionRef());
		System.err.println("Done:" + this.getEngineContextInfo());
		if (getFailures().size() > 0) {
			return;
		}
	}

	@Override
	public Failure getFailure() {
		return SchedulingFactory.eINSTANCE.createExpressionFailure();
	}

	public ServiceUser getServiceUser() {
		return serviceUser;
	}

	public void setServiceUser(ServiceUser serviceUser) {
		this.serviceUser = serviceUser;
	}

	@Override
	protected void processResult(List<Object> currentContext,
			List<BaseExpressionResult> expressionResults, Date start, Date end) {
		this.getCommonLogic().processServiceProfileResult(currentContext,
				expressionResults, start, end);
	}

	public RFSService getService() {
		return service;
	}

	public void setService(RFSService service) {
		this.service = service;
	}
}
