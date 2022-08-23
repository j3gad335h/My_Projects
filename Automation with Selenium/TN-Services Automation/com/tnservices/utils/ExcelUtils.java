package com.tnservices.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

public class ExcelUtils {
	public static String excelPath = "G:\\Doc\\Git Repository\\mavenproject\\com.tnservices\\Parameters.xls";

	public ArrayList<Object[]> returnExcel() throws IOException {
		ArrayList<Object[]> testing = new ArrayList<Object[]>();
		
		// obtaining input bytes from a file
		FileInputStream fis = new FileInputStream(new File(excelPath));
		
		// creating workbook instance that refers to .xls file
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		
		// creating a Sheet object to retrieve the object
		HSSFSheet sheet = wb.getSheetAt(0);
		int rowSize = sheet.getLastRowNum();
		for (int i = 1; i < rowSize; i++) {
			HSSFRow row = sheet.getRow(i); // Create Varaiable for a row
			int colSize = row.getLastCellNum(); // Get Total Column in a row
			
			Object[] testx = new Object[colSize];
			for (int j = 0; j < colSize; j++) {
				row.getCell(j).setCellType(CellType.STRING);
				String cellData = row.getCell(j).toString();
				testx[j] = cellData;
			}
			testing.add(testx);
		}
		wb.close();
		return testing;
	}

}
