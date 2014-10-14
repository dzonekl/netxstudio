/*******************************************************************************
 * Copyright (c) 10 okt. 2014 NetXForge.
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
package com.netxforge.base;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import com.netxforge.base.osgi.AbstractCommandProcessor;

/**
 * 
 * @author Christophe Bouhier
 */
@Component
public class EMFService implements CommandProvider, IEMFService {

	public String getHelp() {
		StringBuilder sb = new StringBuilder();
		sb.append("---OSS2 EMF Service\n\n");
		sb.append("\tThis is the EMF Service for OSS2, usage:\n\n");
		sb.append("\temf command");
		sb.append("\n");
		sb.append("\t Following commands are supported");
		sb.append("\t package");
		sb.append("\n");
		return sb.toString();
	}

	@Activate
	public void activate() {
		System.out.println("vroom... EMFService going");
	}

	public String _emf(CommandInterpreter intp) {
		final StringBuilder sb = new StringBuilder();
		AbstractCommandProcessor processor = new AbstractCommandProcessor() {

			@SuppressWarnings("unused")
			public void _argument_packages(String argument) {
				List<EPackage> globalPackages = EMFTooling.globalPackages();
				for (EPackage epack : globalPackages) {
					sb.append("[" + globalPackages.indexOf(epack) + "] nsURI: "
							+ epack.getNsURI() + " name:" + epack.getName() + "\n");
				}
			}
		};
		processor.processCommands(intp);
		return sb.toString();
	}

	public EPackage packageForIndex(String packageIndex) {

		Integer integer = new Integer(packageIndex);
		return EMFTooling.packageForIndex(integer.intValue());
	}

	public EPackage packageForNS_URI(String nsURI) {
		return EMFTooling.packageFor(nsURI);
	}

}
