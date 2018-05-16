package com.LinkTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GmailLinkTesting 
{

	public static void main(String[] args) throws InterruptedException
	{
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("https://www.google.com/gmail/about/");
		List<WebElement>link=driver.findElements(By.tagName("a"));
		System.out.println(link.size());
		
		for(int i=0;i<link.size();i++)
		{
			String linkName=link.get(i).getText();
			System.out.println(i+"."+linkName);
			link.get(i).click();
			System.out.println(driver.getCurrentUrl());
			System.out.println(driver.getTitle());
			System.out.println();
			
			driver.navigate().back();
			
			Thread.sleep(15);
			
			link=driver.findElementsByTagName("a");
		}
	    
		
			
		
		driver.close();
		

	}

}
