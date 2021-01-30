package com.podium.web.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DockerTestSetUp {
    public static WebDriver driver = null;

    @BeforeSuite
    public void initialize() throws MalformedURLException {
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        URL url = new URL("http://localhost:4444/wd/hub");
        driver = new RemoteWebDriver(url, dc);
        driver.manage().window().maximize();
        driver.get("https://www.podium.com/");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDownTest() {
        driver.quit();
    }
}
