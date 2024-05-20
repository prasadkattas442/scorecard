package testrunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Feature",glue = "stepDefination",tags = "@y",plugin ={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"} )
public class TestRunner extends AbstractTestNGCucumberTests {
}
