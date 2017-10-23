package com.projectname.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.projectname.qa.base.TestBase;
import com.projectname.qa.pages.HomePage;
import com.projectname.qa.pages.LoginPage;
import com.projectname.qa.util.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class MobileTest extends TestBase{
	WebDriver driver;
	//LoginPage loginPage;
	//HomePage homePage;

	public MobileTest(){
		super();
	}
	
	public void setup(){
		driver = getDriver();
		//loginPage = PageFactory.initElements(driver, LoginPage.class);
		ExtentTestManager.getTest().log(LogStatus.PASS, "<font color=GREEN><B>Setup Completed</B></font>");
	}

	@Test(priority=1, groups={"Testing","Functional"})
	public void Logon_PageTitleTest(){
		setup();
		//String PageTitle = loginPage.getLoginPageTitle();
	}
	
}
