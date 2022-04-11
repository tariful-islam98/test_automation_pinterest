package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * TC_003
 * this page is to provide email, password and age to signup
 */
public class SignupPage {
    private WebDriver driver;

    private By userEmailField = By.id("email");
    private By userPasswordField = By.id("password");
    private By useAgeField = By.id("age");
    private By signupBtn = By.xpath("//div[@data-test-id=\"registerFormSubmitButton\"]/button");
    private By profileId = By.xpath("//div[@data-test-id=\"header-profile\"]");
    private By successfulMsg = By.xpath("//*[contains(text(),\"Welcome to Pinterest\")]");


    private By fbSignupBtnPath = By.xpath("//div[@data-test-id = \"facebook-connect-button\"]/button");
    private By googleSignupBtnPath = By.xpath("//div[@data-test-id = \"google-connect-button\"]");

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserEmail(String userEmail){
        driver.findElement(userEmailField).sendKeys(userEmail);
    }

    public void setPassword(String userPassword){
        driver.findElement(userPasswordField).sendKeys(userPassword);
    }

    public void setAge(String age){
        driver.findElement(useAgeField).sendKeys(age);
    }

    /**
     * TC_3.1
     * login with email and password
     * @return to Signup completion process
     */
    public SignedUpPage clickContinueBtn() {
        driver.findElement(signupBtn).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileId));
        return new SignedUpPage(driver);
    }

    /**
     * TC_3.2
     * Signup with Facebook
     */
    public void clickFbSignupBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fbSignupBtnPath));
        driver.findElement(fbSignupBtnPath).click();
    }

    /**
     * TC_3.3
     * Signup with Facebook
     */
    public void clickGoggleSignupBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(googleSignupBtnPath));
        driver.findElement(googleSignupBtnPath).click();
    }
}
