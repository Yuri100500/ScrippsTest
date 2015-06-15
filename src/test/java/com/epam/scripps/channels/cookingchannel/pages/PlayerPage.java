package com.epam.scripps.channels.cookingchannel.pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by 1 on 15.06.2015.
 */
public class PlayerPage extends MainPage {

    public PlayerPage(WebDriver driver)
    {
        super(driver);
    }

    public static String playerPageCheck()
    {
        return driver.getCurrentUrl();
    }
}
