package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;


public class WalletTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger();
    SplashPage splashPage;
    CreatePasscodePage createPasscodePage;
    ConfirmPasscodePage confirmPasscodePage;
    NotificationPage notificationPage;
    WalletReadyPage walletReadyPage;
    AdsPage adsPage;
    MainWalletPage mainWalletPage;

    @BeforeMethod
    public void beforeMethod() {
        splashPage = new SplashPage(getDriver());
        createPasscodePage = new CreatePasscodePage(getDriver());
        confirmPasscodePage = new ConfirmPasscodePage(getDriver());
        notificationPage = new NotificationPage(getDriver());
        walletReadyPage = new WalletReadyPage(getDriver());
        adsPage = new AdsPage(getDriver());
        mainWalletPage = new MainWalletPage(getDriver());
    }


    @Test(description = "Verify the create wallet connection TC_01,TC_02,TC_03,TC_04,TC_05, TC_11, TC_13")
    public void CreateWalletPositiveFlow() {
        splashPage.clickOnCreateNewWallet();
        logger.info("clicked create new wallet button");
        createPasscodePage.checkCreatePasscodePage();
        createPasscodePage.enterPasscodeOnCreatePasscodePage();
        logger.info("password entered on create passcode page");
        confirmPasscodePage.checkConfirmPasscodePage();
        createPasscodePage.enterPasscodeOnCreatePasscodePage();
        logger.info("password entered on confirm passcode page");
        notificationPage.checkAndSkipNotificationPage();
        logger.info("clicked on skip notification");
        walletReadyPage.checkAndSkipWalletReadyPage();
        logger.info("Wallet is ready notification is displayed");
        adsPage.checkAndSkipAdsPage();
        logger.info("Clicked on back button from ads page");
        String mainWallet = mainWalletPage.checkMainBalance();
        logger.debug("main wallet balance is: {}", mainWallet);
        Assert.assertEquals(mainWallet, "$0.00");
        logger.info("main wallet balance verified successfully");
    }


    @Test(description = "Verify create and confirm passcode page test cases TC_06,TC_07,TC_10")
    public void CheckCreateAndConfirmPasscodePage() {
        splashPage.clickOnCreateNewWallet();
        logger.info("clicked on create new wallet button");
        createPasscodePage.clickOnBackFromCreatePasscodePage();
        logger.info("clicked on back from create passcode page");
        splashPage.checkCreateWalletButton();
        logger.info("verified back Button successfully from create passcode page");
        splashPage.clickOnCreateNewWallet();
        logger.info("clicked on create new wallet button.");
        createPasscodePage.enterPasscodeOnCreatePasscodePage();
        logger.info("password entered on create passcode page.");
        createPasscodePage.clickOnBackFromCreatePasscodePage();
        logger.info("clicked on back from confirm passcode page");
        splashPage.checkCreateWalletButton();
        logger.info("verified back Button successfully from create passcode page");
        splashPage.clickOnCreateNewWallet();
        logger.info("clicked on create new wallet button.");
        createPasscodePage.enterPasscodeOnCreatePasscodePage();
        logger.info("password entered on create passcode page.");
        confirmPasscodePage.enterWrongPasscodeOnConfirmPasscodePage();
        logger.info("entered wrong password on confirm passcode page");
        Assert.assertTrue(createPasscodePage.CheckPasswordError());
        logger.info("wrong password error verified");


    }
}
