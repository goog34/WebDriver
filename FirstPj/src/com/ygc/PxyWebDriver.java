package com.ygc;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PxyWebDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PxyWebDriver pwd = new PxyWebDriver();
		pwd.test();
	}
	
	@SuppressWarnings("deprecation")
	public void test() {
		WebDriver driver = null;
		try {
			String exePath = "C:\\workspace\\selenium\\FirstPj\\exe\\chromedriver_win32\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);
			
//			ChromeOptions chromeOptions = new ChromeOptions();
////		    chromeOptions.setBinary("/Applications/Google Chrome Canary.app/Contents/MacOS/Google Chrome Canary");
//		    chromeOptions.addArguments("headless");
//		    driver = new ChromeDriver(chromeOptions);
		      

			String PROXY = "localhost:8080";
			PROXY = "88.148.92.37:8080";

			org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
			proxy.setHttpProxy(PROXY)
			     .setFtpProxy(PROXY)
			     .setSslProxy(PROXY);
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(CapabilityType.PROXY, proxy);

			driver = new ChromeDriver(cap);
			
	        //Launch the Online Store Website
			driver.get("https://whatismyipaddress.com/ip-lookup");

	        
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			// Close the driver
			driver.quit();

		}
    }		

}
