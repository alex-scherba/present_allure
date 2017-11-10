package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ascherba on 9/20/17.
 */
public class BasePage {

    protected WebDriver driver;

    @FindBy(xpath = "//li[1]/a[@class='home']")
    WebElement HOME;

    @FindBy(xpath = "//li[1]/a[@class='home']")
    WebElement Home;

    @FindBy(xpath = "//li[1]/a[@class='home']")
    WebElement REGISTER;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Type text in the field")
    protected void typeText(WebElement elem, String msgText){
        elem.clear();
        elem.sendKeys(msgText);
    }

    @Step("Click button")
    private void clickButton(By selector){
        driver.findElement(selector).click();
    }


}
