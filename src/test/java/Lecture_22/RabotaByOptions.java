package Lecture_22;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/feature/RabotaBy_Test.feature"},
        plugin = {
                "pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json"
        },
        glue = {"CucumberSteps/rabotaby"}
)
public class RabotaByOptions extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
