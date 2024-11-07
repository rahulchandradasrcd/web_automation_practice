package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BrowserSetup {

    WebDriver browser;
    @BeforeSuite
    public WebDriver OpenBrowser(){
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return browser;
    }

    @AfterSuite
    public void CloseBrowser(){
        browser.quit();
    }
    public WebElement GetElement(By Locator){
        return browser.findElement(Locator);
    }

    // This Code is Used for Chaldal Website Testing
    @BeforeClass
    public void LoadBrowser(){
        browser.get("https://chaldal.com/");
    }
}
