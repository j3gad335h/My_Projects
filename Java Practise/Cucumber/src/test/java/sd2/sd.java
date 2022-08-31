package sd2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class sd {
	WebDriver driver;

	@Given("Browser is open")
	public void browser_is_open() {
		System.out.println("broswer is open");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@Then("User is on login page")
	public void user_is_on_login_page() {
		System.out.println("User is on login page");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@When("User enters Username as {string} and Password as {string}")
	public void user_enters_username_as_and_password_as(String Admin, String admin123) throws InterruptedException {
		System.out.println("User   Enters username and password");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		Thread.sleep(2000);

	}

	@When("user enters {string} and {string}")
	public void user_enters_and(String username, String password) {
		System.out.println("Invalid credentials");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
	    
	}







	@And("user click the login")
	public void user_click_the_login() {
		System.out.println("User hit the login");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

}
