package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class HomePage {
    @FindBy(xpath="//XCUIElementTypeCell[@name=\"videoTileCell_0_0\"]/XCUIElementTypeOther\n")
    WebElement rail1;

    @FindBy(xpath="//XCUIElementTypeButton[@name=\"threePPPaywallBackButton\"]")
    WebElement back;

    @FindBy(xpath="//XCUIElementTypeCollectionView[@name=\"railsCollectionView\"]/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage")
    WebElement heroBanner;

    @FindBy(xpath="//XCUIElementTypeButton[@name=\"button\"]")
    WebElement signOut;

    @FindBy(xpath="//XCUIElementTypeButton[@name=\"Log out\"]")
    WebElement signOutConfirmation;

    //XCUIElementTypeButton[@name="Log in"]
    @FindBy(name ="scheduleTabItem")
    WebElement scheduleTabItem;

    @FindBy(name="sportsTabItem")
    WebElement sportsTabItem;

    @FindBy(xpath="(//XCUIElementTypeLink[@name=\"footer\"])[1]")
    WebElement splayer;
//    @FindBy(xpath="//XCUIElementTypeOther[@name=“Allow”]")
//    WebElement Allow;

        @FindBy(xpath="//XCUIElementTypeButton[@name=\"Allow\"]")
        WebElement Allow;

//    @FindBy(xpath="//XCUIElementTypeButton[@name=\"Ask App Not to Track\"]")
//    WebElement Allow;

    @FindBy(xpath="//XCUIElementTypeButton[@name=\"railsTabItem\"]")
    WebElement home;

    @FindBy(xpath="(//XCUIElementTypeButton[@name=\"star\"]")
    WebElement star;

    @FindBy(xpath="//XCUIElementTypeStaticText[@name=\"Boxing\"]\n")
    WebElement seBoxing;

    @FindBy(name="back")
    WebElement error;
    @FindBy(xpath="//XCUIElementTypeStaticText[@name=\"FIFA Club World Cup\"]")
    WebElement FIFA;

    @FindBy(xpath="//XCUIElementTypeStaticText[@name=\"NFL Game Pass\"]")
    WebElement nfl;

    @FindBy(xpath=" //XCUIElementTypeTextField[@name=\"searchInput\"]")
    WebElement searchInput;

    @FindBy(xpath="//XCUIElementTypeOther[@name=\"sports_shortcuts_view\"]")
    WebElement semov;
    public WebElement semov(WebDriver driver){
        return(semov);
    }
    public WebElement searchInput(WebDriver driver){
        return(searchInput);
    }
    public WebElement nfl(WebDriver driver){
        return(nfl);
    }

    public WebElement FIFA(WebDriver driver){
        return(FIFA);
    }

    public WebElement error(WebDriver driver){
        return(error);
    }

    @FindBy(xpath="//XCUIElementTypeStaticText[@name=\"National League\"]")
    WebElement nationalleague;

    @FindBy(xpath="//XCUIElementTypeStaticText[@name=\"Channels\"]")
    WebElement Channels;

    @FindBy(xpath="//XCUIElementTypeStaticText[@name=\"UEFA Women's Champions League\"]")
    WebElement XSeries;

    @FindBy(xpath="//XCUIElementTypeButton[@name=\"searchButton\"]")
    WebElement search;

    @FindBy(xpath="//XCUIElementTypeButton[@name=\"buttonRestart\"]")
    WebElement restart;

    @FindBy(xpath="//XCUIElementTypeButton[@name=\"chromecastButton\"]\n")
    WebElement chromecast;

    @FindBy(xpath="//XCUIElementTypeButton[@name=\"Cancel\"]")
    WebElement cancel;



    public WebElement cancel(WebDriver driver){
        return(cancel);
    }
    public WebElement chromecast(WebDriver driver){
        return(chromecast);
    }
    public WebElement XSeries(WebDriver driver){
        return(XSeries);
    }
    public WebElement Channels(WebDriver driver){
        return(Channels);
    }
    public WebElement restart(WebDriver driver){
        return(restart);
    }

    public WebElement search(WebDriver driver){
        return(search);
    }

    public WebElement nationalleague(WebDriver driver){
        return(nationalleague);
    }



    public WebElement seBoxing(WebDriver driver){
        return(seBoxing);
    }
    public WebElement star(WebDriver driver){
        return(star);
    }

    public WebElement home(WebDriver driver){
        return(home);
    }
    public WebElement rail1(WebDriver driver){
        return(rail1);
    }



    public WebElement sportsTabItem(WebDriver driver){
        return(sportsTabItem);
    }

    public WebElement scheduleTabItem(WebDriver driver){
        return(scheduleTabItem);
    }

    public WebElement signOutConfirmation(WebDriver driver){
        return(signOutConfirmation);
    }

    public WebElement signOut(WebDriver driver){
        return(signOut);
    }

    public WebElement heroBanner(WebDriver driver){
        return(heroBanner);
    }

    public WebElement back(WebDriver driver){
        return(back);
    }
    public WebElement Allow(WebDriver driver){
        return(Allow);
    }
    @FindBy(xpath="//XCUIElementTypeCell[@name=\"videoTileCell_1_0\"]/XCUIElementTypeOther")
    WebElement rail2;
    // Locator for rail1 (adjust the locator as necessary)
    public WebElement rail2(WebDriver driver) {
        return (rail2);
    }





}
