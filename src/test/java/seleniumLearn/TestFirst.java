package seleniumLearn;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestFirst {
  WebDriver driver;
	@Test
  public void openSite() {
		System.setProperty("webdriver.chrome.driver", "E://Setup//chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/");
		driver.manage().window().maximize();
 }
  
  
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  
  }

  
  
  @AfterMethod
  public void afterMethod() {
	  
	  
  }

}