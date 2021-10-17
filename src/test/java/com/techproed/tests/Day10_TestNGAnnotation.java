package com.techproed.tests;

import org.testng.annotations.*;

public class Day10_TestNGAnnotation {

    /*
    @Test is used to create Test Cases on TestNG
    @BeforeMethod is used to run Brefore each @Test Annotation. Same as @Before in JUnit
    @Ignore is used to skip @Test annotation
        @Test(enabled = false) also skips the @Test annotation. This is similar to @Ignore

    Ordering the Test cases:
        TestNG executes the test cases base on alphabetical order- NOT FORM TOP TO BOTTOM
        We use priority to run in specific order

        @Test(priority = 1)

        Where would you need @BeforeMethod annotation?
            -Pre condition- Creating driver, maximizing screen, time-outs, ...To avoid reputation
        Where would you need @AfterMethod annotation?
            -Post conditions -for closing the driver, To avoid repetition, report generation
        Where would you need @Test annotation?
            -To create test case.
     */

   @BeforeMethod
   public void setUp(){
       System.out.println("Before method");

   }
    @AfterMethod
    public void tearDown(){
        System.out.println("After Method");

    }
    @Test(priority = 1)
    public void test6(){
        System.out.println("Test 6");

    }
    @Test(enabled = false) // same with @Ignore
    public void test2(){
        System.out.println("Test 2");

    }
    @Ignore
    @Test
    public void test3(){
        System.out.println("Test 3");

    }
    @Test(priority = 3)
    public void test4(){
        System.out.println("Test 4");

    }
    @Test(priority = 2)
    public void test5(){
        System.out.println("Test 5");

    }
}
