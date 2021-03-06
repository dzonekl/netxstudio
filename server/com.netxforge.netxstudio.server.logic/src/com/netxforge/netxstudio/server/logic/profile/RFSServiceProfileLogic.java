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

import java.util.List;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.services.ServiceUser;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * Performs the profile logic execution for a RFSService.
 * 
 * @author Christophe Bouhier. 
 */
public class RFSServiceProfileLogic extends BaseProfileLogic {

	

//	private ServiceMonitor serviceMonitor;

	public void initializeProfileLogic() {
//		Date startTime = getStartTime();
//		if (startTime == null) {
//			// TODO: make the period for the look back configurable
//			// TODO: note that a user can do a separate run which runs in the
//			// past
//			// creating new last service monitor with an end date in the past
//			// the system, should not pick the last servicemonitor in the list
//			// but should find the last end time of all service monitors.
//			startTime = new Date(System.currentTimeMillis() - 30 * 24 * 60 * 60
//					* 1000);
//			if (!rfsService.getServiceMonitors().isEmpty()) {
//				final Date previousEndTime = rfsService.getServiceMonitors()
//						.get(rfsService.getServiceMonitors().size() - 1)
//						.getPeriod().getEnd().toGregorianCalendar().getTime();
//				startTime = new Date(previousEndTime.getTime() + 1);
//			}
//			setStartTime(startTime);
//		}
//		Date endTime = getEndTime();
//		if (endTime == null) {
//			endTime = new Date(System.currentTimeMillis());
//			setEndTime(endTime);
//		}

//		serviceMonitor = ServicesFactory.eINSTANCE.createServiceMonitor();
//		// what name should a servicemonitor have?
//		serviceMonitor.setName(rfsService.getServiceName());
//		serviceMonitor.setPeriod(getTimeRange());
//		rfsService.getServiceMonitors().add(serviceMonitor);
//		getEngine().setServiceMonitor(serviceMonitor);
	}


	@Override
	protected List<ServiceUser> getServiceUsersToExecuteFor() {
		final List<ServiceUser> serviceUsers = Lists.newArrayList();
		//
		for (final ServiceUser serviceUser : this.getRfsService().getServiceUserRefs()) {
			// 1) The Service User should have a profile.�
			// 2) The Service Profile should have resources. 
			if (serviceUser
					.eIsSet(ServicesPackage.Literals.SERVICE_USER__SERVICE_PROFILE)
					&& serviceUser.getServiceProfile().getProfileResources()
							.size() > 0) {
				serviceUsers.add(serviceUser);
			}
		}
		return serviceUsers;
	}

}
