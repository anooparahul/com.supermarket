package com.supermarket.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.supermarket.constants.Constants;
import com.supermarket.extendreports.TestListener;
import com.supermarket.pages.LoginPage;
import com.supermarket.utilities.DataProviderUtility;
import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.RetryAnalizerUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class LoginTest extends BaseClass {
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	LoginPage lpobj;
	ExcelUtility exobj=new ExcelUtility();
	//String url="https://groceryapp.uniqassosiates.com/admin/login";
	@Test(priority=2, retryAnalyzer=RetryAnalizerUtility.class)
	  public void loginWithValidCredentials() throws IOException {
		  
		  lpobj=new LoginPage(driver);
		  lpobj.clearData();
		  lpobj.login(exobj.readStringData(1, 0),(exobj.readStringData(1, 1)));
		  Assert.assertTrue(lpobj.isDisplayedDashboard());
	  }
	  @Test(dataProvider="loginData",dataProviderClass=DataProviderUtility.class,priority=1)
	  public void loginWithinValidCredentials(String username,String password) throws IOException {
		  
		  lpobj=new LoginPage(driver);
		  lpobj.clearData();
		  lpobj.login(username,password);
		  Assert.assertEquals(lpobj.gerErrorMessage(), Constants.expectedResult);
	  }
	  
  

  

}
