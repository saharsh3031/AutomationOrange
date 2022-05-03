package OrangeHrm.TestCasesOrangeHRM;

import com.automationpage.DatePicker;
import com.automationpage.LoginPage;
import com.automationpage.PimModule;

public class leave extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		
		
		getBrowserInstance("Chrome");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		LoginPage login = new LoginPage();
		
		login.Login("Admin", "admin123");
		
		PimModule pim = new PimModule("Sayali", "Dange", "SDange","Sayali31");
		
		DatePicker date = new DatePicker("Apr", "2022","20","Apr","2022","25");

	}

}
