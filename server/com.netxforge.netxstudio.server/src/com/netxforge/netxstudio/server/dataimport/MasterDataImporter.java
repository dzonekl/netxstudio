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
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

import com.netxforge.netxstudio.data.IDataProvider;

/**
 * Imports metrics and units from an excel sheet.
 * 
 * @author Martin Taal
 */
public class MasterDataImporter {

	private IDataProvider dataProvider;

	private List<EStructuralFeature> eFeatures = new ArrayList<EStructuralFeature>();

	private EClass eClassToImport;

	private List<EObject> objects = new ArrayList<EObject>();

	private List<RowResult> rowResults = new ArrayList<RowResult>();

	private List<String> unresolvedReferences = new ArrayList<String>();

	public void process(HSSFWorkbook workBook) {
		try {
			for (int i = 0; i < workBook.getNumberOfSheets(); i++) {
				processWorkSheet(i, workBook.getSheetAt(i));
			}

			for (final RowResult rowResult : rowResults) {
				processEReferences(rowResult.getEObject(), rowResult.getRow());
				final Resource resource = dataProvider.getResource(rowResult.getEObject().eClass());
				resource.getContents().add(rowResult.getEObject());
			}
		} catch (final Exception e) {
			throw new IllegalStateException(e);
		}
	}

	private List<EObject> processWorkSheet(int index, HSSFSheet sheet) {
		final List<EObject> result = new ArrayList<EObject>();
		setEFeatures(sheet);
		for (int i = 2; i <= sheet.getLastRowNum(); i++) {
			if (isEmptyRow(sheet.getRow(i))) {
				continue;
			}

			final EObject eObject = processRow(sheet.getRow(i));
			if (eObject != null) {
				result.add(eObject);
				objects.add(eObject);
				final RowResult rowResult = new RowResult();
				rowResult.setRow(sheet.getRow(i));
				rowResult.setEObject(eObject);
				rowResults.add(rowResult);
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
		if (isEmptyRow(row)) {
			return null;
		}
		
		final EObject result = EcoreUtil.create(eClassToImport);
		for (int i = 0; i < eFeatures.size(); i++) {
			final EStructuralFeature eFeature = eFeatures.get(i);
			if (row.getCell(i) == null) {
				continue;
			}
			if (eFeature instanceof EReference) {
				continue;
			}
			final String value = row.getCell(i).getStringCellValue();
			final int maxLength = ExtendedMetaData.INSTANCE
					.getMaxLengthFacet(((EAttribute) eFeature)
							.getEAttributeType());
			if (value == null || value.trim().length() == 0) {
				continue;
			}
			if (maxLength > 0 && value != null && value.length() > maxLength) {
				result.eSet(eFeature, value.substring(0, maxLength));
			} else {
				result.eSet(eFeature, value);
			}
		}
		return result;
	}

	private boolean isEmptyRow(HSSFRow row) {
		if (row == null) {
			return true;
		}
		final Iterator<Cell> cellIterator = row.cellIterator();
		while (cellIterator.hasNext()) {
			final Cell cell = cellIterator.next();
			final String value = cell.getStringCellValue();
			if (value != null && value.trim().length() > 0) {
				return false;
			}
		}
		return true;
	}
	
	private void processEReferences(EObject result, HSSFRow row) {
		for (int i = 0; i < eFeatures.size(); i++) {
			final EStructuralFeature eFeature = eFeatures.get(i);
			if (row.getCell(i) == null) {
				continue;
			}
			if (eFeature instanceof EAttribute) {
				continue;
			}
			final String value = row.getCell(i).getStringCellValue();
			if (value == null || value.trim().length() == 0) {
				continue;
			}
			final EReference eReference = (EReference) eFeature;
			result.eSet(eFeature, getObject(eReference, value));
		}
	}

	public EClass getEClassToImport() {
		return eClassToImport;
	}

	public void setEClassToImport(EClass eClassToImport) {
		this.eClassToImport = eClassToImport;
	}

	public IDataProvider getDataProvider() {
		return dataProvider;
	}

	public void setDataProvider(IDataProvider dataProvider) {
		this.dataProvider = dataProvider;
	}

	private EObject getObject(EReference eReference, String identifier) {
		final EClass expectedEClass = eReference.getEReferenceType();
		for (final EObject eObject : objects) {
			if (eObject.eClass() == expectedEClass) {
				for (final EAttribute eAttribute : eObject.eClass()
						.getEAllAttributes()) {
					final Object value = eObject.eGet(eAttribute);
					if (value instanceof String
							&& ((String) value).compareToIgnoreCase(identifier) == 0) {
						return eObject;
					}
				}
			}
		}

		// not found, maybe it can be found in an existing resource
		final Resource res = dataProvider.getResource(expectedEClass);
		for (final EObject eObject : res.getContents()) {
			if (eObject.eClass() == expectedEClass) {
				for (final EAttribute eAttribute : eObject.eClass()
						.getEAllAttributes()) {
					final Object value = eObject.eGet(eAttribute);
					if (value instanceof String
							&& ((String) value).compareToIgnoreCase(identifier) == 0) {
						return eObject;
					}
				}
			}
		}
		
		unresolvedReferences.add("From " + eReference.getName() + " --> "
				+ expectedEClass.getName() + " using " + identifier);
		return null;
	}

	private static class RowResult {
		private HSSFRow row;
		private EObject eObject;

		public HSSFRow getRow() {
			return row;
		}

		public void setRow(HSSFRow row) {
			this.row = row;
		}

		public EObject getEObject() {
			return eObject;
		}

		public void setEObject(EObject eObject) {
			this.eObject = eObject;
		}
	}
}
