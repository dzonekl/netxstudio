/*******************************************************************************
 * Copyright (c) May 22, 2011 NetXForge.
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
package com.netxforge.netxstudio.common.internal;

import static org.ops4j.peaberry.Peaberry.service;
import static org.ops4j.peaberry.util.Attributes.objectClass;
import static org.ops4j.peaberry.util.TypeLiterals.export;

import com.netxforge.base.security.JCAServiceModule;
import com.netxforge.netxstudio.common.math.INativeFunctions;
import com.netxforge.netxstudio.common.math.INativeFunctions2;
import com.netxforge.netxstudio.common.math.NativeFunctions;
import com.netxforge.netxstudio.common.model.ChartModelProvider;
import com.netxforge.netxstudio.common.model.ComponentSummaryProvider;
import com.netxforge.netxstudio.common.model.IChartModelProvider;
import com.netxforge.netxstudio.common.model.MonitoringAdapterFactory;
import com.netxforge.netxstudio.common.model.MonitoringStateModel;
import com.netxforge.netxstudio.common.model.NetxresourceSummaryProvider;
import com.netxforge.netxstudio.common.model.NodetypeSummaryProvider;
import com.netxforge.netxstudio.common.model.OperatorSummaryProvider;
import com.netxforge.netxstudio.common.model.RFSServiceSummaryProvider;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class CommonModule extends JCAServiceModule {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		super.configure();

		// ///////////////////////////////
		// EXPORT SERVICES

		// Inject static.
		requestStaticInjection(MonitoringStateModel.class);

		bind(export(MonitoringStateModel.class)).toProvider(
				service(MonitoringStateModel.class).attributes(
						objectClass(MonitoringStateModel.class)).export());

		bind(export(MonitoringAdapterFactory.class)).toProvider(
				service(MonitoringAdapterFactory.class).attributes(
						objectClass(MonitoringAdapterFactory.class)).export());

		bind(export(NetxresourceSummaryProvider.class)).toProvider(
				service(NetxresourceSummaryProvider.class).attributes(
						objectClass(NetxresourceSummaryProvider.class))
						.export());

		bind(export(ComponentSummaryProvider.class)).toProvider(
				service(ComponentSummaryProvider.class).attributes(
						objectClass(ComponentSummaryProvider.class)).export());

		bind(export(NodetypeSummaryProvider.class)).toProvider(
				service(NodetypeSummaryProvider.class).attributes(
						objectClass(NodetypeSummaryProvider.class)).export());

		bind(export(RFSServiceSummaryProvider.class)).toProvider(
				service(RFSServiceSummaryProvider.class).attributes(
						objectClass(RFSServiceSummaryProvider.class)).export());

		bind(export(OperatorSummaryProvider.class)).toProvider(
				service(OperatorSummaryProvider.class).attributes(
						objectClass(OperatorSummaryProvider.class)).export());

		bind(export(IChartModelProvider.class)).toProvider(
				service(ChartModelProvider.class).export());

		// Bind each subsequent version of Native funtions separately.

		bind(export(INativeFunctions.class)).toProvider(
				service(NativeFunctions.class).export());

		bind(export(INativeFunctions2.class)).toProvider(
				service(NativeFunctions.class).export());

		// ///////////////////////////////
		// IMPORT SERVICES
		// (Copy to modules in other OSGI bundles to import the service).

		bind(INativeFunctions.class).toProvider(
				service(INativeFunctions.class).single());

	}
}
