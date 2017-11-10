package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegisterPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by ascherba on 9/20/17.
 */
public class RegisterTest {

    private static WebDriver driver;

    @BeforeMethod(description = "Open Browser")
    private void set_up() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://redmine-train.dev.thumbtack.net:3000/account/register");
    }

//    @BeforeMethod(description = "Navigate to Login Page")
//    private void open(){
//        driver.get("http://redmine-train.dev.thumbtack.net:3000/account/register");
//    }

    @Test
//    @Owner("Alexander Scherba")
    @Description("Login with incorrect data")
    public void testRegister() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillForm("Login","Passw0rd","First","Last","test@mail.com");
//        clickButton();
 //       Assert.assertEquals(driver.findElement(By.xpath("//div[2][@id=\"content\"]/div[1]")).getText(),
 //               "Invalid user or password");
    }

    @AfterMethod(description = "Close Browser")
    private void tearDown() {
        driver.quit();
    }
}
