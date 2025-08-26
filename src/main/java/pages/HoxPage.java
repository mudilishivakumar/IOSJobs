package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class HoxPage {
    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Boxing\"]")
    WebElement BoxingTab;
    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Home of Boxing\"]")
    WebElement HomeBoxing;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Upcoming Fights\"]")
    WebElement UpcomingFights;

    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"optionsCellButton_Latest_0\"]\n")
    WebElement video;
    @FindBy(xpath ="//XCUIElementTypeCell[@name=\"action_sheet_item_watchNow\"]")
    WebElement watchnow;
    @FindBy(xpath ="//XCUIElementTypeButton[@name=\"optionsCellButton_Latest_0\"]")
    WebElement ACL;

    @FindBy(xpath ="//XCUIElementTypeButton[@name=\"Cancel\"]\n")
    WebElement cancel;

    @FindBy(xpath ="//XCUIElementTypeImage[@name=\"share_icon\"]")
    WebElement share;

    @FindBy(xpath ="//XCUIElementTypeStaticText[@name=\"Follow\"]")
    WebElement follow;

    @FindBy(xpath ="//XCUIElementTypeImage[@name=\"like_unselected\"]")
    WebElement like;
    @FindBy(xpath ="//XCUIElementTypeButton[@name=\"navClose\"]")
    WebElement CLOSE;

    @FindBy(xpath ="//XCUIElementTypeStaticText[@name=\"Settings\"]\n")
    WebElement settings;

    @FindBy(xpath ="//XCUIElementTypeStaticText[@name=\"Live TV\"]")
    WebElement linear;

    @FindBy(xpath ="//XCUIElementTypeStaticText[@name=\"Women's Sports\"]\n")
    WebElement womensSports;
    @FindBy(xpath = "(//XCUIElementTypeButton[@name=\"Not Now\"])[1]")
    WebElement notnowone;

    public WebElement notnowone(WebDriver driver) {
        return (notnowone);
    }
    @FindBy(xpath="//XCUIElementTypeButton[@name=\"chromecastButton\"]\n")
    WebElement chromecast;
    @FindBy(xpath="//XCUIElementTypeOther[@name=\"sports_shortcuts_view\"]")
    WebElement secondarynav;
    public WebElement secondarynav(WebDriver driver){
        return(secondarynav);
    }

    public WebElement chromecast(WebDriver driver){
        return(chromecast);
    }


    public WebElement womensSports(WebDriver driver) {
        return (womensSports);
    }
    public WebElement ACL(WebDriver driver) {
        return (ACL);
    }
    public WebElement cancel(WebDriver driver) {
        return (cancel);
    }
    public WebElement settings(WebDriver driver) {
        return (settings);
    }
    public WebElement linear(WebDriver driver) {
        return (linear);
    }
    public WebElement CLOSE(WebDriver driver) {
        return (CLOSE);
    }
    public WebElement like(WebDriver driver) {
        return (like);
    }
    public WebElement follow(WebDriver driver) {
        return (follow);
    }
    public WebElement share(WebDriver driver) {
        return (share);
    }
    public WebElement watchnow(WebDriver driver) {
        return (watchnow);
    }
    public WebElement video(WebDriver driver) {
        return (video);
    }

    public WebElement HomeBoxing(WebDriver driver) {
        return (HomeBoxing);
    }

    public WebElement BoxingTab(WebDriver driver) {
        return (BoxingTab);
    }



}

