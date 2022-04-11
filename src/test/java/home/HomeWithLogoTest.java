package home;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoggedInHomePage;
import pages.LoginPage;

public class HomeWithLogoTest extends BaseTests {
    /**
     * TC_4.1
     */
    @Test
    public void loadHomeByLogo() {
        String expectedUrl = "https://www.pinterest.com/";
        LoginPage loginPage = homePage.clickLogin();

        loginPage.setUserEmail("vespimerka6@vusra.com");
        loginPage.setPassword("121212A");

        LoggedInHomePage loggedInHomePage = loginPage.clickLoginBtn();
        loggedInHomePage.clickLogo();

        Assert.assertEquals(loggedInHomePage.getCurrentUrl(), expectedUrl);

    }
}
