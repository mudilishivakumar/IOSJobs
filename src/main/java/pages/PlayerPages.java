package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlayerPages {

    @FindBy(xpath="//XCUIElementTypeButton[@name=\"searchButton\"]")
    WebElement searchButton;

    @FindBy(xpath="//XCUIElementTypeTextField[@name=\"searchInput\"]")
    WebElement searchInput;

    @FindBy(xpath="//XCUIElementTypeCollectionView[@name=\"searchResults\"]/XCUIElementTypeCell[3]/XCUIElementTypeOther\n")
    WebElement searchingStacktile;

    @FindBy(xpath="//XCUIElementTypeButton[@name=\"player forward10\"]\n")
    WebElement playerforward10;

    @FindBy(xpath="//XCUIElementTypeButton[@name=\"player back10\"]")
    WebElement playerback10;
    @FindBy(xpath="//XCUIElementTypeButton[@name=\"helpButton\"]")
    WebElement helpButton;

    @FindBy(xpath="//XCUIElementTypeButton[@name=\"chromecastButton\"]")
    WebElement chromecastButton;

    @FindBy(xpath="//XCUIElementTypeOther[@name=\"airplayButton\"]")
    WebElement airplayButton;

    @FindBy(xpath="//XCUIElementTypeOther[@name=\"timeScrubberView\"]")
    WebElement timeScrubberView;

    @FindBy(xpath="//XCUIElementTypeButton[@name=\"fullScreenButton\"]")
    WebElement fullScreenButton;
    @FindBy(xpath="//XCUIElementTypeSlider[@name=\"sliderView\"]/XCUIElementTypeOther\n")
    WebElement sliderView;
    @FindBy(xpath="//XCUIElementTypeOther[@name=\"timeLabel\"]")
    WebElement timeLabel;

    @FindBy(xpath="//XCUIElementTypeOther[@name=\"videoPlayerView\"]")
    WebElement videoPlayerView;

//XCUIElementTypeOther[@name="videoPlayerView"]

    @FindBy(xpath="//XCUIElementTypeImage[@name=\"share_icon\"]\n")
    WebElement share_icon;
    @FindBy(xpath="//XCUIElementTypeImage[@name=\"like_unselected\"]\n")
    WebElement like;

    @FindBy(xpath="//XCUIElementTypeButton[@name=\"closeButton\"]\n")
    WebElement close;

    @FindBy(xpath="//XCUIElementTypeOther[@name=\"view\"]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]\n")
    WebElement playerclick;
//XCUIElementTypeButton[@name=""]
@FindBy(xpath="//XCUIElementTypeButton[@name=\"switch content\"]")
WebElement switchcontent;

    @FindBy(xpath="//XCUIElementTypeStaticText[@name=\"Extended Highlights\"]")
    WebElement highlightplayicon;
    public WebElement highlightplayicon(WebDriver driver) {
        return (highlightplayicon);
    }
    public WebElement switchcontent(WebDriver driver) {
        return (switchcontent);
    }
    public WebElement videoPlayerView(WebDriver driver) {
        return (videoPlayerView);
    }

    public WebElement playerclick(WebDriver driver) {
        return (playerclick);
    }

    public WebElement close(WebDriver driver) {
        return (close);
    }

    public WebElement timeLabel(WebDriver driver) {
        return (timeLabel);
    }

    public WebElement like(WebDriver driver) {
        return (like);
    }

    public WebElement share_icon(WebDriver driver) {
        return (share_icon);
    }

    public WebElement sliderView(WebDriver driver) {
        return (sliderView);
    }

    public WebElement fullScreenButton(WebDriver driver) {
        return (fullScreenButton);
    }

    public WebElement timeScrubberView(WebDriver driver) {
        return (timeScrubberView);
    }

    public WebElement airplayButton(WebDriver driver) {
        return (airplayButton);
    }

    public WebElement chromecastButton(WebDriver driver) {
        return (chromecastButton);
    }

    public WebElement helpButton(WebDriver driver) {
        return (helpButton);
    }

    public WebElement playerforward10(WebDriver driver) {
        return (playerforward10);
    }


    public WebElement playerback10(WebDriver driver) {
        return (playerback10);
    }


    public WebElement searchingStacktile(WebDriver driver) {
        return (searchingStacktile);
    }

    public WebElement searchButton(WebDriver driver) {
        return (searchButton);
    }

    public WebElement searchInput(WebDriver driver) {
        return (searchInput);
    }


}
