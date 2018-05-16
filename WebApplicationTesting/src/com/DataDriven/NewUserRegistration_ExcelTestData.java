package com.DataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewUserRegistration_ExcelTestData
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
	public void UserRegistration() throws IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Neetha.Yerramada\\Desktop\\NeethaSelenium\\WebApplicationTesting\\src\\com\\ExcelTestDataFiles\\NewUserRegistrationTestData.xlsx");
		XSSFWorkbook workBook =new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		
		int RowCount=sheet.getLastRowNum();
		
		for(int i=1;i<=RowCount;i++)
		{
		
			Row r=sheet.getRow(i);
		
		driver.findElement(By.name("firstName")).sendKeys(r.getCell(0).getStringCellValue());
		driver.findElement(By.name("lastName")).sendKeys(r.getCell(1).getStringCellValue());
		
		double d=r.getCell(2).getNumericCellValue();
		long x=(long)d;
		String PhoneNumber=Long.toString(x);
		
		driver.findElementByName("phone").sendKeys(PhoneNumber);
		driver.findElementByName("userName").sendKeys(r.getCell(3).getStringCellValue());
		driver.findElementByName("address1").sendKeys(r.getCell(4).getStringCellValue());
		driver.findElementByName("city").sendKeys(r.getCell(5).getStringCellValue());
		driver.findElementByName("state").sendKeys(r.getCell(6).getStringCellValue());
		
		double p=r.getCell(7).getNumericCellValue();
		long y=(long)p;
		String PostalCode=Long.toString(y);
		
		driver.findElementByName("postalCode").sendKeys(PostalCode);
		driver.findElementByName("country").sendKeys(r.getCell(8).getStringCellValue());
		
		driver.findElementByName("email").sendKeys(r.getCell(9).getStringCellValue());
		driver.findElementByName("password").sendKeys(r.getCell(10).getStringCellValue());
		driver.findElementByName("confirmPassword").sendKeys(r.getCell(11).getStringCellValue());
		
		driver.findElementByName("register").click();
		
		// html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b	
		
		String expected_UserName=r.getCell(9).getStringCellValue();
		String actual_RegisterdUserName=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")).getText();
		
		if(actual_RegisterdUserName.contains(expected_UserName))
		{
			System.out.println("User Registered Successfully --PASS");
			r.createCell(12).setCellValue("User Registered Successfully --PASS");
		}
		else
		{
			System.out.println("User Registration Failed -- FAIL");
			r.createCell(12).setCellValue("User Registration Failed -- FAIL");
		}
		
		
		driver.navigate().back();
		
		FileOutputStream file1 = new FileOutputStream("C:\\Users\\Neetha.Yerramada\\Desktop\\NeethaSelenium\\WebApplicationTesting\\src\\com\\ExcelTestResultFiles\\NewUserRegistrationResultFile.xlsx");
		workBook.write(file1);
	}	
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	
	
}
