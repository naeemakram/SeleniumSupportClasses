package com.testautomationtv;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

import java.lang.reflect.Field;

public class VisibleElementAjaxFactory implements ElementLocatorFactory {
    private final WebDriver driver;
    private final int timeout;

    public VisibleElementAjaxFactory(WebDriver driver, int timeout) {
        this.driver = driver;
        this.timeout = timeout;
    }

    @Override
    public ElementLocator createLocator(Field field) {
        return new VisibleAjaxElementLocator(driver, field, timeout);
    }

    private class VisibleAjaxElementLocator extends AjaxElementLocator {
        public VisibleAjaxElementLocator(WebDriver driver, Field field, int timeout) {
            super(driver, field, timeout);
        }
        @Override
        public boolean isElementUsable(WebElement element)
        {
            if(element == null)
                return false;
            return element.isDisplayed() && element.isEnabled();
        }
    }
}
