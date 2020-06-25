package page;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ContactUs extends Base{
	public By BTN_CONTACTUS=By.xpath("//*[@id=\"contact-link\"]");
	public By DRL_SUBJECT=By.xpath("//*[@id=\"id_contact\"]");
	public By TXT_EMAIL=By.xpath("//*[@id=\"email\"]");
	public By TXT_ORDER=By.xpath("//*[@id=\"id_order\"]");
	//public By ATTACHFILE=By.xpath("//*[@class=\"filename\"]");
	public By ATTACHFILE=By.xpath("//*[@id=\"fileUpload\"]");
	public By TXT_MESSAGE=By.xpath("//*[@id=\"message\"]");
	public By BTN_SEND=By.xpath("//*[@id=\"submitMessage\"]");
	public By MESSAGE=By.xpath("//*[@class=\"alert alert-success\"]");


	public ContactUs(WebDriver driver) {
		this.driver=driver;
	}
	public LoginGmail contactUs() throws InterruptedException {
		driver.findElement(BTN_CONTACTUS).click();
		Select dropdown= new Select(driver.findElement(DRL_SUBJECT));
		dropdown.selectByIndex(1);
		driver.findElement(TXT_EMAIL).sendKeys("tnthuy140582@gmail.com");
		driver.findElement(TXT_ORDER).sendKeys("Thuy Test");
		
		//To get current working directory: 
		Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
		System.out.println(path);

		
		//Locating the Test data excel file
		String filePath =path.toString()+"\\B52F099B-9219-4ED8-870C-808733FC5714.jpg";
		System.out.println(filePath);

		driver.findElement(ATTACHFILE).sendKeys(filePath);
		
		driver.findElement(TXT_MESSAGE).sendKeys(" Test add Contact Us for AutomationPractice");
		driver.findElement(BTN_SEND).click();
		String mess=driver.findElement(MESSAGE).getText();
		System.out.println(mess);
		String message="Your message has been successfully sent to our team";
		if (mess.equalsIgnoreCase(message)){
			System.out.println("Show chua dung message: "+mess);
		}
		else {
			System.out.println(" Show dung message: "+ mess);
		}
		return new LoginGmail(driver);

	}


}
