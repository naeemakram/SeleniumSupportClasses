package com.testautomationtv;

import org.bouncycastle.crypto.modes.KCTRBlockCipher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageSupport extends PageFactory {
    private final WebDriver driver;
    @FindBy(how= How.ID, using = "resend-select")
    public WebElement singleResendButton;
    @FindBy(how = How.ID, using = "message")
    public WebElement message;
    public PageSupport(WebDriver driver)
    {
        this.driver = driver;
        initElements(driver, this);
    }

    public String waitForMessageText() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(
                        message
                )).getText();
    }
}
