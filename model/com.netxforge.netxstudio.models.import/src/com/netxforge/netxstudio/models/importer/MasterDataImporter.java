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
package com.netxforge.netxstudio.models.importer;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.NodeType;

/**
 * Imports metrics and units from an excel sheet.
 * 
 * @author Martin Taal
 * @author Christophe Bouhier
 */
public class MasterDataImporter {

	private IDataProvider dataProvider;

	private EClass eClassToImport;

	private List<EObject> cachedObjects = new ArrayList<EObject>();
	private List<EObject> structuredResult = new ArrayList<EObject>();

	private List<String> unresolvedReferences = new ArrayList<String>();

	private EPackage[] ePackagesToImport;

	public void process(InputStream is) {
		HSSFWorkbook workBook;
		try {
			workBook = new HSSFWorkbook(is);
			for (int i = 0; i < workBook.getNumberOfSheets(); i++) {

				ProcessWorkSheet pw = new ProcessWorkSheet(i,
						workBook.getSheetAt(i));
				List<RowResult> sheetResult = pw.getResult();
				if (!pw.isMultiRefSheet()) {
					for (final RowResult rowResult : sheetResult) {

						EObject copyFromCache = EcoreUtil.copy(rowResult
								.getEObject());
						structuredResult.add(copyFromCache);
					}
				}
			}

		} catch (final Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public List<EObject> getResolvedObjects() {
		return structuredResult;
	}

	class ProcessWorkSheet {

		private List<EStructuralFeature> eFeatures = new ArrayList<EStructuralFeature>();

		final List<RowResult> sheetRowResults = new ArrayList<RowResult>();
		private boolean isMultiRefSheet = false;

		List<RowResult> getResult() {
			return sheetRowResults;
		}

		boolean isMultiRefSheet() {
			return isMultiRefSheet;
		}

		/**
		 * Process an .xls worksheet, each worksheet should match an EClass or
		 * an EClass multiplicity references. For each row an object, with the
		 * matching EClass is created or looked up. EAttributes are set
		 * immidiatly, while for EReferences, row results, which are later used
		 * are produced to be further processed later on (Resolving the
		 * EReferences).
		 * 
		 * @param index
		 * @param sheet
		 * @return
		 */
		ProcessWorkSheet(int index, HSSFSheet sheet) {

			System.err.println("processing sheet: " + sheet.getSheetName());

			// Match the features of this sheet.
			isMultiRefSheet = setEFeatures(sheet);

			// Keep track of the last resolved object for multiref sheets.
			EObject lastRootObject = null;

			// process non-empty rows, starting from 3nd row.
			for (int i = 2; i <= sheet.getLastRowNum(); i++) {
				if (isEmptyRow(sheet.getRow(i))) {
					continue;
				}
				EObject eObject;
				if (!isMultiRefSheet) {
					eObject = processRow(sheet.getRow(i));
					if (eObject != null) {
						// result.add(eObject);
						cachedObjects.add(eObject);
						final RowResult rowResult = new RowResult();
						rowResult.setRow(sheet.getRow(i));
						rowResult.setEObject(eObject);
						sheetRowResults.add(rowResult);
						eObject = processEReferences(rowResult.getEObject(),
								rowResult.getRow());
					}
				} else {
					eObject = processMultiRefRow(lastRootObject,
							sheet.getRow(i));
					if (eObject != null) {
						final RowResult rowResult = new RowResult();
						rowResult.setRow(sheet.getRow(i));
						rowResult.setEObject(eObject);
						sheetRowResults.add(rowResult);
						eObject = processEReferences(rowResult.getEObject(),
								rowResult.getRow());
					}
				}
				if (eObject.eContainer() == null) {
					lastRootObject = eObject;
					System.out.println("Setting last root object: "
							+ printObject(lastRootObject));
				}

			}
		}

		/**
		 * Loop through the features of the target packages. Match the cell with
		 * the EStructuralFeature name.
		 * 
		 * @param sheet
		 */
		private boolean setEFeatures(HSSFSheet sheet) {
			eFeatures.clear();

			boolean isMultiRefSheet = matchEClassFromSheetName(sheet);

			if (eClassToImport == null) {
				return false; // We need an EClass.
			}
			final Iterator<Cell> iterator = sheet.getRow(0).cellIterator();
			while (iterator.hasNext()) {

				Cell c = iterator.next();
				if (isMultiRefSheet && c.getColumnIndex() == 0) {
					// skip the first column
					continue;
				}

				final String name = c.getStringCellValue();
				for (final EStructuralFeature eFeature : eClassToImport
						.getEAllStructuralFeatures()) {
					if (name.toLowerCase().equals(
							eFeature.getName().toLowerCase())) {
						eFeatures.add(eFeature);
						break;
					}
				}
			}
			return isMultiRefSheet;
		}

		/**
		 * Create an object for each non-empty row, then
		 * 
		 * @param row
		 * @return
		 */
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
				if (maxLength > 0 && value != null
						&& value.length() > maxLength) {
					result.eSet(eFeature, value.substring(0, maxLength));
				} else {
					result.eSet(eFeature, value);
				}
			}
			return result;
		}

		/**
		 * 
		 * @param row
		 * @return
		 */
		private EObject processMultiRefRow(EObject parent, HSSFRow row) {
			if (row == null) {
				return null;
			}
			if (isEmptyRow(row)) {
				return null;
			}

			// The identifier is the first column for a MultiRef row.
			String identifier = row.getCell(0).getStringCellValue();
			System.out.println("Resolving object: ");
			final EObject result = getResultObject(parent, eClassToImport,
					identifier);

			return result;

		}

		private EObject processEReferences(EObject target, HSSFRow row) {
			for (int i = 0; i < eFeatures.size(); i++) {
				final EStructuralFeature eFeature = eFeatures.get(i);
				if (row.getCell(i + 1) == null) {
					continue;
				}
				if (eFeature instanceof EAttribute) {
					continue;
				}

				// Skip the first column.
				final String value = row.getCell(i + 1).getStringCellValue();
				if (value == null || value.trim().length() == 0) {
					continue;
				}
				final EReference eReference = (EReference) eFeature;

				System.out.println("Resolving reference: ");
				// Get the referenced object from the cache.
				EObject objectToSet = getResultObject(null,
						eReference.getEReferenceType(), value);

				if (objectToSet != null) {

					if (eReference.isMany()) {
						// Process many values
						EClassifier eType = eReference.getEType();
						if (eType.eClass().equals(objectToSet.eClass())) {
							System.out
									.println("Reference to be set matching type: "
											+ eType);
						} else {
						}

						@SuppressWarnings("unchecked")
						EList<EObject> manyReference = (EList<EObject>) target
								.eGet(eReference);
						Collection<EObject> copyAll = EcoreUtil
								.copyAll(manyReference);

						if (eReference.isContainment()) {
							EObject copyOfObjectToSet = EcoreUtil
									.copy(objectToSet);
							System.out.println(" Setting containment: "
									+ printObject(copyOfObjectToSet)
									+ " with eRef: " + eReference.getName()
									+ " , on object:" + printObject(target));

							// Find the object to set from the result set and
							// remove
							// it.
							int index = structuredResult.indexOf(objectToSet);
							if (index != -1) {
								System.out
										.println(" Removing from result set: "
												+ printObject(objectToSet));
								structuredResult.remove(index);
							}
							copyAll.add(copyOfObjectToSet);
						} else {
							System.out.println(" Setting non containment: "
									+ printObject(objectToSet) + " with eRef: "
									+ eReference.getName() + " , on object:"
									+ printObject(target));
							copyAll.add(objectToSet);
						}
						target.eSet(eReference, copyAll);

					} else {
						target.eSet(eFeature, objectToSet);
					}
				} else {
					System.err.println("Could not resolve " + value
							+ "from reference" + eReference);
				}
			}
			return target;
		}

	}

	private boolean matchEClassFromSheetName(HSSFSheet sheet) {

		for (int i = 0; i < this.ePackagesToImport.length; i++) {
			EPackage ePackage = ePackagesToImport[i];
			for (EClassifier classifier : ePackage.getEClassifiers()) {
				if (classifier instanceof EClass) {
					String cName = ((EClass) classifier).getName();
					if (cName.equals(sheet.getSheetName())) {
						eClassToImport = (EClass) classifier;
					}
					cName = cName + "_refs";
					if (cName.equals(sheet.getSheetName())) {
						eClassToImport = (EClass) classifier;
						return true;
					}
				}
			}
		}
		return false;
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

	public void setEPackagesToImport(EPackage... ePackagesToImport) {
		this.ePackagesToImport = ePackagesToImport;
	}

	public IDataProvider getDataProvider() {
		return dataProvider;
	}

	public void setDataProvider(IDataProvider dataProvider) {
		this.dataProvider = dataProvider;
	}

	/**
	 * Should find an object within this hierarchy root, if not produce a new
	 * node from the cache, the eContainer of the root should not be set,
	 * otherwise we would be fishing on a branch.
	 * 
	 * @param root
	 * @param eClass
	 * @param identifier
	 * @return
	 */
	private EObject getResultObject(EObject root, EClass eClass,
			String identifier) {

		EObject result = null;

		if (root != null && root.eContainer() == null) {
			Iterator<EObject> it = null;
			String rootString = root != null ? printObject(root) : "no-root";
			System.out.println(" Looking for object: " + identifier
					+ " in root: " + rootString);
			// Is it a child in the result set?
			it = root.eAllContents();
			while (it.hasNext()) {
				final EObject eObject = it.next();
				if (eObject.eClass() == eClass) {
					for (final EAttribute eAttribute : eObject.eClass()
							.getEAllAttributes()) {
						final Object value = eObject.eGet(eAttribute);
						if (value instanceof String
								&& ((String) value)
										.compareToIgnoreCase(identifier) == 0) {
							result = eObject;
							System.out.println("  Found object for : "
									+ identifier + " object: "
									+ printObject(eObject));
							return result;
						}
					}
				}
			}
		}
		System.out.println(" Looking for object: " + identifier
				+ " in complete result set: ");
		// If we don't have a root object, we look in the full result set
		// for the occurence.
		Iterator<EObject> it = null;
		it = this.structuredResult.iterator();
		while (it.hasNext()) {
			final EObject eObject = it.next();
			if (eObject.eClass() == eClass) {
				for (final EAttribute eAttribute : eObject.eClass()
						.getEAllAttributes()) {
					final Object value = eObject.eGet(eAttribute);
					if (value instanceof String
							&& ((String) value).compareToIgnoreCase(identifier) == 0) {
						result = eObject;
						System.out.println("  Found object for : " + identifier
								+ " object: " + printObject(eObject));
						return result;
					}
				}
			}
		}

		System.out
				.println(" No object can be found in the result set, get a copy from cache: "
						+ identifier + " with class: " + eClass.getName());

		// It's not in our structure, so get a copy of the cached version.
		for (final EObject eObject : cachedObjects) {
			if (eObject.eClass() == eClass) {
				for (final EAttribute eAttribute : eObject.eClass()
						.getEAllAttributes()) {
					final Object value = eObject.eGet(eAttribute);
					if (value instanceof String
							&& ((String) value).compareToIgnoreCase(identifier) == 0) {
						System.out.println("  Copy object for : " + identifier
								+ " object: " + printObject(eObject));
						result = EcoreUtil.copy(eObject);
						break;
					}
				}
			}
		}

		 unresolvedReferences.add(eClass.getName() + " using " + identifier);
		 
		return result;
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

	private void printResultSet(List<EObject> set) {
		for (EObject o : set) {
			printObject(o);
		}
	}

	private String printObject(EObject o) {
		String result = "";
		if (o instanceof Equipment) {
			result = ((Equipment) o).getEquipmentCode();

		}
		if (o instanceof Function) {
			result = ((Function) o).getName();
		}
		if (o instanceof NodeType) {
			NodeType nt = (NodeType) o;
			result = nt.getName() + "{" + nt.getFunctions().size() + "} " + "{"
					+ nt.getEquipments().size() + "} ";
		}
		return result;
	}

}
