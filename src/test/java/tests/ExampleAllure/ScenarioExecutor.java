package tests.ExampleAllure;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by ascherba on 9/26/17.
 */
public class ScenarioExecutor {
    private static WebDriver driver;
    protected WebElement elem;

    @BeforeTest(description = "Example Before Test")
    private void sayAll(){
        System.out.println("Test run");
    }

    @BeforeClass(description = "Example Before Class")
    private void sayMe(){
        System.out.println("Test class run");
    }

    @BeforeMethod(description = "Open Browser")
    private void set_up() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test(description = "Placement for Test Name")
    @Owner("Alex Scherba")
    @Description("Registration of the user that is in the system")
    public void testRegister() {
        open();
        fillRegisterForm("ExampleLogin","Passw0rd","First",
                         "Last","test@mail.com");
        clickSubmit();
        assertErrorText("Login has already been taken");
    }

    @AfterMethod(description = "Close Browser")
    private void tearDown() {
        driver.quit();
    }

    @Step("Navigate to Register Page")
    private void open(){
        driver.get("http://redmine-train.dev.thumbtack.net:3000/account/register");
    }

    @Step("Fill Register Form with parameters")
    private void fillRegisterForm(String Login, String Password, String Firstname, String Lastname, String Mail){
        typeText(By.id("user_login"),"ExampleLogin");
        typeText(By.id("password"),"");
        typeText(By.id("password_confirmation"),"");
        typeText(By.id("user_firstname"),"");
        typeText(By.id("user_lastname"),"");
        typeText(By.id("user_mail"),"");
    }


    private void typeText(By selector, String messageText){
        elem = driver.findElement(selector);
        elem.clear();
        elem.sendKeys(messageText);
    }

    @Step("Click button")
    private void clickSubmit(){
        driver.findElement(By.name("commit")).click();
    }

    @Step("Verify Error Text")
    private void assertErrorText(String errorText) {
        Assert.assertEquals(driver.findElement(By.cssSelector("#errorExplanation > ul")).getText(), errorText);
    }
}
