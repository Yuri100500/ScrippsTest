package com.epam.scripps.channels.cookingchannel.tests;



import com.epam.scripps.channels.cookingchannel.pages.LiveTvPage;
import com.epam.scripps.channels.cookingchannel.pages.MainPage;
import com.epam.scripps.channels.cookingchannel.pages.authentication.ProvidersPopUp;
import com.epam.scripps.channels.cookingchannel.providers.OptimumPage;
import com.epam.scripps.utils.AnvatoServices;
import com.epam.scripps.utils.Consts;
import com.google.gson.JsonObject;
import netscape.javascript.JSObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;


/**
 * Created by Iurii_Galias on 6/17/2015.
 */
public class LivePageTests extends PreparingConfiguration
{
/*    @Test()
    public void checkAuthorization()
    {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.getUrl(liveTv);
        ProvidersPopUp signInPopUp = mainPage.openPopUp();
        OptimumPage enterCredentials = signInPopUp.chooseOptimum();
        enterCredentials.enterOptimumCredentials(optName,optPass);
        Assert.assertEquals(MainPage.checkUrl(), Consts.LIVE_TV_PAGE_URL, "Incorrect URL");
        Assert.assertTrue(mainPage.isAuthorized(), "Providers logo is present on the page, Somethings wrong with authorization");
    }*/

    @Test
    public void checkAnvatoOfflineService()
    {
/*        LiveTvPage liveTvPage  = new LiveTvPage(getDriver());
        liveTvPage.getUrl(liveTv);*/
        AnvatoServices.checkingMetadataOfflineService();
    }
}
