package com.wipro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wipro.base.TestBase;

public class LoginPage extends TestBase{
	By login = By.linkText("Log in");
	By email = By.id("Email");
	By password = By.id("Password");
	By loginButton = By.xpath("//button[text()='Log in']");
	//By logout = By.className("ico-logout12");
	public boolean validateLogin(String uname, String pwd) {
		
		
		driver.findElement(login).click();
		wait(1000);
		driver.findElement(email).sendKeys(uname);
		wait(1000);
		driver.findElement(password).sendKeys(pwd);
		wait(1000);
		driver.findElement(loginButton).click();
		
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		boolean actResult = true;
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ico-logout")));
//		driver.findElement(logout).click();
		}catch(TimeoutException te) {
			actResult = false;
			captureScreenshots("login failure");
//			te.printStackTrace();
		}
		
		return actResult;
		
	}
	
//	public void AddAddress() {
//		
//	}
}
