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
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.metrics.DataKind;
import com.netxforge.netxstudio.metrics.IdentifierDataKind;
import com.netxforge.netxstudio.metrics.KindHintType;
import com.netxforge.netxstudio.metrics.Mapping;
import com.netxforge.netxstudio.metrics.MappingColumn;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.ObjectKindType;
import com.netxforge.netxstudio.metrics.ValueDataKind;
import com.netxforge.netxstudio.metrics.ValueKindType;
import com.netxforge.netxstudio.services.Service;

/**
 * @author Martin Taal
 * @author Christophe Bouhier
 */
public class MasterDataImporter {

	private IDataProvider dataProvider;

	private EClass eClassToImport;

	private Map<String, EObject> globalIndex = Maps.newHashMap();

	Resource resource = new ResourceSetImpl().createResource(URI
			.createURI("temp"));

	private List<String> unresolvedReferences = new ArrayList<String>();

	private EPackage[] ePackagesToImport;

	private boolean indexSupport;

	public boolean isIndexSupport() {
		return indexSupport;
	}

	public void setIndexSupport(boolean indexSupport) {
		this.indexSupport = indexSupport;
	}

	public void process(InputStream is) {
		HSSFWorkbook workBook;
		try {
			workBook = new HSSFWorkbook(is);

			// Multi pass the worksheets, do not add objects after the first
			// pass.
			// int passes = 2;

			// for (int k = 1; k <= passes; k++) {

			System.out.println("DATA IMPORTER:");

			for (int i = 0; i < workBook.getNumberOfSheets(); i++) {

				ProcessWorkSheet pw = new ProcessWorkSheet(i,
						workBook.getSheetAt(i));
				List<RowResult> sheetResult = pw.getSheetResult();
				if (!pw.isMultiRefSheet()) {
					for (final RowResult rowResult : sheetResult) {
						// EObject resultObject = EcoreUtil.copy(rowResult
						// .getEObject());

						// We only add object on the first pass
						globalIndex.put(rowResult.getIndex(),
								rowResult.getEObject());
						resource.getContents().add(rowResult.getEObject());

						// if (k == 1
						// && !globalIndex.containsKey(rowResult
						// .getIndex())) {
						// globalIndex.put(rowResult.getIndex(),
						// rowResult.getEObject());
						// resource.getContents().add(
						// rowResult.getEObject());
						// } else {
						//
						// }

					}
				}
			}

			printResult();
			// }
		} catch (final Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public List<EObject> getResolvedObjects() {
		return resource.getContents();
	}

	class ProcessWorkSheet {

		private List<EStructuralFeature> eFeatures = new ArrayList<EStructuralFeature>();

		final List<RowResult> sheetRowResults = new ArrayList<RowResult>();
		private boolean isMultiRefSheet = false;

		List<RowResult> getSheetResult() {
			return sheetRowResults;
		}

		boolean isMultiRefSheet() {
			return isMultiRefSheet;
		}

		/**
		 * Process an .xls worksheet, each worksheet should match an EClass or
		 * an EClass multiplicity references. From the EClass we generate the
		 * EFeatures (EAttribute and EReference) which should correspond to the
		 * columns of the sheet.
		 * 
		 * Next for each row an object, with the matching EClass is created or
		 * looked up. Single ref sheets are populated and cached, while for
		 * multi ref - sheets the object is looked EReferences).
		 * 
		 * @param index
		 * @param sheet
		 * @return
		 */
		ProcessWorkSheet(int index, HSSFSheet sheet) {

			System.err.println("SHEET: " + sheet.getSheetName());

			// Match the features of this sheet.
			if (!setEFeatures(sheet)) {
				System.err.println("SHEET ABORT " + sheet.getSheetName()
						+ " No Class found for the context Packages"
						+ ePackagesToImport);
				return;
			}

			// Keep track of the last resolved object for multiref sheets.
			EObject lastRootObject = null;

			// process non-empty rows, starting from 3nd row.
			for (int i = 2; i <= sheet.getLastRowNum(); i++) {
				HSSFRow row = sheet.getRow(i);
				if (isEmptyRow(row)) {
					continue;
				}
				EObject eObject;
				if (eClassToImport != null) {
					if (!isMultiRefSheet) {
						String objectIndex = null;
						if (indexSupport) {
							objectIndex = this.processIndex(row);
						} else {
							// An arbitrary number.
							objectIndex = new Long(System.nanoTime())
									.toString();
						}
						eObject = processAttributes(row);
						if (eObject != null) {

							// Create a Row result.
							final RowResult rowResult = new RowResult();
							rowResult.setRow(sheet.getRow(i));
							rowResult.setEObject(eObject);
							if (objectIndex != null) {
								rowResult.setIndex(objectIndex);
							}
							sheetRowResults.add(rowResult);

							if (featuresHaveReferences()) {
								eObject = processEReferences(false,
										rowResult.getEObject(),
										rowResult.getRow());
							}

						}
					} else {
						eObject = getMultiRefRowObject(lastRootObject, row);
						if (eObject != null) {
							eObject = processEReferences(true, eObject, row);
						}
					}
					if (eObject != null && eObject.eContainer() == null) {
						lastRootObject = eObject;
						System.out.println(" LAST ROOT: "
								+ printObject(lastRootObject));
					}
				}
			}
		}

		private boolean featuresHaveReferences() {
			boolean hasReference = false;
			for (EStructuralFeature f : eFeatures) {
				if (f instanceof EReference) {
					hasReference = true;
				}
			}
			return hasReference;
		}

		/**
		 * Loop through the features of the target packages. Match the cell with
		 * the EStructuralFeature name.
		 * 
		 * @param sheet
		 */
		private boolean setEFeatures(HSSFSheet sheet) {

			eFeatures.clear();
			isMultiRefSheet = setEClassFromSheetName(sheet);

			if (eClassToImport == null) {
				return false; // We need an EClass.
			}
			if (sheet.getRow(0) == null) {
				return false; // We need a first row.
			}

			// Process each column from row 0, and find the corresponding
			// feature.
			// When found.
			final Iterator<Cell> iterator = sheet.getRow(0).cellIterator();
			while (iterator.hasNext()) {

				Cell c = iterator.next();
				if (isMultiRefSheet && c.getColumnIndex() == 0) {
					// skip the first column
					continue;
				}

				int currentFeatureCount = eFeatures.size();
				final String name = c.getStringCellValue();
				for (final EStructuralFeature eFeature : eClassToImport
						.getEAllStructuralFeatures()) {
					if (name.toLowerCase().equals(
							eFeature.getName().toLowerCase())) {
						System.out.println("  FEATURE -> Add Feature="
								+ c.getColumnIndex() + ", Value=" + name);
						eFeatures.add(eFeature);
						break;
					} else {

					}
				}
				// We haven't added a feature.
				if (currentFeatureCount == eFeatures.size()) {
					System.out.println("  FEATURE -> Skipped Column="
							+ c.getColumnIndex() + ", Value=" + name);
				}
			}
			return true;
		}

		private String processIndex(HSSFRow row) {
			if (row == null) {
				return null;
			}
			if (isEmptyRow(row)) {
				return null;
			}
			String value = row.getCell(0).getStringCellValue();
			return value;
		}

		/**
		 * Create an object for each non-empty row, then populate the attributes
		 * and single refs using the features (Which have been set previously).
		 * Note: we also consider the max length of the value which can be
		 * stored.
		 * 
		 * @param row
		 * @return
		 */
		private EObject processAttributes(HSSFRow row) {

			if (row == null) {
				return null;
			}
			if (isEmptyRow(row)) {
				return null;
			}

			System.out.println(" CREATE: " + eClassToImport.getName());
			final EObject result = EcoreUtil.create(eClassToImport);
			for (int i = 0; i < eFeatures.size(); i++) {
				final EStructuralFeature eFeature = eFeatures.get(i);

				int index = indexSupport ? i + 1 : i;
				System.out.print(" ROW(A)=" + row.getRowNum() + " , COL= "
						+ index);
				HSSFCell cell = row.getCell(index);
				if (cell == null) {
					System.out.println(" -> WRONG Value=\"empty\"");
					continue;
				}
				if (eFeature instanceof EReference) {
					System.out.println(" -> Skip, Reference="
							+ eFeature.getName());
					continue;
				} else if (eFeature instanceof EAttribute) {

					if (eFeature == LibraryPackage.Literals.EXPRESSION__EXPRESSION_LINES) {
						// FIXME, doesn't work for this feature.
						System.out.println("debug here");
						continue;
					}

					System.out.print(" -> OK Attribute=" + eFeature.getName());
					EAttribute eAttrib = (EAttribute) eFeature;
					EDataType type = eAttrib.getEAttributeType();

					// Get the value.
					String value = cell.getStringCellValue();
					if (value == null || value.trim().length() == 0) {
						System.out.println(" , WRONG Value=\"empty\"");
						continue;
					}

					// Trim the value to the maxfacet Length.
					final int maxLength = ExtendedMetaData.INSTANCE
							.getMaxLengthFacet(eAttrib.getEAttributeType());
					if (maxLength > 0 && value != null
							&& value.length() > maxLength) {
						System.out.print(" , trim to=" + maxLength);
						value = value.substring(0, maxLength);
					}

					// Resolve the type and set the attrib value.
					if (type.getInstanceClass() == String.class) {
						result.eSet(eFeature, value);
					} else if (type.getInstanceClass() == boolean.class) {
						Boolean bValue = new Boolean(value);
						result.eSet(eFeature, bValue);
					} else if (type.getInstanceClass() == int.class) {
						Integer iValue = new Integer(value);
						result.eSet(eFeature, iValue);
					}

					// ///// ENUMS WHICH ARE MODE SPECIFIC.
					else if (type.getInstanceClass() == ObjectKindType.class) {
						ObjectKindType ok = ObjectKindType.get(value);
						result.eSet(eFeature, ok);
					}
					if (type.getInstanceClass() == ValueKindType.class) {
						ValueKindType vk = ValueKindType.get(value);
						result.eSet(eFeature, vk);
					}
					if (type.getInstanceClass() == KindHintType.class) {
						KindHintType kht = KindHintType.get(value);
						result.eSet(eFeature, kht);
					}
					System.out.println(" , Type=" + type.getInstanceClassName()
							+ ", Value=\"" + value + "\"");
				} else {
					System.out.println("Some other structural feature");
				}

			}
			return result;
		}

		/**
		 * 
		 * @param row
		 * @return
		 */
		private EObject getMultiRefRowObject(EObject parent, HSSFRow row) {
			if (row == null) {
				return null;
			}
			if (isEmptyRow(row)) {
				return null;
			}
			// The identifier is the first column for a MultiRef row.
			String identifier = row.getCell(0).getStringCellValue();
			EObject targetObject = getReferencedObject(parent, eClassToImport,
					identifier);
			if (targetObject == null) {
				// targetObject = getReferencedObjectFromContainment(parent,
				// eClassToImport, identifier);
				// if (targetObject != null) {
				// if (targetObject.eContainer() == null) {
				// System.err
				// .println("ERROR: Contained object has no container??");
				// }
				// } else {
				notFound(eClassToImport, identifier);
				// }
			}
			return targetObject;
		}

		private EObject processEReferences(boolean isMultiRef,
				EObject targetObject, HSSFRow row) {

			if (row == null) {
				return null;
			}
			if (isEmptyRow(row)) {
				return null;
			}

			System.out.println(" REFS FOR: " + eClassToImport.getName());
			for (int i = 0; i < eFeatures.size(); i++) {

				final EStructuralFeature eFeature = eFeatures.get(i);
				int index = (isMultiRef | isIndexSupport()) ? i + 1 : i;

				System.out.print(" ROW(" + (isMultiRef ? "MR" : "R") + ")="
						+ row.getRowNum() + " , COL= " + index);
				if (row.getCell(index) == null) {
					System.out.println(" ,Value=\"empty\"");
					continue;
				}
				if (eFeature instanceof EAttribute) {
					System.out.println(" -> Skip, Attribute="
							+ eFeature.getName());
					continue;
				} else if (eFeature instanceof EReference) {

					System.out.print(" -> OK Reference=" + eFeature.getName());

					// Get the value.
					final String indexValue = row.getCell(index)
							.getStringCellValue();

					if (indexValue == null || indexValue.trim().length() == 0) {
						System.out.println(" ,WRONG Value=\"empty\"");
						continue;
					}

					System.out.println(" , ref index=" + indexValue);
					final EReference eReference = (EReference) eFeature;

					// Get the referenced object.
					EObject objectToSet = getReferencedObject(null,
							eReference.getEReferenceType(), indexValue);
					if (objectToSet != null) {
						storeReference(false, indexValue, targetObject,
								eReference, objectToSet);
					}
				}
			}
			return targetObject;
		}
	}

	private void storeReference(boolean copyObjectForContainment,
			String indexValue, EObject target, final EReference eReference,
			EObject objectToSet) {

		EClassifier eType = eReference.getEType();
		if (eType.eClass().equals(objectToSet.eClass())) {
			System.out.println("Reference to be set matching type: " + eType);
		}

		if (eReference.isMany()) {
			// Process many values

			@SuppressWarnings("unchecked")
			EList<EObject> manyReference = (EList<EObject>) target
					.eGet(eReference);
			Collection<EObject> copyAll = EcoreUtil.copyAll(manyReference);

			// For containments, we set as a
			// reference and
			// then move it from the result set to the
			// For Non-Containments we simply set a reference to the object to
			// set (Which might
			// still be in the result set).
			if (eReference.isContainment()) {

				System.out.println("  SET REF MULTI(Containment): "
						+ printObject(objectToSet) + " with eRef: "
						+ eReference.getName() + " , on object:"
						+ printObject(target));

				// System.out.println("  MOVE from result set to contained set: "
				// + printObject(objectToSet));

				if (copyObjectForContainment) {
					EObject copyOfObjectToSet = EcoreUtil.copy(objectToSet);
					copyAll.add(copyOfObjectToSet);
					// removeObjectFromResultSet(objectToSet);
					// addObjectToContainedSet(indexValue, copyOfObjectToSet);
				} else {
					copyAll.add(objectToSet);
				}

			} else {
				System.out.println(" SET REF MULTI (NON-Containment): "
						+ printObject(objectToSet) + " with eRef: "
						+ eReference.getName() + " , on object:"
						+ printObject(target));
				copyAll.add(objectToSet);
			}
			target.eSet(eReference, copyAll);

		} else {
			if (eReference.isContainment()) {

				System.out.println("  SET REF SINGLE(Containment): "
						+ printObject(objectToSet) + " with eRef: "
						+ eReference.getName() + " , on object:"
						+ printObject(target));

				System.out.println("  MOVE from result set to contained set: "
						+ printObject(objectToSet));

				if (copyObjectForContainment) {
					EObject copyOfObjectToSet = EcoreUtil.copy(objectToSet);
					target.eSet(eReference, copyOfObjectToSet);
					// removeObjectFromResultSet(objectToSet);
					// addObjectToContainedSet(indexValue, copyOfObjectToSet);
				} else {
					target.eSet(eReference, objectToSet);
				}

			} else {
				System.out.println("  SET REF SINGLE (NON-Containment): "
						+ printObject(objectToSet) + " with eRef: "
						+ eReference.getName() + " , on object:"
						+ printObject(target));
				target.eSet(eReference, objectToSet);
			}
		}
	}

	private boolean setEClassFromSheetName(HSSFSheet sheet) {
		String name = sheet.getSheetName();
		for (int i = 0; i < this.ePackagesToImport.length; i++) {
			EPackage ePackage = ePackagesToImport[i];
			for (EClassifier classifier : ePackage.getEClassifiers()) {
				if (classifier instanceof EClass) {
					String cName = ((EClass) classifier).getName();
					if (cName.equalsIgnoreCase(name)) {

						eClassToImport = (EClass) classifier;
						System.out.println("CLASS REF: "
								+ eClassToImport.getName());
					}
					cName = cName + "_refs";
					if (cName.equalsIgnoreCase(name)) {
						eClassToImport = (EClass) classifier;
						System.out.println("CLASS MULTI_REF: "
								+ eClassToImport.getName());
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
	 * Should find an object within this hierarchy root, the eContainer of the
	 * root should not be set, otherwise we would be fishing on a branch. if
	 * there is no root, look in the total set, and finally produce a new node
	 * from the cache.
	 * 
	 * @param root
	 * @param eClass
	 * @param identifier
	 * @return
	 */
	private EObject getReferencedObject(EObject root, EClass eClass,
			String identifier) {

		EObject result = null;
		System.out.print("  RESOLVING: " + identifier);
		if (root != null && root.eContainer() == null) {

			System.out.print("  , in root: " + printObject(root));

			// Is it a child in the result set?
			Iterator<EObject> it = null;
			it = root.eAllContents();
			while (it.hasNext()) {
				final EObject eObject = it.next();
				if (isAnyOfTheSuperTypes(eObject, eClass)) {
					if (matchesAnyAttribute(identifier, eObject)) {
						System.out.print(", found!=" + printObject(eObject));
						return eObject;
					}
				}
			}
			System.out.println(" , not (yet) found in root...");
		}

		// If we don't have a root object, we look in the full result set
		// for the occurence. (the object will already have hierarchy).
		//

		if (this.indexSupport) {
			System.out.print("  , look in complete result set");
			result = this.globalIndex.get(identifier);
			if (result != null) {
				System.out.println(" FOUND REF :" + printObject(result));

			}
		} else {

			result = this.findObject(eClass, identifier);
			if (result != null) {
				System.out.println(", found!=\"" + printObject(result) + "\"");
			}
		}

		if (result == null) {
			notFound(eClass, identifier);
		}
		return result;
	}

	public void notFound(EClass eClass, String identifier) {
		System.err
				.print(", NOT found!, Check the sheet, Is the order of the sheets correct?, ");
		unresolvedReferences.add(eClass.getName() + " using " + identifier);
	}

	/**
	 * Find using any of the attributes from the class and the identifier.
	 * 
	 * @param eClass
	 * @param identifier
	 * @return
	 */
	private EObject findObject(EClass eClass, String identifier) {
		for (String key : globalIndex.keySet()) {
			EObject eObject = globalIndex.get(key);
			if (isAnyOfTheSuperTypes(eObject, eClass)) {
				if (matchesAnyAttribute(identifier, eObject)) {
					return eObject;
				}
			}
		}
		return null;
	}

	// private void removeObjectFromResultSet(EObject eo) {
	// int index = -1;
	// for (IndexedObject io : this.resultList) {
	// if (io.getEObject() == eo) {
	// index = this.resultList.indexOf(io);
	// }
	// }
	// if (index != -1) {
	// resultList.get(index);
	// resultList.remove(index);
	// } else {
	// System.out
	// .println("ERROR, Moving object from result set to contained set, the object to move doesn't exist in the result set!");
	// }
	// }

	// private void addObjectToContainedSet(String indexValue, EObject eo) {
	// IndexedObject findObject = this.findObject(indexValue,
	// this.containedList);
	// if (findObject == null) {
	// eo.hashCode();
	// findObject = new IndexedObject(indexValue, eo);
	// this.containedList.add(findObject);
	// }
	// }

	private boolean isAnyOfTheSuperTypes(EObject eObject, EClass eClass) {

		List<EClass> classes = Lists.newArrayList(eObject.eClass());
		classes.addAll(eObject.eClass().getEAllSuperTypes());
		for (EClass c : classes) {
			if (eClass.getName().equals(c.getName())) {
				return true;
			}
		}
		return false;
	}

	private boolean matchesAnyAttribute(String identifier, final EObject eObject) {
		for (final EAttribute eAttribute : eObject.eClass().getEAllAttributes()) {
			final Object value = eObject.eGet(eAttribute);
			if (value instanceof String
					&& ((String) value).compareToIgnoreCase(identifier) == 0) {
				System.out.println("  Found object for : " + identifier
						+ " object: " + printObject(eObject));
				return true;
			}
		}
		return false;
	}

	public class RowResult {
		private HSSFRow row;
		private EObject eObject;
		private String index;

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

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
			this.index = index;
		}
	}

	private void printResult() {

		// TODO FIX.
		// System.out.println("The STRUCTURED result");
		// for (IndexedObject io : structuredResult) {
		// String print = this.printObject(0, io.getEObject());
		// System.out.println(print);
		// }
		for (String s : unresolvedReferences) {
			System.out.println(" Unresolved identifier : " + s);
		}
		System.out.println("The UNRESOLVED references ="
				+ unresolvedReferences.size());
	}

	private String printObject(EObject o) {
		return printObject(0, o);
	}

	private String printObject(int depth, EObject o) {
		depth++;
		StringBuilder result = new StringBuilder();
		if (o instanceof Equipment) {
			result.append(depth(depth) + ((Equipment) o).getEquipmentCode());
			for (Equipment e : ((Equipment) o).getEquipments()) {
				printObject(depth, e);
			}
		}
		if (o instanceof Function) {
			result.append(depth(depth) + (((Function) o).getName()));
			for (Function e : ((Function) o).getFunctions()) {
				printObject(depth, e);
			}
		}
		if (o instanceof NodeType) {
			NodeType nt = (NodeType) o;
			result.append(depth(depth) + nt.getName());

			for (Function e : ((NodeType) nt).getFunctions()) {
				printObject(depth, e);
			}

			for (Equipment e : ((NodeType) nt).getEquipments()) {
				printObject(depth, e);
			}
		}
		if (o instanceof Service) {
			Service nt = (Service) o;
			result.append(nt.getServiceName());
			for (Service s : nt.getServices()) {
				result.append(this.printObject(depth, s));
			}
		}

		if (o instanceof MetricSource) {
			MetricSource ms = (MetricSource) o;
			result.append(ms.getName());
			result.append(this.printObject(depth, ms.getMetricMapping()));
		}
		if (o instanceof Mapping) {
			Mapping mapping = (Mapping) o;
			result.append("mapping");
			for (MappingColumn mc : mapping.getDataMappingColumns()) {
				result.append(this.printObject(depth, mc));
			}
		}
		if (o instanceof MappingColumn) {
			MappingColumn mc = (MappingColumn) o;
			result.append("mapping column: " + mc.getColumn());
			result.append(printObject(depth, mc.getDataType()));
		}
		if (o instanceof DataKind) {
			DataKind dk = (DataKind) o;
			if (dk instanceof IdentifierDataKind) {
				result.append("Identifier Datakind: "
						+ ((IdentifierDataKind) dk).getObjectKind());
			}
			if (dk instanceof ValueDataKind) {
				result.append("Value Datakind: "
						+ ((ValueDataKind) dk).getValueKind());
			}
		}

		return result.toString();
	}

	String depth(int depth) {
		char[] chars = new char[depth];
		for (int i = 0; i < chars.length; i++) {
			chars[i] = '-';
		}
		return chars.toString();
	}

}
