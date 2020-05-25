@@ -0,0 +1,59 @@
package seleniumLearn;

import org.testng.annotations.Test;

import page.CreateAccount;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Bai7_SignUp {
	WebDriver driver;

	public By BTN_CREATE_ACCOUNT=By.xpath("//*[@id=\"SubmitCreate\"]/span");
	public By BTN_SIGNIN=By.linkText("Sign in");
	public By tXT_EMAILCREATE=By.id("email_create");
	public By MSG_INVALIDEMAIL=By.xpath("//*[@id=\"create_account_error\"]");
	public String emailInValid="abc123";
	public String emailvalid="abc123@gmail.com";
	
	@Test
	public void SignUp() {
		//Mo trang
		driver.get("http://automationpractice.com/index.php");
		//tim Sign in
		driver.findElement(BTN_SIGNIN).click();
		//tim va click tao account
		driver.findElement(tXT_EMAILCREATE).sendKeys(emailInValid);
		driver.findElement(BTN_CREATE_ACCOUNT).click();
		String invalidMsg=driver.findElement(MSG_INVALIDEMAIL).getText();
		if (driver.findElement(MSG_INVALIDEMAIL).isDisplayed())
		{
			Assert.assertEquals(invalidMsg, "Invalid email address.");
			}
		else {
			driver.findElement(tXT_EMAILCREATE).sendKeys(emailvalid);
			driver.findElement(BTN_CREATE_ACCOUNT).click();
			System.out.println("nhap dung email ");

		}
			
	}
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C://Setup/chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();

	}

}