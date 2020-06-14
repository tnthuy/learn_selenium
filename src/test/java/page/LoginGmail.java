package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginGmail extends Base {
	public By LNL_HOME=By.xpath("//*[@title=\"Home\"]");
	public By MSG_ACCOUNT=By.xpath("//*[@class=\"info-account\"]");
	public LoginGmail(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public void CheckMail() {
		driver.get("https://www.google.com.vn/");
		WebElement DangNhap=driver.findElement(By.xpath("//*[@id=\"gb_70\"]"));
		DangNhap.click();
	}
	public void checkMess() {
		String mess=driver.findElement(MSG_ACCOUNT).getText();
		System.out.println("show message");
		System.out.println(mess);
	}

}
