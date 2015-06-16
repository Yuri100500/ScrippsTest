package com.epam.scripps.channels.cookingchannel.providers;

import com.epam.scripps.channels.cookingchannel.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by 1 on 16.06.2015.
 */
public class OptimumPage extends MainPage
{
    @FindBy(id = "IDToken1")
    protected WebElement nameField;

    @FindBy(id = "IDToken2")
    protected WebElement passField;

    @FindBy(id = "signin_button")
    protected WebElement optimumSignIn;

    public OptimumPage(WebDriver driver)
    {
        super(driver);
    }

    public void enterOptimumCredentials(String name, String password)
    {
        nameField.sendKeys(name);
        passField.sendKeys(password);
        optimumSignIn.click();
    }
}
