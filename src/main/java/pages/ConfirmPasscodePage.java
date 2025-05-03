package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;


public class ConfirmPasscodePage extends CommonFunctions {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Confirm passcode']")
    private static WebElement confirmPasscode_lbl;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Re-enter your passcode. Be sure to remember it so you can unlock your wallet.']")
    private static WebElement confirmPasscodeInfo_lbl;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='2']")
    private static WebElement twoNumber_btn;

    public ConfirmPasscodePage(WebDriver driver) {
        super(driver);
    }


    public void checkConfirmPasscodePage() {
        checkElementVisibility(confirmPasscode_lbl);
        checkElementVisibility(confirmPasscodeInfo_lbl);

    }

    public void enterWrongPasscodeOnConfirmPasscodePage() {
        for (int i = 0; i < 6; i++) {
            click(twoNumber_btn);
        }
    }

}
