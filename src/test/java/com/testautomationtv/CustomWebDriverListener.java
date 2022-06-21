package com.testautomationtv;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.lang.reflect.Method;

public class CustomWebDriverListener implements WebDriverListener {
    @Override
    public void beforeGet(WebDriver driver, String url) {
        System.out.println(String.format("About to open a page %s", url));
    }
    @Override
    public void afterGetText(WebElement element, String result) {
        System.out.println(String.format("Element %s has text '%s'", element, result));
    }

    @Override
    public void beforeAnyWebElementCall(WebElement element, Method method, Object[] args) {
        System.out.println(String.format(
                "About to call a method %s in element %s with parameters %s",
                method, element, args));
    }
    @Override
    public void afterAnyWebElementCall(WebElement element, Method method, Object[] args, Object result) {
        System.out.println(String.format(
                "Method %s called in element %s with parameters %s returned %s",
                method, element, args, result));
    }
    @Override
    public void beforeAnyCall(Object target, Method method, Object[] args) {
        System.out.println(String.format("About to call a method %s in %s with parameters %s",
                method, target, args));
    }
    @Override
    public void afterAnyCall(Object target, Method method, Object[] args, Object result) {
        System.out.println(String.format("Method %s called in %s with parameters %s returned %s",
                method, target, args, result));
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        System.out.println(String.format("Finding element: %s", locator.toString()));
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        System.out.println(String.format("Found element: %s", locator.toString()));
    }
}
