package seleniumLearn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Bai6_Table {
	WebDriver driver;
	WebElement bankDrag;
	WebElement salesDrag;
	@Test
	public void testKeyboard() throws InterruptedException {

		//Mo trang guruDemo
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		//Drag and drop bank
		bankDrag= driver.findElement(By.xpath("//*[@id=\"credit2\"]"));
		salesDrag=driver.findElement(By.xpath("//*[@id=\"credit1\"]"));
		


	}
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "E://Setup/chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();

	}

}