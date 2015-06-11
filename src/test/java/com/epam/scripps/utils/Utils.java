package com.epam.scripps.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

/**
 * Created by Iurii_Galias on 5/18/15.
 */
public class Utils {
    WebDriver driver;
    public  boolean isElementPresent(By by){
        try {
            driver.findElement(by);
        }catch (NoSuchElementException e){
            return false;
        }return true;
    }
}
