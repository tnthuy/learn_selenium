package seleniumLearn;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Bai6_TableLondon {
	WebDriver driver;
	
  @Test
  public void TestTable() {
	//Mo trang guruDemo
			driver.get("https://www.seleniumeasy.com/test/table-sort-search-demo.html");
			// No.of Columns
			List <WebElement> col=(List<WebElement>) driver.findElement(By.xpath("//*[@id=\"example\"]/thead/tr/th[1]"));
			System.out.println("No of col "+ col.size());

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