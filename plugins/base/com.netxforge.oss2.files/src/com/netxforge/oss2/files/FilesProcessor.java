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
package com.netxforge.oss2.files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import com.google.inject.Inject;
import com.netxforge.base.osgi.AbstractCommandProcessor;
import com.netxforge.oss2.files.internal.FilesActivator;

import files.FilesFactory;
import files.FilesSession;
import files.SESSIONS;

/**
 * Provides file services. Consumers can feed it
 * 
 * @author Christophe Bouhier
 */
@Component
public class FilesProcessor implements CommandProvider, IFilesProcessor {

	@Inject
	private IFiles files;

	@Activate
	public void activate() {
		FilesActivator.getSelf().getInjector().injectMembers(this);
		if (files != null) {
			System.out.println("Ho,Ho, Ho, Files services going :-8");
		}
	}

	@Override
	public String getHelp() {
		StringBuilder sb = new StringBuilder();
		sb.append("---OSS2 FILES\n\n");
		sb.append("\tThis is the FILES Services for OSS2, usage:\n\n");
		sb.append("\tfiles [options]\n");

		return sb.toString();
	}

	public Object _files(CommandInterpreter intp) {

		@SuppressWarnings("unused")
		FilesSession createFilesSession = FilesFactory.eINSTANCE
				.createFilesSession();
		@SuppressWarnings("unused")
		SESSIONS validateFor = null;

		AbstractCommandProcessor abstractCommandProcessor = new AbstractCommandProcessor() {

			@SuppressWarnings("unused")
			public void _argument_list(String argument) {
				// Check for listing validation.
				// validateFor = SESSIONS.LISTING;
				throw new UnsupportedOperationException("Sorry not yet");
			}

		};

		abstractCommandProcessor.processCommands(intp);

		return "Session complete";

	}

	@Override
	public void filesFor(FilesSession session) {
		files.process(session);
	}

	@Override
	public void writeFile(FilesSession session, InputStream in) {
		File fileToWrite = new File(session.getFolderURL() + '/'
				+ session.getFileName() + '/' + session.getFileExtension());

		try {
			OutputStream out = new FileOutputStream(fileToWrite);
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			out.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
