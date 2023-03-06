package com.wipro.stepdefinations;

import org.testng.Assert;

import com.wipro.base.TestBase;
import com.wipro.pages.AddressPage;
import com.wipro.pages.HomePage;
import com.wipro.pages.LoginPage;
import com.wipro.pages.PlaceOrderPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddAddress extends TestBase{
	
	@Before
	public void setup() {
		
	}
	@Given("user is on login page")
	public void user_is_on_login_page() {
	   launchBrowser();
	   navigateToURL();
	}
	
	@When("user enters {string} and {string} and click login button")
	public void user_enters_and_and_click_login(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		LoginPage loginPage = new LoginPage();
		boolean actResult = loginPage.validateLogin(string,string2);
		Assert.assertTrue(actResult);
	}
	

	@Then("user clicks on My Account then Address")
	public void user_clicks_on_my_account() {
		HomePage hp = new HomePage();
		boolean actResult = hp.myAccountClick();
		Assert.assertTrue(actResult);
		
		boolean actResult1 = hp.clickAddress();
		Assert.assertTrue(actResult1);
	}

	@Then("user enters {string} , {string} , {string}  , {string} , {string} , {string} and {string} and click save button")
	public void user_enter_and_and_click_save_button(String string, String string2, String string3, String string4, String string5, String string6, String string7) {
	   AddressPage ap = new AddressPage();
	   boolean actResult = ap.addAddress(string, string2, string3, string4, string5, string6, string7);
	   Assert.assertTrue(actResult);
	}
	
	@After
	public void tearDown() {
		wait(1000);
		driver.close();
	}

}
