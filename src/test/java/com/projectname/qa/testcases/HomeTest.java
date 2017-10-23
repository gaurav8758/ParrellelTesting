package com.projectname.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.projectname.qa.base.TestBase;
import com.projectname.qa.pages.ContactsPage;
import com.projectname.qa.pages.DealsPage;
import com.projectname.qa.pages.HomePage;
import com.projectname.qa.pages.LoginPage;
import com.projectname.qa.pages.TasksPage;
import com.projectname.qa.util.ExtentTestManager;
import com.projectname.qa.util.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class HomeTest extends TestBase {
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	TestUtil TestUtil;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	
	public HomeTest(){
		super();
	}
	
	public void setup() throws InterruptedException{
		driver = getDriver();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		TestUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		ExtentTestManager.getTest().log(LogStatus.PASS, "<font color=GREEN><B>Setup Completed</B></font>");
	}
	
	@Test(priority=1, groups={"FREECRM","Functional"},enabled=false)
	public void Home_verifyHomePageTitleTest() throws InterruptedException{
		setup();
		String PageTitle = homePage.getHomePageTitle();
		Assert.assertEquals(PageTitle, "CRMPRO","Home Page title not matched");
	}
	
	@Test(priority=1, groups={"FREECRM","Functional"},enabled=false)
	public void Home_verifyUsernameTest() throws InterruptedException{
		setup();
		TestUtil.switchToFrame(driver);
		Assert.assertTrue(homePage.verifyCorrectUsername(), "Username is not correct");
	}
	
	@Test(priority=1, groups={"FREECRM","Functional"},enabled=false)
	public void Home_verifyContactsLinkTest() throws InterruptedException{
		setup();
		TestUtil.switchToFrame(driver);
		contactsPage = homePage.clickonContactsLink();
	}
	
	@Test(priority=1, groups={"FREECRM","Functional"},enabled=false)
	public void Home_verifyDealsLinkTest() throws InterruptedException{
		setup();		
		TestUtil.switchToFrame(driver);
		dealsPage = homePage.clickonDealsLink();
	}
	
	@Test(priority=1, groups={"FREECRM","Functional"},enabled=false)
	public void Home_verifyTasksLinkTest() throws InterruptedException{
		setup();
		TestUtil.switchToFrame(driver);
		tasksPage = homePage.clickonTasksLink();
	}
}
