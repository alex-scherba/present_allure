package tests;

import com.beust.jcommander.Parameter;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by ascherba on 9/19/17.
 */
public class LoginTest {

    private static WebDriver driver;

    @BeforeMethod(description = "Open Browser and navigate to Login Page")
    private void set_up() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://redmine-train.dev.thumbtack.net:3000/login");
    }

    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][]{{"", "Test@123"},
                              {"testuser_1", ""},
                              {"testuser_1", "Test@123"}};
    }

    @Test(dataProvider = "Authentication")
    @Description("Login with incorrect data")
    @Parameters("USERNAME")
    public void test(String sUsername, String sPassword) {
        fillForm(sUsername, sPassword);
        clickButton();
        Assert.assertEquals(driver.findElement(By.xpath("//div[2][@id=\"content\"]/div[1]")).getText(),
                "Invalid user or password");
    }

    @Step("Fill login form")
    private void fillForm(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Step("Click Submit button")
    private void clickButton() {
        driver.findElement(By.name("login")).click();
    }

    @AfterMethod(description = "Close Browser")
    private void tearDown() {
        driver.quit();
    }
}
