package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class HobPage {
    @FindBy(xpath="//XCUIElementTypeStaticText[@name=\"Boxing\"]")
    WebElement Hob;
    public WebElement Hob(WebDriver driver){
        return(Hob);
    }

    @FindBy(xpath="//XCUIElementTypeStaticText[@name=\"Home\"]")
    WebElement Home;
    public WebElement Home(WebDriver driver){
        return(Home);
    }

    public WebElement UpcomingFights(WebDriver driver){
        return(UpcomingFights);
    }
    @FindBy(xpath="//XCUIElementTypeStaticText[@name=\"Upcoming Fights\"]")
    WebElement UpcomingFights;

    @FindBy(xpath="//XCUIElementTypeStaticText[@name=\"Previous Events\"]\n")
    WebElement PreviousEvents;
    public WebElement PreviousEvents(WebDriver driver){
        return(PreviousEvents);
    }

    public WebElement Fighters(WebDriver driver){
        return(Fighters);
    }
    @FindBy(xpath="//XCUIElementTypeStaticText[@name=\"Fighters\"]")
    WebElement Fighters;
    @FindBy(xpath="//XCUIElementTypeStaticText[@name=\"Social\"]")
    WebElement Social;

    public WebElement Social(WebDriver driver){
        return(Social);
    }
    @FindBy(xpath="//XCUIElementTypeStaticText[@name=\"Shows\"]")
    WebElement Shows;
    public WebElement Shows(WebDriver driver){
        return(Shows);
    }
    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Rankings\"]")
    WebElement Rankings;
    public WebElement Rankings(WebDriver driver){return Rankings;}
    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"back\"]")
    WebElement Back;
    public WebElement Back(WebDriver driver){return Back;}

    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"searchClose\"]")
    WebElement searchClose;
    public WebElement searchClose(WebDriver driver){return searchClose;}
}
