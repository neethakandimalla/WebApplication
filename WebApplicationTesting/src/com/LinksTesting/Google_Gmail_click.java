package com.LinksTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Google_Gmail_click {

	public static void main(String[] args)
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		
		//driver.findElement(By.linkText("Sign in")).click();
		
		//driver.findElement(By.id("gb_70")).click();
		
		driver.findElement(By.xpath(".//*[@id='gb_70']")).click();
		
		//*[@id="gb_70"]
		
		driver.close();
		
		

	}

}
