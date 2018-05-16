package com.MouseHover;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class WalmartMouseHover 
{

	public static void main(String[] args)
	{
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("https://www.walmart.com/");
		
		WebElement dept=driver.findElementById("header-GlobalLefthandNav-toggle-1");
		System.out.println(dept.getText());
		
		Actions list=new Actions(driver);
		
		list.moveToElement(dept).build().perform();
		System.out.println(driver.getTitle());
	
		WebElement homefurn=driver.findElementById("superDeptId-2");

		
		list.moveToElement(homefurn).build().perform();
		driver.findElementByXPath("//*[@id='superDept-2']/div[1]/div[2]/a[2]").click();
	
		
		
		driver.close();
	}
		
}
