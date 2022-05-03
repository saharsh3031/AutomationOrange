package com.automationpage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOrange {

	static Workbook wb;
	static Sheet sheet;
	static Row row;

	public static void getWorkBookInstance(String filePath, FileInputStream input) throws IOException {

		String extention = filePath.substring(filePath.indexOf("."));

		if (extention.equals(".xlsx")) {
			wb = new XSSFWorkbook(input);
		} else
			wb = new XSSFWorkbook(input);
	}

	public static Object[][] getExcelData(String filePath, String sheetName) throws IOException {

		FileInputStream input = new FileInputStream(filePath);
		getWorkBookInstance(filePath, input);

		sheet = wb.getSheet(sheetName);

		int totalRow = sheet.getLastRowNum();
		row = sheet.getRow(0);
		int totalClm = row.getPhysicalNumberOfCells();

		Object[][] excelObject = new Object[totalRow + 1][totalClm];

		System.out.println(totalRow + "   " + totalClm);

		for (int i = 1; i <= totalRow; i++) {
			for (int j = 0; j < totalClm; j++) {

				Cell cell = sheet.getRow(i).getCell(j);

				excelObject[i][j] = Objects.isNull(cell) ? null : getCellData(cell);
			}
		}
		wb.close();
		return excelObject;
	}

	public static Object getCellData(Cell cell) {

		switch (cell.getCellType()) {
		case NUMERIC:
			return cell.getNumericCellValue();
		case STRING:
			return cell.getStringCellValue();
		case BLANK:
			return null;
		case BOOLEAN:
			return cell.getBooleanCellValue();
		default:
			return " ";
		}
	}

	public static void setExcelData(String filePath, String sheetName, int rowNo, int colNo, String value)
			throws IOException {

		FileInputStream input = new FileInputStream(filePath);

		getWorkBookInstance(filePath, input);

		if (Objects.isNull(wb.getSheet(sheetName))) {
			sheet = wb.createSheet(sheetName);
		} else
			sheet = wb.getSheet(sheetName);

		if (Objects.isNull(sheet.getRow(rowNo))) {
			row = sheet.createRow(rowNo);
		}

		else {
			row = sheet.getRow(rowNo);
		}
		row.createCell(colNo).setCellValue(value);

		FileOutputStream output = new FileOutputStream(filePath);
		wb.write(output);
		wb.close();
	}

}
