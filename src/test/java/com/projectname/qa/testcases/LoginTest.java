package com.projectname.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.projectname.qa.base.TestBase;
import com.projectname.qa.pages.HomePage;
import com.projectname.qa.pages.LoginPage;
import com.projectname.qa.util.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends TestBase{
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;

	public LoginTest(){
		super();
	}
	
	public void setup(){
		driver = getDriver();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		ExtentTestManager.getTest().log(LogStatus.PASS, "<font color=GREEN><B>Setup Completed</B></font>");
	}

	@Test(priority=1, groups={"FREECRM","Testing"})
	public void Logon_PageTitleTest(){
		setup();
		String PageTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(PageTitle, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
	@Test(priority=1, groups="FREECRM",enabled=false)
	public void Logon_CRMLogoImageTest(){
		setup();
		Assert.assertTrue(loginPage.validateCRMImage());
	}
	
	@Test(priority=1, groups="FREECRM",enabled=false)
	public void Logon_ValidCredentialsTest() throws InterruptedException{
		setup();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
}
