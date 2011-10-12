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

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
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

	// private List<EObject> cachedObjects = new ArrayList<EObject>();

	private List<IndexedObject> structuredResult = new ArrayList<IndexedObject>();
	// private Map<String, EObject> structuredMap = Maps.newHashMap();

	private List<String> unresolvedReferences = new ArrayList<String>();

	private EPackage[] ePackagesToImport;

	private boolean indexSupport;

	public boolean isIndexSupport() {
		return indexSupport;
	}

	public void setIndexSupport(boolean indexSupport) {
		this.indexSupport = indexSupport;
	}

	class IndexedObject {

		private EObject eo;
		private String index;

		// private List<IndexedObject> children;

		public EObject getEObject() {
			return eo;
		}

		public void setEObject(EObject eo) {
			this.eo = eo;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
			this.index = index;
		}
		// public List<IndexedObject> getChildren() {
		// return children;
		// }
		// public void setChildren(List<IndexedObject> children) {
		// this.children = children;
		// }
	}

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

						IndexedObject io = new IndexedObject();
						io.setEObject(copyFromCache);
						io.setIndex(rowResult.getIndex());

						// structuredResult.add(copyFromCache);
						structuredResult.add(io);
					}
				}
			}

			// printResult();

		} catch (final Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public List<EObject> getResolvedObjects() {

		List<EObject> result = Lists.newArrayList();

		for (IndexedObject io : structuredResult) {
			result.add(io.getEObject());
		}
		return result;
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

			System.err.println("processing sheet: " + sheet.getSheetName());

			// Match the features of this sheet.
			isMultiRefSheet = setEFeatures(sheet);

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
						}
						eObject = processAttributes(row, indexSupport);
						if (eObject != null) {
							// result.add(eObject);
							// cachedObjects.add(eObject);
							final RowResult rowResult = new RowResult();
							rowResult.setRow(sheet.getRow(i));
							rowResult.setEObject(eObject);
							if (objectIndex != null) {
								rowResult.setIndex(objectIndex);
							}
							System.out.println("Creating: " + objectIndex !=  null ? objectIndex : eObject);

							sheetRowResults.add(rowResult);
							eObject = processEReferences(false,
									rowResult.getEObject(), rowResult.getRow());
						}
					} else {
						eObject = getMultiRefRowIndex(lastRootObject, row);
						System.out
								.println("Processing multi-references for object:"
										+ eObject);
						if (eObject != null) {

							// TODO, why a new result for a multiref row? No new
							// object is created.
							//
							// final RowResult rowResult = new RowResult();
							// rowResult.setRow(sheet.getRow(i));
							// rowResult.setEObject(eObject);
							// sheetRowResults.add(rowResult);

							eObject = processEReferences(true,eObject, row);
						}
					}
					if (eObject.eContainer() == null) {
						lastRootObject = eObject;
						System.out.println("Setting last root object: "
								+ printObject(lastRootObject));
					}
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
			if (sheet.getRow(0) == null) {
				return false; // We need a first row.
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
		private EObject processAttributes(HSSFRow row, boolean skipIndex) {
			if (row == null) {
				return null;
			}
			if (isEmptyRow(row)) {
				return null;
			}

			final EObject result = EcoreUtil.create(eClassToImport);
			for (int i = 0; i < eFeatures.size(); i++) {
				final EStructuralFeature eFeature = eFeatures.get(i);
				// if (row.getCell(i) == null) {
				// System.out.println("Skipping index=" +i);
				// continue;
				// }
				if (eFeature instanceof EReference) {
					System.out.println(eFeature);
					continue;
				} else if (eFeature instanceof EAttribute) {
					EAttribute eAttrib = (EAttribute) eFeature;
					EDataType type = eAttrib.getEAttributeType();

					HSSFCell cell = row.getCell(indexSupport ? i + 1 : i);
					if (cell == null) {
						continue;
					}
					String value = cell.getStringCellValue();

					final int maxLength = ExtendedMetaData.INSTANCE
							.getMaxLengthFacet(eAttrib.getEAttributeType());
					if (value == null || value.trim().length() == 0) {
						continue;
					}
					if (maxLength > 0 && value != null
							&& value.length() > maxLength) {
						value = value.substring(0, maxLength);
					}
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
						System.out.println("Objectkind found");
						ObjectKindType ok = ObjectKindType.get(value);
						result.eSet(eFeature, ok);
					}
					if (type.getInstanceClass() == ValueKindType.class) {
						System.out.println("Valuekind found");
						ValueKindType vk = ValueKindType.get(value);
						result.eSet(eFeature, vk);
					}
					if (type.getInstanceClass() == KindHintType.class) {
						KindHintType kht = KindHintType.get(value);
						result.eSet(eFeature, kht);
					}
					System.out.println("index=" + i + ", Attribute of class: "
							+ type.getInstanceClassName() + "value : " + value);
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
		private EObject getMultiRefRowIndex(EObject parent, HSSFRow row) {
			if (row == null) {
				return null;
			}
			if (isEmptyRow(row)) {
				return null;
			}

			// The identifier is the first column for a MultiRef row.
			String identifier = row.getCell(0).getStringCellValue();
			System.out.println("Resolving object: " + identifier);

			// // Some eclasses, don't not have an identifier, so we mapp to
			// // another class.
			// EClass eClassMapped = mapClass(eClassToImport);
			//
			// if (eClassToImport != eClassMapped) {
			// EObject eo = getResultObject(parent, eClassMapped, identifier);
			// EReference mappedReference = this.mapFeature(eClassToImport);
			// return (EObject) eo.eGet(mappedReference);
			//
			// } else {
			return getResultObject(parent, eClassToImport, identifier);
			// }

		}

		/**
		 * Maps a class to another for a valid identifier.
		 * 
		 * @param eClassToImport
		 * @return
		 */
		// private EClass mapClass(EClass eClassToImport) {
		// if (eClassToImport == MetricsPackage.Literals.MAPPING) {
		// return MetricsPackage.Literals.METRIC_SOURCE;
		// }
		// return eClassToImport;
		// }
		//
		// private EReference mapFeature(EClass eClassToImport) {
		// if (eClassToImport == MetricsPackage.Literals.MAPPING) {
		// return MetricsPackage.Literals.METRIC_SOURCE__METRIC_MAPPING;
		// }
		// return null;
		// }

		private EObject processEReferences(boolean isMultiRef, EObject target, HSSFRow row) {
			for (int i = 0; i < eFeatures.size(); i++) {
				// Skip the first column.
				int k = isMultiRef? i+1: i;

				
				final EStructuralFeature eFeature = eFeatures.get(i);
				if (row.getCell(k) == null) {
					continue;
				}
				if (eFeature instanceof EAttribute) {
					continue;
				}

				// Skip the first column.
				final String value = row.getCell(k).getStringCellValue();
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

							// // Find the object to set from the result set and
							// // remove
							// // it.
							// int index =
							// structuredResult.indexOf(objectToSet);
							// if (index != -1) {
							// structuredResult.remove(index);
							// }

							System.out.println(" Removing from result set: "
									+ printObject(objectToSet));

							RemoveObject(objectToSet);

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
						if (eReference.isContainment()) {
							target.eSet(eFeature, objectToSet);
							RemoveObject(objectToSet);
						} else {
							target.eSet(eFeature, objectToSet);
						}
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
		String name = sheet.getSheetName();
		for (int i = 0; i < this.ePackagesToImport.length; i++) {
			EPackage ePackage = ePackagesToImport[i];
			for (EClassifier classifier : ePackage.getEClassifiers()) {
				if (classifier instanceof EClass) {
					String cName = ((EClass) classifier).getName();
					if (cName.equalsIgnoreCase(name)) {
						eClassToImport = (EClass) classifier;
					}
					cName = cName + "_refs";
					if (cName.equalsIgnoreCase(name)) {
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
				if (isAnyOfTheSuperTypes(eObject, eClass)) {
					if (matchesAnyAttribute(identifier, eObject)) {
						return eObject;
					}

				}
			}
		}
		System.out.println(" Looking for object: " + identifier
				+ " in complete result set: ");
		// If we don't have a root object, we look in the full result set
		// for the occurence. (the object will already have hierarchy).
		//
		IndexedObject io = null;
		if (this.indexSupport) {
			io = this.findObject(identifier);
		} else {
			io = this.findObject(eClass, identifier);
		}

		if (io != null) {
			System.out.println(" object found in the result set:"
					+ io.getEObject());
			return io.getEObject();
		}

		// System.out
		// .println(" No object can be found in the result set, get a copy from cache: "
		// + identifier + " with class: " + eClass.getName());

		// FIXME Note, it's not in our structure it's also not in the cache!

		// It's not in our structure, so get a copy of the cached version, with
		// no hierarchy
		// for (final EObject eObject : cachedObjects) {
		//
		// if (isAnyOfTheSuperTypes(eObject, eClass)) {
		// if (matchesAnyAttribute(identifier, eObject)) {
		// System.out.println("  Copy object for : " + identifier
		// + " object: " + printObject(eObject));
		// result = EcoreUtil.copy(eObject);
		// break;
		// }
		// }
		// }

		unresolvedReferences.add(eClass.getName() + " using " + identifier);

		return result;
	}

	private IndexedObject findObject(String identifier) {
		IndexedObject ioResult = null;
		for (IndexedObject io : this.structuredResult) {
			if (io.getIndex().equals(identifier)) {
				ioResult = io;
				break;
			}
		}
		return ioResult;
	}

	private IndexedObject findObject(EClass eClass, String identifier) {
		IndexedObject ioResult = null;
		for (IndexedObject io : this.structuredResult) {
			EObject eObject = io.getEObject();
			if (isAnyOfTheSuperTypes(eObject, eClass)) {
				if (matchesAnyAttribute(identifier, eObject)) {
					return io;
				}
			}
		}
		return ioResult;
	}

	private void RemoveObject(EObject eo) {
		int index = -1;
		for (IndexedObject io : this.structuredResult) {
			if (io.getEObject() == eo) {
				index = this.structuredResult.indexOf(io);
			}
		}
		if (index != -1) {
			structuredResult.remove(index);
		}
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

	@SuppressWarnings("unused")
	private void printResult() {
		System.out.println("The STRUCTURED result");
		for (IndexedObject io : structuredResult) {
			String print = this.printObject(0, io.getEObject());
			System.out.println(print);
		}
		System.out.println("The UNRESOLVED references ");
		for (String s : unresolvedReferences) {
			System.out.println(" Unresolved identifier : " + s);
		}
	}

	private String printObject(EObject o) {
		return printObject(0, o);
	}

	private String printObject(int depth, EObject o) {
		depth++;
		StringBuilder result = new StringBuilder();
		if (o instanceof Equipment) {
			result.append(depth(depth) + ((Equipment) o).getEquipmentCode()
					+ "\n");
			for (Equipment e : ((Equipment) o).getEquipments()) {
				printObject(depth, e);
			}
		}
		if (o instanceof Function) {
			result.append(depth(depth) + (((Function) o).getName()) + "\n");
			for (Function e : ((Function) o).getFunctions()) {
				printObject(depth, e);
			}
		}
		if (o instanceof NodeType) {
			NodeType nt = (NodeType) o;
			result.append(depth(depth) + nt.getName() + "\n");

			for (Function e : ((NodeType) nt).getFunctions()) {
				printObject(depth, e);
			}

			for (Equipment e : ((NodeType) nt).getEquipments()) {
				printObject(depth, e);
			}
		}
		if (o instanceof Service) {
			Service nt = (Service) o;
			result.append(nt.getServiceName() + "\n");
			for (Service s : nt.getServices()) {
				result.append(this.printObject(depth, s));
			}
		}

		if (o instanceof MetricSource) {
			MetricSource ms = (MetricSource) o;
			result.append(ms.getName() + "\n");
			result.append(this.printObject(depth, ms.getMetricMapping()));
		}
		if (o instanceof Mapping) {
			Mapping mapping = (Mapping) o;
			result.append("mapping" + "\n");
			for (MappingColumn mc : mapping.getDataMappingColumns()) {
				result.append(this.printObject(depth, mc));
			}
		}
		if (o instanceof MappingColumn) {
			MappingColumn mc = (MappingColumn) o;
			result.append("mapping column: " + mc.getColumn() + "\n");
			result.append(printObject(depth, mc.getDataType()));
		}
		if (o instanceof DataKind) {
			DataKind dk = (DataKind) o;
			if (dk instanceof IdentifierDataKind) {
				result.append("Identifier Datakind: "
						+ ((IdentifierDataKind) dk).getObjectKind() + "\n");
			}
			if (dk instanceof ValueDataKind) {
				result.append("Value Datakind: "
						+ ((ValueDataKind) dk).getValueKind() + "\n");
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
