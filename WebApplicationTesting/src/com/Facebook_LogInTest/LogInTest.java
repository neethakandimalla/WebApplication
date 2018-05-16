package com.Facebook_LogInTest;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LogInTest {

	public static void main(String[] args)
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://facebook.com");
		
		//  id="email"
		
		driver.findElement(By.id("email")).sendKeys("Hello");

		//  id="pass" 
		
		// driver.findElement(By.id("pass")).sendKeys("Hiiii");
		
		// name="pass">
		
		driver.findElement(By.name("pass")).sendKeys("Hiii");
		
		// loginbutton
		
		driver.findElement(By.id("loginbutton")).click();
		
		//driver.close();
		
		
	}

}
