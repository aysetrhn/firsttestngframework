package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FaceLogin extends TestBase {
        //    Create a test method: logInTest() and test the following user story
        //    When user enter invalid credentials, we should see sign up page
        //    https://www.facebook.com/
        //    Username: fakeusername
        //    Passwork: fakepassword
        //===========================================
    @Test
    public void login(){
        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys("fakeusername");
        driver.findElement(By.id("pass")).sendKeys("fakepassword");
        driver.findElement(By.id("u_0_b")).click();
        WebElement signUp = driver.findElement(By.partialLinkText("Forgot Password?"));
        Assert.assertTrue(signUp.isDisplayed());
    }
}
