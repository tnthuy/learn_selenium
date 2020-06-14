package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import org.openqa.selenium.WebElement;


public class Login extends Base {
	public By TXT_EMAIL=By.id("email");
	public By TXT_EMAIL_CREATE=By.id("email_create");
	public By TXT_PASSWORD=By.xpath("//*[@id=\"passwd\"]");
	public By BTN_SIGNIN=By.xpath("//*[@id=\"SubmitLogin\"]/span");
	public By BTN_CREATE_ACCOUNT=By.xpath("//*[@id=\"SubmitCreate\"]/span");
	public By MS_INVALID_EMAIL=By.xpath("//*[@id=\"create_account_error\"]/ol/li");
	public By tXT_EMAILCREATE=By.id("email_create");
	public By MSG_INVALIDEMAIL=By.xpath("//*[@id=\"create_account_error\"]");

	public Login(WebDriver driver) {
		this.driver=driver;
	}

	public MyAccount login(String username, String password) {
		driver.findElement(TXT_EMAIL).sendKeys(username);
		driver.findElement(TXT_PASSWORD).sendKeys(password);
		driver.findElement(BTN_SIGNIN).click();
		return new MyAccount(driver);

	}
	
	public String signUpWithWrongEmail(String email) {
		driver.findElement(tXT_EMAILCREATE).sendKeys(email);
		driver.findElement(BTN_CREATE_ACCOUNT).click();
		if (isElementPresent(MSG_INVALIDEMAIL) ){
			System.out.println("tim thay message");
		};
		WebElement alert= driver.findElement(MSG_INVALIDEMAIL);
		String error=alert.getText();
		System.out.println(error);
		System.out.println("Email fail");
		return error;
	}
	public CreateAccount signUpWithValidEmail(String email) {
		driver.findElement(TXT_EMAIL_CREATE).sendKeys(email);
		driver.findElement(BTN_CREATE_ACCOUNT).click();
		return new CreateAccount(driver);
	}

}
