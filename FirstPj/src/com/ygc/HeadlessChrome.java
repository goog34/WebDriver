package com.ygc;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HeadlessChrome {

	public static void main(String[] args) {
		HeadlessChrome hc = new HeadlessChrome();
		try {
			hc.createChromeDriverHeadless();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	  public void createChromeDriverHeadless() throws IOException
	  {
		  WebDriver driver = null;
		  String exePath = "C:\\workspace\\selenium\\FirstPj\\exe\\chromedriver_win32\\chromedriver.exe";
		  System.setProperty("webdriver.chrome.driver", exePath);
			
		  ChromeOptions chromeOptions = new ChromeOptions();
//	      chromeOptions.setBinary("/Applications/Google Chrome Canary.app/Contents/MacOS/Google Chrome Canary");
	      chromeOptions.addArguments("headless");

	      driver = new ChromeDriver(chromeOptions);
	      driver.get("http:\\www.facebook.com");


			WebElement element1 = driver.findElement(By.id("email"));
			element1.sendKeys("chc0720@gmail.com");
			
			WebElement element2 = driver.findElement(By.id("pass"));
			element2.sendKeys("01111@@@");
			
			WebElement element3 = driver.findElement(By.id("loginbutton"));
			element3.click();
			
			System.out.println("Login");
			


//	      Assert.assertTrue(Driver.findElement(By.id("flash")).getText().contains("Your password is invalid!"));
	      driver.quit();
	  }
	}
