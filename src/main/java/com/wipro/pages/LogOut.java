package com.wipro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wipro.base.TestBase;

public class LogOut extends TestBase{
	
	// Locate WebElements on Web Site 
	By logout = By.xpath("//a[@class='ico-logout']");
	
	//Code for LogOut
	public boolean logOut() {
		wait(5000);
		driver.findElement(logout).click();
		
		//Check Whether you successfully logout or  not
		boolean actResult=true;
		try {
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='ico-login']")));
		}catch(TimeoutException te) {
			actResult=false;
			captureScreenshots("logout failure");
		}
		
		return actResult;
	}
}