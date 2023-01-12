package com.supermarket.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.constants.Constants;
import com.supermarket.pages.HomePage;
import com.supermarket.pages.LoginPage;
import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.WaitUtility;

public class HomeTest extends BaseClass{
	LoginPage lpobj;
	
	ExcelUtility exobj=new ExcelUtility();
	WaitUtility wtobj=new WaitUtility();
    @Test(priority=2,groups="sanity")
  public void managepageslinkclick() throws IOException {
    

	  HomePage hmobj=new HomePage(driver);
	  //hmobj.navigateToHomePage();
	  hmobj.managepageslink();
	  Assert.assertEquals(hmobj.getmanagepagesheading(),Constants.manageuserheading);
	  hmobj.navigateBack();
  }
    @Test(priority=1,enabled=true,groups="sanity")
    public void adminUserslinkclick() throws IOException {
  	 
  	  HomePage hmobj=new HomePage(driver);
  	  hmobj.navigateToHomePage();
  	  hmobj.adminUserslink();
  	  Assert.assertEquals(hmobj.getadminusersheading(),Constants.manageadminheading);
  	  hmobj.navigateBack();
    }
    @Test(priority=3)
    public void categorylinkclick() throws IOException {
  	  HomePage hmobj=new HomePage(driver);
  	  hmobj.categorylink();
  	  Assert.assertEquals(hmobj.getcategoryheading(),Constants.categoryheading);
  	  hmobj.navigateBack();
    }
    
    @Test(priority=4)
    public void deliveryboylinkclick() throws IOException {
  	  HomePage hmobj=new HomePage(driver);
  	  hmobj.deliveryboylink();
  	  Assert.assertEquals(hmobj.getdelboyheading(),Constants.deliveryBoyheading);
  	  hmobj.navigateBack();
    }
  
    @Test(priority=5)
    public void managesliderclick() throws IOException {
  	  HomePage hmobj=new HomePage(driver);
  	  hmobj.managepageslink();
  	  Assert.assertEquals(hmobj.getmanagesliderheading(),Constants.manageslider);
  	  hmobj.navigateBack();
    }
    
}
