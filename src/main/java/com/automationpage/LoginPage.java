package com.automationpage;

import org.openqa.selenium.By;

import OrangeHrm.TestCasesOrangeHRM.BaseClass;


public class LoginPage extends BaseClass {
	

	   public By Username =By.id("txtUsername"); 
	   public By Password =By.id("txtPassword");
	   public By loginButoon =By.id("btnLogin");
	   public By forgotPassword =By.linkText("Forgot your password?");
	
	public void Login(String Username, String Password) {

		driver.findElement(this.Username).sendKeys(Username);
		driver.findElement(this.Password).sendKeys(Password);
		driver.findElement(loginButoon).click();

	}
}

