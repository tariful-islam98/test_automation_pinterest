package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginWithFbTest extends BaseTests {
    /**
     * TC_2.2
     */
    @Test
    public void loadLoginWithFbWindow(){
        LoginPage loginPage = homePage.clickLogin();
        loginPage.clickFbBtn();
    }
}
