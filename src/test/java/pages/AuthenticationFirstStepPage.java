package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationFirstStepPage extends BasePage{

    public final By INPUT_EMAIL_LOCATOR = By.id("email");
    public final By INPUT_PASSWORD_LOCATOR = By.id("passwd");
    public final By CREATE_BUTTON_LOCATOR = By.id("SubmitCreate");
    public final By INPUT_NEW_EMAIL_LOCATOR = By.id("email_create");
    public final By SIGN_IN_LOCATOR = By.cssSelector(".icon-lock.left");
    public final By SIGN_IN_ERROR_MESSAGE = By.cssSelector(".alert.alert-danger");


    public AuthenticationFirstStepPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void clickCreateButton() {
        logger.info("Clicking create button");
        driver.findElement(CREATE_BUTTON_LOCATOR).click();
    }

    @Step
    public void setUsername(String username) {
        logger.debug("Input username {}", username );
        driver.findElement(INPUT_EMAIL_LOCATOR).sendKeys(username);
    }

    @Step
    public void setPassword(String password) {
        logger.debug("Input password {}", password );
        driver.findElement(INPUT_PASSWORD_LOCATOR).sendKeys(password);
    }

    @Step
    public void emailNewInput(String newUsername) {
        logger.debug("Input new email {}", newUsername );
        driver.findElement(INPUT_NEW_EMAIL_LOCATOR).sendKeys(newUsername);
    }

    @Step
    public void clickSignInButton() {
        logger.info("Clicking SignIn button");
        driver.findElement(SIGN_IN_LOCATOR).click();
    }

    @Step
    public boolean invalidEmailMessage() {
        logger.info("Message is displayed");
        return driver.findElement(SIGN_IN_ERROR_MESSAGE).isDisplayed();
    }

    @Step
    public void waitForInvalidMessage() {
        logger.info("Wait message");
        waitForElementDisplayed(SIGN_IN_ERROR_MESSAGE);
    }
}
