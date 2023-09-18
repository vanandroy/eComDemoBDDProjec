package GenericUtils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {
	WebDriver driver;

	public WebDriverUtils(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement waitForElement(WebElement element,long durationInSecond) {
		WebElement webElement = null;
		try {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSecond));
			webElement= wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return webElement;
	}

	public void clickOnElement(WebElement element,long durationInSecond) {
		WebElement webElement=waitForElement(element, durationInSecond);
		webElement.click();
	}

	public void typeTextIntoElement(WebElement element,String textToBeTyped,long durationInSecond) {
		WebElement webElement=waitForElement(element, durationInSecond);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToBeTyped);
	}

	public void selectOptionFromDropdown(WebElement element,String selectText,long durationInSecond) {
		WebElement webElement=waitForElement(element, durationInSecond);
		Select select=new Select(webElement);
		select.selectByVisibleText(selectText);
	}

	public Alert waitForAlert(long durationInSecond) {

		Alert alert=null;
		try {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSecond));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return alert;
	}
	
	public void acceptAlert(long durationInSecond) {
		Alert alert=waitForAlert(durationInSecond);
		alert.accept();
	}
	
	public void dismissAlert(long durationInSecond) {
		Alert alert=waitForAlert(durationInSecond);
		alert.dismiss();
	}
	
	public WebElement visibilityOfElement(WebElement element,long durationInSecond) {
		WebElement webElement=null;
		try {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(durationInSecond));
		webElement=wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Throwable t) {
			t.printStackTrace();
		}
		
		return webElement;
	}
	
	public void mouseHoverAndClick(WebElement element,long durationInSecond) {
		
		WebElement webElement=visibilityOfElement(element, durationInSecond);
		
		Actions actions=new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();
	}
	
	public void doubleClickActions(WebElement element,long durationInSecond) {
		WebElement webElement=visibilityOfElement(element, durationInSecond);
		Actions actions=new Actions(driver);
		actions.doubleClick(webElement).perform();
		
	}
	
	public void contextClickActions(WebElement element,long durationInSecond) {
		WebElement webElement=visibilityOfElement(element, durationInSecond);
		Actions actions=new Actions(driver);
		actions.contextClick(webElement).perform();
	}
	
//	public void dragANdDropActions(WebElement element,long durationOfSecond) {
//		WebElement webElement=visibilityOfElement(element, durationOfSecond);
//		Actions actions=new Actions(driver);
//		actions.dragAndDrop(element, webElement);
//		
//	}
	
	public void javaScriptClick(WebElement element,long durationInSecond) {
		WebElement webElement=visibilityOfElement(element, durationInSecond);
	 JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", webElement);
	}
	
	public void javaScriptType(WebElement element,String textToBeTyped,long durationInSecond) {
		WebElement webElement=visibilityOfElement(element, durationInSecond);
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].value='"+textToBeTyped+"'", webElement);
	}
	
	public String getTextFromElement(WebElement element,long durationInSecond) {
		WebElement webElement=visibilityOfElement(element, durationInSecond);
		return webElement.getText();
	}
	
	public boolean VerifyElementIsDisplayed(WebElement element,long durationInSecond) {
		try {
		WebElement webElement=visibilityOfElement(element, durationInSecond);
		return webElement.isDisplayed();
		}catch(Throwable e) {
			return false;
		}
	}

}
