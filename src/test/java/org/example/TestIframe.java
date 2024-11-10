package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestIframe extends BrowserSetup{
    //Locator for IframeText
    By iframe_locator = By.xpath("//legend[normalize-space()='iFrame Example']");
    By iframe_support_email = By.xpath("//li[normalize-space()='contact@rahulshettyacademy.com']");
    By element1 = By.className("new-navbar-highlighter");


    @BeforeMethod
    public void GetTestSite() throws InterruptedException {
        browser.get("https://rahulshettyacademy.com/AutomationPractice/");
        browser.manage().window().maximize();
    }

    @Test
    public void IframeTestingWithScroll() throws InterruptedException {
        JavascriptExecutor scroll = (JavascriptExecutor) browser;
        scroll.executeScript("window.scrollTo(0,document.body.scrollHeight);");
        Thread.sleep(2000);
        scroll.executeScript("window.scrollTo(document.body.scrollHeight, 0);");
        Thread.sleep(2000);

        WebElement iframe = GetElement(iframe_locator);
        scroll.executeScript("arguments[0].scrollIntoView()", iframe);
        Thread.sleep(2000);

        browser.switchTo().frame("iframe-name");
        System.out.println(GetElement(iframe_support_email).getText());
        WebElement frame = GetElement(element1);
        frame.click();
        System.out.println(frame.getText());
        Thread.sleep(2000);

        browser.switchTo().defaultContent();
        browser.navigate().refresh();
        Thread.sleep(2000);

    }
}
