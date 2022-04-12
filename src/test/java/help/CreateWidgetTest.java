package help;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HelpPage;
import pages.LoggedInHomePage;
import pages.LoginPage;

public class CreateWidgetTest extends BaseTests {
    /**
     * TC_4.7
     */
    @Test
    public void testCreateWidget(){
        LoginPage loginPage = homePage.clickLogin();
        loginPage.setUserEmail("vespimerka6@vusra.com");
        loginPage.setPassword("121212A");

        LoggedInHomePage inHomePage = loginPage.clickLoginBtn();
        HelpPage helpPage = inHomePage.clickHelpIcon();
        Assert.assertTrue(helpPage.isPopupDisplayed());

        helpPage.clickCreateOption();
    }
}
