package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

/*
 # 1.In this class only general utility methods that are not related to same specific page.
 */
     public class BrowserUtils {
    //1.this method will accept int(in second) and execute Thread.sleep for given duration

    public static void sleep(int second){
        second*=1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e){

            }
        }
   /*
 #  2. This method accepts 3 argument
   Arg1. webdriver
   Arg2. expectedInURL: for verify if the url contains given String.
      - If condition matches, will break loop'\.
   Arg3. expectedInTitle to be compared against actualTitle
    */
    public static void switchWindowAndVerify(WebDriver driver,String expectedInUrl, String expectedTitle ){

        Set<String> allWindowsHandles = driver.getWindowHandles();
        for (String each : allWindowsHandles) {
            driver.switchTo().window(each);
            System.out.println("Current URL: " + driver.getCurrentUrl()); //stays on Google

            // if statement we don't need if we have only 2 windows
            if (driver.getCurrentUrl().contains("expectedInUrl")) {
                break;// stopping and stay on expectedTitle
            }
        }

        //  Assert: Title contains “expectedTitle”
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }
    /*
  # 3. This static accepts a String "expectedTitle" and Asserts if it is true
     */
    public static void verifyTitle(WebDriver driver,String expectedTitle){

        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }
}


