package google.stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import io.cucumber.java.en.*;

public class GoogleStepDefinition {
	WebDriver driver;
	@When("browser is open")
	public void browser_is_open() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
	}

	@And("user is on google search page")
	public void user_is_on_google_search_page() {
		driver.get("https://www.google.com/");
	}

	@When("user enter text in search box")
	public void user_enter_text_in_search_box() {
		WebElement searchBox =driver.findElement(By.xpath("//input[@title='Search']"));
		searchBox.sendKeys("Facebook");
	}

	@And("enters keys")
	public void enters_keys() {
		WebElement searchBox =driver.findElement(By.xpath("//input[@title='Search']"));
		searchBox.sendKeys(Keys.RETURN);
	}

	@Then("user navigated to results page")
	public void user_navigated_to_results_page() {
		System.out.println("User Navigated to search Results");
		System.out.println(driver.getTitle());
	}
}
