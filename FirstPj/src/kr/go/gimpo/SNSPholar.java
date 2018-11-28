package kr.go.gimpo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SNSPholar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SNSPholar sp = new SNSPholar();
		sp.dataSNSPholar();
	}

	public void dataSNSPholar() {
		try {
			// 크롬 드라이브 설정
			WebDriver driver = null;
			String exePath = "C:\\workspace\\selenium\\FirstPj\\exe\\chromedriver_win32\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);

			// 헤드레스(창 없는) 크롬 설정 
			ChromeOptions chromeOptions = new ChromeOptions();
//		    chromeOptions.setBinary("/Applications/Google Chrome Canary.app/Contents/MacOS/Google Chrome Canary");
			chromeOptions.addArguments("headless");
			driver = new ChromeDriver(chromeOptions);

			// 첫번째 집속 
			driver.get("https://www.pholar.co/my/913211/profile");

			// 목록 링크 정보 추출
			List<WebElement> myElements = driver.findElements(By.className("list_wrap"));
			for (WebElement e : myElements) {
				// 추출된 링크를 이용하여 
				// 다시 접속
				driver.get(e.getAttribute("href"));

				// 목록에서 정보 추출
				List<WebElement> mymElements = driver.findElements(By.className("item_info_wrap"));
				for (WebElement ee : mymElements) {
					List<WebElement> mymElements2 = ee.findElements(By.className("item_data"));
					for (WebElement eee : mymElements2) {
						// 해당 텍스트 추출
						System.out.println(eee.getText());
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
