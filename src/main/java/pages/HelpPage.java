package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HelpPage {
    private WebDriver driver;

    private By helpCenterLayout = By.xpath("//div[@id= \"QuestionMarkFlyout\"]");
    private By visitHlpLnk = By.xpath("//div[@id= \"QuestionMarkFlyout-item-0\"]");
    private By createWidgetLnk = By.xpath("//div[@id= \"QuestionMarkFlyout-item-1\"]");
    private By optionsList = By.xpath("//div[@role=\"listitem\"][@class=\"zI7 iyn Hsu\"]");

    private List<WebElement> options;

    public HelpPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPopupDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(helpCenterLayout));
        return driver.findElement(helpCenterLayout).isDisplayed();
    }

    public void clickVisitHelpOption(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(visitHlpLnk));
        driver.findElement(visitHlpLnk).click();
    }

    public void clickCreateOption(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(createWidgetLnk));
        driver.findElement(createWidgetLnk).click();
    }

    public void getOptions(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(optionsList));
        options = driver.findElements(optionsList);
    }

    public void clickAboutOption(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(optionsList));

        options.get(0).click();
    }

    public void clickBlogOption(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(optionsList));

        options.get(1).click();
    }

    public void clickBusinessOption(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(optionsList));

        options.get(2).click();
    }

    public void clickCareerOption(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(optionsList));

        options.get(3).click();
    }

    public void clickDeveloperOption(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(optionsList));

        options.get(4).click();
    }

}
