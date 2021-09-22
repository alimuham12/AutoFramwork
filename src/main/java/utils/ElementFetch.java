package main.java.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.java.BaseTests;

import java.util.List;

public class ElementFetch {
    public WebElement getWebElement(String identifierType, String identifierValue) {
        switch (identifierType) {
            case "ID":
                return BaseTests.driver.findElement(By.id(identifierValue));
            case "CSS":
                return BaseTests.driver.findElement(By.cssSelector(identifierValue));
            case "TAGNAME":
                return BaseTests.driver.findElement(By.tagName(identifierValue));
            case "XPATH":
                return BaseTests.driver.findElement(By.xpath(identifierValue));
            default:
                return null;
        }
    }

    public List<WebElement> getListWebElements(String identifierType, String identifierValue) {
        switch (identifierType) {
            case "ID":
                return BaseTests.driver.findElements(By.id(identifierValue));
            case "CSS":
                return BaseTests.driver.findElements(By.cssSelector(identifierValue));
            case "TAGNAME":
                return BaseTests.driver.findElements(By.tagName(identifierValue));
            case "XPATH":
                return BaseTests.driver.findElements(By.xpath(identifierValue));
            default:
                return null;
        }
    }

}


