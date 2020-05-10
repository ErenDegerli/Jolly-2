package com.jolly2.pages;

import com.jolly2.configuration.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;

public class HomePage extends Base {

    @FindBy(css = "button[id='setrow-push-popup-cancel-button']")
    private WebElement laterBtn;

    @FindBy(css = "i[class='icon icon-close close-icon']")
    private WebElement cookieCloseBtn;

    @FindBy(css = "span[class='moreTextList']")
    private WebElement message;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean resultVerification() {
        List<WebElement> list = driver.findElements(By.cssSelector("div[class='tour-list-area list-main-area'] div"));
        return list.size()>0;
    }

    public void getHomePage() throws IOException {
        driver.get(Config.getValue("url"));
        waitUntilClickable(laterBtn).click();
        waitUntilClickable(cookieCloseBtn).click();
    }

    public boolean checkMsg(String msg) {
        return waitUntilVisible(message).getText().contains(msg);
    }





}