/*******************************************************************************
 * Copyright (c) 17 jun. 2014 NetXForge.
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
package com.netxforge.netxstudio.server;

import org.eclipse.emf.ecore.EPackage;

import com.google.common.collect.ImmutableList;
import com.netxforge.netxstudio.server.internal.ServerActivator;

public class ServerDataPackages {

	public static ServerDataPackages INSTANCE = new ServerDataPackages();

	public ServerDataPackages() {
		ServerActivator.getInstance().getInjector().injectMembers(this);
	};

	public String getRegisteredPackages() {
		// return packageService.discoverEPackages();

		StringBuilder sb = new StringBuilder();

		ImmutableList<String> copyOf = ImmutableList
				.copyOf(EPackage.Registry.INSTANCE.keySet().iterator());
		for (String s : copyOf) {
			sb.append("[" + copyOf.indexOf(s) + "]  -  " + s + "\n");
		}
		return sb.toString();
	}

	public EPackage getEPackage(String nsURI) {
		EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(nsURI);
		return ePackage;
	}

	public EPackage getPackageForIndex(int intValue) {
		EPackage ePackage = null;
		ImmutableList<String> copyOf = ImmutableList
				.copyOf(EPackage.Registry.INSTANCE.keySet().iterator());

		if (intValue <= copyOf.size()) {
			String string = copyOf.get(intValue);
			ePackage = getEPackage(string);
		}

		return ePackage;
	}
}
