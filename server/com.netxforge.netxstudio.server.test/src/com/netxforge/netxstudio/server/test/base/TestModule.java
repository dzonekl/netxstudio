/*******************************************************************************
 * Copyright (c) May 12, 2011 NetXForge.
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
 *    Christophe Bouhier - initial API and implementation and/or initial documentation
 *******************************************************************************/ 
package com.netxforge.netxstudio.server.test.base;

import static com.google.inject.util.Modules.override;

import com.google.inject.AbstractModule;
import com.google.inject.Module;
import com.netxforge.netxstudio.common.CommonModule;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.cdo.CDODataServiceModule;
import com.netxforge.netxstudio.server.test.actions.TestDataCreator;
import com.netxforge.netxstudio.server.test.dataprovider.NonStatic;
import com.netxforge.netxstudio.server.test.dataprovider.NonStaticCDODataProvider;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 *
 */
public class TestModule extends AbstractModule {

	public static Module getModule() {
		Module om = new CommonModule();
		om = override(om).with(new CDODataServiceModule());
		om = override(om).with(new TestModule());
		return om;
	}
	
	private TestModule(){
	}
	
	/* (non-Javadoc)
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		this.bind(IDataProvider.class).annotatedWith(NonStatic.class).to(NonStaticCDODataProvider.class);
		this.bind(TestDataCreator.class);
	}
}
