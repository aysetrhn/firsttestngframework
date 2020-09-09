package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleExample extends TestBase {
    /*
        Given user is on the https://the-internet.herokuapp.com/windows
        Then user verifies the text : “Opening a new window”
        Then user verifies the title of the page is “The Internet”
        When user clicks on the Click Here button
        Then user verifies the new window title is “New Window”
        Then user verifies the text:  “New Window”
        When user goes back to the previous window and then verifies the title : “The Internet”
     */
    @Test
    public void newWindowTest(){
        //Given user is on the https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");
        String parentWindowHandle = driver.getWindowHandle();  //PARENT WINDOW HANDLE
        System.out.println("PARENT WINDOW HANDLE: "+parentWindowHandle);
        // Then user verifies the text : “Opening a new window”
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(actualText,expectedText);
        //Then user verifies the title of the page is “The Internet”
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(actualTitle,expectedTitle);
        //user clicks on the Click Here button
        driver.findElement(By.linkText("Click Here")).click();  //Now I have 2 windows open
        Set<String> allWindowHandles = driver.getWindowHandles();  //we have parent and child window

        //switching to the child window
        for(String handle : allWindowHandles){
            if(!handle.equals(parentWindowHandle)){
                driver.switchTo().window(handle);
                System.out.println("CHILD WINDOW HANDLE: "+handle);
            }
        }
        //Then user verifies the new window title is “New Window”
        String newWindowTitle = driver.getTitle();
        Assert.assertEquals(newWindowTitle,"New Window");

        //Then user verifies the text:  “New Window”
        String actualNewWindowText = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(actualNewWindowText,"New Window");

        //When user goes back to the previous window and then verifies the title : “The Internet”
        //how to go back
        driver.switchTo().window(parentWindowHandle);
        Assert.assertEquals(driver.getTitle(),"The Internet");

    }
}
