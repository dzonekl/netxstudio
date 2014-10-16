/*******************************************************************************
 * Copyright (c) 1 okt. 2014 NetXForge.
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
package com.netxforge.oss2.rest.jersey;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.netxforge.oss2.rest.entity.EMFEntityProcessr;

/**
 * Construct with an {@link EMFEntityProcessr} to produce EMF Object graphs
 * (Resource) from a REST Response.
 * 
 * @author Christophe Bouhier
 */
public class EMFMessageBodyReader implements MessageBodyReader<Resource> {

	private EMFEntityProcessr entityProcessor;

	public EMFMessageBodyReader(EMFEntityProcessr entityProcessor) {
		this.entityProcessor = entityProcessor;
	}

	@Override
	public boolean isReadable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		boolean typeMatch = type == EObject.class;
		boolean mediaMatch = mediaType.equals(MediaType.APPLICATION_JSON_TYPE)
				|| mediaType.equals(MediaType.APPLICATION_XML_TYPE);

		return typeMatch && mediaMatch;
	}

	@Override
	public Resource readFrom(Class<Resource> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {
		if (mediaType.equals(MediaType.APPLICATION_JSON_TYPE)) {
			entityProcessor.processJSON(entityStream);
		} else if (mediaType.equals(MediaType.APPLICATION_XML_TYPE)) {
			entityProcessor.processXML(entityStream);
		}
		return entityProcessor.getResource();
	}

}
