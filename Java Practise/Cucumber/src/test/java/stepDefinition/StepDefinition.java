package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {
	public static WebDriver driver;

	@Given("Launch the Browser")
	public void launch_the_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@And("Get Amazon url {string}")
	public void get_amazon_url(String url) {
		driver.get(url);
	}

	@When("user in in Amazon Website")
	public void user_in_in_amazon_website() throws Exception {
		String actualTitle = driver.getTitle();
		if (actualTitle.contains("Amazon")) {
			System.out.println("USer in Amazon Website");
		} else {
			throw new Exception("Invalid Url or some other Error");
		}
	}

	@And("Search something {string}")
	public void search_something(String keyWord) {
		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		searchbox.sendKeys(keyWord, Keys.RETURN);
	}

	@Then("Validate Search Function")
	public void validate_search_function() {
		System.out.println("Validated");
	}

	@When("Click Returns and Order")
	public void click_returns_and_order() {
		driver.findElement(By.linkText("Sell")).click();
	}

	@When("Search something called {string}")
	public void search_something_called(String string) {
		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		searchbox.sendKeys(string, Keys.RETURN);
	}

}
