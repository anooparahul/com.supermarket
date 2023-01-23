package com.supermarket.tests;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.supermarket.constants.Constants;
import com.supermarket.extendreports.TestListener;
import com.supermarket.pages.AdminUsersPage;
import com.supermarket.pages.ManageDeliveryBoyPage;

public class DeliveryBoyTest extends BaseClass {
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	@Test(priority=1)
	public void addDeliveryBoy() throws IOException, AWTException, InterruptedException {
		ManageDeliveryBoyPage mdpobj=new ManageDeliveryBoyPage(driver);
		mdpobj.navigatetodeliveryboy();
		  Assert.assertTrue(mdpobj.addDeliveryBoy());  
	}
	
	@Test(priority=2,enabled=true)
	public void searchDeliveryBoy() throws IOException, AWTException {
		ManageDeliveryBoyPage mdpobj=new ManageDeliveryBoyPage(driver);
	
		 Assert.assertTrue(mdpobj.searchDeliveryBoy());  
	}
	
	@Test(priority=3,enabled=true)
	public void passworddetailschecking() throws InterruptedException {
		ManageDeliveryBoyPage mdpobj=new ManageDeliveryBoyPage(driver);
	
		 Assert.assertEquals(mdpobj.passworddetailscheck(), Constants.password,"Passed"); 
	}
	  @Test(priority=4)
	  public void makeuserdeactive() {
		  ManageDeliveryBoyPage mdpobj=new ManageDeliveryBoyPage(driver);
		  Assert.assertEquals(mdpobj.userstatusdeactvate(),Constants.deactive,"Passed");
	  }
	  @Test(priority=5)
	  public void makeuseractive() {
		  ManageDeliveryBoyPage mdpobj=new ManageDeliveryBoyPage(driver);
		  Assert.assertEquals(mdpobj.userstatusactvate(),Constants.active,"Passed");
	  }
	  
	
	@Test(priority=6)
	public void updateDeliveryBoy() throws AWTException, InterruptedException, IOException {
		ManageDeliveryBoyPage mdpobj=new ManageDeliveryBoyPage(driver);
		 Assert.assertTrue(true, mdpobj.editDeliveryboy());
	}
	
	  @Test(priority=7)
	  public void userRemoval() {
		  ManageDeliveryBoyPage mdpobj=new ManageDeliveryBoyPage(driver);
		 
		  Assert.assertTrue(true, mdpobj.deleteuser()); 

	  }
}
