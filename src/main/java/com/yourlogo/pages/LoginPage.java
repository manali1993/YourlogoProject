package com.yourlogo.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.yourlogo.testbase.TestBase;

public class LoginPage extends TestBase{
	@FindBy(xpath="//a[contains(text() , 'Sign in')]")
	WebElement signinBtn;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public AlreadyAccountPage navigateLoginPage(){
		signinBtn.click();
		return new AlreadyAccountPage();
	}


}
