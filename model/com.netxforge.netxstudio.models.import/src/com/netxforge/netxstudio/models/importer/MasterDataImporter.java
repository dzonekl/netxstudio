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
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
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
import com.netxforge.base.cdo.ICDOData;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Lifecycle;
import com.netxforge.netxstudio.library.Component;
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
import com.netxforge.netxstudio.models.importer.internal.ImportActivator;
import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.services.Service;

/**
 * @author Martin Taal
 * @author Christophe Bouhier
 */
public class MasterDataImporter {

	private ICDOData dataProvider;

	private EClass eClassToImport;

	// private Map<String, EObject> globalIndex = Maps.newHashMap();

	private Map<String, EObject> globalIndexURI = Maps.newHashMap();

	Resource resource = new ResourceSetImpl().createResource(URI
			.createURI("temp"));

	private List<String> unresolvedReferences = new ArrayList<String>();

	private EPackage[] ePackagesToImport;

	private boolean indexSupport;

	private int passes = 2;

	public boolean isIndexSupport() {
		return indexSupport;
	}

	/*
	 * Use an EObject path as a global index pointer into the Resource.
	 */
	private void addToGlobalIndex(String index, EObject object) {

		// int hashcode = object.hashCode();
		globalIndexURI.put(index, object);
		if (ImportActivator.DEBUG) {
			System.out.println("INDEX: Added index=" + index + ", object="
					+ printObject(object));
		}
	}

	/*
	 * Use an EObject path as a global index pointer into the Resource.
	 */
	private EObject getFromGlobalIndex(String index) {

		EObject object = null;
		if (globalIndexURI.containsKey(index)) {
			object = globalIndexURI.get(index);

			// TreeIterator<EObject> allContents = resource.getAllContents();
			// while (allContents.hasNext()) {
			// EObject next = allContents.next();
			// if (next.hashCode() == hashcode) {
			// object = next;
			// }
			// }
			if (ImportActivator.DEBUG) {
				System.out.println("INDEX: Resolved index=" + index
						+ ", object=" + printObject(object));
			}
			return object;
		} else {
			if (ImportActivator.DEBUG) {
				System.err.println("INDEX: Error index=" + index
						+ " doesn't exist!");
			}
		}
		return object;
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

			for (int passIndex = 1; passIndex <= passes; passIndex++) {

				// Clear after each pass...
				unresolvedReferences.clear();

				if (ImportActivator.DEBUG) {
					System.out.println("DATA IMPORTER: pass=" + passIndex);
				}

				for (int sheetIndex = 0; sheetIndex < workBook
						.getNumberOfSheets(); sheetIndex++) {

					ProcessWorkSheet pw = new ProcessWorkSheet(passIndex,
							sheetIndex, workBook.getSheetAt(sheetIndex));

					// We only add object on the first pass
					List<RowResult> sheetResult = pw.getSheetResult();
					if (!pw.isMultiRefSheet() && passIndex == 1) {
						for (final RowResult rowResult : sheetResult) {
							resource.getContents().add(rowResult.getEObject());
							this.addToGlobalIndex(rowResult.getIndex(),
									rowResult.getEObject());
						}
					}
				}
				if (ImportActivator.DEBUG) {
					printResult();
					printIndex();
				}

			}
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
		 * @param passIndex
		 * @param sheetIndex
		 * @param sheet
		 * @return
		 */
		ProcessWorkSheet(int passIndex, int sheetIndex, HSSFSheet sheet) {

			if (ImportActivator.DEBUG) {
				System.err.println("SHEET: " + sheet.getSheetName());
			}

			// Match the features of this sheet.
			if (!setEFeatures(sheet)) {

				if (ImportActivator.DEBUG) {
					System.err.println("SHEET ABORT " + sheet.getSheetName()
							+ " No Class found for the context Packages"
							+ ePackagesToImport);
				}

				return;
			}

			// Keep track of the last resolved object for multiref sheets.
			EObject lastRootObject = null;

			if (eClassToImport == null)
				return;

			// process non-empty rows, starting from 3nd row.
			for (int i = 2; i <= sheet.getLastRowNum(); i++) {
				HSSFRow row = sheet.getRow(i);
				if (isEmptyRow(row)) {
					continue;
				}
				EObject eObject = null;

				if (!isMultiRefSheet) {
					String objectIndex = null;
					if (indexSupport) {
						objectIndex = this.processIndex(row);
					} else {
						// An arbitrary number.
						Random randomGen = new Random();
						objectIndex = new Long(randomGen.nextLong()).toString();

					}

					// Create an object with attributes only on the first pass.
					if (passIndex == 1) {
						if (objectIndex
								.equals("OID:http://www.netxforge.com/13042011/metrics#Metric#5603")) {
							System.err.println("stop here");
						}
						eObject = processAttributes(row);
						if (eObject != null) {

							// Create a Row result.
							final RowResult rowResult = new RowResult();
							rowResult.setRow(row);
							rowResult.setEObject(eObject);
							if (objectIndex != null) {
								rowResult.setIndex(objectIndex);
							}
							sheetRowResults.add(rowResult);
						}

					} else {

						if (eClassToImport
								.equals(OperatorsPackage.Literals.NODE)) {
							System.out.println("debug");
						}

						if (indexSupport) {
							eObject = getFromGlobalIndex(objectIndex);
						} else {
							eObject = getSingleRefRowObject(row);
						}

					}

					if (eObject != null && passIndex > 1
							&& featuresHaveReferences()) {
						eObject = processEReferences(false, eObject, row);

					}
				} else {
					// Process multi references only on the 2nd pass.
					if (passIndex > 1) {
						eObject = getMultiRefRowObject(lastRootObject, row);
						if (eObject != null) {
							eObject = processEReferences(true, eObject, row);
						}
					}
				}

				if (eObject != null && eObject.eContainer() == null) {
					lastRootObject = eObject;
					if (ImportActivator.DEBUG) {
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
						if (ImportActivator.DEBUG) {
							System.out.println("  FEATURE -> Add Feature="
									+ c.getColumnIndex() + ", Value=" + name);
						}
						eFeatures.add(eFeature);
						break;
					} else {
						// if (ImportActivator.DEBUG) {
						// System.out.println("  FEATURE -> Skip column name doesn't match Feature="
						// + c.getColumnIndex() + ", Value=" + name);
						// }
					}
				}
				// We haven't added a feature.
				if (currentFeatureCount == eFeatures.size()) {
					if (ImportActivator.DEBUG) {
						System.out.println("  FEATURE -> Skipped Column="
								+ c.getColumnIndex() + ", Value=" + name);
					}
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

			if (ImportActivator.DEBUG) {
				System.out.println(" CREATE: " + eClassToImport.getName());
			}

			final EObject result = EcoreUtil.create(eClassToImport);
			if (result instanceof Component) {
				Component c = (Component) result;
				EObject lc = EcoreUtil
						.create(GenericsPackage.Literals.LIFECYCLE);
				c.setLifecycle((Lifecycle) lc);
			}
			for (int i = 0; i < eFeatures.size(); i++) {
				final EStructuralFeature eFeature = eFeatures.get(i);

				int index = indexSupport ? i + 1 : i;

				if (ImportActivator.DEBUG) {
					System.out.print(" ROW(A)=" + row.getRowNum() + " , COL= "
							+ index);
				}

				HSSFCell cell = row.getCell(index);
				if (cell == null) {
					if (ImportActivator.DEBUG) {
						System.out.println(" -> WRONG Value=\"empty\"");
					}
					continue;
				}
				if (eFeature instanceof EReference) {
					if (ImportActivator.DEBUG) {
						System.out.println(" -> Skip, Reference="
								+ eFeature.getName());
					}
					continue;
				} else if (eFeature instanceof EAttribute) {

					if (ImportActivator.DEBUG) {
						System.out.print(" -> OK Attribute="
								+ eFeature.getName());
					}

					EAttribute eAttrib = (EAttribute) eFeature;
					EDataType type = eAttrib.getEAttributeType();

					String value = this.getCellValue(cell);

					if (value == null || value.trim().length() == 0) {

						if (ImportActivator.DEBUG) {
							System.out.println(" , WRONG Value=\"empty\"");
						}
						continue;
					}

					// Trim the value to the maxfacet Length.
					final int maxLength = ExtendedMetaData.INSTANCE
							.getMaxLengthFacet(eAttrib.getEAttributeType());
					if (maxLength > 0 && value != null
							&& value.length() > maxLength) {
						if (ImportActivator.DEBUG) {
							System.out.print(" , trim to=" + maxLength);
						}
						value = value.substring(0, maxLength);
					}

					// Resolve the type and set the attrib value.
					if (type.getInstanceClass() == String.class) {
						// Special threatment for multiplicity attributes.
						// http://work.netxforge.com/issues/311
						if (eFeature == LibraryPackage.Literals.EXPRESSION__EXPRESSION_LINES) {
							
							if (ImportActivator.DEBUG) {
								System.out
										.println("-> Processing expression lines. ");
							}
							Object eGet = result.eGet(eFeature);
							if(eGet instanceof EList){
								// We can safely cast. 
								@SuppressWarnings("unchecked")
								EList<String> lines = (EList<String>) eGet;
								
								String strings[] = value.split("\\r?\\n");
								for(String s : strings){
									lines.add(s + "\n");
								}
							}
						} else {
							result.eSet(eFeature, value);
						}
					} else if (type.getInstanceClass() == boolean.class) {
						Boolean bValue = new Boolean(value);
						result.eSet(eFeature, bValue);
					} else if (type.getInstanceClass() == int.class) {
						Integer iValue = new Integer(value);
						result.eSet(eFeature, iValue);
					}

					// Park for now.
					// else if( type.getInstanceClass() == double.class){
					// Double dbValue = new Double(value);
					// result.eSet(eFeature, dbValue);
					// }else if( type.getInstanceClass() ==
					// XMLGregorianCalendar.class){
					// new XMLGregorianCalendar(value);
					//
					// }

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
					if (ImportActivator.DEBUG) {
						System.out.println(" , Type="
								+ type.getInstanceClassName() + ", Value=\""
								+ value + "\"");
					}
				} else {
					if (ImportActivator.DEBUG) {
						System.out.println("Some other structural feature");
					}
				}
			}
			return result;
		}

		private String getCellValue(HSSFCell cell) {
			String value = null;
			// Get the value.
			int cellType = cell.getCellType();
			if (cellType == HSSFCell.CELL_TYPE_NUMERIC) {
				double numericCellValue = cell.getNumericCellValue();
				// value = new Double(numericCellValue).toString();

				// DecimalFormat decimalFormat = (DecimalFormat)
				// DecimalFormat.getInstance();
				// decimalFormat.setDecimalSeparatorAlwaysShown(false);
				// decimalFormat.setMaximumFractionDigits(0);
				// value = decimalFormat.format(numericCellValue);
				NumberFormat nf = NumberFormat.getInstance();
				nf.setMaximumFractionDigits(0);// set as you need
				nf.setGroupingUsed(false);
				value = nf.format(numericCellValue);

			} else if (cellType == HSSFCell.CELL_TYPE_STRING) {
				value = cell.getStringCellValue();
			}
			return value;
		}

		/**
		 * 
		 * @param row
		 * @return
		 */
		private EObject getMultiRefRowObject(EObject lastRoot, HSSFRow row) {
			if (row == null) {
				return null;
			}
			if (isEmptyRow(row)) {
				return null;
			}

			// The identifier is the first column for a MultiRef row.
			String identifier = row.getCell(0).getStringCellValue();

			EObject targetObject = getReferencedObject(lastRoot,
					eClassToImport, identifier);
			if (targetObject == null) {
				notFound(eClassToImport, identifier);
			}
			return targetObject;
		}

		private EObject getSingleRefRowObject(HSSFRow row) {
			if (row == null) {
				return null;
			}
			if (isEmptyRow(row)) {
				return null;
			}

			// The identifier can be anywhere, look for a match.
			if (row.getCell(0) != null) {
				String identifier = row.getCell(0).getStringCellValue();

				EObject targetObject = getReferencedObject(null,
						eClassToImport, identifier);
				if (targetObject == null) {
					notFound(eClassToImport, identifier);
				}
				return targetObject;
			}
			return null;
		}

		private EObject processEReferences(boolean isMultiRef,
				EObject targetObject, HSSFRow row) {

			if (row == null) {
				return null;
			}
			if (isEmptyRow(row)) {
				return null;
			}

			if (ImportActivator.DEBUG) {
				System.out.println(" REFS FOR: " + eClassToImport.getName());
			}

			for (int i = 0; i < eFeatures.size(); i++) {

				final EStructuralFeature eFeature = eFeatures.get(i);
				int index = (isMultiRef | isIndexSupport()) ? i + 1 : i;

				if (ImportActivator.DEBUG) {
					System.out.print(" ROW(" + (isMultiRef ? "MR" : "R") + ")="
							+ row.getRowNum() + " , COL= " + index);
				}

				if (row.getCell(index) == null) {
					if (ImportActivator.DEBUG) {
						System.out.println(" ,Value=\"empty\"");
					}

					continue;
				}
				if (eFeature instanceof EAttribute) {
					if (ImportActivator.DEBUG) {
						System.out.println(" -> Skip, Attribute="
								+ eFeature.getName());
					}
					continue;
				} else if (eFeature instanceof EReference) {

					if (ImportActivator.DEBUG) {
						System.out.print(" -> OK Reference="
								+ eFeature.getName());
					}

					// Get the value.

					final String indexValue = this.getCellValue(row
							.getCell(index));

					if (indexValue == null || indexValue.trim().length() == 0) {

						if (ImportActivator.DEBUG) {
							System.out.println(" ,WRONG Value=\"empty\"");
						}
						continue;
					}

					if (ImportActivator.DEBUG) {
						System.out.println(" , ref index=" + indexValue);
					}

					// Get the referenced object.
					final EReference eReference = (EReference) eFeature;

					EObject objectToSet = getReferencedObject(null,
							eReference.getEReferenceType(), indexValue);

					if (objectToSet != null) {
						storeReference(targetObject, eReference, objectToSet);
					}
				}
			}
			return targetObject;
		}
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

		if (ImportActivator.DEBUG) {
			System.out.print("  RESOLVING: " + identifier);
		}

		if (root != null && root.eContainer() == null) {

			if (ImportActivator.DEBUG) {
				System.out.println(" -> Try last root object="
						+ printObject(root));
			}

			// Is it a child in the result set?
			Iterator<EObject> it = null;
			it = root.eAllContents();
			while (it.hasNext()) {
				final EObject eObject = it.next();
				if (isAnyOfTheSuperTypes(eObject, eClass)) {
					if (matchesAnyAttribute(identifier, eObject)) {
						if (ImportActivator.DEBUG) {
							System.out
									.print(", found! object="
											+ printObject(eObject)
											+ " parent ="
											+ eObject.eContainer() != null ? printObject(eObject
											.eContainer()) : "No Parent (yet)");
						}
						return eObject;
					}
				}
			}

			if (ImportActivator.DEBUG) {
				System.out
						.println(" -> not found in last root object, continue...");
			}
		}

		// If we don't have a root object, we look in the full result set
		// for the occurence. (the object will already have hierarchy).
		//
		if (this.indexSupport) {
			result = this.getFromGlobalIndex(identifier);
		} else {
			result = this.findObject(eClass, identifier);
			if (result != null) {
				if (ImportActivator.DEBUG) {
					System.out.println(", found ref, object="
							+ printObject(result) + " parent ="
							+ result.eContainer() != null ? printObject(result
							.eContainer()) : "No Parent (yet)");
				}
			}
		}

		if (result == null) {
			notFound(eClass, identifier);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	private void storeReference(EObject target, final EReference eReference,
			EObject objectToSet) {

		if (eReference.isMany()) {
			// Process many values

			EList<EObject> manyReferenceCollection = (EList<EObject>) target
					.eGet(eReference);

			if (eReference.isContainment()) {

				if (ImportActivator.DEBUG) {
					System.out.println("  SET REF MULTI(Containment): "
							+ printObject(objectToSet) + " with eRef: "
							+ eReference.getName() + " , on object:"
							+ printObject(target));
				}
				manyReferenceCollection.add(objectToSet);

			} else {

				if (ImportActivator.DEBUG) {
					System.out.println(" SET REF MULTI (NON-Containment): "
							+ printObject(objectToSet) + " with eRef: "
							+ eReference.getName() + " , on object:"
							+ printObject(target));
				}
				manyReferenceCollection.add(objectToSet);
			}
		} else {
			if (eReference.isContainment()) {

				// DO NOT USE COPIES, AS REFERENCE BREAK.
				// if (eReference == OperatorsPackage.Literals.NODE__NODE_TYPE
				// && objectToSet.eClass() == LibraryPackage.Literals.NODE_TYPE)
				// {
				// objectToSet = EcoreUtil.copy(objectToSet);
				// }

				if (ImportActivator.DEBUG) {
					System.out.println("  SET REF SINGLE(Containment): "
							+ printObject(objectToSet) + " with eRef: "
							+ eReference.getName() + " , on object:"
							+ printObject(target));
				}

				target.eSet(eReference, objectToSet);

			} else {
				if (ImportActivator.DEBUG) {
					System.out.println("  SET REF SINGLE (NON-Containment): "
							+ printObject(objectToSet) + " with eRef: "
							+ eReference.getName() + " , on object:"
							+ printObject(target));
				}
				target.eSet(eReference, objectToSet);
			}
		}
		// printIndex();
	}

	/*
	 * Retrieves the EClass which is the sheet name. It is either single or
	 * multi reference sheet.
	 */
	private boolean setEClassFromSheetName(HSSFSheet sheet) {
		String name = sheet.getSheetName();
		for (int i = 0; i < this.ePackagesToImport.length; i++) {
			EPackage ePackage = ePackagesToImport[i];
			for (EClassifier classifier : ePackage.getEClassifiers()) {
				if (classifier instanceof EClass) {
					String cName = ((EClass) classifier).getName();
					if (cName.equalsIgnoreCase(name)) {

						eClassToImport = (EClass) classifier;

						if (ImportActivator.DEBUG) {
							System.out.println("CLASS REF: "
									+ eClassToImport.getName());
						}
					}
					cName = cName + "_refs";
					if (cName.equalsIgnoreCase(name)) {
						eClassToImport = (EClass) classifier;
						if (ImportActivator.DEBUG) {
							System.out.println("CLASS MULTI_REF: "
									+ eClassToImport.getName());
						}
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

	public ICDOData getDataProvider() {
		return dataProvider;
	}

	public void setDataProvider(ICDOData dataProvider) {
		this.dataProvider = dataProvider;
	}

	public void notFound(EClass eClass, String identifier) {
		if (ImportActivator.DEBUG) {
			System.err
					.print(", NOT found!, Check the sheet, Is the order of the sheets correct?, ");
		}
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
		for (String key : globalIndexURI.keySet()) {
			EObject eObject = getFromGlobalIndex(key);
			if (isAnyOfTheSuperTypes(eObject, eClass)) {
				if (matchesAnyAttribute(identifier, eObject)) {
					return eObject;
				}
			}
		}
		return null;
	}

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

	private void printIndex() {
		for (String key : globalIndexURI.keySet()) {
			// print in get call.
			getFromGlobalIndex(key);
		}
	}

	private void printResult() {

		for (String s : unresolvedReferences) {
			System.out.println(" Unresolved identifier : " + s);
		}
		System.out.println("The UNRESOLVED references ="
				+ unresolvedReferences.size());

		TreeIterator<EObject> allContents = resource.getAllContents();

		int count = 0;
		while (allContents.hasNext()) {
			EObject next = allContents.next();
			count++;
			System.out.println(" - (" + count + ") : " + printObject(next));
		}
		System.out.println("Total created objects " + count);

	}

	@SuppressWarnings("unused")
	private void printBranch(EObject o) {
		TreeIterator<EObject> allContents = o.eAllContents();

		int count = 0;
		while (allContents.hasNext()) {
			EObject next = allContents.next();
			count++;
			System.out.println(" - (" + count + ") : " + printObject(next));
		}
	}

	private String printObject(EObject o) {
		StringBuilder result = new StringBuilder();

		if (o instanceof Network) {
			Network net = (Network) o;
			result.append("Network: name=" + net.getName());
		}

		if (o instanceof Node) {
			Node n = (Node) o;
			result.append("Node: name=" + n.getNodeID());
		}

		if (o instanceof Equipment) {
			result.append("Equipment: code="
					+ ((Equipment) o).getEquipmentCode());
		}
		if (o instanceof Function) {
			result.append("Function: name=" + ((Function) o).getName());
		}
		if (o instanceof NodeType) {
			NodeType nt = (NodeType) o;
			result.append("NodeType: name=" + nt.getName());
		}
		if (o instanceof Service) {
			Service nt = (Service) o;
			result.append("Service: name=" + nt.getServiceName());
		}

		if (o instanceof MetricSource) {
			MetricSource ms = (MetricSource) o;
			result.append("Metric Source: name=" + ms.getName());
		}
		if (o instanceof Mapping) {
			Mapping mapping = (Mapping) o;
			result.append("Mapping: datarow=" + mapping.getFirstDataRow()
					+ "interval=" + mapping.getIntervalHint() + ",colums="
					+ mapping.getDataMappingColumns().size());
		}
		if (o instanceof MappingColumn) {
			MappingColumn mc = (MappingColumn) o;
			result.append("mapping column: " + mc.getColumn());
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

		// if( ECoreUtil.geto.getClass() != null){
		// result.append(" class=" + o.eClass().getName());
		// }else if(o.eResource() != null){
		// result.append(" resource=" + o.eResource().getURI().toString());
		// }
		result.append("object=" + o);

		return result.toString();
	}

	String depth(int depth) {
		char[] chars = new char[depth];
		for (int i = 0; i < chars.length; i++) {
			chars[i] = '-';
		}
		return chars.toString();
	}

	void updateIndex(Collection<EObject> oldCollection,
			Collection<EObject> newCollection) {
		for (EObject eEO : oldCollection) {

			// 1. get it from the index;
			String keyToSet = null;
			for (String index : globalIndexURI.keySet()) {
				EObject eEI = this.globalIndexURI.get(index);
				if (EcoreUtil.equals(eEO, eEI)) {
					keyToSet = index;
					break;
				}
			}

			// 2. get if from the new collection
			EObject eObjectToSet = null;
			for (EObject eEN : newCollection) {
				if (EcoreUtil.equals(eEO, eEN)) {
					eObjectToSet = eEN;
					break;
				}
			}
			globalIndexURI.put(keyToSet, eObjectToSet);
			// if(ImportActivator.DEBUG){
			// System.out.println("INDEX: index=" + keyToSet
			// +" replaced object=" + eEO.hashCode() + " , with=" +
			// eObjectToSet.hashCode()) ;
			// }
		}
	}

	// void printAllHashCodes() {
	// TreeIterator<EObject> allContents = resource.getAllContents();
	// while (allContents.hasNext()) {
	// EObject next = allContents.next();
	// System.err.println("RESOURCE: hashcode=" + next.hashCode()
	// + " , object=" + printObject(next));
	// }
	//
	// }

}
