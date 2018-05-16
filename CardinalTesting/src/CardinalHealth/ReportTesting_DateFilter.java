package CardinalHealth;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ReportTesting_DateFilter 
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
		Thread.sleep(10000);
		
		driver.findElementByClassName("input_search").sendKeys(r1.getCell(3).getStringCellValue());
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElementByClassName("btn_go").click();
		
		String Parent_Window = driver.getWindowHandle(); 
		
		driver.findElementByLinkText(r1.getCell(4).getStringCellValue()).click();
		//driver.findElementByLinkText("Specialty Solutions Distribution Validation").click();
		
		//driver.findElementByLinkText("Specialty Solutions Distribution Validation_Deploy").click();
		driver.findElementByLinkText(r1.getCell(5).getStringCellValue()).click();
		
		
		Set<String>allwindows=driver.getWindowHandles();
		Iterator<String>iter=allwindows.iterator();
		
		String Main_window=iter.next();
		String Child_window=iter.next();
		String Child_window2=iter.next();
		
		
		driver.switchTo().window(Child_window);
		
		//driver.findElementByXPath(".//*[@id='14']/div[1]/div[1]/div[2]").click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//Thread.sleep(5000);
		
		driver.findElementByXPath(".//div[contains(@class,'QvFrame') and contains(@class, 'Document_MB01')]/div[2]/div/div[1]/div[5]/div/div[2]/div[2]/div/div/div").click();
		
		FileInputStream File=new FileInputStream("C:\\Users\\Neetha.Yerramada\\Desktop\\NeethaSelenium\\CardinalTesting\\src\\Cardinal_Date.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(File);
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		
		int Row_count=sheet.getLastRowNum();
		System.out.println(Row_count);
		
		for(int i=1;i<=Row_count;i++)
		{
			Row r=sheet.getRow(i);
			double d=r.getCell(0).getNumericCellValue();
			long x=(long)d;
			
			String acc_num=Long.toString(x);
			System.out.println(acc_num);
			Thread.sleep(5000);
	
			driver.findElementByXPath(".//*[@id='12']/div[2]/div/div[1]/div[5]/div/div[3]/div[1]").sendKeys(acc_num);
			//driver.findElementByXPath(".//*[@id='DS']/div/div/div[1]/div[1]/div[1]").sendKeys(acc_num);
			
			Thread.sleep(5000);;
			Actions act=new Actions(driver);
			act.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(5000);
			
			for(int a=1;a<=3;a++)
			{
				String acc_value=acc_num;
				driver.findElementByXPath(".//div[contains(@class,'QvFrame')and contains(@class,'Document_LB82')] /div[2]/div/div[1]/div["+a+"]/div[1]").click();
				Thread.sleep(5000);
				
				String report_total=driver.findElementByXPath(".//div[contains(@class,'QvFrame') and contains(@class, 'Document_CH80')]/div[2]/div[1]/div[1]/div[4]/div/div[3]/div[2]/div").getText();
				//Thread.sleep(5000);
				System.out.println("validation value is: "+report_total);
				//Thread.sleep(5000);
				
				r.createCell(a).setCellValue(report_total);
				
				FileOutputStream file1=new FileOutputStream("C:\\Users\\Neetha.Yerramada\\Desktop\\NeethaSelenium\\CardinalTesting\\src\\Cardinal_Date_Result.xlsx");
				workBook.write(file1);
				
				file1.flush();
				file1.close();
			
				}
				
		driver.findElementByXPath(".//div[contains(@class,'QvFrame') and contains(@class, 'Document_MB01')]/div[2]/div/div[1]/div[5]/div/div[2]/div[2]/div/div/div").click();
			
			}
		Thread.sleep(5000);
			
		driver.switchTo().window(Child_window2);
		
		driver.findElementByXPath(".//div[contains(@class,'QvFrame') and contains(@class, 'Document_MB01')]/div[2]/div/div[1]/div[5]/div/div[2]/div[2]/div/div/div").click();
		
		for(int i=1;i<=Row_count;i++)
		{
			
			Row r=sheet.getRow(i);
			double d=r.getCell(0).getNumericCellValue();
			long x=(long)d;
			String acc_num=Long.toString(x);
			
			System.out.println(acc_num);
		
			Thread.sleep(5000);
			driver.findElementByXPath(".//*[@id='12']/div[2]/div/div[1]/div[5]/div/div[3]/div[1]").sendKeys(acc_num);
			//driver.findElementByXPath(".//*[@id='DS']/div/div/div[1]/div[1]/div[1]").sendKeys(acc_num);
			
			Thread.sleep(5000);
			Actions act1=new Actions(driver);
			act1.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(5000);
			
			for(int a=1;a<=3;a++)
			{	
				
				driver.findElementByXPath(".//div[contains(@class,'QvFrame')and contains(@class,'Document_LB82')] /div[2]/div/div[1]/div["+a+"]/div[1]").click();
				
				Thread.sleep(5000);
				
				String deploy_report_total=driver.findElementByXPath(".//div[contains(@class,'QvFrame') and contains(@class, 'Document_CH80')]/div[2]/div[1]/div[1]/div[4]/div/div[3]/div[2]/div").getText();
			
				System.out.println("Deploy validation value is: "+deploy_report_total);
				Thread.sleep(5000);
				r.createCell(a+3).setCellValue(deploy_report_total);
	
				FileOutputStream file1=new FileOutputStream("C:\\Users\\Neetha.Yerramada\\Desktop\\NeethaSelenium\\CardinalTesting\\src\\Cardinal_Date_Result.xlsx");
				workBook.write(file1);
				
				file1.flush();
				file1.close();
				}
					
			driver.findElementByXPath(".//div[contains(@class,'QvFrame') and contains(@class, 'Document_MB01')]/div[2]/div/div[1]/div[5]/div/div[2]/div[2]/div/div/div").click();
		
	}
		
		/*Thread.sleep(5000);
		
		FileInputStream File2=new FileInputStream("C:\\Users\\Neetha.Yerramada\\Desktop\\NeethaSelenium\\CardinalTesting\\src\\Cardinal_Date_Result.xlsx");
		XSSFWorkbook workBook2= new XSSFWorkbook(File2);
		XSSFSheet sheet2 = workBook.getSheet("Sheet1");
		
		for(int j=1;j<=sheet2.getLastRowNum();j++)
		{
			Row r=sheet2.getRow(j);
			
			for(int q=1;q<=sheet2.getLastRowNum();j++)
			{
			String val_rep_value=r.getCell(j).getStringCellValue();
			String deploy_rep_value=r.getCell(j+3).getStringCellValue();
			
			if(val_rep_value.equalsIgnoreCase(deploy_rep_value))
			{
				r.createCell(j+1).setCellValue("Matched");
			}
			else
			{
				r.createCell(j+1).setCellValue("Not matched");
			}
			FileOutputStream file1=new FileOutputStream("C:\\Users\\Neetha.Yerramada\\Desktop\\NeethaSelenium\\CardinalTesting\\src\\Cardinal_Speciality_Result.xlsx");
			workBook.write(file1);
			}*/
		
			
			

		driver.close();
		driver.quit();
		
		
	
		}
}
	

	
	



	


