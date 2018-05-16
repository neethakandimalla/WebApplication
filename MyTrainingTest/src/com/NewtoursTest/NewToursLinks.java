package com.NewtoursTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewToursLinks {

	
		

	

			public static void main(String[] args)
			{
				FirefoxDriver driver = new FirefoxDriver();
				driver.get("http://newtours.demoaut.com/");
				
				List<WebElement>links=driver.findElements(By.tagName("a"));
				
				System.out.println(links.size());
				
				for(int i=0;i<links.size();i++)
					
				{
					String linkName=links.get(i).getText();
					System.out.println(linkName);
				}
				
				
				driver.close();

			}


	}


