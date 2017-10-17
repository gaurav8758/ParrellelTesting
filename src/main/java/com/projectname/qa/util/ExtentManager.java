package com.projectname.qa.util;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.projectname.qa.base.TestBase;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
    static ExtentReports extent;
    //final static String filePath = System.getProperty("user.dir") + "\\test-output\\ExtentReport.html";
    static Path filePath;
    
    public synchronized static ExtentReports getReporter() {
    	//System.out.println("filepath:" + filePath);
    	filePath = Paths.get(TestBase.GlobalExtentReportsLocation);
        if (extent == null) {
        	if (TestBase.GlobalExtentReportsOverWrite)
        	{
        		extent = new ExtentReports(filePath.toString(), true, DisplayOrder.OLDEST_FIRST);
        		System.out.println(filePath);
        		System.out.println("inside true");
        	}
        	else
        	{
        		extent = new ExtentReports(filePath.toString(), false, DisplayOrder.OLDEST_FIRST);
        		System.out.println("inside false");
        	}
        	extent
            //.addSystemInfo("Host Name", java.net.InetAddress.getLocalHost())
            .addSystemInfo("Environment", "Automation Testing - Environment")
            .addSystemInfo("User Name", System.getProperty("user.name"));
            
    		extent.loadConfig(new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\projectname\\qa\\config\\extent-config.xml"));
        }
        
        return extent;
    }
}