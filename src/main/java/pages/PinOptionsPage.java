package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PinOptionsPage {
    private WebDriver driver;

    private By pinFlyout = By.xpath("//div[@id= \"AddPinDropdown\"]");
    private By createPin = By.xpath("//div[@data-test-id= \"createAPin\"]");
    private By getBrowser = By.xpath("//div[@id= \"AddPinDropdown-item-0\"]");

    public PinOptionsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPinOptionsDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(pinFlyout));
        return driver.findElement(pinFlyout).isDisplayed();
    }

    public void clickCreatePin(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(createPin));

        driver.findElement(createPin).click();
    }

    public void clickGetBrowser(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(getBrowser));

        driver.findElement(getBrowser).click();
    }

    public String currentUrl(){
        return driver.getCurrentUrl();
    }
}
