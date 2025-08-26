package testcases;

import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.MobileScrolling;
import pages.languagePageObjects;
import pages.profilepage;

public class languageSwitch extends BaseTest{
    profilepage up;
    MobileScrolling sc;
    languagePageObjects language;
    LandingPage RHP;
    @BeforeClass
    public void setupPage() {
        up = PageFactory.initElements(driver, profilepage.class);
        language=PageFactory.initElements(driver, languagePageObjects.class);
        RHP = PageFactory.initElements(driver, LandingPage.class);
        sc = new MobileScrolling(driver);
    }

    @Test(priority = 30)
    public void languageChange() {
        runTest("User click on languageChange Button", () -> {
            up.home(driver).click();
            up.userprofile(driver).click();
            captureScreenshot(driver);
            sc.scrollDown();
            sc.scrollDown();
            language.LanguageButton(driver).click();
            captureScreenshot(driver);

        });
    }
    @Test(priority = 31)
    public void selectlanguage() {
        runTest("User select  language", () -> {

            language.FrenchLanguage(driver).click();
            captureScreenshot(driver);
        });
    }
    @Test(priority = 32)
    public void verifyingLanguageChangeOrNot() {
        runTest("User verifyingLanguageChangeOrNot", () -> {
            String expectedLabel = "Accueil";

            WebElement inicioBtn = driver.findElement(
                    AppiumBy.accessibilityId("railsTabItem")
            );
            String actualLabel = inicioBtn.getAttribute("label").trim();

            test.log(LogStatus.INFO, "Expected Text: '" + expectedLabel + "'");
            test.log(LogStatus.INFO, "Actual Text:   '" + actualLabel + "'");

            if (expectedLabel.equals(actualLabel)) {
                test.log(LogStatus.PASS, "✅ Expected and Actual text MATCH.");
            } else {
                test.log(LogStatus.FAIL, "❌ Expected and Actual text DO NOT match.");
            }
        });
    }


    @Test(priority = 33)
    public void defaultlanguage() {
        runTest("User change default languageChange ", () -> {
            captureScreenshot(driver);
            RHP.notnowone(driver).click();
           // RHP.notnowone(driver).click();
            up.home(driver).click();
            up.userprofile(driver).click();
            captureScreenshot(driver);
            sc.scrollDown();
            sc.scrollDown();
            captureScreenshot(driver);
            language.LanguageButtonFrançais(driver).click();
            captureScreenshot(driver);
            language.EnglishLanguage(driver).click();
            captureScreenshot(driver);

        });
    }
}

