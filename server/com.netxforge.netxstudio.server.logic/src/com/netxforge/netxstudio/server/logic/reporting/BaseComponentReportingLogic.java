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

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;

import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.scheduling.ComponentWorkFlowRun;
import com.netxforge.netxstudio.scheduling.Failure;
import com.netxforge.netxstudio.server.logic.BaseComponentLogic;
import com.netxforge.netxstudio.server.logic.internal.LogicActivator;

/**
 * Performs the resource monitoring logic execution for a RFSService.
 * 
 * @author Martin Taal
 */
public abstract class BaseComponentReportingLogic extends BaseComponentLogic {

	// @Override
	// protected abstract List<NodeType> getNodeTypesToExecuteFor();
	
//	private ServiceMonitor serviceMonitor;
	
	private static final int HEADER_CELL_SIZE = 10;
	
	private ReportingEngine engine;

	private HSSFWorkbook workBook;
	protected HSSFSheet sheet;

	private OutputStream stream;

	public OutputStream getStream() {
		return stream;
	}

	public void setStream(OutputStream stream) {
		this.stream = stream;
	}

	@Override
	protected ReportingEngine getEngine() {
		if (engine == null) {
			engine = LogicActivator.getInstance().getInjector()
					.getInstance(ReportingEngine.class);
		}
		return engine;
	}

	protected void doRun() {

		// start a transaction
		this.getData().getTransaction();

		final List<NodeType> allNodes = getNodeTypesToExecuteFor();

		getJobMonitor().setTotalWork(countComponents(allNodes));
		getJobMonitor().setTask("Performing reporting");
		
		
		// EXCEL WRITE
		setWorkBook(new HSSFWorkbook());
		
		writeReportTemplate();

		List<NodeType> uniqueNodeTypes = StudioUtils.uniqueNodeTypes(
				allNodes);

		int nodeTypeCount = 0;
		for (final NodeType nodeType : uniqueNodeTypes) {

			getJobMonitor().appendToLog(
					"reporting for node type" + nodeType.getName());

			getJobMonitor().setTask("Resource reporting Data for nodeType");

			// EXCEL WRITE
			this.writeContent(sheet, nodeType);

			if (nodeType.eIsSet(LibraryPackage.Literals.NODE_TYPE__NAME)) {
				// Output only the one matching nt.
				int nodeCount = 0;
				for (NodeType nt : allNodes) {

					if (nt.eIsSet(LibraryPackage.Literals.NODE_TYPE__NAME)) {
						if (nt.getName().equals(nodeType.getName())) {
							// EXCEL WRITE
							writeContent(sheet, (Node) nt.eContainer(),
									nodeCount++, nodeTypeCount);
							
							// EXCEL WRITE, DELEGATED TO ENGINE 
							// OPTIONAL FOR SOME REPORTS....
							processNode(nt);
							 
						}
					}
				}
			}else{
				getJobMonitor().appendToLog(
						"skipping node type" + nodeType.getName() + ", Node Type name is not set!" );
			}
			
			nodeTypeCount++;
		}
		if (!getFailures().isEmpty()) {
			final ComponentWorkFlowRun run = (ComponentWorkFlowRun) this
					.getData().getTransaction()
					.getObject(this.getJobMonitor().getWorkFlowRunId());

			for (Failure f : this.getFailures()) {
				run.getFailureRefs().add(f);
			}
		}

		try {
			workBook.write(this.getStream());
		} catch (IOException e) {
			e.printStackTrace();
			// TODO, Perhaps add another failure?
		}

		// dataProvider.commitTransaction();
	}

	// TODO, We likely don't need to walk the tree by leaf first.

//	protected void executeFor(Component component) {
//		this.getJobMonitor().setTask("Reporting for " + component.getName());
//		this.getJobMonitor().incrementProgress(1, false);
//		final ReportingEngine engine = (ReportingEngine) getEngine();
//		engine.setJobMonitor(getJobMonitor());
//		engine.setComponent(component);
//		engine.setDataProvider(this.getDataProvider());
//		engine.setPeriod(getTimeRange());
//		engine.execute();
//		if (engine.getFailures().size() > 0) {
//			for (final Failure failure : engine.getFailures()) {
//				if (failure instanceof ComponentFailure) {
//					((ComponentFailure) failure).setComponentRef(component);
//				}
//				this.getFailures().add(failure);
//			}
//		}
//	}

	@Override
	protected void processNode(NodeType nodeType) {
		int cnt = 0;
		{
			final Set<Equipment> leafEquipments = new HashSet<Equipment>();
			getLeafEquipments(nodeType.getEquipments(), leafEquipments);
			Set<Equipment> executeFor = leafEquipments;
			while (!executeFor.isEmpty()) {
				final Set<Equipment> newExecuteFor = new HashSet<Equipment>();
				for (final Equipment equipment : executeFor) {
					executeFor(equipment);
					if (equipment.eContainer() instanceof Equipment
							&& !newExecuteFor.contains(equipment.eContainer())) {
						newExecuteFor.add((Equipment) equipment.eContainer());
					}
					executeFor = newExecuteFor;
				}
				getJobMonitor().incrementProgress(0, (cnt++ % 10) == 0);
			}
		}
		{
			final Set<Function> leafFunctions = new HashSet<Function>();
			getLeafFunctions(nodeType.getFunctions(), leafFunctions);
			Set<Function> executeFor = leafFunctions;
			while (!executeFor.isEmpty()) {
				final Set<Function> newExecuteFor = new HashSet<Function>();
				for (final Function function : executeFor) {
					executeFor(function);
					if (function.eContainer() instanceof Function
							&& !newExecuteFor.contains(function.eContainer())) {
						newExecuteFor.add((Function) function.eContainer());
					}
					executeFor = newExecuteFor;
					getJobMonitor().incrementProgress(0, (cnt++ % 10) == 0);
				}
			}
		}
	}

	private void getLeafEquipments(List<Equipment> equipments,
			Set<Equipment> leafEquipments) {
		for (final Equipment equipment : equipments) {
			if (equipment.getEquipments().isEmpty()) {
				leafEquipments.add(equipment);
			} else {
				getLeafEquipments(equipment.getEquipments(), leafEquipments);
			}
		}
	}

	private void getLeafFunctions(List<Function> functions,
			Set<Function> leafFunctions) {
		for (final Function function : functions) {
			if (function.getFunctions().isEmpty()) {
				leafFunctions.add(function);
			} else {
				getLeafFunctions(function.getFunctions(), leafFunctions);
			}
		}
	}

	// /// WRITING SECTION.

	protected abstract void writeHeader(HSSFSheet sheet);

	protected abstract void writeContent(HSSFSheet sheet, NodeType nodeType);

	protected abstract void writeContent(HSSFSheet sheet, Node node, int index,
			int nodeTypeCount);

	protected void writeReportTemplate() {
		sheet = this.getWorkBook().createSheet();
		writeHeader(sheet);
	}

	public HSSFWorkbook getWorkBook() {
		return workBook;
	}

	public void setWorkBook(HSSFWorkbook workBook) {
		this.workBook = workBook;
	}

	// Formated Header cells, to be filled by clients.
	protected HSSFCell typeCell;
	protected HSSFCell titleCell;
	protected HSSFCell periodCell;

	public void createHeaderStructure(HSSFSheet sheet) {

		
		CellStyle baseStyle = this.getWorkBook().createCellStyle();
		baseStyle.setBorderTop(CellStyle.BORDER_MEDIUM);
		baseStyle.setBorderBottom(CellStyle.BORDER_MEDIUM);
		baseStyle.setBorderLeft(CellStyle.BORDER_MEDIUM);
		baseStyle.setBorderRight(CellStyle.BORDER_MEDIUM);
		baseStyle.setAlignment(CellStyle.ALIGN_LEFT);

		CellStyle typeStyle = this.getWorkBook().createCellStyle();
		typeStyle.cloneStyleFrom(baseStyle);
		
		Font typeFont = getWorkBook().createFont();
		typeFont.setFontHeightInPoints((short) 24);
		typeStyle.setFont(typeFont);


		HSSFRow typeRow = sheet.createRow(0);
		typeCell = typeRow.createCell(0);
		typeCell.setCellValue("<Service Type>");
		typeCell.setCellStyle(typeStyle);
		
		for( int i = 1 ;i < HEADER_CELL_SIZE ; i++){
			typeRow.createCell(i).setCellStyle(typeStyle);	
		}
		
		CellStyle titleStyle = this.getWorkBook().createCellStyle();
		titleStyle.cloneStyleFrom(baseStyle);
		
		Font titleFont = getWorkBook().createFont();
		titleFont.setFontHeightInPoints((short) 16);
		titleStyle.setFont(titleFont);


		HSSFRow titleRow = sheet.createRow(1);
		titleCell = titleRow.createCell(0);
		titleCell.setCellValue("<Report title>");
		titleCell.setCellStyle(titleStyle);

		for( int i = 1 ;i < HEADER_CELL_SIZE ; i++){
			titleRow.createCell(i).setCellStyle(titleStyle);	
		}

		HSSFRow periodRow = sheet.createRow(2);
		periodCell = periodRow.createCell(0);
		periodCell.setCellValue("<Period>");
		periodCell.setCellStyle(titleStyle);

		for( int i = 1 ;i < HEADER_CELL_SIZE ; i++){
			periodRow.createCell(i).setCellStyle(typeStyle);	
		}

		// Merge
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, HEADER_CELL_SIZE-1));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, HEADER_CELL_SIZE-1));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, HEADER_CELL_SIZE-1));

	}	
	
//	public ServiceMonitor getServiceMonitor() {
//		return serviceMonitor;
//	}
//
//	public void setServiceMonitor(ServiceMonitor serviceMonitor) {
//		this.serviceMonitor = serviceMonitor;
//	}

}
