package ObjectUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtils.JavaUtils;
import GenericUtils.WebDriverUtils;

public class CreatedAccountPage {
	WebDriver driver;
	WebDriverUtils webDriverUtils;
	
	public CreatedAccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		webDriverUtils=new WebDriverUtils(driver);
		
	}
	
	//Locator to verify account is created
	
	@FindBy(css="div#content>h1")
	private WebElement verifyAcc;
	
	public WebElement getVerifyAcc() {
		return verifyAcc;
	}
	public boolean verifyAccountIsCreated() {
		return webDriverUtils.VerifyElementIsDisplayed(verifyAcc, JavaUtils.IMPLICIT_WAIT_TIME);
	}
}
