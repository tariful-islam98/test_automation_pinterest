package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * TC_4.6
 * Profile
 */
public class ProfilePage {
    private WebDriver driver;
    private By editBtn = By.xpath("//div[@data-test-id=\"edit-button\"]");
    private By lastNameInputField = By.xpath("//input[@id=\"last_name\"]");
    private By saveBtn = By.xpath("//div[@data-test-id=\"done-button\"]");
    private By toastDiv = By.xpath("//div[@data-test-id=\"toast\"]");

    //Share Profile
    private By shareBtn = By.xpath("//button[@aria-label=\"Send Profile\"]");
    private By emailInputField = By.xpath("//input[@id=\"search\"]");
    private By contactId = By.xpath("//div[@class=\"RDc zI7 iyn Hsu\"]/div[@role=\"button\"]");
    private By msgField = By.xpath("//textarea[@id=\"sendObjectMessage\"]");
    private By sendBtn = By.xpath("//button[@type=\"submit\"]");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickEditProfile(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(editBtn));
        driver.findElement(editBtn).click();
    }

    public void clickShareProfile(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(shareBtn));
        driver.findElement(shareBtn).click();
    }

    /**
     *
     * @param name - enter last name
     */
    public void editProfileName(String name){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameInputField));
        driver.findElement(lastNameInputField).sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        driver.findElement(lastNameInputField).sendKeys(name);
    }

    public boolean isEdited(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));

        driver.findElement(saveBtn).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(toastDiv));
        return driver.findElement(toastDiv).isDisplayed();
    }

    public String getLastName(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameInputField));

        return driver.findElement(lastNameInputField).getAttribute("value");
    }

    /**
     * Share contact
     * @param email - use email id to search contact
     * @param msg - Write message
     */
    public void shareContact(String email, String msg){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputField));
        driver.findElement(emailInputField).sendKeys(email);

        wait.until(ExpectedConditions.visibilityOfElementLocated(contactId));
        driver.findElement(contactId).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(msgField));
        driver.findElement(msgField).sendKeys(msg);

        wait.until(ExpectedConditions.visibilityOfElementLocated(sendBtn));
        driver.findElement(sendBtn).click();
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
}
