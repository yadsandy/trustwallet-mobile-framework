package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

public class MainWalletPage extends CommonFunctions {

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='mainBalance']")
    private static WebElement mainBalance_lbl;

    public MainWalletPage(WebDriver driver) {
        super(driver);
    }


    public String checkMainBalance() {
        return getText(mainBalance_lbl);
    }


}
