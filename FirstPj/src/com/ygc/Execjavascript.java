package com.ygc;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Execjavascript {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {
			String exePath = "C:\\workspace\\selenium\\FirstPj\\exe\\chromedriver_win32\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);
			
			ChromeOptions chromeOptions = new ChromeOptions();
//		    chromeOptions.setBinary("/Applications/Google Chrome Canary.app/Contents/MacOS/Google Chrome Canary");
		    chromeOptions.addArguments("headless");

		    driver = new ChromeDriver(chromeOptions);
		      
	        //Launch the Online Store Website
			driver.get("http://www.gimpo.go.kr/mayor/main.do");
			WebElement facecon = driver.findElement(By.className("face-con"));
//			System.out.println(facecon.getText());
			
			JavascriptExecutor js; 
			if (driver instanceof JavascriptExecutor) { 
			    js = (JavascriptExecutor)driver; 
			    js.executeScript(
			    	     "var inputs = document.getElementsByClassName('face-con')[0].toString();" + 
			    	     "alert(inputs);");
			}
			
			
			// Print a Log In message to the screen
	        System.out.println("Successfully opened the website www.Store.Demoqa.com");

			//Wait for 5 Sec
			Thread.sleep(5000);
			
	        
	        
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			// Close the driver
			driver.quit();

		}
    }
}
