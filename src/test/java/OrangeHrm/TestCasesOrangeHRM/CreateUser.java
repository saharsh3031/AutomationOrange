package OrangeHrm.TestCasesOrangeHRM;

import com.automationpage.LoginPage;

public class CreateUser extends BaseClass{

	public static void main(String[] args) {
		
		getBrowserInstance("Chrome");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com");
		LoginPage login = new LoginPage();
		login.Login("Admin","admin123");
		

	}

}
