package org.test.testcases;
import org.openqa.selenium.By;
import org.test.pageEvents.LoginPageEvents;
import org.test.utilities.readExcelData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.test.base.baseTest;

public class loginTest extends baseTest {

    LoginPageEvents LoginPage = new LoginPageEvents();

        @Test(dataProviderClass = readExcelData.class, dataProvider = "loginData")
       public void LoginTest(String username, String password) throws InterruptedException {
            LoginPage.verifyLoginPageIsLoaded();
            logger.info("Login page loaded!");
            LoginPage.enterCredentials(username,password);
            logger.info("Credentials entered:"+username+password);
            LoginPage.loginUser();
            logger.info("User logged-in!");

        }

}
