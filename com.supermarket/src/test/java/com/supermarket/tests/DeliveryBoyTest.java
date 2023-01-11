package com.supermarket.tests;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.constants.Constants;
import com.supermarket.pages.AdminUsersPage;
import com.supermarket.pages.ManageDeliveryBoyPage;

public class DeliveryBoyTest extends BaseClass {

	@Test(priority=1)
	public void addDeliveryBoy() throws IOException, AWTException, InterruptedException {
		ManageDeliveryBoyPage mdpobj=new ManageDeliveryBoyPage(driver);
		mdpobj.navigatetodeliveryboy();
		 String value=mdpobj.addDeliveryBoy();
		  Assert.assertEquals(value, Constants.addnew);  
	}
	
	@Test(priority=2,enabled=true)
	public void searchDeliveryBoy() throws IOException, AWTException {
		ManageDeliveryBoyPage mdpobj=new ManageDeliveryBoyPage(driver);
		//mdpobj.navigatetodeliveryboy();
		 String value=mdpobj.searchDeliveryBoy();
		 Assert.assertEquals(value, Constants.addnew);  
	}
	
	@Test(priority=3,enabled=true)
	public void passworddetailschecking() throws InterruptedException {
		ManageDeliveryBoyPage mdpobj=new ManageDeliveryBoyPage(driver);
		//mdpobj.navigatetodeliveryboy();
		 String value=mdpobj.passworddetailscheck();
		 Assert.assertEquals(value, Constants.password); 
	}
	  @Test(priority=4)
	  public void makeuserdeactive() {
		  ManageDeliveryBoyPage mdpobj=new ManageDeliveryBoyPage(driver);
		  String value=mdpobj.userstatusdeactvate();
		  Assert.assertEquals(value,Constants.deactive);
	  }
	  @Test(priority=5)
	  public void makeuseractive() {
		  ManageDeliveryBoyPage mdpobj=new ManageDeliveryBoyPage(driver);
		  String value=mdpobj.userstatusactvate();
		  Assert.assertEquals(value,Constants.active);
	  }
	  
	
	@Test(priority=6)
	public void updateDeliveryBoy() throws AWTException, InterruptedException {
		ManageDeliveryBoyPage mdpobj=new ManageDeliveryBoyPage(driver);
		//mdpobj.navigatetodeliveryboy();
		 String value=mdpobj.editDeliveryboy();
		 Assert.assertTrue(true, value);
	}
	
	  @Test(priority=7)
	  public void userRemoval() {
		  ManageDeliveryBoyPage mdpobj=new ManageDeliveryBoyPage(driver);
		 
		  String value= mdpobj.deleteuser();
		  Assert.assertTrue(true, value); 

	  }
}
