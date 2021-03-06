package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandlingAlerts {
    /*
    Create 3 methods
    1. acceptAlert
    2. dismissAlert
    3. sendKeysAlert
    Create a @BeforeMethod
    Go to https://the-internet.herokuapp.com/javascript_alerts
     */
    WebDriver driver;   //I created this driver on class level, not inside the @BeforeMethod.
    @BeforeMethod       //Because I can use the same driver on other methods.
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void acceptAlert(){
        //getting the element of the button
        WebElement clickButton=driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        //clicking on the button
        clickButton.click();
        //switching to the alert then accepting the alert(Clicking Ok)
       System.out.println( "Getting the text on the Alert "+driver.switchTo().alert().getText() );
        driver.switchTo().alert().accept();
        //I am checking if I clicked Ok by verifying the result message
        WebElement resultMessage=driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(resultMessage.isDisplayed());
    }
    @Test
    public void dismissAlert(){
        //Click on the 2nd button and click cancel and verify that you clicked cancel
        //finding the second element  and click on it
        WebElement clickButton=driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        clickButton.click();
        //clicking cancel
        driver.switchTo().alert().dismiss();
        //verifying the message
        String actualResultMessage=driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResultMessage="You clicked: Cancel";
        Assert.assertEquals(expectedResultMessage,actualResultMessage);
    }
    @Test
    public void sendKeysAlert(){
        //Click on the 3rd button, send your name, then verify it it is sent or not
        //Creating the webelement of teh button and clicking on it
        WebElement clickButton = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        clickButton.click();
        //switching the alert
        driver.switchTo().alert().sendKeys("AYSE TURHAN");
        //we are accepting the alert
        driver.switchTo().alert().accept();
        //We are asserting if my text is sent or not
        String actualResultMessage=driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResultMessage="You entered: AYSE TURHAN";
        Assert.assertEquals(expectedResultMessage,actualResultMessage);
    }
}
