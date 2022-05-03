package com.HrmCompleteAutomation;

import org.testng.annotations.Test;

import OrangeHrm.TestCasesOrangeHRM.ExcelUtil;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Dataprovider {
  
  @Test(dataProvider="ExcelDataProvider")
  public void login(Object username,Object password) {
	  
	  System.out.println(username+"-"+password);
  }
  @DataProvider(name="ExcelDataProvider")
  public Object[][] getData() {
    return ExcelUtil.getExcelData()
  }

  }

