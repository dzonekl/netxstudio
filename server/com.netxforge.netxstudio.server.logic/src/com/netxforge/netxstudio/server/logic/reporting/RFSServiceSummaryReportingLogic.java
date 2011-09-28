package com.netxforge.netxstudio.server.logic.reporting;

import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;

import com.netxforge.netxstudio.common.model.OperatorSummary;
import com.netxforge.netxstudio.common.model.RFSServiceSummary;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.scheduling.ComponentWorkFlowRun;
import com.netxforge.netxstudio.scheduling.Failure;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServiceUser;

public class RFSServiceSummaryReportingLogic extends OperatorReportingLogic {

	private static final int CONTENT_ROW = 7;
	private static final int HEADER_ROW = 8;
	private static final int SERVICES_ROW = 9;
	private static final int NODES_ROW = 10;
	private static final int RESOURCES_ROW = 11;
	private OperatorSummary opSummary = new OperatorSummary();

	@Override
	protected void writeHeader(HSSFSheet sheet, DateTimeRange dtr) {
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

	@Override
	protected void writeContent(HSSFSheet sheet, NodeType nodeType) {
	}

	@Override
	protected void writeContent(HSSFSheet sheet, Service service, Node node,
			int index, int nodeTypeCount) {
	}

	protected void doRun() {

		// start a transaction
		this.getDataProvider().getTransaction();

		final List<Service> allServices = this.getServicesToExecuteFor();
		// final List<NodeType> allNodes = getNodeTypesToExecuteFor();

		getJobMonitor().setTotalWork(allServices.size());
		getJobMonitor().setTask("Performing reporting");

		// EXCEL WRITE
		setWorkBook(new HSSFWorkbook());
		HSSFSheet sheet = this.getSheet("Summary");
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

		if (!getFailures().isEmpty()) {
			final ComponentWorkFlowRun run = (ComponentWorkFlowRun) this
					.getDataProvider().getTransaction()
					.getObject(this.getJobMonitor().getWorkFlowRunId());

			for (Failure f : this.getFailures()) {
				run.getFailureRefs().add(f);
			}
		}

		try {
			this.getWorkBook().write(this.getStream());
		} catch (IOException e) {
			e.printStackTrace();
			// TODO, Perhaps add another failure?
		}

		// dataProvider.commitTransaction();
	}

	private void writeSummary(HSSFSheet sheet) {

		// Title
		HSSFRow summaryRow = sheet.createRow(CONTENT_ROW);
		HSSFCell summaryCell = summaryRow.createCell(2);
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

		HSSFRow headerRow = sheet.createRow(HEADER_ROW);
		{
			HSSFCell c1 = headerRow.createCell(4);
			c1.setCellValue("Quantity");
			c1.setCellStyle(borderStyle);
		}

		{
			HSSFCell c1 = headerRow.createCell(5);
			c1.setCellValue("RED");
			c1.setCellStyle(borderStyle);
		}

		{
			HSSFCell c1 = headerRow.createCell(6);
			c1.setCellValue("AMBER");
			c1.setCellStyle(borderStyle);
		}

		{
			HSSFCell c1 = headerRow.createCell(7);
			c1.setCellValue("GREEN");
			c1.setCellStyle(borderStyle);
		}

		writeServicesSummary(sheet, borderStyle);
		writeNodesSummary(sheet, borderStyle);
		writeResourcesSummary(sheet, borderStyle);

	}

	private void writeServicesSummary(HSSFSheet sheet, CellStyle borderStyle) {
		HSSFRow servicesRow = sheet.createRow(SERVICES_ROW);

		{
			HSSFCell c1 = servicesRow.createCell(2);
			c1.setCellValue("#Services");

		}
		{ // QUANTITY
			HSSFCell c1 = servicesRow.createCell(4);
			c1.setCellStyle(borderStyle);
			c1.setCellValue(opSummary.totalServices());
			this.getServices().size();
		}

		{ // RED
			HSSFCell c1 = servicesRow.createCell(5);
			c1.setCellStyle(borderStyle);
			c1.setCellValue(opSummary.totalRedServices());
		}

		{ // AMBER
			HSSFCell c1 = servicesRow.createCell(6);
			c1.setCellStyle(borderStyle);
			c1.setCellValue(opSummary.totalAmberServices());
		}

		{ // GREEN
			HSSFCell c1 = servicesRow.createCell(7);
			c1.setCellStyle(borderStyle);
			c1.setCellValue(opSummary.totalGreenServices());
		}
	}

	private void writeNodesSummary(HSSFSheet sheet, CellStyle borderStyle) {
		HSSFRow nodesRow = sheet.createRow(NODES_ROW);

		{
			HSSFCell c1 = nodesRow.createCell(2);
			c1.setCellValue("#Nodes");
		}
		{
			HSSFCell c1 = nodesRow.createCell(4);
			c1.setCellStyle(borderStyle);
			c1.setCellValue(opSummary.totalNodes());
		}

		{
			HSSFCell c1 = nodesRow.createCell(5);
			c1.setCellStyle(borderStyle);
			c1.setCellValue(opSummary.totalRedNodes());
		}

		{
			HSSFCell c1 = nodesRow.createCell(6);
			c1.setCellStyle(borderStyle);
			c1.setCellValue(opSummary.totalAmberNodes());
		}

		{
			HSSFCell c1 = nodesRow.createCell(7);
			c1.setCellStyle(borderStyle);
			c1.setCellValue(opSummary.totalGreenNodes());
		}
	}

	private void writeResourcesSummary(HSSFSheet sheet, CellStyle borderStyle) {
		HSSFRow resourcesRow = sheet.createRow(RESOURCES_ROW);

		{
			HSSFCell c1 = resourcesRow.createCell(2);
			c1.setCellValue("#Resources");
		}
		{
			HSSFCell c1 = resourcesRow.createCell(4);
			c1.setCellStyle(borderStyle);
			c1.setCellValue(opSummary.totalResources());
		}

		{
			HSSFCell c1 = resourcesRow.createCell(5);
			c1.setCellStyle(borderStyle);
			c1.setCellValue(opSummary.totalRedResources());
		}

		{
			HSSFCell c1 = resourcesRow.createCell(6);
			c1.setCellStyle(borderStyle);
			c1.setCellValue(opSummary.totalAmberResources());
		}

		{
			HSSFCell c1 = resourcesRow.createCell(7);
			c1.setCellStyle(borderStyle);
			c1.setCellValue(opSummary.totalGreenResources());
		}
	}

	@Override
	protected void writeContent(HSSFSheet sheet, Service service,
			ServiceUser serviceUser, int rowIndex, int columnIndex) {
	}

	@Override
	protected void writeContent(HSSFSheet sheet, Component component) {
	}

	private RFSServiceSummary processService(Service service) {
		// Build a service summary, to be passed to the engine.
		RFSServiceSummary serviceSummary = this.getModelUtils()
				.serviceSummaryForService(service, this.getPeriod());

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

	@Override
	protected void processServiceUser(Service service, HSSFSheet sheet) {
	}

}
