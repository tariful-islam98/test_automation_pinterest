package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * TC_4.4
 * Notification
 */
public class NotificationPage {
    private WebDriver driver;

    private By notificationList = By.xpath("//ul[@data-test-id=\"scrollable-list\"]");

    public NotificationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String selectNotification(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(notificationList));
        WebElement ul = driver.findElement(notificationList);
        List<WebElement> options = ul.findElements(By.tagName("li"));
        options.get(0).click();
        return options.get(0).getAttribute("id");
    }
}
