package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * TC_3.1
 * This page is to complete the signup processes.
 */
public class SignedUpPage {
    private WebDriver driver;
    private By successfulMsg = By.xpath("//*[contains(text(),\"Welcome to Pinterest\")]");//path for getting welcome message
    private By nextBtnLnk = By.xpath("//div[@data-test-id=\"nux_name_done_btn\"]/button");//path for getting the button to go next step
    private By genderMsg = By.xpath("//*[contains(text(),\"How do you identify?\")]");
    private By genderSelectBtn = By.xpath("//input[@id=\"male\"]");//path to select a gender option
    private By countryChoiceNxtBtn = By.xpath("//div[@data-test-id=\"nux-locale-country-next-btn\"]/button");//path for getting the button to go next step after choosing country

    private By topicDoneBtn = By.xpath("//div[@data-test-id=\"nux-picker-done-btn\"]/button");//path for getting 'Done' button after selecting topics

    private By qrDoneBtn = By.xpath("//div[@data-test-id=\"nux-qr-code-done-btn\"]/button");
    private By saveBtn = By.xpath("//button[@aria-label=\"Save button\"]");
    private By profileId = By.xpath("//div[@data-test-id=\"header-profile\"]");

//    String path = "//div[@data-test-id=\"nux-picker-topic-label\"]/*[contains(text(),\"Wallpaper\")]";

    public SignedUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSignedUp() {
        return driver.findElement(successfulMsg).isDisplayed();
    }

    public void clickNextBtn() {
        driver.findElement(nextBtnLnk).click();
    }

    public void selectGenderBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(genderMsg));
        driver.findElement(genderSelectBtn).click();
    }

    public void clickCountryPageNxtBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(countryChoiceNxtBtn));
        driver.findElement(countryChoiceNxtBtn).click();
    }

    /**
     * select 5 topics to go to the next step
     */
    public void selectTopic() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test-id=\"nux-picker-topic\"]")));
        List<WebElement> elements = driver.findElements(By.xpath("//div[@data-test-id=\"nux-picker-topic\"]"));

        for (int i=0; i<5; i++){
            elements.get(i).click();
        }
    }

    /**
     * after selecting topics click 'Done'
     */
    public void clickTopicBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.elementToBeClickable(topicDoneBtn));
        driver.findElement(topicDoneBtn).click();
    }

    public void clickQrDoneBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(qrDoneBtn));
        driver.findElement(qrDoneBtn).click();
    }

    public LoggedInHomePage clickSaveBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveBtn));
        driver.findElement(saveBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileId));
        return new LoggedInHomePage(driver);
    }

}
