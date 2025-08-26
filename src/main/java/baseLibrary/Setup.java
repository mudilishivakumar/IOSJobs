package baseLibrary;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.stream.Collectors;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;


public class Setup {

    protected static IOSDriver driver;

    public static void initializeDriver (String platformName) throws MalformedURLException {
        if ("iOS".equalsIgnoreCase(platformName)) {
            System.out.println("Initializing iOS driver...");
            XCUITestOptions options = new XCUITestOptions();
            options.setPlatformName("iOS");
            options.setPlatformVersion("17.6.1");
            options.setDeviceName("iPad Pro");
            options.setAutomationName("XCUITest");
          //  options.setBundleId("com.dazn.theApp");
            options.setApp("/Users/shivakumar.mudili/Library/Developer/Xcode/DerivedData/DAZN-bfsglkpxoyaqqqdebodtxoirhjjw/Build/Products/Production-Debug-iphonesimulator/DAZN.app");

            options.setUdid("F501615E-554D-463C-B417-BA0AE5B4F2A9");

            options.setCapability("appium:recordScreen", true);

            options.setCapability("showIOSLog", true);
            options.setWdaLaunchTimeout(Duration.ofDays(200000));
            options.setCapability("autoAcceptAlerts", true);
            options.setCapability("autoDismissAlerts", false);
            URL url = new URL("http://localhost:4723/");
            driver = new IOSDriver(url, options);
        }
    }






    public static IOSDriver getDriver() {
        return driver;
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver quit successfully.");
        }
    }}

