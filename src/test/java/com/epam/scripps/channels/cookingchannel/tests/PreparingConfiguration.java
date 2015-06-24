package com.epam.scripps.channels.cookingchannel.tests;

import com.epam.scripps.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

/**
 * Created by Iurii_Galias on 6/11/2015.
 */
public class PreparingConfiguration
{
    protected static WebDriver driver;

    protected static String home = ConfigReader.getStringFromFile("dev.env.home");
    protected static String liveTv = ConfigReader.getStringFromFile("dev.env.live");
    protected static String optName = ConfigReader.getStringFromFile("opt.name");
    protected static String optPass = ConfigReader.getStringFromFile("opt.pass");

    protected static WebDriver getDriver()
    {

        if (driver == null){
            driver = chooseDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS).pageLoadTimeout(15,TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    private static WebDriver chooseDriver()
    {
        String browser = java.lang.System.getProperties().getProperty("webbrowser");

        if (browser == null)
        {
            browser = "firefox";
        }
        if (browser.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        }
        return driver;
    }

    @BeforeClass
    public void preparation()
    {
        driver = getDriver();
    }

    @AfterSuite
    public void tearDown()
    {
        driver.quit();
    }
}
