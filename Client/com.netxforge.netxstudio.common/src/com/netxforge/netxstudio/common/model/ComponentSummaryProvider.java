/*******************************************************************************
 * Copyright (c) 1 feb. 2013 NetXForge.
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
package com.netxforge.netxstudio.common.model;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Provider for monitoring model.
 * 
 * @author Christophe Bouhier
 */
public class ComponentSummaryProvider implements
		Provider<ComponentSummary> {

	private ModelUtils utils;

	private MonitoringStateModel stateModel;

	@Inject
	public ComponentSummaryProvider(MonitoringStateModel stateModel,
			ModelUtils utils) {
		this.utils = utils;
		this.stateModel = stateModel;
	}

	public ComponentSummary get() {
		final ComponentSummary summary = new ComponentSummary();

		summary.setModelUtils(utils);
		summary.setStatModel(stateModel);

		return summary;

	}
}
