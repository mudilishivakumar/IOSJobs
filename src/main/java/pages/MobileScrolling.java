package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static io.appium.java_client.touch.offset.PointOption.point;

public class MobileScrolling {
    protected static IOSDriver driver;

    // Constructor to inject the Appium driver
    public MobileScrolling(IOSDriver driver) {
        this.driver = driver;
    }


    public void scrollDown() {
        Map<String, String> args = new HashMap<>();
        args.put("direction", "down");
        driver.executeScript("mobile: scroll", args);

    }

    public void swipeLeft() {
        Map<String, String> args = new HashMap<>();
        args.put("direction", "right");
        driver.executeScript("mobile: scroll", args);

    }
    public void horizontalSwipeOnElement(WebElement element) {
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "right"); // or "right" if needed
        params.put("element", ((RemoteWebElement) element).getId());

        ((JavascriptExecutor) driver).executeScript("mobile: swipe", params);
    }
//    public void swipeLeft() {
//        Dimension size = driver.manage().window().getSize();
//        int startX = (int) (size.width * 0.8);
//        int endX = (int) (size.width * 0.2);
//        int y = (int) (size.height * 0.3);
//
//        new TouchAction(driver)
//                .press(PointOption.point(startX, y))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
//                .moveTo(PointOption.point(endX, y))
//                .release()
//                .perform();
//    }

    public void drag(double scrollPercentageStart, double scrollPercentageEnd) {
        Dimension size = driver.manage().window().getSize();
        System.out.println("Screen Size: " + size);

        int x = size.getWidth() / 2;
        int starty = (int) (size.getHeight() * scrollPercentageStart);
        System.out.println("Start Y: " + starty);

        int endy = (int) (size.getHeight() * scrollPercentageEnd);
        System.out.println("End Y: " + endy);

        // Ensure starty and endy are within valid range
        starty = Math.max(0, Math.min(starty, size.getHeight()));
        endy = Math.max(0, Math.min(endy, size.getHeight()));

        System.out.println("Adjusted Start Y: " + starty);
        System.out.println("Adjusted End Y: " + endy);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, starty))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(2000), PointerInput.Origin.viewport(), x, endy))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(swipe));
    }

    public void scrollToEndIOS(AppiumDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        boolean canScrollMore = true;
        int maxScrolls = 8;
        int scrollCount = 0;

        while (canScrollMore && scrollCount < maxScrolls) {
            try {
                PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                Sequence swipe = new Sequence(finger, 1);
                swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
                swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), startX, endY));
                swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
                driver.perform(Collections.singletonList(swipe));
                scrollCount++;
            } catch (Exception e) {
                canScrollMore = false;
            }
        }
    }
    public void swipeDown() {
        // Get screen dimensions
        int screenWidth = driver.manage().window().getSize().getWidth();
        int screenHeight = driver.manage().window().getSize().getHeight();

        // Swipe from top to bottom (adjust for your use case)
        int startX = screenWidth / 2;
        int startY = screenHeight / 4;
        int endY = screenHeight * 3 / 4;

        // Perform swipe action
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), startX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(swipe));  // Execute the swipe
    }


    public void scrollDownUntilElementClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Keep scrolling until the element is clickable
        while (true) {
            try {
                // Check if the element is clickable
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

                // If the element is clickable, break the loop and stop scrolling
                if (element.isDisplayed() && element.isEnabled()) {
                    System.out.println("Element is clickable: " + locator);
                    element.click();  // Optionally, you can click it directly here
                    break;
                }
            } catch (Exception e) {
                // Scroll down if element is not clickable yet
                System.out.println("Element not clickable yet, scrolling down...");
                scrollDown();
            }
        }
    }

    //    public void performSwipe(WebElement element, int minSwipes, int maxSwipes) {
//        int startX = element.getLocation().getX() + (int) (element.getSize().getWidth() * 0.9); // Start further right
//        int startY = element.getLocation().getY() + (element.getSize().getHeight() / 2);
//        int endX = element.getLocation().getX() + (int) (element.getSize().getWidth() * 0.1); // Swipe further left
//        int endY = startY;
//
//
//        // Generate a random number of swipes between minSwipes and maxSwipes
//        int totalSwipes = minSwipes + (int) (Math.random() * ((maxSwipes - minSwipes) + 1));
//
//        for (int i = 0; i < totalSwipes; i++) {
//            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//            Sequence swipe = new Sequence(finger, 1);
//            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
//            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endX, endY));
//            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//
//            driver.perform(Collections.singletonList(swipe));
//        }
//        System.out.println("Performed " + totalSwipes + " swipes.");
//    }
    public void performSwipe(WebElement element, String targetElementXpath, int minSwipes, int maxSwipes, boolean isVertical) {
        int startX, startY, endX, endY;

        if (isVertical) {
            // Vertical swipe logic
            startX = element.getLocation().getX() + (element.getSize().getWidth() / 2);
            startY = element.getLocation().getY() + (int) (element.getSize().getHeight() * 0.8);  // Start near bottom
            endX = startX;
            endY = element.getLocation().getY() + (int) (element.getSize().getHeight() * 0.2);    // Swipe upward
        } else {
            // Horizontal swipe logic
            startX = element.getLocation().getX() + (int) (element.getSize().getWidth() * 0.9);
            startY = element.getLocation().getY() + (element.getSize().getHeight() / 2);
            endX = element.getLocation().getX() + (int) (element.getSize().getWidth() * 0.1);
            endY = startY;
        }

        int totalSwipes = minSwipes + (int) (Math.random() * ((maxSwipes - minSwipes) + 1));

        for (int i = 0; i < totalSwipes; i++) {
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1);

            swipe.addAction(finger.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), startX, startY));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), endX, endY));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Collections.singletonList(swipe));

            // Check for visibility of the target element
            try {
                WebElement targetElement = driver.findElement(By.xpath(targetElementXpath));
                if (targetElement.isDisplayed()) {
                    System.out.println("Element found, stopping swipe.");
                    break;
                }
            } catch (NoSuchElementException e) {
                System.out.println("Target element not yet visible, continuing swipe...");
            }
        }
        System.out.println("Performed " + totalSwipes + " swipes.");
    }


    public void performSwipeBack(WebElement element, int minSwipes, int maxSwipes) {
        int startX = element.getLocation().getX() + (int) (element.getSize().getWidth() * 0.1); // Start from left
        int startY = element.getLocation().getY() + (element.getSize().getHeight() / 2);
        int endX = element.getLocation().getX() + (int) (element.getSize().getWidth() * 0.9); // Swipe to right
        int endY = startY;

        // Generate a random number of swipes between minSwipes and maxSwipes
        int totalSwipes = minSwipes + (int) (Math.random() * ((maxSwipes - minSwipes) + 1));

        for (int i = 0; i < totalSwipes; i++) {
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endX, endY));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Collections.singletonList(swipe));
        }
        System.out.println("Performed " + totalSwipes + " swipes backward.");
    }




//    public void scrollup() {
//        Map<String, Object> args = new HashMap<>();
//        args.put("direction", "up");
//        driver.executeScript("mobile: swipe", args);
//    }}
// Scroll Up Until Element is Visible
//    public void scrollUpUntilElementVisible(By locator) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        // Attempt to find the element initially
//        WebElement element = null;
//
//        try {
//            // Loop until the element is visible or a timeout occurs
//            while (element == null) {
//                try {
//                    // Try to find the element
//                    element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//                    System.out.println("Element found");
//                    break; // Exit if the element is found
//                } catch (Exception e) {
//                    // If element is not visible, scroll up
//                    System.out.println("Element not found, scrolling up...");
//                    scrollUp();
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Element not found after scrolling");
//        }
//    }
//}
public void swipeHorizontally(WebElement element, boolean isLeft) {
    int startX, endX, y;
    int width = element.getSize().getWidth();
    int height = element.getSize().getHeight();
    int elementX = element.getLocation().getX();
    int elementY = element.getLocation().getY();

    y = elementY + (height / 2);
    if (isLeft) {
        startX = elementX + (int) (width * 0.9);
        endX = elementX + (int) (width * 0.1);
    } else {
        startX = elementX + (int) (width * 0.1);
        endX = elementX + (int) (width * 0.9);
    }

    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    Sequence swipe = new Sequence(finger, 1)
            .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, y))
            .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
            .addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endX, y))
            .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(Collections.singletonList(swipe));
}}