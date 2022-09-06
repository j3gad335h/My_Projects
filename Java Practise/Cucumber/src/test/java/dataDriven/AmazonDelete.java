package dataDriven;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonDelete {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		ExcelReaderAndWriter obj = new ExcelReaderAndWriter();
		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		searchbox.sendKeys("TV",Keys.RETURN);
		List<WebElement> result= driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		int i=0;
		for(WebElement el:result){
			try {
				String data=el.getText();
				obj.writeExcel(data,i);
				i++;
			}
			catch(Exception e) {
				
			}
		}
		
			
		
	}

}
