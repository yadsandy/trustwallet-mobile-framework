package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

public class NotificationPage extends CommonFunctions {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Keep up with the market!']")
    private static WebElement notificationPage_lbl;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='secondaryAction']")
    private static WebElement skipNotificationPage_btn;

    public NotificationPage(WebDriver driver) {
        super(driver);
    }

    public void checkAndSkipNotificationPage() {
        if (checkElementVisibility(notificationPage_lbl)) {
            clickSkipNotification();
        }
    }

    public void clickSkipNotification() {
        click(skipNotificationPage_btn);
    }

}
