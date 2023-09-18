package stepDefinitions;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import GenericUtils.JavaUtils;
import ObjectUtils.CreatedAccountPage;
import ObjectUtils.HomePage;
import ObjectUtils.RegisterAccountPage;
import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register {

	WebDriver driver;
	private HomePage homePage;
	private RegisterAccountPage registerAccountPage;
	private CreatedAccountPage createdAccountPage;
	private JavaUtils javaUtils;
	private DriverFactory driverFactory;

	@Given("user navigate to Register Account button")
	public void user_navigate_to_register_account_button() {
		driverFactory=new DriverFactory();
		driver=driverFactory.getDriver();
		homePage=new HomePage(driver);
		javaUtils=new JavaUtils();
		

		homePage.clickOnMyAccount();
		registerAccountPage =homePage.selectRegisterOption();
	}

	@When("user has enters the details below")
	public void user_has_enters_the_details_below(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		registerAccountPage.enterFirstName(dataMap.get("firstName"));
		registerAccountPage.enterLastName(dataMap.get("lastName"));
		registerAccountPage.enterEmail(javaUtils.getRandomEmail());
		registerAccountPage.enterTelephone(dataMap.get("telephone"));
		registerAccountPage.enterPassword(dataMap.get("password"));
		registerAccountPage.enterConfirmPassword(dataMap.get("cnfPassword"));
	}

	@When("user has enters the details to verify duplicate account below")
	public void user_has_enters_the_details_to_verify_duplicate_account_below(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		registerAccountPage.enterFirstName(dataMap.get("firstName"));
		registerAccountPage.enterLastName(dataMap.get("lastName"));
		registerAccountPage.enterEmail(dataMap.get("email"));
		registerAccountPage.enterTelephone(dataMap.get("telephone"));
		registerAccountPage.enterPassword(dataMap.get("password"));
		registerAccountPage.enterConfirmPassword(dataMap.get("cnfPassword"));
	}

	@When("user should click on continue button")
	public void user_should_click_on_continue_button() {
		createdAccountPage=registerAccountPage.clickOnContinue();
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		Assert.assertTrue(createdAccountPage.verifyAccountIsCreated());
	}

	@When("user should select newsletter")
	public void user_should_select_newsletter(){
		registerAccountPage.clickOnNewsletter();
	}

	@When("user should select Privacy Policy")
	public void user_should_select_privacy_policy() {
		registerAccountPage.clickOnPrivacyPolicy();
	}

	@Then("User should get proper warning message about email is already exit")
	public void user_should_get_proper_warning_message_about_email_is_already_exit() {
		Assert.assertTrue(registerAccountPage.verifyWarningMessageAboutDuplicateEmail());
	}

	@When("user has not enters any details")
	public void user_has_not_enters_any_details() {
		//empty 
	}

	@Then("User should get proper warning message about all mandatory fields")
	public void user_should_get_proper_warning_message_about_all_mandatory_fields() {
		Assert.assertTrue(registerAccountPage.verifyWarningMessageAboutFirstName());
		Assert.assertTrue(registerAccountPage.verifyWarningMessageAboutLastName());
		Assert.assertTrue(registerAccountPage.verifyWarningMessageAboutEmail());
		Assert.assertTrue(registerAccountPage.verifyWarningMessageAboutTelephone());
		Assert.assertTrue(registerAccountPage.verifyWarningMessageAboutPassword());
		Assert.assertTrue(registerAccountPage.verifyWarningMessageAboutPrivacyPolicy());
	}
}
