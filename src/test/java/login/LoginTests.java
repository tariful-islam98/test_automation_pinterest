package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoggedInHomePage;
import pages.LoginPage;

public class LoginTests extends BaseTests {
    @Test
    public void testSuccessfulLogin(){
        LoginPage loginPage = homePage.clickLogin();

        loginPage.setUserEmail("abir0dhaka@gmail.com");
        loginPage.setPassword("#111156");

        LoggedInHomePage loggedInHomePage = loginPage.clickLoginBtn();
        Assert.assertTrue(loggedInHomePage.getProfile());

        if (loggedInHomePage.getProfile()==true){
            System.out.println("TestCase(Login): Passed");
        }else {
            System.out.println("TestCase(Login): Failed");
        }
    }
}
