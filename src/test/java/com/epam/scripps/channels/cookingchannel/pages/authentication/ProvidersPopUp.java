package com.epam.scripps.channels.cookingchannel.pages.authentication;

import com.epam.scripps.channels.cookingchannel.pages.MainPage;
import com.epam.scripps.channels.cookingchannel.providers.OptimumPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by 1 on 16.06.2015.
 */
public class ProvidersPopUp extends MainPage
{
    @FindBy(xpath = ".//*[@id='mCSB_1_container']/ul[1]/li[1]/div/img")
    protected WebElement optimumProvider;

    public ProvidersPopUp(WebDriver driver)
    {
        super(driver);
    }

    public OptimumPage chooseOptimum()
    {
        optimumProvider.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().defaultContent();
        return PageFactory.initElements(driver,OptimumPage.class);
    }
}
