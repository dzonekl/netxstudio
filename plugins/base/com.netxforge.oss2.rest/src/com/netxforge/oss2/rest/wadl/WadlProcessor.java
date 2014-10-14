/*******************************************************************************
 * Copyright (c) 7 okt. 2014 NetXForge.
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
package com.netxforge.oss2.rest.wadl;

import java.io.File;
import java.util.List;

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.netxforge.base.osgi.AbstractCommandProcessor;
import com.netxforge.oss2.files.IFilesProcessor;

import files.FilesFactory;
import files.FilesSession;

@Component
public class WadlProcessor implements IWadlProcessor, CommandProvider {

	private IFilesProcessor filesProcessor;

	@Activate
	public void activate() {
		System.out.println("Wadl going.. ");
	}

	@Modified
	public void modified() {
		System.out.println("hey something changed here.." + this);
	}

	public void _wadl(CommandInterpreter interpr) {
		AbstractCommandProcessor abstractCommandProcessor = new AbstractCommandProcessor() {
			@SuppressWarnings("unused")
			public void _argument_scan(String argument){
				doScanWadlFiles();		
			}

		};
		abstractCommandProcessor.processCommands(interpr);

		
	}

	@Override
	public String getHelp() {
		StringBuilder sb = new StringBuilder();
		sb.append("---OSS2 (REST) WADL\n\n");
		return sb.toString();
	}

	@Reference
	public void setFileService(IFilesProcessor filesProcessor) {
		this.filesProcessor = filesProcessor;
	}

	@Override
	public void doScanWadlFiles() {

		FilesSession fileSession = FilesFactory.eINSTANCE.createFilesSession();
		fileSession.setFolderURL("/Users/Christophe/Desktop/wadl/");
		fileSession.setFileExtension("wadl");
		filesProcessor.filesFor(fileSession);

		Object result = fileSession.getResult();
		if (result instanceof List<?>) {
			List<?> resultList = (List<?>) result;
			if (resultList.isEmpty()) {
				System.out.println("Sorry no files for: " + fileSession.toString());
			} else {
				for (Object o : resultList) {
					if (o instanceof File) {
						System.out.println(o.toString());
					}
				}
			}
		}

	}

}
