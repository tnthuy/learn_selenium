package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccount extends Base {
	public By LNL_HOME=By.xpath("//*[@title=\"Home\"]");

	public MyAccount(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public Hompage back2Homepage() {
		driver.findElement(LNL_HOME).click();
		return new Hompage(driver);
	}

}
