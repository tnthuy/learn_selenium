package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login extends Base {
	public By TXT_EMAIL=By.id("email");
	public By TXT_PASSWORD=By.xpath("//*[@id=\"passwd\"]");
	public By BTN_SIGNIN=By.xpath("//*[@id=\"SubmitLogin\"]/span");
	public By tXT_EMAILCREATE=By.id("email_create");
	public By MSG_INVALIDEMAIL=By.xpath("//*[@id=\"create_account_error\"]");
	public By BTN_CREATEACCOUNT=By.xpath("//*[@id=\"SubmitCreate\"]/span");
	


	public Login(WebDriver driver) {
		this.driver=driver;
	}

	public MyAccount login(String username, String password) {
		driver.findElement(TXT_EMAIL).sendKeys(username);
		driver.findElement(TXT_PASSWORD).sendKeys(password);
		driver.findElement(BTN_SIGNIN).click();
		return new MyAccount(driver);
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
}
