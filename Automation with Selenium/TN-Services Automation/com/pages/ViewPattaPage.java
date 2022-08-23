package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tnservices.utils.WebDriverUtils;

public class ViewPattaPage extends WebDriverUtils {
	static ChromeDriver driver;

	public ViewPattaPage() {
		driver = getDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}
	
	

	

	@FindBy(id = "districtCode")
	private WebElement district;

	@FindBy(xpath = "//select[@name='talukCode']")
	private WebElement taluk;

	@FindBy(xpath = "(//select[@name='talukCode']/option)[2]")
	private WebElement talukWait;

	@FindBy(xpath = "//select[@name='villageCode']")
	private WebElement village;

	@FindBy(xpath = "(//select[@name='villageCode']/option)[2]")
	private WebElement villageWait;

	@FindBy(xpath = "//input[@value='pt']")
	private WebElement pattaNumBtn;

	@FindBy(xpath = "//input[@value='sur']")
	private WebElement surNumBtn;

	@FindBy(id = "surveyNo")
	private WebElement surveyNum;

	@FindBy(name = "pattaNo")
	private WebElement pattaNum;

	@FindBy(name = "subdivNo")
	private WebElement sdNum;

	@FindBy(xpath = "(//select[@name='subdivNo']/option[2])")
	private WebElement subDivisionWait;

	@FindBy(tagName = "img")
	private WebElement captcha;
	
	@FindBy(name = "captcha")
	private WebElement captchaText;
	

	public WebElement getCaptchaText() {
		return captchaText;
	}

	public void setCaptchaText(WebElement captchaText) {
		this.captchaText = captchaText;
	}

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
		
		setExplicitWait(talukWait);
		return talukWait;
	}

	public void settWait(WebElement tWait) {
		this.talukWait = tWait;
	}

	public WebElement getVillage() {
		return village;
	}

	public void setVillage(WebElement village) {
		this.village = village;
	}

	public WebElement getvWait() {
		
		setExplicitWait(villageWait);
		return villageWait;
	}

	public void setvWait(WebElement vWait) {
		this.villageWait = vWait;
	}

	public WebElement getPattaNumBtn() {
		return pattaNumBtn;
	}

	public void setPattaNumBtn(WebElement pattaNumBtn) {
		this.pattaNumBtn = pattaNumBtn;
	}

	public WebElement getSurNumBtn() {
		return surNumBtn;
	}

	public void setSurNumBtn(WebElement surNumBtn) {
		this.surNumBtn = surNumBtn;
	}

	public WebElement getSurveyNum() {
		return surveyNum;
	}

	public void setSurveyNum(WebElement surveyNum) {
		this.surveyNum = surveyNum;
	}

	public WebElement getPattaNum() {
		return pattaNum;
	}

	public void setPattaNum(WebElement pattaNum) {
		this.pattaNum = pattaNum;
	}

	public WebElement getSdNum() {
		return sdNum;
	}

	public void setSdNum(WebElement sdNum) {
		this.sdNum = sdNum;
	}

	public WebElement getSdWait() {
		setExplicitWait(subDivisionWait);
		return subDivisionWait;
	}

	public void setSdWait(WebElement sdWait) {
		this.subDivisionWait = sdWait;
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
