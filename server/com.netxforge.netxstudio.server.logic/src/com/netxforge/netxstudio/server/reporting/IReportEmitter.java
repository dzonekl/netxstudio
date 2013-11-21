/*******************************************************************************
 * Copyright (c) 29 okt. 2013 NetXForge.
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
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.netxforge.netxstudio.data.IData;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServiceUser;

/**
 * An emitting format for reports. 
 * 
 * @author Christophe Bouhier
 */
public interface IReportEmitter {

	public static final String REPORT_PREFIX_SM_EXEC = "Exec_Summary";
	public static final String REPORT_PREFIX_SM_DASH = "DashBoard";
	public static final String REPORT_PREFIX_SM_MATRIX = "Distribution";
	public static final String REPORT_PREFIX_SM_USER = "Users";
	public static final String REPORT_PREFIX_SM_RESOURCE = "Resources";
	public static final String REPORT_PREFIX_RM = "Details";
	public static final String REPORT_PREFIX_RM_FORECAST = "Forecast";

	public static List<String> reports = ImmutableList.of(
			REPORT_PREFIX_SM_EXEC, REPORT_PREFIX_SM_DASH,
			REPORT_PREFIX_SM_MATRIX, REPORT_PREFIX_SM_USER, REPORT_PREFIX_RM,
			REPORT_PREFIX_RM_FORECAST);

	/**
	 * 
	 * Return the file extension associated with this emitter.
	 * 
	 * @return
	 */
	public String getExtension();

	/**
	 * Return the name of this report
	 * 
	 * @return
	 */
	public String getReportName();

	/**
	 * 
	 */
	public abstract void activate(IData dataProvider);

	/**
	 * Flush what has been produced to the output stream
	 */
	public void flush(OutputStream stream);

	/**
	 * Should be implemented when writing to the the next page for a
	 * {@link Service Service name}. For example an XLSX emitter would create a
	 * new XLSX sheet and emit to this new sheet.
	 * 
	 * @param serviceName
	 */
	public void nextPage(String serviceName);

	/**
	 * Write the header with the specified {@link DateTimeRange period}
	 * 
	 * @param dtr
	 */
	public abstract void writeHeader(DateTimeRange dtr);

	/**
	 * Write the content of {@link NodeType Node type}
	 * 
	 * @param nodeType
	 */
	public abstract void writeContent(NodeType nodeType);

	/**
	 * Write the content of a {@Link Service}, {@link Node} for a
	 * specified row and column index.
	 * 
	 * @param service
	 * @param node
	 * @param rowIndex
	 * @param columnIndex
	 */
	public abstract void writeContent(Service service, Node node, int rowIndex,
			int columnIndex);

	/**
	 * Write the content of a {@link Service}, {@link ServiceUser} for a
	 * specified row and column index.
	 * 
	 * @param service
	 * @param serviceUser
	 * @param rowIndex
	 * @param columnIndex
	 */
	public abstract void writeContent(Service service, ServiceUser serviceUser,
			int rowIndex, int columnIndex);

	/**
	 * Write the content for a {@link Component}
	 * 
	 * @param component
	 */
	public abstract void writeContent(Component component);

	/**
	 * Write the final part.
	 */
	public abstract void writeFinal();

}
