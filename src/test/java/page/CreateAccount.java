

package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateAccount extends Base {
	WebDriver driver;
	public By BTN_CREATE_ACCOUNT=By.xpath("//*[@id=\"SubmitCreate\"]/span");
	public By BTN_SIGNIN=By.linkText("Sign in");
	public By tXT_EMAIL_CREATE=By.id("email_create");
	public By MSG_INVALIDEMAIL=By.xpath("//*[@id=\"create_account_error\"]");
	public String emailInValid="abc123";
	public String emailvalid="abc12365@gmail.com";

	public CreateAccount(WebDriver driver) {
		this.driver=driver;
	}
	public MyAccount SignUpEmail() throws Exception {
		driver.findElement(By.id("id_gender1")).click();
		driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]")).sendKeys("Ngotrreewew");
		driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]")).sendKeys("Tran");
		driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("Thuyvy12");
		driver.findElement(By.xpath("//*[@id=\"days\"]")).sendKeys("3");
		driver.findElement(By.xpath("//*[@id=\"months\"]")).sendKeys("January");
		driver.findElement(By.xpath("//*[@id=\"years\"]")).sendKeys("1992");
		driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[7]/label")).click();
		//driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys("Test1");
		//driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys("Thuy Tran");
		driver.findElement(By.xpath("//*[@id=\"company\"]")).sendKeys("LQA");
		driver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys("68 Nguyen Co Thach");
		driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Ha Noi");
		Select dropdown= new Select(driver.findElement(By.xpath("//*[@id=\"id_state\"]")));
		dropdown.selectByIndex(3);
		driver.findElement(By.id("postcode")).sendKeys("00000");
		Select dropdownCountry=new Select(driver.findElement(By.xpath("//*[@id=\"id_country\"]")));
		//dropdownCountry.selectByValue("United States");
		dropdown.selectByIndex(21);
		driver.findElement(By.id("authentication")).sendKeys("1234");
		driver.findElement(By.id("phone_mobile")).sendKeys("123456");
		driver.findElement(By.id("alias")).sendKeys("Nguyen Co Thach");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"submitAccount\"]")).click();
		System.out.println("Click Sign In");
		return new MyAccount(driver);
	}

}

