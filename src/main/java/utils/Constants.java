package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

import static utils.PropertyReader.getConfigValue;

public class Constants {
    // Appium Constants
    public static final String APPIUM_SERVER_IP = getConfigValue("appium_server_ip");
    public static final Duration APPIUM_DRIVER_TIMEOUT = Duration.ofSeconds(
            Long.parseLong(getConfigValue("appium_driver_timeout_in_seconds"))
    );
    // Android Constants
    public static final String ANDROID_DEVICE_NAME = getConfigValue("android_device_name");
    public static final String ANDROID_APP_FILE_PATH = getConfigValue("android_app_file_path");
    public static final String ANDROID_APP_PACKAGE = getConfigValue("android_app_package");
    public static final String ANDROID_FULL_RESET = getConfigValue("android_full_reset");
    private final static Logger logger = LogManager.getLogger();
}
