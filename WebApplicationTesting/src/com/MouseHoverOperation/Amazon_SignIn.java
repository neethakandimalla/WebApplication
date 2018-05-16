package com.MouseHoverOperation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon_SignIn {

	public static void main(String[] args)
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://amazon.in");
		
		driver.manage().window().maximize();
		
		System.out.println(driver.getTitle());
		WebElement SignIn=driver.findElement(By.id("nav-link-yourAccount"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(SignIn).build().perform();
		
		driver.findElement(By.xpath(".//*[@id='nav_prefetch_yourorders']/span")).click();
		
		System.out.println(driver.getTitle());
		driver.close();

	}

}
