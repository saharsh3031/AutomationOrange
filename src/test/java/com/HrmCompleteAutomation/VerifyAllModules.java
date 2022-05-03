package com.HrmCompleteAutomation;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.automationpage.Admin;
import com.automationpage.DatePicker;
import com.automationpage.LoginPage;
import com.automationpage.PimModule;

import OrangeHrm.TestCasesOrangeHRM.BaseClass;
import OrangeHrm.TestCasesOrangeHRM.PropertyHandling;

public class VerifyAllModules extends BaseClass {
	PropertyHandling prop;
	LoginPage loginPage;
	PimModule pimModule ;
	Admin admin;
	DatePicker leave;
	String firstName = generateRandomString(5);
	String lastName = generateRandomString(5);
	String username = generateRandomString(6);
	String paswrd = generateRandomString(9);
	
	
	
  @Test(priority=1)
  public void loginOrangeHrm() throws IOException {
	  
	  System.out.println("Succesfuly Started loginOrangeHrm");
	  prop = new PropertyHandling();
	  getBrowserInstance(prop.getProperty("browser"));
	  loginPage = new LoginPage();
	  driver.navigate().to(prop.getProperty("orangeHrmUrl"));
	  loginPage.Login(prop.getProperty("orangeHrmUsername"), prop.getProperty("orangeHrmPaasword"));
  }
  @Test(priority=2)
  
  public void addEmployee() throws InterruptedException {
	  System.out.println("Succesfuly Started addEmployee");
	  pimModule = new PimModule();
	  pimModule.pimModule.click();
		pimModule.addButton.click();
		
		driver.findElement(pimModule.firstName).sendKeys(firstName);
		driver.findElement(pimModule.lastName).sendKeys(lastName);
		driver.findElement(pimModule.checkBox).click();
		driver.findElement(pimModule.username).sendKeys(username);
//		String paswrd = generateRandomString(9);
		driver.findElement(pimModule.password).sendKeys(paswrd);
		driver.findElement(pimModule.confirmPassword).sendKeys(paswrd);
		pimModule.save.click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
  }
  @Test(priority=3)
  public void verifyEmployee() throws InterruptedException {
	  System.out.println("Succesfuly Started verifyEmployee");
//	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  Thread.sleep(10000);
	  pimModule.pimModule.click();
		driver.findElement(pimModule.searchEmployyename).click();
		driver.findElement(pimModule.employyeName).sendKeys(firstName);
		driver.findElement(pimModule.id).click();
		driver.findElement(pimModule.searchButton).click();  
  }
  
  @Test(priority=4)
  public void verifyUser() throws InterruptedException
  {
	  System.out.println("Succesfuly Started verifyUser");
	  Thread.sleep(10000);
	  driver.findElement(admin.admin).click();
	 
	  Thread.sleep(10000);
	  driver.findElement(admin.searchUsername).sendKeys(username);
	  driver.findElement(admin.userRole).click();
	  driver.findElement(pimModule.searchButton).click();
  }
  @Test(priority=5)
  public void assingLeave() {
	  System.out.println("-------------");
	  leave.leave.click();
	  driver.findElement(leave.assingLeave).click();
	  driver.findElement(leave.employeeName).sendKeys(firstName+" "+lastName);
	  
	  Select leaveType = new Select(driver.findElement(leave.leaveType));
	  leaveType.selectByIndex(3);
	  driver.findElement(leave.calfromDate).sendKeys("2022-04-16");
	  
	  driver.findElement(leave.calfromDate).sendKeys("2022-04-18");
	  
	  driver.findElement(leave.assingbutton).click();
	  
  
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
