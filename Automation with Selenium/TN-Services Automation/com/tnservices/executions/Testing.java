package com.tnservices.executions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testing {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://eservices.tn.gov.in/eservicesnew/land/chittaCheckNewRural_en.html?lan=en");
		
		WebElement district =driver.findElement(By.id("districtCode"));
		Select districtDd = new Select(district);
		List<WebElement> x =districtDd.getOptions();
		for(WebElement y:x) {
			System.out.println(y.getText());
		}

	}

}
