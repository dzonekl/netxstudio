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
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.UnmodifiableIterator;
import com.google.inject.Inject;
import com.netxforge.base.NonModelUtils;
import com.netxforge.base.cdo.ICDOData;
import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.ServerSettings;
import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.server.data.IServerDataProvider;
import com.netxforge.netxstudio.server.data.Server;
import com.netxforge.netxstudio.server.jsp.JSPActivator;

/**
 * 
 * @author Christophe Bouhier
 * 
 */
public final class ListFolder {

	@Inject
	@Server
	private IServerDataProvider dpProvider;

	private ServerSettings settings;

	private String workspacePath;

	private static final ListFolder INSTANCE = new ListFolder();

	public static final ListFolder getInstance() {
		return INSTANCE;
	}

	public ListFolder() {
		JSPActivator.getInstance().getInjector().injectMembers(this);
	}

	/**
	 * 
	 */
	public void initMonitors() {
		ICDOData dataProvider = dpProvider.get();
		dataProvider.openSession();
		Resource res = dataProvider
				.getResource(NetxstudioPackage.Literals.SERVER_SETTINGS);
		if (res.getContents().size() == 1) {
			settings = (ServerSettings) res.getContents().get(0);
		}
	}

	/**
	 * 
	 */
	public void initWorkspace() {
		workspacePath = System.getProperty("osgi.instance.area");

	}

	public String getPath() {
		if (settings != null) {
			return settings.getExportPath();
		} else if (workspacePath != null) {
			return workspacePath;
		}
		return "unknown path...";
	}

	public List<File> getFiles(String contextPath) {

		// Compare to base context path.
		File path = null;
		if (settings != null) {
			String exportPath = settings.getExportPath();
			exportPath += contextPath;
			path = new File(exportPath);

		} else if (workspacePath != null) {
			String exportPath = workspacePath;
			exportPath += contextPath;
			try {
				URI uri = new URI(exportPath);
				path = new File(uri);
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (path != null && path.exists() && path.isDirectory()) {
			File[] files = path.listFiles();
			List<File> filesList = Lists.newArrayList(files);
			Collections.sort(filesList,
					NonModelUtils.fileLastModifiedComparator());
			UnmodifiableIterator<File> filter = Iterators.filter(
					filesList.iterator(), NonModelUtils.nonHiddenFile());
			return Lists.newArrayList(filter);
		}else if(path.isFile()){
			
		}
		return Lists.newArrayList();
	}

	public static final int NOT_PROCESSED = 0; // NOT DONE FILES.
	public static final int DONE = 1; // NOT DONE FILES.
	public static final int DONE_WITH_FAILURE = 2; // NOT DONE FILES.

	public List<File> getSourceFiles(String contextPath, int type) {

		List<File> result = Lists.newArrayList();

		// Compare to base context path.
		int index = contextPath.indexOf(JSPActivator.CONTEXT_PATH, 0);
		String importPath = settings.getImportPath();
		if (index == 0) {
			importPath += contextPath.substring(JSPActivator.CONTEXT_PATH
					.length());
		}
		File path = new File(importPath);
		if (path.exists() && path.isDirectory()) {
			File[] files = path.listFiles();
			List<File> filesList = Lists.newArrayList(files);
			Collections.sort(filesList,
					NonModelUtils.fileLastModifiedComparator());

			Predicate<File> fileExtensionPredicate = null;
			switch (type) {

			case NOT_PROCESSED: {
				// All non DONE, and non DONE_WITH_FAILURES.
				fileExtensionPredicate = NonModelUtils.extensionFile(true,
						StudioUtils.EXTENSION_DONE,
						StudioUtils.EXTENSION_DONE_WITH_FAILURES);
			}
				break;
			case DONE: {
				fileExtensionPredicate = NonModelUtils
						.extensionFile(StudioUtils.EXTENSION_DONE);
			}
				break;

			case DONE_WITH_FAILURE: {
				fileExtensionPredicate = NonModelUtils
						.extensionFile(StudioUtils.EXTENSION_DONE_WITH_FAILURES);
			}
				break;
			}

			UnmodifiableIterator<File> filter = Iterators.filter(
					filesList.iterator(), NonModelUtils.nonHiddenFile());
			// Check to see, if we have a predicate to filter.
			if (fileExtensionPredicate != null) {
				filter = Iterators.filter(filter, fileExtensionPredicate);
			}

			result = Lists.newArrayList(filter);
		}

		return result;
	}

}
