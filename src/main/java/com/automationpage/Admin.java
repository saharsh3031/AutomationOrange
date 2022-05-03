package com.automationpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import OrangeHrm.TestCasesOrangeHRM.BaseClass;

public class Admin extends BaseClass{
	
//	@FindBy(id="menu_admin_viewAdminModule")
//	public WebElement admin;
	
	public By admin = By.id("menu_admin_viewAdminModule");
	public By searchUsername = By.id("searchSystemUser_userName");
	public By userRole = By.id("searchSystemUser_userType");
	
	public Admin() {
		
//		PageFactory.initElements(driver,this);
		
		
	}

}
