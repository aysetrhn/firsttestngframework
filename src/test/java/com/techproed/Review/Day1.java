package com.techproed.Review;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Day1 extends TestBase {
    //Test Case 1:
//    Step1: Go to "https://www.airbnb.co.in/"
//    Step2: get the title and print it
//    Step3: get the current url of the page
//    Step4: get the Page Source (the codes of the page)
    @Test
    public void getTitleTest(){
        driver.get("https://www.airbnb.co.in/");
        String title=driver.getTitle();
        System.out.println("title: "+title);
        String current_url=driver.getCurrentUrl();
        System.out.println("current_url = " + current_url);
        String page_source=driver.getPageSource();
        System.out.println("page_source = " + page_source);
    }
    //Test case 2:
//    Step1: Go to "https://www.google.com"
//    Step2: Navigate to "https://www.airbnb.co.in/"
//    Step3: Navigate back to previous webpage
//    Step4: Navigate forward to second webpage
//    Step5: Refresh the page
//    Step6: Close the webpage
    @Test
    public void navigateTest(){
        driver.get("https://www.google.com");
        driver.navigate().to("https://www.airbnb.co.in/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        //driver.quit();
    }
    //Test Case 3:
//    Step1: Go to "http://ebay.com"
//    Step2: Enter "selenium" in to Search input box
//    Step3: Click on Search Button
//    Step4: Check how many results for Selenium and print it
//    Step5: Get current url
//    Step6: Get page source
//    Step7: Get the title
//    Step8: Close the webpage
    @Test
    public void locateTest01(){
        driver.get("http://ebay.com");

        WebElement searchbox=driver.findElement(By.id("gh-ac"));
        searchbox.sendKeys("selenium");

        WebElement searchButton = driver.findElement(By.id("gh-btn"));
        searchButton.click();

        System.out.println(driver.findElement(By.className("srp-controls__count-heading")).getText());
//        WebElement text = driver.findElement(By.className("srp-controls__count-heading"));
//        String printText = text.getText();
//        System.out.println(printText);

        String current_url= driver.getCurrentUrl();
        System.out.println("current_url = " + current_url);

        String page_Source = driver.getPageSource();
        System.out.println("pageSource = " + page_Source);

        String title = driver.getTitle();
        System.out.println("title = " + title);

    }


    /* Test Case 4:
       Step1: Go to "https://twitter.com/login"
       Step2: Enter your name in to username input box
       Step3: Enter password in to password input box
       Step4: Close the webpage
       */
    @Test
    public void logInTest(){
        driver.get("https://twitter.com/login");
        driver.findElement(By.name("session[username_or_email]")).sendKeys("ayse trhn");
        driver.findElement(By.name("session[password]")).sendKeys("123456agt");
       // driver.close();

//        WebElement username= driver.findElement(By.name("session[username_or_email]"));
//        username.sendKeys("Harun");
//        WebElement password = driver.findElement(By.name("session[password])"));
//        password.sendKeys("Harun123");

    }
}
