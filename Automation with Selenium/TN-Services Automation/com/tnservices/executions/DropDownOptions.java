package com.tnservices.executions;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.pages.ViewPattaPage;
import com.tnservices.utils.WebDriverUtils;

public class DropDownOptions extends WebDriverUtils {
	static ChromeDriver driver;
	
	@Test
	public void launchBroswer() {
		launchBrowser();
		driver = getDriver();
		driver.get("https://eservices.tn.gov.in/eservicesnew/land/chittaCheckNewRural_en.html?lan=en");
	}
	
	@Test(dependsOnMethods = "launchBroswer")
	public void getDistrictValue() {
		ViewPattaPage vPage = new ViewPattaPage();
		WebElement district = vPage.getDistrict();
		Select dd = new Select(district);
		List<WebElement> options = dd.getOptions();
		
		for(WebElement opt:options) {
			System.out.println(opt.getText());
		}
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		System.out.println("Done");
	}

}
