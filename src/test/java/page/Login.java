package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Base {
	public By TXT_EMAIL=By.id("email");
	public By TXT_PASSWORD=By.xpath("//*[@id=\"passwd\"]");
	public By BTN_SIGNIN=By.xpath("//*[@id=\"SubmitLogin\"]/span");

	public Login(WebDriver driver) {
		this.driver=driver;
	}
	
	public MyAccount login(String username, String password) {
		driver.findElement(TXT_EMAIL).sendKeys(username);
				driver.findElement(TXT_PASSWORD).sendKeys(password);
				driver.findElement(BTN_SIGNIN).click();
				return new MyAccount(driver);
	}
}
