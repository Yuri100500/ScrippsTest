package com.epam.scripps.channels.travelchannel.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.NoSuchElementException;

/**
 * Created by Iurii_Galias on 5/18/15.
 */
public class HomePage {
     public static WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement homePageChecking(){
        WebElement element = driver.findElement(By.className("featured-carousel-item analytic-click-item111"));
        Assert.assertFalse(isElementPresent(By.className("featured-carousel-item analytic-click-item111")),"Error, the current element is not displayed");
        return element;
    }

    public static boolean isElementPresent(By by){
        try{
            driver.findElement(by);
        }catch (NoSuchElementException e){
            return false;
        }return true;
    }


}
