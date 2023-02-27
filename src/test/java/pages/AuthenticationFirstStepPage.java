package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationFirstStepPage extends BasePage{

    public final By INPUT_EMAIL_LOCATOR = By.id("email");
    public final By INPUT_PASSWORD_LOCATOR = By.id("passwd");
    public final By CREATE_BUTTON_LOCATOR = By.id("SubmitCreate");
    public final By INPUT_NEW_EMAIL_LOCATOR = By.id("email_create");

    public AuthenticationFirstStepPage(WebDriver driver) {
        super(driver);
    }

    public void clickCreateButton() {
        driver.findElement(CREATE_BUTTON_LOCATOR).click();
    }

    public void emailInput(String username) {
        driver.findElement(INPUT_EMAIL_LOCATOR).sendKeys(username);
    }

    public void passwordInput(String password) {
        driver.findElement(INPUT_PASSWORD_LOCATOR).sendKeys(password);
    }
    public void emailNewInput(String newUsername) {
        driver.findElement(INPUT_NEW_EMAIL_LOCATOR).sendKeys(newUsername);
    }

}
