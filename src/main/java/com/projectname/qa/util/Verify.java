package com.projectname.qa.util;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.Assertion;

import com.relevantcodes.extentreports.LogStatus;

public class Verify extends Assertion 
{
	WebDriver driver;
	
	public Verify(WebDriver Tdriver){
		driver = Tdriver;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void assertTrue(boolean condition) {
		try
		{	
			super.assertTrue(condition);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Condition met.");  
		}
		catch(AssertionError ex)
		{
          	try {
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Condition", "Condition not met.: " + ExtentTestManager.getTest().addScreenCapture(GetScreenShot.capture(driver, "screenShotName")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void assertTrue(boolean condition, String message) {
		try
		{
			super.assertTrue(condition, message);
			ExtentTestManager.getTest().log(LogStatus.PASS, message,"Condition met.");  
		}
		catch(AssertionError ex)
		{
			try {
				ExtentTestManager.getTest().log(LogStatus.FAIL, message, "Condition not met.: " + ExtentTestManager.getTest().addScreenCapture(GetScreenShot.capture(driver, "screenShotName")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}	

	@Override
	public void assertFalse(boolean condition) {
		try
		{	
			super.assertFalse(condition);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Condition", "Condition not met.");  
		}
		catch(AssertionError ex)
		{
	    	try {
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Condition: ", "Condition not met.: " + ExtentTestManager.getTest().addScreenCapture(GetScreenShot.capture(driver, "screenShotName")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void assertFalse(boolean condition, String message) {
		try
		{
			super.assertFalse(condition, message);
			ExtentTestManager.getTest().log(LogStatus.PASS, message,"Condition met.");  
		}
		catch(AssertionError ex)
		{
	    	try {
				ExtentTestManager.getTest().log(LogStatus.FAIL, message, "Condition not met.: " + ExtentTestManager.getTest().addScreenCapture(GetScreenShot.capture(driver, "screenShotName")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}	
	


}
