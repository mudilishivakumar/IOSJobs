package testcases;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MobileScrolling;
import pages.profilepage;

public class Profilecases extends BaseTest{
profilepage up;
    MobileScrolling sc;

    @BeforeClass
    public void setupPage() {
        up = PageFactory.initElements(driver, profilepage.class);

        sc = new MobileScrolling(driver);
    }

        @Test(priority = 79)
    public void signOut() {
        runTest("USER Sign Out", () -> {
            up.home(driver).click();
            up.userprofile(driver).click();
            captureScreenshot(driver);
            test.log(LogStatus.PASS, "User click userprofile icon");
            sc.scrollDown();
            up.signOut(driver).click();
            captureScreenshot(driver);
            test.log(LogStatus.PASS, "User click signOut");
            up.signOutConfirmation(driver).click();
            captureScreenshot(driver);
            test.log(LogStatus.PASS, "User click signOutConfirmation button");

        });
    }
}
