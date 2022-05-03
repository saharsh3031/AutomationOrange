package com.automationpage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import OrangeHrm.TestCasesOrangeHRM.BaseClass;

public class RedBus extends BaseClass {
	
	
	public By From = By.id("src");
	
//	@FindBy(id="dest")
//	public WebElement to;
	
	public By to= By.id("dest");
	
	public By date= By.id("onward_cal");
	
	public By sreachButton= By.id("search_btn");
	
	public By sreachOption= By.xpath("//li[@data-id='130']");
	
	public By sreachToOption= By.xpath("//li[@data-id='462']");
	
	public By verifyLink = By.xpath("//div[@id='OPERATORS_SERVING_viewMore']");
	
	
//	public By sreachToOption= By.id("462");
	
//	@FindBy(id="onward_cal")
//	public WebElement date;
	
//	@FindBy(id="search_btn")
//	public WebElement sreachButton;
	
//	public int currentDate= LocalDateTime.now().getDayOfMonth();
	
	public By busOptions = By.xpath("//div[@class='clearfix bus-item-details']/descendant::span[contains(@class,'f-bold')]");
	
	public By busName = By.xpath("//div[@class='travels lh-24 f-bold d-color']");
	
	
	public String currentDate1= LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	
//	public int travellingDate=currentDate+1;
	
	public By selectDate = By.xpath("//table[@class='rb-monthTable first last']//tr/td");
	
	public RedBus() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
}
