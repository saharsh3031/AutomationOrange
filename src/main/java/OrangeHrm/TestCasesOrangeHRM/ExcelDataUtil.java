package OrangeHrm.TestCasesOrangeHRM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataUtil {

	static Workbook wb;
	static Sheet sheet;
	static Row row;

	private static void getWorkBookInstance(String filePath, FileInputStream input) throws IOException {

		String extention = filePath.substring(filePath.indexOf("."));

		if (extention.equals(".xlsx")) {

			wb = new XSSFWorkbook(input);
		} else if(extention.equals("xlx")) {
			wb = new HSSFWorkbook(input);
		}
	}

	public static Object[][] getExcelData(String filePath, String sheetName) throws IOException {

//		String filePath = "C:\\Users\\Sayu\\Desktop\\New folder\\loginCredential.xlsx";

		FileInputStream input = new FileInputStream(filePath);
		getWorkBookInstance(filePath, input);

		sheet = wb.getSheet(sheetName); // wb.getSheetAt(indexOfSheet)

		int totalRows = sheet.getLastRowNum();
		row = sheet.getRow(0);

		int totalColumn = row.getPhysicalNumberOfCells();
		System.out.println("Total Rows-:" + totalRows + "  Total Columns-:" + totalColumn);

		Object[][] excelObject = new Object[totalRows + 1][totalColumn];

		for (int i = 1; i <= totalRows; i++) {

			for (int j = 0; j < totalColumn; j++) {

				Cell cell = sheet.getRow(i).getCell(j);
				excelObject[i][j] = Objects.isNull(cell) ? null : getCellData(cell);
			}
			
		}
		wb.close();
		return excelObject;
	}

	private static Object getCellData(Cell cell) {
			
			switch (cell.getCellType()) {
			case NUMERIC:
				return cell.getNumericCellValue();
			case STRING:
				return cell.getStringCellValue();
			case BLANK:
				return null;
			case BOOLEAN:
				return cell.getBooleanCellValue();
			default :
				return " ";
		}
	}
public static void setExcelData(String filePath, String sheetName,int rowNm, int colNm , String value ) throws IOException {
	
	FileInputStream input = new FileInputStream(filePath);
	
	getWorkBookInstance(filePath, input);
	 if(Objects.isNull(wb.getSheet(sheetName))) {
		 
		 sheet=wb.createSheet(sheetName);
		 
	 }
	 else
		 sheet=wb.getSheet(sheetName);
	 Row row = sheet.createRow(rowNm);
	 row.createCell(colNm).setCellValue(value);
	 FileOutputStream output = new FileOutputStream(filePath);
	 wb.write(output);
	 wb.close();
}
}


















