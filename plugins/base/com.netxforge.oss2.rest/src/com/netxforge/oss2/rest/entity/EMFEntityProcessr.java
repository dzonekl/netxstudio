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
package com.netxforge.oss2.rest.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import javax.ws.rs.core.Response;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.emf.texo.component.ComponentProvider;
import org.eclipse.emf.texo.json.JSONEMFConverter;
import org.eclipse.emf.texo.store.MemoryObjectStore;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.netxforge.base.IEMFService;
import com.netxforge.oss2.rest.connectors.IEntityProcessr;

/**
 * Dispatches for the connector type.
 * 
 * @author Christophe Bouhier
 * 
 */
public class EMFEntityProcessr implements IEntityProcessr<EObject> {

	private IEMFService emfService;

	private String nsURI;

	public EMFEntityProcessr(IEMFService emfService, String nsURI) {
		this.emfService = emfService;
		this.nsURI = nsURI;
	}

	@Override
	public EObject processResult(Object toProcess) {

		if (toProcess instanceof Response) {
			_dispatchToJavaxWSRS((Response) toProcess);
		}
		return null;
	}

	private EObject _dispatchToJavaxWSRS(Response toProcess) {

		EObject readEntity = toProcess.readEntity(EObject.class);
		return readEntity;
	}

	public void process(InputStream stream, final EPackage pkg) {

		XMLResource res = new XMLResourceImpl() {

			@Override
			protected XMLHelper createXMLHelper() {
				XMLHelper helper = createXMLHelper();
				helper.setNoNamespacePackage(pkg);
				return helper;
			}
		};

		try {
			res.load(stream, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Process an {@link InputStream} with an EMF {@link ResourceFactoryImpl}
	 * resolved from the {@link #nsURI}.
	 * 
	 * @param stream
	 * @return
	 */
	public Resource processXML(InputStream stream) {
		final EPackage packageForIndex = emfService.packageForNS_URI(nsURI);
		BasicExtendedMetaData basicExtendedMetaData = new BasicExtendedMetaData() {

			@Override
			public EPackage getPackage(String namespace) {
				return packageForIndex;
			}
		};

		XMLResource res = new XMLResourceImpl();

		HashMap<String, Object> options = new HashMap<String, Object>();
		options.put(XMLResource.OPTION_EXTENDED_META_DATA,
				basicExtendedMetaData);
		options.put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
		try {
			res.load(stream, options);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * Process an {@link InputStream} with a TEXO
	 * 
	 * @param entityStream
	 * @return
	 */
	public Resource processJSON(InputStream entityStream) {
		JSONObject parseJSonentry = parseJSON(entityStream);
		Resource parseEMFentry = parseJSON_EMF(parseJSonentry);
		return parseEMFentry;
	}

	/**
	 * TODO Enrich the JSON with package info: {"_eclass":
	 * "nsPrefix|hostConfig",
	 * "nodeConnectorType":"OF","nodeConnectorId":"1","nodeId"
	 * :"00:00:00:00:00:00:00:03"
	 * ,"networkAddress":"10.0.0.3","dataLayerAddress":
	 * "7a:78:ba:2b:c2:30","staticHost":false,"vlan":"0","nodeType":"OF"}
	 * 
	 * @param parseJSonentry
	 * @return
	 */
	private Resource parseJSON_EMF(JSONObject parseJSonentry) {

		// Make sure the JSON model is enriched with eCLass info.
		 enrichJSONWithPackageInfo(parseJSonentry);

		final MemoryObjectStore memObjectStore = ComponentProvider
				.getInstance().newInstance(MemoryObjectStore.class);

		final JSONEMFConverter fromJsonConverter = ComponentProvider
				.getInstance().newInstance(JSONEMFConverter.class);
		fromJsonConverter.setObjectResolver(memObjectStore);
		EObject convert = fromJsonConverter.convert(parseJSonentry);
		ResourceImpl resource = new ResourceImpl();
		resource.getContents().add(convert);
		return resource;
	}

	private void enrichJSONWithPackageInfo(JSONObject parseJSonentry) {
		
		while(parseJSonentry.keys().hasNext()){
			String next = (String) parseJSonentry.keys().next();
			try {
				parseJSonentry.get(next);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
		}

	}

	protected JSONObject parseJSON(InputStream entityStream) {

		JSONTokener tokener = new JSONTokener(new InputStreamReader(
				entityStream));
		JSONObject root = null;
		try {
			root = new JSONObject(tokener);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return root;
	}
}
