package home;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.InboxPage;
import pages.LoggedInHomePage;
import pages.LoginPage;

public class InboxTest extends BaseTests {
    /**
     * TC_4.5
     */
    @Test
    public void testMessaging(){
        LoginPage loginPage = homePage.clickLogin();
        loginPage.setUserEmail("vespimerka6@vusra.com");
        loginPage.setPassword("121212A");

        LoggedInHomePage homePage = loginPage.clickLoginBtn();
        InboxPage inboxPage = homePage.clickInboxIcon();
        inboxPage.clickNewMsgBtn();
        inboxPage.selectContact("abir0dhaka@gmail.com");
        inboxPage.sendMessage("Hello!");
    }
}
