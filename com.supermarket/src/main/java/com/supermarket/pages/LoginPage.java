package com.supermarket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(xpath="//input[@name='username']") 
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement signin;
	
	@FindBy(xpath="//li[text()='Dashboard']")
	WebElement dashboard;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement errormessge;
	
		
	public void login(String username1, String password1) {
		username.sendKeys(username1);
		password.sendKeys(password1);
		signin.click();
	}
	
	public String gerErrorMessage() {
		String errorMessage=errormessge.getText();
		return errorMessage;
	}
	
	public void clearData() {
		username.clear();
		password.clear();
	}
	public boolean isDisplayedDashboard() {
		boolean returndashval=dashboard.isDisplayed();
		return returndashval;
	}
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
