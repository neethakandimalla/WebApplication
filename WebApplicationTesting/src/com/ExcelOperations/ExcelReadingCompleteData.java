package com.ExcelOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadingCompleteData {

	public static void main(String[] args) throws IOException
	{

		FileInputStream file = new FileInputStream("C:\\Users\\Neetha.Yerramada\\Desktop\\NeethaSelenium\\WebApplicationTesting\\src\\com\\ExcelTestDataFiles\\MultileTestData.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		
		int RowCount=sheet.getLastRowNum();
		
		for(int i=0;i<=RowCount;i++)
		{
			Row r=sheet.getRow(i);
			
			int CellCount=r.getLastCellNum();
			for(int j=0;j<CellCount;j++)
			{
				String data=r.getCell(j).getStringCellValue();
				System.out.print(data+"  ");
			}
	
			System.out.println();
		}

	}

}
