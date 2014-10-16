/*******************************************************************************
 * Copyright (c) 14 okt. 2014 NetXForge.
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
package com.netxforge.oss2.mappings;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import com.netxforge.base.osgi.AbstractCommandProcessor;

/**
 * listens for all references to {@link IMappingService}.
 * 
 * @author Christophe Bouhier
 * 
 */
@Component(name = "OSS2 Model Mapping aggregator")
public class MappingAggregator implements IMappingAggregator, CommandProvider {

	/**
	 * 
	 */
	List<IMappingService> mappingServices = new ArrayList<IMappingService>();

	@Override
	public List<IMappingService> getMappingServices() {
		return mappingServices;
	}

	@Reference(cardinality = ReferenceCardinality.MULTIPLE)
	public void setMappingService(IMappingService service) {
		mappingServices.add(service);
	}

	public String _model(CommandInterpreter intp) {

		final StringBuilder sb = new StringBuilder();

		AbstractCommandProcessor cp = new AbstractCommandProcessor() {

			@SuppressWarnings("unused")
			public void _argument_mappings(String argument) {
				for (IMappingService mappingService : mappingServices) {
					sb.append("[" + mappingServices.indexOf(mappingService)
							+ "]" + mappingService.toString() + "\n");
				}
			}

			@SuppressWarnings("unused")
			public void _option_n(String option) {

				try {
					Integer integer = new Integer(option);
					if (integer < mappingServices.size()) {
						for (String namespace : mappingServices.get(integer)
								.supportedNameSpaces()) {
							sb.append(namespace + "\n");
						}
					}
				} catch (NumberFormatException nfe) {
				}
			}
		};

		cp.processCommands(intp);

		return sb.length() > 0 ? sb.toString() : "Session complete";
	}

	@Override
	public String getHelp() {
		StringBuilder sb = new StringBuilder();
		sb.append("---OSS2 Model Mapping\n\n");
		sb.append("\tThis is the Model Mapping Services for OSS2, usage:\n\n");
		sb.append("\tmodel mappings\n");

		return sb.toString();
	}

	@Activate
	public void activate() {
		System.out.println("OSS2 Model Mapping Service booting...");
	}

	@Override
	public IMappingService serviceForNamespace(String namespace) {
		for(IMappingService service : mappingServices){
			if(service.serviceFor(namespace)){
				return service;
			}
		}
		return null;
	}
}
