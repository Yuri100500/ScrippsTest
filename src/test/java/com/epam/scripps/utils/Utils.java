package com.epam.scripps.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

/**
 * Created by Iurii_Galias on 5/18/15.
 */
public class Utils
{
   // WebDriver driver;

    public static boolean isElementPresent(WebElement element)
    {
        if (element != null && element.isDisplayed() && element.isEnabled())
        {
            return true;
        }
        return false;
    }

    public static void waitForElementPresent(WebDriver driver, WebElement element, int timeInterval, int pollingInterval)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeInterval, pollingInterval);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
