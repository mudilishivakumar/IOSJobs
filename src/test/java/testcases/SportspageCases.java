package testcases;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MobileScrolling;
import pages.SchedulePage;
import pages.Sportspage;
import pages.profilepage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SportspageCases extends BaseTest {

    Sportspage sportspage;
    MobileScrolling sc;
    profilepage up;

    @BeforeClass
    public void setupPage() {
        sportspage = PageFactory.initElements(driver, Sportspage.class);
        up = PageFactory.initElements(driver, profilepage.class);
        sc = new MobileScrolling(driver);

    }

    @Test(priority = 29)
    public void SportsTab() {
        runTest("user click on SportsTab", () -> {
            up.home(driver).click();
            sportspage.sportsTab(driver).click();
            captureScreenshot(driver);
            test.log(LogStatus.PASS, "User click SportsTab");

        });
    }}

//    @Test(priority = 30)
//    public void uksportsActions() {
//        runTest("User verify sports page actions", () -> {
//            Set<String> visited = new HashSet<>();
//            int scrollCount = 0;
//            int maxScrolls = 10; // Avoid infinite scroll
//
//            boolean keepScrolling = true;
//
//            while (keepScrolling && scrollCount < maxScrolls) {
//                List<WebElement> cells = driver.findElements(
//                        By.xpath("//XCUIElementTypeCell[contains(@name, 'sportCell(row:')]")
//                );
//
//                boolean foundNew = false;
//
//                for (WebElement cell : cells) {
//                    String name = cell.getAttribute("name");
//
//                    if (visited.contains(name)) {
//                        continue;
//                    }
//
//                    List<WebElement> liveTvTexts = cell.findElements(
//                            By.xpath(".//XCUIElementTypeStaticText[@name='Live TV']")
//                    );
//                    if (!liveTvTexts.isEmpty()) {
//                        visited.add(name);
//                        continue;
//                    }
//
//                    visited.add(name);
//                    System.out.println("Clicking on: " + name);
//                    cell.click();
//
//                    // Try to click back button
//                    try {
//                        captureScreenshot(driver);
//
//                        List<WebElement> backButtons = driver.findElements(
//                                By.xpath("//XCUIElementTypeButton[@name='back'] | //XCUIElementTypeButton[@name='left regular']")
//                        );
//
//                        if (!backButtons.isEmpty()) {
//                            backButtons.get(0).click();
//                        } else {
//                            System.out.println("Back button not found.");
//                        }
//
//                    } catch (Exception e) {
//                        System.out.println("Error navigating back: " + e.getMessage());
//                    }
//
//                    foundNew = true;
//                    break; // Process one new item per loop
//                }
//
//                if (!foundNew) {
//                    sc.scrollDown(); // Scroll to load more
//                    scrollCount++;
//                }
//            }
//
//            System.out.println("Completed sports section verification.");
//        });
//    }
//}

//        @Test(priority = 30)
//    public void uksportsActions() {
//        runTest("User verify sports page actions", () -> {
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
////                    // Wait for detail screen to load
////                    try {
////                        Thread.sleep(2000);
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
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
////                    try {
////                        Thread.sleep(300); // Allow screen to transition back
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
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
////                    try {
////                        Thread.sleep(1000);
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
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
//}
