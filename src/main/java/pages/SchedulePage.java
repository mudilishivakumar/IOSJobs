package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SchedulePage {
    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"scheduleTabItem\"]")
    WebElement scheduleTabItem;
    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"DAZN | Schedule\"]/XCUIElementTypeOther[1]\n")
    WebElement pills;

    public WebElement scheduleTabItem(WebDriver driver) {

        return (scheduleTabItem);
    }
        public WebElement pills(WebDriver driver) {
            return (pills);
        }


    }


