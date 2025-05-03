package tests;

import base.MobileDriverService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import utils.TestListener;

import java.time.Duration;

import static utils.Constants.ANDROID_DEVICE_NAME;

@Listeners(TestListener.class)
public class BaseTest extends MobileDriverService {
    private static final Logger logger = LogManager.getLogger();

    @BeforeSuite
    public void oneTimeSetup() {
        logger.debug("Test execution starts on device: {}", ANDROID_DEVICE_NAME);
    }

    @BeforeMethod
    public void openApp() {
        setDriver(spinUpDriver());
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterMethod
    public void closeApp() {
        closeDriver();
        stopAppiumService();
    }
}

