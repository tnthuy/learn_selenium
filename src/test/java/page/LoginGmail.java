package page;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginGmail extends Base {
	public By BTN_DANGNHAP=By.xpath("//*[@id=\"gb_70\"]");
	public By TXT_EMAIL=By.xpath("//*[@id=\"identifierId\"]");
	public By BTN_NEXTEMAIL=By.xpath("//*[@id=\"identifierNext\"]");
	public By TXT_PASSWORD=By.name("password");
	public By BTN_NEXT=By.xpath("//*[@id=\"passwordNext\"]");
	public By BTN_INBOX=By.xpath("//*[@id=\":3a\"]");
	
	public LoginGmail(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public void LoginGmail() throws Exception {
		//Mo Gmail
		System.setProperty("webdriver.chrome.driver", "C://Setup/chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/intl/vi/gmail/about/#");
		//Dang nhap
		WebElement DangNhap=driver.findElement(BTN_DANGNHAP);
		DangNhap.click();
		driver.findElement(TXT_EMAIL).sendKeys("tnthuy140583@gmail.com");
		driver.findElement(BTN_NEXTEMAIL).click();
		driver.findElement(TXT_PASSWORD).sendKeys("Thuyvy12");
		driver.findElement(BTN_NEXT).click();
		//driver.findElement(By.xpath("//*[contains(text(), 'Gmail')]")).click();
		
		
		//Kiem tra email
		driver.findElement(BTN_INBOX).click();
		List<WebElement> unreadmail=(List<WebElement>) driver.findElement(By.className("zE"));
		System.out.println("Total No. of unread mail"+unreadmail.size());
		//real logic start here
		for (int i=0;i<=unreadmail.size();i++) {
			System.out.println(unreadmail.get(i).getText());
			if (unreadmail.get(i).getText()=="automationpractice") {
				System.out.println("Da gui mail");
			}
			
		}
		unreadmail.get(0).click();
		Thread.sleep(3000);
		driver.close();
	}
	
	
}
