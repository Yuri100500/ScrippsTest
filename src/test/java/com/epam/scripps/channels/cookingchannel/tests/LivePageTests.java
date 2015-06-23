package com.epam.scripps.channels.cookingchannel.tests;



import com.epam.scripps.channels.cookingchannel.pages.LiveTvPage;
import com.epam.scripps.channels.cookingchannel.pages.authentication.ProvidersPopUp;
import com.epam.scripps.channels.cookingchannel.providers.OptimumPage;
import com.epam.scripps.utils.AnvatoServices;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;


/**
 * Created by Iurii_Galias on 6/17/2015.
 */
public class LivePageTests extends PreparingConfiguration
{
    List<JSONObject> allMetadata;
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

    @BeforeTest
    public void getMetadata()
    {
        allMetadata = AnvatoServices.allMetadataOffline();
    }

/*    @Test
    public void checkAnvatoOfflineService()
    {
        LiveTvPage liveTvPage  = new LiveTvPage(getDriver());
        liveTvPage.getUrl(liveTv);
        String programTitle = AnvatoServices.getMetadataByName(allMetadata, "title");
        String upNextTitle = AnvatoServices.getMetadataByName(allMetadata, "next");
        String programDescription = AnvatoServices.getMetadataByName(allMetadata, "rovi_long_description");

        String episodeName = AnvatoServices.getMetadataByName(allMetadata, "rovi_episode_title");
        if (episodeName != null && episodeName.equals(""))
        {
            episodeName = AnvatoServices.getMetadataByName(allMetadata, "rovi_long_title");
        }

        Assert.assertEquals(programTitle,liveTvPage.getLiveTitleName());
        Assert.assertEquals(upNextTitle,liveTvPage.getUpNextTitle(), "Incorrect Up Next title");
        Assert.assertEquals(episodeName,liveTvPage.getLiveEpisodeName(), "Incorrect episode name");
        Assert.assertEquals(programDescription,liveTvPage.getLiveDescriptionName(), "Incorrect description of the episode");
    }*/

    @Test
    public void checkAnvatoOnlineService()
    {
        LiveTvPage liveTvPage = new LiveTvPage(getDriver());
        liveTvPage.getUrl(liveTv);

        ProvidersPopUp signInPopUp = liveTvPage.openPopUp();
        OptimumPage enterCredentials = signInPopUp.chooseOptimum();
        enterCredentials.enterOptimumCredentials(optName,optPass);

        String eventId = AnvatoServices.getMetadataByName(allMetadata, "event");
        AnvatoServices.allMetadataOnline(eventId);

        String programTitleOnline = AnvatoServices.getMetadataByName(allMetadata, "def_title");
        String episodeNameOnline = AnvatoServices.getMetadataByName(allMetadata, "rovi_episode_title");
        String episodeDescriptionOnline = AnvatoServices.getMetadataByName(allMetadata, "rovi_long_description");

        Assert.assertEquals(programTitleOnline,liveTvPage.getLiveTitleName());
        Assert.assertEquals(episodeNameOnline,liveTvPage.getLiveEpisodeName());
        Assert.assertEquals(episodeDescriptionOnline,liveTvPage.getLiveDescriptionName());

    }
}
