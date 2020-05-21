package seleniumLearn;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Bai2_Tong2So_CSV {
	WebDriver driver;

	@Test
	public void ReadCSVFile() throws Exception {
		//Mo trinh duyet
		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
		WebElement a =driver.findElement(By.xpath("//*[@id=\"sum1\"]"));
		WebElement b= driver.findElement(By.xpath("//*[@id=\"sum2\"]"));
		WebElement btKQ = driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button"));
		
		//Doc file
		CSVReader reader=new CSVReader(new FileReader("C:\\Users\\thuytn\\git\\learn_selenium\\src\\test\\java\\data\\ExportExcelCSV.csv"));
		List<String[]> list=reader.readAll();
		System.out.println("Total rows which we have is "+ list.size());

		//create Iterator reference
		Iterator<String[]> iterator=list.iterator();

		//Iterate all values
		while (iterator.hasNext()) {
			
			 			 
			String[] str=iterator.next();
			//System.out.println(str.length);

			//xoa gia tri cu va dien gia tri a
			a.clear();
			a.sendKeys(str[0]);

			//xoa gia tri cu va dien gia tri b
			b.clear();
			b.sendKeys(str[1]);

			//Click to tinh kq
			btKQ.click();

			//tinh va so sanh kq

			String ketqua= driver.findElement(By.xpath("//*[@id=\"displayvalue\"]")).getText();
			
			System.out.println(ketqua);

			
				if (ketqua.equals(String.valueOf(str[2]))) {
				
				System.out.println("dong " + str[0] +" + " +str[1]+ " show dung" );

			}
			else {
				System.out.println("dong " + str[0] +" + " +str[1]+  " show sai");

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
