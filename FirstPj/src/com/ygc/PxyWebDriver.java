package com.ygc;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PxyWebDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PxyWebDriver pwd = new PxyWebDriver();
		pwd.test2();
	}
	
	@SuppressWarnings("deprecation")
	public void test() {
		String exePath = "C:\\workspace\\selenium\\FirstPj\\exe\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		
		WebDriver driver = null;
		try {
			
//			ChromeOptions chromeOptions = new ChromeOptions();
////		    chromeOptions.setBinary("/Applications/Google Chrome Canary.app/Contents/MacOS/Google Chrome Canary");
//		    chromeOptions.addArguments("headless");
//		    driver = new ChromeDriver(chromeOptions);
		    
			String host = "218.239.244.15";
			String port = "80";

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--proxy-server=\"socks5://" + host + ":" + port+"\"");
			options.addArguments("--host-resolver-rules=\"MAP * ~NOTFOUND , EXCLUDE " + host +"\"");
			driver = new ChromeDriver(options);
			
	        //Launch the Online Store Website
			driver.get("https://www.whatismyip.com/my-ip-information/");
//			driver.get("https://www.whatismyip.com/my-ip-information/");

	        
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			// Close the driver
			driver.quit();

		}
    }		

	
	public void test2() {
		String exePath = "C:\\workspace\\selenium\\FirstPj\\exe\\geckodriver-v0.23.0-win64\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", exePath);
				
		
		String host = "218.239.244.15";
		String port = "80";
		
//		host = "166.88.124.111";
//		port = "3111";
		String proxy = host;
		
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setJavascriptEnabled(true);
		FirefoxProfile profile = new FirefoxProfile();

		profile.setPreference("network.proxy.type", 1);
		profile.setPreference("network.proxy.http", proxy);
		profile.setPreference("network.proxy.http_port", port);
		profile.setPreference("network.proxy.ssl", proxy);
		profile.setPreference("network.proxy.ssl_port", port);
		profile.setPreference("dom.ipc.plugins.enabled.libflashplayer.so", false);

		capability.setCapability("firefox_profile", profile);
		WebDriver driver = new FirefoxDriver(capability);		

		driver.get("https://www.iplocation.net/find-ip-address");
		
		
	}
}
