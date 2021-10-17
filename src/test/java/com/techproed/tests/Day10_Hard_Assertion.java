package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Day10_Hard_Assertion {
    /*
    When user goes to application home page http://www.carettahotel.com/
    Then verifies the title equals Caretta Hotel
    And clicks on login button
    And verify the page title Caretta Hotel - Log in
     */

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void hardAssert(){
        driver.get("http://www.carettahotel.com/");
        Assert.assertTrue(driver.getTitle().equals("Caretta Hotel"));

        driver.findElement(By.linkText("Log in")).click();
        Assert.assertTrue(driver.getTitle().equals("Caretta Hotel - Log in"));


    }
}
