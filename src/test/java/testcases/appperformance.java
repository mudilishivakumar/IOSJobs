package testcases;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;



public class appperformance extends BaseTest {
//    LandingPage RHP;
//    HomePage HOM;
//    MobileScrolling sc;
//    HoxPage HO;
//    PlayerPages PL;
//    SchedulePage sp;
//
//    @BeforeClass
//    public void setupPage() {
//        RHP = PageFactory.initElements(driver, LandingPage.class);
//        HOM = PageFactory.initElements(driver, HomePage.class);
//        PL = PageFactory.initElements(driver, PlayerPages.class);
//        sp = PageFactory.initElements(driver, SchedulePage.class);
//
//        sc = new MobileScrolling(driver);
//    }
//
//    @Test(priority = 1)
//
//    public void testAppLaunch() {
//        runTest("App Launch Time", () -> {
//            Assert.assertTrue(RHP.splashscreen(driver).isDisplayed(), "Splash screen not visible");
//            RHP.splashscreen(driver).click();
//        });
//    }
//
//    @Test(priority = 2)
//    public void completeLoginFlow() {
//        runTest("Complete Login Time", () -> {
//            RHP.login(driver).click();
//            test.log(LogStatus.PASS, "User clicked the login button on the landing page");
//
//            WebElement usernameField = RHP.username(driver);
//            usernameField.sendKeys("test27@uat.com");
//            test.log(LogStatus.PASS, "Entered username: test27@uat.com");
//
//            RHP.Nextbutton(driver).click();
//            test.log(LogStatus.PASS, "Clicked on continue button");
//
//            WebElement passwordField = RHP.password(driver);
//            passwordField.sendKeys("Test@27");
//            test.log(LogStatus.PASS, "Entered password: ********");
//
//            WebElement loginBtn = RHP.loginButton(driver);
//            loginBtn.click();
//            test.log(LogStatus.PASS, "Clicked on login button");
//
//            captureScreenshot(driver);
//        });
//    }
//
//    @Test(priority = 3)
//    public void search() {
//        runTest("Searching", () -> {
//            RHP.notnowone(driver).click();
//            PL.searchButton(driver).click();
//            PL.searchInput(driver).click();
//            PL.searchInput(driver).sendKeys("Boxing");
//            captureScreenshot(driver);
//        });
//    }
//        @Test(priority = 4)
//        public void Boxing() {
//            runTest("Boxing", () -> {
//                RHP.Boxing(driver).click();
//            });
//
//        }
//    @Test(priority = 5)
//    public void ScheduleTab(){
//        runTest("Schedule", () -> {
//            sp.scheduleTabItem(driver).click();
//            captureScreenshot(driver);
//            test.log(LogStatus.PASS, "User click ScheduleTab");
//
//        });
//    }
//}
}