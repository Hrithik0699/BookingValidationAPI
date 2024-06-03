package testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;
import utils.RetryListener;

@Listeners({RetryListener.class})
@CucumberOptions(
        plugin = {"pretty:target/cucumber/cucumber.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
//                "html:target/cucumber/report",
                "json:target/cucumber/cucumber.json",
                "utils.MyTestListener",
                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
        }
        ,features= {"scenarios"}
        ,glue = {"steps"}
        //,dryRun = true
        ,monochrome = true
        ,snippets = CucumberOptions.SnippetType.CAMELCASE
        ,tags = "@bookerAPI"
        //,publish = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
