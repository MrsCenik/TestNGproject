package com.techproed.tests.smoketest;

import com.techproed.pages.LoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day12_NegativeLoginTest {
    @Test
    public void invalidPassword(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));
        LoginPage loginPage = new LoginPage();
        //When the user enters wrong password only
        loginPage.username.sendKeys(ConfigReader.getProperty("manager_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("invalid_password"));
        loginPage.loginButton.click();

        //Then verify the error message include "Wrong password"
        String actualErrorMessage = loginPage.errorMessage.getText();
        Assert.assertTrue(actualErrorMessage.contains("Wrong password"));
    }

    @Test
    public void invalidId(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));
        LoginPage loginPage = new LoginPage();
        loginPage.username.sendKeys(ConfigReader.getProperty("invalid_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
        loginPage.loginButton.click();

        String actualErrorMessage = loginPage.errorMessage.getText();
        Assert.assertTrue(actualErrorMessage.contains("Try again please"));
    }
    @Test
    public void invalidIdAndPassword(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));
        LoginPage loginPage = new LoginPage();
        loginPage.username.sendKeys(ConfigReader.getProperty("invalid_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("invalid_password"));
        loginPage.loginButton.click();
        String actualErrorMessage = loginPage.errorMessage.getText();
        System.out.println(actualErrorMessage);
        Assert.assertTrue(actualErrorMessage.contains("Username or password is incorrect, please correct them and try again"));
    }
}
