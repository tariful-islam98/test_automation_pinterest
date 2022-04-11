package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * loading home page after login
 */
public class LoggedInHomePage {
    private WebDriver driver;
    private By profileId = By.xpath("//div[@data-test-id=\"header-profile\"]");

    public LoggedInHomePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     *
     * @return true if logged in successfully
     */
    public boolean getProfile(){
        return driver.findElement(profileId).isDisplayed();
    }
}