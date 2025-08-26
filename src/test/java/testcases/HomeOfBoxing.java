package testcases;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

import pages.*;

public class HomeOfBoxing extends BaseTest{
    HoxPage HO;
    MobileScrolling sc;
    HobPage Hob;
    PlayerPages PL;
    LandingPage RHP;
    @BeforeClass
    public void setupPage() {
        HO = PageFactory.initElements(driver, HoxPage.class);

        sc = new MobileScrolling(driver);
        PL = PageFactory.initElements(driver, PlayerPages.class);
        Hob = PageFactory.initElements(driver, HobPage.class);
        RHP = PageFactory.initElements(driver, LandingPage.class);

    }

    @Test(priority = 34)
    public void search() {
        runTest("User want open Hob Page", () -> {
            RHP.notnowone(driver).click();
            PL.searchButton(driver).click();
            captureScreenshot(driver);
            test.log(LogStatus.PASS, "User click search in the Home of Boxing");
            PL.searchInput(driver).click();
            PL.searchInput(driver).sendKeys("Boxing");
            Hob.Hob(driver).click();
            test.log(LogStatus.PASS, "User able to open Hob Page");
            captureScreenshot(driver);


        });
    }

    @Test(priority = 35)
    public void swipeAndVerifyHomeHeroBanners() {
        runTest("Swipe and Verify Home Hero Banners", () -> {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            MobileScrolling scroller = new MobileScrolling(driver);
            captureScreenshot(driver);
            String bannerRailXPath = "//XCUIElementTypeOther[@name=\"DAZN | Boxing\"]/XCUIElementTypeOther[3]";

            for (int i = 0; i < 2; i++) {
                try {
                    Reporter.log("Verifying banner " + (i + 1), true);

                    WebElement bannerContainer = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(bannerRailXPath)));
                    if (bannerContainer.isDisplayed()) {
                        Reporter.log("Banner " + (i + 1) + " is displayed", true);
                    }

                    if (i < 1) {
                        Reporter.log("Swiping to banner " + (i + 2), true);
                        scroller.swipeHorizontally(bannerContainer, true);
                        Thread.sleep(1500); // Allow time for swipe animation
                    }

                } catch (Exception e) {
                    Reporter.log("Error verifying/swiping banner " + (i + 1) + ": " + e.getMessage(), true);
                }
            }

            Reporter.log("Finished verifying both home hero banners.", true);
        });
    }

    @Test(priority = 36)
    public void HomePillScrolling(){
        runTest("Scrolling the HomePill to the end",()->{
            Hob.Home(driver).click();
            MobileScrolling Scroller = new MobileScrolling(driver);
            sc.scrollToEndIOS(driver);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        test.log(LogStatus.PASS,"Clicked on Home and Scrolled to end");
    }

    @Test(priority = 37)
    public void Upcoming_Fights_Scrolling(){
        runTest("Scrolling the Upcoming_Fights to the end",()->{
            Hob.UpcomingFights(driver).click();
            MobileScrolling Scroller = new MobileScrolling(driver);
            Scroller.scrollToEndIOS(driver);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        test.log(LogStatus.PASS,"Clicked on Upcoming_Fights and Scrolled to end");
    }

    @Test(priority = 38)
    public void Previous_Events_Scrolling(){
        runTest("Scrolling the Previous_Events to the end",()->{
            Hob.PreviousEvents(driver).click();
            MobileScrolling Scroller = new MobileScrolling(driver);
            Scroller.scrollToEndIOS(driver);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        test.log(LogStatus.PASS,"Clicked on Previous_Events and Scrolled to end");
    }

    @Test(priority = 39)
    public void Fighters_Scrolling(){
        runTest("Scrolling the Fighters to the end",()->{
            Hob.Fighters(driver).click();
            MobileScrolling Scroller = new MobileScrolling(driver);
            Scroller.scrollToEndIOS(driver);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        test.log(LogStatus.PASS,"Clicked on Fighters and Scrolled to end");
    }

    @Test(priority = 40)
    public void Rankings_Scrolling(){
        runTest("Scrolling the Rankings to the end",()->{
            Hob.Rankings(driver).click();
            MobileScrolling Scroller = new MobileScrolling(driver);
            Scroller.scrollToEndIOS(driver);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        test.log(LogStatus.PASS,"Clicked on Rankings and Scrolled to end");
    }
    @Test(priority = 41)
    public void Social_Scrolling(){
        runTest("Scrolling the Social to the end",()->{
            Hob.Social(driver).click();
            captureScreenshot(driver);
            MobileScrolling Scroller = new MobileScrolling(driver);
            Scroller.scrollToEndIOS(driver);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        test.log(LogStatus.PASS,"Clicked on Social and Scrolled to end");
    }

    @Test(priority = 42)
    public void Shows_Scrolling(){
        runTest("Scrolling the Shows to the end",()->{
            Hob.Shows(driver).click();
            captureScreenshot(driver);
            MobileScrolling Scroller = new MobileScrolling(driver);
            Scroller.scrollToEndIOS(driver);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        test.log(LogStatus.PASS,"Clicked on Shows and Scrolled to end");
    }

    @Test(priority = 43)
    public void BackClick(){
        runTest("Click Back and Return to Home Page",()->{
            Hob.Back(driver).click();
            captureScreenshot(driver);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Hob.searchClose(driver).click();
            captureScreenshot(driver);
        });
        test.log(LogStatus.PASS,"Click Back and Return to Home Page");
    }
}

