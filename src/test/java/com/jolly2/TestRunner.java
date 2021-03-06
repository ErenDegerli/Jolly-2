package com.jolly2;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "com/jolly2/steps", plugin = {
        "pretty",
        "html:target/cucumber",
})
public class TestRunner {
}