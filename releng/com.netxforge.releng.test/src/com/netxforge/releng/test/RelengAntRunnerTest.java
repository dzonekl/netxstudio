/*******************************************************************************
 * Copyright (c) May 16, 2012 NetXForge.
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
package com.netxforge.releng.test;

import org.eclipse.ant.core.AntRunner;
import org.junit.Before;

/**
 */
public abstract class RelengAntRunnerTest {

	protected AntRunner runner;

	@Before
	public void before() {
		// 1. get releng ant tasks.
		// 2. Setup the ant runner.
		// 3. set the properties.
		runner = new AntRunner();
		String buildFileLocation = getAntBuildFileLocation();
		if (buildFileLocation != null && buildFileLocation.isEmpty()) {
			runner.setBuildFileLocation(buildFileLocation);
		}
		
		String[] propertyFiles = getPropertiesFiles();
		
		runner.setPropertyFiles(propertyFiles);
		
		String[] executionTargets = getExecutionTargets();
		
		runner.setExecutionTargets(executionTargets);
		
		runner.setArguments("-Dmessage=Building -verbose");
		
	}

	protected abstract String[] getExecutionTargets();

	protected abstract String[] getPropertiesFiles();

	protected abstract String getAntBuildFileLocation();

}
