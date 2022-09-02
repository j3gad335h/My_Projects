package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebUtils {
	public static WebDriver driver;

	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 }
	public void takeSs() throws IOException {
		// Format Date Time Format e.g 12-02-22 0816-987464687
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-mm-yy hhmm-ns"); 
		LocalDateTime ldt = LocalDateTime.now();
		String date=dtf.format(ldt);
		
		// Take Screenshot and save output as File
		File rawFile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		// Get user directory where we want to save screenshot
		String userDir=System.getProperty("user.dir");
		File screenShotDir=new File(userDir+"//Screenshot");
		if(!screenShotDir.exists()) {
			screenShotDir.mkdir();
		}
		File destFile= new File(screenShotDir+"//Screenshot "+date+" .png");
		
		// Copy Raw file to destination file
		FileUtils.copyFile(rawFile, destFile);
	}
	
}
