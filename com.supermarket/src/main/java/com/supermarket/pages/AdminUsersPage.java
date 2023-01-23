package com.supermarket.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.WaitUtility;

public class AdminUsersPage extends LoginPage {
	LoginPage lpobj;
	ExcelUtility exobj=new ExcelUtility();
	WaitUtility wtobj=new WaitUtility();
	GeneralUtilities guobj=new GeneralUtilities();
	HomePage hmobj;
	public AdminUsersPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//select[@name='user_type']")
	WebElement usertype;
	
	@FindBy(xpath="//button[@name='Create']")
	WebElement saveButton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement addedmessage;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr")
	List<WebElement> row;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]")
	WebElement rowvalue;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[2]/td")
	List<WebElement> column;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement search;
	
	@FindBy(xpath="//input[@name='un']")
	WebElement usernamesearch;
	
	@FindBy(xpath="//select[@id='ut']")
	WebElement usertypesearch;
	
	@FindBy(xpath="//button[@name='Search']")
	WebElement Searchbutton;
	
	@FindBy(xpath="//a[text()='Home']")
	WebElement home;
	
	@FindBy(xpath="//i[@class='fas fa-bars']")
	WebElement delete;
	
	@FindBy(xpath="//i[@class='fa fa-angle-double-down']")
	WebElement detailssymbol;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[2]/td/div/div/span")
	WebElement passworddetails;
	
	
	
	@FindBy(xpath="//span[@class='badge bg-success']")
	WebElement statusactive;
	
	@FindBy(xpath="//span[@class='badge bg-warning']")
	WebElement statusdeactive;
	
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement deletebutton;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tr/td[1]")
	List<WebElement> allcol;
	
	public boolean adduser() throws IOException {
		guobj.clickCommand(newbutton);
		guobj.sendkeysCommand(username, exobj.readStringData(4, 1));
		guobj.sendkeysCommand(password, exobj.readStringData(5, 1));
		Select s=new Select(usertype);
		s.selectByValue(exobj.readStringData(6, 1));
		saveButton.click();
		String value= exobj.readStringData(4, 1);
		boolean status=guobj.validateDynamicWebtableColm(allcol, value);
		return status;
	}
	
	public String getaddmessage() {
		String text=addedmessage.getText();
		System.out.println(text);
		return text;
	}
	
	public void navigateToAdminUserPage() throws IOException {
		
	  	  HomePage hmobj=new HomePage(driver);
	  	  hmobj.navigateToHomePage();
	  	  hmobj.adminUserslink();
	}
	
	public String addeddatacheck() {
		String value=rowvalue.getText();
		return value;
	}
	
	public void navigatetoHome() {
		home.click();
	}
	
	public boolean searchaddeduser() throws IOException {
		guobj.clickCommand(search);
		guobj.sendkeysCommand(usernamesearch, exobj.readStringData(4, 1));
		String value=exobj.readStringData(4, 1);
		Select s=new Select(usertypesearch);
		s.selectByValue(exobj.readStringData(6, 1));
		Searchbutton.click();
		boolean status=guobj.validateDynamicWebtableColm(allcol, value);
		return status;
		
	}
	
	public String passworddetailscheck() throws InterruptedException {
		guobj.clickCommand(detailssymbol);
		
		wtobj.generalSleep();
		String value=passworddetails.getText();
		System.out.println(value);
		return value;
	
	}

	public String userstatusdeactvate() {
		
		guobj.clickCommand(statusactive);
		
		String value=statusdeactive.getText();
		return value;
	}
	
	public String userstatusactvate() {
		
		guobj.clickCommand(statusdeactive);
		
		String value=statusactive.getText();
		return value;
	}
	
	public void deleteuser() {
		guobj.clickCommand(deletebutton);
		
		driver.switchTo().alert().accept();
	}
}
