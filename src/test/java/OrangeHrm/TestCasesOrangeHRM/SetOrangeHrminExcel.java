package OrangeHrm.TestCasesOrangeHRM;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automationpage.ExcelOrange;
import com.automationpage.LoginPage;
import com.automationpage.PimModule;

public class SetOrangeHrminExcel extends BaseClass {

	PropertyHandling prop;
	PimModule pim;
	LoginPage loginPage;

	@BeforeClass()
	public void beforeclass() throws IOException, InterruptedException {

		prop = new PropertyHandling();
		getBrowserInstance(prop.getProperty("browser"));
		loginPage = new LoginPage();
		pim=new PimModule();
		driver.navigate().to(prop.getProperty("orangeHrmUrl"));
	}

	@Test(priority = 1)
	public void loginHrm() throws IOException, InterruptedException {
		System.out.println("Succesfuly Started loginOrangeHrm");
		loginPage.Login(prop.getProperty("orangeHrmUsername"), prop.getProperty("orangeHrmPaasword"));
	}

	@Test(priority = 2)
	public void getEmployeeData() throws IOException, InterruptedException {
		pim.pimModule.click();
		String filePath = prop.getProperty("excelFilePath");
		String sheetName = prop.getProperty("sheetName");
		for (int i = 1; i <= 50; i++) {
			for (int j = 2; j <= 7; j++) {	
				if (i == 1) {
					String value = driver
							.findElement(By.xpath("//table[@id='resultTable']//tr[" + i + "]/th[" + j + "]")).getText();
					System.out.println(value);
					ExcelOrange.setExcelData(filePath, sheetName, i - 1, j - 2, value);
				} else {
					String value = driver
							.findElement(By.xpath("//table[@id='resultTable']//tr[" + i + "]/td[" + j + "]")).getText();
					ExcelOrange.setExcelData(filePath, sheetName, i - 1, j - 2, value);
				}
			}
		}

	}

	@AfterClass
	public void afterClass() {

		driver.quit();

	}
}
