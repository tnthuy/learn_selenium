package seleniumLearn;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Bai3_MaleAndGroupAge {
	WebDriver driver;
	WebElement maleRadio;
	WebElement ageGroup;
  @Test
  public void testRadioButton() throws InterruptedException {
	//Mo trinh duyet
			driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
			//tim va click to Male Radio
			driver.findElement(By.xpath("//*[@value=\"Male\" and @name=\"gender\"]")).click();
			//tim va click to Age Group 5-15
			driver.findElement(By.xpath("//*[@value=\"5 - 15\"]")).click();
			//Check ket qua
			driver.findElement(By.xpath("//*[@onclick='getValues();']")).click();
			
			String sex = driver.findElement(By.xpath("//*[@class='groupradiobutton']")).getText();
			
			if (sex.contains("Sex : Male")) {
				System.out.println("Sex shows correct");
			}
			if (sex.contains("Age group: 5 - 15")) {
				System.out.println("Age shows correct");
			}
					
			Thread.sleep(50000);
		
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "F://Setup//chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
