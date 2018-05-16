package com.RadioOperation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioButtonTesting {

	public static void main(String[] args) {
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("http://demo.guru99.com/test/radio.html");
		
		WebElement software=driver.findElementByXPath("html/body/div[2]");
		List<WebElement> soft_name=software.findElements(By.name("webform"));

		
		System.out.println(soft_name.size());
		for(int i=0;i<soft_name.size();i++)
		{
			soft_name.get(i).click();
			
			for(int j=0;j<soft_name.size();j++)
			{
				System.out.println(soft_name.get(j).getAttribute("value")+"  "+soft_name.get(j).getAttribute("checked"));
			}
		
		}
		

	}

}
