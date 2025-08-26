package testcases;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;
public class NFLTestCases extends BaseTest{
    MobileScrolling sc;
    HobPage Hob;
    PlayerPages PL;
    NflPage NFL;
    @BeforeClass
    public void setupPage() {
        NFL= PageFactory.initElements(driver, NflPage.class);
        sc = new MobileScrolling(driver);
        PL = PageFactory.initElements(driver, PlayerPages.class);
        Hob = PageFactory.initElements(driver, HobPage.class);
    }
    @Test(priority = 44)
    public void search() {
        runTest("User want open nfl Page", () -> {
            PL.searchButton(driver).click();
            captureScreenshot(driver);
            test.log(LogStatus.PASS, "User click search in the NFL");
            PL.searchInput(driver).click();
            PL.searchInput(driver).sendKeys("NFL");
            NFL.NFL(driver).click();
            test.log(LogStatus.PASS, "User able to open NFL Page");
            captureScreenshot(driver);

        });
    }

    @Test(priority = 45)
    public void swipeAndVerifyHomeHeroBanners() {
        runTest("Swipe and Verify NFL Hero Banners", () -> {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            MobileScrolling scroller = new MobileScrolling(driver);

            String bannerRailXPath = "//XCUIElementTypeOther[@name=\"DAZN | NFL Game Pass\"]/XCUIElementTypeOther[6]";

            for (int i = 0; i < 4; i++) {
                try {
                    Reporter.log("Verifying banner " + (i + 1), true);

                    WebElement bannerContainer = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(bannerRailXPath)));
                    if (bannerContainer.isDisplayed()) {
                        Reporter.log("Banner " + (i + 1) + " is displayed", true);
                    }

                    if (i < 3) {
                        Reporter.log("Swiping to banner " + (i + 2), true);
                        scroller.swipeHorizontally(bannerContainer, true);
                        Thread.sleep(1500);
                    }

                } catch (Exception e) {
                    Reporter.log("Error verifying/swiping banner " + (i + 1) + ": " + e.getMessage(), true);
                }
            }

            Reporter.log("Finished verifying both home hero banners.", true);
        });
    }




    @Test(priority = 46)
    public void NFL_Game_Pass_Home() throws InterruptedException {
        Thread.sleep(2000);
        runTest("Click on Home and Scroll to end",()->{
            NFL.NFL_Home(driver).click();
            captureScreenshot(driver);
            MobileScrolling scroller = new MobileScrolling(driver);
            scroller.scrollToEndIOS(driver);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            test.log(LogStatus.PASS,"Clicked on Home and Scroll to end");
        });
    }

    @Test(priority = 47)
    public void NFL_Game_Pass_Schedule() throws InterruptedException {
        Thread.sleep(2000);
        runTest("Click on Schedule and Scroll to end",()->{
            NFL.Schedule(driver).click();
            captureScreenshot(driver);
            MobileScrolling scroller = new MobileScrolling(driver);
            scroller.scrollToEndIOS(driver);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            test.log(LogStatus.PASS,"Clicked on Schedule and Scroll to end");
        });
    }

    @Test(priority = 48)
    public void NFL_Game_Pass_Games() throws InterruptedException {
        Thread.sleep(2000);
        runTest("Click on Games and Scroll to end",()->{
            NFL.Games(driver).click();
            captureScreenshot(driver);
            MobileScrolling scroller = new MobileScrolling(driver);
            scroller.scrollToEndIOS(driver);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            test.log(LogStatus.PASS,"Clicked on Games and Scroll to end");
        });
    }

    @Test(priority = 49)
    public void NFL_Game_Pass_NFL_Network() throws InterruptedException {
        Thread.sleep(2000);
        runTest("Click on NFL_Network and Scroll to end",()->{
            NFL.NFL_Network(driver).click();
            captureScreenshot(driver);
            MobileScrolling scroller = new MobileScrolling(driver);
            scroller.scrollToEndIOS(driver);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            test.log(LogStatus.PASS,"Clicked on NFL_Network and Scroll to end");
        });
    }

    @Test(priority = 50)
    public void NFL_Game_Pass_Teams() throws InterruptedException {
        Thread.sleep(2000);
        runTest("Click on Teams and Scroll to end",()->{
            NFL.NFL_Game_Pass_Teams(driver).click();
            captureScreenshot(driver);
            MobileScrolling scroller = new MobileScrolling(driver);
            scroller.scrollToEndIOS(driver);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            test.log(LogStatus.PASS,"Clicked on Teams and Scroll to end");
        });
    }

    @Test(priority = 51)
    public void NFL_Game_Pass_Standings() throws InterruptedException {
        Thread.sleep(2000);
        runTest("Click on Standings and Scroll to end",()->{
            NFL.Standings(driver).click();
            captureScreenshot(driver);
            MobileScrolling scroller = new MobileScrolling(driver);
            scroller.scrollToEndIOS(driver);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            test.log(LogStatus.PASS,"Clicked on Standings and Scroll to end");
        });
    }

    @Test(priority = 52)
    public void NFL_Game_Pass_NFL_Originals() throws InterruptedException {
        Thread.sleep(2000);
        runTest("Click on NFL_Originals and Scroll to end",()->{
            NFL.NFL_Originals(driver).click();
            captureScreenshot(driver);
            MobileScrolling scroller = new MobileScrolling(driver);
            scroller.scrollToEndIOS(driver);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            test.log(LogStatus.PASS,"Clicked on NFL_Originals and Scroll to end");
        });
    }

    @Test(priority = 53)
    public void NFL_Game_Pass_BackBtn(){
        runTest("Click on Back",()->{
            Hob.Back(driver).click();
            captureScreenshot(driver);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Hob.searchClose(driver).click();
            test.log(LogStatus.PASS,"Click on Back");
        });
    }
}

