package org.test.pageEvents;

import org.test.pageObjects.LoginPageElements;
import org.test.utilities.ElementFetch;
import org.testng.Assert;

public class LoginPageEvents {

    ElementFetch ele = new ElementFetch();

    public void verifyLoginPageIsLoaded(){
        Assert.assertTrue(ele.getWebElement("ID", LoginPageElements.usr_field).isDisplayed(), "Element not found");
    }

    public void enterCredentials(String username, String password){

        ele.getWebElement("ID", LoginPageElements.usr_field).sendKeys(username);
        ele.getWebElement("ID", LoginPageElements.pwd_field).sendKeys(password);

    }

    public void loginUser() throws InterruptedException {

        ele.getWebElement("ID", LoginPageElements.login).click();
        Thread.sleep(4000);
        Assert.assertTrue(ele.getWebElement("ID",LoginPageElements.invetoryScreen).isDisplayed(), "Login unsuccessful!");
    }

}
