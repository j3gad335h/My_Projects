package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tnservices.utils.WebDriverUtils;

public class FMBPage extends WebDriverUtils {
	ChromeDriver driver;

	public FMBPage() {
		driver = getDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "districtCode")
	private WebElement district;

	@FindBy(name = "talukCode")
	private WebElement taluk;

	@FindBy(xpath = "(//select[@name='talukCode']/option)[2]")
	private WebElement tWait;

	@FindBy(name = "villageCode")
	private WebElement village;

	@FindBy(xpath = "(//select[@name='villageCode']/option)[2]")
	private WebElement vWait;

	@FindBy(id = "surveyNo")
	private WebElement surveyNum;

	@FindBy(id = "subdivNo")
	private WebElement sdNum;

	@FindBy(xpath = "(//select[@name='subdivNo']/option[2])")
	private WebElement sdWait;

	@FindBy(tagName = "img")
	private WebElement captcha;

	@FindBy(xpath = "//input[@value='Submit']")
	private WebElement submitBtn;

	public WebElement getDistrict() {
		return district;
	}

	public void setDistrict(WebElement district) {
		this.district = district;
	}

	public WebElement getTaluk() {
		return taluk;
	}

	public void setTaluk(WebElement taluk) {
		this.taluk = taluk;
	}

	public WebElement gettWait() {
		return tWait;
	}

	public void settWait(WebElement tWait) {
		this.tWait = tWait;
	}

	public WebElement getVillage() {
		return village;
	}

	public void setVillage(WebElement village) {
		this.village = village;
	}

	public WebElement getvWait() {
		return vWait;
	}

	public void setvWait(WebElement vWait) {
		this.vWait = vWait;
	}

	public WebElement getSurveyNum() {
		return surveyNum;
	}

	public void setSurveyNum(WebElement surveyNum) {
		this.surveyNum = surveyNum;
	}

	public WebElement getSdNum() {
		return sdNum;
	}

	public void setSdNum(WebElement sdNum) {
		this.sdNum = sdNum;
	}

	public WebElement getSdWait() {
		return sdWait;
	}

	public void setSdWait(WebElement sdWait) {
		this.sdWait = sdWait;
	}

	public WebElement getCaptcha() {
		return captcha;
	}

	public void setCaptcha(WebElement captcha) {
		this.captcha = captcha;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public void setSubmitBtn(WebElement submitBtn) {
		this.submitBtn = submitBtn;
	}

}
