package com.yourlogo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.yourlogo.testbase.TestBase;

public class AlreadyAccountPage extends TestBase{

	@FindBy(xpath="//*[@id='center_column']/h1")
	WebElement authentication;
	
	@FindBy(id="email")
	WebElement emailAddress;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement submitBtn;
	
	@FindBy(xpath="//li[contains(text(),'An email address required.')]")
	WebElement emailErrMsg;

	@FindBy(xpath="//li[contains(text(),'Invalid email address.')]")
	WebElement wrongUnPwErrMsg;
	
	public AlreadyAccountPage() {
		PageFactory.initElements(driver, this);
	}


	public boolean validateAccountPage(){
		return authentication.isDisplayed();
	}
	
	public MyAccountPage sendNamePwd(String un, String pwd){
		emailAddress.sendKeys(un);
		password.sendKeys(pwd);
		submitBtn.click();
		
		return new MyAccountPage();
	}
	
	public boolean getEmailErrMsg(){
		return emailErrMsg.isDisplayed();
	}

	public boolean getWrongUnPwErrMsgTest(){
		return wrongUnPwErrMsg.isDisplayed();
	}



}
