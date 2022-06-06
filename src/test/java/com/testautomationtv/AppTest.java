package com.testautomationtv;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    static WebDriver driver;
    static final String url = "https://eviltester.github.io/supportclasses/";

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
    }
}
