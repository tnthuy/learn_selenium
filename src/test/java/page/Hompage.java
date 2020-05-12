package page;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Hompage extends Base{
//Declare all objects on pages
	public By BTN_SIGNIN=By.linkText("Sign in");
	public By LNK_BESTSELLER =By.xpath("//*[@id=\"home-page-tabs\"]/li[2]/a");
	
	//Constructor
	public Hompage(WebDriver driver) {
		this.driver=driver;
		
	}
		//Action on Page
	public Login clickSignIn() {
		
	driver.findElement(BTN_SIGNIN).click();
	return new Login(driver);
	}
}
