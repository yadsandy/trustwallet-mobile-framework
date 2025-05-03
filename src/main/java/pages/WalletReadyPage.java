package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

public class WalletReadyPage extends CommonFunctions {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Brilliant, your wallet is ready!']")
    private static WebElement walletReady_lbl;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Skip, I'll do it later']")
    private static WebElement skipWalletReadyPage_btn;

    public WalletReadyPage(WebDriver driver) {
        super(driver);
    }

    public void checkAndSkipWalletReadyPage() {
        if (checkElementVisibility(walletReady_lbl)) {
            clickSkipWalletReadyPage();
        }
    }

    public void clickSkipWalletReadyPage() {
        clickElementBasedOnCoordinates(40, 2260);
    }


}
