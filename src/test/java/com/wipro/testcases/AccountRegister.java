package com.wipro.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wipro.base.TestBase;

import com.wipro.pages.RegistrationPage;

import com.wipro.utilities.ReadFromExcelRegistration;

public class AccountRegister extends TestBase {
	@BeforeClass
	public void beforeClass() {
		launchBrowser();
		navigateToURL();
	}

	@Test(dataProvider = "dp")
	public void createAccount(String fname, String lname, String emailid, String passwd, String cnfpass) {
		RegistrationPage registerPage = new RegistrationPage();
		boolean actResult = registerPage.createAccount(fname, lname, emailid, passwd, cnfpass);
		Assert.assertTrue(actResult);
	}

	@DataProvider
	public Object[][] dp() {

		String[][] data = new String[1][5];
		data = ReadFromExcelRegistration.getData();

		return data;
	}

	@AfterClass
	public void afterClass() {
		wait(1000);
		driver.close();
	}

}
