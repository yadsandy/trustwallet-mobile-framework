package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

public class CreatePasscodePage extends CommonFunctions {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Create passcode']")
    private static WebElement createPasscode_lbl;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='1']")
    private static WebElement oneNumber_btn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Those passwords didn’t match!']")
    private static WebElement passwordNotMatch_error;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter your passcode. Be sure to remember it so you can unlock your wallet.']")
    private static WebElement createPasscodeInfo_lbl;
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.View/android.view.View/android.view.View[3]/android.view.View")
    private static WebElement createPasscodeBack_btn;

    public CreatePasscodePage(WebDriver driver) {
        super(driver);
    }

    public void checkCreatePasscodePage() {
        checkElementVisibility(createPasscode_lbl);
        checkElementVisibility(createPasscodeInfo_lbl);

    }

    public void enterPasscodeOnCreatePasscodePage() {
        for (int i = 0; i < 6; i++) {
            click(oneNumber_btn);
        }
    }


    public void clickOnBackFromCreatePasscodePage() {
        click(createPasscodeBack_btn);
    }

    public boolean CheckPasswordError() {
        return checkElementVisibility(passwordNotMatch_error);
    }
}
