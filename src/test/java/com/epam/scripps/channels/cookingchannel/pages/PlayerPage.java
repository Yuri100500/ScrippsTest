package com.epam.scripps.channels.cookingchannel.pages;

import com.epam.scripps.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by 1 on 15.06.2015.
 */
public class PlayerPage extends MainPage {

    @FindBy(id = "player")
    protected WebElement player;

//===========================================

    public PlayerPage(WebDriver driver)
    {
        super(driver);
    }

//===========================================

    public boolean playerPageChecking()
    {
        return Utils.isElementPresent(player);
    }
}
