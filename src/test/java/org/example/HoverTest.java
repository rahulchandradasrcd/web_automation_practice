package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoverTest extends BrowserSetup{
    //Locator for HoverTest
    By MouseHover = By.xpath("//button[@id='mousehover']");
    By Top = By.xpath("//a[normalize-space()='Top']");
    By Reload = By.xpath("//a[normalize-space()='Reload']");

    //Locator for AutoCopyPaste
    By copy = By.xpath("//input[@id='autocomplete']");
    By paste = By.xpath("//input[@id='name']");

    @BeforeMethod
    public void GetTestSite() throws InterruptedException {
        browser.get("https://rahulshettyacademy.com/AutomationPractice/");
        browser.manage().window().maximize();
        Thread.sleep(2000);
    }

    @Test
    public void MouseHover() throws InterruptedException {
        Actions action = new Actions(browser);
        action.scrollByAmount(0, 500).build().perform();
        Thread.sleep(2000);
        action.moveToElement(GetElement(MouseHover)).build().perform();
        Thread.sleep(2000);
        //action.clickAndHold(GetElement(MouseHover)).build().perform();
        //Thread.sleep(2000);
        action.click(GetElement(Top)).build().perform();
        Thread.sleep(2000);
        //GetElement(Top).click();
        //Thread.sleep(2000);
        action.scrollByAmount(0, 500).build().perform();
        Thread.sleep(2000);
        action.moveToElement(GetElement(MouseHover)).build().perform();
        Thread.sleep(2000);
        action.click(GetElement(Reload)).build().perform();
        Thread.sleep(2000);

        action.sendKeys(GetElement(copy), "Bangladesh").build().perform();
        Thread.sleep(2000);
        action.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("x").build().perform();
        Thread.sleep(2000);
        action.click(GetElement(paste)).keyDown(Keys.CONTROL).sendKeys("v").build().perform();
        Thread.sleep(2000);
        action.click(GetElement(paste)).keyDown(Keys.CONTROL).sendKeys("a").sendKeys(Keys.DELETE).build().perform();
        Thread.sleep(2000);

    }
}
