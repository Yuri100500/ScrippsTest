package com.epam.scripps.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

/**
 * Created by Iurii_Galias on 5/18/15.
 */
public class Utils
{
   // WebDriver driver;

    public static boolean isElementPresent(WebElement element)
    {
        if (element != null && element.isDisplayed())
        {
            return true;
        }
        return false;
    }
}
