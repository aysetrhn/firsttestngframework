package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownload extends TestBase {
//    Create a class:FileDownload
//    Create two test method: isExist() and downloadTest()
//    In the downloadTest() method, do the following test:
//    Go to https://the-internet.herokuapp.com/download
//    Download upload.jpg file
//    Then verify if the file downloaded successfully.

    //Selenium cannot test windows applications
    //we need to use JAVA concept to verify if a file exist
        @Test
        public void isExist(){
            String currentFolder = System.getProperty("user.dir");   //gives me the path of the current folder
            System.out.println("Current Folder => "+currentFolder);

            String userFolder = System.getProperty("user.home");  //gives me the path of the user folder
            System.out.println("User Folder => "+userFolder);
            //                  /Users/techproed
            String pathOfFile = userFolder + "/Downloads/logo9.png";
            //String pathOfFile = "C:\\Users\\Dell E7250\\Downloads\\logo9.png";

            //Now that I have the path of the file, I can verify if the file exist or not, using JAVA
            boolean isFileExists =  Files.exists(Paths.get(pathOfFile));
            Assert.assertTrue(isFileExists);  //If file exist, this will be true. If file doesn't exist this will fail
        }
    @Test
    public void downloadTest() throws InterruptedException {
        //Im going to the link
        driver.get("https://the-internet.herokuapp.com/download");
        //Finding the element that I want to download
        WebElement file=driver.findElement(By.linkText("upload.jpg"));
        //Clicking on the file
        file.click();

        //We need to put wait for downloading the file
        Thread.sleep(3000);   //this is not recommended to use. Because, it is not dynamic.This is hard wait
                                    //What hard wait means is;It will wait 5 seconds no matter what.
                                    //for example; if an element found in 2 seconds, you still wait 3 more seconds.
        //getting the user folder
        String userFolder=System.getProperty("user.home");
        //finding the path of the downloaded file
        String pathOfFile=userFolder+"/Downloads/upload.jpg";
        //String pathOfFile  = "C:\\Users\\Dell E7250\\Downloads\\upload.jpg";//This can also be used
        //Checking if the file path exist or not
        boolean isDownloaded=Files.exists(Paths.get(pathOfFile));
        //Asserting if the test case is true or false
        Assert.assertTrue(isDownloaded);
    }

}
