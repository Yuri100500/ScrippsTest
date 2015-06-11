package com.epam.scripps.channels.travelchannel.tests;

import com.epam.scripps.channels.travelchannel.pageobject.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Created by Iurii_Galias on 5/25/2015.
 */
public class AllTests {

    WebDriver driver;
    HomePage homePage = new HomePage(driver);


    @Test(description = "Check that we are on the homepage")
    public void test1TC(){
        homePage.homePageChecking();
    }
}
