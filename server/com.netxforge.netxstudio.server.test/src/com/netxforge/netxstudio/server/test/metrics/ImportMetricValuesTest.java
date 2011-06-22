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
 * Contributors: 
 * 	Martin Taal - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.server.test.metrics;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.netxforge.netxstudio.server.ServerUtils;
import com.netxforge.netxstudio.server.service.NetxForgeService;
import com.netxforge.netxstudio.server.test.actions.ImportMetricValuesActions;

/**
 * Tests the import of metrics for one xls type.
 * 
 * @author Martin Taal
 */
public class ImportMetricValuesTest extends TestCase {
//	private static final String MS_NAME_1 = "SGSN attached users (Gb_IuPS)(10192010 1611)";
	private static final String MS_NAME_1 = "SGSN_Attached_Users";

	public void testImportSGSNMetricSource() throws Exception {
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(NetxForgeService.SERVICE_PARAM_NAME, ImportMetricValuesActions.class.getName());
		parameters.put(NetxForgeService.COMMAND_PARAM_NAME, ImportMetricValuesActions.IMPORT_METRIC_SOURCE_COMMAND);		
		parameters.put(ImportMetricValuesActions.METRIC_SOURCE_NAME_PARAM, MS_NAME_1);
		ServerUtils.getInstance().runService(parameters);
	}
}
