package testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        plugin = {"pretty:target/cucumber/cucumber.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
//                "html:target/cucumber/report",
                "json:target/cucumber/cucumber.json",
                "utils.MyTestListener"
        }
        ,features= {"scenarios"}
        ,glue = {"steps"}
        //,dryRun = true
        ,monochrome = true
        ,snippets = CucumberOptions.SnippetType.CAMELCASE
        ,tags = "@e2e"
        //,publish = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
