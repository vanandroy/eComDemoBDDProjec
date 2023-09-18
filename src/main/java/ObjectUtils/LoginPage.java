package ObjectUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtils.JavaUtils;
import GenericUtils.WebDriverUtils;

public class LoginPage {
	WebDriver driver;
	WebDriverUtils webDriverUtils;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		webDriverUtils=new WebDriverUtils(driver);
	}
	
	//Locators for email input
	@FindBy(id="input-email")
	private WebElement enterEmail;
	
	public WebElement getEnterEmail() {
		return enterEmail;
	}
	
	public void enterEmailText(String emailText) {
		webDriverUtils.typeTextIntoElement(enterEmail, emailText, JavaUtils.IMPLICIT_WAIT_TIME);
	}
	
	
	//Locators for password input
	@FindBy(id="input-password")
	private WebElement enterpassword;
	
	public WebElement getEnterpassword() {
		return enterpassword;
	}
	public void enterPassword(String passwordText) {
		webDriverUtils.javaScriptType(enterpassword, passwordText, JavaUtils.IMPLICIT_WAIT_TIME);
	}
	
	//Locators for login click
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginClick;
	
	public WebElement getLoginClick() {
		return loginClick;
	}
	
	public MyAccountPage clickOnLoginButton() {
		webDriverUtils.javaScriptClick(loginClick, JavaUtils.IMPLICIT_WAIT_TIME);
		return new MyAccountPage(driver);
	}
	
	//locators for warningMessage
	@FindBy(css="div.alert.alert-danger.alert-dismissible")
	private WebElement warning;
	
	public WebElement getWarning() {
		return warning;
	}
	
	public String getWarningMessage() {
		String msg=webDriverUtils.getTextFromElement(warning, JavaUtils.IMPLICIT_WAIT_TIME);
		return msg;
	}
	

}
