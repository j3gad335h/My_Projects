package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyLogin {
	WebDriver driver;
	@Given("User is on login Page")
	public void user_is_on_login_page() {
		System.out.println("User is on Login Page");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
	}

	@When("User enter username and password")
	public void user_enter_username_and_password() {
		System.out.println("User Entering username and Password");
		WebElement userName =driver.findElement(By.id("email"));
		userName.sendKeys("ram123@gmail.com");
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys("password");
	}

	@And("Click Login button")
	public void click_login_button() {
		System.out.println("User Clicking Login Button");
		WebElement loginBtn= driver.findElement(By.name("login"));
		loginBtn.click();
		
		
	}

	@Then("user navigated to home page")
	public void user_navigated_to_home_page() {
		System.out.println("User Navigated to Home Page");
		
	}

	
}
