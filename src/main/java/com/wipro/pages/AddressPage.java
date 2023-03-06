package com.wipro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wipro.base.TestBase;

public class AddressPage extends TestBase{
	
	// Locate WebElements on Web Site 
	By addNew = By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[2]/button");
	By firstName = By.xpath("//*[@id=\"Address_FirstName\"]");
	By lastName = By.xpath("//*[@id=\"Address_LastName\"]");
	By email = By.xpath("//*[@id=\"Address_Email\"]");
	By country = By.xpath("//*[@id=\"Address_CountryId\"]/option[2]");
	By city = By.xpath("//*[@id=\"Address_City\"]");
	By address1 = By.xpath("//*[@id=\"Address_Address1\"]");
	By zipCode = By.xpath("//*[@id=\"Address_ZipPostalCode\"]");
	By phoneNumber = By.xpath("//*[@id=\"Address_PhoneNumber\"]");
	By saveBtn = By.xpath("/html/body/div[6]/div[3]/div/div[2]/form/div/div[2]/div[2]/button");
	
	
	//Code for adding address in myAccount Section
	public boolean addAddress(String firstname,String lastname,String Email,String cityname,String addressCity,String postalCode,String pNumber) {
		
		driver.findElement(addNew).click();
		wait(1000);
		driver.findElement(firstName).sendKeys(firstname);
		wait(1000);
		driver.findElement(lastName).sendKeys(lastname);
		wait(1000);
		driver.findElement(email).sendKeys(Email);
		wait(1000);
		driver.findElement(country).click();
		wait(1000);
		driver.findElement(By.xpath("//*[@id=\"Address_StateProvinceId\"]/option[2]")).click();
		driver.findElement(city).sendKeys(cityname);
		wait(1000);
		driver.findElement(address1).sendKeys(addressCity);
		wait(1000);
		driver.findElement(zipCode).sendKeys(postalCode);
		wait(1000);
		driver.findElement(phoneNumber).sendKeys(pNumber);
		wait(1000);
		driver.findElement(saveBtn).click();
		
		
		//Check Whether address is updated or  not
		boolean actResult=true; 
		try {
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bar-notification\"]/div/p")));
		}catch(TimeoutException te) {
			actResult=false;
			captureScreenshots("address update failure");
		}
		
		return actResult;
		
	}
	
}
