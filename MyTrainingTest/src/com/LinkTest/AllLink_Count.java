package com.LinkTest;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AllLink_Count
{

	public static void main(String[] args)
	{
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("http://facebook.com");
		List<WebElement>link=driver.findElementsByTagName("a");
		System.out.println(link.size());
		for(int i = 0;i<link.size();i++)
		{
			
			System.out.println(link.get(i).getText());
			
		}
		
		driver.close();
	


	}

}
