# Trust Wallet Android App Automation Using Appium

This project defines the automation of android app using appium.

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
9. Clone the project from https://github.com/yadsandy/trustwallet-mobile-framework
10. Download the latest Android apk from https://trustwallet.com/ and place it in [resources](src/test/resources) folder
    and replace the apk name as app_release.apk

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