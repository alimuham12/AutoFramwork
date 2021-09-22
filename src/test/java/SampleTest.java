package test.java;

import main.java.pageEvents.HomePageEvents;
import main.java.pageEvents.LoginPageEvents;
import org.testng.annotations.Test;

public class SampleTest extends BaseTests{
    @Test
    public void sampleMethodForEmailEnetering()
    {
        HomePageEvents homePageEvents = new HomePageEvents();
        homePageEvents.clickOnSignInButton();

        LoginPageEvents loginPageEvents = new LoginPageEvents();
        loginPageEvents.EmailEntering();

    }
}
