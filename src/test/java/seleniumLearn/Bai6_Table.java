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
	WebElement col=driver.findElement(By.xpath("//*[@id=\"example\"]/thead/tr/th[1]"));
	@Test
	public void testFindLondon() {

		//Mo trang guruDemo
		driver.get("https://www.seleniumeasy.com/test/table-sort-search-demo.html");
		System.out.println(col.getSize());
		


	}
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C://Setup/chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();

	}

}