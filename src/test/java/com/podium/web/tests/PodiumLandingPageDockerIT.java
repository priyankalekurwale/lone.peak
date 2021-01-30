package com.podium.web.tests;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.podium.web.pages.PodiumLandingPage;
import com.podium.web.utils.TestUtils;

public class PodiumLandingPageDockerIT extends DockerTestSetUp {
    SoftAssert report = new SoftAssert();
    PodiumLandingPage landingPage;

    // Executes before each test method
    @BeforeMethod
    public void setUp() {
        landingPage = PageFactory.initElements(driver, PodiumLandingPage.class);
    }

    /**
     * Validates if home page title and if Podium logo is displayed
     */
    @Test(priority = 1)
    public void validateTitleAndLogo() {
        report.assertTrue(landingPage.getLogo().isEnabled() == true, "Logo is not enabled on landing page");
        report.assertTrue(landingPage.getTitle().contains("Messaging Tools for Local Business"),
                "Title for landing page is incorrect");
        report.assertAll();
    }

    /**
     * Clicks on Watch Demo button and validates redirection
     */
    @Test(priority = 2)
    public void validateWatchDemoButton() {
        landingPage.getWatchDemoButton().click();
        report.assertTrue(driver.getCurrentUrl().equals("https://learn.podium.com/watch3now"),
                "Watch Demo button redirect is incorrect");
        driver.navigate().back();
        report.assertAll();
    }

    /**
     * Validates if images on landing page are displayed
     *
     * @throws InterruptedException : if Thread is interrupted
     */
    @Test(priority = 3)
    public void validateImagesOnLandingPage() throws InterruptedException {
        TestUtils.validateImages(driver, landingPage, report);
        report.assertAll();
    }

    /**
     * Validates if testimonial videos can be played and closed. This method tests 2 videos in slider
     *
     * @throws InterruptedException
     */
    @Test(priority = 4)
    public void validateTestimonialVideos() throws InterruptedException {
        landingPage.playTraneVideo();
        Thread.sleep(3000);
        landingPage.clickRightVideoArrow();
        landingPage.playAustinCouchPotatoVideo();
    }

    /**
     * Validates navigation in Products mega menu.
     */
    @Test(priority = 5)
    public void validateProductsMegaMenu() throws InterruptedException {
        TestUtils.validateProductsMenu(driver, landingPage, report);
        report.assertAll();
    }

    /**
     * Validates if chat bubble is accessible
     */
    @Test(priority = 6)
    public void validateChatFeature() throws InterruptedException {
        landingPage.waitForChatBubble(new WebDriverWait(driver, 3));
        landingPage.getChatBubble().click();
    }

}
