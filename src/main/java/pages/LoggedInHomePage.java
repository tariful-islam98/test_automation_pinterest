package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * loading home page after login
 */
public class LoggedInHomePage {
    private WebDriver driver;
    private By profileId = By.xpath("//div[@data-test-id=\"header-profile\"]");
    private By logoLink = By.xpath("//a[@aria-label=\"Home\"]");
    private By homeLink = By.xpath("//a/div/div/span[contains(text(), \"Home\")]");

    //Search
    private By searchBoxLink = By.xpath("//input[@data-test-id=\"search-box-input\"]");

    //Notification
    private By notificationIconLnk = By.xpath("//button[@aria-label=\"Notifications\"]");

    //Message
    private By inboxIconLnk = By.xpath("//button[@aria-label= \"Messages\"]");

    //help center
    private By helpIconLnk = By.xpath("//button[@aria-label= \"More\"]");

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
     * TC_4.4
     * Notifications
     */
    public NotificationPage clickNotificationIcon(){
        driver.findElement(notificationIconLnk).click();
        return new NotificationPage(driver);
    }

    /**
     * TC_4.5
     * Inbox
     */
    public InboxPage clickInboxIcon(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(inboxIconLnk));
        driver.findElement(inboxIconLnk).click();

        return new InboxPage(driver);
    }

    /**
     * TC_4.6
     * Profile
     */
    public ProfilePage clickProfileIcon(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileId));
        driver.findElement(profileId).click();
        return new ProfilePage(driver);
    }

    /**
     * TC_4.7
     * Help Center
     */
    public HelpPage clickHelpIcon(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(helpIconLnk));
        driver.findElement(helpIconLnk).click();
        return new HelpPage(driver);
    }

    /**
     * TC_004
     */
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
}
