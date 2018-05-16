package com.ValidatingTitle;

import org.openqa.selenium.firefox.FirefoxDriver;

public class ValidatingTitle_Google {

	public static void main(String[] args)
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		
		
		String expected_Title="google";
		String actual_Title=driver.getTitle();
		
		System.out.println(actual_Title);
		System.out.println(expected_Title);
		
		if(actual_Title.equalsIgnoreCase(expected_Title))
		{
			System.out.println("TItle matched -- PASS");
		}
		else
		{
			System.out.println("Title Not matched -- FAIL");
		}
		
		driver.close();

	}

}
