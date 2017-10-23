package com.projectname.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.projectname.qa.base.TestBase;
import com.projectname.qa.pages.ContactsPage;
import com.projectname.qa.pages.HomePage;
import com.projectname.qa.pages.LoginPage;
import com.projectname.qa.util.ExtentTestManager;
import com.projectname.qa.util.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class ContactsTest extends TestBase {
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	TestUtil TestUtil;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";
	
	public ContactsTest(){
		super();
	}
	
	//@BeforeMethod
	public void setup() throws InterruptedException{
		driver = getDriver();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		TestUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		ExtentTestManager.getTest().log(LogStatus.PASS, "<font color=GREEN><B>Setup Completed</B></font>");
	}
	
	@Test(priority = 1,enabled = true, groups={"FREECRM","Functional"})
	public void Contacts_verifyContactsPageLabelTest() throws InterruptedException{
		setup();
		TestUtil.switchToFrame(driver);
		contactsPage = homePage.clickonContactsLink();
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts label is not displayed in the page");
	}
	
	@Test(priority = 2,enabled = true, groups={"FREECRM","Functional"})
	public void Contacts_selectSingleContactTest() throws InterruptedException{
		setup();
		TestUtil.switchToFrame(driver);
		contactsPage = homePage.clickonContactsLink();
		contactsPage.selectContactsByName("David Cris");
	}
	
	@Test(priority = 1,enabled = true, groups={"FREECRM","Functional"})
	public void Contacts_selectMultipleContactTest() throws InterruptedException{
		setup();
		TestUtil.switchToFrame(driver);
		contactsPage = homePage.clickonContactsLink();
		contactsPage.selectContactsByName("David Cris");
		contactsPage.selectContactsByName("Mukta Sharma");
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 2,dataProvider="getCRMTestData", enabled=true, groups={"FREECRM","Functional"})
	public void Contacts_createNewContactTest(String title, String firstName, String lastName, String company) throws InterruptedException{
		setup();
		TestUtil.switchToFrame(driver);
		contactsPage = homePage.clickonNewContactLink();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactsPage.createNewContact(title, firstName, lastName, company);
	}
}
