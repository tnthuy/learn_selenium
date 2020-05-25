package seleniumLearn;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class Bai9_Date {
  WebDriver driver;
  @Test
  public void datePicker() throws InterruptedException {
	  driver.get("https://www.seleniumeasy.com/test/jquery-date-picker-demo.html");
	  driver.findElement(By.xpath("//*[@id=\"from\"]")).click();
	  Select monthFrom = new Select(driver.findElement(By.xpath("//*[@data-handler=\"selectMonth\"]")));
	  monthFrom.selectByValue("2");
	  driver.findElement(By.xpath("//*[@data-handler=\"selectDay\"] /a[text()=\"1\"]")).click();
	  
	  driver.findElement(By.xpath("//*[@id=\"to\"]")).click();
	  Select monthTo = new Select(driver.findElement(By.xpath("//*[@data-handler=\"selectMonth\"]")));
	  monthTo.selectByValue("4");
	  driver.findElement(By.xpath("//*[@data-handler=\"selectDay\"] /a[text()=\"5\"]")).click();
	  
	  Thread.sleep(9000);
	  

	 
  }
  @BeforeMethod
  public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "E://Setup/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	
  }

  @AfterMethod
  public void afterMethod() {
  }

}
