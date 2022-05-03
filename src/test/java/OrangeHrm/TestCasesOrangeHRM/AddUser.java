package OrangeHrm.TestCasesOrangeHRM;

import com.automationpage.LoginPage;
import com.automationpage.PimModule;

public class AddUser extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		
     getBrowserInstance("Chrome");
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		LoginPage login = new LoginPage();
		login.Login("Admin", "admin123");
		PimModule pim = new PimModule("Sayali", "Dange", "SDange","Sayali31");
		System.out.println("1st user creater--UN=SDange");
		login.Login("Admin", "admin123");
		pim = new PimModule("Sayalee", "Dange", "SHDange","Sayalee31");
		System.out.println("2ND user creater--UN=SHDange");
		login.Login("Admin", "admin123");
		pim = new PimModule("Sayalee", "Dange", "Sayali_D","Sayali@31");
		login.Login("Admin", "admin123");
		pim = new PimModule("Saharsh", "Dange", "SaHarsh","SH293130");

	}

}
