package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InteractWithElement extends BrowserSetup{

    @BeforeMethod
    public void GetTestSite(){
        browser.get("https://rahulshettyacademy.com/AutomationPractice/");
        browser.manage().window().maximize();
    }

    @Test(priority = 0)
    public void RadioTestElement() throws InterruptedException {
        WebElement radio_button1 = GetElement(By.xpath("//input[@value='radio1']"));
        radio_button1.click();
        Thread.sleep(3000);
        WebElement radio_button2 = GetElement(By.xpath("//input[@value='radio2']"));
        radio_button2.click();
        //System.out.println("radio button1 select state " + radio_button1.isSelected());
        Assert.assertFalse(radio_button1.isSelected());
        //System.out.println("radio button1 is enabled " + radio_button1.isEnabled());
        Assert.assertTrue(radio_button1.isEnabled());
        //System.out.println("radio button2 select state " + radio_button2.isSelected());
        Assert.assertTrue(radio_button2.isSelected());
        //System.out.println("radio2 button2 is enabled " + radio_button2.isEnabled());
        Assert.assertTrue(radio_button1.isEnabled());
        Thread.sleep(3000);
    }

    @Test(priority = 1)
    public void HideShowElement() throws InterruptedException {
       WebElement ShowTestArea1 = GetElement(By.xpath("//input[@id='displayed-text']"));
       //System.out.println("TextArea displayed status " + ShowTestArea1.isDisplayed());
       Assert.assertTrue(ShowTestArea1.isDisplayed());
       Thread.sleep(2000);

       GetElement(By.xpath("//input[@id='hide-textbox']")).click();
       WebElement ShowTestArea2 = GetElement(By.xpath("//input[@id='displayed-text']"));
       //System.out.println("TextArea displayed status " + ShowTestArea2.isDisplayed());
       Assert.assertFalse(ShowTestArea2.isDisplayed());
       Thread.sleep(2000);

       GetElement(By.xpath("//input[@id='show-textbox']")).click();
       WebElement ShowTestArea3 = GetElement(By.xpath("//input[@id='displayed-text']"));
       //System.out.println("TextArea displayed status " + ShowTestArea3.isDisplayed());
       Assert.assertTrue(ShowTestArea3.isDisplayed());
       Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void TextReadTest() throws InterruptedException {
        WebElement Text1 = GetElement(By.xpath("//h1[normalize-space()='Practice Page']"));
        Text1.getText();
        //System.out.println("Text1 name is " + Text1.getText());
        Assert.assertEquals(Text1.getText(), "Practice Page");

        WebElement Text2 = GetElement(By.xpath("//legend[normalize-space()='Radio Button Example']"));
        Text2.getText();
        //System.out.println("Text2 name is " + Text2.getText());
        Assert.assertEquals(Text2.getText(), "Radio Button Example");

        WebElement Text3 = GetElement(By.xpath("//legend[normalize-space()='Suggession Class Example']"));
        Text3.getText();
        //System.out.println("Text3 name is " + Text3.getText());
        Assert.assertEquals(Text3.getText(),"Suggession Class Example");
    }

    @Test(priority = 3)
    public void WriteTextTest() throws InterruptedException {
        WebElement write_test1 = GetElement(By.xpath("//input[@id='name']"));
        write_test1.sendKeys("Rahul Chandra Das");
        Assert.assertEquals(write_test1.getAttribute("value"), "Rahul Chandra Das");
        Thread.sleep(2000);
        write_test1.clear();
        Assert.assertEquals(write_test1.getAttribute("value"), "");
        Thread.sleep(2000);
        // This code for check attribute value what is written Like "enter your name" this written or not (Start)
        String AttributeName1 = write_test1.getAttribute("placeholder");
        Assert.assertEquals(AttributeName1, "Enter Your Name");
        Thread.sleep(2000);
        // This code for check attribute value what is written Like "enter your name" this written or not (End)
        WebElement write_test2 = GetElement(By.xpath("//input[@id='autocomplete']"));
        write_test2.sendKeys("Bangladesh");
        Assert.assertEquals(write_test2.getAttribute("value"), "Bangladesh");
        Thread.sleep(2000);
        write_test2.clear();
        Assert.assertEquals(write_test2.getAttribute("value"), "");
        Thread.sleep(2000);
        // This code for check attribute value what is written Like "enter your name" this written or not (Start)
        String AttributeName2 = write_test2.getAttribute("placeholder");
        Assert.assertEquals(AttributeName2, "Type to Select Countries");
        // This code for check attribute value what is written Like "enter your name" this written or not (End)
        String css_value = write_test1.getCssValue("background-color");
        //System.out.println(css_value);
        Assert.assertEquals(css_value, "rgba(245, 245, 245, 1)");
        WebElement check_box = GetElement(By.xpath("//input[@id='checkBoxOption1']"));
        check_box.click();
        Thread.sleep(2000);
        //System.out.println(check_box.isSelected());
        Assert.assertTrue(check_box.isSelected());
        WebElement Check_box2 = GetElement(By.xpath("//label[normalize-space()='Option1']"));
        //System.out.println(Check_box2.getText());
        Assert.assertEquals(Check_box2.getText(), "Option1");
        //System.out.println(Check_box2.isDisplayed());
        Assert.assertTrue(Check_box2.isDisplayed());
    }
}
