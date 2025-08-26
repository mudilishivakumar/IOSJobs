package testcases;

import baseLibrary.Setup;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HoxPage;
import pages.LandingPage;
import pages.MobileScrolling;

public class LoginCases extends BaseTest {
        LandingPage RHP;
        HomePage HOM;
        MobileScrolling sc;
        HoxPage HO;

        @BeforeClass
        public void setupPage() {
            RHP = PageFactory.initElements(driver, LandingPage.class);
            HOM = PageFactory.initElements(driver, HomePage.class);

            sc = new MobileScrolling(driver);
        }

        @Test(priority = 1)
        public void testLaunchApp() {
            runTest("launch app", () -> {
                captureScreenshot(driver);
                Assert.assertTrue(RHP.splashscreen(driver).isDisplayed(), "Splash screen not visible");
                RHP.splashscreen(driver).click();

            });
        }

        @Test(priority = 2)
        public void signInButton() {
            runTest(" landing Pages", () -> {
                captureScreenshot(driver);

                RHP.login(driver).click();

                test.log(LogStatus.PASS, "User click the login button on landing page");
            });
        }

        @Test(priority = 3)
        public void enterCredentials() {
            runTest("USER Enters Username & Password", () -> {
                captureScreenshot(driver);

                WebElement usernameField = RHP.username(driver);
                usernameField.sendKeys("test6@uat.com");
                test.log(LogStatus.PASS, "Entered username: test6@uat.com");

                RHP.Nextbutton(driver).click();
                test.log(LogStatus.PASS, "click on continue-button");
                captureScreenshot(driver);

                WebElement passwordField = RHP.password(driver);
                passwordField.sendKeys("Test@6");
                test.log(LogStatus.PASS, "Entered password:  ********");


            });
        }

        @Test(priority = 4)
        public void loginButton() {
            runTest("Login Button", () -> {
                WebElement loginBtn = RHP.loginButton(driver);
                loginBtn.click();
                captureScreenshot(driver);
                test.log(LogStatus.PASS, "click on login button");

            });
        }

        @Test(priority = 5)
        public void homePageNotification() {
            runTest("HomePage Notification", () -> {
                try {
                    RHP.notnowone(driver).click();
                    Thread.sleep(2000);
                    RHP.notnowone(driver).click();
                    test.log(LogStatus.INFO, "User dismiss notifications");
                    HO.notnowone(driver).click();
                    test.log(LogStatus.INFO, "User dismiss 2nd notifications");

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        @Test(priority = 6)
        public void UMSImage() {
            runTest("User Dismiss the UMS popup", () -> {
                try {
                    WebElement umsPopup = RHP.dismiss(driver);
                    if (umsPopup != null && umsPopup.isDisplayed()) {
                        umsPopup.click();
                      //  captureScreenshot(driver);
                        test.log(LogStatus.INFO, "User dismissed UMS popup");
                    } else {
                      //  captureScreenshot(driver);
                        test.log(LogStatus.INFO, "UMS popup not displayed");
                    }
                } catch (NoSuchElementException | TimeoutException e) {
                 //   captureScreenshot(driver);
                    test.log(LogStatus.INFO, "UMS popup not displayed - exception caught");
                } catch (Exception e) {
                   // captureScreenshot(driver);
                    test.log(LogStatus.FAIL, "An unexpected error occurred: " + e.getMessage());
                }
            });
        }

    }
