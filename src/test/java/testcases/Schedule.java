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
import pages.HoxPage;
import pages.MobileScrolling;
import pages.SchedulePage;

import java.time.Duration;

public class Schedule extends BaseTest{

    SchedulePage sp;
    MobileScrolling sc;

    @BeforeClass
    public void setupPage() {
        sp = PageFactory.initElements(driver, SchedulePage.class);
        sc = new MobileScrolling(driver);

    }

    @Test(priority = 27)
    public void ScheduleTab(){
        runTest("user click on ScheduleTab", () -> {
            sp.scheduleTabItem(driver).click();
            captureScreenshot(driver);
            int numberOfScrolls = 8; // Define the number of times to perform the scroll
            double dragCoefficient = 0.9;
            double dragStep = 0.001;

            for (int i = 0; i < numberOfScrolls; i++) {
                sc.drag(dragCoefficient, dragStep);

                captureScreenshot(driver);
                test.log(LogStatus.PASS, "User click ScheduleTab");

            }  });
        }}
//    @Test(priority = 28)
//    public void ScheduleSports(){
//        runTest("User able to clicking the ScheduleSports pills", () -> {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            MobileScrolling scroller = new MobileScrolling(driver);
//            String railXpath = "//XCUIElementTypeOther[@name=\"DAZN | Schedule\"]/XCUIElementTypeOther";
//            String[] tabXPaths = {
//                    //XCUIElementTypeSwitch
//                    "//XCUIElementTypeStaticText[@name=\"All Sports\"]",
//                    "//XCUIElementTypeStaticText[@name=\"Boxing\"]",
//                    "//XCUIElementTypeStaticText[@name=\"FIFA Club World Cup™\"]",
//                    "//XCUIElementTypeStaticText[@name=\"NFL Game Pass\"]",
//                    "//XCUIElementTypeStaticText[@name=\"National League\"]",
////                    "//XCUIElementTypeStaticText[@name=\"Women's Football\"]",
//                    "//XCUIElementTypeStaticText[@name=\"MMA\"]",
//                    "//XCUIElementTypeStaticText[@name=\"X Series\"]",
//                    "//XCUIElementTypeStaticText[@name=\"Golf\"]",
//                    "//XCUIElementTypeStaticText[@name=\"ELF\"]",
////                    "//XCUIElementTypeStaticText[@name=\"Courtside 1891\"]",
//                    "//XCUIElementTypeStaticText[@name=\"Football\"]",
//                    "//XCUIElementTypeStaticText[@name=\"Rally TV\"]",
//                    "//XCUIElementTypeStaticText[@name=\"Nassr TV\"]",
//                    "//XCUIElementTypeStaticText[@name=\"Extreme Sports\"]",
//                    "//XCUIElementTypeStaticText[@name=\"Chess\"]",
//                    "//XCUIElementTypeStaticText[@name=\"American Football\"]",
//                    "//XCUIElementTypeStaticText[@name=\"Snooker\"]",
//                    "//XCUIElementTypeStaticText[@name=\"Basketball\"]",
//                    "//XCUIElementTypeStaticText[@name=\"Live TV\"]",
//                    "//XCUIElementTypeStaticText[@name=\"Baseball\"]",
//                    "//XCUIElementTypeStaticText[@name=\"Motorsport\"]",
//                    "//XCUIElementTypeStaticText[@name=\"Triathlon\"]",
//                    "//XCUIElementTypeStaticText[@name=\"BKFC\"]",
//                    "//XCUIElementTypeStaticText[@name=\"Tennis\"]",
//                    "//XCUIElementTypeStaticText[@name=\"Kickboxing\"]",
//                    "//XCUIElementTypeStaticText[@name=\"Equestrian\"]",
//                    "//XCUIElementTypeStaticText[@name=\"Volleyball\"]",
//                    "//XCUIElementTypeStaticText[@name=\"Sport Entertainment\"]",
//                    "//XCUIElementTypeStaticText[@name=\"Basketball 3x3\"]"
//            };
//            for (int i = 0; i < tabXPaths.length; i++) {
//                try {
//                    WebElement tabButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tabXPaths[i])));
//                    tabButton.click();
//                    Reporter.log("Clicked on tab index " + i, true);
//
//                    // Record initial element for scroll comparison
//                    WebElement firstCardBeforeScroll = driver.findElement(By.xpath("(//XCUIElementTypeCell)[1]"));
//                    int initialY = firstCardBeforeScroll.getLocation().getY();
//                    int numberOfScrolls = 6; // Define the number of times to perform the scroll
//                    double dragCoefficient = 0.9;
//                    double dragStep = 0.001;
//
//
//                        sc.drag(dragCoefficient, dragStep);
//
//                    scroller.swipeDown();
//                    Thread.sleep(1500);
//                    sc.drag(dragCoefficient, dragStep);
//                    Thread.sleep(1500);
//                    scroller.scrollDown(); // fallback small scroll
//
//                    WebElement firstCardAfterScroll = driver.findElement(By.xpath("(//XCUIElementTypeCell)[1]"));
//                    int finalY = firstCardAfterScroll.getLocation().getY();
//
//                    if (initialY == finalY) {
//                        Reporter.log("No scroll detected for tab index " + i, true);
//                    } else {
//                        Reporter.log("Scroll successful for tab index " + i, true);
//                    }
//
//                    Thread.sleep(1500);
//                    scroller.swipeDown();
//                    scroller.scrollDown();
//                    Thread.sleep(1500);
//
//                    if (i < tabXPaths.length - 1) {
//                        WebElement railElement = driver.findElement(By.xpath(railXpath));
//                        sc.swipeHorizontally(railElement, true);
//                        Thread.sleep(2000);
//                    }
//
//                } catch (Exception e) {
//                    Reporter.log("Error at tab index " + i + ": " + e.getMessage(), true);
//                }
//            }
//
//            Reporter.log("Finished all AllSports tabs scroll checks.", true);
//        });
//    }
//    }


