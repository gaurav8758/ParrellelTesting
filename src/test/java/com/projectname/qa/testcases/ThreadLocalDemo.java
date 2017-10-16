package com.projectname.qa.testcases;

import org.testng.annotations.Test;

import com.projectname.qa.base.TestBase;

public class ThreadLocalDemo extends TestBase {
	   @Test
	    public void testMethod1() {
	        getDriver();
	    }
	 
	    @Test
	    public void testMethod2() {
	    	getDriver();
	    }
	    
	   @Test
	    public void testMethod3() {
		   getDriver();
	    }
	 
	    @Test
	    public void testMethod4() {
	    	getDriver();
	    }

}
