package com.techproed.smoketest;

import com.techproed.pages.AmazonLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AmazonLoginTest {

    AmazonLoginPage amazonLoginPage=new AmazonLoginPage();
    @Test
    public void AmazonRegistrationTest(){
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));

        amazonLoginPage.signIn.click();
        amazonLoginPage.createButton.click();
        amazonLoginPage.yourname.sendKeys("tom sawyer");
        amazonLoginPage.email.sendKeys("tomswyr@gmail.com");
        amazonLoginPage.password.sendKeys("12345ts");
        amazonLoginPage.repassword.sendKeys("12345ts");
        amazonLoginPage.createAccountButton.click();

    }
}
