package testcases;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.appium.Eyes;
import com.applitools.eyes.selenium.ClassicRunner;
import io.appium.java_client.AppiumDriver;
public class EyesManager {

    private Eyes eyes;
    private EyesRunner runner;

    public EyesManager() {
        runner = new ClassicRunner(); // Required to fetch test results
        eyes = new Eyes(runner);
        eyes.setApiKey("9JOpZy1Nixh6mJyJUoGQMMQyydB109vceIX100ZRLl7iEqk110"); // hardcoded API key
    }

    public Eyes getEyes() {
        return eyes;
    }

    public void openEyes(AppiumDriver driver, String appName, String testName) {
        eyes.open(driver, appName, testName);
    }

    public void closeEyes() {
        eyes.closeAsync();
    }

    public void abortIfNotClosed() {
        eyes.abortIfNotClosed();
    }

    // ✅ Add this method to fetch and print the test result link
    public void printTestResultsUrl() {
        TestResultsSummary summary = runner.getAllTestResults(false); // false = no exceptions
        String url = summary.getAllResults()[0].getTestResults().getUrl();
        System.out.println("🔗 Applitools visual test result: " + url);
    }
}