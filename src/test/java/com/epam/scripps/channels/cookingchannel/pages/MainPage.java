package com.epam.scripps.channels.cookingchannel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Iurii_Galias on 6/11/2015.
 */
public class MainPage {
    protected static WebDriver driver;

    @FindBy(id = ".//*[@id='logo']")
    protected WebElement logo;

    @FindBy(xpath = "//*[contains(text(),'Full Episodes')]")
    protected WebElement fullEpisodesButton;

    @FindBy(xpath = "//*[contains(text(),'Select a Show')]")
    protected WebElement selectAshowButton;

    @FindBy(xpath = "//*[contains(text(),'LIVE TV')]")
    protected WebElement liveTvButton;

    @FindBy(id = ".//*[@id='logIn']")
    protected WebElement signInButton;

    @FindBy(className = ".//*[@class = \'rsArrowIcn ss-navigateright\']")
    protected WebElement mainCarouselNavigationRight;

    @FindBy(className = ".//*[@class = \'rsArrowIcn ss-navigateleft\']")
    protected WebElement mainCarouselNavigationLeft;

    @FindBy(className = "//*[contains(text(),'More Videos')]")
    protected WebElement moreVideosButton;

public MainPage(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver, this);
}

    public void getUrl(String url){
        driver.get(url);
    }

    public ParentPage moveToParentPage(){
        logo.click();
        return PageFactory.initElements(driver, ParentPage.class);
    }

}
