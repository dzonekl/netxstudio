package com.netxforge.netxstudio.emf.poi.ui;

import java.util.List;

import com.netxforge.netxstudio.emf.poi.PoiMappingService.MappingStat;
import com.netxforge.netxstudio.emf.poi.Tuple;
import com.netxforge.netxstudio.generics.Value;

public class PoiUI {

	public static PoiUI INSTANCE = new PoiUI();

	public PoiUI() {
	}

	/**
	 * Dump the currentRecords and statistics.
	 */
	public void printResult(MappingStat currentStatistics,
			List<Tuple> currentRecordMap) {

		System.out.println("Total Records:" //$NON-NLS-1$
				+ currentStatistics.getTotalRecords());
		for (MappingStat.MappingTuple tuple : currentStatistics
				.getFailedRecordsList()) {
			System.out.println("row: " + tuple.getRow() + ", column: " //$NON-NLS-1$ //$NON-NLS-2$
					+ tuple.getColumn());
		}

		for (Tuple tuple : currentRecordMap) {

			Object key = tuple.getKey();
			if (key instanceof List) {
				List ids = (List) key;
				// print, multiple ID's.
				for (Object object : ids) {
					if (object instanceof Tuple) {
						Tuple idTuple = (Tuple) object;
						System.out.print("ID Key:" //$NON-NLS-1$
								+ idTuple.getKey().toString() + " ID Value: " //$NON-NLS-1$
								+ idTuple.getValue());
					}
				}
			}
			Object value = tuple.getValue();
			if (value instanceof Tuple) {
				String valueKey = (String) ((Tuple) value).getKey();
				Value v = (Value) ((Tuple) value).getValue();
				System.out.println(" Metric (" + valueKey + ") value:" //$NON-NLS-1$ //$NON-NLS-2$
						+ v.getValue() + " at: " + v.getTimeStamp().toString()); //$NON-NLS-1$
			}
		}
	}

}
