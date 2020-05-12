package seleniumLearn;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class TF_Bai1_Wait {
	WebDriver driver;


	@Test
	public void testWait() throws Exception {
		WebDriverWait wait= new WebDriverWait(driver, 10);
		driver.get("https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");
		Helper.printCurrentTime();
		WebElement download=driver.findElement(By.xpath("//*[@id=\"downloadButton\"]"));
		download.click();
		WebElement element;

		element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"dialog\"]/div[1]")));
		Helper.printCurrentTime();
		Thread.sleep(2000);
	}
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "E://Setup//chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();

	}

}
