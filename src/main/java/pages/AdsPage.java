package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

public class AdsPage extends CommonFunctions {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='GET STARTED']")
    private static WebElement ads_lbl;
    @AndroidFindBy(xpath = "(//android.widget.Button)[2]")
    private static WebElement backAdsPage_btn;

    public AdsPage(WebDriver driver) {
        super(driver);
    }

    public void checkAndSkipAdsPage() {
        if (checkElementVisibility(ads_lbl)) {
            clickOnBackButtonOnAdsPage();
        }

    }

    public void clickOnBackButtonOnAdsPage() {
        click(backAdsPage_btn);
    }


}
