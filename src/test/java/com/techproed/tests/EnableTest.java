package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EnableTest extends TestBase {
    //when user goes to "https://the-internet.herokuapp.com/dynamic_controls"
    //and clicks on Enable button
    //then verify that textbox is enable-I can type in
    //and verify the text "It's enabled!"

    @Test
    public void isEnabled() {
        //I am creating WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver,10);
        //going to the page
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //locating enable button
        WebElement enableButton = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        //clicking on enabled message
        enableButton.click();
        //waiting for the enabled message because it takes time to load.Implicit didn't work
        //Explicit wait will wait for that enabled message up to 10 seconds. If it locates in less than 10 sec, then it go to the next line
        //If that element is not found in 10 seconds, then this line will fail
        WebElement enabledMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        //verifying the enabled text message
        Assert.assertEquals(enabledMessage.getText(), "It's enabled!");
        //locating text box element
        WebElement textBox =driver.findElement(By.xpath("//input[@type='text']"));

        // to test is  an element Enable or Not, we can use isEnabled() method
                //isDisplayed => if an element displayed or not
                //isSelected => radio button or checkbox
                //isEnabled => to check if an element enabled or not

        //we are checking the condition of the textbox. if it is enabled or not
        boolean isEnabled = textBox.isEnabled();
        //Asserting if the above statement true or false
        Assert.assertTrue(isEnabled);



    }
}