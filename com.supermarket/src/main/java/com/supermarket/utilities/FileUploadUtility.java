package com.supermarket.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FileUploadUtility {
	public void fileUpload(WebElement element, String location) {
		element.sendKeys(location);
	}
	
	public void uploadRobotclass(WebElement element, String fileupload) throws Exception {
		StringSelection s=new StringSelection(fileupload);
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		  element.click();
		  Robot robot=new Robot();
		  robot.delay(250);
		  Thread.sleep(3000);
		  robot.keyPress(KeyEvent.VK_ENTER);
		  robot.delay(250);
		  robot.keyRelease(KeyEvent.VK_ENTER);
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_V);
		  robot.keyRelease(KeyEvent.VK_CONTROL);
		  robot.keyRelease(KeyEvent.VK_V);
		  robot.keyPress(KeyEvent.VK_ENTER);
		  robot.delay(250);
		  robot.keyRelease(KeyEvent.VK_ENTER);
	}

}
