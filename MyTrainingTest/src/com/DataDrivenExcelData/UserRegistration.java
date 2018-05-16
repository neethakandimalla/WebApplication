package com.DataDrivenExcelData;





import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserRegistration 
{
	FirefoxDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test(priority=1)
	public void Register()
	{
		driver.findElement(By.linkText("REGISTER")).click();
	}
	
	@Test(priority=2)
	public void UserRegistration()
	{
		driver.findElement(By.name("firstName")).sendKeys("Neetha");
		driver.findElement(By.name("lastName")).sendKeys("hai");
		driver.findElementByName("phone").sendKeys("1323255");
		driver.findElementByName("userName").sendKeys("neetha@gmail.com");
		driver.findElementByName("address1").sendKeys("HiTech");
		driver.findElementByName("city").sendKeys("Hyderabad");
		driver.findElementByName("state").sendKeys("Telangana");
		driver.findElementByName("postalCode").sendKeys("50001");
		driver.findElementByName("country").sendKeys("INDIA");
		
		driver.findElementByName("email").sendKeys("Neeethaaa");
		driver.findElementByName("password").sendKeys("abc123");
		driver.findElementByName("confirmPassword").sendKeys("abc123");
		
		driver.findElementByName("register").click();
		
		// html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b	
		
		String expected_UserName="Neeethaaa";
		String actual_RegisterdUserName=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")).getText();
		
		if(actual_RegisterdUserName.contains(expected_UserName))
		{
			System.out.println("User Registered Successfully --PASS");
		}
		else
		{
			System.out.println("User Registration Failed -- FAIL");
		}
		
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	
	
}