package com.MyBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


		public class GetTest
		{

			public static void main(String[] args) 
			{
				WebDriver driver=new FirefoxDriver();
				driver.get("http://google.com");
				String title=driver.getTitle();
				String titleURL=driver.getCurrentUrl();
				System.out.println(title);
				System.out.println(titleURL);
				//System.out.println(driver.getPageSource());
				System.out.println(driver.getWindowHandle());
				System.out.println(driver.getClass());
				System.out.println(driver.toString());
				driver.close();

			}

		

	}


