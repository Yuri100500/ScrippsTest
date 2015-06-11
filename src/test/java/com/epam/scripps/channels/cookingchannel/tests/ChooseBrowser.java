package com.epam.scripps.channels.cookingchannel.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

/**
 * Created by Iurii_Galias on 6/11/2015.
 */
public class ChooseBrowser {
    protected static WebDriver driver;

    @BeforeClass()
    public void preparation(){
        driver = new FirefoxDriver();
    }

}
