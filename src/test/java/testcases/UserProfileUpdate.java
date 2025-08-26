package testcases;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MobileScrolling;
import pages.profilepage;

public class UserProfileUpdate extends BaseTest {
    profilepage up;
    MobileScrolling sc;

    @BeforeClass
    public void setupPage() {
        up = PageFactory.initElements(driver, profilepage.class);

        sc = new MobileScrolling(driver);
    }

    @Test(priority = 66)
    public void profileIcon(){
        runTest("Clicking on profile",()-> {
            up.userprofile(driver).click();
            test.log(LogStatus.PASS,"Clicked on the Profile");
            captureScreenshot(driver);
        });
    }

    @Test(priority = 67)
    public void DetailedProfiles(){
        runTest("Clicked on Detailed Profile",()-> {
            up.detailedProfile(driver).click();
            test.log(LogStatus.PASS,"Clicked on detailed TestCases");
            captureScreenshot(driver);
        });
    }
//    @Test(priority = 36)
//    public void ProfileBtnClick(){
//        runTest("Clicking on profile",()-> {
//            up.Profile(driver).click();
//            test.log(LogStatus.PASS,"Clicked on the Profile");
//            captureScreenshot(driver);
//        });
//    }
//
//    @Test(priority = 37)
//    public void DetailedProfileBtnClick(){
//        runTest("Clicked on Detailed Profile",()-> {
//            up.detailedProfile(driver).click();
//            test.log(LogStatus.PASS,"Clicked on detailed TestCases");
//            captureScreenshot(driver);
//        });
//    }

//    @Test(priority = 4)
//    public void NickNameBtn(){
//        runTest("Click on edit NickName",()->{
//            PD.NickName(driver).click();
//            test.log(LogStatus.PASS,"Clicked on the NickName Edit");
//        });
//    }
//
//    @Test(priority = 5)
//    public void NickNameChangeClick(){
//        runTest("Click on NickName Change",()->{
//            PD.NickNameChangeClick(driver).click();
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            PD.NickNameChangeClick(driver).sendKeys("Raghavaa");
//            test.log(LogStatus.PASS,"Clicked on Change NickName");
//        });
//    }
//
//    @Test(priority = 5)
//    public void NickNameSaveBtn(){
//        runTest("Click on NickName Save",()->{
//            PD.NickNameSave(driver).click();
//            test.log(LogStatus.PASS,"Clicked on Save Btn");
//        });
//    }

    @Test(priority = 68)
    public void AgeBtn(){
        runTest("Click on Age",()-> {
            up.Age(driver).click();
            test.log(LogStatus.PASS,"Clicked on Age");
            captureScreenshot(driver);
        });
    }

    @Test(priority = 69)
    public void AgeChangeBtn(){
        runTest("Click on Age",()-> {
            up.AgeChange(driver).click();
            test.log(LogStatus.PASS,"Clicked on Age");
            captureScreenshot(driver);
        });
    }


    @Test(priority = 70)
    public void AgeConfirmBtn(){
        runTest("Click on confirm",()-> {
            up.AgeConfirm(driver).click();
            test.log(LogStatus.PASS,"Clicked on Age Confirm Btn");
            captureScreenshot(driver);
        });
    }
    @Test(priority = 71)
    public void GenderBtn() throws InterruptedException {
        Thread.sleep(2000);
        runTest("Click on Gender",() ->{
            up.Gender(driver).click();
            test.log(LogStatus.PASS,"Clicked on Gender");
            captureScreenshot(driver);
        });
    }

    @Test(priority = 72)
    public void GenderChangeBtn(){
        runTest("Click on Gender",() ->{
            up.GenderChange(driver).click();
            test.log(LogStatus.PASS,"Clicked on Gender");
            captureScreenshot(driver);
        });
    }

    @Test(priority = 73)
    public void GenderConfirm(){
        runTest("Click on Gender Confirm",()->{
            up.GenderConfirm(driver).click();
            captureScreenshot(driver);
            test.log(LogStatus.PASS,"Clicked on GenderConfirm");
            captureScreenshot(driver);
        });
    }

    @Test(priority = 74)
    public void PhoneNumberBtn() throws InterruptedException {
        Thread.sleep(2000);
        runTest("Click on PhoneNumber",()->{

            captureScreenshot(driver);
            test.log(LogStatus.PASS,"Clicked on PhoneNumber");
        });
    }

    @Test(priority = 75)
    public void PhoneNumberChangeClick(){
        runTest("PhoneNumber update",()->{
            WebElement PhoneField = up.PhoneNumberClick(driver);
            PhoneField.click();

            for (int i = 0; i < 11; i++) {
                PhoneField.sendKeys(Keys.BACK_SPACE);
                captureScreenshot(driver);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            PhoneField.sendKeys("9553007248");
            captureScreenshot(driver);
            test.log(LogStatus.PASS,"User update PhoneNumber");
        });
    }

    @Test(priority = 76)
    public void NumberConfirmBtn() throws InterruptedException {
        Thread.sleep(1000);
        runTest("Clicked on Number Confirm",()->{
            captureScreenshot(driver);
            up.PhoneConfirm(driver).click();
            test.log(LogStatus.PASS,"Clicked on Number Confirm");
        });
    }

    @Test(priority = 77)
    public void InnerBackBtn() throws InterruptedException{
        Thread.sleep(2000);
        runTest("Click on Inner Back",()->{
            captureScreenshot(driver);
            up.InnerBackBtn(driver).click();
            test.log(LogStatus.PASS,"Clicked on Back Btn");
        });
    }
    @Test(priority = 78)
    public void OuterBackBtn() throws InterruptedException{
        Thread.sleep(2000);
        runTest("Click on Outer Back",()->{
            captureScreenshot(driver);
            up.OuterBackBtn(driver).click();
            test.log(LogStatus.PASS,"Clicked on Back Btn");
        });
    }

}
