package recyclingFactory;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, plugin = {"html:target/cucumber-html-report.html", "json:target/cucumber-json-report.json"}
        ,features = "src/test/resources/recyclingFactory.feature",glue = {"recyclingFactory"})
public class TestApplication {
}

