package com.projectname.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.projectname.qa.base.TestBase;
import com.projectname.qa.util.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPage extends TestBase{
	WebDriver driver;
	
	@FindBy(name="username")
	WebElement username;

	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[contains(@value,'Login')]")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(.,'Sign Up')]")
	WebElement signupBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	@FindBy(xpath="//div[@class='intercom-launcher-close-icon']")
	WebElement closeCustomerChatboxBtn;
	
	//Constructor to initialize the page objects.
	public LoginPage(WebDriver Tdriver){
		driver =Tdriver;
		ExtentTestManager.getTest().log(LogStatus.PASS, "<FONT COLOR ='BLUE'><B>LOGIN PAGE</B></FONT>");
	}
	
	//Actions:
	public String getLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws InterruptedException{
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(1000);
		if (!loginBtn.isDisplayed()){
			closeCustomerChatboxBtn.click();
		}
		loginBtn.click();
		
		
		return PageFactory.initElements(driver, HomePage.class);
	}
	
}
