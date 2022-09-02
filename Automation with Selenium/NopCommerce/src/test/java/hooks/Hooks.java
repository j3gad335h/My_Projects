package hooks;


import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.WebUtils;

public class Hooks extends WebUtils {
	@Before 
	public void beforeScenario() {
		System.out.println("--Before Scenario--");
		launchBrowser();
	}
	@After
	public void tearDown(Scenario sc) throws IOException {
		if(sc.isFailed()) {
			System.out.println("After Scenario-Scenario is Failed and Taking SS");
			takeSs();
		}
	}

}
