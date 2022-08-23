package com.tnservices.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class SampleExcelClass {

	public static void main(String[] args) throws IOException {
		String excelPath = "G:\\Doc\\Git Repository\\mavenproject\\com.tnservices\\Parameters.xls";
		FileInputStream fis = new FileInputStream(new File(excelPath));
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sheet = wb.getSheet("Sheet1");
		int rowSize = sheet.getLastRowNum();//6
		for(int i=0;i<rowSize;i++) {
			try {
			HSSFRow row = sheet.getRow(i);
			int colSize = row.getLastCellNum();//3
			for(int j=0;j<colSize;j++) {
				try {
				String value=row.getCell(j).getStringCellValue();
				
				System.out.print(value+" ");}
				catch(Exception e) {
					//skjhsakjhf
				}
			}
			System.out.println("");}
			catch(Exception e) {
				//jdsg
			}
		}
		wb.close();
	}

}
/*
 * Excel Path declare
 * File read -->pdf,image,excel
 * Excel Read Workbook-->To read excel
 * 		--->Sheet Name
 * 				-->Row Size
 * 				-->Column Size
 * 		---->Row Value
 * 			-->cell values
 * 				--->String Store
 * 
 */
