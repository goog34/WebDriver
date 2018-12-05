package com.ygc;

import java.io.File;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PxyWebDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PxyWebDriver pwd = new PxyWebDriver();
		String host = "177.104.123.218";
		String port = "8181";
		
//		pwd.YChrome(host,port);
		
//		pwd.YGecko(host,port);
//		pwd.YGecko2(host,port);
		
//		pwd.YOpera(host,port);
		
		pwd.YTor();
	}
	
	public void YTor(){
		WebDriver driver = null;
		try {
			String torPath = "C:\\Users\\GCYang\\Desktop\\Tor Browser\\Browser\\firefox.exe";
	        String profilePath = "C:\\Users\\GCYang\\Desktop\\Tor Browser\\Browser\\TorBrowser\\Data\\Browser\\profile.default\\";
	        FirefoxProfile profile = new FirefoxProfile(new File(profilePath));
	        FirefoxBinary binary = new FirefoxBinary(new File(torPath));
	        profile.setPreference("webdriver.load.strategy", "unstable");

//	        binary.startProfile(profile, profilePath, "");

	        
//	        driver = new FirefoxDriver(binary, profile); 
	        
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@SuppressWarnings("deprecation")
	public void YChrome(String host, String port) {
		String exePath = "C:\\workspace\\selenium\\FirstPj\\exe\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		
		WebDriver driver = null;
		try {
			
//			ChromeOptions chromeOptions = new ChromeOptions();
////		    chromeOptions.setBinary("/Applications/Google Chrome Canary.app/Contents/MacOS/Google Chrome Canary");
//		    chromeOptions.addArguments("headless");
//		    driver = new ChromeDriver(chromeOptions);

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

	public void YGecko(String host, String port) {
		String exePath = "C:\\workspace\\selenium\\FirstPj\\exe\\geckodriver-v0.23.0-win64\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", exePath);

		String proxy = host;
		WebDriver driver = null;
		
		try {
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
			driver = new FirefoxDriver(capability);		

			driver.get("https://www.iplocation.net/find-ip-address");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			// Close the driver
			driver.quit();

		}
		
		
	}

	public void YGecko2(String host, String port){
		String exePath = "C:\\workspace\\selenium\\FirstPj\\exe\\geckodriver-v0.23.0-win64\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver",exePath);

//		String winOsPath = System.getenv("PATH");
//		winOsPath = winOsPath + ";C:\\workspace\\selenium\\FirstPj\\exe\\geckodriver-v0.23.0-win64\\";
//    	System.setProperty("PATH",winOsPath);
//    	winOsPath = System.getenv("PATH");
    	
		String proxy = host;
		WebDriver driver = null;
		
		try {
			FirefoxOptions fo = new FirefoxOptions();

			// Create object Proxy class
			Proxy prox = new Proxy();
//			prox.setProxyType(ProxyType.AUTODETECT);
			prox.setProxyType(ProxyType.SYSTEM);
			// register the proxy with options class
			fo.setProxy(prox);
			
			driver = new FirefoxDriver(fo);

			driver.get("https://www.iplocation.net/find-ip-address");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			// Close the driver
			driver.quit();

		}
		
	}
	
	public void YOpera(String host, String port) {
		String exePath = "C:\\workspace\\selenium\\FirstPj\\exe\\operadriver_win64\\operadriver.exe";
		System.setProperty("webdriver.opera.driver", exePath);
		
		try {
			String proxy = host+":"+port;
			
			WebDriver driver = this.getOperaConfigurado(proxy);
			
			driver.get("https://www.iplocation.net/find-ip-address");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}	
	
	@SuppressWarnings("deprecation")
	private WebDriver getOperaConfigurado(String proxy) {
		DesiredCapabilities capabilities = DesiredCapabilities.opera();

		ArrayList<String> switches = new ArrayList<String>();

		if (!(proxy.equals(""))) {
			switches.add("--proxy-server=" + "http://" + proxy);
		} else {
			System.out.println("usando proxy!");
		}

		switches.add("--start-maximized");
		capabilities.setCapability("opera.switches", switches);
		capabilities.setBrowserName("opera");
		capabilities.setJavascriptEnabled(true);

		return new OperaDriver(capabilities);
	}	


}
