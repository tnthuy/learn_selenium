
package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.ContactUs;
import page.CreateAccount;
import page.Hompage;
import page.Login;
import page.LoginGmail;
import page.MyAccount;

public class LoginTest {
	WebDriver driver;
	@DataProvider
	public Object[][] dataSet(){
		return new Object[][] {
			{"pop2020@test.com", "123456"},
			{"thuy140583@gmail.com", "Thuyvy12"},
			{"datadriven@test.com", "123456"}
		};
		
	}
	@Test(dataProvider = "dataSet", enabled = false)
	public void testLogin(String username, String password) {

		Hompage home=new Hompage(driver);
		Login login= home.clickSignIn();
		MyAccount myAcc=login.login(username, password);
		home=myAcc.back2Homepage();
		assert (home.isElementPresent(home.LNK_BESTSELLER));


	}
	
	@Test(enabled = false)
	public void testInValidEmail()
	{
		Hompage home=new Hompage(driver);
		Login login=home.clickSignIn();
		login.signUpWithWrongEmail("abc123");
	
	}
	@Test(enabled=false)
	public void testValidEmail() throws Exception
	{
		Hompage home=new Hompage(driver);
		Login login=home.clickSignIn();
		CreateAccount createAccount=login.signUpWithValidEmail("thuytn131112@lqa.com.vn");
		MyAccount myaccount=createAccount.SignUpEmail();
		myaccount.checkMess();	
		}
	
	@Test
	public void testNewsLetter() throws Exception
	{

		Hompage home=new Hompage(driver);
		LoginGmail loginGmail=home.newLetter("lqa-tester_1@b-eee.com");
		loginGmail.LoginGmail("lqa-tester@b-eee.com", "Thuyvy12");		
		 
	}
	//contact Us
	@Test
	public void testContactUs() throws Exception {
		Hompage home=new Hompage(driver);
		ContactUs contactUs=home.clickContactUs();
		LoginGmail loginGmail=contactUs.contactUs();
		loginGmail.LoginGmail("tnthuy140583@gmail.com", "Thuyvy12");		
		
	}
	//Enter tu khoa cho Search
	@Test
	public void testSearchEnter() {
		Hompage home=new Hompage(driver);
		home.EnterKeyToSearch("Dress");
		
	}
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C://Setup/chromedriver_win32/chromedriver.exe");
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

