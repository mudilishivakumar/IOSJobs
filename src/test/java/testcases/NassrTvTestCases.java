package testcases;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
public class NassrTvTestCases extends BaseTest{

        MobileScrolling sc;
        HobPage Hob;
        PlayerPages PL;
        NassrTv NTV;
        @BeforeClass
        public void setupPage() {
            NTV= PageFactory.initElements(driver, NassrTv.class);
            sc = new MobileScrolling(driver);
            PL = PageFactory.initElements(driver, PlayerPages.class);
            Hob = PageFactory.initElements(driver, HobPage.class);
        }
        @Test(priority = 54)
        public void SearchClick(){
            runTest("Click on Search",()->{
                PL.searchButton(driver).click();
                test.log(LogStatus.PASS,"Clicked on search");
            });
        }

        @Test(priority = 55)
        public void SearchBarClick(){
            runTest("Click on SearchBar to search",()->{
              PL.searchInput(driver).click();

                PL.searchInput(driver).sendKeys("Nassr TV");

                test.log(LogStatus.PASS,"Clicked on SearchBar and Type Nassr Tv");
            });
        }

        @Test(priority = 56)
        public void Nassr_tv_Click() throws InterruptedException {
            Thread.sleep(2000);
            runTest("Click on Banner",()->{
                NTV.Nassr_TV(driver).click();
                test.log(LogStatus.PASS,"Clicked on Banner");
            });
        }

        @Test(priority = 57)
        public void Nassr_TV_Home() throws InterruptedException {
            Thread.sleep(2000);
            runTest("Click on Nassr_TV Home and Scroll to end",()->{
                NTV.Home(driver).click();
                MobileScrolling scroller = new MobileScrolling(driver);
                scroller.scrollToEndIOS(driver);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                test.log(LogStatus.PASS,"Clicked on Nassr_TV Home and scroll to end");
            });
        }

//    @Test(priority = 17)
//    public void Nassr_TV_Overall(){
//        runTest("Click on every Elements in Nassr_TV and scroll",()->{
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            MobileScrolling scroller = new MobileScrolling(driver);
//            String[] pillNames = {
//                    "Match Highlights",
//                    "Features",
//                    "Fixtures",
//                    "Table",
//            };
//            for (String name : pillNames) {
//                String xpath = "//XCUIElementTypeStaticText[@name=\"" + name + "\"]";
//                scroller.scrollUntilElementVisible(driver, xpath);
//                WebElement pillElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
//                pillElement.click();
//                scroller.scrollToEndIOS(driver);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            test.log(LogStatus.PASS,"Clicked on Nassr_TV next pills  and Scrolled to the end");
//        });
//    }

        @Test(priority = 58)
        public void Nassr_TV_Match_Highlights() throws InterruptedException {
            Thread.sleep(2000);
            runTest("Click on Nassr_TV_Match_Highlights and Scroll to end",()->{
                NTV.Nassr_TV_Match_Highlights(driver).click();
                MobileScrolling scroller = new MobileScrolling(driver);
                scroller.scrollToEndIOS(driver);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                test.log(LogStatus.PASS,"Clicked on Nassr_TV_Match_Highlights and Scroll to end");
            });
        }

        @Test(priority = 59)
        public void Nassr_TV_Features() throws InterruptedException {
            Thread.sleep(2000);
            runTest("Click on Nassr_TV_Features and Scroll to end",()->{
                NTV.Nassr_TV_Features(driver).click();
                MobileScrolling scroller = new MobileScrolling(driver);
                scroller.scrollToEndIOS(driver);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                test.log(LogStatus.PASS,"Clicked on Nassr_TV_Features and Scroll to end");
            });
        }

//    @Test(priority = 35)
//    public void Nassr_TV_Fixtures() throws InterruptedException {
//        Thread.sleep(2000);
//        runTest("Click on Nassr_TV_Fixtures and Scroll to end",()->{
//            NTV.Nassr_TV_Fixtures(driver).click();
//            MobileScrolling scroller = new MobileScrolling(driver);
//            scroller.scrollToEndIOS(driver);
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            test.log(LogStatus.PASS,"Clicked on Nassr_TV_Fixtures and Scroll to end");
//        });
//    }

        @Test(priority = 60)
        public void Nassr_TV_Table() throws InterruptedException {
            Thread.sleep(2000);
            runTest("Click on Nassr_TV_Table and Scroll to end",()->{
                NTV.Nassr_TV_Table(driver).click();
                MobileScrolling scroller = new MobileScrolling(driver);
                scroller.scrollToEndIOS(driver);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                test.log(LogStatus.PASS,"Clicked on Nassr_TV_Table and Scroll to end");
            });
        }

        @Test(priority = 61)
        public void BackBtn(){
            runTest("Click on Back",()->{
                NTV.BackBtn(driver).click();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                NTV.BackBtn(driver).click();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                NTV.SearchClose(driver).click();
                test.log(LogStatus.PASS,"Click on Back");
            });
        }

    }

