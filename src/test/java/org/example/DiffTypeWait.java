package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class DiffTypeWait extends BrowserSetup{
    // This is locator for testing
    By element1 = By.xpath("//input[@name='commit']");
    By result1 = By.xpath("//h2[@id='two']");
    By start = By.xpath("//input[@id='loaderStart']");
    By loading = By.xpath("//b[normalize-space()='Loading...']");
    By Loader_delay_txt = By.xpath("//h2[@id='loaderdelay']");

    @BeforeMethod
    public void GetBrowser(){
        browser.get("https://qavbox.github.io/demo/delay/");
        browser.manage().window().maximize();
    }

    @Test
    public void WaiTest() throws InterruptedException {
        GetElement(element1).click();;
        //Thread.sleep(4000);
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(result1, "I am here!"));
        //System.out.println(test_1.getText());
        Assert.assertEquals(GetElement(result1).getText(), "I am here!");

        GetElement(start).click();;
//        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println(GetElement(loading).getText());
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loading));
        System.out.println(GetElement(Loader_delay_txt).getText());
        wait.until(ExpectedConditions.visibilityOfElementLocated(Loader_delay_txt));



    }

    @Test
    public void WaiTestWithSoftAssertion() throws InterruptedException {
        SoftAssert softassert = new SoftAssert();
        GetElement(element1).click();;
        //Thread.sleep(4000);
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(result1, "I am here!"));
        //System.out.println(test_1.getText());
        Assert.assertEquals(GetElement(result1).getText(), "I am here!");

        GetElement(start).click();;
//        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        softassert.assertEquals(GetElement(loading).getText(), "Loading...");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loading));
        //System.out.println(GetElement(Loader_delay_txt).getText());
        wait.until(ExpectedConditions.visibilityOfElementLocated(Loader_delay_txt));
        softassert.assertEquals(GetElement(Loader_delay_txt).getText(), "I appeared after 5 sec loading");
        softassert.assertAll();

    }
}
