package com.epam.scripps.channels.cookingchannel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Iurii_Galias on 6/11/2015.
 */
public class MainPage
{
    protected static WebDriver driver;

    @FindBy(id = "logo")
    protected  WebElement logo;

    @FindBy(xpath = "//*[contains(text(),'Full Episodes')]")
    protected  WebElement fullEpisodesButton;

    @FindBy(xpath = "//*[contains(text(),'Shows')]")
    protected  WebElement showButton;

    @FindBy(xpath = ".//*[@id='showsWrapper']/ul[1]/li[1]/a")
    protected WebElement firstShows;

    @FindBy(xpath = "//*[contains(text(),'LIVE TV')]")
    protected WebElement liveTvButton;

    @FindBy(id = "logIn")
    protected WebElement signInButton;

    @FindBy(className = ".//*[@class = \'rsArrowIcn ss-navigateright\']")
    protected WebElement mainCarouselNavigationRight;

    @FindBy(className = ".//*[@class = \'rsArrowIcn ss-navigateleft\']")
    protected WebElement mainCarouselNavigationLeft;

    @FindBy(className = "//*[contains(text(),'More Videos')]")
    protected WebElement moreVideosButton;

public MainPage(WebDriver driver)
{
    this.driver = driver;
    PageFactory.initElements(driver, this);
}

    public void getUrl(String url)
    {
        driver.get(url);
    }

    public ParentPage moveToParentPage()
    {
        logo.click();
        return PageFactory.initElements(driver, ParentPage.class);
    }

    public void moveToMainPage()
    {
        fullEpisodesButton.click();
    }

    public static String mainPageCheck()
    {
        return driver.getCurrentUrl();
    }

    public  void hoverAndClick()
    {
        Actions action = new Actions(driver);
        action.moveToElement(showButton).build().perform();
        firstShows.click();
    }

}
