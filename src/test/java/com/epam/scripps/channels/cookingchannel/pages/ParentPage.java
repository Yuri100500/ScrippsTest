package com.epam.scripps.channels.cookingchannel.pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Iurii_Galias on 6/12/2015.
 */
public class ParentPage extends MainPage {

    public static String parentPageCheck(){
        return driver.getCurrentUrl();
    }

    public ParentPage(WebDriver driver){
        super(driver);
    }
}
