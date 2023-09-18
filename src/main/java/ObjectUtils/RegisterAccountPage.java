package ObjectUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtils.JavaUtils;
import GenericUtils.WebDriverUtils;

public class RegisterAccountPage {
	WebDriver driver;
	WebDriverUtils webDriverUtils;
	
	public RegisterAccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		webDriverUtils=new WebDriverUtils(driver);
	}
	
	//Locators for enter first name

	@FindBy(id="input-firstname")
	private WebElement inputName;

	public WebElement getInputName() {
		return inputName;
	}
	
	public void enterFirstName(String text) {
		webDriverUtils.typeTextIntoElement(inputName, text, JavaUtils.IMPLICIT_WAIT_TIME);
	}
	
	//Locators for enter last name
	
	@FindBy(id="input-lastname")
	private WebElement inputlastName;

	public WebElement getInputLastName() {
		return inputlastName;
	}
	
	public void enterLastName(String text) {
		webDriverUtils.typeTextIntoElement(inputlastName, text, JavaUtils.IMPLICIT_WAIT_TIME);
	}
	
	//locator for enter email
	
	@FindBy(id="input-email")
	private WebElement inputEmail;

	public WebElement getInputEmail() {
		return inputEmail;
	}
	
	public void enterEmail(String text) {
		webDriverUtils.typeTextIntoElement(inputEmail, text, JavaUtils.IMPLICIT_WAIT_TIME);
	}
	
	//Locator for enter telephone
	
	@FindBy(id="input-telephone")
	private WebElement inputTele;

	public WebElement getInputTele() {
		return inputTele;
	}
	
	public void enterTelephone(String text) {
		webDriverUtils.typeTextIntoElement(inputTele, text, JavaUtils.IMPLICIT_WAIT_TIME);
	}
	
	//Locators for enter password
	
	@FindBy(id="input-password")
	private WebElement inputPass;

	public WebElement getInputPass() {
		return inputPass;
	}
	
	public void enterPassword(String text) {
		webDriverUtils.typeTextIntoElement(inputPass, text, JavaUtils.IMPLICIT_WAIT_TIME);
	}
	
	//Locators for enter Confirm password
	
	@FindBy(id="input-confirm")
	private WebElement inputCnfPass;

	public WebElement getInputCnfPass() {
		return inputCnfPass;
	}
	
	public void enterConfirmPassword(String text) {
		webDriverUtils.typeTextIntoElement(inputCnfPass, text, JavaUtils.IMPLICIT_WAIT_TIME);
	}
	
	//Locators for newsletter
	
	@FindBy(xpath="//div/label[@class='radio-inline']/following-sibling::label")
	private WebElement news;

	public WebElement getNews() {
		return news;
	}
	
	public void clickOnNewsletter() {
		webDriverUtils.clickOnElement(news, JavaUtils.IMPLICIT_WAIT_TIME);
	}
	
	//Locators for privacy policy
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement prPol;

	public WebElement getpriPol() {
		return prPol;
	}
	
	public void clickOnPrivacyPolicy() {
		webDriverUtils.clickOnElement(prPol, JavaUtils.IMPLICIT_WAIT_TIME);
	}
	
	//Locators for click on continue button
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement conti;

	public WebElement getContinue() {
		return conti;
	}
	
	public CreatedAccountPage clickOnContinue() {
		webDriverUtils.clickOnElement(conti, JavaUtils.IMPLICIT_WAIT_TIME);
		return new CreatedAccountPage(driver);
	}
	
	//Locators for verify created account
	@FindBy(css="div#content>h1")
	private WebElement verifyAcc;
	
	public WebElement getVerifyAcc() {
		return verifyAcc;
	}
	public boolean verifyAccountisCreated() {
		return webDriverUtils.VerifyElementIsDisplayed(verifyAcc, JavaUtils.IMPLICIT_WAIT_TIME);
	}
	
	//Locators to verify warning message of duplicate email
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement warnMsg;
	
	public WebElement getWarnMsg() {
		return warnMsg;
	}
	public boolean verifyWarningMessageAboutDuplicateEmail() {
		return webDriverUtils.VerifyElementIsDisplayed(warnMsg, JavaUtils.IMPLICIT_WAIT_TIME);
	}
	
	//Locators to verify warning message for first name
	
	@FindBy(xpath="//div[text()='First Name must be between 1 and 32 characters!']")
	private WebElement warnMsgF;
	
	public WebElement getWarnMsgF() {
		return warnMsgF;
	}
	public boolean verifyWarningMessageAboutFirstName() {
		return webDriverUtils.VerifyElementIsDisplayed(warnMsgF, JavaUtils.IMPLICIT_WAIT_TIME);
	}
	
	//Locators to verify warning message for last name

	@FindBy(xpath="//div[text()='Last Name must be between 1 and 32 characters!']")
	private WebElement warnMsgL;
	
	public WebElement getWarnMsgL() {
		return warnMsgL;
	}
	public boolean verifyWarningMessageAboutLastName() {
		return webDriverUtils.VerifyElementIsDisplayed(warnMsgL, JavaUtils.IMPLICIT_WAIT_TIME);
	}
	
	
	//Locators to verify warning message for email
	
	@FindBy(xpath="//div[text()='E-Mail Address does not appear to be valid!']")
	private WebElement warnMsgEm;
	
	public WebElement getWarnMsgEm() {
		return warnMsgEm;
	}
	public boolean verifyWarningMessageAboutEmail() {
		return webDriverUtils.VerifyElementIsDisplayed(warnMsgEm, JavaUtils.IMPLICIT_WAIT_TIME);
	}
	
	
	//Locators to verify warning message for telephone
	
	@FindBy(xpath="//div[text()='Telephone must be between 3 and 32 characters!']")
	private WebElement warnMsgTel;
	
	public WebElement getWarnMsgTel() {
		return warnMsgTel;
	}
	public boolean verifyWarningMessageAboutTelephone() {
		return webDriverUtils.VerifyElementIsDisplayed(warnMsgTel, JavaUtils.IMPLICIT_WAIT_TIME);
	}
	
	
	//Locators to verify warning message for password
	
	@FindBy(xpath="//div[text()='Password must be between 4 and 20 characters!']")
	private WebElement warnMsgPas;
	
	public WebElement getWarnMsgPas() {
		return warnMsgPas;
	}
	public boolean verifyWarningMessageAboutPassword() {
		return webDriverUtils.VerifyElementIsDisplayed(warnMsgPas, JavaUtils.IMPLICIT_WAIT_TIME);
	}
	
	//Locators to verify warning message for privacy policy
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement warnMsgPriv;
	
	public WebElement getWarnMsgPriv() {
		return warnMsgPriv;
	}
	public boolean verifyWarningMessageAboutPrivacyPolicy() {
		return webDriverUtils.VerifyElementIsDisplayed(warnMsgPriv, JavaUtils.IMPLICIT_WAIT_TIME);
	}
	
	
}
