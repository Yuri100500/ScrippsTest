package com.epam.scripps.channels.cookingchannel.tests;

import com.epam.scripps.channels.cookingchannel.pages.MainPage;
import com.epam.scripps.channels.cookingchannel.pages.ParentPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Iurii_Galias on 6/11/2015.
 */
public class Tests {

   // public WebDriver driver;

    @Test
    public void checkCorrectLinkToParentPage(){
        MainPage mainPage = new MainPage(ChooseBrowser.getDriver());
        mainPage.getUrl("http://www.cookingchanneltv.dev.video.snidigital.com/");
        mainPage.moveToParentPage();
        Assert.assertEquals(ParentPage.parentPageCheck(),"http://www.cookingchanneltv.dev.video.snidigital.com/");
    }
}
