package com.cydeo.tests.practice_03_02_2022;

import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CRM_US10_CorrectModules {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        String browserType = ConfigurationReader.getProperty("browser");

        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get(ConfigurationReader.getProperty("env"));

        CRM_Utilities.crm_login(driver);

    }

    @Test
    public void leftSidebarModulesTest(){

    }
}
