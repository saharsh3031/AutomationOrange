package com.HrmCompleteAutomation;

import java.io.IOException;

import org.testng.annotations.Test;

import OrangeHrm.TestCasesOrangeHRM.ExcelDataUtil;
import OrangeHrm.TestCasesOrangeHRM.PropertyHandling;

public class ExcelAutomation {
	PropertyHandling prop;
	
	
	
	
	
	
  @Test
  public void excelfile() throws IOException {
	 String filepath = "C:\\Users\\Sayu\\Desktop\\New folder\\loginCredential.xlsx";
	  
	  ExcelDataUtil.setExcelData(filepath, "TestData", 0, 0, "Username1");
	  
	  Object[][] excelData= ExcelDataUtil.getExcelData(filepath, "Sheet1");
	  
	  
	  for (int i=0;i<excelData.length;i++) {
		  
		  
		  for(int j=0; i<excelData[i].length;j++) {
			  
			  System.out.println(excelData[i][j]);
		  }
	  }
	  
	  
  }
}
