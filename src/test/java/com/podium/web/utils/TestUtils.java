package com.podium.web.utils;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.podium.web.pages.PodiumLandingPage;

public class TestUtils {
    public static void validateProductsMenu(WebDriver driver, PodiumLandingPage landingPage, SoftAssert report) {
        Actions builder = new Actions(driver);
        builder.moveToElement(landingPage.getProductsMenu()).build().perform();
        landingPage.getReviewsMenu().click();
        report.assertTrue(driver.getTitle().contains("Customer Feedback") == true,
                "Redirection to Reviews page is incorrect");
        driver.navigate().back();

        builder.moveToElement(landingPage.getProductsMenu()).build().perform();
        landingPage.getPaymentsMenu().click();
        report.assertTrue(driver.getTitle().contains("Mobile Payment Processing") == true,
                "Redirection to Payments page is incorrect");
        driver.navigate().back();

        builder.moveToElement(landingPage.getProductsMenu()).build().perform();
        landingPage.getFeedbackMenu().click();
        report.assertTrue(driver.getTitle().contains("Customer Feedback Software") == true,
                "Redirection to Feedback page is incorrect");
        driver.navigate().back();

        builder.moveToElement(landingPage.getProductsMenu()).build().perform();
        landingPage.getVideoChatMenu().click();
        report.assertTrue(driver.getTitle().contains("Get face to face with Videochat") == true,
                "Redirection to Video chat page is incorrect");
        driver.navigate().back();

        builder.moveToElement(landingPage.getProductsMenu()).build().perform();
        landingPage.getWebChatMenu().click();
        report.assertTrue(driver.getTitle().contains("Live Chat SMS Softwar") == true,
                "Redirection to Web chat page is incorrect");
        driver.navigate().back();

        builder.moveToElement(landingPage.getProductsMenu()).build().perform();
        landingPage.getTeamChatMenu().click();
        report.assertTrue(driver.getTitle().contains("Internal Communication Software") == true,
                "Redirection to Team chat page is incorrect");
        driver.navigate().back();
    }

    public static void validateImages(WebDriver driver, PodiumLandingPage landingPage, SoftAssert report) {
        List<WebElement> allImages = landingPage.getLandingPageImages();
        for (WebElement img : allImages) {
            // check image natural width
            if (img.getAttribute("src") != null && img.getAttribute("style").equalsIgnoreCase("display:none")) {
                boolean isImageDisplayed = (Boolean) ((JavascriptExecutor) driver).executeScript(
                        "return (typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth > 0);",
                        img) == true;
                report.assertTrue(isImageDisplayed == true, "This image is broken : " + img.getAttribute("src"));
            }
        }
    }
}
