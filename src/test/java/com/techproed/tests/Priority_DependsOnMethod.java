package com.techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Priority_DependsOnMethod {
    /*
    In testNG, test methods runs alphabetical order. They do nut run from top to buttom.
    To prioritize test cases, we use priority annotation.
    When the priority numbers same, then the execution is in alphabetical order.
    If the test method doesn't have the priority annotation, it execute before.
     */
    //Make search() dependent on login():Answer: we write dependsOnMethod="login" inside the search() method
    @Test(priority = 1)
    public void login(){
        System.out.println("This is login page");
    }
    @Test(priority = 2)
    public void homePage(){
        System.out.println("This is home page");
    }
    @Test(priority = 3)
    public void search(){
        System.out.println("This is search page");
        //Assert.assertTrue(false);
        Assert.assertEquals(3,5);  //this method will fail
        //since this method fails, result() will be ignored
    }
    //To make result() depends on search()
    @Test(priority = 4,dependsOnMethods = "search") //result() is now dependent on result.search() is not dependent on result()
    public void result(){
        System.out.println("This is result page");
    }
}
