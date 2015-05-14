package com.epam.test.scripps.testsuite.travelchannel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

/**
 * Created by Iurii_Galias on 5/14/15.
 */
public class TCRunner {
    private WebDriver driver;

    @BeforeClass(description = "Start WebDriver")

    public void startBrowser(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}
