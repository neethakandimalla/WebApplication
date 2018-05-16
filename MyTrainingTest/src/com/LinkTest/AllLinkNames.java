package com.LinkTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AllLinkNames 
{

	public static void main(String[] args)
	{
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("http://gmail.com");
		List<WebElement>obj= driver.findElements(By.tagName("a"));
		System.out.println(obj.size());
		
			
	

	}

}
