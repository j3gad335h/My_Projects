package redbus.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "onward_cal")
	public WebElement date;

	@FindBy(xpath = "//table/tbody/tr/td[@class='monthTitle']")
	public WebElement monthYear;

	@FindBy(xpath = "//table/tbody/tr/td[@class='next']")
	public WebElement nextMonth;

	@FindBy(xpath = "//table/tbody/tr/td")
	public List<WebElement> days;
	
	@FindBy(id = "src")
	public WebElement source;
	
	@FindBy(id = "dest")
	public WebElement destination;
	
	@FindBy(xpath = "//*[@select-id='results[0]']")
	public WebElement result;
	
	@FindBy(id = "search_btn")
	public WebElement searchBtn;
	
	
	
	public static int dummy;
	public void selectMonth() {
		while (!monthYear.getText().contains("Sep")) {
			try {
				System.out.println(monthYear.getText());
				nextMonth.click();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	}

	public void selectDate() {
		for (WebElement day : days) {
			if (day.getText().contains("12")) {
				day.click();
			}
		}
	}
	
	public void selectLocation() {
		source.sendKeys("Trichy");
		result.click();
		destination.sendKeys("Chennai");
		result.click();
		searchBtn.click();
	}
}
