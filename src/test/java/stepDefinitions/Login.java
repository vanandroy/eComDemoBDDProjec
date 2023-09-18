package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ObjectUtils.HomePage;
import ObjectUtils.LoginPage;
import ObjectUtils.MyAccountPage;
import factory.DriverFactory;
import io.cucumber.java.en.*;



public class Login {
	WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private MyAccountPage myAccountPage;
	private DriverFactory driverFactory;

	@Given("User should navigate the login page on home Page")
	public void User_should_navigate_the_login_page_on_home_Page() {
		driverFactory=new DriverFactory();
		driver=driverFactory.getDriver();
		homePage=new HomePage(driver);


		homePage.clickOnMyAccount();
		loginPage=homePage.selectLoginOption();
	}
	
	@When("^User has enter valid username (.+) in the login field$")
	public void User_has_enter_valid_username_in_the_login_field(String username){
		loginPage.enterEmailText(username);
	}

	@When("User has enters valid username {string} in the login field")
	public void User_has_enters_valid_username_in_the_login_field(String emailText){
		loginPage.enterEmailText(emailText);
	}

	@When("User has dont enters username {string} in the login field")
	public void User_has_dont_enters_username_in_the_login_field(String empty) {
		//Intentionally kept empty
	}
	@When("^User has enter invalid username (.+) in the login field$")
	public void User_has_enter_invalid_username_in_the_login_field(String invalidEmailText) {
		loginPage.enterEmailText(invalidEmailText);
	}
	
	@When("User has enters invalid username {string} in the login field")
	public void User_has_enters_invalid_username_in_the_login_field(String invalidEmailText) {
		loginPage.enterEmailText(invalidEmailText);
	}

	@And("^User has enter valid password (.+) in the password field$")
	public void User_has_enter_valid_password_in_the_password_field(String passwordText) {
		loginPage.enterPassword(passwordText);
	}
	
	@And("User has enters valid password {string} in the password field")
	public void User_has_enters_valid_password_in_the_password_field(String passwordText) {
		loginPage.enterPassword(passwordText);
	}

	@And("User has enters invalid password {string} in the password field")
	public void User_has_enters_invalid_password_in_the_password_field(String invalidPasswordText) {
		loginPage.enterPassword(invalidPasswordText);
	}

	@And("User has dont enters password {string} in the password field")
	public void User_has_dont_enters_password_in_the_password_field(String empty) {
		//Intentionally empty
	}

	@And("User has click on login button")
	public void User_has_click_on_login_button() {
		myAccountPage= loginPage.clickOnLoginButton();
	}

	@Then("User should logged in successfully in the app")
	public void User_should_logged_in_successfully_in_the_app() {
		Assert.assertTrue(myAccountPage.verifySuccessfullyLogin(), true);
	}

	@And("User should logout the app")
	public void User_should_logout_the_app() {
		myAccountPage.clickOnMyAccountButton();
		myAccountPage.clickOnLogoutButton();
	}


	@Then("User should get warning message to entered credentials are missmatched")
	public void User_should_get_warning_message_to_entered_credentials_are_missmatched() {
		Assert.assertTrue(loginPage.getWarningMessage(), true);
	}


}
