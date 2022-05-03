package com.automationpage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import OrangeHrm.TestCasesOrangeHRM.BaseClass;

public class PimModule extends BaseClass {
	
	@FindBy(id="menu_pim_viewPimModule")
	public WebElement pimModule;

//	public By pimModule = By.id("menu_pim_viewPimModule");
	
	@FindBy(id="btnAdd")
	public WebElement addButton;
	
	@FindBy(id="btnSave")
	public WebElement save;
	
	
//	public By addEmployee = By.id("btnAdd");
	public By firstName = By.id("firstName");
	public By lastName = By.id("lastName");
	public By checkBox = By.id("chkLogin");
	public By username = By.id("user_name");
	public By password = By.id("user_password");
	public By confirmPassword = By.id("re_password");
	
//	public By save = By.id("btnSave");
	public By searchEmployyename = By.id("empsearch_employee_name_empName");
	public By employyeName = By.id("empsearch_employee_name_empName");
	public By id = By.id("empsearch_id");
	public By searchButton = By.id("searchBtn");

	public PimModule() throws InterruptedException {
		PageFactory.initElements(driver, this);
		
		
//		driver.findElement(pimModule).click();
//		driver.findElement(addEmployee).click();
//		driver.findElement(this.firstName).sendKeys(firstName);
//		driver.findElement(this.lastName).sendKeys(lastName);
//		driver.findElement(checkBox).click();
//		Thread.sleep(2000);
//		driver.findElement(this.username).sendKeys(username);
//		driver.findElement(password).sendKeys(str);
//		driver.findElement(confirmPassword).sendKeys(str);
//		driver.findElement(save).click();
//		Thread.sleep(2000);
//		driver.findElement(pimModule).click();
//		driver.findElement(searchEmployyename).click();
//		driver.findElement(employyeName).sendKeys(firstName);
////		Thread.sleep(1000);
//		driver.findElement(id).click();
//		driver.findElement(searchButton).click();
//		driver.findElement(By.xpath("//a[contains(text(),'Welcome')]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.findElement(By.xpath("//a[text()='Logout']")).click();

	}

}
