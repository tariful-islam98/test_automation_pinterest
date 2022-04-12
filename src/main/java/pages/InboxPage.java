package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class InboxPage {
    private WebDriver driver;

    private By newMsgBtnLnk = By.xpath("//button[@aria-label= \"Compose new message\"]");
    private By contactInputField = By.xpath("//input[@id= \"contactSearch\"]");
    private By contactList = By.xpath("//div[@class= \"Jea gjz mQ8 wsz zI7 iyn Hsu\"]");
    private By msgInputField = By.xpath("//textarea[@id= \"messageDraft\"]");
    private By sendBtn = By.xpath("//button[@aria-label=\"Send message to conversation\"]");

    public InboxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickNewMsgBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(newMsgBtnLnk));
        driver.findElement(newMsgBtnLnk).click();
    }

    public void selectContact(String email){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactInputField));
        driver.findElement(contactInputField).sendKeys(email);

        wait.until(ExpectedConditions.visibilityOfElementLocated(contactList));
        List<WebElement> contact = driver.findElements(contactList);
        contact.get(0).click();
    }

    public void sendMessage(String msg){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(msgInputField));
        driver.findElement(msgInputField).sendKeys(msg);

        wait.until(ExpectedConditions.visibilityOfElementLocated(sendBtn));
        driver.findElement(sendBtn).click();
    }
}
