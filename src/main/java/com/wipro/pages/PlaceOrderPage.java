package com.wipro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wipro.base.TestBase;
import com.wipro.utilities.WriteIntoFile;

public class PlaceOrderPage extends TestBase{
	//locating webElements
	By clickOnComp = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a");
	By clickOnDesktop = By.xpath("/html/body/div[6]/div[3]/div/div[2]/div[1]/div[2]/ul/li[1]/ul/li[1]/a");
	By fetchProdName = By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/h2/a");
	By fetchProdPrice = By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div[1]/span");
	By clickOnAddToCart = By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div[2]/button[1]");
	By clickOnShoppingCart = By.cssSelector("#topcartlink > a");
	By clickCheckBox = By.xpath("//*[@id=\"termsofservice\"]");
	By checkOut = By.xpath("//*[@id=\"checkout\"]");
	By shoppingCartTextCheck = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[1]/h1");
	By clickContinue = By.xpath("//*[@id=\"billing-buttons-container\"]/button[4]");
	By shipContinue = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button");
	By paymentContinue = By.xpath("//*[@id=\"payment-method-buttons-container\"]/button");
	By paymentInfoContinue = By.xpath("//*[@id=\"payment-info-buttons-container\"]/button");
	By cnfBtn = By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button");
	By cnfMsg = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong");
	
WebDriverWait wait = new WebDriverWait(driver, 10);
	
	// code for select desktop from category
	public boolean selectDesktop() {
		driver.findElement(clickOnComp).click();
		wait(2000);
		driver.findElement(clickOnDesktop).click();
		wait(3000);
		String ProductName = driver.findElement(fetchProdName).getText();
		String ProductPrice = driver.findElement(fetchProdPrice).getText();
	
		WriteIntoFile.writeData(ProductName, ProductPrice);
		boolean actResult = driver.findElement(clickOnAddToCart).isDisplayed();
		return actResult;
	}
	
	//Code for add products to the Add To Cart Section
	public boolean addToCart() {
		driver.findElement(clickOnAddToCart).click();
		wait(10000);
		boolean actResult = driver.findElement(clickOnShoppingCart).isDisplayed();
		return actResult;
	}

	
	//Click on Shopping Cart Section
	public boolean clickShoppingCart() {
		driver.findElement(clickOnShoppingCart).click();
		wait(1000);
		driver.findElement(clickCheckBox).click();
		wait(1000);
		boolean actResult = driver.findElement(shoppingCartTextCheck).isDisplayed();
		return actResult;
	}
	
	//Click on CheckOut
	public boolean clickCheckout() {
		driver.findElement(checkOut).click();
		wait(1000);
		driver.findElement(clickContinue).click();
		wait(1000);
		driver.findElement(shipContinue).click();
		wait(5000);
		boolean actResult = driver.findElement(paymentContinue).isDisplayed();
		return actResult;
		
	}

	// Code for making payment process
	public boolean makePayment() {
		driver.findElement(By.xpath("//*[@id=\"paymentmethod_0\"]")).click();
		driver.findElement(paymentContinue).click();
		wait(1000);
		driver.findElement(paymentInfoContinue).click();
		wait(5000);
		boolean actResult = driver.findElement(cnfBtn).isDisplayed();
		return actResult;
		
	}

	//Click on confirm Button
	public boolean clickConfirm() {
		driver.findElement(cnfBtn).click();
		wait(1000);
		
		//Check whether Clicked or not
		boolean actResult = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(cnfMsg));
		} catch (TimeoutException te) {
			actResult = false;
			captureScreenshots("login failure");
		}

		return actResult;
		
	}
	
//	public boolean validatePlaceOrder() {
//		driver.findElement(clickOnComp).click();
//		wait(1000);
//		driver.findElement(clickOnDesktop).click();
//		wait(1000);
//		String ProductName = driver.findElement(fetchProdName).getText();
//		String ProductPrice = driver.findElement(fetchProdPrice).getText();
//		
//		WriteIntoFile.writeData(ProductName, ProductPrice);
//		
//		
//		wait(1000);
//		driver.findElement(clickOnAddToCart).click();;
//		wait(10000);
////		driver.findElement(clickOnShoppingCart)
//		driver.findElement(clickOnShoppingCart).click();
//		wait(1000);
//		driver.findElement(clickCheckBox).click();
//		wait(1000);
//		driver.findElement(checkOut).click();
//		wait(1000);
////		//add address 
//////		driver.findElement(bgFname).sendKeys("Shubham");
//////		wait(1000);
//////		driver.findElement(bglname).sendKeys("Tange");
//////		wait(1000);
//////		driver.findElement(bgEmail).sendKeys("shubhamtange167@gmail.com");
//////		wait(1000);
////		driver.findElement(slctCntry).click();
////		wait(1000);
////		driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_StateProvinceId\"]/option[2]")).click();
////		wait(1000);
////		driver.findElement(cityName).sendKeys("Chennai");
////		wait(1000);
////		driver.findElement(bgAddress).sendKeys("Absgd");
////		wait(1000);
////		driver.findElement(bgZipCode).sendKeys("102504");
////		wait(1000);
////		driver.findElement(bgPhone).sendKeys("1025012544");
////		wait(1000);
////		driver.findElement(bgContnu).click();
////		wait(1000);
//		driver.findElement(clickContinue).click();
//		wait(1000);
//		driver.findElement(shipContinue).click();
//		wait(10000);
//		driver.findElement(By.xpath("//*[@id=\"paymentmethod_0\"]")).click();
//		driver.findElement(paymentContinue).click();
//		wait(1000);
//		driver.findElement(paymentInfoContinue).click();
//		wait(10000);
//		driver.findElement(cnfBtn).click();
//		wait(1000);
////		driver.findElement(cnfMsg).click();
////		wait(1000);
//		WebDriverWait wait = new WebDriverWait(driver,10);
//		boolean actResult = true;
//		try {
//		wait.until(ExpectedConditions.visibilityOfElementLocated(cnfMsg));
////		driver.findElement(logout).click();
//		}catch(TimeoutException te) {
//			actResult = false;
//			captureScreenshots("PlaceOrder failure");
////			te.printStackTrace();
//		}
//		
//		return actResult;
//		
//	}


}
