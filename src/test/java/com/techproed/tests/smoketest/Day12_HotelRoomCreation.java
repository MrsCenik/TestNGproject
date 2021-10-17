package com.techproed.tests.smoketest;

import com.techproed.pages.DefaultPage;
import com.techproed.pages.LoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collection;

public class Day12_HotelRoomCreation {
    /*
        //Create a clickOnLogin method
        //Click on Hotel Management
        //Click on Hotel Rooms
        //Click on Add Hotel Room
        //Enter All required fields
        //To enter a price, we can send keys, OR we can use actions class to drag and drop
        //Click Save
        //Verify the message: HotelRoom was inserted successfully
        //Click OK
     */
    LoginPage loginPage;
    DefaultPage defaultPage;

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));
        loginPage=new LoginPage();
        loginPage.username.sendKeys(ConfigReader.getProperty("manager_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
        loginPage.loginButton.click();
        //Assertion login success
        defaultPage = new DefaultPage();
        Assert.assertTrue(defaultPage.addUserButton.isDisplayed());
    }

    @Test
    public void hotelRoomCreate(){
        defaultPage.hotelManagementTab.click();
        defaultPage.hotelRooms.click();
        defaultPage.addHotelRoom.click();

    }

    /*
    //Click on Hotel Management
        defaultPage.hotelManagementTab.click();
//Click on Hotel Rooms
        defaultPage.hotelRoomsTab.click();
//Click on Add Hotel Room
        hotelRoomsPage=new HotelRoomsPage();
        hotelRoomsPage.addHotelRoomLink.click();
//Enter All required fields
        //ID IS DROPDOWN
        Select select = new Select(hotelRoomsPage.idDropdown);
        select.selectByIndex(2);

        //Code
        hotelRoomsPage.code.sendKeys("discount code");

//To enter a price, we can send keys, OR we can use actions class to drag and drop
//Click Save
//Verify the message: HotelRoom was inserted successfully
//Click OK
     */
}
