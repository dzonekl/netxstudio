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

import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServiceUser;

/**
 * Provides empty implementation.   
 * 
 * @author Christophe Bouhier
 */
public abstract class BaseServiceReportingAdapterLogic extends BaseServiceReportingLogic {


	@Override
	public void writeFinal(HSSFSheet sheet) {
		
	}

	@Override
	protected void processServiceUser(Service service, HSSFSheet sheet) {
		
	}

	@Override
	protected void writeHeader(HSSFSheet sheet, DateTimeRange dtr) {
	}

	@Override
	protected void writeContent(HSSFSheet sheet, NodeType nodeType) {
	}

	@Override
	protected void writeContent(HSSFSheet sheet, Service service, Node node,
			int rowIndex, int columnIndex) {
		
	}

	@Override
	protected void writeContent(HSSFSheet sheet, Service service,
			ServiceUser serviceUser, int rowIndex, int columnIndex) {
	}

	@Override
	protected void writeContent(HSSFSheet sheet, Component component) {
	}
	

}
