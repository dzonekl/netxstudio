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
package com.netxforge.netxstudio.server.logic.reporting;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.common.util.URI;

import com.google.common.collect.ImmutableList;
import com.netxforge.base.NonModelUtils;
import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.ServerSettings;
import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.services.RFSService;

/**
 * Performs the capacity logic execution for a RFSService.
 * 
 * @author Christophe Bouhier
 */
public abstract class RFSServiceReportingLogic extends
		BaseComponentReportingLogic {

	private RFSService rfsService;
	public static final String REPORT_PREFIX = "Cap";

	public static final String REPORT_PREFIX_SM_EXEC = "Exec_Summary";
	public static final String REPORT_PREFIX_SM_DASH = "DashBoard";
	public static final String REPORT_PREFIX_SM_MATRIX = "Distribution";
	public static final String REPORT_PREFIX_SM_USER = "Users";
	public static final String REPORT_PREFIX_RM = "Details";
	public static final String REPORT_PREFIX_RM_FORECAST = "Forecast";

	public List<String> reports = ImmutableList.of(REPORT_PREFIX_SM_EXEC,
			REPORT_PREFIX_SM_DASH, REPORT_PREFIX_SM_MATRIX,
			REPORT_PREFIX_SM_USER, REPORT_PREFIX_RM, REPORT_PREFIX_RM_FORECAST);

	void initializeReportingLogic() {
		initializeStream();
	}

	public void initializeStream() {
		ServerSettings settings = getSettings();

		if (settings != null
				&& settings
						.eIsSet(NetxstudioPackage.Literals.SERVER_SETTINGS__EXPORT_PATH)) {
			try {

				URI uri = URI.createFileURI(settings.getExportPath());
				if (!uri.lastSegment().endsWith("/")) {
					uri.appendFragment("/");
				}
				uri = uri.appendSegment(calculateFileName())
						.appendFileExtension("xls");

				// FIXME, What if the file exists.
				FileOutputStream fileOut = new FileOutputStream(
						uri.toFileString());
				this.setStream(fileOut);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public RFSService getRfsService() {
		return rfsService;
	}

	public void setRfsService(CDOID cdoId) {
		// read the rfsservice in the transaction of the run
		this.rfsService = (RFSService) getData().getTransaction()
				.getObject(cdoId);
	}

	@Override
	protected List<NodeType> getNodeTypesToExecuteFor() {

		final List<NodeType> nodeTypes = new ArrayList<NodeType>();

		// first go through the leave nodes
		for (final Node node : rfsService.getNodes()) {
			if (StudioUtils.isInService(node)
					&& node.getNodeType().isLeafNode()) {
				nodeTypes.add(node.getNodeType());
			}
		}
		// and then the other nodes
		for (final Node node : rfsService.getNodes()) {
			if (StudioUtils.isInService(node)
					&& !node.getNodeType().isLeafNode()) {
				nodeTypes.add(node.getNodeType());
			}
		}
		return nodeTypes;
	}

	protected String calculateFileName() {
		StringBuffer buf = new StringBuffer();
		buf.append(NonModelUtils.date(this.getBeginTime()) + "_"
				+ NonModelUtils.date(this.getEndTime()));

		return buf.toString();
	}

}
