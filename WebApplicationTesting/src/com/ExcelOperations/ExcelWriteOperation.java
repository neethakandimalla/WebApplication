package com.ExcelOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.dev.XSSFSave;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriteOperation {

	public static void main(String[] args) throws IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Neetha.Yerramada\\Desktop\\NeethaSelenium\\WebApplicationTesting\\src\\com\\ExcelTestDataFiles\\TestData.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		
		Row r=sheet.createRow(3);
		Cell c=r.createCell(2);
		c.setCellValue("Neetha");
		
		FileOutputStream file1 = new FileOutputStream("C:\\Users\\Neetha.Yerramada\\Desktop\\NeethaSelenium\\WebApplicationTesting\\src\\com\\ExcelTestDataFiles\\TestData.xlsx");
		workBook.write(file1);
		
	}

}
