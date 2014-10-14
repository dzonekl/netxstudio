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

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.netxforge.base.osgi.AbstractCommandProcessor;
import com.netxforge.netxstudio.metrics.MappingExternal;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.oss2.mappings.IMappingAggregator;
import com.netxforge.oss2.mappings.IMappingService;

@Component
public class InventoryService implements IInventoryService, CommandProvider {

	/*
	 * Provide MappingExternal implementations for specific name spaces.
	 */
	private IMappingAggregator mappingAggregator;

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
				
				
				// Now, we need to translate a string to a session, as we don't know what kind of source this is. 
				String metricLocation = metricSource.getMetricLocation();
				processMetricSourceLocation(metricLocation);
				
			}
		}else{
			// For other mapping types like CSV, Excel or RDBMS see current implementations 
			// in MetricSourceJobImplementation, it instanties the Processor depending on the mapping type. 
			
			
		}
		
		
		
	}

	/**
	 * Maps a given {@link URI#getScheme() to handler which can deal with it. 
	 * 
	 * @param metricLocation
	 */
	private void processMetricSourceLocation(String metricLocation) {
		try {
			URI uri = new URI(metricLocation);
			uri.getScheme();
			uri.getPort();
			
			
			
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

}
