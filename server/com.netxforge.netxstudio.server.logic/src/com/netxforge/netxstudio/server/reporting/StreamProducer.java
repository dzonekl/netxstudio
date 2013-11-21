/*******************************************************************************
 * Copyright (c) May 20, 2011 NetXForge.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Martin Taal - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.server.reporting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

import org.eclipse.emf.common.util.URI;

import com.google.inject.Inject;
import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.ServerSettings;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.common.model.MonitoringStateModel;

/**
 * Produces an output stream.
 * 
 * @author Christophe Bouhier
 */
public class StreamProducer implements IStreamProducer {

	@Inject
	private ModelUtils modelUtils;

	private OutputStream stream;

	@Inject
	protected MonitoringStateModel monStateModel;

	private ServerSettings settings;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.server.reporting.IStreamProducer#initializeStream
	 * (com.netxforge.netxstudio.server.reporting.IReportEmitter,
	 * java.util.Date, java.util.Date, java.lang.String)
	 */
	public void initializeStream(IReportEmitter emitter, Date begin, Date end,
			String extension) {
		initializeStream(emitter, folderURI(), begin, end, extension);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.server.reporting.IStreamProducer#initializeStream
	 * (com.netxforge.netxstudio.server.reporting.IReportEmitter,
	 * org.eclipse.emf.common.util.URI, java.util.Date, java.util.Date,
	 * java.lang.String)
	 */
	public void initializeStream(IReportEmitter emitter, URI pathURI,
			Date begin, Date end, String extension) {

		// Are the ServerSettings resolved for the report location?
		if (pathURI == null) {
			throw new IllegalStateException(
					"The URI for storing reports shoud be set, check access to Server Settings data object");
		}

		// append the file name without the extension, for this run, try until
		// we have a new one.
		pathURI = pathURI.appendSegment(calculateFileName(emitter, begin, end));
		pathURI = pathURI.appendFileExtension(extension);
		{
			boolean absent = true;
			int tries = 1;
			while (absent) {
				File f = new File(pathURI.toFileString());
				if (f.exists()) {
					pathURI.trimFileExtension();
					pathURI.appendSegment(new Integer(tries).toString());
					pathURI.appendFileExtension(extension);
					tries++;
					continue;
				} else {
					absent = false;
				}
			}
		}

		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(pathURI.toFileString());
			this.setStream(fileOut);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.server.reporting.IStreamProducer#folderURI()
	 */
	public URI folderURI() {

		if (settings != null
				&& settings
						.eIsSet(NetxstudioPackage.Literals.SERVER_SETTINGS__EXPORT_PATH)) {

			URI uri = URI.createFileURI(settings.getExportPath());

			// append the folder for this run.
			uri = uri.appendSegment(calculateFolderName());
			{
				final File f = new File(uri.toFileString());
				if (!f.exists() && !f.isDirectory()) {
					f.mkdir();
				}
			}
			return uri;

		}
		return null;
	}

	protected String calculateFolderName() {
		StringBuffer buf = new StringBuffer();

		// buf.append(getModelUtils().date(this.getStartTime()) + "_"
		// + getModelUtils().date(this.getEndTime()));

		Date todayAndNow = modelUtils.todayAndNow();
		buf.append(this.modelUtils.folderDateAndTime(todayAndNow));

		return buf.toString();
	}

	protected String calculateFileName(IReportEmitter emitter, Date begin,
			Date end) {

		// Use the reporting period as a file name.
		String fileName = REPORT_PREFIX + "_" + emitter.getReportName()
				+ modelUtils.date(begin) + "_" + modelUtils.date(end);
		return fileName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.server.reporting.IStreamProducer#getStream()
	 */
	public OutputStream getStream() {
		return stream;
	}

	private void setStream(OutputStream stream) {
		this.stream = stream;
	}

	public ServerSettings getSettings() {
		return settings;
	}

	public void setSettings(ServerSettings settings) {
		this.settings = settings;
	}
}
