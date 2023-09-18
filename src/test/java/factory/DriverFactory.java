package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import GenericUtils.JavaUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public static WebDriver driver;
	
	public WebDriver initializeBrowser(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(options);
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			FirefoxOptions options=new FirefoxOptions();
			options.addArguments("--disable-notification");
			driver=new FirefoxDriver(options);
			
		}else if(browserName.equalsIgnoreCase("edge")){
		     EdgeOptions options=new EdgeOptions();
			options.addArguments("--disable-notification");
			driver=new EdgeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(JavaUtils.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(JavaUtils.IMPLICIT_WAIT_TIME));
		driver.manage().window().maximize();
		return driver;
		
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

}
