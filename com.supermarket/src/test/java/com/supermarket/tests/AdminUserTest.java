package com.supermarket.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.supermarket.constants.Constants;
import com.supermarket.extendreports.TestListener;
import com.supermarket.pages.AdminUsersPage;
import com.supermarket.pages.HomePage;

public class AdminUserTest extends BaseClass {
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
  @Test(priority=1)
  public void addingUser() throws IOException, InterruptedException {
	  
	  AdminUsersPage admobj=new AdminUsersPage(driver);
	  admobj.navigateToAdminUserPage();
	  Assert.assertTrue(admobj.adduser()) ;
  }
  
  @Test(priority=2)
  public void searchuser() throws IOException {
	 
	  AdminUsersPage admobj=new AdminUsersPage(driver);
	  Assert.assertTrue(admobj.searchaddeduser());
	  
  }
  
  @Test(priority=5)
  public void passworddetails() throws InterruptedException {
	  AdminUsersPage admobj=new AdminUsersPage(driver);
	  Assert.assertEquals(admobj.passworddetailscheck(),Constants.password,"Psssed");

  }
  @Test(priority=3)
  public void makeuserdeactive() {
	  AdminUsersPage admobj=new AdminUsersPage(driver);
	  Assert.assertEquals(admobj.userstatusdeactvate(),Constants.deactive,"Passed");
  }
  @Test(priority=4)
  public void makeuseractive() {
	  AdminUsersPage admobj=new AdminUsersPage(driver);
	  Assert.assertEquals(admobj.userstatusactvate(),Constants.active);
  }
  
  
  @Test(priority=6)
  public void userRemoval() {
	  AdminUsersPage admobj=new AdminUsersPage(driver);
	  admobj.deleteuser();
	  Assert.assertNotEquals(admobj.addeddatacheck(), Constants.addnew);  

  }
}
