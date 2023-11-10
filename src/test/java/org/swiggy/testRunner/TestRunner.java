package org.swiggy.testRunner;

import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.swiggy.baseUtils.TestBase;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        tags = (""),
        monochrome = true,
        plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread/", "html:target/cucumber-reports.html", "json:target/cucumber-reports/Cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml", "rerun:target/failedrerun.txt"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @BeforeTest
    public void setup() {
        TestBase.setup();
    }

    @AfterTest
    public void teardown() {
        TestBase.tearDown();
    }
}
