package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class profilepage {

    @FindBy(xpath="//XCUIElementTypeButton[@name=\"button\"]")
    WebElement signOut;

    @FindBy(xpath="//XCUIElementTypeButton[@name=\"Log out\"]")
    WebElement signOutConfirmation;

    @FindBy(xpath="//XCUIElementTypeButton[@name=\"railsTabItem\"]")
    WebElement home;

    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"userProfileButton\"]")
    WebElement userprofile;
    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"userProfileButton\"]")
    WebElement Profile;
    public WebElement Profile(WebDriver driver){return Profile;}

    @FindBy(xpath = "//XCUIElementTypeImage[@name=\"Profile\"]")
    WebElement detailedProfile;
    public WebElement detailedProfile(WebDriver driver){return detailedProfile;}

    @FindBy(xpath = "//XCUIElementTypeTextField[@value=\"raghavendra7461\"]")
    WebElement NickName;
    public WebElement NickName(WebDriver driver){return NickName;}

    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"userProfileBottomSheetAvatarPickerView\"]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
    WebElement NickNameChangeClick;
    public WebElement NickNameChangeClick(WebDriver driver){return NickNameChangeClick;}

    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"primaryButton\"]")
    WebElement NickNameSave;
    public WebElement NickNameSave(WebDriver driver){return NickNameSave;}

    @FindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[18]")
    WebElement Age;
    public WebElement Age(WebDriver driver){return Age;}

    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"ageRangeRadioButton1\"]")
    WebElement AgeChange;
    public WebElement AgeChange(WebDriver driver){return AgeChange;}

    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"dateLoadingButton\"]")
    WebElement AgeConfirm;
    public WebElement AgeConfirm(WebDriver driver){return AgeConfirm;}

    @FindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[20]")
    WebElement Gender;
    public WebElement Gender(WebDriver driver){return Gender;}

    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"genderRadioButton0\"]")
    WebElement GenderChange;
    public WebElement GenderChange(WebDriver driver){return GenderChange;}

    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"genderLoadingButton\"]")
    WebElement GenderConfirm;
    public WebElement GenderConfirm(WebDriver driver){return GenderConfirm;}

    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"showPhoneNumberButton\"]")
    WebElement PhoneNumber;
    public WebElement PhoneNumber(WebDriver driver){return PhoneNumber;}

    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"showPhoneNumberButton\"]")
    WebElement PhoneNumberClick;
    public WebElement PhoneNumberClick(WebDriver driver){return PhoneNumberClick;}

    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"phoneLoadingButton\"]")
    WebElement PhoneConfirm;
    public WebElement PhoneConfirm(WebDriver driver){return PhoneConfirm;}

    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"back\"]")
    WebElement InnerBackBtn;
    public WebElement InnerBackBtn(WebDriver driver){return InnerBackBtn;}

    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"back\"]")
    WebElement OuterBackBtn;
    public WebElement OuterBackBtn(WebDriver driver){return OuterBackBtn;}
    public WebElement signOut(WebDriver driver) {
        return (signOut);
    }
    public WebElement signOutConfirmation(WebDriver driver) {
        return (signOutConfirmation);
    }
    public WebElement home(WebDriver driver) {
        return (home);
    }
    public WebElement userprofile(WebDriver driver) {
        return (userprofile);
    }


}
