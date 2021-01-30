package com.podium.web.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class LocalTestSetUp {
    public static WebDriver driver = null;

    @BeforeMethod
    public void initialize() {
        driver = new ChromeDriver();
        // Maximize browser window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://www.podium.com");
    }

    @AfterMethod
    public void tearDownTest() {
        driver.quit();
    }
}
