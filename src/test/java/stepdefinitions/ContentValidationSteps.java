package stepdefinitions;

import com.pages.DBSLandingPage;
import com.pages.SearchPage;
import com.pages.SearchResultPage;
import com.qa.factory.DriverFactory;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContentValidationSteps {
	private SearchPage searchPage = new SearchPage(DriverFactory.getDriver());
	private SearchResultPage searchResultPage;
	private DBSLandingPage dbsLandingPage;

	@Given("I launch google")
	public void i_launch_google() {
		DriverFactory.getDriver().get("http://www.google.com");
	}

	@Given("search for the keyword {string}")
	public void search_for_the_keyword(String searchKeyword) {
		searchResultPage = searchPage.searchText(searchKeyword);
	}

	@When("I click on the first search result")
	public void i_click_on_the_first_search_result() {
		dbsLandingPage = searchResultPage.clickOnFirstSearchResult();
	}

	@Then("validate that the right logo is displayed in the landing page")
	public void validate_that_the_right_logo_is_displayed_in_the_landing_page() {
		Assert.assertTrue(dbsLandingPage.getDBSLogoList().size() == 1);
	}
	
	@When("I click on Login button")
	public void i_click_on_button() {
		dbsLandingPage.clickLogin();
	}
	
	@Then("validate that digibank by DBS is displayed under login options")
	public void validate_that_is_displayed_under_login_options() {
		dbsLandingPage.checkDigiLoginOptionExist();
	}
}
