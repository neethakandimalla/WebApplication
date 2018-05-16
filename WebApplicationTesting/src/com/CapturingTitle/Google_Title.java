package com.CapturingTitle;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Google_Title {

	public static void main(String[] args)
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://google.com");

		String Title=driver.getTitle();
		System.out.println(Title);
		
		driver.close();
	}

}
