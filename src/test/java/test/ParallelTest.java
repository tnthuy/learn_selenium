package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.Hompage;
import page.Login;
import page.MyAccount;

public class ParallelTest {
	WebDriver driver;
	String baseUrl="http://automationpractice.com/";
	@DataProvider
	public Object[][] dataSet(){
		return new Object[][] {
			//{"pop2020@test.com", "123456"},
			//{"thuy140583@gmail.com", "Thuyvy12"},
			{"datadriven@test.com", "123456"}
		};
		
	}
	@Test(dataProvider = "dataSet")
	public void testLogin(String username, String password) {

		Hompage home=new Hompage(driver);
		Login login= home.clickSignIn();
		MyAccount myAcc=login.login(username, password);
		home=myAcc.back2Homepage();
		assert (home.isElementPresent(home.LNK_BESTSELLER));


	}
	@BeforeMethod
	@Parameters({"browser", "baseUrl"})
	public void beforeMethod(String browser, String url) {
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C://Setup/geckodriver-v0.26.0-win64/chromedriver.exe");
			driver=new ChromeDriver();
			System.out.println("++RUN Firefox");
		} else {
			System.setProperty("webdriver.chrome.driver", "C://Setup/chromedriver_win32/chromedriver.exe");
			driver=new ChromeDriver();
			System.out.println("++RUN Chrome");
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
