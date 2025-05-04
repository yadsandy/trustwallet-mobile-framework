# Trust Wallet Android App Automation Using Appium

This project defines the automation of Trust wallet android app using appium. It's a POM framework integrated with testng, maven and extent reporting.
It also contains the list of manual test cases related to create new wallet feature which future use to automate the same flows.

## Prerequisites for the project

1. Java and set JAVA_HOME
2. Maven and set MAVEN_HOME
3. NodeJS
4. Android Studio
5. Android SDK and set ANDROID_HOME
6. IDE (preferred: IntelliJ)
7. Appium 2.0

   `npm install -g appium`

8. Appium Drivers

   `appium driver install uiautomator2`

## Project Setup
1. Clone the project from https://github.com/yadsandy/trustwallet-mobile-framework
2. Download the latest Android apk from https://trustwallet.com/ and place it in [resources](src/test/resources) folder
   and replace the apk name as app_release.apk
3. You can find the manual test cases for create new wallet feature in [Trust_Wallet_Creation_Test_Cases.xlsx](src/test/resources/Trust_Wallet_Creation_Test_Cases.xlsx)
4. [MobileDriverService.java](src/main/java/base/MobileDriverService.java) contains all the methods related to initialize driver and stop driver.
5. [pages](src/main/java/pages) folder have different page classes based on each screen used for create new wallet feature
6. [ExtentReportService.java](src/main/java/reporters/ExtentReportService.java) is to generate a pretty report once the test execution will over. You can view the report in reports folder with the name as test_execution_results_<timestamp>
7. [CommonFunctions.java](src/main/java/utils/CommonFunctions.java) contains all the common functions/actions used to perform for elements like click, sendkeys, element is displaying or not.
8. [Constants.java](src/main/java/utils/Constants.java) having constant which used in the framework.
9. [PropertyReader.java](src/main/java/utils/PropertyReader.java) is to read the data from [config.properties](src/test/resources/config.properties) file which is used in [Constants.java](src/main/java/utils/Constants.java)
10. [TestListener.java](src/main/java/utils/TestListener.java) contain testng listeners to understand the pass, fail and other scenarios of the test cases.
11. [BaseTest.java](src/test/java/tests/BaseTest.java) have before and after methods to execute with every test cases
12. [WalletTest.java](src/test/java/tests/WalletTest.java) contains wallet test cases to run on android device.
13. [images](src/test/resources/images) contains screenshots used in readme file
14. [config.properties](src/test/resources/config.properties) having key value pair used in framework
15. [log4j2.xml](src/test/resources/log4j2.xml) having logging configuration and generation logging file for every scenario and logs will show for every execution in logs folder.
16. [testng.xml](src/test/resources/testng.xml) use to execute the test cases of wallet class and you can config execution based on your needs.

## Execution of Test Cases

Steps:

1. Connect real android device or open simulator with the system and update the `android` app and device details
   in [config.properties](src/test/resources/config.properties)
2. Check the [testng.xml](src/test/resources/testng.xml) and update or edit the classes and methods based on the need
3. You can run the test cases using Intellij and terminal.
    1. **Intellij ::**
        - Execute the [testng.xml](src/test/resources/testng.xml)
        - You can see the results in the reports folder based on the latest execution.
    2. **Terminal ::**

    * To run the test suite for android platform

      `mvn clean test`

4. You can manually run the wallet test cases one by one from [WalletTest.java](src/test/java/tests/WalletTest.java)

## Execution Result :

Console Output -
![Screenshot 2025-05-04 001240.png](src/test/resources/images/Screenshot%202025-05-04%20001240.png)
![Screenshot 2025-05-04 005952.png](src/test/resources/images/Screenshot%202025-05-04%20005952.png)
Extent Report -
![Screenshot 2025-05-04 001307.png](src/test/resources/images/Screenshot%202025-05-04%20001307.png)
![Screenshot 2025-05-04 001328.png](src/test/resources/images/Screenshot%202025-05-04%20001328.png)