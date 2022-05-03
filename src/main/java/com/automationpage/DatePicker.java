package com.automationpage;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import OrangeHrm.TestCasesOrangeHRM.BaseClass;

public class DatePicker extends BaseClass {

	@FindBy(id = "menu_leave_viewLeaveModule")
	public WebElement leave;

//	public By leave = By.id("menu_leave_viewLeaveModule");
	public By assingLeave = By.id("menu_leave_assignLeave");
	public By employeeName = By.id("assignleave_txtEmployee_empName");
	public By leaveType = By.xpath("//select[@id='assignleave_txtLeaveType']");

	public By calfromDate = By.id("calFromDate");
	public By month = By.xpath("//select[@class='ui-datepicker-month']");
	public By year = By.xpath("//select[@class='ui-datepicker-year']");
	public By date = By.xpath("//select[@class='ui-datepicker-calender']");
	
	public By assingbutton = By.id("assignBtn");

	public SimpleDateFormat sd ;
	public SimpleDateFormat sd1;
	public By calToDate = By.id("calToDate");

//	public DatePicker() {

//		driver.findElement(calfromDate).click();
//
//		Select month = new Select(driver.findElement(this.month));
//		month.selectByVisibleText(fromMonth);
//		Select year = new Select(driver.findElement(this.year));
//		year.selectByVisibleText(fromYear);
//
//		String date = fromDate;
//		List<WebElement> allDates = driver.findElements(this.date);
//
//		allDates.forEach((val) -> {
//			String dt = val.getText();
//			if (dt.equals(date)) {
//				val.click();
////				break;
//	
//			}
//
//		});
//		driver.findElement(calToDate).click();
//
//		Select month1 = new Select(driver.findElement(this.month));
//		month.selectByVisibleText(toMonth);
//		Select year1 = new Select(driver.findElement(this.year));
//		year.selectByVisibleText(toYear);
//
//		String dateTo = toDate;
//		List<WebElement> allToDates = driver.findElements(this.date);
//
//		allDates.forEach((val) -> {
//			String dt = val.getText();
//			if (dt.equals(date)) {
//				val.click();
////				break;
//			}
//
//		});
//	}

	public DatePicker() {

		Random random = new Random();
		int randomFromValue = random.nextInt(100);
		int randomToValue = random.nextInt(100);

		Calendar cal = Calendar.getInstance();

		cal.add(Calendar.DATE, randomFromValue);

		cal.add(Calendar.MONTH, 2);
		cal.add(Calendar.YEAR, 2);

		java.util.Date d = cal.getTime();

		 sd = new SimpleDateFormat("yyyy-mm-dd");

		Calendar cal1 = Calendar.getInstance();

		cal1.add(Calendar.DATE, randomToValue);

		cal1.add(Calendar.MONTH, 2);
		cal1.add(Calendar.YEAR, 2);
		
		sd1 = new SimpleDateFormat("yyyy-mm-dd");
		
		SimpleDateFormat St = sd;
		

	}

}
