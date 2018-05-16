package com.Select;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectExample
{

	public static void main(String[] args) 
	{
		FirefoxDriver driver  = new FirefoxDriver();
		driver.get("http://my.monsterindia.com/sponsered_popup.html");
		
		WebElement CurrentLocation=driver.findElement(By.className("border_grey1"));
		Select country=new Select(CurrentLocation);
		
		country.selectByIndex(1);
		

	}

}
