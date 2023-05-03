package stepDefinitions;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	private static String loginPgTitle = "";
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	@Given("User is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("https://www.facebook.com");
	}

	@When("user gets title of the accounts page")
	public void user_gets_title_of_the_home_page() {
		loginPgTitle = loginPage.getLoginPageTitle();
		System.out.println("Login page title is " + loginPgTitle);
	}

	@Then("page title sbould be {string}")
	public void page_title_sbould_be(String expectedTitleName) {
		Assert.assertTrue(loginPgTitle.contains(expectedTitleName)); 
	}

	@Then("Forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		loginPage.enterUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);  
		
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("user gets title of the page")
	public void user_gets_title_of_the_page() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
}
