package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationSecondStepPage extends BasePage{

    public final By REGISTER_BUTTON_LOCATOR = By.id("submitAccount");


    public AuthenticationSecondStepPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void clickRegisterButton() {
        logger.info("Clicking registration button");
        driver.findElement(REGISTER_BUTTON_LOCATOR).click();
    }
}
