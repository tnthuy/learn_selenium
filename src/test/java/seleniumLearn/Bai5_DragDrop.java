package seleniumLearn;
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
	@Test
	public void testKeyboard() throws InterruptedException {

//Mo trang guruDemo
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		//Drag and drop bank
		bankDrag= driver.findElement(By.xpath("//*[@id=\"credit2\"]"));
		salesDrag=driver.findElement(By.xpath("//*[@id=\"credit1\"]"));
		bankDrag.
		int x=itemDrop.getLocation().getX();
		int y=itemDrop.getLocation().getY();
		System.out.println(x);
		System.out.println(y);

		//Using Action class for drag and drop.		
		Actions act=new Actions(driver);

		//Dragged and dropped.		
		act.dragAndDrop(itemDrag, itemDrop).perform();
		//act.dragAndDropBy(itemDrag, 221, 64).build().perform();

		if(driver.findElement(By.xpath("//*[@id=\"droppedlist\"]/span")).isDisplayed())							
		{		
			System.out.println("Displayed !!!");					
		}
		else
		{
			System.out.println("Not Displayed !!!");					
		}


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