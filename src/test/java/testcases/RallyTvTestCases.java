package testcases;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
public class RallyTvTestCases extends BaseTest{
    MobileScrolling sc;
    HobPage Hob;
    PlayerPages PL;
    RallyTvPage RTV;
    @BeforeClass
    public void setupPage() {
        RTV= PageFactory.initElements(driver, RallyTvPage.class);
        sc = new MobileScrolling(driver);
        PL = PageFactory.initElements(driver, PlayerPages.class);
        Hob = PageFactory.initElements(driver, HobPage.class);
    }
    @Test(priority = 62)
    public void SearchClick(){
        runTest("Click on Search",()->{
            PL.searchButton(driver).click();
            test.log(LogStatus.PASS,"Clicked on search");
        });
    }

    @Test(priority = 63)
    public void SearchBarClick(){
        runTest("Click on SearchBar to search",()->{
            PL.searchInput(driver).click();
            PL.searchInput(driver).click();

            PL.searchInput(driver).sendKeys("Rally TV");

        });
    }

    @Test(priority = 64)
    public void Rally_TV_Click() throws InterruptedException {
        Thread.sleep(2000);
        runTest("Click on Rally_TV and Scroll to end",()->{
            RTV.Rally_TV(driver).click();
            MobileScrolling scroller = new MobileScrolling(driver);
            scroller.scrollToEndIOS(driver);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            test.log(LogStatus.PASS,"Clicked on Rally_TV and Scroll to end");
        });
    }

    @Test(priority = 65)
    public void Rally_TV_BackBtn(){
        runTest("Click on Back",()->{
            RTV.BackBtn(driver).click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Hob.searchClose(driver).click();
            test.log(LogStatus.PASS,"Click on Back");
        });
    }



}

