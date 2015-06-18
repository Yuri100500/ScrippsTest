package com.epam.scripps.channels.cookingchannel.tests;

import com.epam.scripps.channels.cookingchannel.pages.*;
import com.epam.scripps.channels.cookingchannel.pages.authentication.ProvidersPopUp;
import com.epam.scripps.channels.cookingchannel.providers.OptimumPage;
import com.epam.scripps.utils.Consts;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Iurii_Galias on 6/11/2015.
 */
public class HeaderTests extends PreparingConfiguration
{

   /* @Test(description = "Check that channel logo navigates correct", priority = 1)
    public void movingToParentPage()
    {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.getUrl(home);
        mainPage.moveToParentPage();
        Assert.assertEquals(ParentPage.checkUrl(), Consts.PARENT_PAGE_URL, "Incorrect URL");
        Assert.assertEquals(ParentPage.parentPageChecking(), true, "You are on the wrong page");
    }

    @Test(description = "check that Full Episodes button navigates correct", priority = 2)
    public void movingToMainPage()
    {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.getUrl(home);
        mainPage.moveToMainPage();
        mainPage.mainPageChecking();
        Assert.assertEquals(MainPage.checkUrl(),Consts.HOME_PAGE_URL, "Incorrect URL");
        Assert.assertEquals(mainPage.mainPageChecking(), true,"You are on the wrong page");
    }

    @Test(description = "check that shows popup menu navigate to the player page", priority = 3)
    public void movingToPlayerPage()
    {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.getUrl(home);
        PlayerPage playerPage = mainPage.moveToPlayerPage();
        Assert.assertEquals(PlayerPage.checkUrl(),Consts.PLAYER_PAGE_CCJFF_SHOW_URL, "Incorrect URL");
        Assert.assertEquals(playerPage.playerPageChecking(), true,"You are on the wrong page");
    }

    @Test(description = "check that Live TV button navigates correct", priority = 4)
    public void movingToLiveTvPage()
    {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.getUrl(home);
        LiveTvPage liveTvPage = mainPage.moveToLiveTvPage();
        Assert.assertEquals(LiveTvPage.checkUrl(),Consts.LIVE_TV_PAGE_URL, "Incorrect URL");
        Assert.assertEquals(liveTvPage.liveTvPageChecking(),true, "You are on the wrong page");
    }

    @Test(description = "authorization on the site using Optimum provider", priority = 5)
    public void signInChecking()
    {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.getUrl(home);
        ProvidersPopUp signInPopUp = mainPage.openPopUp();
        OptimumPage enterCredentials = signInPopUp.chooseOptimum();
        enterCredentials.enterOptimumCredentials(optName,optPass);
        Assert.assertEquals(MainPage.checkUrl(), Consts.HOME_PAGE_URL, "Incorrect URL");
        Assert.assertTrue(mainPage.isAuthorized(), "Providers logo is present on the page, Somethings wrong with authorization");
    }

    @Test(dependsOnMethods ="signInChecking", description = "sign out on main page")
    public void signOutChecking()
    {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.getUrl(home);
        mainPage.signOut();
        Assert.assertTrue(mainPage.signInChecking(),"The sign in button is absent !!!!");
    }*/
}
