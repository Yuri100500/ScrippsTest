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

    @FindBy(id = "program-title")
    protected WebElement liveTitleName;

    @FindBy(xpath = ".//*[@id='additional-program-desc']/span[1]")
    protected WebElement liveEpisodeName;

    @FindBy(id = "program-desc")
    protected WebElement liveDescriptionName;


//========================================================

    public LiveTvPage(WebDriver driver)
    {
        super(driver);
    }

    public boolean liveTvPageChecking()
    {
        return Utils.isElementPresent(livePlayerOverlay);
    }

    public String getLiveTitleName()
    {
        return liveTitleName.getText();
    }

    public String getLiveEpisodeName()
    {
        return liveEpisodeName.getText();
    }

    public String getLiveDescriptionName()
    {
        return liveDescriptionName.getText();
    }
}
