/*******************************************************************************
 * Copyright (c) 22 sep. 2014 NetXForge.
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
package com.netxforge.oss2.inventory;

import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import restSession.EntityInfo;
import restSession.HTTP_METHODS;
import restSession.MEDIA_TYPE;
import restSession.RestSession;
import restSession.RestSessionFactory;

import com.netxforge.base.osgi.AbstractCommandProcessor;
import com.netxforge.base.services.IConnectorService;
import com.netxforge.base.services.IExternalConnector;
import com.netxforge.netxstudio.metrics.MappingExternal;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.oss2.mappings.IMappingAggregator;
import com.netxforge.oss2.mappings.IMappingService;
import com.netxforge.oss2.rest.RestConnector;

@Component(name = "OSS2 Inventory Services")
public class InventoryService implements IInventoryService, CommandProvider {

	/*
	 * Provide MappingExternal implementations for specific name spaces.
	 */
	private IMappingAggregator mappingAggregator;

	private IConnectorService connectorService;

	@Override
	public void processMetricSource(MetricSource metricSource) {

		if (metricSource.getMetricMapping() instanceof MappingExternal) {
			MappingExternal mappingExt = (MappingExternal) metricSource
					.getMetricMapping();

			// TODO, remodel the external mapping to simply provide a namespace.
			String classURI = mappingExt.getClassURI();

			IMappingService serviceForNamespace = mappingAggregator
					.serviceForNamespace(classURI);

			if (serviceForNamespace != null) {
				MappingExternal mappingExternal = serviceForNamespace
						.getMappingExternal(classURI);

				// Now, we need to translate a string to a session, as we don't
				// know what kind of source this is.
				String metricLocation = metricSource.getMetricLocation();
				processMetricSourceLocation(metricLocation, mappingExternal);

			}
		} else {
			// For other mapping types like CSV, Excel or RDBMS see current
			// implementations
			// in MetricSourceJobImplementation, it instanties the Processor
			// depending on the mapping type.

		}

	}

/**
	 * Maps a given {@link URI#getScheme() to handler which can deal with it. 
	 * 
	 * @param metricLocation
 * @param mappingExternal 
	 */
	private void processMetricSourceLocation(String metricLocation, MappingExternal mappingExternal) {
		try {

			URI uri = new URI(metricLocation);
			IExternalConnector connectorFor = connectorService.connectorFor(uri
					.getScheme());
			if (connectorFor != null) {
				Object connectorInfo = connectorFor.connectorInfo();

				if (connectorFor instanceof RestConnector) {
					// we know its a RestSession now...
					RestSession session = (RestSession) connectorInfo;
					
					// This is the MEtric Source Location. 
					session.setBaseURI(metricLocation);
					
					// As inventory is reading, we force the GET method. 
					session.setHttpMethod(HTTP_METHODS.GET);
						
					// Matches the MappingExternal class URI. 
					EntityInfo createEntityInfo = RestSessionFactory.eINSTANCE.createEntityInfo();
					createEntityInfo.setName(mappingExternal.getClassURI());
					session.setEntityInfo(createEntityInfo);
					
					session.setMedia(MEDIA_TYPE.XML);
					
					// Could be obtained from the URL. 
					session.setPassword("admin"); 
					
					Object connect = connectorFor.connect(session);
					if(connect instanceof Resource){
						// Next is to make a matrix, and apply the mapping, which should populate our 
						// internal model topology. 
						
						
					}
					
				}
			}

		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	@Activate
	public void activate() {
		System.out.println("OSS2 Inventory service booting");
	}

	public void deactivate() {
	}

	@Override
	public String getHelp() {
		return "inventory [metricsource_id] // [TODO], Make metric sources more generic";
	}

	public Object _inventory(CommandInterpreter intp) {

		AbstractCommandProcessor cp = new AbstractCommandProcessor() {

		};

		cp.processCommands(intp);

		return "Session done";
	}

	@Reference
	public void setMappingAggregator(IMappingAggregator mappingAggregator) {
		this.mappingAggregator = mappingAggregator;
	}

	@Reference
	public void setConnectService(IConnectorService connectorService) {
		this.connectorService = connectorService;
	}

}
