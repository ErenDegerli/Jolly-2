package com.jolly2.pages;

import com.jolly2.core.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base extends PageBase {

    protected Base(WebDriver driver) {
        super(driver);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        PageFactory.initElements(driver,this);
    }
}