/*******************************************************************************
 * Copyright (c) Sep 19, 2011 NetXForge.
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
package util;

import java.io.File;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.ServerSettings;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.server.Server;
import com.netxforge.netxstudio.server.jsp.JSPActivator;

public final class ListFolder {

	@Inject
	@Server
	IDataProvider dataProvider;

	private ServerSettings settings;

	private static final ListFolder INSTANCE = new ListFolder();

	public static final ListFolder getInstance() {
		return INSTANCE;
	}

	public ListFolder() {
		JSPActivator.getInstance().getInjector().injectMembers(this);
		dataProvider.openSession();
		Resource res = dataProvider
				.getResource(NetxstudioPackage.Literals.SERVER_SETTINGS);
		if (res.getContents().size() == 1) {
			settings = (ServerSettings) res.getContents().get(0);
		}

	}

	public String getPath() {
		return settings.getExportPath();
	}

	public List<File> getFiles(String contextPath) {

		// Compare to base context path.
		int index = contextPath.indexOf(JSPActivator.CONTEXT_PATH, 0);
		String exportPath = settings.getExportPath();
		if (index == 0) {
			exportPath += contextPath.substring(JSPActivator.CONTEXT_PATH.length());
		}
		File path = new File(exportPath);
		if (path.exists() && path.isDirectory()) {
			File[] files = path.listFiles();
			return Lists.newArrayList(files);
		}
		return Lists.newArrayList();
	}

}
