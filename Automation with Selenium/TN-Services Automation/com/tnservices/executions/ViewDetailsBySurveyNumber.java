package com.tnservices.executions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.ViewPattaPage;
import com.tnservices.utils.ExcelUtils;
import com.tnservices.utils.WebDriverUtils;

import net.sourceforge.tess4j.TesseractException;

public class ViewDetailsBySurveyNumber extends WebDriverUtils {
	public static ChromeDriver driver;
	public String url;

	public ExcelUtils data = new ExcelUtils();
	public String districtValue;
	public String talukValue;
	public String villageValue;
	public String pattaChitta;

	@DataProvider(name = "dataProvider")
	public Iterator<Object[]> dpMethod() throws IOException {
		ArrayList<Object[]> values = data.returnExcel(); //
		return values.iterator();

	}

	@BeforeSuite
	public void setupBrowser() {
		launchBrowser();
		driver = getDriver();
	}

	@BeforeClass
	@Parameters({ "district", "taluk", "village" })
	public void getVillageDetails(String district, String taluk, String village) {
		districtValue = district;
		talukValue = taluk;
		villageValue = village;
	}

	@Test
	public void getUrl() {
		driver.get("https://eservices.tn.gov.in/eservicesnew/index.html");
	}

	@Test(dependsOnMethods = "getUrl")
	public void viewPatta() {
		HomePage hPage = new HomePage();
		hPage.getViewPattaChitta().click();
		url=driver.getCurrentUrl();
	}
	@Test(enabled=false)
	public void getZoneValues() {
		
	}

	@Test(dependsOnMethods = "viewPatta", dataProvider = "dataProvider")
	public void viewBySurveyNumber(Object[] excelValues) throws IOException, TesseractException, InterruptedException {
		driver.navigate().refresh();
		driver.get(url);
		// Initialize object
		ViewPattaPage vPage = new ViewPattaPage();

		// Selecting District
		ddByVisibleText(vPage.getDistrict(), districtValue);

		// Selecting Taluk
		vPage.gettWait(); // Wait for taluk dropdown to load
		ddByVisibleText(vPage.getTaluk(), talukValue);

		// Selecting Village
		vPage.getvWait(); // Wait for Village dropdown to load
		ddByVisibleText(vPage.getVillage(), villageValue);

		// Choosing Survey Number
		vPage.getSurNumBtn().click();

		// Passing Survey Number,Sub Division Number Values
		String surNumObj = excelValues[0].toString();
		String sdNumObj = excelValues[1].toString();
		vPage.getSurveyNum().sendKeys(surNumObj, Keys.TAB);
		vPage.getSdWait(); // Wait for Sub Division dropdown to load
		ddByVisibleText(vPage.getSdNum(), sdNumObj);

		elementScreenshot(vPage.getCaptcha());
		String captcha = captchaSolver();
		vPage.getCaptchaText().sendKeys(captcha);
		Thread.sleep(500);
		vPage.getSubmitBtn().click();
//		printPage(surNumObj, sdNumObj);
		driver.get("https://eservices.tn.gov.in/eservicesnew/land/chittaCheckNewRural_en.html?lan=en");
		Thread.sleep(1000);

	}

}
