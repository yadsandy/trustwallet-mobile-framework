package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

public class SplashPage extends CommonFunctions {

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='buttonTitle' and @text='Create new wallet']")
    private static WebElement createANewWallet_btn;

    public SplashPage(WebDriver driver) {
        super(driver);
    }

    public void checkCreateWalletButton() {
        checkElementVisibility(createANewWallet_btn);
    }

    public void clickOnCreateNewWallet() {
        click(createANewWallet_btn);

    }

}
