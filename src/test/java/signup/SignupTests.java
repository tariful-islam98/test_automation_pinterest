package signup;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoggedInHomePage;
import pages.SignedUpPage;
import pages.SignupPage;

public class SignupTests extends BaseTests {
    @Test
    public void testSuccessfulSignup(){
        SignupPage signup = homePage.clickSignup();

        signup.setUserEmail("vespimerka6@vusra.com");
        signup.setPassword("121212A");
        signup.setAge(""+23);

        SignedUpPage signedUpPage = signup.clickContinueBtn();
        Assert.assertTrue(signedUpPage.isSignedUp());
        signedUpPage.clickNextBtn();
        signedUpPage.selectGenderBtn();
        signedUpPage.clickCountryPageNxtBtn();
        signedUpPage.selectTopic();
        signedUpPage.clickTopicBtn();
        signedUpPage.clickQrDoneBtn();



        LoggedInHomePage loggedInHomePage = signedUpPage.clickSaveBtn();
        Assert.assertTrue(loggedInHomePage.getProfile());

        if (loggedInHomePage.getProfile()==true){
            System.out.println("TestCase(Signup): Passed");
        }else {
            System.out.println("TestCase(Signup): Failed");
        }
    }
}
