package com.supermarket.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GeneralUtilities {
    Faker faker = new Faker();
	WebDriver driver;
	public WebDriver browserLaunch(String url,String browser) {
		if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else {
			System.out.println("Please check the browser you launched.");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		return driver;
	}
	
	public void clickCommand(WebElement element) {
		element.click();
		
	}
	
	public void clearCommand(WebElement element) {
		element.clear();
	}
	
	public void sendkeysCommand(WebElement element,String text) {
		element.sendKeys(text);
		
	}
	
	public void movetoevementCommand(WebElement element,WebDriver driver) {
		Actions acobj=new Actions(driver);
		acobj.moveToElement(element).build().perform();
	}
	
	public void takescreenshot(WebDriver driver,String testcaseName) throws IOException {
		
		Date d=new Date();
		 String date=d.toString().replace(":", "_").replace(" ","_" );
	  TakesScreenshot ts=(TakesScreenshot) driver;
	  File sourcefile=ts.getScreenshotAs(OutputType.FILE);
	  FileHandler.copy(sourcefile, new File("./Screenshots/"+testcaseName+"_"+date+".jpg"));
	
		  
	}
	
	public void selectByVisibleText(WebElement element, String text) {
		Select select= new Select(element);
		select.selectByVisibleText(text);
	}	
	
	public void selectByindex(WebElement element, int index) {
		Select select= new Select(element);
		select.selectByIndex(index);
	}	
	
	public void selectByvalue(WebElement element, String text) {
		Select select= new Select(element);
		select.selectByValue(text);
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	
	
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	
	
	public void promptAlert(WebDriver driver,String text) {
		Alert alert=driver.switchTo().alert();
		alert.sendKeys(text);
		alert.accept();
		
		
	}
	
	public String getTitle(WebDriver driver) {
		String title=driver.getTitle();
		return title;
		
	}
	
	public String getcurrentUrl(WebDriver driver) {
		String title=driver.getCurrentUrl();
		return title;
		
	}
	
	public boolean validateDynamicWebtableColm(List<WebElement> allcol,String value) {
		boolean status=false;
			for(WebElement ele:allcol) {
			String value1=ele.getText();
			
			if(value1.contains(value)) {
				status=true;
				break;
				
			}
	}
			return status;
	}
	
	public void fackername(WebElement element) {
		
		String name=faker.name().fullName();
		element.sendKeys(name);
	}
	
public String fackeremail(WebElement element) {
		
		String email=faker.internet().emailAddress();
		element.sendKeys(email);
		return email;
	}
}
