package com.wipro.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wipro.base.TestBase;

public class ValidateMenuPage extends TestBase{
	By topMenuNotMobiles = By.xpath("/html/body/div[6]/div[2]/ul[1]");
	
	By computers = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a");
	By electronics = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/a");
	By apparel = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[3]/a");
	By digitals = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[4]/a");
	By books = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[5]/a");
	By jewelry = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[6]/a");
	By giftCards = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[7]/a");
	
	public boolean validateMenuList() {
		
		driver.findElement(computers).click();
		captureScreenshots("Computer");
		wait(1000);
		driver.findElement(electronics).click();
		captureScreenshots("Electronics");
		wait(1000);
		driver.findElement(apparel).click();
		captureScreenshots("Apparel");
		wait(1000);
		driver.findElement(digitals).click();
		captureScreenshots("Digitals");
		wait(1000);
		driver.findElement(books).click();
		captureScreenshots("Books");
		wait(1000);
		driver.findElement(jewelry).click();
		captureScreenshots("Jewelry");
		wait(1000);
		driver.findElement(giftCards).click();
		captureScreenshots("GiftCards");
		
		boolean actResult=true;
		try {
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Gift Cards']")));
		}catch(TimeoutException te) {
			actResult=false;
		}
		
		return actResult;
	}

}