package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.Hompage;
import page.Login;
import page.MyAccount;

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
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/");
	}

	@AfterMethod
	public void afterMethod() {
		//driver.close();
	}

}
