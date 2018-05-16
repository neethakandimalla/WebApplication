package com.DataDrivenExcelData;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserRegistration_ExcelData {
	
	
	FirefoxDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver=new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@Test(priority=1)
	public void Register()
	{
		driver.findElement(By.linkText("REGISTER")).click();
		
	}
	
	@Test(priority=2)
	public void UserRegister() throws IOException
	{
		FileInputStream File=new FileInputStream("C:\\Users\\Neetha.Yerramada\\Desktop\\NeethaSelenium\\MyTrainingTest\\src\\com\\DataDrivenExcelData\\UserRegistrationFile.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(File);
		XSSFSheet sheet=workbook.getSheet("sheet1");
		
		for(int i=1;i<=sheet.getLastRowNum();i++)
		{
			Row r=sheet.getRow(i);
			
			driver.findElementByName("firstName").sendKeys(r.getCell(0).getStringCellValue());
			driver.findElementByName("lastName").sendKeys(r.getCell(1).getStringCellValue());
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
			String Expected_Result=r.getCell(9).getStringCellValue();
			String Actual_Result=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")).getText();
			
			if( Actual_Result.contains(Expected_Result))
			{
				System.out.println("User Registered Successfully --PASS");
				r.createCell(12).setCellValue("User Registered Successfully --PASS");
			}
			else
			{
				System.out.println("User Registration Failed -- FAIL");
				r.createCell(12).setCellValue("User Registration Failed -- FAIL");
			}
			
			Reporter.log("NewTours LogIn Successfull");
			driver.navigate().back();
			FileOutputStream File1=new FileOutputStream("C:\\\\Users\\\\Neetha.Yerramada\\\\Desktop\\\\NeethaSelenium\\\\MyTrainingTest\\\\src\\\\com\\\\DataDrivenExcelData\\\\UserRegistrationFileResult.xlsx");
			workbook.write(File1);
					
			
		}
		
		
	}

	@AfterTest
	public void Teardown()
	{
		driver.close();
	}
	
	

}
