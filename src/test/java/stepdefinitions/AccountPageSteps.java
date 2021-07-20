package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageSteps {
	private LoginPage loginPage= new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {
		List<Map<String,String>> credentialList = credTable.asMaps();
		String UserName = credentialList.get(0).get("username");
		String PWD = credentialList.get(0).get("password");
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountsPage = loginPage.doLogin(UserName, PWD);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		String actualTitle = accountsPage.getAccountsPageTitle();
		System.out.println("Accounts Page title is: " + actualTitle);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionTable) {
		
		List<String> sectionList = sectionTable.asList();
		System.out.println("Expected Section List : " +sectionList);
 		List<String> actualSectionList = accountsPage.getAccountsSectionList();
 		System.out.println("Actual Section List : " +actualSectionList);
 		Assert.assertTrue(actualSectionList.containsAll(sectionList));
 		
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
		int sectionCount = accountsPage.getAccountsSectionCount();
		System.out.println("Expected Section Count : "+expectedSectionCount);		
		System.out.println("Actual Section Count : "+sectionCount);
		Assert.assertTrue(sectionCount==expectedSectionCount);
	}

	
}
