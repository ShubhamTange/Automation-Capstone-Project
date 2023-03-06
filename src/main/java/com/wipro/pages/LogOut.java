package com.wipro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wipro.base.TestBase;

public class LogOut extends TestBase{
	By logout = By.xpath("//a[@class='ico-logout']");
	
	public boolean logOut() {
		wait(5000);
		driver.findElement(logout).click();
		
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