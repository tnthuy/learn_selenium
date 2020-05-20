package seleniumLearn;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

public class Bai4_MaleAndGroupAge2_CSV {
	WebDriver driver;
	WebElement maleRadio=driver.findElement(By.xpath("//*[@value=\"Male\" and @name=\"gender\"]"));
	WebElement femaleRadio = driver.findElement(By.xpath("//*[@value=\"Female\" and @name=\"gender\"]"));
	WebElement ageGroup0_5=driver.findElement(By.xpath("//*[@value=\"0 - 5\"]"));
	WebElement ageGroup5_15= driver.findElement(By.xpath("//*[@value=\"5 - 15\"]"));
	WebElement ageGroup15_50= driver.findElement(By.xpath("//*[@value=\"15 - 50\"]"));
	
	WebElement kq= driver.findElement(By.xpath("//*[@onclick='getValues();']"));
  @Test
  public void testRadioButton() throws InterruptedException, Exception {
	//Mo trinh duyet
			driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
			
			//Doc file
			CSVReader reader=new CSVReader(new FileReader("C:\\Users\\thuy\\eclipse-workspace\\seleniumLearn\\src\\test\\java\\data\\MaleAndGroup.csv"));
			List<String[]> list=reader.readAll();
			System.out.println("Total rows which we have is "+ list.size());

			//create Iterator reference
			Iterator<String[]> iterator=list.iterator();

			//Iterate all values
			while (iterator.hasNext()) {


				String[] str=iterator.next();
				//System.out.println(str.length);

				//tim va click to Male or Female radio
				maleRadio.click();

				//tim va click to one Age Group 
				ageGroup0_5.click();

				//Check ket qua
				kq.click();

				String sex = driver.findElement(By.xpath("//*[@class='groupradiobutton']")).getText();
				
				if (sex.contains("Sex : Male")) {
					System.out.println("Sex shows correct");
				}
				if (sex.contains("Age group: 5 - 15")) {
					System.out.println("Age shows correct");
				}
						
				Thread.sleep(2000);

				//System.out.println("Value are ");
				/*
				 * for (int i=0; i<str.length; i++) { System.out.println(" " +str[i]); }
				 */
				System.out.println("   ");

			}
		
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
