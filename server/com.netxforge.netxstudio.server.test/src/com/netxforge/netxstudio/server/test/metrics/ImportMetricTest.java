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
 * Contributors: 
 * 	Martin Taal - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.server.test.metrics;

import java.io.InputStream;

import junit.framework.TestCase;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.server.dataimport.MasterDataImporter;

/**
 * Tests the import of metrics.
 * 
 * @author Martin Taal
 */
public class ImportMetricTest extends TestCase {
	public void testImportMetrics() throws Exception {
		final InputStream is = this.getClass().getResourceAsStream("data/metrics16052011.xls");
		final MasterDataImporter masterDataImporter = new MasterDataImporter();
		masterDataImporter.setEClassToImport(MetricsPackage.eINSTANCE.getMetric());
		masterDataImporter.process(new HSSFWorkbook(is));
	}
}
