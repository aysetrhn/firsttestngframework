package com.techproed.paralelTesting;


import org.testng.annotations.Test;

public class Test1 {
    @Test
    public void method1(){
        //Given user is on the https://fhctrip.com/admin/useradmin/Create
        //And verify all the information and click save
        //Then verify the creation is successful
        System.out.println("This is method 1");
        System.out.println("Thread ID of method 1: " +Thread.currentThread().getId());
    }
    @Test
    public void method2(){
        System.out.println("This is method 2");
        System.out.println("Thread ID of method 2: " +Thread.currentThread().getId());

    }
    @Test
    public void method3(){
        System.out.println("This is method 3");
        System.out.println("Thread ID of method 3: " +Thread.currentThread().getId());


    }
}
