package com.tnservices.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.print.PageSize;
import org.openqa.selenium.print.PrintOptions;
import org.openqa.selenium.print.PrintOptions.Orientation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class WebDriverUtils {
	private static ChromeDriver driver; // Print Page only works with ChromeDriver
	public static WebDriverWait wait;

	public static ChromeDriver getDriver() {
		return driver;
	}

	public static void setDriver(ChromeDriver driver) {
		WebDriverUtils.driver = driver;
	}

	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
//		options.addArguments("--headless"); // Selenium 4 print option only works in headless mode
		setDriver(new ChromeDriver(options));
		driver.manage().window().maximize();
	}

	public static void setExplicitWait(WebElement el) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(el));
	}

	public String returnDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM--hh-mm-ss-ns");
		LocalDateTime ldt = LocalDateTime.now();
		String timeNow = dtf.format(ldt);
		String timeStamp = timeNow.substring(0, timeNow.length() - 8);
		return timeStamp;
	}

	public void pageScreenshot() throws IOException {
		String timeStamp = returnDate();
		// Create Path to save Screenshot
		String workingDir = System.getProperty("user.dir");
		String destPath = workingDir + "/Screenshot/" + "MySs " + timeStamp + ".png";
		File destFile = new File(destPath);

		// Typecast driver to TakeScreenshot interface
		File rawFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(rawFile, destFile);
	}

	public void elementScreenshot(WebElement el) throws IOException {
		// Create Path to save Screenshot
		String workingDir = System.getProperty("user.dir");
		String destPath = workingDir + "/Screenshot/" + "Element" + ".png";
		File destFile = new File(destPath);

		// Typecast driver to TakeScreenshot interface
		File rawFile = ((TakesScreenshot) el).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(rawFile, destFile);
	}

	// Captcha Solver
	public String captchaSolver() throws TesseractException {
		String workingDir = System.getProperty("user.dir");
		String destPath = workingDir + "/Screenshot/" + "Element" + ".png";

		Tesseract tesseract = new Tesseract();
		String text = "";

		File imgFile = new File(destPath);
		text = tesseract.doOCR(imgFile);
		text=text.replaceAll("[\\n\t ]", "");
		return text;
	}

	// Print Page
	public void printPage(String text1, String text2) throws IOException {
		// ChromeDriver driver
		String workingDir = System.getProperty("user.dir");
		String destPath = workingDir + "/" + text1 + "-" + text2 + ".pdf";
		PrintOptions printOptions = new PrintOptions();
		PageSize pageSize = new PageSize(29.6926, 21.0058); // A4 format size
		printOptions.setPageSize(pageSize);
		printOptions.setOrientation(Orientation.PORTRAIT);
		Pdf pdf = driver.print(printOptions);
		Files.write(Paths.get(destPath), OutputType.BYTES.convertFromBase64Png(pdf.getContent()));
	}

	// Dropdown by visible Text
	public static void ddByVisibleText(WebElement el, String text) {
		Select dd = new Select(el);
		dd.selectByVisibleText(text);
	}

}
