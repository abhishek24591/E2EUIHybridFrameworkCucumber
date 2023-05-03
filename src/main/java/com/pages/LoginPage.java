/**
 * 
 */
package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author abhishekdeshmukh
 *
 */
public class LoginPage {

	private WebDriver driver;

	private By emailId = By.id("email");
	private By password = By.id("pass");
	private By signInBtn = By.xpath("//button[@name='login']");
	private By forgotPwdLink = By.linkText("Forgot your password?");
	
//	2.Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions - methods
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}

	public void enterUserName(String username) {
		driver.findElement(emailId).sendKeys(username);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickOnLoginBtn() {
		driver.findElement(signInBtn).click();
	}
	
	public AccountsPage doLogin(String username,String pwd) {
		System.out.println("Logging in with " + username + " " + password);
		driver.findElement(emailId).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInBtn).click();
		
		return new AccountsPage(driver);  //return instance of next page after login - POM feature 
	}
}
