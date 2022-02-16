package com.cydeo.tests.practice_02_16_2022;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TC2_MultipleButtons {
    public static void main(String[] args) {


        //TC-2: XPATH LOCATOR practice
        //1. Open Chrome browser
        // 2. Go to http://practice.cybertekschool.com/multiple_buttons
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        // 3. Click on Button 1
        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        button1.click();
        // 4. Verify text displayed is as expected:
        WebElement resultText = driver.findElement(By.id("result"));

        // Expected: “Clicked on button one!”
        String expectedText = "Clicked on button one!";
        String actualText = resultText.getText();

       if(actualText.equals(expectedText)){
           System.out.println("passed!");
       }else{
           System.out.println("failed!");
       }
        // 5. Locate and click Button 2
        WebElement button2 = driver.findElement(By.xpath("//button[@onclick='button2()']"));
        button2.click();
        //6. Verify Button 2 is displayed.
        System.out.println("Button 2 is displayed "+button2.isDisplayed());
    }
}