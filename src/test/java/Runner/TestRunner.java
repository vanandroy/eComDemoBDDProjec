package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".\\src\\test\\resources\\features",
                 glue= {"stepDefinitions","Hooks"},
                 plugin = {"pretty","html:target/CucumberReports/CucumberReport.html"},
                 publish = true
                  
		)
public class TestRunner {
//intentionally kept empty
}