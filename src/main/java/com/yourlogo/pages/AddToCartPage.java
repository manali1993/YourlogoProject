package com.yourlogo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.yourlogo.testbase.TestBase;
import com.yourlogo.utility.TestUtil;

public class AddToCartPage extends TestBase{
	
	@FindBy(xpath="//*[@id=\"layer_cart_product_title\"]")
	WebElement cartItemTitle;
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	WebElement checkOutBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}

	
	public void hoverItem(String itemNum){
		Actions hover = new Actions(driver);
		hover.moveToElement(driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li["+itemNum+"]/div/div[1]/div/a[1]/img"))).build().perform();
	}
	
	public void clickAddToCartBtn(String itemNum){
		driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li["+itemNum+"]/div/div[2]/div[2]/a[1]")).click();
	}
	
	public double getItemPrice(String itemNum){
		String itemPrice = driver.findElement(By.xpath("//*[@id='homefeatured']/li["+itemNum+"]/div/div[2]/div[1]/span")).getText().replace("$", "");
		return Double.parseDouble(itemPrice);
	}
	
	public String getItemTitle(String itemNum){
		String itemTitle=driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li["+itemNum+"]/div/div[2]/h5/a")).getText();
		return itemTitle;
	}

	public String verifyTitle(){
		return cartItemTitle.getText();
	}
	
	public CheckOutPage clickCheckOutBtn(){
		checkOutBtn.click();
		return new CheckOutPage();
	}
}
