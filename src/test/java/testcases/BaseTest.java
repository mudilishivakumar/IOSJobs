package testcases;


import baseLibrary.Setup;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSStartScreenRecordingOptions;
import io.appium.java_client.screenrecording.BaseStartScreenRecordingOptions;
import org.openqa.selenium.*;

import org.testng.annotations.*;

import java.io.*;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

public class BaseTest extends Setup {
    protected static ExtentReports report;
    public static String report1;
    protected static ExtentTest test;
    protected static String reportFileName;
  //  public List<Map<String, String>> testResults = new ArrayList<>();

    public static List<Map<String, String>> testResults = new ArrayList<>();

    protected static IOSDriver driver;
    @BeforeSuite
    public void globalSetup() throws MalformedURLException {
        Date d = new Date();
        String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".html";
        report1 = "Native Automation ios test report ios/production/v2.44.8/#202507072133 _" + fileName;
        System.out.println(report1);
        report = new ExtentReports(System.getProperty("user.dir") + "/" + report1);

        Setup.initializeDriver("iOS");

        driver = Setup.getDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));


    }



    @AfterSuite
    public void globalTearDown() throws IOException {

        report.flush();
        printTestResults(); // Print the final test case summary

        try {
           // sendMail.sendTestReportEmail(testResults, videoFile.getAbsolutePath());
            sendMail.sendTestReportEmail(testResults);
        } catch (Exception e) {
            System.err.println("Failed to send the email.");
            e.printStackTrace();
        }
    }


        protected void runTest(String testCaseName, Runnable logic) {
        test = report.startTest(testCaseName);
        Map<String, String> result = new HashMap<>();
        result.put("S.No", String.valueOf(testResults.size() + 1));
        result.put("Test Case Name", testCaseName);

        try {
            logic.run();
            test.log(LogStatus.PASS, testCaseName + " Passed");
            result.put("Status", "PASS");
        } catch (Exception | AssertionError e) {
            test.log(LogStatus.FAIL, testCaseName + " Failed: " + e.getMessage());
            result.put("Status", "FAIL");
        }

        testResults.add(result);
    }

    private void printTestResults() {
        System.out.println("\nTest Case Summary:");
        System.out.println("+------+----------------------------+--------+");
        System.out.println("| S.No | Test Case Name            | Status |");
        System.out.println("+------+----------------------------+--------+");

        for (Map<String, String> result : testResults) {
            System.out.printf("| %-4s | %-26s | %-6s |\n",
                    result.get("S.No"), result.get("Test Case Name"), result.get("Status"));
        }

        System.out.println("+------+----------------------------+--------+");
    }

    protected void captureScreenshot(WebDriver driver) {
        ScreenshotUtil.captureAndResize(driver, test);
    }
}

