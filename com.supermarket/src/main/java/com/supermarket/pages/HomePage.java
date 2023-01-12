package com.supermarket.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.WaitUtility;

public class HomePage extends LoginPage {
	LoginPage lpobj;
	ExcelUtility exobj=new ExcelUtility();
	WaitUtility wtobj=new WaitUtility();
	GeneralUtilities guobj=new GeneralUtilities();
	@FindBy(xpath="//div[1]/p[text()='Manage Pages']") 
	WebElement managepagestext;
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//a[text()='More info ' and@href='https://groceryapp.uniqassosiates.com/admin/list-page']") 
	WebElement managepageslink;
	
	@FindBy(xpath="//div[1]/p[text()='Admin Users']") 
	WebElement adminusertext;
	
	@FindBy(xpath="//a[text()='More info ' and@href='https://groceryapp.uniqassosiates.com/admin/list-admin']") 
	WebElement adminuserslink;
	
	@FindBy(xpath="//a[text()='More info ' and@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy']") 
	WebElement deliveryboylink;
	
	@FindBy(xpath="//div[1]/p[text()='Category']") 
	WebElement categorytext;
	
	@FindBy(xpath="//a[text()='More info ' and@href='https://groceryapp.uniqassosiates.com/admin/list-category']") 
	WebElement categorylink;
	
	@FindBy(xpath="//a[text()='More info ' and@href='https://groceryapp.uniqassosiates.com/admin/list-slider']")
	WebElement listsliderlink;
	
	@FindBy(xpath="//a[text()='Home']")
	WebElement home;
	
	@FindBy(xpath="//h1[text()='List Pages']")
	WebElement managepageheading;
	
	@FindBy(xpath="//h1[text()='Admin Users']")
	WebElement adminusersheading;
	
	@FindBy(xpath="//h1[text()='List Categories']")
	WebElement categoryheading;
	
	@FindBy(xpath="//h1[@class='m-0 text-dark']")
	WebElement manageDeliveryBoyheading;
	
	@FindBy(xpath="//h1[@class='m-0 text-dark']")
	WebElement listsliderheading;
	
	
	public void managepageslink() {
		guobj.clickCommand(managepageslink);
		
	}
	public void adminUserslink() {
		guobj.clickCommand(adminuserslink);
		
	}
	public void categorylink() {
		guobj.clickCommand(categorylink);
		
	}
	public void deliveryboylink() {
		guobj.clickCommand(deliveryboylink);
		
	}
	
	public void listsliderlink() {
		guobj.clickCommand(listsliderlink);
	}
	
	public void navigateToHomePage() throws IOException {
		  lpobj=new LoginPage(driver);
	  	  lpobj.clearData();
	  	  lpobj.login(exobj.readStringData(1, 0),(exobj.readStringData(1, 1)));
	}
	
	public void navigateBack() {
		home.click();
	}
	
	public String getmanagepagesheading() {
		String text=managepageheading.getText();
		//System.out.println(text);
		return text;
	}
	
	public String getadminusersheading() {
		String text=adminusersheading.getText();
		return text;
	}
	
	public String getcategoryheading() {
		String text=categoryheading.getText();
		return text;
	}
	public String getdelboyheading() {
		String text=manageDeliveryBoyheading.getText();
		return text;
	}
	public String getmanagesliderheading() {
		String text=listsliderheading.getText();
		return text;
	}
	
}
