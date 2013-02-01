/*******************************************************************************
 * Copyright (c) Oct 27, 2011 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.models.export;

import java.io.FileOutputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.util.CDOUtil;
import org.eclipse.emf.cdo.util.ObjectNotFoundException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.models.export.internal.ExportActivator;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;

/**
 * A model exporter to Excel format, using the SXSSF functionality: </p> Files
 * will be flushed into the temp directory as determined when the JVM was
 * launched. This location can be changed with the property:
 * <code>-Djava.io.tempdir= [temp dir location]</code>
 * 
 * @see <a href="http://poi.apache.org/spreadsheet/how-to.html#sxssf">Apache POI
 *      SXSSF</a>
 * 
 * @author Christophe Bouhier
 */
public class MasterDataExporterRevenge_sxssf {

	private IDataProvider dataProvider;
	private EPackage[] ePackages;

	private static final int INITIAL_CACHED_ROWS = 100;

	/** Our cache */
	private Map<EClass, List<EObject>> cache = Maps.newHashMap();

	/** Keeps track of the work per EClass */
	@SuppressWarnings("unused")
	private Map<EClass, Integer> workMap = Maps.newHashMap();

	/** Our Excel Streamed Workbook **/
	// private final XSSFWorkbook workBook = new XSSFWorkbook();
	SXSSFWorkbook workBook = new SXSSFWorkbook(INITIAL_CACHED_ROWS);

	/**
	 * The export filer which is consulted for exporting classes and features
	 * from the packages
	 */
	private IExportFilter exportFilter;

	/** Our progress monitor */
	private IProgressMonitor monitor;

	public void process(FileOutputStream fileOut, IProgressMonitor monitor) {

		this.monitor = monitor;

		try {
			if (ExportActivator.DEBUG) {
				ExportActivator.TRACE.trace(
						ExportActivator.TRACE_EXPORT_OPTION, "Starting export");
				ExportActivator.TRACE.trace(
						ExportActivator.TRACE_EXPORT_OPTION,
						"Creating SXSSF Workbook model");

				// As we flush to temp, print the flush directory here.
				String property = System.getProperty("java.io.tmpdir");

				if (property != null && !property.isEmpty()) {
					ExportActivator.TRACE.trace(
							ExportActivator.TRACE_EXPORT_OPTION,
							"Stream rows will be flushed in the temp directory: "
									+ property);

					ExportActivator.TRACE.trace(
							ExportActivator.TRACE_EXPORT_OPTION,
							"in file: poi-sxxsf-sheet.xml");
				}
			}

			processPackages(ePackages);

			if (ExportActivator.DEBUG) {
				ExportActivator.TRACE.trace(
						ExportActivator.TRACE_EXPORT_OPTION, "Writing file");
			}

			workBook.write(fileOut);
			fileOut.close();
		} catch (final Exception e) {
			if (ExportActivator.DEBUG) {
				ExportActivator.TRACE.trace(
						ExportActivator.TRACE_EXPORT_OPTION,
						"Export exception", e);
			}
			throw new IllegalStateException(e);
		} finally {
			workBook.dispose();
		}
	}

	private void processPackages(EPackage[] ePackages) {

		if (exportFilter == null) {
			// bail it's mandatory for now.
			return;
		}

		final List<EClassifier> alphabetOrderedClassesFor = exportFilter
				.alphabetOrderedNonFilteredClassesFor(ePackages);

		int classWork = alphabetOrderedClassesFor.size();
		int totalWork = classWork * 2 + 10;

		// create a cache.
		SubMonitor subMon = SubMonitor.convert(monitor, totalWork);

		SubMonitor buildCacheMon = subMon.newChild(10);
		subMon.setTaskName("building Cache");
		buildCache(alphabetOrderedClassesFor);
		buildCacheMon.worked(10);

		// process the attributes for each classifier.
		SubMonitor processAttribMon = subMon.newChild(classWork);
		processAttribMon.setTaskName("Processing attribute sheets");
		for (EClassifier eClassifier : alphabetOrderedClassesFor) {
			processAttributeClassifier(eClassifier);
			processAttribMon.worked(1);
		}

		// process the references for each classifier.
		SubMonitor processMultiRefsMon = subMon.newChild(classWork);
		processMultiRefsMon.setTaskName("Processing reference sheets");
		for (EClassifier eClassifier : alphabetOrderedClassesFor) {
			processMultiRefClassifier(eClassifier);
			processMultiRefsMon.worked(1);
		}
	}

	/*
	 * Populate a cache.
	 */
	private int buildCache(List<EClassifier> alphabetOrderedClassesFor) {

		int totalWork = 0;

		if (ExportActivator.DEBUG) {
			ExportActivator.TRACE.trace(ExportActivator.TRACE_EXPORT_OPTION,
					"Building cache for classifiers:");
		}

		for (EClassifier eClassifier : alphabetOrderedClassesFor) {

			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				if (ExportActivator.DEBUG) {
					ExportActivator.TRACE.trace(
							ExportActivator.TRACE_EXPORT_OPTION, "-- EClass: "
									+ eClass.getName());
				}
				// Handle - Non-direct resources in the export properly.
				if (eClassifier == LibraryPackage.Literals.NET_XRESOURCE) {
					// all resources for
					{
						List<Resource> resources = dataProvider
								.getResources("/Node_");
						for (Resource r : resources) {
							totalWork += cacheForResource(r);
						}
					}
					{
						List<Resource> resources = dataProvider
								.getResources("/NodeType_");
						for (Resource r : resources) {
							totalWork += cacheForResource(r);
						}
					}

				} else {
					Resource resource = null;

					// For some classes we should use the super type to get the
					// resource.
					final EList<EClass> eAllSuperTypes = eClass
							.getEAllSuperTypes();
					if (eAllSuperTypes.contains(SchedulingPackage.Literals.JOB)) {
						int indexOf = eAllSuperTypes
								.indexOf(SchedulingPackage.Literals.JOB);
						final EClass eClassJob = eAllSuperTypes.get(indexOf);
						resource = dataProvider.getResource(eClassJob);

					} else {
						resource = dataProvider.getResource(eClass);
					}

					if (resource != null) {
						totalWork += cacheForResource(resource);
					}
				}
			}
		}
		if (ExportActivator.DEBUG) {
			ExportActivator.TRACE.trace(ExportActivator.TRACE_EXPORT_OPTION,
					"Done, building cache for classifiers.");
		}
		return totalWork;
	}

	/**
	 * Cache objects in this resource. objects with a class in the set export
	 * filter are pruned.
	 * 
	 * 
	 * @param resource
	 */
	private int cacheForResource(Resource resource) {

		int resourceWork = 0;

		if (resource != null && resource.getContents().size() > 0) {
			final TreeIterator<EObject> allContents = resource.getAllContents();
			while (allContents.hasNext()) {

				final EObject closureObject;
				try {
					closureObject = allContents.next();
				} catch (ObjectNotFoundException onfe) {
					if (ExportActivator.DEBUG) {
						ExportActivator.TRACE.trace(
								ExportActivator.TRACE_EXPORT_OPTION,
								"-- skipping not found objec with ID: "
										+ onfe.getID(), onfe);
					}
					continue;
				}

				final EClass objectClass = closureObject.eClass();

				// Make sure we don't cache closure objects which are dynamic.
				if (exportFilter.shouldFilterObject(objectClass)) {
					// prune all sub objects.
					allContents.prune();
					if (ExportActivator.DEBUG) {
						ExportActivator.TRACE.trace(
								ExportActivator.TRACE_EXPORT_OPTION,
								"-- skipping & pruning nested object EClass: "
										+ objectClass.getName());
					}
					continue;
				}

				final List<EObject> currentForClass;
				if (cache.containsKey(objectClass)) {
					currentForClass = Lists
							.newArrayList(cache.get(objectClass));
					// We could have duplicates, if the resource holds all
					// objects from a super class. I.e. Job EClass.
					if (!currentForClass.contains(closureObject)) {
						currentForClass.add(closureObject);
						cache.put(objectClass, currentForClass);
						resourceWork++;
					}
				} else {
					currentForClass = Lists.newArrayList();
					currentForClass.add(closureObject);
					cache.put(objectClass, currentForClass);
					resourceWork++;
				}

				if (ExportActivator.DEBUG) {
					ExportActivator.TRACE.trace(
							ExportActivator.TRACE_EXPORT_OPTION,
							"-- Added cache entry for type: "
									+ objectClass.getName() + " , entry: "
									+ closureObject);
				}

			}
		}
		return resourceWork;
	}

	private void processAttributeClassifier(EClassifier eClassifier) {
		if (ExportActivator.DEBUG) {
			ExportActivator.TRACE.trace(ExportActivator.TRACE_EXPORT_OPTION,
					"Start processing attributes");
		}

		if (eClassifier instanceof EClass) {
			// MARKER => Submonitor for processing attribute sheet.s.

			processAttributesClass((EClass) eClassifier);
		}
	}

	private void processMultiRefClassifier(EClassifier eClassifier) {
		if (ExportActivator.DEBUG) {
			ExportActivator.TRACE.trace(ExportActivator.TRACE_EXPORT_OPTION,
					"Start processing multi references for classifier:"
							+ eClassifier.getName());
		}
		if (eClassifier instanceof EClass) {
			// MARKER => Submonitor for processing multiref sheet.
			// We however don't have the number multi-ERefs?
			processMultiRefClass((EClass) eClassifier);
		}
	}

	private void processAttributesClass(EClass eClass) {

		if (ExportActivator.DEBUG) {
			ExportActivator.TRACE.trace(ExportActivator.TRACE_EXPORT_OPTION,
					"Outputing attributes sheet for: " + eClass.getName()
							+ " in package: " + eClass.getEPackage().getName());
		}
		final Sheet sheet = _generateAttributeWorksheet(eClass);

		// output the ID column.
		_generateID(sheet);

		// output all attributes columns.
		for (EAttribute eAttribute : filterAttributes(eClass)) {
			if (ExportActivator.DEBUG) {
				ExportActivator.TRACE.trace(
						ExportActivator.TRACE_EXPORT_OPTION, "-- EAttribute: "
								+ eAttribute.getName());
			}
			processAttribute(eAttribute, sheet);
		}

		// output all single-reference columns.
		for (EReference eReference : eClass.getEAllReferences()) {
			if (!eReference.isMany()) {
				if (ExportActivator.DEBUG) {
					ExportActivator.TRACE.trace(
							ExportActivator.TRACE_EXPORT_OPTION,
							"-- EReference: " + eReference.getName());
				}
				processReference(eReference, sheet);
			}
		}
		// Process the actual values here, get the EOBjects from the cache
		// first.
		final List<EObject> data = contextObjectsForClass(eClass);

		processAttributeData(data, sheet);

	}

	private void processMultiRefClass(EClass eClass) {
		List<EReference> multiRefs = this.filterMultiRefs(eClass);
		if (multiRefs.size() > 0) {
			Sheet sheet = _generateRefsWorksheet(eClass);
			_generateMultiReferenceSource(eClass, sheet);
			for (EReference eReference : multiRefs) {
				if (ExportActivator.DEBUG) {
					ExportActivator.TRACE.trace(null, "-- EReference: "
							+ eReference.getName());
				}
				processMultiReference(eReference, sheet);
			}

			if (ExportActivator.DEBUG) {
				ExportActivator.TRACE.trace(null,
						"--  processing multi reference data for classifier:"
								+ eClass.getName());
			}
			// Process the actual values here.
			List<EObject> data = contextObjectsForClass(eClass);
			processMultiRefData(data, sheet);
		}
	}

	private void processReference(EReference eReference, Sheet sheet) {
		_generateCell(eReference, sheet);

	}

	private void processAttribute(EAttribute eAttribute, Sheet sheet) {
		_generateCell(eAttribute, sheet);
	}

	private void processMultiReference(EReference eReference, Sheet sheet) {
		_generateMultiRefCell(eReference, sheet);

	}

	private void processAttributeData(List<EObject> data, Sheet sheet) {

		if (ExportActivator.DEBUG) {
			ExportActivator.TRACE.trace(ExportActivator.TRACE_EXPORT_OPTION,
					"Exporting data: ");
		}

		// We assume the attribute order for each data object.
		int objectCount = 2;
		for (EObject dataObject : data) {
			// Generate the Identifier.
			_generateIDCell(dataObject, objectCount, 0, sheet);

			int attributeCount = 1;
			for (EAttribute eAttribute : this.filterAttributes(dataObject
					.eClass())) {

				Object value = dataObject.eGet(eAttribute);

				// For many() attributes, where the list values are of type
				// String,
				// export as one string separated with newline. (\n).
				// http://work.netxforge.com/issues/311
				if (eAttribute.isMany() && value instanceof EList<?>) {
					EList<?> list = (EList<?>) value;
					if (!list.isEmpty()) {
						// gamble we are of type string.
						final StringBuffer sb = new StringBuffer();
						for (Object o : list) {
							if (o instanceof String) {
								sb.append((String) o);
							}
						}
						value = sb.toString();
					} else {
						value = "";
					}
				}

				if (ExportActivator.DEBUG) {
					ExportActivator.TRACE.trace(
							ExportActivator.TRACE_EXPORT_OPTION,
							"-- EObject (value):" + value);
				}
				_generateDataCell(value, objectCount, attributeCount, sheet);
				attributeCount++;
			}

			for (EReference eReference : dataObject.eClass()
					.getEAllReferences()) {

				if (ExportActivator.DEBUG) {
					ExportActivator.TRACE.trace(null, "-- EReference: "
							+ eReference.getName());
				}
				// Export Check single reference which are set only.
				if (!eReference.isMany()) {
					// Clean-external references, which might have corrupted the
					// DB in the past, skipp this ref, when cleaned.
					// bug ID?
					if (!cleanRef(dataObject, eReference)) {

						final Object refObject = dataObject.eGet(eReference);
						String identifier = "";
						if (refObject != null) {
							identifier = this
									.contextObjectsIdentifier((EObject) refObject);

						}
						_generateDataCell(identifier, objectCount,
								attributeCount, sheet);
						attributeCount++;
					}
				}
			}
			objectCount++;
		}
	}

	private void processMultiRefData(List<EObject> data, Sheet sheet) {
		// We assume the attribute order for each data object.
		int objectCount = 2;
		for (EObject dataObject : data) {
			if (ExportActivator.DEBUG) {
				ExportActivator.TRACE.trace(
						ExportActivator.TRACE_EXPORT_OPTION, "-- EObject:"
								+ dataObject);
			}
			int referenceCount = 1;
			for (EReference eReference : this.filterMultiRefs(dataObject
					.eClass())) {

				if (ExportActivator.DEBUG) {
					ExportActivator.TRACE.trace(
							ExportActivator.TRACE_EXPORT_OPTION,
							"-- EReference:" + eReference);
				}

				// Clean external references for this multi-valued ref.

				cleanRef(dataObject, eReference);

				final Object collection = dataObject.eGet(eReference);
				int rowCount = objectCount;

				if (collection instanceof List<?>) {

					if (ExportActivator.DEBUG) {
						ExportActivator.TRACE.trace(
								ExportActivator.TRACE_EXPORT_OPTION,
								"-- EReference:" + eReference
										+ " collection size (After clean): "
										+ ((List<?>) collection).size());
					}

					for (Object refObject : (List<?>) collection) {
						String identifier = this
								.contextObjectsIdentifier(dataObject);

						_generateDataCell(identifier, rowCount, 0, sheet);

						String refIdentifier = this
								.contextObjectsIdentifier((EObject) refObject);
						_generateDataCell(refIdentifier, rowCount,
								referenceCount, sheet);
						rowCount++;
					}
				}
				referenceCount++;
				objectCount = rowCount;
			}
		}
	}

	// Context setters.
	public void setDataProvider(IDataProvider dataProvider) {
		this.dataProvider = dataProvider;
	}

	public void setPackagesToExport(EPackage[] ePackages) {
		this.ePackages = ePackages;
	}

	private List<EObject> contextObjectsForClass(EClass eClass) {
		final List<EObject> allObjectsForClass = fromCache(eClass);
		return allObjectsForClass;
	}

	private List<EObject> fromCache(EClass eClass) {
		if (cache.containsKey(eClass)) {
			return cache.get(eClass);
		} else {
			return Collections.emptyList();
		}
	}

	private String contextObjectsIdentifier(EObject eo) {
		if (eo instanceof CDOObject) {
			return ((CDOObject) eo).cdoID().toString();
		}
		return null;
	}

	private void _generateID(Sheet sheet) {
		// Generate name.
		{
			// Style, cell color.
			CellStyle attributeStyle = workBook.createCellStyle();
			attributeStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT
					.getIndex());
			attributeStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

			// Style, font
			Font attributeFont = workBook.createFont();
			attributeFont.setFontName("Verdana");
			attributeFont.setColor(IndexedColors.BLUE.getIndex());
			attributeStyle.setFont(attributeFont);

			// Style, border.
			attributeStyle.setBorderBottom(CellStyle.BORDER_MEDIUM);

			Row row = sheet.getRow(0);
			if (row == null) {
				row = sheet.createRow(0);
			}
			short lastCellNum = row.getLastCellNum();
			if (lastCellNum == -1) {
				lastCellNum = 0;
			}
			Cell cell = row.createCell(lastCellNum);
			cell.setCellValue("ID");
			cell.setCellStyle(attributeStyle);
		}
		// Generate type
		{

			CellStyle typeStyle = workBook.createCellStyle();
			typeStyle.setBorderBottom(CellStyle.BORDER_MEDIUM);

			Row row = sheet.getRow(1);
			if (row == null) {
				row = sheet.createRow(1);
			}
			short lastCellNum = row.getLastCellNum();
			if (lastCellNum == -1) {
				lastCellNum = 0;
			}
			Cell cell = row.createCell(lastCellNum);
			cell.setCellStyle(typeStyle);
		}
	}

	// POI SECTION.
	private Sheet _generateAttributeWorksheet(EClass eClass) {
		return workBook.createSheet(eClass.getName());
	}

	private Sheet _generateRefsWorksheet(EClass eClass) {
		return workBook.createSheet(eClass.getName() + "_refs");
	}

	private void _generateCell(EAttribute eAttribute, Sheet sheet) {

		// Generate name.
		{
			// Style, cell color.
			CellStyle attributeStyle = workBook.createCellStyle();
			attributeStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT
					.getIndex());
			attributeStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

			// Style, font
			Font attributeFont = workBook.createFont();
			attributeFont.setFontName("Verdana");
			attributeFont.setColor(IndexedColors.BLUE.getIndex());
			attributeStyle.setFont(attributeFont);

			// Style, border.
			attributeStyle.setBorderBottom(CellStyle.BORDER_MEDIUM);

			Row row = sheet.getRow(0);
			if (row == null) {
				row = sheet.createRow(0);
			}
			short lastCellNum = row.getLastCellNum();
			if (lastCellNum == -1) {
				lastCellNum = 0;
			}
			Cell cell = row.createCell(lastCellNum);
			cell.setCellValue(StringUtils.capitalize(eAttribute.getName()));
			cell.setCellStyle(attributeStyle);
		}
		// Generate type
		{

			CellStyle typeStyle = workBook.createCellStyle();
			typeStyle.setBorderBottom(CellStyle.BORDER_MEDIUM);

			Row row = sheet.getRow(1);
			if (row == null) {
				row = sheet.createRow(1);
			}
			short lastCellNum = row.getLastCellNum();
			if (lastCellNum == -1) {
				lastCellNum = 0;
			}
			Cell cell = row.createCell(lastCellNum);
			cell.setCellValue(eAttribute.getEType().getName());
			cell.setCellStyle(typeStyle);
		}
	}

	private void _generateCell(EReference eReference, Sheet sheet) {

		// Generate name.
		{
			// Style, cell color.
			CellStyle referenceStyle = workBook.createCellStyle();
			referenceStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT
					.getIndex());
			referenceStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

			// Style, font
			Font referenceFont = workBook.createFont();
			referenceFont.setFontName("Verdana");
			referenceFont.setColor(IndexedColors.DARK_RED.getIndex());
			referenceStyle.setFont(referenceFont);

			// Style, border.
			referenceStyle.setBorderBottom(CellStyle.BORDER_MEDIUM);

			Row row = sheet.getRow(0);
			if (row == null) {
				row = sheet.createRow(0);
			}
			short lastCellNum = row.getLastCellNum();
			if (lastCellNum == -1) {
				lastCellNum = 0;
			}
			Cell cell = row.createCell(lastCellNum);
			cell.setCellValue(StringUtils.capitalize(eReference.getName()));
			cell.setCellStyle(referenceStyle);
		}
		// Generate type
		{

			CellStyle typeStyle = workBook.createCellStyle();
			typeStyle.setBorderBottom(CellStyle.BORDER_MEDIUM);

			Row row = sheet.getRow(1);
			if (row == null) {
				row = sheet.createRow(1);
			}
			short lastCellNum = row.getLastCellNum();
			if (lastCellNum == -1) {
				lastCellNum = 0;
			}
			Cell cell = row.createCell(lastCellNum);
			cell.setCellValue(eReference.getEType().getName());
			cell.setCellStyle(typeStyle);
		}
	}

	private void _generateMultiReferenceSource(EClass eClass, Sheet sheet) {
		// Generate name.
		{
			// Style, cell color.
			CellStyle referenceStyle = workBook.createCellStyle();
			referenceStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT
					.getIndex());
			referenceStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

			// Style, font
			Font referenceFont = workBook.createFont();
			referenceFont.setFontName("Verdana");
			referenceFont.setColor(IndexedColors.DARK_RED.getIndex());
			referenceStyle.setFont(referenceFont);

			// Style, border.
			referenceStyle.setBorderBottom(CellStyle.BORDER_MEDIUM);

			Row row = sheet.getRow(0);
			if (row == null) {
				row = sheet.createRow(0);
			}
			short lastCellNum = row.getLastCellNum();
			if (lastCellNum == -1) {
				lastCellNum = 0;
			}
			Cell cell = row.createCell(lastCellNum);
			cell.setCellValue(StringUtils.capitalize(eClass.getName()));
			cell.setCellStyle(referenceStyle);
		}
		// Generate type
		{

			CellStyle typeStyle = workBook.createCellStyle();
			typeStyle.setBorderBottom(CellStyle.BORDER_MEDIUM);

			Row row = sheet.getRow(1);
			if (row == null) {
				row = sheet.createRow(1);
			}
			short lastCellNum = row.getLastCellNum();
			if (lastCellNum == -1) {
				lastCellNum = 0;
			}
			Cell cell = row.createCell(lastCellNum);
			cell.setCellStyle(typeStyle);
		}
	}

	private void _generateMultiRefCell(EReference eReference, Sheet sheet) {

		// Generate name.
		{
			// Style, cell color.
			CellStyle referenceStyle = workBook.createCellStyle();
			referenceStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT
					.getIndex());
			referenceStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

			// Style, font
			Font referenceFont = workBook.createFont();
			referenceFont.setFontName("Verdana");
			referenceFont.setColor(IndexedColors.DARK_RED.getIndex());
			referenceStyle.setFont(referenceFont);

			// Style, border.
			referenceStyle.setBorderBottom(CellStyle.BORDER_MEDIUM);

			Row row = sheet.getRow(0);
			if (row == null) {
				row = sheet.createRow(0);
			}
			short lastCellNum = row.getLastCellNum();
			if (lastCellNum == -1) {
				lastCellNum = 0;
			}
			Cell cell = row.createCell(lastCellNum);
			cell.setCellValue(StringUtils.capitalize(eReference.getName()));
			cell.setCellStyle(referenceStyle);
		}
		// Generate type
		{

			CellStyle typeStyle = workBook.createCellStyle();
			typeStyle.setBorderBottom(CellStyle.BORDER_MEDIUM);

			Row row = sheet.getRow(1);
			if (row == null) {
				row = sheet.createRow(1);
			}
			short lastCellNum = row.getLastCellNum();
			if (lastCellNum == -1) {
				lastCellNum = 0;
			}
			Cell cell = row.createCell(lastCellNum);
			cell.setCellValue(eReference.getEType().getName());
			cell.setCellStyle(typeStyle);
		}
	}

	private void _generateIDCell(EObject dataObject, int rowCount,
			int cellCount, Sheet sheet) {
		Row row = sheet.getRow(rowCount);
		if (row == null) {
			row = sheet.createRow(rowCount);
		}
		Cell cell = row.createCell(cellCount);
		if (dataObject != null && dataObject instanceof CDOObject) {
			// What if we deal with a detached object?
			cell.setCellValue(((CDOObject) dataObject).cdoID().toString());
		}
	}

	private void _generateDataCell(Object value, int rowCount, int cellCount,
			Sheet sheet) {
		Row row = sheet.getRow(rowCount);
		if (row == null) {
			row = sheet.createRow(rowCount);
		}
		Cell cell = row.createCell(cellCount);
		if (value != null) {
			cell.setCellValue(value.toString());
		}

	}

	public List<EReference> filterMultiRefs(EClass eClass) {
		List<EReference> multiRefs = Lists.newArrayList();
		for (EReference eReference : eClass.getEAllReferences()) {
			if (eReference.isMany() && !eReference.isDerived()) {
				multiRefs.add(eReference);
			}
		}
		return multiRefs;
	}

	public List<EAttribute> filterAttributes(EClass eClass) {
		List<EAttribute> nonDerivedAttributes = Lists.newArrayList();
		for (EAttribute eAttribute : eClass.getEAllAttributes()) {
			if (!eAttribute.isDerived()) {
				nonDerivedAttributes.add(eAttribute);
			}
		}
		return nonDerivedAttributes;
	}

	public void setExportFilter(IExportFilter exportFilter) {
		this.exportFilter = exportFilter;
	}

	/**
	 * Clean invalid (External) references from an object with the provided
	 * {@link EReference reference}. If the reference is multi-valued, all
	 * referenced objects are checked.
	 * 
	 * @param objectToCheck
	 * @param eRef
	 */
	private boolean cleanRef(EObject objectToCheck, EReference eRef) {

		boolean cleaned = false;

		if (eRef.isMany()) {
			Object eGet = objectToCheck.eGet(eRef);

			if (eGet == null) {
				return cleaned;
			}

			@SuppressWarnings("unchecked")
			final List<? extends EObject> collection = (List<? extends EObject>) eGet;
			if (ExportActivator.DEBUG) {
				ExportActivator.TRACE.trace(
						ExportActivator.TRACE_EXPORT_OPTION,
						"-- checking external ref from object" + objectToCheck
								+ "with reference" + eRef + " collection size:"
								+ collection.size());
			}

			// final List<EObject> toRemove = Lists.newArrayList();

			for (int i = 0; i < collection.size(); i++) {

				try {
					collection.get(i);

				} catch (NullPointerException npe) {
					// Clean-it.
					CDOUtil.cleanStaleReference(objectToCheck, eRef, i);

				}

				// if (isExternal(eo, eRef)) {
				// if (ExportActivator.DEBUG) {
				// ExportActivator.TRACE.trace(
				// ExportActivator.TRACE_EXPORT_OPTION,
				// "-- cleaning external ref from object" + eo
				// + "with reference" + eRef);
				// }
				//
				// int index = collection.indexOf(eo);
				// toRemove.add(collection.get(index));
				// }
			}

			// for (EObject eo : toRemove) {
			// collection.remove(eo);
			// }

		} else {
			// final EObject eo = (EObject) objectToCheck.eGet(eRef);
			if (isExternal(objectToCheck, eRef)) {
				if (ExportActivator.DEBUG) {
					ExportActivator.TRACE.trace(
							ExportActivator.TRACE_EXPORT_OPTION,
							"-- cleaning external ref from object"
									+ objectToCheck + "with reference" + eRef);
					;
				}
				CDOUtil.cleanStaleReference(objectToCheck, eRef);
				cleaned = true;
			}
		}
		return cleaned;
	}

	// Check if the object is external.
	private boolean isExternal(EObject eo, EReference eRef) {
		if (eo instanceof CDOObject) {
			// if(eRef ==
			// OperatorsPackage.Literals.NODE__ORIGINAL_NODE_TYPE_REF){
			// System.out.println("break here!");
			// }
			//
			// CDOObject cdoObject = CDOUtil.getCDOObject(eo);
			// if (cdoObject != null && cdoObject.cdoID() != null) {
			// return cdoObject.cdoID().isExternal();
			// } else {
			// return true;
			// }
			try {
				eo.eGet(eRef);
			} catch (Exception e) {
				return true;
			}
		}
		return false;

	}

}
