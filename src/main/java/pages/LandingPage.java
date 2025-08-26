package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class LandingPage {

    //    @FindBy(xpath = "//XCUIElementTypeTextField[@name=\"textFieldEmail\"]")
//    WebElement username;
    @FindBy(xpath = "//XCUIElementTypeTextField[@name=\"emailField\"]")
    WebElement username;

    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"Continue\"]")
    WebElement Nextbutton;
    //    @FindBy(xpath = "//XCUIElementTypeSecureTextField[@name=\"textFieldPassword\"]")
//    WebElement password;
    @FindBy(xpath = "//XCUIElementTypeSecureTextField[@name=\"passwordField\"]")
    WebElement password;
//    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"buttonSignIn\"]")
//    WebElement loginButton;

    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"Explore\"]")
    WebElement ExploreButton;


    @FindBy(xpath = "//XCUIElementTypeImage[@name=\"dazn-splash-logo\"]")
    WebElement splashscreen;
//    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"userProfileButton\"]")
//    WebElement userprofile;
//
//    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"SignIn\"]")
//    WebElement signInButton;

    @FindBy(xpath = "(//XCUIElementTypeButton[@name=\"Not Now\"])[2]")
    WebElement notnowtwo;


    @FindBy(xpath = "(//XCUIElementTypeButton[@name=\"Not Now\"])[1]")
    WebElement notnowone;
    @FindBy(xpath = "dismiss")
    WebElement dismiss;

    @FindBy(xpath = "(//XCUIElementTypeButton[@name=\"sportsTabItem\"]")
    WebElement sports;
    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"See full schedule\u200B\"]")
    WebElement seefullSchedule;

    @FindBy(xpath = "(//XCUIElementTypeOther[@name=\"location\"])[2]/XCUIElementTypeOther")
    WebElement location;


    @FindBy(xpath = "//XCUIElementTypeSearchField[@name=\"Search Content Country\"]")
    WebElement searchcountry;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"titleLabel\"]\n")
    WebElement countryname;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='Log in' and @label='Log in']")
    WebElement login;


    //XCUIElementTypeButton[@name="Log in"]
    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"Log in\"]")
    WebElement loginButton;


    public WebElement login(WebDriver driver) {
        return (login);
    }
    public WebElement countryname(WebDriver driver) {
        return (countryname);
    }
    public WebElement searchcountry(WebDriver driver) {
        return (searchcountry);
    }
    public WebElement location(WebDriver driver) {
        return (location);
    }
    public WebElement seefullSchedule(WebDriver driver) {
        return (seefullSchedule);
    }
    public WebElement dismiss(WebDriver driver) {
        return (dismiss);
    }
    public WebElement ExploreButton(WebDriver driver) {
        return (ExploreButton);
    }
    public WebElement Nextbutton(WebDriver driver) {
        return (Nextbutton);
    }
    public WebElement sports(WebDriver driver) {
        return (sports);
    }
    public WebElement username(WebDriver driver) {
        return (username);
    }

    public WebElement password(WebDriver driver) {
        return (password);
    }

    public WebElement loginButton(WebDriver driver) {
        return (loginButton);
    }

    public WebElement splashscreen(WebDriver driver) {
        return (splashscreen);
    }

    //    public WebElement userprofile(WebDriver driver) {
//        return (userprofile);
//    }
//
//    public WebElement signInButton(WebDriver driver) {
//        return (signInButton);
//    }
    public WebElement notnowtwo(WebDriver driver) {
        return (notnowtwo);
    }

    public WebElement notnowone(WebDriver driver) {
        return (notnowone);
    }
}