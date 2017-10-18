package com.projectname.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.projectname.qa.base.TestBase;
import com.projectname.qa.util.ExtentTestManager;
import com.projectname.qa.util.GetScreenShot;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage extends TestBase{
	WebDriver driver;
	
	@FindBy(xpath="//td[contains(.,'User: Naveen K')]")
	WebElement usernameLabel;
	
	@FindBy(xpath="//a[contains(@title,'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(@title,'New Contact')]")
	WebElement newcontactLink;
	
	@FindBy(xpath="//a[contains(@title,'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath="//a[contains(@title,'Tasks')]")
	WebElement tasksLink;

	public HomePage(WebDriver Tdriver){
		driver = Tdriver;
		ExtentTestManager.getTest().log(LogStatus.PASS, "<FONT COLOR ='BLUE'><B>HOME PAGE</B></FONT>");
		if (!usernameLabel.isDisplayed())
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "<FONT COLOR ='RED'>Unsucessful Login</FONT>", "Home Page is displayed. User might have not logged in" + ExtentTestManager.getTest().addScreenCapture(GetScreenShot.capture(driver, "screenShotName")));
			//ExtentTestManager.getTest().log(LogStatus.FAIL, "<FONT COLOR ='RED'>Home Page is displayed. User might have not logged in</FONT>");
		}
	}
	
	//Actions:
	public String getHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUsername(){
		return usernameLabel.isDisplayed();
	}
	
	public ContactsPage clickonContactsLink(){
		contactsLink.click();
		
		return PageFactory.initElements(driver, ContactsPage.class);
	}
	
	public DealsPage clickonDealsLink(){
		dealsLink.click();
		
		return PageFactory.initElements(driver, DealsPage.class);
	}
	
	public TasksPage clickonTasksLink(){
		tasksLink.click();
		
		return PageFactory.initElements(driver, TasksPage.class);
	}
	
	public ContactsPage clickonNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newcontactLink.click();
		
		return PageFactory.initElements(driver, ContactsPage.class);
	}
}
