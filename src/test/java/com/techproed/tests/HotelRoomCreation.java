package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelRoomCreation extends TestBase{

//    Create a class: HotelRoomCreation
//    Create a Method: RoomCreateTest()
//    When user goes to http://www.fhctrip.com/admin/HotelRoomAdmin
//    And fills out all of the required fields
//    Then click on save button
//    And Verify the text message on the pop up “HotelRoom was inserted successfully” Then Click Ok button
//    Then Click on Hotel Rooms
//    Then verify the LIST OF HOTELROOMS page is displayed
//    Then verify your hotel is being created(You can use id, code, or name to verify)

    @Test
    public void roomCreateTest() throws InterruptedException {
        driver.get("http://www.fhctrip.com/admin/HotelRoomAdmin");
        WebElement userNameBox = driver.findElement(By.cssSelector("#UserName"));
        userNameBox.sendKeys("manager2");
        WebElement passwordBox = driver.findElement(By.cssSelector("#Password"));
        passwordBox.sendKeys("Man1ager2!");
        WebElement logInButton = driver.findElement(By.xpath("//button[@type='submit']"));
        logInButton.click();

        WebElement addHotelRoomButton = driver.findElement(By.cssSelector(".hidden-480"));
        addHotelRoomButton.click();

        WebElement createHotelRoomText = driver.findElement(By.cssSelector(".caption"));
        Assert.assertTrue(createHotelRoomText.isDisplayed());

        WebElement IDHotel = driver.findElement(By.id("IDHotel"));
        Select select = new Select(IDHotel);
        select.selectByIndex(18);
        driver.findElement(By.id("Code")).sendKeys("Royal");
        driver.findElement(By.id("Name")).sendKeys("Maria");
        driver.findElement(By.xpath("//textarea[@dir='ltr']")).sendKeys("This room is only for Royal families");

        WebElement source = driver.findElement(By.xpath("//li[@data-id='700']"));
        WebElement target = driver.findElement(By.name("Price"));
        actions.dragAndDrop(source,target).perform();

        WebElement roomType = driver.findElement(By.id("IDGroupRoomType"));
        Select options = new Select(roomType);
        options.selectByIndex(6);
        driver.findElement(By.id("MaxAdultCount")).sendKeys("2");
        driver.findElement(By.id("MaxChildCount")).sendKeys("3");
        driver.findElement(By.id("btnSubmit")).click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        boolean isTrue = wait.until(ExpectedConditions.textToBe(By.cssSelector("div.bootbox-body"),"HotelRoom was inserted successfully"));
        Assert.assertTrue(isTrue);

        WebElement okButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        okButton.click();


        WebElement hotelRoomsLink=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@href='/admin/HotelRoomAdmin']"))));
        Thread.sleep(3000);
        actions.doubleClick(hotelRoomsLink).perform();

        WebElement listOfHotelRoomsText = driver.findElement(By.linkText("List Of Hotelrooms"));
        Assert.assertTrue(listOfHotelRoomsText.isDisplayed());

        WebElement IDHotelSelect = driver.findElement(By.id("lkpHotels"));
        Select selectHotel = new Select(IDHotelSelect);
        selectHotel.selectByIndex(18);
        driver.findElement(By.xpath("(//button)[6]")).click();

        Thread.sleep(3000);
        String myHotel = driver.findElement(By.xpath("(//td[@class='sorting_1'])[1]")).getText();
        Assert.assertTrue(myHotel.equals("AKROPOLIS"));

    }
}
