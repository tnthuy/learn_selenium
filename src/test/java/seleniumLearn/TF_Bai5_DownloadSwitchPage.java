package seleniumLearn;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.Utils;

public class TF_Bai5_DownloadSwitchPage {
	WebDriver driver;
	public boolean isElementPresent (By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	@Test
	public void Bai5_TestDownload() {
		//WebDriverWait wait= new WebDriverWait(driver, 10);
		driver.get("https://www.seleniumeasy.com/test/");
		Select Alert=new Select(driver.findElement(By.xpath("//*[contains(text(),'Alerts & Modals')]")));
		Alert.selectByValue("File Download");
		
	}
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C://Setup//chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		//driver.close();

	}

}
