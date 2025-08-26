package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class NassrTv {
    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Nassr TV\"]")
    WebElement Nassr_TV;
    public WebElement Nassr_TV(WebDriver driver){return Nassr_TV;}

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Home\"]")
    WebElement Home;
    public WebElement Home(WebDriver driver){return Home;}

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Match Highlights\"]")
    WebElement Nassr_TV_Match_Highlights;
    public WebElement Nassr_TV_Match_Highlights(WebDriver driver){return Nassr_TV_Match_Highlights;}

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Features\"]")
    WebElement Nassr_TV_Features;
    public WebElement Nassr_TV_Features(WebDriver driver){return Nassr_TV_Features;}

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Fixtures\"]")
    WebElement Nassr_TV_Fixtures;
    public WebElement Nassr_TV_Fixtures(WebDriver driver){return Nassr_TV_Fixtures;}

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Table\"]")
    WebElement Nassr_TV_Table;
    public WebElement Nassr_TV_Table(WebDriver driver){return Nassr_TV_Table;}

    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"back\"]")
    WebElement BackBtn;
    public WebElement BackBtn(WebDriver driver){return BackBtn;}

    @FindBy(xpath = "  //XCUIElementTypeButton[@name=\"searchClose\"]")
    WebElement SearchClose;
    public WebElement SearchClose(WebDriver driver){return SearchClose;}

}
