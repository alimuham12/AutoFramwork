package main.java.pageEvents;

import main.java.pageObjects.HomePageElements;
import main.java.pageObjects.LoginPageElements;
import main.java.utils.ElementFetch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import test.java.BaseTests;

import static test.java.BaseTests.driver;

public class LoginPageEvents {
    public void EmailEntering()
    {

        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("CSS", LoginPageElements.emailAddress).sendKeys("muhammad.ali@indusvalleylabs.com");
        elementFetch.getWebElement("CSS",LoginPageElements.password).sendKeys("test2");
        elementFetch.getWebElement("CSS",LoginPageElements.SigninButton).click();


    }





}
