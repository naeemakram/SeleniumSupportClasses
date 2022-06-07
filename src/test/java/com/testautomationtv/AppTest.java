package com.testautomationtv;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

// there's a serious difference between JUnit 4 and JUnit 5.

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    static WebDriver driver;
    static final String url = "https://eviltester.github.io/supportclasses/#_2000";

    @BeforeAll
    public static void beforeYou()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
    }
    @Test
    public void canSelectAnOptionUsingFindElements()
    {
        final Select selectMenu = new Select(driver.findElement(By.id("select-menu")));
        selectMenu.selectByVisibleText("Option 3");
        Assertions.assertEquals("3", selectMenu.getFirstSelectedOption().getAttribute("value"));
        Assertions.assertEquals(false, selectMenu.isMultiple());// assertTrue method causes a strange error
        //  class file for java.util.function.BooleanSupplier not found

        final Select selectMulti = new Select(driver.findElement(By.id("select-multi")));
        Assertions.assertEquals(true, selectMulti.isMultiple());

        List<WebElement> options =selectMenu.getOptions();
        Assertions.assertEquals(4, options.size());

        Assertions.assertEquals("Option 1", options.get(0).getText());
    }

    @Test
    public void doItWithPageFactory()
    {
        PageSupport supp = new PageSupport(driver);
        supp.singleResendButton.click();
        Assertions.assertEquals("Received message: selected 1",
                supp.getForMessageText());
    }
}
