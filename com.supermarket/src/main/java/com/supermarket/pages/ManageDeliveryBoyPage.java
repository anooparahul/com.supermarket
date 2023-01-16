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
	
	public String addDeliveryBoy() throws AWTException, InterruptedException, IOException {
		guobj.clickCommand(newButton);
		guobj.sendkeysCommand(name, exobj.readStringData(10, 1));
		guobj.sendkeysCommand(email, exobj.readStringData(11, 1));
		guobj.sendkeysCommand(phone, "1023456789");
		guobj.sendkeysCommand(address, exobj.readStringData(13, 1));
		guobj.sendkeysCommand(username, exobj.readStringData(14, 1));
		guobj.sendkeysCommand(password, exobj.readStringData(15, 1));
		Robot robot=new Robot();
		robot.delay(450);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		String value=newDeliveryboy.getText();
		return value;
	}
	
	public String searchDeliveryBoy() throws IOException {
		guobj.clickCommand(searchButton);
		guobj.sendkeysCommand(namesearch, exobj.readStringData(10, 1));
		guobj.clickCommand(searchButton1);
		String value=newDeliveryboy.getText();
		
		return value;
		
		
	}
	public String passworddetailscheck() throws InterruptedException {
		guobj.clickCommand(passwordShow);
		Thread.sleep(5000);
		String value=passwordDetails.getText();
		return value;
	
	}
	public String userstatusdeactvate() {
		guobj.clickCommand(statusactive);
		String value=statusdeactive.getText();
		return value;
	}
	
	public String userstatusactvate() {
		guobj.clickCommand(statusdeactive);
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

	public String  editDeliveryboy() throws AWTException, InterruptedException, IOException {
		guobj.clickCommand(editIcon);
		guobj.clearCommand(username);
		guobj.sendkeysCommand(username,exobj.readStringData(17, 1));
		guobj.clearCommand(password);
		guobj.sendkeysCommand(password, exobj.readStringData(18, 1));
		Robot robot=new Robot();
		robot.delay(450);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		String value=updatemessage.getText();
		//System.out.println(value);
		return value;
	}
	
	public String deleteuser() {
		guobj.clickCommand(deleteIcon);
		driver.switchTo().alert().accept();
		String value=deletemessage.getText();
		//System.out.println(value);
		return value;
	}
}
