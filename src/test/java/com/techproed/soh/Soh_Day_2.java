package com.techproed.soh;

import com.techproed.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class Soh_Day_2 extends TestBase {

    // go to fhctrip.com and verify the "FHCTRIP" text on the top-left corner
    @Test
    public void fhctripTextTest(){
        driver.get("http://www.fhctrip.com/");
        WebElement fhcTripLink = driver.findElement(By.className("navbar-brand"));
        //System.out.println(fhcTripLink.getText());
        Assert.assertEquals(fhcTripLink.getText(),"FHCTRIP");
    }

    // go to fhctrip.com and verify the "Welcome To Our Hotel" text
    @Test
    public void welcomeTest() throws InterruptedException {
        driver.get("http://www.fhctrip.com/");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(500);
        WebElement wellcomeText = driver.findElement(By.xpath("(//h2[@class='mb-4'])[1]"));
        Assert.assertEquals(wellcomeText.getText(),"Welcome To Our Hotel");

    }

    // go to fhctrip.com and verify the number of staff is "1,000"
    @Test
    public void staffNumberTest() throws InterruptedException {
        driver.get("http://www.fhctrip.com/");
        for(int i=0 ; i<6 ; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            Thread.sleep(500);
        }
        Thread.sleep(7000);
        WebElement staffNumber = driver.findElement(By.xpath("//strong[@data-number='1000']"));
        System.out.println(" Actual Number is : " +staffNumber.getText());
        Assert.assertEquals(staffNumber.getText(),"1,000");

    }


}
