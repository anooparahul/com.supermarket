package com.supermarket.tests;

import org.testng.annotations.Test;
import org.testng.annotations.*;

import com.supermarket.extendreports.ExtentManager;
import com.supermarket.utilities.GeneralUtilities;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseClass {
	WebDriver driver;
	GeneralUtilities guobj=new GeneralUtilities();
	public static Properties po;
	public static void testBasic() throws IOException {
		po=new Properties();
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\propertyFile\\configuration.properties");
		po.load(file);
	}
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod(alwaysRun=true)
  public void afterMethod(ITestResult result) throws IOException {
	  if(ITestResult.FAILURE==result.getStatus()) {
		  guobj.takescreenshot(driver,result.getName());
	  }
	  
  }
  @Parameters({"browser"})
  @BeforeClass(alwaysRun=true)
  public void beforeClass(String browser) throws IOException {
	  			testBasic();
	  			  driver=guobj.browserLaunch(po.getProperty("URL"), browser);
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
	  
  }

  @BeforeSuite(alwaysRun=true)
  public void createReport(final ITestContext testContext) {
	  ExtentManager.createInstance().createTest(testContext.getName(), "message");
  }

  @AfterSuite
  public void afterSuite() {
  }

}
