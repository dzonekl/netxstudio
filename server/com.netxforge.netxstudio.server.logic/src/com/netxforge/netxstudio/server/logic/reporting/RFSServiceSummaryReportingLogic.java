package com.netxforge.netxstudio.server.logic.reporting;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.netxforge.netxstudio.common.model.OperatorSummary;
import com.netxforge.netxstudio.common.model.RFSServiceSummary;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;

public class RFSServiceSummaryReportingLogic extends OperatorReportingLogic {

	private static final int CONTENT_ROW = 7;
	private static final int HEADER_ROW = 8;
	private static final int SERVICES_ROW = 9;
	private static final int NODES_ROW = 10;
	private static final int RESOURCES_ROW = 11;
	private OperatorSummary opSummary = new OperatorSummary();

	@Override
	protected void writeHeader(Sheet sheet, DateTimeRange dtr) {
		super.createHeaderStructure(sheet);

		super.typeCell.setCellValue("Service Monitoring");
		super.titleCell.setCellValue("Management Sheet");

		if (dtr != null) {
			super.periodCell.setCellValue(this.getModelUtils().date(
					getModelUtils().fromXMLDate(dtr.getBegin()))
					+ "-"
					+ this.getModelUtils().date(
							getModelUtils().fromXMLDate(dtr.getEnd())));
		}
	}

	protected String calculateFileName() {
		String baseName = super.calculateFileName();
		return REPORT_PREFIX + "_" + REPORT_PREFIX_SM_EXEC + "_" + baseName;
	}

	protected void doRun() {

		// start a transaction
		this.getDataProvider().getTransaction();

		final List<Service> allServices = this.getServicesToExecuteFor();
		// final List<NodeType> allNodes = getNodeTypesToExecuteFor();

		getJobMonitor().setTotalWork(allServices.size());
		getJobMonitor().setTask("Performing reporting");

		// EXCEL WRITE
		setWorkBook(new XSSFWorkbook());
		Sheet sheet = this.getSheet("Summary");
		this.writeHeader(sheet, this.getPeriod());

		// Execute the tolerance expressions, which returns a summary for each
		// service.
		// The summary
		for (Service service : allServices) {
			if (service instanceof RFSService) {
				RFSServiceSummary summary = this.processService(service);
				opSummary.addSummary(summary);
			}
		}

		writeSummary(sheet);

		this.getJobMonitor().updateFailures(this.getFailures());

		try {
			this.getWorkBook().write(this.getStream());
		} catch (IOException e) {
			e.printStackTrace();
			// TODO, Perhaps add another failure?
		}

		 this.getDataProvider().commitTransaction();
		 this.getDataProvider().closeSession();
	}

	private void writeSummary(Sheet sheet) {

		// Title
		Row summaryRow = sheet.createRow(CONTENT_ROW);
		Cell summaryCell = summaryRow.createCell(2);
		summaryCell.setCellValue("Executive Summary");
		sheet.addMergedRegion(new CellRangeAddress(CONTENT_ROW, CONTENT_ROW, 2,
				4));

		// Table
		CellStyle borderStyle = this.getWorkBook().createCellStyle();
		borderStyle.setBorderTop(CellStyle.BORDER_THIN);
		borderStyle.setBorderBottom(CellStyle.BORDER_THIN);
		borderStyle.setBorderLeft(CellStyle.BORDER_THIN);
		borderStyle.setBorderRight(CellStyle.BORDER_THIN);
		borderStyle.setAlignment(CellStyle.ALIGN_CENTER);
		borderStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

		Row headerRow = sheet.createRow(HEADER_ROW);
		{
			Cell c1 = headerRow.createCell(4);
			c1.setCellValue("Quantity");
			c1.setCellStyle(borderStyle);
		}

		{
			Cell c1 = headerRow.createCell(5);
			c1.setCellValue("RED");
			c1.setCellStyle(borderStyle);
		}

		{
			Cell c1 = headerRow.createCell(6);
			c1.setCellValue("AMBER");
			c1.setCellStyle(borderStyle);
		}

		{
			Cell c1 = headerRow.createCell(7);
			c1.setCellValue("GREEN");
			c1.setCellStyle(borderStyle);
		}

		writeServicesSummary(sheet, borderStyle);
		writeNodesSummary(sheet, borderStyle);
		writeResourcesSummary(sheet, borderStyle);

	}

	private void writeServicesSummary(Sheet sheet, CellStyle borderStyle) {
		Row servicesRow = sheet.createRow(SERVICES_ROW);

		{
			Cell c1 = servicesRow.createCell(2);
			c1.setCellValue("#Services");

		}
		{ // QUANTITY
			Cell c1 = servicesRow.createCell(4);
			c1.setCellStyle(borderStyle);
			c1.setCellValue(opSummary.totalServices());
			this.getServices().size();
		}

		{ // RED
			Cell c1 = servicesRow.createCell(5);
			c1.setCellStyle(borderStyle);
			c1.setCellValue(opSummary.totalRedServices());
		}

		{ // AMBER
			Cell c1 = servicesRow.createCell(6);
			c1.setCellStyle(borderStyle);
			c1.setCellValue(opSummary.totalAmberServices());
		}

		{ // GREEN
			Cell c1 = servicesRow.createCell(7);
			c1.setCellStyle(borderStyle);
			c1.setCellValue(opSummary.totalGreenServices());
		}
	}

	private void writeNodesSummary(Sheet sheet, CellStyle borderStyle) {
		Row nodesRow = sheet.createRow(NODES_ROW);

		{
			Cell c1 = nodesRow.createCell(2);
			c1.setCellValue("#Nodes");
		}
		{
			Cell c1 = nodesRow.createCell(4);
			c1.setCellStyle(borderStyle);
			c1.setCellValue(opSummary.totalNodes());
		}

		{
			Cell c1 = nodesRow.createCell(5);
			c1.setCellStyle(borderStyle);
			c1.setCellValue(opSummary.totalRedNodes());
		}

		{
			Cell c1 = nodesRow.createCell(6);
			c1.setCellStyle(borderStyle);
			c1.setCellValue(opSummary.totalAmberNodes());
		}

		{
			Cell c1 = nodesRow.createCell(7);
			c1.setCellStyle(borderStyle);
			c1.setCellValue(opSummary.totalGreenNodes());
		}
	}

	private void writeResourcesSummary(Sheet sheet, CellStyle borderStyle) {
		Row resourcesRow = sheet.createRow(RESOURCES_ROW);

		{
			Cell c1 = resourcesRow.createCell(2);
			c1.setCellValue("#Resources");
		}
		{
			Cell c1 = resourcesRow.createCell(4);
			c1.setCellStyle(borderStyle);
			c1.setCellValue(opSummary.totalResources());
		}

		{
			Cell c1 = resourcesRow.createCell(5);
			c1.setCellStyle(borderStyle);
			c1.setCellValue(opSummary.totalRedResources());
		}

		{
			Cell c1 = resourcesRow.createCell(6);
			c1.setCellStyle(borderStyle);
			c1.setCellValue(opSummary.totalAmberResources());
		}

		{
			Cell c1 = resourcesRow.createCell(7);
			c1.setCellStyle(borderStyle);
			c1.setCellValue(opSummary.totalGreenResources());
		}
	}

	private RFSServiceSummary processService(Service service) {
		// Build a service summary, to be passed to the engine.
		RFSServiceSummary serviceSummary = this.getModelUtils()
				.serviceSummaryForService(service, this.getPeriod(), null);

		final ReportingEngine engine = (ReportingEngine) getEngine();
		engine.setService(service);
		engine.setServiceSummary(serviceSummary);
		engine.setJobMonitor(getJobMonitor());
		engine.setDataProvider(this.getDataProvider());
		engine.setPeriod(getPeriod());
		engine.execute();
		if (engine.getFailures().size() > 0) {
			// Don't add anmy
			this.getFailures().addAll(engine.getFailures());
		}
		return serviceSummary;
	}

}
