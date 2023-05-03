package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>(); // for parallel execution

	// This method is used to initialize the threadlocal driver on the basis of
	// given browser
	public WebDriver init_driver(String browser) {
		System.out.println("Broswer is --> " + browser);

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver()); //sets current thread copy for that perticular threadlocal variable
		} else if (browser.equals("firefox")) {
			tldriver.set(new FirefoxDriver());
		} else if (browser.equals("safari")) {
			tldriver.set(new SafariDriver());
		} else {
			System.out.println("Please pass correct browser value: " + browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}

	// this method is ued to get driver with ThreadLocal
	public static synchronized WebDriver getDriver() {
		// TODO Auto-generated method stub
		return tldriver.get(); //it will create multiple copies of same driver 
		
		// will get driver with  ThreadLocal instance
	}

}
