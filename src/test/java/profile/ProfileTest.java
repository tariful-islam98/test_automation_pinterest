package profile;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoggedInHomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileTest extends BaseTests {
    /**
     * TC_4.6
     */
    @Test
    public void testProfileEdit(){
        LoginPage loginPage = homePage.clickLogin();
        loginPage.setUserEmail("vespimerka6@vusra.com");
        loginPage.setPassword("121212A");

        LoggedInHomePage homePage = loginPage.clickLoginBtn();
        ProfilePage profilePage = homePage.clickProfileIcon();

        String expectedUrl1 = "https://www.pinterest.com/vespimerka6/_saved/";
        Assert.assertEquals(profilePage.getCurrentUrl(),expectedUrl1);

        profilePage.clickEditProfile();
        String expectedUrl2 = "https://www.pinterest.com/settings#profile";
        Assert.assertEquals(profilePage.getCurrentUrl(), expectedUrl2);

        String lastName = profilePage.getLastName();
        profilePage.editProfileName(lastName+"A");
        Assert.assertTrue(profilePage.isEdited());
    }
}
