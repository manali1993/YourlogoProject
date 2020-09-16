package com.yourlogo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yourlogo.pages.AddToCartPage;
import com.yourlogo.pages.CheckOutPage;
import com.yourlogo.testbase.TestBase;

public class AddToCartPageTest extends TestBase {

	AddToCartPage addToCartPage;
	CheckOutPage checkOutPage;
	double itemPrice;
	String itemTitle;
	
	public AddToCartPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		setupBrowser();
		addToCartPage = new AddToCartPage();
		checkOutPage = new CheckOutPage();
		addToCartPage.hoverItem("2");
	}
	
	@Test(priority=1)
	public void addOneItemToCartTest() throws InterruptedException{
		itemPrice = addToCartPage.getItemPrice("2");
		itemTitle= addToCartPage.getItemTitle("2");
		addToCartPage.clickAddToCartBtn("2");
		Thread.sleep(2000);
		Assert.assertEquals(itemTitle, addToCartPage.verifyTitle(), "Item title not matched");
	}
	
	@Test(priority=2)
	public void clickCheckOutTest(){
		addToCartPage.clickAddToCartBtn("2");
		checkOutPage= addToCartPage.clickCheckOutBtn();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
