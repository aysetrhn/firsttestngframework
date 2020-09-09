package com.techproed.soh;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Soh_Day_3 extends TestBase {
    // go to "https://the-internet.herokuapp.com/hovers"
    // verify "name: user2" text under second picture
    @Test
    public void hoverTest(){
        driver.get("https://the-internet.herokuapp.com/hovers");

        WebElement secondImage =driver.findElement(By.xpath("(//img)[3]"));
        actions.moveToElement(secondImage).perform();

        WebElement text = driver.findElement(By.xpath("(//h5)[2]"));
        Assert.assertEquals(text.getText(), "name: user2");

    }
    // go to "https://the-internet.herokuapp.com/dynamic_loading/1"
    // verify "Hello World!" text that appears when the start button is pressed
    @Test
    public void hiddenElementTest(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement startButton = driver.findElement(By.xpath("//button"));
        startButton.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement text=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        //WebElement text=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("finish"))));

        Assert.assertEquals(text.getText(), "Hello World!");
    }
    // go to "https://www.glbtrader.com/contact.html"
    // click "View Larger Map" link
    // verify that new tab's title is 16192 Coastal Hwy - Google Maps
    // hint: titleContains()
    @Test
    public void pageTitleTest() {
        // go to URL
        driver.get("https://www.glbtrader.com/contact.html");
        // switch to first frame
        driver.switchTo().frame(0);
        //wait for "View Larger Map" link to be visible and then click on it
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement viewLargerMap = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("View larger map")));
        viewLargerMap.click();
        // switch to new tab
        for (String eachHandle : driver.getWindowHandles()){
            driver.switchTo().window(eachHandle);
        }
//        Set<String> tabs = driver.getWindowHandles();
//        driver.switchTo().window(tabs.toArray()[1].toString());
//        Assert.assertEquals(driver.getTitle(), "16192 Coastal Hwy - Google Maps"); // won't work
        // verify page title
        boolean result = wait.until(ExpectedConditions.titleContains("16192 Coastal Hwy - Google Maps"));
        Assert.assertTrue(result);
    }
}
