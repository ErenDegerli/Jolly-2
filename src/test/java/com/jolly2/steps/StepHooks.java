package com.jolly2.steps;

import com.jolly2.driver.SetDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

public class StepHooks {

    public static WebDriver driver;

    @Before
    public void donothing() throws IOException {
        driver = SetDriver.initialiseDriver();
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
            String destinationFile = System.getProperty("user.dir") + "\\target\\" + scenario.getName() + ".png";
            FileUtils.copyFile(source, new File(destinationFile));
        }
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}