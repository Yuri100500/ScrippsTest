package com.epam.scripps.channels.cookingchannel.pages;

import com.epam.scripps.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Iurii_Galias on 6/16/2015.
 */
public class LiveTvPage extends MainPage
{
    @FindBy(className = "live-player-overlay-play-button")
    protected WebElement livePlayerOverlay;

    public LiveTvPage(WebDriver driver)
    {
        super(driver);
    }

    public boolean liveTvPageChecking()
    {
        return Utils.isElementPresent(livePlayerOverlay);
    }
}
