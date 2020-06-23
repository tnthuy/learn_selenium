package page;

import java.sql.Driver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Hompage extends Base{
	//Declare all objects on pages
	public By BTN_SIGNIN=By.linkText("Sign in");
	public By LNK_BESTSELLER =By.xpath("//*[@id=\"home-page-tabs\"]/li[2]/a");
	public By TXT_NEWSLETTER=By.xpath("//*[@id=\"newsletter-input\"]");
	public By BTN_SUBMIT_NEWSLETTER=By.name("submitNewsletter");
	public By MSG_NEWSLETTER=By.xpath("//*[@class=\"alert alert-success\"]");
	public By BTN_CONTACTUS=By.xpath("//*[@id=\"contact-link\"]");
	
	//Constructor
	public Hompage(WebDriver driver) {
		this.driver=driver;

	}
	//Action on Page
	public Login clickSignIn() {

		driver.findElement(BTN_SIGNIN).click();
		return new Login(driver);
	}
	//Enter Email and Click Submit button 
	public LoginGmail newLetter(String email) {
		driver.findElement(TXT_NEWSLETTER).sendKeys(email);
		driver.findElement(BTN_SUBMIT_NEWSLETTER).click();
		String alert=driver.findElement(MSG_NEWSLETTER).getText();
		System.out.println("show alert successfully");
		System.out.println(alert);
		String alertMess= " Newsletter : You have successfully subscribed to this newsletter.";
		if (alert.equals(String.valueOf(alertMess))) {
			System.out.println("Hien thi dung message");
			
		}
		return new LoginGmail(driver);
	}
	public ContactUs clickContactUs() {

		driver.findElement(BTN_CONTACTUS).click();
		return new ContactUs(driver);
	}
}
