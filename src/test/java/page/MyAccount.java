package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccount extends Base {
	public By LNL_HOME=By.xpath("//*[@title=\"Home\"]");
	public By MSG_ACCOUNT=By.xpath("//*[@class=\"info-account\"]");
	public MyAccount(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public Hompage back2Homepage() {
		driver.findElement(LNL_HOME).click();
		return new Hompage(driver);
	}
	public void checkMess() {
		String mess=driver.findElement(MSG_ACCOUNT).getText();
		System.out.println("show message");
		System.out.println(mess);
	}

}
