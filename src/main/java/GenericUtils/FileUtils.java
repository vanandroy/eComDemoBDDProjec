package GenericUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtils {
	public Properties initializeProperties() throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\config\\config.properties");
		prop.load(fis);
		
		return prop;
		
	}

}
