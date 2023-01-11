package com.supermarket.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtilities;

public class ManageDeliveryBoyPage extends LoginPage {
	LoginPage lpobj;
	HomePage hmobj=new HomePage(driver);
	ExcelUtility exobj=new ExcelUtility();
	GeneralUtilities guobj=new GeneralUtilities();
	

	public ManageDeliveryBoyPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton ;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton ;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']")
	WebElement resetButton ;
	
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement editIcon ;
	
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement deleteIcon ;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement name ;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email ;
	
	@FindBy(xpath="//input[@id='phone']")
	WebElement phone ;

	@FindBy(xpath="//textarea[@id='address']")
	WebElement address ;
	
	@FindBy(xpath="//input[@id='username']")
	WebElement username ;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password ;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveButton ;
	
	@FindBy(xpath="//input[@id='un']")
	WebElement namesearch ;
	
	@FindBy(xpath="//button[@name='Search']")
	WebElement searchButton1 ;
	
	@FindBy(xpath="//span[@class='badge bg-success']")
	WebElement statusactive ;
	
	@FindBy(xpath="//span[@class='badge bg-warning']")
	WebElement statusdeactive ;
	
	@FindBy(xpath="//div[@class='action-buttons']")
	WebElement passwordShow ;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[2]/td/div/div/span")
	WebElement passwordDetails ;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]")
	WebElement newDeliveryboy;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement updatemessage;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement deletemessage;
	
	public String addDeliveryBoy() throws AWTException, InterruptedException {
		guobj.clickCommand(newButton);
		guobj.sendkeysCommand(name, "Anoopa");
		guobj.sendkeysCommand(email, "asugathan@as.com");
		guobj.sendkeysCommand(phone, "1023456789");
		guobj.sendkeysCommand(address, "Abcd 4/1, Trivandrum");
		guobj.sendkeysCommand(username, "anoopa");
		guobj.sendkeysCommand(password, "password1");
		Robot robot=new Robot();
		robot.delay(350);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		String value=newDeliveryboy.getText();
		return value;
	}
	
	public String searchDeliveryBoy() {
		guobj.clickCommand(searchButton);
		guobj.sendkeysCommand(namesearch, "Anoopa");
		guobj.clickCommand(searchButton1);
		String value=newDeliveryboy.getText();
		
		return value;
		
		
	}
	public String passworddetailscheck() throws InterruptedException {
		passwordShow.click();
		Thread.sleep(5000);
		String value=passwordDetails.getText();
		//System.out.println(value);
		return value;
	
	}
	public String userstatusdeactvate() {
		//status.getText();
		statusactive.click();
		String value=statusdeactive.getText();
		return value;
	}
	
	public String userstatusactvate() {
		//status.getText();
		statusdeactive.click();
		String value=statusactive.getText();
		return value;
	}
	
	public void navigatetodeliveryboy() throws IOException
	{
		HomePage hmobj=new HomePage(driver);
	  	  //wtobj.explicitWaitelementSelectionStateToBe(driver, hmobj.adminuserslink);
	  	  hmobj.navigateToHomePage();
	  	  hmobj.deliveryboylink();
	}

	public String  editDeliveryboy() throws AWTException, InterruptedException {
		guobj.clickCommand(editIcon);
		guobj.clearCommand(username);
		guobj.sendkeysCommand(username,"sanoopa");
		guobj.clearCommand(password);
		guobj.sendkeysCommand(password, "password2");
		Robot robot=new Robot();
		robot.delay(350);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		String value=updatemessage.getText();
		//System.out.println(value);
		return value;
	}
	
	public String deleteuser() {
		deleteIcon.click();
		driver.switchTo().alert().accept();
		String value=deletemessage.getText();
		//System.out.println(value);
		return value;
	}
}
