package com.yourlogo.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yourlogo.pages.AlreadyAccountPage;
import com.yourlogo.pages.LoginPage;
import com.yourlogo.testbase.TestBase;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	AlreadyAccountPage alreadyAccountPage;
	
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		setupBrowser();
		loginPage = new LoginPage();
		alreadyAccountPage = new AlreadyAccountPage();
	}
	
	@Test
	public void goToLogInPageTest(){
		alreadyAccountPage= loginPage.navigateLoginPage();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
