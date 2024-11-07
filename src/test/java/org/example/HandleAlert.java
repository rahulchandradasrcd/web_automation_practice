package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleAlert extends BrowserSetup{
    @BeforeMethod
    public void Alert() throws InterruptedException {
        browser.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
        browser.manage().window().maximize();
        Thread.sleep(2000);
    }
    //Locator
    By jasAlert = By.xpath("//input[@id='alertexamples']");
    By Confirm = By.xpath("//input[@id='confirmexample']");
    By prompt = By.xpath("//input[@id='promptexample']");

    //result
    By result1 = By.xpath("//p[@id='alertexplanation']");
    By result2 = By.xpath("//p[@id='confirmexplanation']");
    By result3 = By.xpath("//p[@id='promptexplanation']");


    @Test
    public void AlertHandle() throws InterruptedException {
        GetElement(jasAlert).click();
        Thread.sleep(2000);
        Alert alert = browser.switchTo().alert();
        String massage = alert.getText();
        System.out.println(massage);
        alert.accept();
        String result = GetElement(result1).getText();
        //System.out.println(result);
        Assert.assertEquals(result, "You triggered and handled the alert dialog");
        Thread.sleep(2000);


        GetElement(Confirm).click();
        Thread.sleep(2000);
        alert = browser.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();
        Thread.sleep(2000);
        Assert.assertEquals(GetElement(result2).getText(), "You clicked Cancel, confirm returned false.");
        Thread.sleep(2000);


        GetElement(Confirm).click();
        Thread.sleep(2000);
        alert = browser.switchTo().alert();
        alert.accept();
        Thread.sleep(2000);
        Assert.assertEquals(GetElement(result2).getText(), "You clicked OK, confirm returned true.");
        Thread.sleep(2000);


        GetElement(prompt).click();
        Thread.sleep(2000);
        alert = browser.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("Rahul Chandra Das");
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(2000);
        Assert.assertEquals(GetElement(result3).getText(), "You clicked OK. 'prompt' returned Rahul Chandra Das");
        Thread.sleep(2000);


        GetElement(prompt).click();
        Thread.sleep(2000);
        alert = browser.switchTo().alert();
        alert.dismiss();
        Thread.sleep(2000);
        Assert.assertEquals(GetElement(result3).getText(), "You clicked Cancel. 'prompt' returned null");
        Thread.sleep(2000);
    }
}
