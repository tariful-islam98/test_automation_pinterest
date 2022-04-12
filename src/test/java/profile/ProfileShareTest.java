package profile;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoggedInHomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileShareTest extends BaseTests {
    /**
     * TC_4.6
     */
    @Test
    public void testProfileShare(){

        LoginPage loginPage = homePage.clickLogin();
        loginPage.setUserEmail("vespimerka6@vusra.com");
        loginPage.setPassword("121212A");

        LoggedInHomePage homePage = loginPage.clickLoginBtn();
        ProfilePage profilePage = homePage.clickProfileIcon();

        String expectedUrl1 = "https://www.pinterest.com/vespimerka6/_saved/";
        Assert.assertEquals(profilePage.getCurrentUrl(),expectedUrl1);

        profilePage.clickShareProfile();
        profilePage.shareContact("abir0dhaka@gmail.com", "Hello");
    }
}
