package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocatorBasic extends BrowserSetup{
    @Test(priority = 2)
    public void TestElement0() throws InterruptedException {
        WebElement Search_Bar = browser.findElement(By.cssSelector("input[placeholder='Search for products (e.g. eggs, milk, potato)'][name='mainSearch']"));
        Search_Bar.sendKeys("Egg");
        Thread.sleep(3000);
    }
    @Test(priority = 0)
    public void TestElement1() throws InterruptedException {
        WebElement Pharmacy_Button = browser.findElement(By.xpath("//h5[normalize-space()='Pharmacy']"));
        Pharmacy_Button.click();

        Thread.sleep(3000);
    }

    @Test(priority = 1)
    public void TestElement2() throws InterruptedException {
        WebElement Grocery_Button = browser.findElement(By.xpath("//*[name()='g' and contains(@data-name,'Group 4241')]//*[name()='g' and contains(@transform,'translate(')]//*[name()='path' and contains(@fill,'url(#linea')]"));
        Grocery_Button.click();
        Thread.sleep(3000);
    }

    @Test(priority = 3)
    public void TestElement3() throws InterruptedException {
        WebElement search_button = browser.findElement(By.xpath("//img[@class='egg chaldal_logo']"));
        search_button.click();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void TestElement4() throws InterruptedException {
        WebElement health_wellness = browser.findElement(By.xpath("//a[contains(text(),'Health & Wellness')]"));
        health_wellness.click();
        Thread.sleep(3000);
        WebElement item = browser.findElement(By.xpath("//img[@alt='Mouthwashes, Inhaler & Balm']"));
        item.click();
        Thread.sleep(2000);
        browser.findElement(By.xpath("//div[@class='productPane']//div[1]//div[1]//section[1]//p[1]")).click();
        Thread.sleep(2000);
        browser.findElement(By.xpath("//button[normalize-space()='+']")).click();
        Thread.sleep(2000);
        browser.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/section[1]/div[1]/p[1]/span[1]")).click();
        Thread.sleep(2000);
        browser.findElement(By.xpath("//div[@title='Remove from bag']//*[name()='svg']//*[name()='rect' and contains(@x,'18.575')]")).click();
        Thread.sleep(2000);
        browser.findElement(By.xpath("//button[@class='closeCartButtonTop']")).click();
        Thread.sleep(2000);
        browser.findElement(By.xpath("//img[@class='egg chaldal_logo']")).click();
        Thread.sleep(2000);
    }

}
