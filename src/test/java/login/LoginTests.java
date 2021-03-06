package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoggedInHomePage;
import pages.LoginPage;

public class LoginTests extends BaseTests {
    /**
     * TC_2.1
     */
    @Test
    public void testSuccessfulLogin(){
        LoginPage loginPage = homePage.clickLogin();

        loginPage.setUserEmail("vespimerka6@vusra.com");
        loginPage.setPassword("121212A");

        LoggedInHomePage loggedInHomePage = loginPage.clickLoginBtn();
        Assert.assertTrue(loggedInHomePage.getProfile());

        if (loggedInHomePage.getProfile()==true){
            System.out.println("TestCase(Login): Passed");
        }else {
            System.out.println("TestCase(Login): Failed");
        }
    }
}
