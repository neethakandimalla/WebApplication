package CardinalHealth;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Sample 
{

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		FirefoxDriver driver=new FirefoxDriver();
		
		FileInputStream file_login=new  FileInputStream("C:\\Users\\Neetha.Yerramada\\Desktop\\NeethaSelenium\\CardinalTesting\\src\\Cardinal_Speciality_Login.xlsx");
		XSSFWorkbook workbook_login=new XSSFWorkbook(file_login);
		XSSFSheet sheet_login=workbook_login.getSheet("sheet1");
		
		Row r1=sheet_login.getRow(0);
		driver.get(r1.getCell(0).getStringCellValue());
		
		//driver.get("https://webssoil021.cardinalhealth.com/forms/Reporting/Reportinglogin.fcc?TYPE=33554433&REALMOID=06-d306327c-8b85-45b0-b7e4-92a6af65507c&GUID=0&SMAUTHREASON=0&METHOD=GET&SMAGENTNAME=-SM-8v4U7gacx%2fiRcJW9ckjIGQaNyBeBvFHeTe7CitcMwWzxKN3YR9OoG7gGSmsHwWG5FijGkbGLcG8Co%2bS6I0O3jfDXjyRzV%2fAN&TARGET=-SM-https%3a%2f%2freporting.cardinalhealth.com%2freportcenter%2f");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByName("USER").sendKeys(r1.getCell(1).getStringCellValue());
		driver.findElementByName("PASSWORD").sendKeys(r1.getCell(2).getStringCellValue());
		driver.findElementByXPath(".//*[@id='HomepageSignIn']/form/input[10]").click();
		Thread.sleep(5000);
		
		driver.findElementByClassName("input_search").sendKeys(r1.getCell(3).getStringCellValue());
		Thread.sleep(5000);
		driver.findElementByClassName("btn_go").click();
		
		String Parent_Window = driver.getWindowHandle();  
		
		driver.findElementByLinkText(r1.getCell(4).getStringCellValue()).click();
		//driver.findElementByLinkText("Specialty Solutions Distribution Validation").click();
		
		Thread.sleep(5000);
		//driver.findElementByLinkText("Specialty Solutions Distribution Validation_Deploy").click();
		driver.findElementByLinkText(r1.getCell(5).getStringCellValue()).click();
		
		
		Set<String>allwindows=driver.getWindowHandles();
		Iterator<String>iter=allwindows.iterator();
		
		String Main_window=iter.next();
		String Child_window=iter.next();
		String Child_window2=iter.next();
		
		
		driver.switchTo().window(Child_window);
		
		Thread.sleep(5000);
		
		driver.findElementByXPath(".//div[contains(@class,'QvFrame') and contains(@class, 'Document_MB01')]/div[2]/div/div[1]/div[5]/div/div[2]/div[2]/div/div/div").click();
		
		FileInputStream File=new FileInputStream("C:\\Users\\Neetha.Yerramada\\Desktop\\NeethaSelenium\\CardinalTesting\\src\\Cardinal_Speciality.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(File);
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		
		int Row_count=sheet.getLastRowNum();
		for(int i=1;i<=Row_count;i++)
		{
			Row r=sheet.getRow(i);
			double d=r.getCell(0).getNumericCellValue();
			long x=(long)d;
			String acc_num=Long.toString(x);
			
			System.out.println(acc_num);
			
			driver.findElementByXPath(".//*[@id='DS']/div/div/div[1]/div[1]/div[1]").sendKeys(acc_num);
			
			Actions act=new Actions(driver);
			Thread.sleep(5000);
			act.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(5000);
			
			String report_total=driver.findElementByXPath(".//div[contains(@class,'QvFrame') and contains(@class, 'Document_CH80')]/div[2]/div[1]/div[1]/div[4]/div/div[3]/div[2]/div").getText();
			
			System.out.println("validation value is: "+report_total);
			
			r.createCell(1).setCellValue(report_total);
			
			FileOutputStream file1=new FileOutputStream("C:\\Users\\Neetha.Yerramada\\Desktop\\NeethaSelenium\\CardinalTesting\\src\\sample.xlsx");
			workBook.write(file1);
			
			file1.flush();
			file1.close();

			driver.findElementByXPath(".//div[contains(@class,'QvFrame') and contains(@class, 'Document_MB01')]/div[2]/div/div[1]/div[5]/div/div[2]/div[2]/div/div/div").click();
		}
		
		Thread.sleep(5000);
		driver.switchTo().window(Child_window2);
		
		for(int i=1;i<=Row_count;i++)
		{
			Row r=sheet.getRow(i);
			double d=r.getCell(0).getNumericCellValue();
			long x=(long)d;
			String acc_num=Long.toString(x);
			
			System.out.println(acc_num);
			
			driver.findElementByXPath(".//div[contains(@class,'QvFrame') and contains(@class, 'Document_MB01')]/div[2]/div/div[1]/div[5]/div/div[2]/div[2]/div/div/div").click();
			Thread.sleep(5000);
			
			driver.findElementByXPath(".//*[@id='DS']/div/div/div[1]/div[1]/div[1]").sendKeys(acc_num);
			
			Actions act2=new Actions(driver);
			Thread.sleep(5000);
			act2.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(5000);
			
			String deploy_report_total=driver.findElementByXPath(".//div[contains(@class,'QvFrame') and contains(@class, 'Document_CH80')]/div[2]/div[1]/div[1]/div[4]/div/div[3]/div[2]/div").getText();
			
			System.out.println("Deploy validation value is: "+deploy_report_total);
			
			r.createCell(2).setCellValue(deploy_report_total);

			FileOutputStream file1=new FileOutputStream("C:\\Users\\Neetha.Yerramada\\Desktop\\NeethaSelenium\\CardinalTesting\\src\\sample.xlsx");
			workBook.write(file1);
			
			file1.flush();
			file1.close();
		}
		
		FileInputStream File2=new FileInputStream("C:\\Users\\Neetha.Yerramada\\Desktop\\NeethaSelenium\\CardinalTesting\\src\\sample.xlsx");
		XSSFWorkbook workBook2= new XSSFWorkbook(File2);
		XSSFSheet sheet2 = workBook.getSheet("Sheet1");
		
		for(int j=1;j<=sheet2.getLastRowNum();j++)
		{
			Row r=sheet2.getRow(j);
			String val_rep_value=r.getCell(1).getStringCellValue();
			String deploy_rep_value=r.getCell(2).getStringCellValue();
			
			if(val_rep_value.equalsIgnoreCase(deploy_rep_value))
			{
				r.createCell(3).setCellValue("Matched");
			}
			else
			{
				r.createCell(3).setCellValue("Not matched");
			}
			FileOutputStream file1=new FileOutputStream("C:\\Users\\Neetha.Yerramada\\Desktop\\NeethaSelenium\\CardinalTesting\\src\\sample.xlsx");
			workBook.write(file1);
		}
		
		driver.close();
		driver.quit();
		
	}
	
	
}



