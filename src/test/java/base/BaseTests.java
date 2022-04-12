package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://www.pinterest.com/");
        homePage = new HomePage(driver);
    }
    
    @Test
    public void testHomeLoad(){
        String expectedUrl = "https://www.pinterest.com/";
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl+" "+expectedUrl);
        Assert.assertEquals(currentUrl, expectedUrl);
        if (currentUrl.equalsIgnoreCase(expectedUrl)){
            System.out.println("TestCase(Home Page Loading): Passed");
        }else {
            System.out.println("TestCase(Home Page Loading): Failed");
        }
    }

    @AfterClass
    public void exitWindow(){
        driver.quit();
    }
}
