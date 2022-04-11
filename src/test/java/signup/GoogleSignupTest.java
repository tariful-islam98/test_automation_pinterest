package signup;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.SignupPage;

public class GoogleSignupTest extends BaseTests {
    /**
     * TC_3.3
     */
    @Test
    public void testGoogleSignup(){
        SignupPage signupPage = homePage.clickSignup();
        signupPage.clickGoggleSignupBtn();
    }
}
