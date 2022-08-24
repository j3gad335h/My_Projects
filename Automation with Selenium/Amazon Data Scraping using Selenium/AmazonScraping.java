package com.amazon.scraping;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonScraping {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		searchbox.sendKeys("Mobile", Keys.RETURN);
		List<WebElement> container = driver.findElements(By.xpath("//div[@class='a-section']"));// 22-->
		/*
		 * div span a div input
		 */

		String excelPath = "G:\\Amazon Data.xls";
		FileInputStream fis = new FileInputStream(excelPath);
		HSSFWorkbook workBook = new HSSFWorkbook(fis);
		HSSFSheet sheet = workBook.getSheet("Sheet1");
		int i = 0;
		for (WebElement cont : container) {
			try {
				WebElement productName = cont
						.findElement(By.xpath(".//span[@class='a-size-medium a-color-base a-text-normal']"));
				String prod = productName.getText();
				sheet.createRow(i).createCell(0).setCellValue(prod);// --0

				String price = cont.findElement(By.xpath(".//span[@class='a-price-whole']")).getText();
				sheet.getRow(i).createCell(1).setCellValue(price); // --0 row

				String avgRating = cont.findElement(By.xpath(".//span[@class='a-icon-alt']")).getText();
				System.out.println(avgRating);
				sheet.getRow(i).createCell(2).setCellValue(avgRating); // --0 row

				String reviews = cont.findElement(By.xpath(".//span[@class='a-size-base s-underline-text']")).getText();
				sheet.getRow(i).createCell(3).setCellValue(reviews); // --0 row
			} catch (Exception e) {

			}
			i++;
		}
		FileOutputStream fos = new FileOutputStream(excelPath);
		workBook.write(fos);
		workBook.close();

	}

}
