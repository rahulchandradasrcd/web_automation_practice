package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTest extends BrowserSetup{

    @Test
    public void TestPageTitle(){
        // Direct Assert WithOut Storing data in variable
        Assert.assertEquals(browser.getTitle(), "Online Grocery Shopping and Delivery in Bangladesh | Buy fresh food items, personal care, baby products and more");
    }

    @Test
    public void TestPageUrl(){
        Assert.assertEquals(browser.getCurrentUrl(), "https://chaldal.com/");
    }
    //this Code used for print page_title with store in variable also assertion
    /*@Test
    public void TestPageTitle2(){
    String PageTitle = browser.getTitle();
    System.out.println(PageTitle);
    Assert.assertEquals(PageTitle, "Online Grocery Shopping and Delivery in Bangladesh | Buy fresh food items, personal care, baby products and more");
    }*/
}
