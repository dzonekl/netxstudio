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
package com.netxforge.netxstudio.server.dataimport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.data.internal.DataActivator;

/**
 * Imports metrics and units from an excel sheet.
 * 
 * @author Martin Taal
 */
public class MasterDataImporter {

	@Inject
	private IDataService dataService;

	private List<EStructuralFeature> eFeatures = new ArrayList<EStructuralFeature>();

	private EClass eClassToImport;

	public MasterDataImporter() {
		DataActivator.getInjector().injectMembers(this);
	}

	public void process(HSSFWorkbook workBook) {
		dataService.getProvider().openSession("test", "test");
		try {
			final List<EObject> result = new ArrayList<EObject>();
			for (int i = 0; i < workBook.getNumberOfSheets(); i++) {
				result.addAll(processWorkSheet(workBook.getSheetAt(i)));
			}

			final Resource resource = dataService.getProvider().getResource(
					eClassToImport.getClassifierID());
			resource.getContents().clear();
			resource.getContents().addAll(result);
			resource.save(Collections.emptyMap());
		} catch (final Exception e) {
			throw new IllegalStateException(e);
		} finally {
			dataService.getProvider().getSession().close();
		}
	}

	private List<EObject> processWorkSheet(HSSFSheet sheet) {
		final List<EObject> result = new ArrayList<EObject>();
		setEFeatures(sheet);
		for (int i = 2; i <= sheet.getLastRowNum(); i++) {
			final EObject eObject = processRow(sheet.getRow(i));
			if (eObject != null) {
				result.add(eObject);
			}
		}
		return result;
	}

	private void setEFeatures(HSSFSheet sheet) {
		eFeatures.clear();
		final Iterator<Cell> iterator = sheet.getRow(0).cellIterator();
		while (iterator.hasNext()) {
			final String name = iterator.next().getStringCellValue();
			for (final EStructuralFeature eFeature : eClassToImport
					.getEAllStructuralFeatures()) {
				if (name.toLowerCase().equals(eFeature.getName().toLowerCase())) {
					eFeatures.add(eFeature);
					break;
				}
			}
		}
	}

	private EObject processRow(HSSFRow row) {
		if (row == null) {
			return null;
		}
		final EObject result = EcoreUtil.create(eClassToImport);
		for (int i = 0; i < eFeatures.size(); i++) {
			if (row.getCell(i) == null) {
				continue;
			}
			final String value = row.getCell(i).getStringCellValue();
			final int maxLength = ExtendedMetaData.INSTANCE.getMaxLengthFacet(((EAttribute)eFeatures.get(i)).getEAttributeType());
			if (maxLength > 0 && value != null && value.length() > maxLength) {
				result.eSet(eFeatures.get(i), value.substring(0, maxLength));
			} else {
				result.eSet(eFeatures.get(i), value);
			}
		}
		return result;
	}

	public EClass getEClassToImport() {
		return eClassToImport;
	}

	public void setEClassToImport(EClass eClassToImport) {
		this.eClassToImport = eClassToImport;
	}

}
