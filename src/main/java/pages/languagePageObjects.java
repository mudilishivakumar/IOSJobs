package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class languagePageObjects {



    @FindBy(xpath = "//XCUIElementTypeCell[@name=\"languages_list_cell_0\"]/XCUIElementTypeOther[1]")
    WebElement SpanishLanguage;
    public WebElement SpanishLanguage(WebDriver loginButton) {return SpanishLanguage;}

    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"railsTabItem\"]")
    WebElement HomeTabLanguage;
    public WebElement HomeTabLanguage(){return(HomeTabLanguage);}

    @FindBy(xpath = "//XCUIElementTypeCell[@name=\"languages_list_cell_1\"]/XCUIElementTypeOther[1]")
    WebElement FrenchLanguage;
    public WebElement FrenchLanguage(WebDriver driver){return FrenchLanguage;}

    @FindBy(xpath = "//XCUIElementTypeCell[@name=\"languages_list_cell_0\"]/XCUIElementTypeOther[1]")
    WebElement EnglishLanguage;
    public WebElement EnglishLanguage(WebDriver driver){return EnglishLanguage;}

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"English\"]")
    WebElement LanguageButton;
    @FindBy(xpath = "(//XCUIElementTypeOther[@name=\"location\"])[3]/XCUIElementTypeOther/XCUIElementTypeButton\n")
    WebElement LanguageButtonFrançais;

    public WebElement LanguageButtonFrançais(WebDriver driver){return LanguageButtonFrançais;}
    public WebElement LanguageButton(WebDriver driver){return LanguageButton;}

}

