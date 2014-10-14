/*******************************************************************************
 * Copyright (c) 29 sep. 2014 NetXForge.
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
package com.netxforge.oss2.rest;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import restSession.EntityInfo;
import restSession.HTTP_METHODS;
import restSession.MEDIA_TYPE;
import restSession.PathFragment;
import restSession.RestSession;
import restSession.RestSessionFactory;
import restSession.RestSessionPackage;

import com.google.inject.Inject;
import com.netxforge.base.IEMFService;
import com.netxforge.base.osgi.AbstractCommandProcessor;
import com.netxforge.base.services.IExternalConnector;
import com.netxforge.oss2.files.IFilesProcessor;
import com.netxforge.oss2.rest.connectors.AbstractConnector;
import com.netxforge.oss2.rest.connectors.IConnector;
import com.netxforge.oss2.rest.entity.EMFEntityProcessr;
import com.netxforge.oss2.rest.internal.RestConnectorActivator;

/**
 * 
 * TODO Requires coupling of the RESTSession with an Object model. The EMF
 * Global Registry provides the models, but we need to write the content to
 * file.
 * 
 * @author Christophe Bouhier
 * 
 */
@Component
public class RestConnector implements IExternalConnector, CommandProvider {

	@Inject
	private IConnector connector;

	// Is needed to write content to file, for correct EMF Processing.
	private IFilesProcessor filesProcessor;

	private IEMFService emfService;

	@Activate
	public void activate() {

		System.out.println("Rest connector activated");

		RestConnectorActivator.getSelf().getInjector().injectMembers(this);

	}

	@Override
	public String getHelp() {
		StringBuilder sb = new StringBuilder();
		sb.append("---OSS2 REST\n\n");
		sb.append("\tThis is the REST Services Connector for OSS2, usage:\n\n");
		sb.append("\trest 'HTTP method' [option] pathspec \n");
		sb.append("\n");
		sb.append("\tAPI (Optional) , a path enhancer which is sticked after the base URL \n");
		sb.append("\tSupported HTTP Methods\n");
		sb.append("\tHTTP GET => Get request, will retrieve the data from the Rest interface\n");
		sb.append("\tHTTP POST => Post request, will post the data to the Rest interface\n");
		sb.append("\t-m => Either JSON or XML \n");
		sb.append("\t-e => The Entity model as an index, it van be obtained from the EMF service (emf packages)\n");

		return sb.toString();
	}

	public Object _rest(CommandInterpreter intp) {

		// prepare out session parameters.
		final RestSession restSession = RestSessionFactory.eINSTANCE
				.createRestSession();

		AbstractCommandProcessor abstractCommandProcessor = new AbstractCommandProcessor() {

			@SuppressWarnings("unused")
			public void _argument_get(String argument) {
				restSession.setHttpMethod(HTTP_METHODS.GET);
			}

			@SuppressWarnings("unused")
			public void _argument_post(String argument) {
				restSession.setHttpMethod(HTTP_METHODS.POST);
			}

			@SuppressWarnings("unused")
			public void _option_p(String password) {
				restSession.setPassword(password);
			}

			@SuppressWarnings("unused")
			public void _option_m(String mediaType) {
				if (mediaType.equalsIgnoreCase(MEDIA_TYPE.JSON.toString())) {
					restSession.setMedia(MEDIA_TYPE.JSON);
				} else if (mediaType
						.equalsIgnoreCase(MEDIA_TYPE.XML.toString())) {
					restSession.setMedia(MEDIA_TYPE.XML); // Default
															// value.
				}
			}

			@SuppressWarnings("unused")
			public void _option_e(String packageIndex) {
				EPackage packageForIndex = emfService
						.packageForIndex(packageIndex);
				EntityInfo createEntityInfo = RestSessionFactory.eINSTANCE
						.createEntityInfo();
				createEntityInfo.setName(packageForIndex.getNsURI());
				restSession.setEntityInfo(createEntityInfo);
			}

			public void _argument_default(String defaultArgument) {
				PathFragment createPathFragment = RestSessionFactory.eINSTANCE
						.createPathFragment();
				createPathFragment.setFragment(defaultArgument);
				restSession.getPathFragments().add(createPathFragment);
			}

		};

		abstractCommandProcessor.processCommands(intp);

		// sessionForCommands(intp, restSession);

		// TODO TRACING
		System.out.println(restSession.toString());
		System.out.println(restSession.constructURI());

		// END TRACING

		if (restSession.compleet()) {
			if (connector instanceof AbstractConnector) {
				
				
				// Make sure to clean the connector :-)
				connector.setEntityProcessor(null);
				

				// The name of the entity info is an EPackage nSURI
				if(restSession.eIsSet(RestSessionPackage.Literals.REST_SESSION__ENTITY_INFO)){
					connector.setEntityProcessor(new EMFEntityProcessr(emfService, restSession.getEntityInfo().getName()));
				}
				
				((AbstractConnector) connector).setFilesProcessor(filesProcessor);
				((AbstractConnector) connector).setRestSession(restSession);
				// Connect!
				connector.connect();
			}
			return "Session complete";
		}

		return getHelp();
	}

	@Reference
	public void setFileService(IFilesProcessor filesProcessor) {
		this.filesProcessor = filesProcessor;
	}

	@Reference
	public void setEMFService(IEMFService emfService) {
		this.emfService = emfService;
	}

	@Override
	public boolean supportsSchema(String schema) {
		return schema.equals("http");
	}
}
