package home;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoggedInHomePage;
import pages.LoginPage;

public class NotificationTest extends BaseTests {
    /**
     * TC_4.4
     */
    @Test
    public void testNotification(){
        LoginPage loginPage = homePage.clickLogin();

        loginPage.setUserEmail("vespimerka5@vusra.com");
        loginPage.setPassword("121212A");

        LoggedInHomePage loggedInHomePage = loginPage.clickLoginBtn();
        loggedInHomePage.clickNotificationIcon();
        String expectedUrl = "https://www.pinterest.com/news_hub/"+loggedInHomePage.selectNotification();

        Assert.assertEquals(loggedInHomePage.getCurrentUrl(), expectedUrl);
    }
}
