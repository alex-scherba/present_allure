package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by ascherba on 9/20/17.
 */
public class RegisterPage extends BasePage{

    @FindBy(id = "user_login")
    WebElement LOGIN;

    @FindBy(id = "password")
    WebElement PASSWORD;

    @FindBy(id = "password_confirmation")
    WebElement PASSWORD_CONFIRMATION;

    @FindBy(id = "user_firstname")
    WebElement FIRSTNAME;

    @FindBy(id = "user_lastname")
    WebElement LASTNAME;

    @FindBy(id = "user_mail")
    WebElement MAIL;

    @FindBy(id = "user_language")
    WebElement LANGUAGE;

    @FindBy(name = "commit")
    WebElement SUBMIT;

    public RegisterPage(WebDriver driver){
        super(driver);
    }

    @Step("Fill Registration Form: {0} ")
    public RegisterPage fillForm(String Login, String Password, String Firstname, String Lastname, String Mail){
        typeText(LOGIN, Login);
        typeText(PASSWORD, Password);
        typeText(PASSWORD_CONFIRMATION, Password);
        typeText(FIRSTNAME, Firstname);
        typeText(LASTNAME, Lastname);
        typeText(MAIL, Mail);
        return PageFactory.initElements(driver, RegisterPage.class);
    }

}
