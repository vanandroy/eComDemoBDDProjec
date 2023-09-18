package Hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import GenericUtils.FileUtils;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MyHooks {

	 WebDriver driver;
	private FileUtils fileUtils;
	private DriverFactory driverFactory;

	@Before
	public void setUp() throws IOException {

		fileUtils=new FileUtils();
		driverFactory=new DriverFactory();
		Properties prop=fileUtils.initializeProperties();	
		driver=driverFactory.initializeBrowser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
	}

	@After
	public void tearDown(Scenario scenario) {
		String scenarioName=scenario.getName().replaceAll(" ", "_");
		if(scenario.isFailed()) {
			byte[] srcScreeshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreeshot, "image/png", scenarioName);
		}
		driver.quit();
	}
}
