package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Sportspage {

    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"sportsTabItem\"]")
    WebElement sportsTab;

    public WebElement sportsTab(WebDriver driver) {
        return (sportsTab);
    }


}
