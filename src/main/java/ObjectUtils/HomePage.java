package ObjectUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtils.JavaUtils;
import GenericUtils.WebDriverUtils;

public class HomePage {
	WebDriver driver;
	WebDriverUtils webDriverUtils;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		webDriverUtils=new WebDriverUtils(driver);
	}
	
	//Locators for myaccount
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccount;
	
	public WebElement getMyAccount() {
		return myAccount;
	}
	public void clickOnMyAccount() {
		webDriverUtils.clickOnElement(myAccount, JavaUtils.IMPLICIT_WAIT_TIME);
	}

	//Locators for Login Option
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement loginOption;
	
	public WebElement getLogin() {
		return loginOption;
	}
	 
	public LoginPage selectLoginOption() {
		webDriverUtils.clickOnElement(loginOption, JavaUtils.IMPLICIT_WAIT_TIME);
		return new LoginPage(driver);
	}
	
	//Locators for Search button
	@FindBy(xpath="//div[@id='search']/input")
	private WebElement enterText;

	public WebElement getEnterText() {
		return enterText;
	}
	
	public void enterTextInSearchButton(String text) {
		webDriverUtils.typeTextIntoElement(enterText, text, JavaUtils.IMPLICIT_WAIT_TIME);
		
	}
	
	// Locators for click search Button
	@FindBy(xpath="//span[@class='input-group-btn']")
	private WebElement clickSearButton;

	public WebElement getClickSearButton() {
		return clickSearButton;
	}
	
	public SearchResultPage clickOnSearchButton() {
		webDriverUtils.clickOnElement(clickSearButton, JavaUtils.IMPLICIT_WAIT_TIME);
		return new SearchResultPage(driver);
	}
	
	//Locator for click on Register
	@FindBy(xpath="//li/a[text()='Register']")
	private WebElement register;

	public WebElement getregister() {
		return register;
	}
	
	public RegisterAccountPage selectRegisterOption() {
		webDriverUtils.clickOnElement(register, JavaUtils.IMPLICIT_WAIT_TIME);
		return new RegisterAccountPage(driver);
	}
	
}
