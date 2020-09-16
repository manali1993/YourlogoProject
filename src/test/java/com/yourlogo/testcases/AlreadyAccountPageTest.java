package com.yourlogo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yourlogo.pages.AlreadyAccountPage;
import com.yourlogo.pages.LoginPage;
import com.yourlogo.pages.MyAccountPage;
import com.yourlogo.testbase.TestBase;

public class AlreadyAccountPageTest extends TestBase{
	
	AlreadyAccountPage alreadyAccountPage;
	MyAccountPage myAccountPage;
	LoginPage loginPage;
	
	public AlreadyAccountPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		setupBrowser();
		loginPage = new LoginPage();
		myAccountPage = new MyAccountPage();
		alreadyAccountPage= loginPage.navigateLoginPage();
		
	}
	
	@Test(priority=1)
	public void checkAccountPageTest() throws InterruptedException{
		boolean flag = alreadyAccountPage.validateAccountPage();
		Assert.assertTrue(flag);
		Thread.sleep(2000);
	}
	
	@Test(priority=2)
	public void BlankUnPwTest(){
		alreadyAccountPage.sendNamePwd("", "");
		Assert.assertTrue(alreadyAccountPage.getEmailErrMsg());
	}
	
	@Test(priority=3)
	public void WrongUnPwTest(){
		alreadyAccountPage.sendNamePwd("manali", "vfsdvfsdvsd");
		Assert.assertTrue(alreadyAccountPage.getWrongUnPwErrMsgTest());
	}
	
	@Test(priority=4)
	public void signInTest(){
		myAccountPage = alreadyAccountPage.sendNamePwd(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
