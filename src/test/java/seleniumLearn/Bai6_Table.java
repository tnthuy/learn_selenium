package seleniumLearn;
import java.util.List;

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
	int count=0;
	@Test
	public void testFindLondon() {

		//Mo trang guruDemo
		driver.get("https://www.seleniumeasy.com/test/table-sort-search-demo.html");
		//Get number of columns and print column name
		List<WebElement> cols=driver.findElements(By.xpath("//*[@id=\"example\"]/thead/tr/th"));

		System.out.println("Number of columns: " +cols.size());
		for(WebElement col:cols) {
			System.out.println("Columns are "+ col.getText());
		}
		//Get number of rows and print row name
		List<WebElement> rows=driver.findElements(By.xpath("//*[@id=\"example\"]/tbody/tr"));
		System.out.println("Number of row:  "+rows.size());
		for (WebElement row:rows) {
			System.out.println("Row are "+ row.getText());
		}
		
		for (int i=1; i<=rows.size(); i++) {
			System.out.println(SelectTableContent(i, 3));
			if (SelectTableContent(i, 3)=="London") {
				count++;
				System.out.println(count);
				System.out.println("Name for "+count+"is "+SelectTableContent(i, 1));
			}
		}
	}

	public String SelectTableContent(int row, int column) {
		String content=driver.findElement((By.xpath(("//*[@id=\"example\"]/tbody/tr["+row+"]/td["+column+"]")))).getText();
		return content;
	
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