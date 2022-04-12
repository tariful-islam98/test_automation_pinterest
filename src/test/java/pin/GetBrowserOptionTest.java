package pin;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoggedInHomePage;
import pages.LoginPage;
import pages.PinOptionsPage;

public class GetBrowserOptionTest extends BaseTests {
    /**
     * TC_4.8
     */
    @Test
    public void testGetBrowserOption(){
        LoginPage loginPage = homePage.clickLogin();
        loginPage.setUserEmail("vespimerka6@vusra.com");
        loginPage.setPassword("121212A");

        LoggedInHomePage inHomePage = loginPage.clickLoginBtn();
        PinOptionsPage pinOptionsPage = inHomePage.clickPinIcon();
        Assert.assertTrue(pinOptionsPage.isPinOptionsDisplayed());

        pinOptionsPage.clickGetBrowser();

    }
}
