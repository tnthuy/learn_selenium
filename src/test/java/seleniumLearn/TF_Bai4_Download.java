package seleniumLearn;

<<<<<<< HEAD
import static org.testng.Assert.fail;

=======
>>>>>>> d4034b18229e53a62495c708946b656ec005bea0
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
<<<<<<< HEAD
import org.openqa.selenium.support.ui.WebDriverWait;
=======
import org.testng.internal.Utils;
>>>>>>> d4034b18229e53a62495c708946b656ec005bea0

public class TF_Bai4_Download {
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
	public void Bai4_TestDownload(FluentWait<WebDriver> wait) throws InterruptedException  {
		//WebDriverWait wait= new WebDriverWait(driver, 10);
		driver.get("https://www.seleniumeasy.com/test/bootstrap-download-progress-demo.html");
		System.out.println("Check download showing");
		WebElement Download=driver.findElement(By.xpath("//*[@id=\"cricle-btn\"]"));
		Download.click();
<<<<<<< HEAD
		//Utils.pause(2000);
		Helper.printCurrentTime();
		
		WebElement  percentage;
		percentage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='percenttext']")));
		System.out.println("100%");		
		/*
		 * Thread.sleep(3000); if (isElementPresent(percentage)) { String
		 * text=driver.findElement(percentage).getText(); System.out.println(text); if
		 * (text=="100") { System.out.println(text);
		 * System.out.println("download xong");
		 * 
		 * } } else { //Return fail or do something here fail
		 * ("First Name does not exist"); }
		 * 
		 * 
		 * Helper.printCurrentTime();
		 */
	}
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "E://Setup//chromedriver_win32/chromedriver.exe");
=======
		Helper.printCurrentTime();
		By percentage=By.xpath("//*[@class='percenttext']");
		String text;
		do {
			 text=driver.findElement(percentage).getText(); System.out.println(text);}
		while (text=="100");
			
		System.out.println("100%");		
		
	}
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C://Setup//chromedriver_win32/chromedriver.exe");
>>>>>>> d4034b18229e53a62495c708946b656ec005bea0
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();

	}

}
