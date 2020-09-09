package com.techproed.Review;

import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class Day2 extends TestBase {
    /*Step1: Go to "https://www.airbnb.co.in/"
  Step2: Click Signup Button
  Step3: Close the webpage
       */
    @Test
    public void locateTest3() {
        driver.get("https://www.airbnb.co.in/");
        //WebElement signup = driver.findElement(By.linkText("Sign up"));
        // signup.click();
        WebElement signup = driver.findElement(By.partialLinkText("Sign"));
        signup.click();
        driver.quit();
    }
    /*Step1: Go to "https://www.airbnb.co.in/"
  Step2: Find out how many WebElements there are with tagName "div"
  Step3: Close the webpage
  */
    @Test
    public void locateTest4() {
        driver.get("https://www.airbnb.co.in/");
        List<WebElement> lst=driver.findElements(By.tagName("div"));
        System.out.println(lst.size());

    }
    /*    Step1: Go to "https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html"
      Step2: Enter Today's date in to select date input box
      Step3: Close the page
     */
    @Test
    public void selectDateTest1(){
        driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
        WebElement date = driver.findElement(By.xpath("//input[@placeholder='dd/mm/yyyy']"));
        date.click();

        WebElement today = driver.findElement(By.xpath(" (//th[@class='today'])[1]"));
        actions.moveToElement(today).click().perform();

    }
    /*    Step1: Go to "https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html"
      Step2: Enter April 29 as a start date in to select  start date input box
      Step3: Enter May 2 as an end date in to select  end date input box
      Step4: Close the page
     */
    @Test
    public void selectDateTest2(){
        driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
        WebElement start_date = driver.findElement(By.xpath("//input[@placeholder='Start date']"));
        start_date.click();
        WebElement start = driver.findElement(By.xpath("(//td[text()='29'])[2]"));
        actions.moveToElement(start).click().perform();
        WebElement end_date= driver.findElement(By.xpath("//input[@placeholder='End date']"));
        end_date.click();
        WebElement end = driver.findElement(By.xpath("//td[@class='new day' and text()='2']"));
        actions.moveToElement(end).click().perform();
    }
     /*Step1: Go to "https://demos.telerik.com/kendo-ui/dragdrop/index"
       Step2: Drag the small circle
       Step3: Drop to bigger circle
       Step4: Close the webpage
           */
     @Test
    public void dragAndDropTest(){
         driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
         WebElement source = driver.findElement(By.id("draggable"));
         WebElement target = driver.findElement(By.id("droptarget"));

         driver.findElement(By.xpath("//button[@title='Accept Cookies']")).click();

         Actions action = new Actions(driver);
         action.dragAndDrop(source, target).build().perform();
         //actions.moveToElement(source).clickAndHold().moveToElement(target).release().build().perform();
     }
     /*Step1: Go to "https://the-internet.herokuapp.com/hovers"
    Step2: Hover your mouse on all pictures
    Step3: Close the webpage
       */
     @Test
    public void hoverOverTest(){
         driver.get("https://the-internet.herokuapp.com/hovers");
         WebElement image1= driver.findElement(By.xpath("(//img)[2]"));
         actions.moveToElement(image1).perform();

         WebElement image2= driver.findElement(By.xpath("(//img)[3]"));
         actions.moveToElement(image2).perform();

         WebElement image3= driver.findElement(By.xpath("(//img)[4]"));
         actions.moveToElement(image3).perform();

     }
    /*Step1: Go to "https://the-internet.herokuapp.com/infinite_scroll"
 Step2: Scroll Down and Scroll Up
 Step3: Close the webpage
      */
     @Test
    public void scrollTest() throws InterruptedException {
         driver.get("https://the-internet.herokuapp.com/infinite_scroll");
         actions.sendKeys(Keys.PAGE_DOWN).perform();
         actions.sendKeys(Keys.PAGE_UP).perform();


//         JavascriptExecutor jse = (JavascriptExecutor) driver;
//         for(int i=0; i<10;i++){
//             Thread.sleep(500);
//             jse.executeScript("window.scrollBy(0,250)");
//         }
//         for(int i= 0; i<10;i++){
//             Thread.sleep(500);
//             jse.executeScript("window.scrollBy(0,-250)");
//         }

         driver.quit();









    }






}