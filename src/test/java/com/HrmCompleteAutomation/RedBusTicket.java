package com.HrmCompleteAutomation;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automationpage.RedBus;
import com.github.dockerjava.api.model.Link;

import OrangeHrm.TestCasesOrangeHRM.BaseClass;
import OrangeHrm.TestCasesOrangeHRM.PropertyHandling;

public class RedBusTicket extends BaseClass {

	PropertyHandling prop;
	RedBus rBus;

	@BeforeClass
	public void beforeClass() throws IOException {
		prop = new PropertyHandling();
		rBus = new RedBus();
		getBrowserInstance(prop.getProperty("browser"));
		driver.navigate().to("https://www.redbus.in/");
	}

	@Test
	public void loginRedbus() throws InterruptedException {

		driver.findElement(rBus.From).sendKeys(prop.getProperty("redBusFromLocation"));
		Thread.sleep(1000);
		driver.findElement(rBus.sreachOption).click();
		
		
		driver.findElement(rBus.to).sendKeys(prop.getProperty("redBusToLocation"));
		Thread.sleep(1000);
		driver.findElement(rBus.sreachToOption).click();

		int currentDate = LocalDateTime.now().getDayOfMonth();
		driver.findElement(rBus.date).click();

		
		driver.findElements(rBus.selectDate).forEach((element) -> {
			String attributeVal = element.getAttribute("class");

			if (attributeVal.equals("wd day") ||  attributeVal.equals("we day") ) {
				if (!element.getText().isEmpty() && (currentDate + 1) == Integer.parseInt(element.getText())) {

					element.click();
				}
			}
		});
		
		driver.findElement(rBus.sreachButton).click();

	
			
	List<WebElement> buses = driver.findElements(rBus.busOptions);

	buses.forEach((var)->{
			
//			System.out.println(var.getText());
			do {
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,1000)");
				System.out.println(var.getText());
			}
				while(driver.findElement(rBus.verifyLink).isDisplayed());
			
//			System.out.println(var.getText());
		
		
	});
	System.out.println("hello");
	
	
	
	
}
}




















