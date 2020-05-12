package com.pop.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Base {
	public By TXT_EMAIL=By.id("email");
	public By TXT_PASSWORD=By.xpath("//*[@id=\"passwd\"]");
	public By BTN_SIGNIN=By.xpath("//*[@id=\"SubmitLogin\"]/span");

	public Login(WebDriver driver) {
		this.driver=driver;
	}
	
	public MyAccount login() {
		driver.findElement(TXT_EMAIL).sendKeys("thuy140583@gmail.com");
				driver.findElement(TXT_PASSWORD).sendKeys("Thuyvy12");
				driver.findElement(BTN_SIGNIN).click();
				return new MyAccount(driver);
	}
}
