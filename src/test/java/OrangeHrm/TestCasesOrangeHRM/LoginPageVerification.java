package OrangeHrm.TestCasesOrangeHRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPageVerification extends BaseClass {

	public static void main(String[] args) {
	getBrowserInstance("Chrome");
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
	     Login("Admin","admin123");
	     Login("qdmin","admin@123");
	     Login("Admin","admin==123");
	     Login("A=edmin","admin123");
	     Login(" "," ");
	}

	private static void Login(String Username, String Password) {
		driver.findElement(By.id("txtUsername")).sendKeys(Username);
		driver.findElement(By.id("txtPassword")).sendKeys(Password);
		driver.findElement(By.id("btnLogin")).click();
	
	if(Username!="Admin" || Password!="admin123" ) {
        String errormessge=driver.findElement(By.xpath("//span[text()='Invalid credentials']")).getText();
		System.out.println(errormessge);
	}
	else {
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		WebElement selectAllCheckBox = driver.findElement(By.id("ohrmList_chkSelectAll"));
		boolean checkBox = selectAllCheckBox.isSelected();
		System.out.println("Select All check Box is checkrd" +checkBox);
		
		
		   driver.findElement(By.xpath("//a[contains(text(),'Welcome')]")).click();
		     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		     driver.findElement(By.xpath("//a[text()='Logout']")).click();
				 
	}
		
		
	}
	}







