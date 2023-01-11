package com.supermarket.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.constants.Constants;
import com.supermarket.pages.AdminUsersPage;
import com.supermarket.pages.HomePage;

public class AdminUserTest extends BaseClass {
  @Test(priority=1)
  public void addingUser() throws IOException, InterruptedException {
	  
	  AdminUsersPage admobj=new AdminUsersPage(driver);
	  admobj.navigateToAdminUserPage();
	  admobj.adduser();
	  String value=admobj.addeddatacheck();
	  Assert.assertEquals(value, Constants.addnew);  

	  //admobj.navigatetoHome();
  }
  
  @Test(priority=2)
  public void searchuser() throws IOException {
	 
	  AdminUsersPage admobj=new AdminUsersPage(driver);
	  //admobj.navigateToAdminUserPage();
	  admobj.searchaddeduser();
	  admobj.addeddatacheck();
	  //admobj.navigatetoHome();
  }
  
  @Test(priority=3)
  public void passworddetails() throws InterruptedException {
	  AdminUsersPage admobj=new AdminUsersPage(driver);
	  //admobj.passworddetailscheck();
	  String value=admobj.passworddetailscheck();
	  System.out.println(value);
  	  Assert.assertEquals(value,Constants.password);

  }
  @Test(priority=4)
  public void makeuserdeactive() {
	  AdminUsersPage admobj=new AdminUsersPage(driver);
	  String value=admobj.userstatusdeactvate();
	  Assert.assertEquals(value,Constants.deactive);
  }
  @Test(priority=5)
  public void makeuseractive() {
	  AdminUsersPage admobj=new AdminUsersPage(driver);
	  String value=admobj.userstatusactvate();
	  Assert.assertEquals(value,Constants.active);
  }
  
  
  @Test(priority=6)
  public void userRemoval() {
	  AdminUsersPage admobj=new AdminUsersPage(driver);
	  admobj.deleteuser();
	  String value=admobj.addeddatacheck();
	  Assert.assertNotEquals(value, Constants.addnew);  

  }
}
