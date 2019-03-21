package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverConnection {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

	public static void closeDriver(WebDriver driver) {
		driver.close();
	}

}
