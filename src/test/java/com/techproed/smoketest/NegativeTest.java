package com.techproed.smoketest;
import com.techproed.pages.FhcLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
public class NegativeTest extends TestBase {


    @Test
    public void invalidPass(){
                //Creating explicit wait object
                //WebDriverWait wait=new WebDriverWait(driver,10);
        driver.get(ConfigReader.getProperty("fhc_login_url"));
        FhcLoginPage fhcLoginPage = new FhcLoginPage(driver);
                 //correct username but incorrect pass
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("valid_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("invalid_password"));
        fhcLoginPage.login.click();
                //Assertion
               //I can find the error message by putting explicit wait.
               //WebElement message=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='divMessageResult']")));
        Assert.assertTrue(fhcLoginPage.error_message.getText().contains(ConfigReader.getProperty("login_error_message")));
                //Assert.assertTrue(message.getText().contains("Wrong password"));
    }
    @Test
    public void invalidID(){
        driver.get(ConfigReader.getProperty("fhc_login_url"));
        FhcLoginPage fhcLoginPage = new FhcLoginPage(driver);
                   // Correct pass but inccorrect username
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("invalid_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("valid_password"));
        fhcLoginPage.login.click();
                  //Assertion
        Assert.assertTrue(fhcLoginPage.error_message.getText().contains(ConfigReader.getProperty("login_error_message2")));
    }
    @Test
    public void invalidIDAndPass(){
        driver.get("http://www.fhctrip.com/Account/Logon");
        FhcLoginPage fhcLoginPage = new FhcLoginPage(driver);
            //Both incorrect username password
        fhcLoginPage.username.sendKeys("minagr2");
        fhcLoginPage.password.sendKeys("Man2ager2");
        fhcLoginPage.login.click();
             //Assertion
        Assert.assertTrue(fhcLoginPage.error_message.getText().contains("Try again please"));
    }
}
