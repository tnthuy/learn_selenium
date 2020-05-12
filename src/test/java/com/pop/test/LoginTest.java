package com.pop.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pop.page.Hompage;
import com.pop.page.Login;
import com.pop.page.MyAccount;

public class LoginTest {
	WebDriver driver;
  @Test
  public void testLogin() {
	  
	  Hompage home=new Hompage(driver);
	  Login login= home.clickSignIn();
	  MyAccount myAcc=login.login();
	  home=myAcc.back2Homepage();
	  assert (home.isElementPresent(home.LNK_BESTSELLER));
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "E://Setup/chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
