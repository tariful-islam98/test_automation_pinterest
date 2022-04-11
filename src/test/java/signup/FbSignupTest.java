package signup;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.SignupPage;

public class FbSignupTest extends BaseTests {
    /**
     * TC_3.2
     */
    @Test
    public void testFbSignup(){
        SignupPage signupPage = homePage.clickSignup();
        signupPage.clickFbSignupBtn();
    }
}
