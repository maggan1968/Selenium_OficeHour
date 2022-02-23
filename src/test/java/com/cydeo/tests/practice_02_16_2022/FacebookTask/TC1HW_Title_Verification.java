package com.cydeo.tests.practice_02_16_2022.FacebookTask;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TC1HW_Title_Verification {
    public static void main(String[] args) {


        //TC #1: Facebook title verification
//1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//2. Go to https://www.facebook.com
        driver.get("https://www.facebook.com");

//3. Verify title:
// Expected: “Facebook – log in or sign up”
        String expectedTitle= "Facebook – log in or sign up";
// actual title comes from the browser
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title is expected. Verification Passed!");
        }else {
            System.out.println("Title is NOT expected. Verification Failed!");
        }

    }
}
