package seleniumLearn;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Bai1_Tong2So {
	WebDriver driver;
  @Test
  public void testKeyboard() throws InterruptedException {
	  int a=5;
		int b=8;
		int kq=a+b;
		
		//Mo trinh duyet
		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
		//tim va dien gia tri a
		driver.findElement(By.xpath("//*[@id=\"sum1\"]")).sendKeys(String.valueOf(a));
		//tim va dien gia tri b
		driver.findElement(By.xpath("//*[@id=\"sum2\"]")).sendKeys(String.valueOf(b));
		//Click to tinh kq
		driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button")).click();
		//tinh va so sanh kq
		
		String ketqua= driver.findElement(By.xpath("//*[@id=\"displayvalue\"]")).getText();

		if (ketqua.equals(String.valueOf(kq))) {
			System.out.println("Summary is displayed correctly");

		}
		else {
			System.out.println("Summary is displayed incorrectly");
		}
		
	
		Thread.sleep(5000);
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C://Setup//chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
