package com.techproed.tests.smoketest;

import com.techproed.pages.DefaultPage;
import com.techproed.pages.LoginPage;
import com.techproed.pages.MainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

public class Day12_PositiveLoginTest {
        /*
            Test Case:
            Create a package: smoketest
            Create a class: PositiveTest
            Method: positiveLoginTest
            When user goes to http://www.carettahotel.com/
            And click on Log in
            And send the username and password
            Manager
            Manager1!
         */
    @Test
    public void positiveLoginTest(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
/*


        //A. Create page object => we created it in MainPage Class / LoginPage is done
        //B. Create test class
                1.Step: Create Page Object
                2.Step: Calling the page element using that object

 */
        MainPage mainPage =new MainPage();
        mainPage.mainPageLoginLink.click();

        //At this point we are in LoginPage
        //Create LoginPage object

        LoginPage loginPage = new LoginPage();
        loginPage.username.sendKeys(ConfigReader.getProperty("manager_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
        loginPage.loginButton.click();

        //We need to automaate the login success
        //We choose aa CORE ELEMENT on the page
        //We will use Add User button to verify the login page
        //At this point, we are on the Default Page

        DefaultPage defaultPage = new DefaultPage();
        boolean isLoggedIn = defaultPage.addUserButton.isDisplayed();
        Assert.assertTrue(isLoggedIn);
    }
}
