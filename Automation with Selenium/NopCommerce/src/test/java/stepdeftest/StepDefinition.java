package stepdeftest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StepDefinition {
	WebDriver driver; //null value
	
	@Given("Launch red bus url")
	public void launch_red_bus_url() {
		driver=Hooks.driver;
		driver.get("https://www.redbus.in/");
	}
	@When("search from and to destination")
	public void search_from_and_to_destination() {
		WebElement src=driver.findElement(By.id("src"));
		src.sendKeys("Trichy");
		driver.findElement(By.xpath("//li[@select-id='results[0]']")).click();
		driver.findElement(By.id("dest")).sendKeys("Chennai");
		driver.findElement(By.xpath("//li[@select-id='results[0]']")).click();
	}
	@When("click search")
	public void click_search() throws Exception {
		String actTitle=driver.getTitle();
		if(actTitle.contains("red")) {
			System.out.println("Scenario Passed");
		}
		else {
			throw new Exception("This is not Amazon website") ;
		}
	}

}
