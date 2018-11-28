package kr.go.gimpo;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SNSFacebook {

	public static void main(String[] args) {
		SNSFacebook sfb = new SNSFacebook();
		try {
			sfb.getData();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	  public void getData() throws IOException
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

		// 사이드 메뉴 추출
		List<WebElement> myElements = driver.findElements(By.className("sideNavItem"));
		for (WebElement e : myElements) {
			String txt1 = e.getText();
//			
//			String sideUrl = txt1.substring(txt1.indexOf("href", txt1.indexOf("left_nav_item_김포시청"))+2, 0);
//			// 추출된 링크를 이용하여
//			// 다시 접속
//			driver.get(sideUrl);
//
//			// 목록에서 정보 추출
//			List<WebElement> mymElements = driver.findElements(By.id("entity_sidebar"));
//			for (WebElement ee : mymElements) {
//				List<WebElement> mymElements2 = ee.findElements(By.className("item_data"));
//				for (WebElement eee : mymElements2) {
//					// 해당 텍스트 추출
//					System.out.println(eee.getText());
//				}
//			}
		}

		driver.quit();
	  }	
	
}
