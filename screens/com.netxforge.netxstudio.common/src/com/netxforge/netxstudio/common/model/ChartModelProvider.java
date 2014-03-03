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
import com.netxforge.netxstudio.common.math.INativeFunctions;

/**
 * Provider for a chart model.
 * 
 * @author Christophe Bouhier
 */
public class ChartModelProvider implements Provider<IChartModel>,
		IChartModelProvider {

	private INativeFunctions nativeFunctions;

	@Inject
	public ChartModelProvider(INativeFunctions nativeFunctions) {
		this.nativeFunctions = nativeFunctions;

	}

	public IChartModel get() {
		final ChartModel cm = new ChartModel();
		cm.setNativeFunctions(nativeFunctions);
		return cm;
	}
}
