package profile;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoggedInHomePage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.ShareProfilePage;

public class ShareByEmail extends BaseTests {
    /**
     * TC_4.6
     * Share by email
     */
    @Test
    public void testShareByEmail(){
        LoginPage loginPage = homePage.clickLogin();
        loginPage.setUserEmail("vespimerka6@vusra.com");
        loginPage.setPassword("121212A");

        LoggedInHomePage inHomePage = loginPage.clickLoginBtn();
        ProfilePage profilePage = inHomePage.clickProfileIcon();
        ShareProfilePage shareProfile = profilePage.clickShareProfile();

        Assert.assertTrue(shareProfile.isPopupDisplayed());

        Assert.assertTrue(shareProfile.clickEmailIcon());
        shareProfile.sharByEmail("abir0dhaka@gmail.com", "Hello");
    }
}
