package com.projectname.qa.util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.projectname.qa.base.TestBase;

public class LocalDriverFactory {
    static synchronized WebDriver createInstance(String browserName) {
        WebDriver driver = null;
        if (browserName.toLowerCase().contains("firefox")) {
            driver = new FirefoxDriver();
            return driver;
        }
        if (browserName.toLowerCase().contains("internet")) {
            driver = new InternetExplorerDriver();
            return driver;
        }
        if (browserName.toLowerCase().contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", TestBase.GlobaldriverLocation + "\\chromedriver.exe");	
            driver = new ChromeDriver();
            return driver;
        }
        if (browserName.toLowerCase().contains("chrome_mac")) {
			System.setProperty("webdriver.chrome.driver", TestBase.GlobaldriverLocation + "\\chromedriver_mac");	
            driver = new ChromeDriver();
            return driver;
        }        
        return driver;
    }
}