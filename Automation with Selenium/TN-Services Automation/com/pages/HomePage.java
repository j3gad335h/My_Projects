package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tnservices.utils.WebDriverUtils;

public class HomePage extends WebDriverUtils {
	ChromeDriver driver;
	public HomePage() {
		driver = getDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "View Patta / Chitta")
	private WebElement viewPattaChitta;
	
	@FindBy(linkText = "FMB Sketch - Rural")
	private WebElement viewFMB;
	
	@FindBy(linkText = "Application Status")
	private WebElement viewApplicationStatus;

	public WebElement getViewPattaChitta() {
		return viewPattaChitta;
	}

	public void setViewPattaChitta(WebElement viewPattaChitta) {
		this.viewPattaChitta = viewPattaChitta;
	}

	public WebElement getViewFMB() {
		return viewFMB;
	}

	public void setViewFMB(WebElement viewFMB) {
		this.viewFMB = viewFMB;
	}

	public WebElement getViewApplicationStatus() {
		return viewApplicationStatus;
	}

	public void setViewApplicationStatus(WebElement viewApplicationStatus) {
		this.viewApplicationStatus = viewApplicationStatus;
	}


}
