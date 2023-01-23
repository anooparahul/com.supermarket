package com.supermarket.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.supermarket.constants.Constants;
import com.supermarket.extendreports.TestListener;
import com.supermarket.pages.HomePage;
import com.supermarket.pages.LoginPage;
import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.WaitUtility;

public class HomeTest extends BaseClass{
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	LoginPage lpobj;
	
	ExcelUtility exobj=new ExcelUtility();
	WaitUtility wtobj=new WaitUtility();
    @Test(priority=2,groups="sanity")
  public void managepageslinkclick() throws IOException {
    

	  HomePage hmobj=new HomePage(driver);
	  hmobj.managepageslink();
	  Assert.assertEquals(hmobj.getmanagepagesheading(),Constants.manageuserheading,"Passed");
	  hmobj.navigateBack();
  }
    @Test(priority=1,enabled=true,groups="sanity")
    public void adminUserslinkclick() throws IOException {
  	 
  	  HomePage hmobj=new HomePage(driver);
  	  hmobj.navigateToHomePage();
  	  hmobj.adminUserslink();
  	  Assert.assertEquals(hmobj.getadminusersheading(),Constants.manageadminheading,"Passed");
  	  hmobj.navigateBack();
    }
    @Test(priority=3)
    public void categorylinkclick() throws IOException {
  	  HomePage hmobj=new HomePage(driver);
  	  hmobj.categorylink();
  	  Assert.assertEquals(hmobj.getcategoryheading(),Constants.categoryheading,"Passed");
  	  hmobj.navigateBack();
    }
    
    @Test(priority=4)
    public void deliveryboylinkclick() throws IOException {
  	  HomePage hmobj=new HomePage(driver);
  	  hmobj.deliveryboylink();
  	  Assert.assertEquals(hmobj.getdelboyheading(),Constants.deliveryBoyheading,"Passed");
  	  hmobj.navigateBack();
    }
  
    @Test(priority=5)
    public void managesliderclick() throws IOException {
  	  HomePage hmobj=new HomePage(driver);
  	  hmobj.listsliderlink();
  	  Assert.assertEquals(hmobj.getmanagesliderheading(),Constants.manageslider,"Passed");
  	  hmobj.navigateBack();
    }
    
    @Test(priority=6)
    public void manageproductlinkclick() throws IOException {
  	  HomePage hmobj=new HomePage(driver);
  	  hmobj.manageproductlink();
  	  Assert.assertEquals(hmobj.getmanageproduheading(),Constants.managesproduct,"Passed");
  	  hmobj.navigateBack();
    }
    
    @Test(priority=7)
    public void manageoffercodelinkclick() throws IOException {
  	  HomePage hmobj=new HomePage(driver);
  	  hmobj.manageoffercodelink();
  	  Assert.assertEquals(hmobj.getmanageoffercodeheading(),Constants.managesoffercode,"Passed");
  	  hmobj.navigateBack();
    }
    
    @Test(priority=8)
    public void manageuserlinkclick() throws IOException {
  	  HomePage hmobj=new HomePage(driver);
  	  hmobj.manageuserlink();
  	  Assert.assertEquals(hmobj.getmanageuserheading(),Constants.listusers,"Passed");
  	  hmobj.navigateBack();
    }
    
    @Test(priority=9)
    public void managelocationlinkclick() throws IOException {
  	  HomePage hmobj=new HomePage(driver);
  	  hmobj.managelistlink();
  	  Assert.assertEquals(hmobj.getmanagelocationheading(),Constants.listlocation,"Passed");
  	  hmobj.navigateBack();
    }
}
