package com.techproed.Review;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Day4 extends TestBase {
    /*Step1: Go to "https://www.seleniumeasy.com/test/bootstrap-dual-list-box-demo.html"
      Step2: choose all 5 elements on the left
      Step3: send all 5 elements to the right side
      Step4: Just send "Cras justo odio" to the left and leave the rest on the right side
      Step5: Close the webpage
       */
    @Test
    public void dualListTest() {
        driver.get("https://www.seleniumeasy.com/test/bootstrap-dual-list-box-demo.html");

//          List<WebElement> list = driver.findElements(By.xpath("(//li[@class='list-group-item'])"));
//          for (int i = 0; i < 5; i++) {
//              list.get(i).click();
//          }

            driver.get("https://www.seleniumeasy.com/test/bootstrap-dual-list-box-demo.html");
            WebElement e1= driver.findElement(By.xpath("//li[text()='bootstrap-duallist ']"));
            e1.click();
            WebElement e2 =driver.findElement(By.xpath("(//li[text()='Dapibus ac facilisis in'])[1]"));
            e2.click();
            WebElement e3= driver.findElement(By.xpath("(//li[text()='Morbi leo risus'])[1]"));
            e3.click();
            WebElement e4= driver.findElement(By.xpath("(//li[text()='Porta ac consectetur ac'])[1]"));
            e4.click();
            WebElement e5 = driver.findElement(By.xpath("(//li[text()='Vestibulum at eros'])[1]"));
            e5.click();
            WebElement rightClick= driver.findElement(By.xpath("//*[@class='glyphicon glyphicon-chevron-right']"));
            rightClick.click();
            WebElement e12= driver.findElement(By.xpath("//li[text()='bootstrap-duallist ']"));
            e1.click();
            WebElement e22 =driver.findElement(By.xpath("(//li[text()='Dapibus ac facilisis in'])[2]"));
            e22.click();
            WebElement e32= driver.findElement(By.xpath("(//li[text()='Morbi leo risus'])[2]"));
            e32.click();
            WebElement e42= driver.findElement(By.xpath("(//li[text()='Porta ac consectetur ac'])[2]"));
            e42.click();
            WebElement e52 = driver.findElement(By.xpath("(//li[text()='Vestibulum at eros'])[2]"));
            e52.click();
            WebElement leftClick = driver.findElement(By.xpath("//*[@class='glyphicon glyphicon-chevron-left']"));
            leftClick.click();



    }
//=========================
    /*Step1: Go to "https://www.seleniumeasy.com/test/jquery-dual-list-box-demo.html"
     Step2: Choose Alice,Lara,Isis,Luiza from the list
     Step3: Click Add button
     Step4: Select Luiza again
     Step5: Click Remove
     Step6: Close the webpage
          */

        @Test
        public void remove() {
            driver.get("https://www.seleniumeasy.com/test/jquery-dual-list-box-demo.html");
            driver.findElement(By.xpath("//option[3]")).click();
            driver.findElement(By.xpath("(//button)[2]")).click();

            driver.findElement(By.xpath("//option[14]")).click();
            driver.findElement(By.xpath("(//button)[2]")).click();

            driver.findElement(By.xpath("//option[1]")).click();
            driver.findElement(By.xpath("(//button)[2]")).click();

            driver.findElement(By.xpath("//option[7]")).click();
            driver.findElement(By.xpath("(//button)[2]")).click();

            driver.findElement(By.xpath("//option[7]")).click();
            driver.findElement(By.xpath("(//button)[3]")).click();
            //driver.close();
        }




}







