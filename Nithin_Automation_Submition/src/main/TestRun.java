package main;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import util.DriverConnection;

public class TestRun {

	public static void main(String[] args) {
		// Getting webdriver instance from util package

		WebDriver driver = DriverConnection.getDriver();
		driver.manage().window().maximize();
		driver.get("https://www1.my.commbiz.commbank.com.au/logon/usermaintenance/login.aspx");

		clickRegisterOnlineButton(driver);
		clickFirstRegistrationPage(driver);
		clickAcknowledgeCheckbox(driver);
		mainRegistrationPage(driver);
		
		DriverConnection.closeDriver(driver);

	}

	private static void clickRegisterOnlineButton(WebDriver driver) {
		List<WebElement> anchors = driver.findElements(By.tagName("a"));
		Iterator<WebElement> i = anchors.iterator();

		while (i.hasNext()) {
			WebElement anchor = i.next();
			if (anchor.getAttribute("href").contains(
					"https://www1.my.commbiz.commbank.com.au/registration/client/registration/RegSelectionDoAction.aspx")) {
				anchor.click();
				break;
				// No Link found
			}
		}
		driver.get(
				"https://www1.my.commbiz.commbank.com.au/registration/client/registration/RegSelectionDoAction.aspx");

	}

	private static void clickFirstRegistrationPage(WebDriver driver) {
		WebElement radioButton = driver.findElement(By.id("rdoExpress"));
		if (!(radioButton.isSelected())) {
			radioButton.click();
		}
		driver.findElement(By.id("btnNext")).click();

	}

	private static void clickAcknowledgeCheckbox(WebDriver driver) {
		driver.findElement(By.id("chkTerms")).click();
		driver.findElement(By.id("btnSubmit")).click();
	}

	private static void mainRegistrationPage(WebDriver driver) {
		driver.findElement(By.id("txtUserName")).sendKeys("Nithin1 Ethapay");
		driver.findElement(By.id("txtPassword")).sendKeys("Nithin1");
		driver.findElement(By.id("txtReenterPassword")).sendKeys("Nithin1");

		Select question1 = new Select(driver.findElement(By.id("ddlSecret1")));
		question1.selectByIndex(1);
		driver.findElement(By.id("txtSecret1")).sendKeys("Red");

		Select question2 = new Select(driver.findElement(By.id("ddlSecret2")));
		question2.selectByIndex(2);
		driver.findElement(By.id("txtSecret2")).sendKeys("Ethapaye");

		driver.findElement(By.id("btnSubmit")).click();

	}
}
