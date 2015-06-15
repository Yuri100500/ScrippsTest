package com.epam.scripps.channels.cookingchannel.tests;

import com.epam.scripps.channels.cookingchannel.pages.MainPage;
import com.epam.scripps.channels.cookingchannel.pages.ParentPage;
import com.epam.scripps.channels.cookingchannel.pages.PlayerPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Iurii_Galias on 6/11/2015.
 */
public class HeaderTest extends ChooseBrowser
{

    @Test(description = "Check that parent page exist", priority = 1)
    public void movingToParentPage()
    {
        MainPage mainPage = new MainPage(ChooseBrowser.getDriver());
        mainPage.getUrl("http://cookingchanneltv.dev.video.snidigital.com/");
        mainPage.moveToParentPage();
        Assert.assertEquals(ParentPage.parentPageCheck(),"http://www.cookingchanneltv.com/home.html");
    }

    @Test(description = "check that Full Episodes button navigates correct",priority = 2)
    public void movingToHomePage()
    {
        MainPage mainPage = new MainPage(ChooseBrowser.getDriver());
        mainPage.getUrl("http://cookingchanneltv.dev.video.snidigital.com/");
        mainPage.moveToMainPage();
        Assert.assertEquals(MainPage.mainPageCheck(),"http://cookingchanneltv.dev.video.snidigital.com/");
    }

    @Test(description = "check forward to  player page",priority = 3)
    public void checkingHover()
    {
        MainPage mainPage = new MainPage(ChooseBrowser.getDriver());
        mainPage.getUrl("http://cookingchanneltv.dev.video.snidigital.com/");
        mainPage.hoverAndClick();
        Assert.assertEquals(PlayerPage.playerPageCheck(),"http://cookingchanneltv.dev.video.snidigital.com/player.CCJFF.html");
    }
}
