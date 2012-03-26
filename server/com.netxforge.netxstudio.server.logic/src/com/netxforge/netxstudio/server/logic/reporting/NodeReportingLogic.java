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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.ServerSettings;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;

/**
 * Performs the capacity logic execution for a RFSService.
 * 
 * @author Christophe Bouhier
 */
public abstract class NodeReportingLogic extends BaseNodeReportingLogic {

	private List<Node> nodes;

	private NodeType nodeType;

	public static final String REPORT_PREFIX = "Cap";

	// public static final String REPORT_PREFIX_SM_EXEC = "Exec_Summary";
	// public static final String REPORT_PREFIX_SM_DASH = "DashBoard";
	// public static final String REPORT_PREFIX_SM_MATRIX = "Distribution";
	// public static final String REPORT_PREFIX_SM_USER = "Users";
	public static final String REPORT_PREFIX_RM_RESOURCE = "Resources";

	// public static final String REPORT_PREFIX_RM = "Details";
	// public static final String REPORT_PREFIX_RM_FORECAST = "Forecast";

	public void initializeStream(URI uri) {

		// append the file name without the extension, for this run, try until
		// we have a new one.
		uri = uri.appendSegment(calculateFileName());
		uri = uri.appendFileExtension("xls");
		{
			boolean absent = true;
			int tries = 1;
			while (absent) {
				File f = new File(uri.toFileString());
				if (f.exists()) {
					uri.trimFileExtension();
					uri.appendSegment(new Integer(tries).toString());
					uri.appendFileExtension("xls");
					tries++;
					continue;
				} else {
					absent = false;
				}
			}
		}

		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(uri.toFileString());
			this.setStream(fileOut);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public abstract void writeFinal(Sheet sheet);
	
	public URI folderURI() {

		ServerSettings settings = getSettings();
		if (settings != null
				&& settings
						.eIsSet(NetxstudioPackage.Literals.SERVER_SETTINGS__EXPORT_PATH)) {

			URI uri = URI.createFileURI(settings.getExportPath());

			// append the folder for this run.
			uri = uri.appendSegment(calculateFolderName());
			{
				File f = new File(uri.toFileString());
				if (!f.exists() && !f.isDirectory()) {
					f.mkdir();
				}
			}
			return uri;

		}
		return null;
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodeType(NodeType nt) {
		this.nodeType = nt;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	@Override
	protected List<NodeType> getNodeTypesToExecuteFor() {

		// Get the nodes from the supplied list, otherwise get nodes matching
		// the node type.
		final List<NodeType> nodeTypes = new ArrayList<NodeType>();
		if (nodes != null) {

			// first go through the leave nodes
			for (final Node node : getNodes()) {
				if (getModelUtils().isInService(node)
						&& node.getNodeType().isLeafNode()) {
					nodeTypes.add(node.getNodeType());
				}
			}
			// and then the other nodes
			for (final Node node : getNodes()) {
				if (getModelUtils().isInService(node)
						&& !node.getNodeType().isLeafNode()) {
					nodeTypes.add(node.getNodeType());
				}
			}
		}else if (nodeType != null){
			
			// TODO, Algorithm gets all operators, all services and all nodes matching this type. 
			Resource operatorResource = this.getDataProvider().getResource(OperatorsPackage.Literals.OPERATOR);
			for(EObject eo : operatorResource.getContents()){
				if(eo instanceof Operator){
					for(Service service : ((Operator) eo).getServices()){
						if(service instanceof RFSService){
							List<Node> result = this.getModelUtils().nodesForNodeType((RFSService) service, nodeType);
							for(Node n : result){
								if(this.getModelUtils().isInService(n)){
									nodeTypes.add(n.getNodeType());
								}else{
									System.out.println("NodeReportingLogic: skipping node, not in service" + n.getNodeID());
								}
							}
						}
					}
				}
			}
		}

		return nodeTypes;
	}

	protected String calculateFolderName() {
		StringBuffer buf = new StringBuffer();

		// buf.append(getModelUtils().date(this.getStartTime()) + "_"
		// + getModelUtils().date(this.getEndTime()));

		Date todayAndNow = getModelUtils().todayAndNow();
		buf.append(this.getModelUtils().dateAndTime(todayAndNow));

		return buf.toString();
	}

	protected String calculateFileName() {
		StringBuffer buf = new StringBuffer();

		// Use the reporting period as a file name.
		buf.append(getModelUtils().date(this.getBeginTime()) + "_"
				+ getModelUtils().date(this.getEndTime()));

		return buf.toString();
	}

}
