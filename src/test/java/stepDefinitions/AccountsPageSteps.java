package stepDefinitions;

import java.util.List;
import java.util.Map;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;

public class AccountsPageSteps {
	
	private  LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private  AccountsPage accountsPage ;

	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(io.cucumber.datatable.DataTable credTable) {
	   List<Map<String,String>> credList = credTable.asMaps();
	   String username = credList.get(0).get("username");
	   String password = credList.get(0).get("password");
	   
	   DriverFactory.getDriver().get("http://automationpractice.com");
	   accountsPage = loginPage.doLogin(username, password);
	}
	

	@Given("user is on accounts page")
	public void user_is_on_accounts_page() {
	   String title = accountsPage.getAccountsPageTitle();
	   System.out.println("Accounts page title is " + title);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(io.cucumber.datatable.DataTable dataTable) {
		 List<String> expectedAccountsSectionList = dataTable.asList();
		 System.out.println("Expected accounts section list : " + expectedAccountsSectionList);
		 
		 List<String> actualAccountsList = accountsPage.getAccountSectionsList();
		 System.out.println("Actual accounts section list : " + actualAccountsList);
		 
		 Assert.assertTrue(expectedAccountsSectionList.containsAll(actualAccountsList));
		 
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedCount) {
		Assert.assertTrue(accountsPage.getAccountSectionCount()== expectedCount);

	}
}
