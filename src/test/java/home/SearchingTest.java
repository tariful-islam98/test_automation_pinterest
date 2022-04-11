package home;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoggedInHomePage;
import pages.LoginPage;

public class SearchingTest extends BaseTests {
    /**
     * TC_4.3
     */
    @Test
    public void testSearchOperation(){
        String expectedUrl = "https://www.pinterest.com/search/pins/?q=Cricket&rs=typed&term_meta[]=Cricket%7Ctyped";
        LoginPage loginPage = homePage.clickLogin();

        loginPage.setUserEmail("vespimerka5@vusra.com");
        loginPage.setPassword("121212A");

        LoggedInHomePage loggedInHomePage = loginPage.clickLoginBtn();
        loggedInHomePage.searchTag();

        Assert.assertEquals(loggedInHomePage.getCurrentUrl(), expectedUrl);

    }
}
