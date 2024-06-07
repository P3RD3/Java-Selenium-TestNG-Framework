package org.test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.test.base.baseTest;

import java.util.List;

public class ElementFetch {

    public WebElement getWebElement(String identifierType, String identifierValue) {
        return switch (identifierType) {
            case "XPATH" -> baseTest.driver.findElement(By.xpath(identifierValue));
            case "CSS" -> baseTest.driver.findElement(By.cssSelector(identifierValue));
            case "ID" -> baseTest.driver.findElement(By.id(identifierValue));
            case "NAME" -> baseTest.driver.findElement(By.name(identifierValue));
            case "TAGNAME" -> baseTest.driver.findElement(By.tagName(identifierValue));
            default -> null;
        };
    }
    public List<WebElement> getWebElements(String identifierType, String identifierValue) {
        return switch (identifierType) {
            case "XPATH" -> baseTest.driver.findElements(By.xpath(identifierValue));
            case "CSS" -> baseTest.driver.findElements(By.cssSelector(identifierValue));
            case "ID" -> baseTest.driver.findElements(By.id(identifierValue));
            case "NAME" -> baseTest.driver.findElements(By.name(identifierValue));
            case "TAGNAME" -> baseTest.driver.findElements(By.tagName(identifierValue));
            default -> null;
        };
    }
}

