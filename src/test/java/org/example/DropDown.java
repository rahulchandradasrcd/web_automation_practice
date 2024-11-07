package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDown extends BrowserSetup{

    @BeforeMethod
    public void GetBrowser() throws InterruptedException {
        browser.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
        browser.manage().window().maximize();
        Thread.sleep(1000);
    }

    @Test
    public void HandleDropDown() throws InterruptedException {
        WebElement drop_down = GetElement(By.xpath("//select[@id='dropdown-class-example']"));
        drop_down.click();
        Thread.sleep(2000);
        Select select = new Select(drop_down);
        select.selectByValue("option1");
        Thread.sleep(2000);
        select.selectByVisibleText("Select");
        Thread.sleep(2000);
        select.selectByIndex(2);
        Thread.sleep(2000);
        select.selectByVisibleText("Option3");
        Thread.sleep(2000);
        List<WebElement> options = select.getOptions();
        for (WebElement option: options){
            System.out.println(option.getText());
        }
    }
}
