package redbus.testing;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import redbus.pageObjects.HomePage;

public class Calender {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		WebElement date = driver.findElement(By.id("onward_cal"));
		date.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		HomePage obj =new HomePage(driver);
		obj.selectMonth();
		obj.selectDate();
		obj.selectLocation();
	}

}
