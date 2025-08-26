package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class RallyTvPage {
    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Rally TV\"]")
    WebElement Rally_TV;
    public WebElement Rally_TV(WebDriver driver){return Rally_TV;}

    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"back\"]")
    WebElement BackBtn;
    public WebElement BackBtn(WebDriver driver){return BackBtn;}

    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"searchClose\"]")
    WebElement searchClose;
    public WebElement searchClose(WebDriver driver){return searchClose;}

}

