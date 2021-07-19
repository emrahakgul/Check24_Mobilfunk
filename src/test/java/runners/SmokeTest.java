package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        tags = "@SmokeTest",
        features = {"src/test/java/features"},
        glue = {"stepDef"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","summary"}

)
public class SmokeTest extends AbstractTestNGCucumberTests {



}
