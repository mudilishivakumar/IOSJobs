package testcases;

import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HoxPage;
import pages.LandingPage;
import pages.MobileScrolling;
import pages.PlayerPages;

import java.time.Duration;

public class playercases extends BaseTest {

    HoxPage HO;
    MobileScrolling sc;

    PlayerPages PL;
    LandingPage RHP;


    @BeforeClass
    public void setupPage() {
        HO = PageFactory.initElements(driver, HoxPage.class);
        RHP = PageFactory.initElements(driver, LandingPage.class);

        sc = new MobileScrolling(driver);
        PL = PageFactory.initElements(driver, PlayerPages.class);
    }

    @Test(priority = 13)
    public void search() {
        runTest("User click the search icon in home", () -> {

            PL.searchButton(driver).click();
            captureScreenshot(driver);
            test.log(LogStatus.PASS, "User click search in the home");

        });
    }

    @Test(priority = 14)
    public void searchinput() {
        runTest("User search the search the Stacktile", () -> {
            PL.searchInput(driver).click();
            PL.searchInput(driver).sendKeys("inter vs.Fluminese");
            captureScreenshot(driver);

            test.log(LogStatus.PASS, "User search the search the Stacktile");


        });
    }

    @Test(priority = 15)
    public void stacktile() {
        runTest("User click the Stacktile", () -> {
            PL.searchingStacktile(driver).click();
            test.log(LogStatus.PASS, "User search the search the Stacktile");
            captureScreenshot(driver);

        });
    }
    @Test(priority = 16)
    public void switchcontent() {
        runTest("User able switch-content", () -> {
            PL.switchcontent(driver).click();
            test.log(LogStatus.PASS, "User switch-content");
            captureScreenshot(driver);
            sc.scrollDown();
            PL.highlightplayicon(driver).click();
            captureScreenshot(driver);
            test.log(LogStatus.PASS, "User click on highlightplayicon");


        });
    }
    @Test(priority = 17)
    public void icons() {
        runTest("User verifying casting,airplay,help button", () -> {
            PL.playerclick(driver).click();
            PL.helpButton(driver).isEnabled();

            test.log(LogStatus.PASS, "User verifying the helpButton ");
            PL.chromecastButton(driver).isEnabled();
            test.log(LogStatus.PASS, "User verifying the chromecastButton ");



            PL.airplayButton(driver).isEnabled();
            test.log(LogStatus.PASS, "User verifying the airplayButton ");

        });
    }

    @Test(priority = 17)
    public void forwardRewind() {
        runTest("User verifying forward-rewind ", () -> {

            PL.playerforward10(driver).click();
            test.log(LogStatus.PASS, "User play player-forward10 ");
            PL.playerback10(driver).click();
            test.log(LogStatus.PASS, "User play player-back10");

        });
    }

    @Test(priority = 18)
    public void fullScreenButton() {
        runTest("User verifying fullScreenButton ", () -> {
            PL.playerclick(driver).click();
            PL.fullScreenButton(driver).click();
            test.log(LogStatus.PASS, "User verifying the fullScreenButton ");
            PL.fullScreenButton(driver).click();
            test.log(LogStatus.PASS, "User ExitFullScreen");

        });
    }

    @Test(priority = 19)
    public void likeshare() {
        runTest("User verifying like and share ", () -> {
            PL.share_icon(driver).isEnabled();
            test.log(LogStatus.PASS, "User verifying share-icon  ");
            PL.like(driver).isEnabled();
            captureScreenshot(driver);

            test.log(LogStatus.PASS, "User verifying  like-icon ");

        });
    }

    @Test(priority = 20)
    public void Timer() {
        runTest("User verifying Timer", () -> {
            PL.playerclick(driver).click();
            PL.timeScrubberView(driver).click();
            PL.timeLabel(driver).isDisplayed();
            test.log(LogStatus.PASS, "User able to see timer");


        });
    }

    @Test(priority = 21)
    public void SeekBar() {
        runTest("User verifying and moving Timer", () -> {
//            WebElement scrubber = PL.timeScrubberView(driver);
//
//            Assert.assertTrue(scrubber.isDisplayed(), "Scrubber is not visible");
//            test.log(LogStatus.PASS, "User able to see timer");
//
//            // Get position and size
//            int startX = scrubber.getLocation().getX();
//            int startY = scrubber.getLocation().getY();
//            int width = scrubber.getSize().getWidth();
//            int height = scrubber.getSize().getHeight();
//
//            int endX = (int) (startX + (width * 0.8));
//            int centerY = startY + (height / 2);
//
//            // Perform swipe action to move the scrubber
//            new TouchAction<>(driver)
//                    .press(PointOption.point(startX, centerY))
//                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
//                    .moveTo(PointOption.point(endX, centerY))
//                    .release()
//                    .perform();
            PL.playerclick(driver).click();
            PL.timeScrubberView(driver).click();
            PL.timeScrubberView(driver).click();
            PL.playerclick(driver).click();
            test.log(LogStatus.INFO, "User moved the seeker forward");
        });
    }
    @Test(priority = 22)

    public void playerclose() {
        runTest("User close the player", () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            PL.playerclick(driver).click();
            PL.playerclick(driver).click();
            PL.playerclick(driver).click();
            PL.playerclick(driver).click();
          PL.close(driver).click();
            captureScreenshot(driver);

            test.log(LogStatus.INFO, "close the fixture page");

        });
    }
}