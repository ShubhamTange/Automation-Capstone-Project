package com.wipro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wipro.base.TestBase;

public class RegistrationPage extends TestBase{
	By register = By.linkText("Register");
	By genderRadio = By.id("gender-male");
	By firstName = By.id("FirstName");
	By lastName = By.id("LastName");
	By emailId = By.id("Email");
	By pwd = By.id("Password");
	By cnfpwd = By.id("ConfirmPassword");
	By rgstrBtn = By.id("register-button");
	By cntnue = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]");
	
public boolean createAccount(String fname, String lname, String emailid, String passwd, String cnfpass) {
		
		
		driver.findElement(register).click();
		wait(1000);
		driver.findElement(genderRadio).click();
		wait(1000);
		driver.findElement(firstName).sendKeys(fname);
		wait(1000);
		driver.findElement(lastName).sendKeys(lname);
		wait(1000);
		driver.findElement(emailId).sendKeys(emailid);
		wait(1000);
		driver.findElement(pwd).sendKeys(passwd);
		wait(1000);
		driver.findElement(cnfpwd).sendKeys(cnfpass);
		wait(1000);
		driver.findElement(rgstrBtn).click();
		wait(1000);
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		boolean actResult = true;
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(cntnue));
//		driver.findElement(logout).click();
		}catch(TimeoutException te) {
			actResult = false;
			captureScreenshots("registration failure");
//			te.printStackTrace();
		}
		return actResult;
}
}
