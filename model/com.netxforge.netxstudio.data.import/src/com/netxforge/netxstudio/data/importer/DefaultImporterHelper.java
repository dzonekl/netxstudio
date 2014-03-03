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
package com.netxforge.netxstudio.data.importer;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.IData;
import com.netxforge.netxstudio.data.index.IComponentLocator;
import com.netxforge.netxstudio.data.internal.ImportActivator;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.KindHintType;
import com.netxforge.netxstudio.metrics.ValueDataKind;

/**
 * A Helper for the importer. Deals mainly with the dataprovider. Clients should
 * have their own implementation as the default implementation doesn't store the
 * imported data.
 * 
 * @author Christophe Bouhier
 */
public class DefaultImporterHelper implements IImporterHelper {

	/* We need the importer to set the data provider */
	@SuppressWarnings("unused")
	private IMetricValueImporter importer;

	public DefaultImporterHelper() {
	}

	public void setImporter(AbstractMetricValuesImporter importer) {
		this.importer = importer;
	}

	public void initializeProviders(IComponentLocator networkElementLocator) {
		// force that the same dataprovider is used
		// so that components retrieved by the networkElementLocator
		// participate in the same transaction
		networkElementLocator.setDataProvider(getDataProvider());
	}

	public IData getDataProvider() {
		// get it from the serverside
		IData dataProvider = ImportActivator.getInjector()
				.getInstance(LocalDataProviderProvider.class).getDataProvider();
		// Set in the importer so we are called only once.
		// importer.setDataProvider(dataProvider);
		return dataProvider;
	}

	public static class LocalDataProviderProvider {

		@Inject
		private IData dataProvider;

		public IData getDataProvider() {
			return dataProvider;
		}
	}

	public void addToValueRange(NetXResource foundNetXResource, int periodHint,
			KindHintType kindHintType, List<Value> newValues, Date start,
			Date end) {

		// We don't write data in the default implementation....
	}

	public boolean cancelled() {
		return false;
	}

	public int addMetricValue(ValueDataKind vdk, Date timeStamp,
			Component networkElement, Double dblValue, int periodHint) {
		throw new UnsupportedOperationException();
	}

	public Properties properties() {
		throw new UnsupportedOperationException();
	}
}
