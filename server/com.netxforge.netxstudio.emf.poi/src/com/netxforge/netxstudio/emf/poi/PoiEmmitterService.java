package com.netxforge.netxstudio.emf.poi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

/**
 * The POI emmitter writes EMF Objects.
 * 
 * @author dzonekl
 * 
 */
public class PoiEmmitterService {

	public static final PoiEmmitterService INSTANCE = new PoiEmmitterService();

	final ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
	final AdapterFactoryContentProvider contentProvider = new AdapterFactoryContentProvider(
			adapterFactory);
	final AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(
			adapterFactory);

	public PoiEmmitterService() {
	}

	public Workbook createWorkbook() {
		return new Workbook[] { new HSSFWorkbook() }[0];
	}

	public Sheet createSheet(Workbook wb, String sheetName) {
		Sheet sheet = wb.createSheet(sheetName);
		return sheet;
	}

	public CellStyle h1(Workbook wb) {
		CellStyle s = this.createStyle(wb);
		Font font = wb.createFont();
		font.setFontHeightInPoints((short) 14);
		font.setBoldweight((short) 5);
		font.setFontName("Arial");
		s.setFont(font);
		return s;
	}

	public CellStyle h2(Workbook wb) {
		CellStyle s = this.createStyle(wb);
		Font font = wb.createFont();
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight((short) 3);
		font.setFontName("Arial");
		s.setFont(font);
		return s;
	}

	public CellStyle d(Workbook wb) {
		CreationHelper createHelper = wb.getCreationHelper();
		CellStyle s = wb.createCellStyle();
		s.setDataFormat(createHelper.createDataFormat()
				.getFormat("m/d/yy h:mm"));
		return s;
	}

	public CellStyle createStyle(Workbook wb) {
		return wb.createCellStyle();
	}

	protected Row createRow(Sheet sh, int rowIndex) {
		Row row = sh.createRow(rowIndex);
		return row;
	}

	protected Cell createCell(Row row, int cellIndex, Object value) {

		// cellIndex, can't be > 255.
		// TODO We need an adapter for the cell type.
		if (cellIndex < 255) {
			Cell cell = row.createCell(cellIndex);
			if (value instanceof String) {
				cell.setCellValue((String) value);
			}
			if (value instanceof Double) {
				cell.setCellValue((Double) value);
			}

			if (value instanceof Date) {
				cell.setCellValue((Date) value);
			}
			return cell;
		}else{
			System.out.println("row: " + row + " index: " + cellIndex);
			System.out.println("Cell not written");
		}
		return null;
	}

	public Workbook readWorkbook(InputStream inp) {
		try {
			Workbook wb = WorkbookFactory.create(inp);
			return wb;
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void writeWorkbook(Workbook wb, OutputStream out) {
		try {
			wb.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Row writeEmptyRow(Sheet sh) {
		int lastRow = sh.getLastRowNum();
		return createRow(sh, lastRow + 1);

	}

	/**
	 * Write an object in the sheet indented by <code>indent</code>.
	 * 
	 * @param sh
	 * @param indent
	 * @param o
	 */
	public Row writeRow(Sheet sh, Object o) {
		return writeRow(sh, o, 0, null);
	}

	public Row writeRow(Sheet sh, Object o, int indent) {
		return writeRow(sh, o, indent, null);
	}

	public Row writeRow(Sheet sh, Object o, int indent, CellStyle style) {

		// Each object has a row.
		int lastRow = sh.getLastRowNum();
		Row r = createRow(sh, lastRow + 1);
		// Create the header, we delegate to a provider.
		int cNum = r.getLastCellNum();
		Cell c = createCell(r, cNum == -1 ? indent : cNum,
				o instanceof EObject ? labelProvider.getText(o) : o);
		if (style != null)
			c.setCellStyle(style);
		return r;
	}

	public Cell writeCell(Row r, Object o) {
		return writeCell(r, o, null);
	}

	public Cell writeCell(Row r, Object o, CellStyle style) {

		int cNum = r.getLastCellNum();
		Cell c = createCell(r, cNum == -1 ? 0 : cNum,
				o instanceof EObject ? labelProvider.getText(o) : o);
		if (c != null & style != null)
			c.setCellStyle(style);
		return c;
	}

}
