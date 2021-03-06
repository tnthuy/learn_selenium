package page;

import java.sql.Driver;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
	public By ICO_SEARCH=By.name("submit_search");
	public By ITEMPRODUCT=By.xpath("//*[@id=\"center_column\"]/div/div/div[3]/h1");
	public By MSG_INVALIDSEARCH=By.xpath("//*[@class=\"alert alert-warning\"]");
	public By BTN_ADDTOCART=By.xpath("//*[@id=\"homefeatured\"]//*[@data-id-product=\"1\"]");
	
	
	public By ADDTOCART1=By.xpath("//*[@id=\"homefeatured\"]//*[@data-id-product=\"1\"]");
	public By ADDTOCART2=By.xpath("//*[@id=\"homefeatured\"]//*[@data-id-product=\"2\"]");
	public By ADDTOCART3=By.xpath("//*[@id=\"homefeatured\"]//*[@data-id-product=\"3\"]");
	public By BTN_CONTINUESHOPPING=By.xpath("//*[@id=\"layer_cart\"]//*[@title=\"Continue shopping\"]");
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
	public void CheckSuggestSearch(String key, String option) {
		//Tim search
		WebElement search=driver.findElement(TXT_SEARCH);

		//Click to search
		search.click();

		//Enter key to search
		search.sendKeys(key);
		

		//Check the list suggestion showing
		WebElement dropElement= driver.findElement(LST_PRODUCT);
		List<WebElement> itemList=dropElement.findElements(By.tagName("li"));
		
		System.out.println("Danh sach goi y");
		for (WebElement li:itemList) {
			if (li.getText().contains(key)) {
				System.out.println(li.getText());
				System.out.println("Co chua :"+key);
			}
			else {
				System.out.println(li.getText());
				System.out.println("Goi y khong chua :"+key);
			}
			System.out.println("********");
		}

		//Select one otion
		for (WebElement li:itemList) {
			if (li.getText().contains(option)) {
				li.click();
				//Click to Search icon
				//driver.findElement(ICO_SEARCH).click();
				//System.out.println("click search");
			}
			
		}
		
		WebElement product=driver.findElement(ITEMPRODUCT);
		System.out.println("show product suitable");
		if(product.getText().contains(option)) {
			//Print the label
			System.out.println("item showing is: "+ product.getText());
		}
		

	}
<<<<<<< HEAD
=======

>>>>>>> c7acfebe999afd3fd58c6f0bce075f69ad3cb30f
	public void AddToCast() {
		//Tim search
		WebElement search=driver.findElement(TXT_SEARCH);

		//Click to search
		search.click();
	}
<<<<<<< HEAD
=======

>>>>>>> c7acfebe999afd3fd58c6f0bce075f69ad3cb30f
	public void CheckSearchInvalid(String invalidKey) {
		//Tim search
				WebElement search=driver.findElement(TXT_SEARCH);

				//Click to search
				search.click();

				//Enter key to search
				search.sendKeys(invalidKey);
				
				//Click to Search icon
				driver.findElement(ICO_SEARCH).click();
				String messInvalidSearch="No results were found for your search";
				WebElement alert=driver.findElement(MSG_INVALIDSEARCH);
				if (alert.getText().contains(messInvalidSearch)) {
					System.out.println("show dung alert: "+alert.getText());
				}
				else {
					System.out.println("Doesn't show the alert: "+alert.getText());
				}
				
	}
	
	public void BuyItems() {
<<<<<<< HEAD
		//Click to Add to cart
		driver.findElement(BTN_ADDTOCART).click();
		// to handle all new opened window
		String MainWindow=driver.getWindowHandle();
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> i1=s1.iterator();
		while (i1.hasNext())
		{
			String ChildWindow=i1.next();
			
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				//Switching to Child Window
				driver.switchTo().window(ChildWindow);
				driver.findElement(By.xpath("//*[@title=\"Continue shopping\"]")).click();
				
			}
		}
		
		
}
=======
		//tim item dau tien va click Add to cart
		WebElement addToCart1=driver.findElement(ADDTOCART1);
		addToCart1.click();
		WebElement continueShopping=driver.findElement(BTN_CONTINUESHOPPING);
		//continueShopping.click();
		System.out.println(continueShopping.getText());
		
		//tim item thu 2 va click Add to cart
		WebElement addToCart2=driver.findElement(ADDTOCART2);
		addToCart2.click();
		driver.findElement(BTN_CONTINUESHOPPING).click();
		WebElement addToCart3=driver.findElement(ADDTOCART3);
		addToCart3.click();
		
}

>>>>>>> c7acfebe999afd3fd58c6f0bce075f69ad3cb30f
}
