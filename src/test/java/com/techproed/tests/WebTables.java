package com.techproed.tests;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;
//        Create a class: WebTables
public class WebTables extends TestBase {
    //        Create a method: login() and log in : http://www.fhctrip.com/admin/HotelRoomAdmin
    public void login(){
        driver.get("http://www.fhctrip.com/admin/HotelRoomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");;
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    //        Finding size of the entire table body
    @Test
    public void entireTable() throws InterruptedException {
        login();
        Thread.sleep(3000);
        WebElement tBody=driver.findElement(By.xpath("//tbody"));
        System.out.println(tBody.getText());
        List<WebElement> table=driver.findElements(By.xpath("//tbody//td"));
        System.out.println("The size of the table body is ===>> "+table.size());//Size of the table
        System.out.println(driver.findElements(By.tagName("//tbody//td")).size());//We can use tag name to find the data
        List<WebElement> allHeader=driver.findElements(By.tagName("th"));
        for (WebElement header:allHeader){
            System.out.println(header.getText());
        }
    }
    //        Find the total number of rows and cells in the table body
    @Test
    public void printRows(){
        login();
        System.out.println("There are "+driver.findElements(By.xpath("//tbody//tr")).size()+" rows in the table body");
        //print the rows
        List<WebElement> allRows=driver.findElements(By.xpath("//tbody//tr"));
        for (WebElement row:allRows){
            System.out.println(row.getText());
        }
        //        Print the elements of 4th row
        List<WebElement> elements4th=driver.findElements(By.xpath("//tr[4]//td"));
        for (WebElement element :elements4th){
            System.out.println(element.getText());
        }
    }
    //        Find the total number of cells in the table body
    @Test
    public void printCells(){
        login();
        System.out.println("There are "+driver.findElements(By.xpath("//tbody//td")).size()+" cells in the table body");
        List<WebElement> allCells = driver.findElements(By.xpath("//tbody//td"));
        for (WebElement cell:allCells){
            System.out.println(cell.getText());
        }
    }
    @Test
    public void printColumn(){
        login();
        System.out.println("There are "+driver.findElements(By.xpath("//tr[3]//td")).size()+" column in the table body");

//        List<WebElement> allCols=driver.findElements(By.xpath("//th"));
//        for (WebElement col:allCols){
//            System.out.println(col.getText());
//        }


        //        Print the elements of the 5th column
        List<WebElement> columns5th=driver.findElements(By.xpath("//tbody//td[5]"));
        for (WebElement element:columns5th){
            System.out.println(element.getText());
        }
    }
    //    1.Create a void method: printData(int row, int column);
    //    When you enter the row and column number,
    //    Then printData method should print the data on that cell.
    //     2.Print another TEST METHOD : printDataTest();
    //    And use this method to call and print printData() method
    //    Example printData(3,5);=> should print the data on the 3rd row, 5th column

    public void printData(int row, int column){
      //tbody//tr[8]//td[6]
        //String xpath = "//tbody//tr[8]//td[6]";  //=>studio

        //we are writing the the dynamic xpath
        String xpath = "//tbody//tr["+row+"]//td["+column+"]";
        System.out.println(xpath);  //this gives me xpath
        //we are finding the elements using that xpath and printing them
       WebElement data = driver.findElement(By.xpath(xpath));
       System.out.println(data.getText());   //this gives me datas

    }
    @Test
    public void printDataTest(){
        login();
        printData(8,6);
        printData(3,4);    //147
        printData(5,2);   //Hilton Hotel-1

    }
}