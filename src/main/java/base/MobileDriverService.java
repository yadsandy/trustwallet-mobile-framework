package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

import static utils.Constants.*;

public class MobileDriverService {
    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    private static final Logger logger = LogManager.getLogger();
    private static AndroidDriver androidDriver;
    private AppiumDriverLocalService appiumService;

    public static AppiumDriver getDriver() {
        if (androidDriver == null) {
            throw new IllegalStateException("Driver not initialized. Please call initializeDriver first.");
        }
        return driver.get();
    }

    public static void setDriver(AndroidDriver driver) {
        MobileDriverService.driver.set(driver);
    }

    public void startAppiumService() {
        try {
            appiumService = AppiumDriverLocalService.buildService(
                    new AppiumServiceBuilder()
                            .withIPAddress(APPIUM_SERVER_IP)
                            .usingPort(4723)
            );

            appiumService.start();

            if (!appiumService.isRunning()) {
                throw new RuntimeException("Appium service failed to start.");
            }

            logger.debug("Appium service started at: {}", appiumService.getUrl());

        } catch (Exception e) {
            logger.debug("Failed to start Appium service: {}", e.getMessage());
            throw new RuntimeException("Failed to start Appium service", e);
        }
    }

    public void stopAppiumService() {
        appiumService.stop();
    }

    public AndroidDriver spinUpDriver() {
        try {
            startAppiumService();
            UiAutomator2Options options = new UiAutomator2Options()
                    .setUdid(ANDROID_DEVICE_NAME)
                    .setApp(new File(ANDROID_APP_FILE_PATH).getAbsolutePath())
                    .setAppPackage(ANDROID_APP_PACKAGE)
                    .setFullReset(Boolean.parseBoolean(ANDROID_FULL_RESET))
                    .autoGrantPermissions();

            androidDriver = new AndroidDriver(appiumService.getUrl(), options);
            androidDriver.manage().timeouts().implicitlyWait(APPIUM_DRIVER_TIMEOUT);
            return androidDriver;
        } catch (Exception e) {
            logger.debug("Failed to spin up AndroidDriver: {}", e.getMessage());
            if (appiumService != null && appiumService.isRunning()) {
                appiumService.stop();
            }

            throw new RuntimeException("Failed to initialize AndroidDriver", e);
        }
    }

    public void closeDriver() {
        if (androidDriver != null) {
            androidDriver.terminateApp(ANDROID_APP_PACKAGE);
            androidDriver = null;
        }
    }

}