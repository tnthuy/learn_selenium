package seleniumLearn;

import org.testng.annotations.Test;

import com.sun.org.apache.xml.internal.serializer.utils.Utils;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.fail;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;


public class TF_Bai2_GetNewUser {
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
	public void Bai2_testWait() throws InterruptedException  {
		//WebDriverWait wait= new WebDriverWait(driver, 10);
		driver.get("https://www.seleniumeasy.com/test/dynamic-data-loading-demo.html");
		System.out.println("Click to Get New User button");
		WebElement getNewUser=driver.findElement(By.xpath("//*[@id=\"save\"]"));
		getNewUser.click();
		//Utils.pause(2000);
		Helper.printCurrentTime();

		By  locatorFN =By.xpath("//*[@id=\"loading\"]");
		Thread.sleep(3000);
		if (isElementPresent(locatorFN)) {
			String text=driver.findElement(locatorFN).getText();
			System.out.println(text);
		} else {
			//Return fail or do something here
			fail ("First Name does not exist");
		}


		Helper.printCurrentTime();

	}

	@Test
	public void Bai3_testAlert()  {
		//WebDriverWait wait= new WebDriverWait(driver, 10);
		driver.get("https://www.seleniumeasy.com/test/bootstrap-progress-bar-dialog-demo.html");
		System.out.println("Kiem tra man hinh khong co Alert");
		By popup=By.xpath("///*[@class='btn btn-warning']");
		
		 if (isElementPresent(popup)) { 
			 System.out.println(" Popup dang show");
		  
		  
		  } else { 		 
		System.out.println("aaaa");
		WebElement btShowDialog=driver.findElement(By.xpath("//*[@class='btn btn-warning']"));
		btShowDialog.click();	
		String text=driver.findElement(popup).getText(); System.out.println(text);
		System.out.println(text);
		  }

	}
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "F://Setup//chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();

	}

}
