package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderAndWriter {

	public ArrayList<String> readExcel() throws IOException {
		File obj = new File("Amazon Data.xlsx");
		FileInputStream file = new FileInputStream(obj);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetAt(0);
		ArrayList<String> data = new ArrayList<>();
		for (Row row : sheet) {
			for (Cell cell : row) {
				String text = cell.getStringCellValue();
				data.add(text);
			}
		}
		return data;
	}

	public void writeExcel(String data,int rowNum) throws IOException {
		File obj = new File("Amazon Data.xlsx");
		FileInputStream file = new FileInputStream(obj);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetAt(0);
		Row row=sheet.createRow(rowNum);
		row.createCell(0).setCellValue(data);
		row.createCell(1).setCellValue(10000);
		
		FileOutputStream file2 = new FileOutputStream(obj);
		wb.write(file2);
	}

	public static void main(String[] args) throws IOException {
		File obj = new File("Amazon Data.xlsx");
		FileInputStream file = new FileInputStream(obj);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetAt(0);
		int num = 1;
		for (Row row : sheet) {
			for (Cell cell : row) {
				cell.setCellValue(num);
				num++;
			}

		}
		FileOutputStream file2 = new FileOutputStream(obj);
		wb.write(file2);
	}
}
