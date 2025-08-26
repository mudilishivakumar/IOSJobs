//package testcases;
//
//
//import baseLibrary.Setup;
//import baseLibrary.utilles;
//import com.google.common.collect.ImmutableMap;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
//import io.appium.java_client.AppiumBy;
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.TouchAction;
//import io.appium.java_client.ios.IOSDriver;
//import io.appium.java_client.screenrecording.CanRecordScreen;
//import io.appium.java_client.touch.WaitOptions;
//import io.appium.java_client.touch.offset.PointOption;
//import org.openqa.selenium.*;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.Rectangle;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.Reporter;
//import org.testng.annotations.*;
//import pages.HomePage;
//import pages.HoxPage;
//import pages.LoginPageIos;
//import pages.MobileScrolling;
//
//
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.*;
//import java.net.MalformedURLException;
//import java.text.SimpleDateFormat;
//import java.time.Duration;
//import java.util.*;
//import java.io.IOException;
//import java.util.Base64;
//import java.util.List;
//
//public class LoginPageTestCases extends Setup {
//    public static String report1;
//
//    utilles utilities;
//
//    LoginPageIos RHP;
//    HomePage HOM;
//
//    HoxPage HO;
//    static ExtentTest test;
//    static ExtentReports report;
//    MobileScrolling sc;
//    private static Setup baseLibrary = new Setup();
//
//    public List<Map<String, String>> testResults = new ArrayList<>(); // Store test results
//
//
//    @BeforeSuite
//    public void appStarting() throws MalformedURLException {
//        Date d = new Date();
//        String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".html";
//        report1 = "Native Automation test report v2.42.3_" + fileName;
//        System.out.println(report1);
//        report = new ExtentReports(System.getProperty("user.dir") + "/" + report1);
//
//        Setup.initializeDriver("iOS");
//
//        driver = Setup.getDriver();
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//        sc = new MobileScrolling(driver);
//
//        RHP = PageFactory.initElements(driver, LoginPageIos.class);
//        HOM = PageFactory.initElements(driver, HomePage.class);
//        HO = PageFactory.initElements(driver, HoxPage.class);
//
//        utilities = new utilles(driver, test);
//
//        // Start Screen Recording
//        driver.startRecordingScreen();
//    }
//
//    @AfterSuite
//    public void generateReport() throws IOException {
//        // Stop Screen Recording
//        String video = driver.stopRecordingScreen();
//
//        // Create timestamp for the filename
//        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//
//        // Save recording to Project Directory with timestamp
//        File videoFile = new File(System.getProperty("user.dir") + "/ScreenRecording_" + timestamp + ".mp4");
//
//        try (FileOutputStream fos = new FileOutputStream(videoFile)) {
//            fos.write(Base64.getDecoder().decode(video));
//        }
//
//        System.out.println("Screen recording saved at: " + videoFile.getAbsolutePath());
//
//        report.flush();
//        printTestResults(); // Print the final test case summary
//
//        try {
//            sendMail.sendTestReportEmail(testResults, videoFile.getAbsolutePath());
//        } catch (Exception e) {
//            System.err.println("Failed to send the email.");
//            e.printStackTrace();
//        }
//    }
//
//    @Test(priority = 1)
//    public void launchApp() {
//        runTest("VIP-USER launch the app", () -> {
//            RHP.splashscreen(driver).isDisplayed();
//            captureScreenshot(driver);
//            RHP.splashscreen(driver).click();
//        });
//    }
////
////    @Test(priority = 2)
////    public void exploreButton() {
////        runTest("VIP-USER Click on Explore Button", () -> {
////            RHP.ExploreButton(driver).click();
////            Reporter.log("Click on Explore Button", true);
////        });
////    }
//
//    @Test(priority = 2)
//    public void signInButton() {
//        runTest("VIP-USER login-in Button", () -> {
//            RHP.login(driver).click();
//            Reporter.log("Clicked on login-in button", true);
//        });
//    }
//
//    @Test(priority = 4)
//    public void enterCredentials() {
//        runTest("VIP-USER Enters Username & Password", () -> {
//            WebElement usernameField = RHP.username(driver);
//            usernameField.sendKeys("abhilash.komara@dazn.com");
//            RHP.Nextbutton(driver).click();
//            captureScreenshot(driver);
//            WebElement passwordField = RHP.password(driver);
//            Assert.assertTrue(passwordField.isEnabled(), "Password input box is not clickable");
//            passwordField.sendKeys("Dazn@24");
//            captureScreenshot(driver);
//            Reporter.log("Entered username: abhilash.komara@dazn.com", true);
//            Reporter.log("Entered password: ********", true);
//        });
//    }
//
//    @Test(priority = 5)
//    public void loginButton() {
//        runTest("VIP-USER Login Button", () -> {
//            WebElement loginBtn = RHP.lgnBtn(driver);
//            loginBtn.click();
//            Reporter.log("Clicked on 'Login' button", true);
//            captureScreenshot(driver);
//        });
//    }
//
//    @Test(priority = 6)
//    public void homePageNotification() {
//        runTest("VIP-USER HomePage Notification", () -> {
//            try {
//                Thread.sleep(2000);
//                RHP.notnowone(driver).click();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//    }
//
//    @Test(priority = 7)
//    public void switchCountry() {
//        runTest("VIP-USER changes the country", () -> {
//            RHP.userprofile(driver).click();
//            sc.scrollDown();
//            RHP.location(driver).click();
//            RHP.searchcountry(driver).sendKeys("spain");
//            try {
//                Thread.sleep(1000); // Optional wait
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            RHP.countryname(driver).click();
//        });
//    }
//
//    @Test(priority = 8)
//    public void castIconValidation() {
//        runTest("VIP-USER Cast Icon Visibility", () -> {
//            try {
//                Thread.sleep(1000); // Optional wait
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//
//            RHP.notnowone(driver).click();
//
//            Assert.assertTrue(HOM.chromecast(driver).isDisplayed(), "Cast Icon is not visible");
//        });
//    }
//
//    @Test(priority = 9)
//    public void castingScreenActions() {
//        runTest("VIP-USER Casting Screen Actions", () -> {
//            HOM.chromecast(driver).click();
//            HO.settings(driver).isEnabled();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            HO.cancel(driver).click();
//        });
//    }
//
//
//
//    @Test(priority = 10)
//    public void homeRailsValidation() {
//        runTest("VIP-USER Spain region Secondary Navigation Visualization", () -> {
//            HOM.semov(driver).isDisplayed();
//        });
//    }
//
//    @Test(priority = 11)
//    public void countHomePageRails() {
//        runTest(  " User able to count home page rails spain", () -> {
//            Set<String> uniqueRailTitles = new HashSet<>();
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            int previousRailCount = -1;
//
//            while (true) {
//                List<WebElement> railSections = driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText"));
//
//                for (WebElement rail : railSections) {
//                    String text = rail.getText();
//                    if (text != null && text.trim().length() > 1 && !uniqueRailTitles.contains(text.trim())) {
//                        uniqueRailTitles.add(text.trim());
//                        System.out.println("Rail found with title: " + text.trim());
//
//                        try {
//                            WebElement parent = (WebElement) js.executeScript("return arguments[0].parentNode;", rail);
//                            List<WebElement> tiles = parent.findElements(By.xpath(".//XCUIElementTypeCell"));
//                            System.out.println(" -> Tiles found under this rail: " + tiles.size());
//                        } catch (Exception e) {
//                            System.out.println(" -> Unable to locate tiles for rail: " + text.trim());
//                        }
//                    }
//                }
//
//                if (uniqueRailTitles.size() == previousRailCount) {
//                    break;
//                }
//
//                previousRailCount = uniqueRailTitles.size();
//                sc.scrollDown();
//            }
//
//            System.out.println("✅ FINAL Total unique rails found: " + uniqueRailTitles.size());
//            test.log(LogStatus.INFO, "✅ FINAL Total unique rails found: " + uniqueRailTitles.size());
//            Assert.assertTrue(uniqueRailTitles.size() >= 2, "Expected at least 2 unique rails.");
//        });
//    }
//
//
//
//    @Test(priority = 12)
//    public void scheduleTab() {
//        runTest("VIP-USER Spain region Schedule", () -> {
//            HOM.scheduleTabItem(driver).isDisplayed();
//            HOM.scheduleTabItem(driver).click();
//            captureScreenshot(driver);
//        });
//    }
//
//    @Test(priority = 13)
//    public void sportsTab() {
//        runTest("VIP-USER Spain region Sports", () -> {
//            HOM.home(driver).click();
//            HOM.sportsTabItem(driver).click();
//            captureScreenshot(driver);
//        });
//    }
//    @Test(priority = 14)
//    public void sportsActions() {
//        runTest("User opens Spain region Sports Pages", () -> {
//            Set<String> visited = new HashSet<>();
//
//            Dimension screenSize = driver.manage().window().getSize();
//            int startX = screenSize.width / 2;
//            int startY = (int) (screenSize.height * 0.8);
//            int endY = (int) (screenSize.height * 0.2);
//
//            boolean keepScrolling = true;
//
//            while (keepScrolling) {
//                List<WebElement> cells = driver.findElements(By.xpath("//XCUIElementTypeCell[contains(@name, 'sportCell(row:')]"));
//                boolean foundNew = false;
//
//                for (WebElement cell : cells) {
//                    String name = cell.getAttribute("name");
//
//                    // Skip if already visited
//                    if (visited.contains(name)) {
//                        continue;
//                    }
//
//                    // Skip if this cell contains "Live TV" text
//                    List<WebElement> liveTvTexts = cell.findElements(By.xpath(".//XCUIElementTypeStaticText[@name='Live TV']"));
//                    if (!liveTvTexts.isEmpty()) {
//                        System.out.println("Skipping Live TV section: " + name);
//                        visited.add(name); // still mark it as visited to avoid re-processing
//                        continue;
//                    }
//
//                    visited.add(name);
//                    System.out.println("Clicking on: " + name);
//
//                    cell.click();
//
//                    // Wait for detail screen to load
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    // Click back button (handle both variations)
//                    try {
//                        captureScreenshot(driver);
//
//                        List<WebElement> backButtons = driver.findElements(By.xpath(
//                                "//XCUIElementTypeButton[@name=\"back\"] | //XCUIElementTypeButton[@name=\"left regular\"]"
//                        ));
//
//                        if (!backButtons.isEmpty()) {
//                            backButtons.get(0).click();
//                        } else {
//                            System.out.println("Back button not found!");
//                        }
//                    } catch (Exception e) {
//                        System.out.println("Error clicking back button: " + e.getMessage());
//                    }
//
//                    try {
//                        Thread.sleep(200); // Allow screen to transition back
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    foundNew = true;
//                    break; // After visiting one new item, restart loop to refresh the list
//                }
//
//                if (!foundNew) {
//                    sc.scrollDown();
//
//                    int previousCount = visited.size();
//
//                    // Wait for new elements to load
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    List<WebElement> newCells = driver.findElements(By.xpath("//XCUIElementTypeCell[contains(@name, 'sportCell(row:')]"));
//                    for (WebElement cell : newCells) {
//                        String name = cell.getAttribute("name");
//
//                        // Also skip "Live TV" cells while marking as visited to prevent endless scroll
//                        List<WebElement> liveTvTexts = cell.findElements(By.xpath(".//XCUIElementTypeStaticText[@name='Live TV']"));
//                        if (!liveTvTexts.isEmpty()) {
//                            visited.add(name);
//                        }
//                    }
//
//                    if (visited.size() == previousCount) {
//                        System.out.println("Visited all sport sections.");
//                        keepScrolling = false;
//                    }
//                }
//            }
//        });
//    }
//
//    @Test(priority =15)
//    public void switchCountry1() {
//        runTest("VIP-USER switch the country japan", () -> {
//
//            HOM.home(driver).click();
//
//            RHP.userprofile(driver).click();
//            sc.scrollDown();
//            RHP.location(driver).click();
//            RHP.searchcountry(driver).sendKeys("japan");
//            try {
//                Thread.sleep(1000); // Optional wait
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            RHP.countryname(driver).click();
//        });
//    }
//
//    @Test(priority = 16)
//    public void japanhomeRailsValidation() {
//        runTest("VIP-USER japan region Secondary Navigation Visualization", () -> {
//
//            RHP.notnowone(driver).click();
//
//            HOM.semov(driver).isDisplayed();
//        });
//    }
//
//    @Test(priority = 17)
//    public void japancountHomePageRails() {
//        runTest(  " User able to count home page rails japan", () -> {
//            Set<String> uniqueRailTitles = new HashSet<>();
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            int previousRailCount = -1;
//
//            while (true) {
//                List<WebElement> railSections = driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText"));
//
//                for (WebElement rail : railSections) {
//                    String text = rail.getText();
//                    if (text != null && text.trim().length() > 1 && !uniqueRailTitles.contains(text.trim())) {
//                        uniqueRailTitles.add(text.trim());
//                        System.out.println("Rail found with title: " + text.trim());
//
//                        try {
//                            WebElement parent = (WebElement) js.executeScript("return arguments[0].parentNode;", rail);
//                            List<WebElement> tiles = parent.findElements(By.xpath(".//XCUIElementTypeCell"));
//                            System.out.println(" -> Tiles found under this rail: " + tiles.size());
//                        } catch (Exception e) {
//                            System.out.println(" -> Unable to locate tiles for rail: " + text.trim());
//                        }
//                    }
//                }
//
//                if (uniqueRailTitles.size() == previousRailCount) {
//                    break;
//                }
//
//                previousRailCount = uniqueRailTitles.size();
//                sc.scrollDown();
//            }
//
//            System.out.println("✅ FINAL Total unique rails found: " + uniqueRailTitles.size());
//            test.log(LogStatus.INFO, "✅ FINAL Total unique rails found: " + uniqueRailTitles.size());
//            Assert.assertTrue(uniqueRailTitles.size() >= 2, "Expected at least 2 unique rails.");
//        });
//    }
//
//
//
//    @Test(priority = 18)
//    public void japanscheduleTab() {
//        runTest("VIP-USER japan region Schedule", () -> {
//            HOM.scheduleTabItem(driver).isDisplayed();
//            HOM.scheduleTabItem(driver).click();
//            captureScreenshot(driver);
//        });
//    }
//
//    @Test(priority = 19)
//    public void japansportsTab() {
//        runTest("VIP-USER japan region Sports", () -> {
//            HOM.home(driver).click();
//            HOM.sportsTabItem(driver).click();
//            captureScreenshot(driver);
//        });
//    }
//    @Test(priority = 20)
//    public void japamsportsActions() {
//        runTest("User opens japan region Sports Pages", () -> {
//            Set<String> visited = new HashSet<>();
//
//            Dimension screenSize = driver.manage().window().getSize();
//            int startX = screenSize.width / 2;
//            int startY = (int) (screenSize.height * 0.8);
//            int endY = (int) (screenSize.height * 0.2);
//
//            boolean keepScrolling = true;
//
//            while (keepScrolling) {
//                List<WebElement> cells = driver.findElements(By.xpath("//XCUIElementTypeCell[contains(@name, 'sportCell(row:')]"));
//                boolean foundNew = false;
//
//                for (WebElement cell : cells) {
//                    String name = cell.getAttribute("name");
//
//                    // Skip if already visited
//                    if (visited.contains(name)) {
//                        continue;
//                    }
//
//                    // Skip if this cell contains "Live TV" text
//                    List<WebElement> liveTvTexts = cell.findElements(By.xpath(".//XCUIElementTypeStaticText[@name='Live TV']"));
//                    if (!liveTvTexts.isEmpty()) {
//                        System.out.println("Skipping Live TV section: " + name);
//                        visited.add(name); // still mark it as visited to avoid re-processing
//                        continue;
//                    }
//
//                    visited.add(name);
//                    System.out.println("Clicking on: " + name);
//
//                    cell.click();
//
//                    // Wait for detail screen to load
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    // Click back button (handle both variations)
//                    try {
//                        captureScreenshot(driver);
//
//                        List<WebElement> backButtons = driver.findElements(By.xpath(
//                                "//XCUIElementTypeButton[@name=\"back\"] | //XCUIElementTypeButton[@name=\"left regular\"]"
//                        ));
//
//                        if (!backButtons.isEmpty()) {
//                            backButtons.get(0).click();
//                        } else {
//                            System.out.println("Back button not found!");
//                        }
//                    } catch (Exception e) {
//                        System.out.println("Error clicking back button: " + e.getMessage());
//                    }
//
//                    try {
//                        Thread.sleep(300); // Allow screen to transition back
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    foundNew = true;
//                    break; // After visiting one new item, restart loop to refresh the list
//                }
//
//                if (!foundNew) {
//                    sc.scrollDown();
//
//                    int previousCount = visited.size();
//
//                    // Wait for new elements to load
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    List<WebElement> newCells = driver.findElements(By.xpath("//XCUIElementTypeCell[contains(@name, 'sportCell(row:')]"));
//                    for (WebElement cell : newCells) {
//                        String name = cell.getAttribute("name");
//
//                        // Also skip "Live TV" cells while marking as visited to prevent endless scroll
//                        List<WebElement> liveTvTexts = cell.findElements(By.xpath(".//XCUIElementTypeStaticText[@name='Live TV']"));
//                        if (!liveTvTexts.isEmpty()) {
//                            visited.add(name);
//                        }
//                    }
//
//                    if (visited.size() == previousCount) {
//                        System.out.println("Visited all sport sections.");
//                        keepScrolling = false;
//                    }
//                }
//            }
//        });
//    }
//
//
//    @Test(priority =21)
//    public void switchCountryuk() {
//        runTest("VIP-USER switch the country uk", () -> {
//            HOM.home(driver).click();
//
//            RHP.userprofile(driver).click();
//            sc.scrollDown();
//            RHP.location(driver).click();
//            RHP.searchcountry(driver).sendKeys("united kingdom of Great Britain and nORTHERN ireland");
//            try {
//                Thread.sleep(1000); // Optional wait
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            RHP.countryname(driver).click();
//        });
//    }
//
//    @Test(priority =22)
//    public void ukhomeRailsValidation() {
//        runTest("VIP-USER uk region Secondary Navigation Visualization", () -> {
//            RHP.notnowone(driver).click();
//
//            HOM.semov(driver).isDisplayed();
//        });
//    }
//
//    @Test(priority =23)
//    public void ukcountHomePageRails() {
//        runTest("User able to count home page rails uk", () -> {
//            Set<String> uniqueRailTitles = new HashSet<>();
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            int previousRailCount = -1;
//
//            while (true) {
//                List<WebElement> railSections = driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText"));
//
//                for (WebElement rail : railSections) {
//                    String text = rail.getText();
//                    if (text != null && text.trim().length() > 1 && !uniqueRailTitles.contains(text.trim())) {
//                        uniqueRailTitles.add(text.trim());
//                        System.out.println("Rail found with title: " + text.trim());
//
//                        try {
//                            WebElement parent = (WebElement) js.executeScript("return arguments[0].parentNode;", rail);
//                            List<WebElement> tiles = parent.findElements(By.xpath(".//XCUIElementTypeCell"));
//                            System.out.println(" -> Tiles found under this rail: " + tiles.size());
//                        } catch (Exception e) {
//                            System.out.println(" -> Unable to locate tiles for rail: " + text.trim());
//                        }
//                    }
//                }
//
//                if (uniqueRailTitles.size() == previousRailCount) {
//                    break;
//                }
//
//                previousRailCount = uniqueRailTitles.size();
//                sc.scrollDown();
//            }
//
//            System.out.println("✅ FINAL Total unique rails found: " + uniqueRailTitles.size());
//            test.log(LogStatus.INFO, "✅ FINAL Total unique rails found: " + uniqueRailTitles.size());
//            Assert.assertTrue(uniqueRailTitles.size() >= 2, "Expected at least 2 unique rails.");
//        });
//    }
//
//
//
//    @Test(priority = 24)
//    public void ukscheduleTab() {
//        runTest("VIP-USER uk region Schedule", () -> {
//            HOM.scheduleTabItem(driver).isDisplayed();
//            HOM.scheduleTabItem(driver).click();
//            captureScreenshot(driver);
//        });
//    }
//
//    @Test(priority = 25)
//    public void uksportsTab() {
//        runTest("VIP-USER japan region Sports", () -> {
//            HOM.home(driver).click();
//            HOM.sportsTabItem(driver).click();
//            captureScreenshot(driver);
//        });
//    }
//    @Test(priority = 26)
//    public void uksportsActions() {
//        runTest("User opens uk region Sports Pages", () -> {
//            Set<String> visited = new HashSet<>();
//
//            Dimension screenSize = driver.manage().window().getSize();
//            int startX = screenSize.width / 2;
//            int startY = (int) (screenSize.height * 0.8);
//            int endY = (int) (screenSize.height * 0.2);
//
//            boolean keepScrolling = true;
//
//            while (keepScrolling) {
//                List<WebElement> cells = driver.findElements(By.xpath("//XCUIElementTypeCell[contains(@name, 'sportCell(row:')]"));
//                boolean foundNew = false;
//
//                for (WebElement cell : cells) {
//                    String name = cell.getAttribute("name");
//
//                    // Skip if already visited
//                    if (visited.contains(name)) {
//                        continue;
//                    }
//
//                    // Skip if this cell contains "Live TV" text
//                    List<WebElement> liveTvTexts = cell.findElements(By.xpath(".//XCUIElementTypeStaticText[@name='Live TV']"));
//                    if (!liveTvTexts.isEmpty()) {
//                        System.out.println("Skipping Live TV section: " + name);
//                        visited.add(name); // still mark it as visited to avoid re-processing
//                        continue;
//                    }
//
//                    visited.add(name);
//                    System.out.println("Clicking on: " + name);
//
//                    cell.click();
//
//                    // Wait for detail screen to load
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    // Click back button (handle both variations)
//                    try {
//                        captureScreenshot(driver);
//
//                        List<WebElement> backButtons = driver.findElements(By.xpath(
//                                "//XCUIElementTypeButton[@name=\"back\"] | //XCUIElementTypeButton[@name=\"left regular\"]"
//                        ));
//
//                        if (!backButtons.isEmpty()) {
//                            backButtons.get(0).click();
//                        } else {
//                            System.out.println("Back button not found!");
//                        }
//                    } catch (Exception e) {
//                        System.out.println("Error clicking back button: " + e.getMessage());
//                    }
//
//                    try {
//                        Thread.sleep(300); // Allow screen to transition back
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    foundNew = true;
//                    break; // After visiting one new item, restart loop to refresh the list
//                }
//
//                if (!foundNew) {
//                    sc.scrollDown();
//
//                    int previousCount = visited.size();
//
//                    // Wait for new elements to load
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    List<WebElement> newCells = driver.findElements(By.xpath("//XCUIElementTypeCell[contains(@name, 'sportCell(row:')]"));
//                    for (WebElement cell : newCells) {
//                        String name = cell.getAttribute("name");
//
//                        // Also skip "Live TV" cells while marking as visited to prevent endless scroll
//                        List<WebElement> liveTvTexts = cell.findElements(By.xpath(".//XCUIElementTypeStaticText[@name='Live TV']"));
//                        if (!liveTvTexts.isEmpty()) {
//                            visited.add(name);
//                        }
//                    }
//
//                    if (visited.size() == previousCount) {
//                        System.out.println("Visited all sport sections.");
//                        keepScrolling = false;
//                    }
//                }
//            }
//        });
//    }
//
//    @Test(priority = 27)
//    public void signOut() {
//        runTest("VIP-USER Sign Out", () -> {
//            HOM.home(driver).click();
//            RHP.userprofile(driver).click();
//            sc.scrollDown();
//            HOM.signOut(driver).click();
//            HOM.signOutConfirmation(driver).click();
//            captureScreenshot(driver);
//        });
//    }
//
//    @Test(priority = 28)
//    public void landingPage() {
//        runTest("USER User able to see landing Pages", () -> {
//            RHP.ExploreButton(driver).click();
//            captureScreenshot(driver);
//        });
//    }
//
//    public void runTest(String testCaseName, Runnable testLogic) {
//        test = report.startTest(testCaseName);
//        Map<String, String> result = new HashMap<>();
//        result.put("S.No", String.valueOf(testResults.size() + 1));
//        result.put("Test Case Name", testCaseName);
//
//        try {
//            testLogic.run();
//            test.log(LogStatus.PASS, testCaseName + " Passed");
//            result.put("Status", "PASS");
//        } catch (AssertionError | Exception e) {
//            test.log(LogStatus.FAIL, testCaseName + " Failed: " + e.getMessage());
//            result.put("Status", "FAIL");
//        }
//        testResults.add(result);
//    }
//
//    private void printTestResults() {
//        System.out.println("\nTest Case Report:");
//        System.out.println("+------+----------------------+--------+");
//        System.out.println("| S.No | Test Case Name       | Status |");
//        System.out.println("+------+----------------------+--------+");
//
//        for (Map<String, String> result : testResults) {
//            System.out.printf("| %-4s | %-20s | %-6s |\n",
//                    result.get("S.No"), result.get("Test Case Name"), result.get("Status"));
//        }
//
//        System.out.println("+------+----------------------+--------+");
//    }
//
//
//    public static void captureScreenshot(WebDriver driver) {
//        if (driver != null) {
//            if (driver instanceof TakesScreenshot) {
//                TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
//                try {
//                    // Capture screenshot as Base64
//                    String screenshotBase64 = screenshotDriver.getScreenshotAs(OutputType.BASE64);
//
//                    // Convert Base64 to BufferedImage
//                    byte[] imageBytes = Base64.getDecoder().decode(screenshotBase64);
//                    ByteArrayInputStream inputStream = new ByteArrayInputStream(imageBytes);
//                    BufferedImage originalImage = ImageIO.read(inputStream);
//
//                    // Resize the image (reduce width & height)
//                    int newWidth = originalImage.getWidth() / 2;  // Reduce by 50%
//                    int newHeight = originalImage.getHeight() / 2;
//
//                    Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
//                    BufferedImage resizedBufferedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
//
//                    Graphics2D g2d = resizedBufferedImage.createGraphics();
//                    g2d.drawImage(resizedImage, 0, 0, null);
//                    g2d.dispose();
//
//                    // Convert BufferedImage back to Base64
//                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//                    ImageIO.write(resizedBufferedImage, "png", outputStream);
//                    byte[] resizedImageBytes = outputStream.toByteArray();
//                    String resizedBase64 = Base64.getEncoder().encodeToString(resizedImageBytes);
//
//                    // Log the resized screenshot
//                    test.log(LogStatus.INFO, "Screenshot (Resized):",
//                            test.addBase64ScreenShot("data:image/png;base64," + resizedBase64));
//
//                } catch (Exception e) {
//                    System.err.println("Failed to capture and resize screenshot: " + e.getMessage());
//                }
//            } else {
//                System.err.println("Driver does not support screenshots.");
//            }
//        } else {
//            System.err.println("Driver is null, unable to capture screenshot.");
//        }
//    }
//
//    private void swipeLeft() {
//        Dimension size = driver.manage().window().getSize();
//        int startX = (int) (size.width * 0.8);
//        int endX = (int) (size.width * 0.2);
//        int y = (int) (size.height * 0.2); // Adjust to vertical center of nav bar
//
//        new TouchAction<>(driver)
//                .press(PointOption.point(startX, y))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(400)))
//                .moveTo(PointOption.point(endX, y))
//                .release()
//                .perform();
//    }
//
//    private boolean isRelevant(String name) {
//        // Add any filtering logic to exclude unrelated texts
//        return !name.isBlank() && !name.equalsIgnoreCase("Home");
//    }
//
//}