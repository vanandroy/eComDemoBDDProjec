package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ObjectUtils.HomePage;
import ObjectUtils.SearchResultPage;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search {

	WebDriver driver;
	private HomePage homePage;
	private SearchResultPage searchResultPage;
	private DriverFactory driverFactory;

	@Given("user opens the application")
	public void user_opens_the_application() {
		driverFactory=new DriverFactory();
		driver=driverFactory.getDriver();
		homePage=new HomePage(driver);
	}

	@When("User has enters the valid products {string} in the search box field")
	public void User_has_enters_the_valid_products_in_the_search_box_field(String SearchedItem) {
		homePage.enterTextInSearchButton(SearchedItem);
	}

	@When("User has enters the invalid products {string} in the search box field")
	public void User_has_enters_the_invalid_products_in_the_search_box_field(String invalidItem) {
		homePage.enterTextInSearchButton(invalidItem);
	}

	@When("User has nothing enters in the search box field")
	public void User_has_nothing_enters_in_the_search_box_field() {
		//empty
	}

	@And("User has click on search button")
	public void User_has_click_on_search_button() {
		searchResultPage =homePage.clickOnSearchButton();
	}

	@Then("User should get the searched product that is displayed in the search result")
	public void User_should_get_the_searched_product_that_is_displayed_in_the_search_result() {
		Assert.assertTrue(searchResultPage.matchProductIsDisplayed());
	}

	@Then("User should not get the searched product in the search result")
	public void User_should_not_get_the_searched_product_in_the_search_result() {
		Assert.assertTrue(searchResultPage.emptySearchList());
	}
}
