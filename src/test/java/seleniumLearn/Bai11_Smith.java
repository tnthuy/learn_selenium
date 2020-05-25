package seleniumLearn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Bai11_Smith {
	WebDriver driver;

	@Test
	public void FindSmith() {
		driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");
		driver.findElement(By.xpath("//*[@id=\"task-table-filter\"]")).sendKeys("smith");
		List<WebElement> strName1 = driver.findElements(By.xpath("//*[@id=\"task-table\"]/tbody/tr[@style=\"display: table-row;\"]/td[3]"));
		String s1="smith";
		String s2 ="Smith";
	    boolean kt =false;
		for(int i=0; i<strName1.size(); i++) {
		String strName2 = strName1.get(i).getText();
			System.out.println(strName1.get(i).getText());
			if((strName2.contains(s1))||((strName2.contains(s2)))) {
				kt =true;
			}			
		}
		if(kt==true)
		{
			System.out.println("OK");
		}
		else
		{
			System.out.println("NG");
		}
	}
  @BeforeMethod
  public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "E://Setup/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	
  }

  @AfterMethod
  public void afterMethod() {
  }

}
