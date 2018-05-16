package com.Keyword;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Facebook_Login
{
	FirefoxDriver driver;
	@BeforeTest
	public void setup()
	{
		driver=new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@Test
	public void Login() throws IOException
	{
		FileInputStream File=new FileInputStream("C:\\Users\\Neetha.Yerramada\\Desktop\\NeethaSelenium\\MyTrainingTest\\src\\com\\Keyword\\FacebookLoginProperties");
		Properties pr=new Properties();
		pr.load(File);
		driver.findElementByName(pr.getProperty("UserName")).sendKeys("hai");
		driver.findElementByName(pr.getProperty("password")).sendKeys("hello");
		driver.findElementByXPath(pr.getProperty("login")).click();
		
		
	}
	

}
