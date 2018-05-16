package com.LinksTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewTours_Register_CLick {

	public static void main(String[] args) 
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		
		System.out.println(driver.getTitle()+ " --  "+ "HomePage Title");
		
		//driver.findElement(By.linkText("REGISTER")).click();
		
		driver.findElement(By.partialLinkText("REGI")).click();
		
		System.out.println(driver.getTitle()+"   --  "+ "Register Page Title");
		
		driver.close();
	}

}
