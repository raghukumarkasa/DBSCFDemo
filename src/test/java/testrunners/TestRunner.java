package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/resources/appfeatures/DBSLandingPage.feature"},
		glue= {"stepdefinitions","apphooks"},
		tags="@smoke",
		plugin = {"pretty","json:target/CucumberReport.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome=true
		)
public class TestRunner {

}
