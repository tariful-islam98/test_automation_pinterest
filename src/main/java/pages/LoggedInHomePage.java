package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    private By logoLink = By.xpath("//a[@aria-label=\"Home\"]");
    private By homeLink = By.xpath("//a/div/div/span[contains(text(), \"Home\")]");
    private By searchBoxLink = By.xpath("//input[@data-test-id=\"search-box-input\"]");

    public LoggedInHomePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     *TC_2.1
     * @return true if logged in successfully
     */
    public boolean getProfile(){
        return driver.findElement(profileId).isDisplayed();
    }

    /**
     * TC_4.1
     * click logo
     */
    public void clickLogo(){
        driver.findElement(logoLink).click();
    }

    /**
     * TC_4.2
     * click Home
     */
    public void clickHome(){
        driver.findElement(homeLink).click();
    }

/**
 * TC_4.3
 */
    public void searchTag(){
        driver.findElement(searchBoxLink).sendKeys("Cricket");
        driver.findElement(searchBoxLink).sendKeys(Keys.ENTER);
    }

    /**
     * TC_004
     */
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
}
