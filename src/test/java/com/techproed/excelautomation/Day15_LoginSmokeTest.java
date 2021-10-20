package com.techproed.excelautomation;
 /*
            TASK:
            Test the log in functionality of the application with different user profiles(admin, manager, customer services, end user)
            Test Data  URL : https://qa-environment.resortsline.com/Account/Logon
            User Credentials : Excel Sheet

            STEPS:
            Prepare the test data:
            Add url in config properties
            Add smoke test excel sheet in the resources
            Create your automation scrips
            Java class : LoginSmokeTest
            Methods   : adminLoginTest
            Methods   : managerLoginTest
*/

import com.techproed.pages.DefaultPage;
import com.techproed.pages.LoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ExcelUtil;
import org.testng.annotations.*;

import java.util.List;
import java.util.Map;

public class Day15_LoginSmokeTest {

    //creating ExcelUtil object
    ExcelUtil excelUtil;
    //Get teh data (username,password) as key-value pairs
    //I will use testData to store username-password values
    //Map<String, String>      : {manager,    Manager1!}
    //List<Map<String,String>> : {{manager, Manager1!},{manager2,   Manager2!},{manager3    Manager3!}}
    List<Map<String, String>>  testData;
    //page objects
    LoginPage loginPage;
    DefaultPage defaultPage;

    @BeforeTest
    public void setUp() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("app_qa_environment"));
        loginPage = new LoginPage();
        Thread.sleep(1000);
        try { //We are using try and catch for handling advanced proceed page
            Thread.sleep(1000);
            loginPage.advancedLink.click();
            Thread.sleep(1000);
            loginPage.proceedLink.click();
        }catch (Exception e){
            System.out.println("Advanced issue");
        }
    }

          //setUp is used to log the application page
//        setUp();
//
//
//        loginPage.username.sendKeys("manager");
//        loginPage.password.sendKeys("Manager1!");
//        loginPage.loginButton.click();
    @Test
    public void adminLoginTest() throws InterruptedException {
        String path = "./src/test/java/resources/smoketestdata.xlsx";
        String sheetName = "admin_login_info";
        excelUtil = new ExcelUtil(path, sheetName);

        testData = excelUtil.getDataList();
        System.out.println(testData);

        for(Map<String, String> eachData : testData){ //eachData represent each username-password pairs
            setUp(); //login in each loop
            loginPage.username.sendKeys(eachData.get("username"));
            loginPage.password.sendKeys(eachData.get("password"));

        }
    }
    @Test
    public void managerLoginTest() throws InterruptedException {

        String path = "./src/test/java/resources/smoketestdata.xlsx";
        String sheetName = "manager_login_info";
        excelUtil = new ExcelUtil(path, sheetName);

        for (Map<String, String> eachData : testData) { //eachData represent each username-password pairs
            setUp();
            loginPage.username.sendKeys(eachData.get("username"));//manager
            loginPage.password.sendKeys(eachData.get("password"));//Manager1!

            loginPage.loginButton.click();
        }
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();

    }

}


