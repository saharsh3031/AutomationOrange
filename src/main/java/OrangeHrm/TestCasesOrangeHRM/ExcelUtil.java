package OrangeHrm.TestCasesOrangeHRM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	static Workbook wb;
	static Row row;
	static int totalRows;
	static int totalColum;
	public static Object username;
	public static Object password;

	public static Object[][] getExcelData() throws IOException {

		String filePath = "C:\\Users\\Sayu\\Desktop\\New folder\\loginCredential.xlsx";

		FileInputStream input = new FileInputStream(filePath);

		String extension = filePath.substring(filePath.indexOf("."));

		if (extension.equals(".xlsx")) {

			wb = new XSSFWorkbook(input);

		}

		else if (extension.equals(".xlx")) {

			wb = new HSSFWorkbook(input);

		}
		Sheet sheet = wb.getSheet("Sheet1");
		totalRows = sheet.getLastRowNum();
		row = sheet.getRow(0);
		totalColum = row.getPhysicalNumberOfCells();
		System.out.println("Total no of rows:-" + totalRows + "Total no of columc" + totalColum);
		Object[][] excelobject = new Object[totalRows][totalColum];

		for (int i = 1; i < totalRows; i++) {

			row = sheet.getRow(i);

			for (int j = 0; j < totalColum; j++) {
				Cell cell = row.getCell(j);
				switch (cell.getCellType()) {
				case NUMERIC:
					excelobject[i][j] = cell.getNumericCellValue();
					break;
				case STRING:
					excelobject[i][j] = cell.getStringCellValue();
					break;
				case BLANK:
					excelobject[i][j] = null;
					break;
				case BOOLEAN:
					excelobject[i][j] = cell.getBooleanCellValue();
					break;
				case ERROR:
					break;
				case FORMULA:
					break;
				case _NONE:
					break;
				}

//				if (j == 0) {
//					username = excelobject[i][j];
////				System.out.println(username);
//
//				} else {
//					password = (String) excelobject[i][j];
////				System.out.println(password);
//
//				}
				System.out.print(excelobject[i][j]+"  ");
			}
		System.out.println( );
		}
		return excelobject;

	}

}
