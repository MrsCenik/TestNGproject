package com.techproed.dataprovider;

import org.testng.annotations.*;

public class Day16_DataProvider1 {
    /*
    Working with DataProvider
    1. Create a method that returns 2D object array
    2. Use @DataProvider annotation on that method
    3. Store the test data in the method

    4. Create a test method
    5. Use  @Test(dataProvider = "getData") annotation

    @DataProvider will pass the data to the test class
    */



    //Create a method to get the data from DataProvider
    //return type of the method is 2D Object array
    @DataProvider
    public Object[][] getData(){
        //manager   Manager1!
        //manager2  Manager2!
        //manager3   Manager3!
/*
        1.Way to add data

        Object [][] managerProfile = new Object[3][2]; //3 rows(outer array), 2 columns(inner array)
        //1st row
        managerProfile [0][0]="manager";
        managerProfile [0][1]="Manager1!";
        //2nd row
        managerProfile [1][0]="manager2";
        managerProfile [1][1]="Manager2!";
        //3rd row
        managerProfile [2][0]="manager2";
        managerProfile [2][1]="Manager2!";

    return managerProfile;
    }
*/
        /*
        2.Way to add data

         */
        String [][] managerProfile= {
                {"manager","Manager1!"},
                {"manager2","Manager2!"},
                {"manager3","Manager3!"}
        };
        return managerProfile;
    }

    @Test(dataProvider = "getData")
    public void managerInfo(String userName, String password){
        //To get the manager credentials we can use Excel
        //In this class we are going to use DataProvider
        System.out.println("User Name: " +userName+ "\nPassword: "+password);
    }
}
