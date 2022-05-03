package com.HrmCompleteAutomation;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automationpage.LoginPage;

import OrangeHrm.TestCasesOrangeHRM.BaseClass;
import OrangeHrm.TestCasesOrangeHRM.ExcelUtil;
import OrangeHrm.TestCasesOrangeHRM.PropertyHandling;

public class VerifyLoginWithExcel extends BaseClass {

	PropertyHandling prop;
	LoginPage loginPage;
	ExcelUtil excel;
	static String username ;
	static String password ;

	@BeforeClass
	public void beforeclass() throws IOException {

		prop = new PropertyHandling();

		getBrowserInstance(prop.getProperty("browser"));
		driver.navigate().to(prop.getProperty("orangeHrmUrl"));
	}

	@Test
	public void loginVerification() throws IOException {
		loginPage = new LoginPage();
		excel = new ExcelUtil();
		Object[][] data = ExcelUtil.getExcelData();
		System.out.println("data size is " +data.length);
		
		for (int i = 1; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {

				if (j == 0) {
					username = data[i][j].toString();
					System.out.println(username);

				} else {
					password =  data[i][j].toString();
					System.out.println(password);
					loginPage.Login(username, password);
					
					
					
					
					
					
					
					if(username!="Admin" || password!="admin123" ) {
				        String errormessge=driver.findElement(By.xpath("//span[text()='Invalid credentials']")).getText();
						System.out.println(errormessge);
						   boolean invalidmassage= driver.findElement(By.xpath("//span[text()='Invalid credentials']")).isEnabled();
							System.out.println(invalidmassage);
						}
						else {
							   driver.findElement(By.xpath("//a[contains(text(),'Welcome')]")).click();
							     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
							     driver.findElement(By.xpath("//a[text()='Logout']")).click();
									  WebElement invalidmassage1= driver.findElement(By.xpath("//span[text()='Invalid credentials']"));
									  System.out.println(invalidmassage1.isEnabled());
									 
						}
				}
				
			}
//			loginPage.Login(username, password);

		}
	}
	@AfterClass
	public void afterclass() {
		
//		driver.quit();
	}
	

}
