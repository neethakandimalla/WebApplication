package com.ExcelOperations;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadData 
{

	public static void main(String[] args) throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Neetha.Yerramada\\Desktop\\NeethaSelenium\\MyTrainingTest\\src\\com\\ExcelOperations\\mydetails.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("sheet1");
		
		Row r=sheet.getRow(0);
		Cell c=r.getCell(0);
		String data =c.getStringCellValue();
		System.out.println(data);
		
	}
}
