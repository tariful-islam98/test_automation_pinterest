package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * TC_4.6
 * Share Profile
 */
public class ShareProfilePage {
    private WebDriver driver;

    private By emailInputField = By.xpath("//input[@id=\"search\"]");
    private By contactId = By.xpath("//div[@class=\"RDc zI7 iyn Hsu\"]/div[@role=\"button\"]");
    private By msgField = By.xpath("//textarea[@id=\"sendObjectMessage\"]");
    private By sendBtn = By.xpath("//button[@type=\"submit\"]");

    //share by....
    private By whatsappBtn = By.xpath("//button[@aria-label=\"Share on WhatsApp\"]");
    private By fbBtn = By.xpath("//button[@aria-label=\"Share on Facebook\"]");
    private By twitterBtn = By.xpath("//button[@aria-label=\"Share on Twitter\"]");
    private By emailBtn = By.xpath("//button[@aria-label=\"Share on Email\"]");

    private By emailInputField2 = By.xpath("//textarea[@id=\"email\"]");
//    private By msg = By.xpath("//textarea[@id=\"sendObjectMessage\"]");


    public ShareProfilePage(WebDriver driver) {
        this.driver = driver;
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

    /**
     * Share by whatsapp
     */
    public void sharByWhatsapp(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(whatsappBtn));
        driver.findElement(whatsappBtn).click();
    }

    /**
     * Share by FB
     */
    public void sharByFb(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fbBtn));
        driver.findElement(fbBtn).click();
    }

    /**
     * Share by twitter
     */
    public void sharByTwitter(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(twitterBtn));
        driver.findElement(twitterBtn).click();
    }

    /**
     * Share by email
     */
    public boolean clickEmailIcon(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailBtn));
        driver.findElement(emailBtn).click();
        return driver.findElement(emailInputField2).isDisplayed();
    }
    public void sharByEmail(String email, String msg){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputField2));
        driver.findElement(emailInputField2).sendKeys(email);
        driver.findElement(msgField).sendKeys(msg);

        wait.until(ExpectedConditions.elementToBeClickable(sendBtn));
        driver.findElement(sendBtn).click();
    }

    public boolean isPopupDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputField));
        return driver.findElement(emailInputField).isDisplayed();
    }

}
