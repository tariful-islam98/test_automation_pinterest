package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private String loginBtnPath = "//div[@data-test-id=\"simple-login-button\"]/button";//get login button
    private String signupBtnPath = "//div[@data-test-id=\"simple-signup-button\"]/button";//get signup button
    private By loginLink = By.xpath(loginBtnPath);
    private By signupLink = By.xpath(signupBtnPath);

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * click login button
     * @return to login page
     */
    public LoginPage clickLogin(){
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }

    /**
     * click signup button
     * @return to signup page
     */
    public SignupPage clickSignup(){
        driver.findElement(signupLink).click();
        return new SignupPage(driver);
    }
}
