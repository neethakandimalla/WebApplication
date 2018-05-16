package com.KeyWord;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTours_LogInTest 
{

	//FirefoxDriver driver;
	
	ChromeDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
		driver = new ChromeDriver();
		
		//driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void LogIn() throws IOException
	{
		
		FileInputStream file = new FileInputStream("C:\\Users\\Neetha.Yerramada\\Desktop\\NeethaSelenium\\WebApplicationTesting\\NewToursLogIn.properties");
		
		Properties pr = new Properties();
		pr.load(file);
		
		driver.findElement(By.name(pr.getProperty("UserName"))).sendKeys("tutorial");
		driver.findElement(By.name(pr.getProperty("Password"))).sendKeys("tutorial");
		
		driver.findElement(By.name(pr.getProperty("SignIn"))).click();
		
		
		String expected_Title="Find";
		String actual_Title=driver.getTitle();
		
		Assert.assertTrue(actual_Title.contains(expected_Title), "Title not Matched -- Fail");
		
		Reporter.log("Title Matched -- LogIn Test Case Passed");
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	
	
	
}
