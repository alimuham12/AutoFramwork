package main.java.pageEvents;

import main.java.pageObjects.HomePageElements;
import main.java.utils.ElementFetch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static test.java.BaseTests.driver;

public class HomePageEvents {

    public void moveToSignInButton()
    {
        WebElement Login = driver.findElement(By.cssSelector("body > app-root > po-header > p-menubar > div > div.p-menubar-end.ng-star-inserted > div > button > span"));

        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("CSS", HomePageElements.signInButton);
        Actions action = new Actions(driver);
        action.moveToElement(Login).perform();



    }

    public void clickOnSignInButton()
    {
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("CSS", HomePageElements.signInButton).click();

    }





}
