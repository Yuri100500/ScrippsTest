package com.epam.scripps.channels.cookingchannel.tests;

import com.epam.scripps.channels.cookingchannel.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Created by Iurii_Galias on 6/11/2015.
 */
public class Tests {
    public WebDriver driver;
    @Test
    public void checkLogo(){
        MainPage mainPage = new MainPage(driver);
        mainPage.getUrl("http://www.cookingchanneltv.dev.video.snidigital.com");
    }
}
