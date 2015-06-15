package com.epam.scripps.channels.cookingchannel.tests;

import com.epam.scripps.channels.cookingchannel.pages.MainPage;
import com.epam.scripps.channels.cookingchannel.pages.ParentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Iurii_Galias on 6/11/2015.
 */
public class HeaderTest extends ChooseBrowser
{

    @Test(priority = 1)
    public void movingToParentPage()
    {
        MainPage mainPage = new MainPage(ChooseBrowser.getDriver());
        mainPage.getUrl("http://cookingchanneltv.dev.video.snidigital.com/");
        mainPage.moveToParentPage();
        Assert.assertEquals(ParentPage.parentPageCheck(),"http://www.cookingchanneltv.com/home.html");
    }

    @Test(priority = 2)
    public void movingToHomePage()
    {
        MainPage mainPage = new MainPage(ChooseBrowser.getDriver());
        mainPage.getUrl("http://cookingchanneltv.dev.video.snidigital.com/");
        mainPage.moveToMainPage();
        Assert.assertEquals(MainPage.mainPageCheck(),"http://cookingchanneltv.dev.video.snidigital.com/");
    }
}
