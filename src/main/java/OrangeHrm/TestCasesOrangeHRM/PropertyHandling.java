package OrangeHrm.TestCasesOrangeHRM;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyHandling {
	
	Properties property;
	
	public PropertyHandling () throws IOException {
		
		String filePath ="C:\\Users\\Sayu\\eclipse-workspace\\TestCasesOrangeHRM\\config.property";
		
		property = new Properties();
		
		FileInputStream input = new FileInputStream(filePath);
		
		property.load(input);
		
		
	}
	
	public String getProperty(String key) {
		
		return property.getProperty(key);
	}
	

}
