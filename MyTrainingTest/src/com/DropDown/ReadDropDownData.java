package com.DropDown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadDropDownData
{

	public static void main(String[] args) 
	{
	FirefoxDriver driver = new FirefoxDriver();
	driver.get("https://www.facebook.com/");
	
	WebElement mon=driver.findElementById("month");
	List <WebElement> month=mon.findElements(By.tagName("on"));
	
	System.out.println(month.size());
	for(int i=0;i<month.size();i++)
	{
		String data=month.get(i).getText();
		System.out.println(data);
	}
	
	
	
		
		


	}

}
