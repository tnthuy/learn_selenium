package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
<<<<<<< HEAD
import org.testng.Assert;
=======
import org.openqa.selenium.WebElement;
>>>>>>> 073385d978e37e17b5b6f1e1e2ab69131122a1a3

public class Login extends Base {
	public By TXT_EMAIL=By.id("email");
	public By TXT_EMAIL_CREATE=By.id("email_create");
	public By TXT_PASSWORD=By.xpath("//*[@id=\"passwd\"]");
	public By BTN_SIGNIN=By.xpath("//*[@id=\"SubmitLogin\"]/span");
<<<<<<< HEAD
	public By BTN_CREATE_ACCOUNT=By.xpath("//*[@id=\"SubmitCreate\"]/span");
	public By MS_INVALID_EMAIL=By.xpath("//*[@id=\"create_account_error\"]/ol/li");
=======
	public By tXT_EMAILCREATE=By.id("email_create");
	public By MSG_INVALIDEMAIL=By.xpath("//*[@id=\"create_account_error\"]");
	public By BTN_CREATEACCOUNT=By.xpath("//*[@id=\"SubmitCreate\"]/span");
	

>>>>>>> 073385d978e37e17b5b6f1e1e2ab69131122a1a3

	public Login(WebDriver driver) {
		this.driver=driver;
	}

	public MyAccount login(String username, String password) {
		driver.findElement(TXT_EMAIL).sendKeys(username);
		driver.findElement(TXT_PASSWORD).sendKeys(password);
		driver.findElement(BTN_SIGNIN).click();
		return new MyAccount(driver);
<<<<<<< HEAD
	}
	public CreateAccount login(String email) {
		driver.findElement(TXT_EMAIL_CREATE).sendKeys(email);
		driver.findElement(BTN_CREATE_ACCOUNT).click();
		String invalidMsg=driver.findElement(MS_INVALID_EMAIL).getText();
		if (driver.findElement(MS_INVALID_EMAIL).isDisplayed())
		{
			Assert.assertEquals(invalidMsg, "Invalid email address.");
			return null;
		}
		else {
			return new CreateAccount(driver);

		}
		
	}


=======
	}
	public CreateAccount login(String email) {
		driver.findElement(tXT_EMAILCREATE).sendKeys(email);
		driver.findElement(BTN_CREATEACCOUNT).click();
		WebElement messageError=driver.findElement(MSG_INVALIDEMAIL);
		if (messageError.isDisplayed()) {
			System.out.println("Email fail");
			return null;
		}
		else {
			return new CreateAccount(driver);
		}
		}
>>>>>>> 073385d978e37e17b5b6f1e1e2ab69131122a1a3
}
