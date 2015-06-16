package com.epam.scripps.channels.cookingchannel.pages;

import com.epam.scripps.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Iurii_Galias on 6/12/2015.
 */
public class ParentPage extends MainPage
{

    @FindBy(id = "cc-search-input")
    protected static WebElement searchInput;

//==========================================================

    public ParentPage(WebDriver driver)
    {
        super(driver);
    }

//==========================================================

    public static boolean parentPageChecking()
    {
        return Utils.isElementPresent(searchInput);
    }
}
