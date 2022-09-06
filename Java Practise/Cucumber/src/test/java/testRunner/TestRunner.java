package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/FbFeature/something.feature",
		glue="stepDefinition",
		dryRun=false,
		tags="@outline"
		
		)
public class TestRunner {

}
