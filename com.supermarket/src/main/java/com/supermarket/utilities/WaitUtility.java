package com.supermarket.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	public void fluentWait(WebDriver driver,WebElement element) {
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(10))
				  .pollingEvery(Duration.ofSeconds(2))
				  .ignoring(Exception.class);
		  wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		  
	  }
	public void implicitwait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void explicitWaitelementSelectionStateToBe(WebDriver driver, WebElement element) {
		WebDriverWait explicitwait=new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitwait.until(ExpectedConditions.elementSelectionStateToBe(element, true) );
	}
}


