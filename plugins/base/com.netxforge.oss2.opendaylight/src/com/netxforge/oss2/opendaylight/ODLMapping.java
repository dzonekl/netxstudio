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
package com.netxforge.oss2.opendaylight;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import tbd.params.xml.ns.yang.network.topology.TopologyPackage;

import com.netxforge.netxstudio.metrics.MappingExternal;
import com.netxforge.netxstudio.metrics.MetricsFactory;
import com.netxforge.oss2.mappings.IMappingService;

@Component(name = "OSS2 Mapping service for ODL models")
public class ODLMapping implements IMappingService {
	
	
	/**
	 * The name spaces supported by this mapping. 
	 */
	List<String> supportedNameSpaces = new ArrayList<String>();
	
	@Activate 
	public void activate(){
		supportedNameSpaces.add(TopologyPackage.eNS_URI);
	}

	@Override
	public MappingExternal getMappingExternal(String namespace) {
		// Should we just provide an instance, or should we pre-configure it for
		// the intended source.

		MappingExternal createMappingExternal = MetricsFactory.eINSTANCE
				.createMappingExternal();
		
		
		// Switch for the namespaces known to us. 
		if(namespace.equals(TopologyPackage.eNS_URI)){
			
		}
		
		return createMappingExternal;
	}

	@Override
	public String toString() {
		return "Mapping service for mapping possible ODL Models to the OSS2 model definition";
	}

	@Override
	public boolean serviceFor(String namespace) {
		if(namespace.equals(TopologyPackage.eNS_URI)){
			return true;
		}
		return false;
	}

	@Override
	public List<String> supportedNameSpaces() {
		// TODO Auto-generated method stub
		return null;
	}

}
