package com.supermarket.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.Alert;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class GeneralUtilities {
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
	//This is for the click action
	public void clickCommand(WebElement element) {
		element.click();
		
	}
	//This is for the clear actions
	public void clearCommand(WebElement element) {
		element.clear();
	}
	//This is for the send keys action
	public void sendkeysCommand(WebElement element,String text) {
		element.sendKeys(text);
		
	}
	//This is for mouse actions
	public void movetoevementCommand(WebElement element,WebDriver driver) {
		Actions acobj=new Actions(driver);
		acobj.moveToElement(element).build().perform();
	}
	//This is for taking the screen shot
	public void takescreenshot(WebDriver driver,String testcaseName) throws IOException {
		
		Date d=new Date();
		 String date=d.toString().replace(":", "_").replace(" ","_" );
	  TakesScreenshot ts=(TakesScreenshot) driver;
	  File sourcefile=ts.getScreenshotAs(OutputType.FILE);
	  FileHandler.copy(sourcefile, new File("./Screenshots/"+testcaseName+"_"+date+".jpg"));
	
		  
	}
	//This is for selecting the drop down value
	public void selectByVisibleText(WebElement element, String text) {
		Select select= new Select(element);
		select.selectByVisibleText(text);
	}	
	//This is for accepting an alert
		
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	//This is for dismissing an alert
	
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	//This is for entering text in promt alert and then accept
	
	public void promptAlert(WebDriver driver,String text) {
		Alert alert=driver.switchTo().alert();
		alert.sendKeys(text);
		alert.accept();
		
		
	}
}
