package page;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginGmail extends Base {
	public By BTN_DANGNHAP=By.linkText("Đăng nhập");
	public By TXT_EMAIL=By.xpath("//*[@id=\"identifierId\"]");
	public By BTN_NEXTEMAIL=By.xpath("//*[@id=\"identifierNext\"]");
	public By TXT_PASSWORD=By.name("password");
	public By BTN_NEXT=By.xpath("//*[@id=\"passwordNext\"]");
	public By BTN_INBOX=By.xpath("//*[@id=\":3a\"]");
	
	public LoginGmail(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public void LoginGmail(String email, String pass) throws Exception {
		//Mo Gmail
		System.setProperty("webdriver.chrome.driver", "C://Setup/chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
<<<<<<< HEAD
		driver.get("https://mail.google.com");
=======
		driver.get("https://www.google.com/intl/vi/gmail/about/#");
>>>>>>> 64ea55c154934c3fda8fb76e871e182ebd246389
		//Dang nhap
		driver.findElement(TXT_EMAIL).sendKeys(email);
		driver.findElement(BTN_NEXTEMAIL).click();
		driver.findElement(TXT_PASSWORD).sendKeys(pass);
		driver.findElement(BTN_NEXT).click();
		//driver.findElement(By.xpath("//*[contains(text(), 'Gmail')]")).click();
		
		
		//Kiem tra email
		driver.findElement(BTN_INBOX).click();
		List<WebElement> unreadmail=(List<WebElement>) driver.findElement(By.className("zF"));
		System.out.println("Total No. of unread mail"+unreadmail.size());
		
		// Mailer name for which i want to check do i have an email in my inbox 
		String MyMailer = "Wrike";
		
		//real logic start here
		for (int i=0;i<=unreadmail.size();i++) {
			System.out.println(unreadmail.get(i).getText());
			if (unreadmail.get(i).getText().equals(MyMailer)) {
				System.out.println("Da gui mail");
			}
			else {
				System.out.println("Chua thay gui mail from  "+ MyMailer);
			}
			
		}
		unreadmail.get(0).click();
		Thread.sleep(3000);
		driver.close();
	}
	
	
}
