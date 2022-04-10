package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private By userEmailField = By.id("email");
    private By userPasswordField = By.id("password");
    private String loginBtnPath = "//div[@data-test-id=\"registerFormSubmitButton\"]/button";
    private By profileId = By.xpath("//div[@data-test-id=\"header-profile\"]");
    private By loginButton = By.xpath(loginBtnPath);

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserEmail(String userEmail){
        driver.findElement(userEmailField).sendKeys(userEmail);
    }

    public void setPassword(String password){
        driver.findElement(userPasswordField).sendKeys(password);
    }

    public LoggedInHomePage clickLoginBtn(){
        driver.findElement(loginButton).click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30) );
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(profileId)));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileId));
        return new LoggedInHomePage(driver);
    }
}
