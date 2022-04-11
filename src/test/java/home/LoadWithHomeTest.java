package home;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoggedInHomePage;
import pages.LoginPage;

public class LoadWithHomeTest extends BaseTests {
    /**
     * TC_4.2
     */
    @Test
    public void LoadWithHome(){
        String expectedUrl = "https://www.pinterest.com/";
        LoginPage loginPage = homePage.clickLogin();

        loginPage.setUserEmail("vespimerka6@vusra.com");
        loginPage.setPassword("121212A");

        LoggedInHomePage loggedInHomePage = loginPage.clickLoginBtn();
        loggedInHomePage.clickHome();
        Assert.assertEquals(loggedInHomePage.getCurrentUrl(), expectedUrl);
    }
}
