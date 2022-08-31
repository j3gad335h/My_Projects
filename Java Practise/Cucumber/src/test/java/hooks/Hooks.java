package hooks;

import com.fb.stepDefinition.ReusableMethods;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends ReusableMethods{
	
	@Before
	public void launchBrowser() {
		System.out.println("---Launching the Browser---");
		setupBrowser();
	}

	@After
	public void closeBrowser() {
		System.out.println("---Closing the Browser---");
		driver.close();
	}
}
