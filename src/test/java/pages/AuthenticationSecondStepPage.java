package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationSecondStepPage extends BasePage{

    public final By REGISTER_BUTTON_LOCATOR = By.id("submitAccount");

    public AuthenticationSecondStepPage(WebDriver driver) {
        super(driver);
    }

    public void clickRegisterButton() {
        driver.findElement(REGISTER_BUTTON_LOCATOR).click();
    }
}
