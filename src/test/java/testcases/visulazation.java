package testcases;

import com.applitools.eyes.appium.Eyes;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HoxPage;
import pages.LandingPage;
import pages.MobileScrolling;

public class visulazation extends BaseTest {
    LandingPage RHP;
    HomePage HOM;
    MobileScrolling sc;
    HoxPage HO;
    EyesManager eyesManager;
    Eyes eyes;
    @BeforeClass
    public void setupPage() {
        RHP = PageFactory.initElements(driver, LandingPage.class);
        HOM = PageFactory.initElements(driver, HomePage.class);

        sc = new MobileScrolling(driver);
        eyesManager = new EyesManager();
        eyes = eyesManager.getEyes();
    }

    @Test(priority = 1)
    public void testLoginFlowWithEyes() {
        runTest("launch app", () -> {

            eyesManager.openEyes(driver, "DAZN App", "Login Flow");

        eyes.checkWindow("Splash Screen");
        RHP.splashscreen(driver).click();

        eyes.checkWindow("Login Button");
        RHP.login(driver).click();

        eyes.checkWindow("Enter Email");
        RHP.username(driver).sendKeys("test27@uat.com");
        RHP.Nextbutton(driver).click();

        eyes.checkWindow("Enter Password");
        RHP.password(driver).sendKeys("Test@27");
        RHP.loginButton(driver).click();

        eyes.checkWindow("Home Screen");

        eyesManager.closeEyes();
    });
    }
    @AfterClass
    public void teardownEyes() {
        eyesManager.abortIfNotClosed();
        eyesManager.printTestResultsUrl();
    }
}