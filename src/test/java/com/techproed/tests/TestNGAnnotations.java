package com.techproed.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TestNGAnnotations {
    //First TestNG Class
    //create a method and name : setUp() and use @BeforeMethod annotation.

    @BeforeMethod
    public void beforeMethod(){
        //@BeforeMethod runs before each method that has annotation.
        System.out.println("THIS IS BEFORE METHOD");
    }


    @BeforeClass
    public void beforeClass(){
        System.out.println("THIS IS BEFORE CLASS RUNS ONLY ONES");
    }


    @Test
    public void test1(){
        //@Test is used to create test cases or test method.
        //@Test annotation helps us to run the test.
        System.out.println("THIS IS Test1 METHOD");
    }
    @Test
    public void test2(){
        System.out.println("THIS IS Test2 METHOD");
    }
    @Ignore  //How can you test3?  Answer: we use @Ignore annotation to skip certain test cases.
    @Test
    public void test3(){
        System.out.println("THIS IS Test3 METHOD");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("THIS IS AFTER METHOD");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("THIS IS AFTER CLASS RUNS ONLY ONES");
    }

}
