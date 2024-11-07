package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BrowserManage extends BrowserSetup{
    @Test
    public void BrowserNavigate() throws InterruptedException {
        browser.get("https://www.youtube.com/");
        Thread.sleep(2000);
        browser.navigate().to("https://www.facebook.com/");
        Thread.sleep(2000);
        browser.navigate().back();
        Thread.sleep(2000);
        browser.navigate().forward();
        Thread.sleep(2000);
        browser.navigate().refresh();
        Thread.sleep(2000);
        browser.manage().window().minimize();
        Thread.sleep(2000);
        browser.manage().window().maximize();
        Thread.sleep(2000);
        browser.manage().window().fullscreen();
        Thread.sleep(2000);
        browser.switchTo().newWindow(WindowType.TAB);
        browser.navigate().to("https://www.google.com/maps");
        Thread.sleep(2000);
        browser.switchTo().newWindow(WindowType.WINDOW);
        browser.get("https://www.prothomalo.com/");
        browser.close();
        Thread.sleep(2000);
    }

    @Test
    public void WindowHandle() throws InterruptedException {
        browser.get("https://rahulshettyacademy.com/AutomationPractice/");
        browser.manage().window().maximize();
        GetElement(By.xpath("//button[@id='openwindow']")).click();
        System.out.println(browser.getTitle());
        System.out.println(browser.getCurrentUrl());
        Thread.sleep(2000);

        //String handles = browser.getWindowHandle();
        //System.out.println(handles);

        List<String> handles2 = new ArrayList<>(browser.getWindowHandles());
        for (String handle : handles2){
            System.out.println(handle);
            if (browser.getTitle().equals("QAClick Academy - A Testing Academy to Learn, Earn and Shine")){
                break;
            }
        }

        browser.switchTo().window(handles2.get(1));
        String TextName =  GetElement(By.xpath("//div[@class='cont']//span[contains(text(),'info@qaclickacademy.com')]")).getText();
        Assert.assertEquals(TextName,"info@qaclickacademy.com");
        System.out.println(browser.getTitle());
        System.out.println(browser.getCurrentUrl());
        Thread.sleep(2000);
        browser.switchTo().window(handles2.get(0));
        System.out.println(browser.getTitle());
        System.out.println(browser.getCurrentUrl());
        Thread.sleep(2000);


    }
}
