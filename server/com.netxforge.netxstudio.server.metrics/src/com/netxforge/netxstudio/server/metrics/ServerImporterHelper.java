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
package com.netxforge.netxstudio.server.metrics;

import java.util.Date;
import java.util.List;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.importer.AbstractMetricValuesImporter;
import com.netxforge.netxstudio.data.importer.IImporterHelper;
import com.netxforge.netxstudio.data.importer.NetworkElementLocator;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.KindHintType;
import com.netxforge.netxstudio.server.CommonLogic;
import com.netxforge.netxstudio.server.Server;
import com.netxforge.netxstudio.server.metrics.internal.MetricsActivator;

/**
 * The main entry class for the Metrics importing.
 * 
 * @author Martin Taal
 */
public class ServerImporterHelper implements IImporterHelper {
	
	
	
	/* We need the importer to set the data provider */
	private AbstractMetricValuesImporter importer;

	public ServerImporterHelper() {
	}
	
	public void setImporter(AbstractMetricValuesImporter importer){
		this.importer = importer;
	}

	@Inject
	private CommonLogic commonLogic;

	public void initializeProviders(NetworkElementLocator networkElementLocator) {
		commonLogic.setDataProvider(importer.getDataProvider());

		// force that the same dataprovider is used
		// so that components retrieved by the networkElementLocator
		// participate in the same transaction
		networkElementLocator.setDataProvider(importer.getDataProvider());
	}

	public IDataProvider getDataProvider() {
		// get it from the serverside
		IDataProvider dataProvider = MetricsActivator.getInstance()
				.getInjector().getInstance(LocalDataProviderProvider.class)
				.getDataProvider();
		// Set in the importer so we are called only once. 
		importer.setDataProvider(dataProvider);
		return dataProvider;
	}

	public static class LocalDataProviderProvider {

		@Inject
		@Server
		private IDataProvider dataProvider;

		public IDataProvider getDataProvider() {
			return dataProvider;
		}
	}

	public void addToValueRange(NetXResource foundNetXResource, int periodHint,
			KindHintType kindHintType, List<Value> newValues, Date start,
			Date end) {
		commonLogic.addToValueRange(foundNetXResource, periodHint,
				kindHintType, newValues, start, end);
	}

}
