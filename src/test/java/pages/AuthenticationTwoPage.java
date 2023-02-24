package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationTwoPage extends BasePage{

    public final By REGISTER_BUTTON_LOCATOR = By.id("submitAccount");

    public AuthenticationTwoPage(WebDriver driver) {
        super(driver);
    }

    public void clickRegisterButton() {
        driver.findElement(REGISTER_BUTTON_LOCATOR).click();
    }
}
