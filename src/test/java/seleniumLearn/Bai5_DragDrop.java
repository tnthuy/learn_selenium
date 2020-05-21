<<<<<<< HEAD
package seleniumLearn;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Bai5_DragDrop {
	WebDriver driver;
	WebElement bankDrag;
	WebElement salesDrag;
	WebElement bankDrop;
	WebElement salesDrop;
	WebElement moneyDrag1;
	WebElement moneyDrop1;
	WebElement moneyDrag2;
	WebElement moneyDrop2;
	@Test
	public void testKeyboard() throws InterruptedException {

		//Mo trang guruDemo
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		//Drag and drop bank
		bankDrag= driver.findElement(By.xpath("//*[@id=\"credit2\"]/a"));
		salesDrag=driver.findElement(By.xpath("//*[@id=\"credit1\"]/a"));
		moneyDrag1= driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
		moneyDrag2= driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
		//Element to which need to drop
		bankDrop = driver.findElement(By.xpath("//*[@id=\"bank\"]/li"));
		salesDrop =driver.findElement(By.xpath("//*[@id=\"loan\"]/li"));
		moneyDrop1 =driver.findElement(By.xpath("//*[@id=\"amt7\"]/li"));
		moneyDrop2 =driver.findElement(By.xpath("//*[@id=\"amt8\"]/li"));


		//Using Action class for drag and drop.		
		Actions act=new Actions(driver);

		//Dragged and dropped.		
		act.dragAndDrop(bankDrag, bankDrop).build().perform();
		act.dragAndDrop(salesDrag, salesDrop).build().perform();
		act.dragAndDrop(moneyDrag1, moneyDrop1).build().perform();
		act.dragAndDrop(moneyDrag2, moneyDrop2).build().perform();

		String outMessage=driver.findElement(By.xpath("//*[@id=\"equal\"]/a")).getText();
		String message= "Perfect!";
		if(driver.findElement(By.xpath("//*[@id=\"equal\"]/a")).isDisplayed())							
		{		
			System.out.println("Displayed !!!");					
		}
		else
		{
			System.out.println("Not Displayed !!!");					
		}

		Thread.sleep(3000);

		assertEquals(outMessage,message,"Expected output"+message+ "but actual output is"+outMessage);
		Thread.sleep(3000);
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

=======
package seleniumLearn;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Bai5_DragDrop {
	WebDriver driver;
	WebElement bankDrag;
	WebElement salesDrag;
	WebElement bankDrop;
	WebElement salesDrop;
	WebElement moneyDrag1;
	WebElement moneyDrop1;
	WebElement moneyDrag2;
	WebElement moneyDrop2;
	@Test
	public void testKeyboard() throws InterruptedException {

		//Mo trang guruDemo
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		//Drag and drop bank
		bankDrag= driver.findElement(By.xpath("//*[@id=\"credit2\"]/a"));
		salesDrag=driver.findElement(By.xpath("//*[@id=\"credit1\"]/a"));
		moneyDrag1= driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
		moneyDrag2= driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
		//Element to which need to drop
		bankDrop = driver.findElement(By.xpath("//*[@id=\"bank\"]/li"));
		salesDrop =driver.findElement(By.xpath("//*[@id=\"loan\"]/li"));
		moneyDrop1 =driver.findElement(By.xpath("//*[@id=\"amt7\"]/li"));
		moneyDrop2 =driver.findElement(By.xpath("//*[@id=\"amt8\"]/li"));


		//Using Action class for drag and drop.		
		Actions act=new Actions(driver);

		//Dragged and dropped.		
		act.dragAndDrop(bankDrag, bankDrop).build().perform();
		act.dragAndDrop(salesDrag, salesDrop).build().perform();
		act.dragAndDrop(moneyDrag1, moneyDrop1).build().perform();
		act.dragAndDrop(moneyDrag2, moneyDrop2).build().perform();

		String outMessage=driver.findElement(By.xpath("//*[@id=\"equal\"]/a")).getText();
		String message= "Perfect!";
		if(driver.findElement(By.xpath("//*[@id=\"equal\"]/a")).isDisplayed())							
		{		
			System.out.println("Displayed !!!");					
		}
		else
		{
			System.out.println("Not Displayed !!!");					
		}

		Thread.sleep(3000);

		assertEquals(outMessage,message,"Expected output"+message+ "but actual output is"+outMessage);
		Thread.sleep(3000);
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

>>>>>>> 073385d978e37e17b5b6f1e1e2ab69131122a1a3
