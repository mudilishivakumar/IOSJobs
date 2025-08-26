package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class NflPage {
    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"sportsTabItem\"]")
    WebElement Sports;
    public WebElement Sports(WebDriver driver){return Sports;}
    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"NFL Game Pass\"]")
    WebElement NFL_Game_Pass;
    public WebElement NFL_Game_Pass(WebDriver driver){return NFL_Game_Pass;}

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Home\"]")
    WebElement NFL_Home;
    public WebElement NFL_Home(WebDriver driver){return NFL_Home;}

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Schedule\"]")
    WebElement Schedule;
    public WebElement Schedule(WebDriver driver){return Schedule;}

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Games\"]")
    WebElement Games;
    public WebElement Games(WebDriver driver){return Games;}

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"NFL Network\"]")
    WebElement NFL_Network;
    public WebElement NFL_Network(WebDriver driver){return NFL_Network;}

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Teams\"]")
    WebElement NFL_Game_Pass_Teams;
    public WebElement NFL_Game_Pass_Teams(WebDriver driver){return NFL_Game_Pass_Teams;}

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Standings\"]")
    WebElement Standings;
    public WebElement Standings(WebDriver driver){return Standings;}

    @FindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"NFL Originals\"])[2]")
    WebElement NFL_Originals;
    public WebElement NFL_Originals(WebDriver driver){return NFL_Originals;}
    @FindBy(xpath="//XCUIElementTypeStaticText[@name=\"NFL\"]")
    WebElement NFL;
    public WebElement NFL(WebDriver driver){
        return(NFL);
    }

}

