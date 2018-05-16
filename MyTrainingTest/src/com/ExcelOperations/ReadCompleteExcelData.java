package com.ExcelOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadCompleteExcelData {

	public static void main(String[] args) throws IOException {
	
		FileInputStream File=new FileInputStream("C:\\Users\\Neetha.Yerramada\\Desktop\\NeethaSelenium\\MyTrainingTest\\src\\com\\ExcelOperations\\mydetails.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(File);
		XSSFSheet sheet=workbook.getSheet("sheet1");
		
		int row_count=sheet.getLastRowNum();
		System.out.println(row_count);
		
		for(int i=0;i<=row_count;i++)
		{
			Row r=sheet.getRow(i);
			int cell_count=r.getLastCellNum();
			System.out.println(cell_count);
		
			for(int j=0;j<cell_count;j++)
			{
				String data=r.getCell(j).getStringCellValue();
				System.out.print(data+"  ");
				
			}
			System.out.println();
		}
		
		

	}

}
