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

import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.scheduling.ComponentWorkFlowRun;
import com.netxforge.netxstudio.server.logic.BaseLogic;
import com.netxforge.netxstudio.server.logic.LogicActivator;

/**
 * Performs the resource monitoring logic execution for a RFSService.
 * 
 * @author Martin Taal
 */
public abstract class BaseResourceReportingLogic extends BaseLogic {


//	@Override
//	protected abstract List<NodeType> getNodeTypesToExecuteFor();

	private ResourceReportingEngine engine;
	
	private HSSFWorkbook workBook;
	
	private OutputStream stream;
	
	public OutputStream getStream() {
		return stream;
	}

	public void setStream(OutputStream stream) {
		this.stream = stream;
	}

	@Override
	protected ResourceReportingEngine getEngine() {
		if (engine == null) {
			engine = LogicActivator.getInstance().getInjector()
					.getInstance(ResourceReportingEngine.class);
		}
		return engine;
	}
	
	protected void doRun() {
		
		// start a transaction
		this.getDataProvider().getTransaction();
		
		final List<NodeType> nodeTypes = getNodeTypesToExecuteFor();

		getJobMonitor().setTotalWork(countComponents(nodeTypes));
		getJobMonitor().setTask("Performing reporting");
			
		setWorkBook(new HSSFWorkbook());
		
		createReportTemplate();
		
		for (final NodeType nodeType : nodeTypes) {

			getJobMonitor().appendToLog("reporting for node (type) "
					+ ((Node) nodeType.eContainer()).getNodeID());

			getJobMonitor().setTask("Resource reporting Data for nodeType");
			processNode(nodeType);
		}
		if (!getFailures().isEmpty()) {
			final ComponentWorkFlowRun run = (ComponentWorkFlowRun) this.getDataProvider()
					.getTransaction().getObject(this.getJobMonitor().getWorkFlowRunId());
			run.getFailureRefs().addAll(getFailures());
		}
		
		
		try {
			workBook.write(this.getStream());
		} catch (IOException e) {
			e.printStackTrace();
			// TODO, Perhaps add another failure? 
		}
		
//		dataProvider.commitTransaction();
	}
	
	private void createReportTemplate() {
		HSSFSheet sheet = this.getWorkBook().createSheet();
		createHeader(sheet);
		createContent(sheet);
	}

	protected abstract void createHeader(HSSFSheet sheet);
	
	protected abstract void createContent(HSSFSheet sheet);
	
	
	// TODO, We likely don't need to walk the tree by  leaf first. 
	
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
	
	
	public HSSFWorkbook getWorkBook() {
		return workBook;
	}


	public void setWorkBook(HSSFWorkbook workBook) {
		this.workBook = workBook;
	}
	
	
	protected HSSFCell typeCell;
	protected HSSFCell titleCell;
	protected HSSFCell periodCell;
	
	public void createHeaderStructure(HSSFSheet sheet) {

		CellStyle typeStyle = this.getWorkBook().createCellStyle();

		Font typeFont = getWorkBook().createFont();
		typeFont.setFontHeightInPoints((short) 24);
		typeStyle.setFont(typeFont);
		
		typeStyle.setBorderTop(CellStyle.BORDER_MEDIUM);
		typeStyle.setBorderBottom(CellStyle.BORDER_MEDIUM);
		typeStyle.setBorderLeft(CellStyle.BORDER_MEDIUM);
		typeStyle.setBorderRight(CellStyle.BORDER_MEDIUM);
		typeStyle.setAlignment(CellStyle.ALIGN_CENTER);
		
		
		HSSFRow typeRow = sheet.createRow(0);
		typeCell = typeRow.createCell(0);
		typeCell.setCellValue("<Service Type>");
		typeCell.setCellStyle(typeStyle);
		
		typeRow.createCell(1).setCellStyle(typeStyle);
		typeRow.createCell(2).setCellStyle(typeStyle);
		typeRow.createCell(3).setCellStyle(typeStyle);
		
		CellStyle titleStyle = this.getWorkBook().createCellStyle();

		Font titleFont = getWorkBook().createFont();
		titleFont.setFontHeightInPoints((short) 16);
		titleStyle.setFont(titleFont);
		
		titleStyle.setBorderTop(CellStyle.BORDER_MEDIUM);
		titleStyle.setBorderBottom(CellStyle.BORDER_MEDIUM);
		titleStyle.setBorderLeft(CellStyle.BORDER_MEDIUM);
		titleStyle.setBorderRight(CellStyle.BORDER_MEDIUM);
		titleStyle.setAlignment(CellStyle.ALIGN_CENTER);
		
		HSSFRow titleRow = sheet.createRow(1);
		titleCell = titleRow.createCell(0);
		titleCell.setCellValue("<Report title>");
		titleCell.setCellStyle(titleStyle);
		
		titleRow.createCell(1).setCellStyle(typeStyle);
		titleRow.createCell(2).setCellStyle(typeStyle);
		titleRow.createCell(3).setCellStyle(typeStyle);

		HSSFRow periodRow = sheet.createRow(2);
		periodCell = periodRow.createCell(0);
		periodCell.setCellValue("<Period>");
		periodCell.setCellStyle(titleStyle);

		
		periodRow.createCell(1).setCellStyle(typeStyle);
		periodRow.createCell(2).setCellStyle(typeStyle);
		periodRow.createCell(3).setCellStyle(typeStyle);
		
		// Merge
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 3));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 3));

	}

}
