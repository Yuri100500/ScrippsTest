package com.epam.test.scripps.globalpreferences.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Iurii_Galias on 5/14/15.
 */
public class Driver {
    public WebDriver getFirefoxInstance(){
        WebDriver driver = new FirefoxDriver();
        return driver;
    }
}
