package ObjectUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtils.JavaUtils;
import GenericUtils.WebDriverUtils;

public class SearchResultPage {
	WebDriver driver;
	WebDriverUtils webDriverUtils;
	
	public SearchResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		webDriverUtils=new WebDriverUtils(driver);
	}
	
	//Locators for valid search Product
	@FindBy(xpath="//a[text()='HP LP3065']")
	private WebElement product;

	public WebElement getProduct() {
		return product;
	}
	
	public boolean matchProductIsDisplayed() {
		return webDriverUtils.VerifyElementIsDisplayed(product, JavaUtils.IMPLICIT_WAIT_TIME);
		
	}
	
	//locators for invalid search product
	@FindBy(xpath="//p[text()='There is no product that matches the search criteria.']")
	private WebElement invalidPro;
	
	
	public WebElement getInvalidPro() {
		return invalidPro;
	}

	public boolean emptySearchList() {
		return webDriverUtils.VerifyElementIsDisplayed(invalidPro, JavaUtils.IMPLICIT_WAIT_TIME);
	}

}
