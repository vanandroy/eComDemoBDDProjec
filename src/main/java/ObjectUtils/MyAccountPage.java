package ObjectUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtils.JavaUtils;
import GenericUtils.WebDriverUtils;

public class MyAccountPage {
	WebDriver driver;
	WebDriverUtils webDriverUtils;

	public MyAccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		webDriverUtils=new WebDriverUtils(driver);
	}
	
	//locators to verify succesfully loggedin
	@FindBy(xpath="//h2[text()='My Orders']")
	private WebElement login;
	
	public WebElement getLogin() {
		return login;
	}
	
	public String verifySuccessfullyLogin() {
		String text=webDriverUtils.getTextFromElement(login, JavaUtils.IMPLICIT_WAIT_TIME);
		return text;
		
	}
	
	//locators for MyAccount
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccount;
	
	public WebElement getMyAccount() {
		return myAccount;
	}
	
	public void clickOnMyAccountButton() {
		webDriverUtils.javaScriptClick(myAccount, JavaUtils.IMPLICIT_WAIT_TIME);
	}
	
	//locators for logOut
	@FindBy(xpath="//li/a[text()='Logout']")
	private WebElement logout;
	
	public WebElement getLogout() {
		return logout;
	}
	
	public void clickOnLogoutButton() {
		webDriverUtils.javaScriptClick(logout, JavaUtils.IMPLICIT_WAIT_TIME);
	}
	
}
