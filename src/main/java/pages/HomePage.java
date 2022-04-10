package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private String loginBtnPath = "//div[@data-test-id=\"simple-login-button\"]/button";
    private By loginLink = By.xpath(loginBtnPath);

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickLogin(){
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }
}
