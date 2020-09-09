package com.techproed.soh;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Soh_Day_1 extends TestBase {
    // Verify that the first item listed on the homepage is iPhone 11 Pro by locating its header element
    // Hint: isDisplayed()
    @Test
    public void firstHeaderTest(){
        driver.get("https://www.apple.com/");
        WebElement header = driver.findElement(By.xpath("(//h2[@class='headline'])[1]"));
        Assert.assertTrue(header.isDisplayed());
    }


    // print all the elements with classname "headline" on the console
    // Hint 1: List
    // Hint 2: foreach
    @Test
    public void printAllHeadersTest(){
        driver.get("https://www.apple.com/");
        List<WebElement> allHeaders = driver.findElements(By.xpath("//*[@class='headline']"));
        for(WebElement eachHeader : allHeaders){
            System.out.println(eachHeader.getText());
        }
    }


    // verify that "Add to Bag" button is disabled at the following page:
    // https://www.apple.com/shop/product/MXQT2LL/A/magic-keyboard-for-ipad-pro-11%E2%80%91inch-2nd-generation-us-english
    // Hint: isEnabled()
    @Test
    public void addToBagTest(){
        driver.get("https://www.apple.com/shop/product/MXQT2LL/A/magic-keyboard-for-ipad-pro-11%E2%80%91inch-2nd-generation-us-english");
        driver.navigate().to("https://www.apple.com/shop/product/MXQT2LL/A/magic-keyboard-for-ipad-pro-11%E2%80%91inch-2nd-generation-us-english");
        WebElement addToCartButton = driver.findElement(By.name("add-to-cart"));
        Assert.assertFalse(addToCartButton.isEnabled());
    }


    // search for "ipad keyboard" in the homepage, go to "Accessories" tab, and verify that at least one item is displayed
    // Hint: implicitlyWait()
    @Test
    public void searchBoxTest(){
        driver.get("https://www.apple.com/");
        WebElement searchIcon = driver.findElement(By.id("ac-gn-link-search"));
        searchIcon.click();

        WebElement searchBox = driver.findElement(By.id("ac-gn-searchform-input"));
        searchBox.sendKeys("ipad keyboard" + Keys.ENTER);

        WebElement accessoriesLink = driver.findElement(By.id("accessories"));
        accessoriesLink.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement firstResult = driver.findElement(By.xpath("(//*[@class='as-producttile-tilelink'])[1]"));
        Assert.assertTrue(firstResult.isDisplayed());
    }


    // instructor's note: students must first check the price manually

    // go to "https://www.apple.com/shop/product/MXNK2LL/A/smart-keyboard-folio-for-ipad-pro-11%E2%80%91inch-2nd-generation-us-english"
    // page and select "12.9-inch iPad Pro" option from the size list
    // then click "Add to Bag"
    // verify that the total is $212.93
    @Test
    public void addToCartTest() throws InterruptedException {
        driver.get("https://www.apple.com/shop/product/MXNK2LL/A/smart-keyboard-folio-for-ipad-pro-11%E2%80%91inch-2nd-generation-us-english");

        WebElement sizeElement = driver.findElement(By.id("dimensionMerchModel"));
        Select sizeOptions = new Select(sizeElement);
        sizeOptions.selectByIndex(1);

//        Thread.sleep(1000);
        driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
        driver.findElement(By.name("add-to-cart")).click();

        String expectedResult = "Your bag total is $212.93.";
        String actualResult = driver.findElement(By.className("rs-bag-header")).getText();

        Assert.assertEquals(expectedResult, actualResult);
    }
}
