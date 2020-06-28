package page;

import java.sql.Driver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Hompage extends Base{
	//Declare all objects on pages
	public By BTN_SIGNIN=By.linkText("Sign in");
	public By LNK_BESTSELLER =By.xpath("//*[@id=\"home-page-tabs\"]/li[2]/a");
	public By TXT_NEWSLETTER=By.xpath("//*[@id=\"newsletter-input\"]");
	public By BTN_SUBMIT_NEWSLETTER=By.name("submitNewsletter");
	public By MSG_NEWSLETTER=By.xpath("//*[@class=\"alert alert-success\"]");
	public By BTN_CONTACTUS=By.xpath("//*[@id=\"contact-link\"]");
	public By TXT_SEARCH=By.id("search_query_top");
	public By BTN_SEARCH=By.name("submit_search");
	public By LST_PRODUCT=By.xpath("//*[@class=\"ac_results\"]");
	
	//Constructor
	public Hompage(WebDriver driver) {
		this.driver=driver;

	}
	//Action on Page for SignIn button
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
	public void EnterKeyToSearch(String key) {
		WebElement search=driver.findElement(TXT_SEARCH);
		//Hiển thị chữ search trước khi enter key
		String searchTextPlaceHolder=search.getAttribute("placeholder");
		String valueText=search.getAttribute("value");
		System.out.println("Text shows before enttering key:  "+ searchTextPlaceHolder);

		System.out.println("Text show before:"+valueText);

		//Click to search
		search.click();
		//Enter key to search
		search.sendKeys(key);
		
		//driver.findElement(BTN_SEARCH).click();
		
		String searchTextAfter=search.getAttribute("placeholder");
		String valueTextAfter=search.getAttribute("value");
		System.out.println("Text tim kiem: "+ valueTextAfter);
		System.out.println("Text shows after enter key: "+ searchTextAfter);
		if (valueTextAfter.contains(searchTextPlaceHolder)) {
			System.out.println("there is Search text in the Textbox");
				
		} else
		{
			System.out.println("There is no Search text in the Textbox");
		}
		search.clear();
		System.out.println("Text show sau khi xoa key tim kiem: "+searchTextAfter);
		String valueTextAfterClear=search.getAttribute("value");
		System.out.println("Text tim kien sau khi xoa key: "+valueTextAfterClear);
	}
	public void CheckSuggestSearch(String key) {
		//Tim search
		WebElement search=driver.findElement(TXT_SEARCH);

		//Click to search
		search.click();
		
		//Enter key to search
		search.sendKeys(key);
		
		//Check the list suggestion showing
		WebElement dropElement=driver.findElement(LST_PRODUCT);
	Select dropdown=new Select(dropElement);
	
	dropdown.deselectByVisibleText(key);
	driver
	
	System.out.println(option.getOptions());
	System.out.println(option.getAllSelectedOptions());
		
		
	}
}
