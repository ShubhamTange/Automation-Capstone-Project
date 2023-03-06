package com.wipro.testcases;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src\\main\\resources\\features\\address.feature",
		glue="com.wipro.stepdefinations",
		monochrome= true)
public class AddAddress extends AbstractTestNGCucumberTests{

}
