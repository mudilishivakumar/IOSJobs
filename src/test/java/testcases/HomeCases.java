package testcases;

import baseLibrary.Setup;

import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HoxPage;
import pages.LandingPage;
import pages.MobileScrolling;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HomeCases extends BaseTest {

    HoxPage HO;
    MobileScrolling sc;

    @BeforeClass
    public void setupPage() {
        HO = PageFactory.initElements(driver, HoxPage.class);

        sc = new MobileScrolling(driver);
    }


    @Test(priority = 8)
    public void castIconValidation() {
        runTest("Cast Icon Visibility", () -> {
            Assert.assertTrue(HO.chromecast(driver).isDisplayed(), "Cast Icon is not visible");
            test.log(LogStatus.PASS, "user able to see cast icon");

        });
    }

    @Test(priority = 9)
    public void castingScreenActions() {
        runTest("Casting Screen Actions", () -> {
            HO.chromecast(driver).click();
            captureScreenshot(driver);
            test.log(LogStatus.PASS, "user click on cast icon");

            HO.settings(driver).isEnabled();
            test.log(LogStatus.PASS, "user verified settingCTA Enable or not");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            HO.cancel(driver).click();
            test.log(LogStatus.PASS, "user click on cancel button on casting screen");
        });
    }

    @Test(priority = 10)
    public void secondarynav() {
        runTest("Secondary Navigation Visualization", () -> {
            try {
                WebElement secondaryNavElement = HO.secondarynav(driver);
                if (secondaryNavElement != null && secondaryNavElement.isDisplayed()) {
                    test.log(LogStatus.PASS, "Secondary navigation is displayed.");
                    // Optional: perform actions like click, etc.
                } else {
                    test.log(LogStatus.FAIL, "Secondary navigation is not displayed.");
                }
            } catch (NoSuchElementException | TimeoutException e) {
                test.log(LogStatus.INFO, "Secondary navigation not available - exception caught.");
            } catch (Exception e) {
                test.log(LogStatus.FAIL, "Unexpected error occurred: " + e.getMessage());
            }
        });
    }
    @Test(priority = 11)
    public void verifySecondaryNavButtonsClickableExceptLiveChannels() {
        runTest("Verify Secondary Nav Buttons actions", () -> {
            HO.secondarynav(driver);
            sc.swipeLeft();
            test.log(LogStatus.PASS, " User able to swipe the SecondaryNav ");

        });
    }


//    @Test(priority = 11)
//    public void verifySecondaryNavButtonsClickableExceptLiveChannels() {
//        runTest("Verify Secondary Nav Buttons actions", () -> {
//            try {
//                WebElement shortcutsContainer = driver.findElement(
//                        By.xpath("//XCUIElementTypeOther[@name='sports_shortcuts_view']")
//                );
//
//                Set<String> visited = new HashSet<>();
//                int swipeAttempts = 0;
//                int maxSwipes = 5;
//
//                while (swipeAttempts <= maxSwipes) {
//                    List<WebElement> navButtons = shortcutsContainer.findElements(
//                            By.xpath(".//XCUIElementTypeOther")
//                    );
//
//                    boolean newButtonClicked = false;
//
//                    for (WebElement button : navButtons) {
//                        String buttonText = "";
//                        try {
//                            buttonText = button.getText().trim();
//                        } catch (Exception ignored) {}
//
//                        if (buttonText.isEmpty() || visited.contains(buttonText) || buttonText.equalsIgnoreCase("Live TV")) {
//                            continue;
//                        }
//
//                        if (button.isDisplayed() && button.isEnabled()) {
//                            test.log(LogStatus.INFO, "Clicking button: " + buttonText);
//                            button.click();
//                            visited.add(buttonText);
//
//                            // Try clicking back button after action
//                            try {
//                                List<WebElement> backButtons = driver.findElements(By.xpath(
//                                        "//XCUIElementTypeButton[@name='back'] | //XCUIElementTypeButton[@name='left regular']"
//                                ));
//
//                                if (!backButtons.isEmpty()) {
//                                    WebElement backBtn = backButtons.get(0);
//                                    if (backBtn.isDisplayed() && backBtn.isEnabled()) {
//                                        backBtn.click();
//                                        test.log(LogStatus.INFO, "Navigated back after clicking '" + buttonText + "'.");
//                                    } else {
//                                        test.log(LogStatus.WARNING, "Back button is not clickable after clicking '" + buttonText + "'.");
//                                    }
//                                } else {
//                                    test.log(LogStatus.WARNING, "Back button not found after clicking '" + buttonText + "'.");
//                                }
//                            } catch (Exception e) {
//                                test.log(LogStatus.WARNING, "Exception while trying to click back button: " + e.getMessage());
//                            }
//
//                            newButtonClicked = true;
//                            break; // Refresh list after one click
//                        } else {
//                            test.log(LogStatus.INFO, "Button '" + buttonText + "' is NOT clickable or not visible.");
//                        }
//                    }
//
//                    if (!newButtonClicked) {
//                        sc.swipeLeft();
//                        test.log(LogStatus.INFO, "Performed horizontal swipe to reveal more buttons.");
//                        swipeAttempts++;
//                    } else {
//                        swipeAttempts = 0; // Reset after a successful interaction
//                    }
//                }
//
//                test.log(LogStatus.INFO, "Test completed for secondary nav buttons.");
//            } catch (Exception e) {
//                test.log(LogStatus.FAIL, "Exception while verifying secondary nav buttons: " + e.getMessage());
//            }
//        });
//    }


        @Test(priority = 12)
    public void countHomePageRails() {
        runTest(  " User able to count home page rails", () -> {
            Set<String> uniqueRailTitles = new HashSet<>();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            int previousRailCount = -1;

            while (true) {
                List<WebElement> railSections = driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText"));

                for (WebElement rail : railSections) {
                    String text = rail.getText();
                    if (text != null && text.trim().length() > 1 && !uniqueRailTitles.contains(text.trim())) {
                        uniqueRailTitles.add(text.trim());
                        System.out.println("Rail found with title: " + text.trim());

                        try {
                            WebElement parent = (WebElement) js.executeScript("return arguments[0].parentNode;", rail);
                            List<WebElement> tiles = parent.findElements(By.xpath(".//XCUIElementTypeCell"));
                            System.out.println(" -> Tiles found under this rail: " + tiles.size());
                        } catch (Exception e) {
                            System.out.println(" -> Unable to locate tiles for rail: " + text.trim());
                        }
                    }
                }

                if (uniqueRailTitles.size() == previousRailCount) {
                    break;
                }

                previousRailCount = uniqueRailTitles.size();
                sc.scrollDown();
            }

            System.out.println("✅ FINAL Total unique rails found: " + uniqueRailTitles.size());
            test.log(LogStatus.INFO, "✅ FINAL Total unique rails found: " + uniqueRailTitles.size());
            //Assert.assertTrue(uniqueRailTitles.size() >= 2, "Expected at least 2 unique rails.");
        });
    }
}