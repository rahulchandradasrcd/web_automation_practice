package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MyTest extends BrowserSetup {
    By pop_up = By.xpath("//button[@class='popup-modal__close-btn close-btn-outside js--popup-modal__close-btn']");////button[contains(@class,'close-btn-outside js--popup-modal__close-btn')]
    By electric = By.xpath("//a[contains(text(),'ইলেক্ট্রনিক্স')]");

    @Test
    public void TestPageTitle() {
        // Direct Assert WithOut Storing data in variable
        Assert.assertEquals(browser.getTitle(), "Online Grocery Shopping and Delivery in Bangladesh | Buy fresh food items, personal care, baby products and more");
    }

    @Test
    public void TestPageUrl() {
        Assert.assertEquals(browser.getCurrentUrl(), "https://chaldal.com/");
    }

    //this Code used for print page_title with store in variable also assertion
    /*@Test
    public void TestPageTitle2(){
    String PageTitle = browser.getTitle();
    System.out.println(PageTitle);
    Assert.assertEquals(PageTitle, "Online Grocery Shopping and Delivery in Bangladesh | Buy fresh food items, personal care, baby products and more");
    }*/
   /* @BeforeMethod
    public void GetTestSite() {
        browser.get("https://rahulshettyacademy.com/AutomationPractice/");
        browser.manage().window().maximize();
    }*/


    @Test
    public void closePopupTest() {
        try {
            browser.get("https://www.rokomari.com/");
            WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(GetElement(pop_up)));
            //WebElement closeButton = GetElement(pop_up);
            closeButton.click();
            Thread.sleep(2000);
            System.out.println("Page title after closing popup");

        } catch (Exception e) {
            System.out.println("An error occurred while closing the popup");
        }
        GetElement(electric).click();
    }
}

