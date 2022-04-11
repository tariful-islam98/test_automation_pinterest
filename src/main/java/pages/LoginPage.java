package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * this page is to automate login
 */
public class LoginPage {
    private WebDriver driver;
    private By userEmailField = By.id("email");
    private By userPasswordField = By.id("password");
    private String loginBtnPath = "//div[@data-test-id=\"registerFormSubmitButton\"]/button";
    private By profileId = By.xpath("//div[@data-test-id=\"header-profile\"]");
    private By loginButton = By.xpath(loginBtnPath);
    private By fbLoginBtnPath = By.xpath("//div[@data-test-id = \"facebook-connect-button\"]/button");
    private By googleLoginBtnPath = By.xpath("//div[@data-test-id = \"google-connect-button\"]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserEmail(String userEmail) {
        driver.findElement(userEmailField).sendKeys(userEmail);
    }

    public void setPassword(String password) {
        driver.findElement(userPasswordField).sendKeys(password);
    }

    /**
     * TC_2.1
     * login with email and password
     * @return to Home Page
     */
    public LoggedInHomePage clickLoginBtn() {
        driver.findElement(loginButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileId));
        return new LoggedInHomePage(driver);
    }

    /**
     * TC_2.2
     * Login with fB
     */
    public void clickFbBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fbLoginBtnPath));
        driver.findElement(fbLoginBtnPath).click();
    }

    /**
     * TC_2.3
     * Login with google
     */
    /*public LoginWithGooglePage clickGoogleBtn() {//Store the ID of the original window
        String originalWindow = driver.getWindowHandle();

//      Check we don't have other windows open already
        assert driver.getWindowHandles().size() == 1;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(googleLoginBtnPath));

        driver.findElement(googleLoginBtnPath).click();

        //Wait for the new window or tab
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

//      Loop through until we find a new window handle
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        wait.until(ExpectedConditions.titleIs("Sign in - Google Accounts"));
        driver.switchTo().newWindow(WindowType.WINDOW);
        return new LoginWithGooglePage(driver);
    }*/

}
