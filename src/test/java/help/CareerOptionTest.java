package help;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HelpPage;
import pages.LoggedInHomePage;
import pages.LoginPage;

public class CareerOptionTest extends BaseTests {
    /**
     * TC_4.7
     */
    @Test
    public void testCareerOption() {
        LoginPage loginPage = homePage.clickLogin();
        loginPage.setUserEmail("vespimerka5@vusra.com");
        loginPage.setPassword("121212A");

        LoggedInHomePage inHomePage = loginPage.clickLoginBtn();
        HelpPage helpPage = inHomePage.clickHelpIcon();
        helpPage.getOptions();
        helpPage.clickCareerOption();
    }
}
