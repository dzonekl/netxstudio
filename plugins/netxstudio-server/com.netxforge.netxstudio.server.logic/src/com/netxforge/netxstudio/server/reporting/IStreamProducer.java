/*******************************************************************************
 * Copyright (c) Oct 31, 2013 NetXForge.
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
package com.netxforge.netxstudio.server.reporting;

import java.io.OutputStream;
import java.util.Date;

import org.eclipse.emf.common.util.URI;

import com.netxforge.netxstudio.ServerSettings;

/**
 * Provides an writing stream to be used by {@link IReportEmitter report
 * emitters}. Clients should implement {@link #folderURI()} as a location for
 * the {@link OutputStream output stream}
 * 
 * @author Christophe Bouhier
 */
public interface IStreamProducer {

	public static final String REPORT_PREFIX = "Cap";

	/**
	 * Initialize the output stream with the folder URI from the
	 * {@link ServerSettings}
	 * 
	 * @param begin
	 * @param end
	 * @param extension
	 */
	public abstract void initializeStream(IReportEmitter emitter, Date begin,
			Date end, String extension);

	/**
	 * Initialize the output stream
	 * 
	 * @param pathURI
	 */
	public abstract void initializeStream(IReportEmitter emitter, URI pathURI,
			Date begin, Date end, String extension);

	/**
	 * The URI of the folder where reports will be stored, is derived from the
	 * {@link ServerSettings Server settings}
	 * 
	 * @return
	 * @see
	 */
	public abstract URI folderURI();

	/**
	 * The stream to write to.
	 * 
	 * @return
	 */
	public abstract OutputStream getStream();

	/**
	 * Get the {@link ServerSettings}
	 * 
	 * @return
	 */
	public ServerSettings getSettings();

	/**
	 * Set the {@link ServerSettings}
	 * 
	 * @param settings
	 */
	public void setSettings(ServerSettings settings);

}