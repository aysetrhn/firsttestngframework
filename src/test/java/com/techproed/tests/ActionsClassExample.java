package com.techproed.tests;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import javax.print.DocFlavor;
public class ActionsClassExample extends TestBase {
    @Test
    public void contextClickMethod(){
        //Given user is on the https://the-internet.herokuapp.com/context_menu
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //When use Right clicks on the box
        //1. Identify the webelement
        WebElement rectangle=driver.findElement(By.id("hot-spot"));
        //2.Create Actions Object
        //3.Now I have actions object, I can perform mouse and keyboard actions
        //actions.contextClick().perform();//This is not going to click on the specific element
        actions.contextClick(rectangle).perform();
        //Then verify the alert message is “You selected a context menu”
        String actualText=driver.switchTo().alert().getText();
        String expectedText="You selected a context menu";
        Assert.assertEquals(actualText,expectedText);
        //Then accept the alert
        driver.switchTo().alert().accept();
        actions.contextClick(rectangle).perform();
        //Now Right Click On the Element selenium==>HOMEWORK
    }
    @Test
    public void hoverOver(){
        //Given user is on the https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        //When use click on “Your Account” link
        WebElement signInBox = driver.findElement(By.xpath("//span[text()='Hello, Sign in']"));
        actions.moveToElement(signInBox).perform();
        WebElement yourAccount=driver.findElement(By.linkText("Your Account"));
        yourAccount.click();
        //Then verify the page title contains “Your Account”
        String actualTitle=driver.getTitle();
        String expectedTitle="Your Account";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
    @Test
    public void imageTest(){
        driver.get("https://www.amazon.com/");
        WebElement tryPrime=driver.findElement(By.id("nav-link-prime"));
        actions.moveToElement(tryPrime).perform();
        Assert.assertTrue(driver.findElement(By.id("nav-flyout-prime")).isDisplayed());
    }
    @Test
    public void keysUpDown(){
        driver.get("https://www.google.com/");
        WebElement searchBox=driver.findElement(By.name("q"));
        //searchBox.sendKeys("iphone x prices");
        //input => iphone x prices. output => IPHONE X PRICES
        //METHOD 1 TO SEND UPPER CASE:
        //searchBox.sendKeys(Keys.SHIFT+"iphone x prices");
        //METHOD 2 : ACTIONS CLASS
        //using Keys.Shift we are pressing shift key on the keyboard
//        actions.
//                moveToElement(searchBox).
//                click().
//                keyDown(Keys.SHIFT).
//                sendKeys("iphone x prices").
//                perform();
       //using the actions object
        actions.keyDown(searchBox, Keys.SHIFT).//pressing shift on the keyboard
                sendKeys("iphone x prices").//typing
                keyUp(searchBox,Keys.SHIFT).//releasing the shift button
                perform();//performing the action
        actions.doubleClick(searchBox).perform();//Go and double click on searchBox
    }
    @Test
    public void scrollUpDown() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        //Scrolling down the page
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        //We can use multiple page down or page up on a single class
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        //ARROW_DOWN also scrolls down the page, but it scroll less amount
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(5000);
        //Scroll Up A Page using sendKeys(Keys.PAGE_UP)
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(5000);
        //Scroll Up A Page using sendKeys(Keys.ARROW_UP)
        actions.sendKeys(Keys.ARROW_UP).perform();
    }
}
