package com.wipro.testcases;

import org.testng.annotations.Test;

import com.wipro.base.TestBase;
import com.wipro.pages.LogOut;
import com.wipro.pages.LoginPage;
import com.wipro.pages.ValidateMenuPage;
import com.wipro.utilities.ReadFromExcel;
import com.wipro.utilities.ReadFromExcel;


import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class ValidateMenu extends TestBase{
	
	@BeforeClass
	  public void beforeClass() {
		 launchBrowser();
		 navigateToURL();
	  }
	
  @Test(dataProvider = "dp",priority=0)
  public void loginTest(String userName,String passWord) {
	  LoginPage lp = new LoginPage();
	  boolean actResult = lp.validateLogin(userName, passWord);
	  Assert.assertTrue(actResult);
  }
  
  @Test(priority=1)
  public void validateMenuTest() {
	  ValidateMenuPage vmp = new ValidateMenuPage();
	  boolean actResult = vmp.validateMenuList();
	  Assert.assertTrue(actResult);
  }

  @DataProvider
  public Object[][] dp() {
	  String[][] data = new String[1][2];
	  data = ReadFromExcel.getData();
	  return data;
  }
  
  @Test(priority=1)
  public void valiadteLogout() {
	  LogOut lo = new LogOut();
	  boolean actResult = lo.logOut();
	  Assert.assertTrue(actResult);
  }

  @AfterClass
  public void afterClass() {
	  wait(1000);
	  driver.close();
  }

}