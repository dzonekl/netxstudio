package com.netxforge.netxstudio.emf.poi;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.Library;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;

public class PoiEmmitter {
	protected OutputStream stream;
	protected Workbook wb;

	PoiEmmitterService pe = PoiEmmitterService.INSTANCE;

	public PoiEmmitter(OutputStream stream) {
		this.stream = stream;
	}

	// Raw emmitter, creates a tree and emmits all.
	public void go(Library lib, Operator op) {
		// We don't deal with a resource, so we need a session.

		wb = pe.createWorkbook();
		CellStyle h1 = pe.h1(wb);
		CellStyle h2 = pe.h2(wb);
		CellStyle d = pe.d(wb);

		for (Function f : lib.getFunctions()) {
			Sheet sh = pe.createSheet(wb, f.getFunctionName());
			for (Network n : op.getNetworks()) {
				for (Node node : n.getNodes()) {
					if (node.getNodeType().get(0).getFunctions().size() > 0
							&& node.getNodeType().get(0).getFunctions().get(0).getFunctionName()
									.equals(f.getFunctionName())) {
						pe.writeRow(sh, node, 1, h1);
						TreeIterator<EObject> it = node.eAllContents();
						while (it.hasNext()) {
							EObject next = it.next();

							{ // METRIC OUTPUT.
								EList<Metric> metrics = null;
								EList<NetXResource> resources = null;

								if (next instanceof Function) {
									// CONDITIONAL WRITING OF THE FUNCTION NAME.
									Function nodeF = (Function) next;
									pe.writeRow(sh, next, 2, h2);
									metrics = (nodeF).getFunctionMetricRefs();
									resources = (nodeF).getFunctionResources();
								}
								if (next instanceof Equipment) {
									pe.writeRow(sh, next, 2, h2);
									Equipment e = (Equipment) next;
									metrics = e.getEquipmentMetricRefs();
									resources = e.getEquipmentResources();
								}

								if (metrics != null)
									for (Metric metric : metrics) {
										pe.writeRow(sh, metric, 3);
									}
								if (resources != null)
									for (NetXResource res : resources) {

										pe.writeRow(sh, res, 3);
										{
											Row r = pe.writeEmptyRow(sh);
											for (Value v : res
													.getMetricValueRanges().get(0).getMetricValues()) {
												Date date = v.getTimeStamp().toGregorianCalendar().getTime();
												pe.writeCell(r, date, d);
											}
										}

										// TODO, apply the range on the values.
										{
											Row r = pe.writeRow(sh, "Value", 4);
											for (Value v : res
													.getMetricValueRanges().get(0).getMetricValues()) {
												pe.writeCell(r, v.getValue());
											}
										}

										{
											Row r = pe.writeRow(sh, "Capacity",
													4);
											for (Value v : res
													.getCapacityValues()) {
												pe.writeCell(r, v);
											}
										}

										pe.writeRow(sh, "Utilization", 4);
										// TODO write a formula.
										// for(Value v : res.getMetricValues()){
										// pe.writeCell(r, v);
										// }
									}
							}

						}
					}
				}
			}
		}
	}

	public void save() {
		if (stream != null)
			try {
				wb.write(stream);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}
