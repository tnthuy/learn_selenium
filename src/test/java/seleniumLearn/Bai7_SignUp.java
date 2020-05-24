package seleniumLearn;

import org.testng.annotations.Test;

import page.CreateAccount;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Bai7_SignUp {
	WebDriver driver;

	public By BTN_CREATE_ACCOUNT=By.xpath("//*[@id=\"SubmitCreate\"]/span");
	public By BTN_SIGNIN=By.linkText("Sign in");
	public By tXT_EMAIL_CREATE=By.id("email_create");
	public By MSG_INVALIDEMAIL=By.xpath("//*[@id=\"create_account_error\"]");
	public String emailInValid="abc123";
	public String emailvalid="abc12365@gmail.com";

	@Test
	public void SignUp() throws Exception {
		//Mo trang
		driver.get("http://automationpractice.com/index.php");
		//tim Sign in
		driver.findElement(BTN_SIGNIN).click();
		
		Thread.sleep(5000);
		//tim va click tao account
		driver.findElement(tXT_EMAIL_CREATE).sendKeys(emailInValid);
		
		driver.findElement(BTN_CREATE_ACCOUNT).click();
		
		Thread.sleep(5000);
		String invalidMsg=driver.findElement(MSG_INVALIDEMAIL).getText();
		
		if (driver.findElement(MSG_INVALIDEMAIL).isDisplayed())
		{
			Assert.assertEquals(invalidMsg, "Invalid email address.");
			
			
		};
		

		//Nhap lai dung email	
		driver.findElement(tXT_EMAIL_CREATE).clear();
		driver.findElement(tXT_EMAIL_CREATE).sendKeys(emailvalid);
		driver.findElement(BTN_CREATE_ACCOUNT).click();
		System.out.println("nhap dung email ");
		Thread.sleep(5000);
		SignUpEmail();

	}
	public void SignUpEmail() throws Exception {
		driver.findElement(By.id("id_gender1")).click();
		driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]")).sendKeys("Ngoc Thuy");
		driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]")).sendKeys("Tran");
		driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("Thuyvy12");
		driver.findElement(By.xpath("//*[@id=\"days\"]")).sendKeys("3");
		driver.findElement(By.xpath("//*[@id=\"months\"]")).sendKeys("January");
		driver.findElement(By.xpath("//*[@id=\"years\"]")).sendKeys("1992");
		driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[7]/label")).click();
		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys("Test1");
		driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys("Thuy Tran");
		driver.findElement(By.xpath("//*[@id=\"company\"]")).sendKeys("LQA");
		driver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys("68 Nguyen Co Thach");
		driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Ha Noi");
		Select dropdown= new Select(driver.findElement(By.xpath("//*[@id=\"id_state\"]")));
		dropdown.selectByIndex(3);
		driver.findElement(By.className("required postcode form-group")).sendKeys("084");
		System.out.println("kkkk");
		Select dropdownCountry=new Select(driver.findElement(By.xpath("//*[@id=\"id_country\"]")));
		dropdownCountry.selectByValue("United States");
		driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"alias\"]")).sendKeys("Nguyen Co Thach");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"submitAccount\"]")).click();
		
		
		
			
	
	}
	

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "E://Setup/chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		//driver.close();

	}

}
