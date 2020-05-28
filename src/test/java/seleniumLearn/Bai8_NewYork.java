package seleniumLearn;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Bai8_NewYork {
	WebDriver driver;
	
	@Test
	public void testFindNewYork() throws Exception {

		driver.get("https://www.seleniumeasy.com/test/table-data-download-demo.html");
		List<WebElement> strName1 = driver.findElements(By.xpath("//tbody/tr/td[text()=\"New York\"]/../td[1]"));
		List<WebElement> strName2 = driver.findElements(By.xpath("//tbody/tr/td[text()=\"Tokyo\"]/../td[text()=\"Accountant\"]/../td[1]"));
		System.out.println("Nhung nguoi o New York la: ");
		for (int i = 0; i < strName1.size(); i++) {
			System.out.println(strName1.get(i).getText());
		}
		System.out.println("Nhung nguoi o Tokyo ma lam Accountant:");
		for (int i = 0; i < strName2.size(); i++) {
			System.out.println(strName2.get(i).getText());
		}

		Thread.sleep(5000);

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