package com.wipro.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestBase {
	public static WebDriver driver;
	FileInputStream fis;
	Properties prop;

	//path for configuration file
	String fileName = "src\\main\\resources\\config\\config.properties";
	
	//code for Launch Browser
	public void launchBrowser() {
		try {
			fis = new FileInputStream(fileName);
		} catch (FileNotFoundException fnf) {
			System.out.println("File path or name is not correct");
		}

		prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (prop.getProperty("Browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driverfiles\\chromedriver.exe");

			driver = new ChromeDriver();
		} else if (prop.getProperty("Browser").equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "src\\main\\resources\\driverfiles\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
	}

	//Code for navigate to URL 
	public void navigateToURL() {
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
	}

	
	// Code for giving wait
	public void wait(int msec) {
		try {
			Thread.sleep(msec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String captureScreenshots(String scrName) {

		System.out.println("Screenshot for " + scrName);

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH_mm_ss");
		String timeStamp = sdf.format(date);

		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String scnShotFileName = "src\\test\\resources\\screenshots\\screenshot_" + timeStamp + ".png";
		File DestFile = new File(scnShotFileName);
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return scnShotFileName;

	}
}
