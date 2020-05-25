package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",glue= {"stepDefinations"},tags="@AddPlace",plugin ="json:target/jsonReports/cucumber-report.json")
public class TestRunner {
//tags= {"@DeletePlace"}  compile test verify
	//plugin ="json:target/jsonReports/cucumber-report.json",
}
