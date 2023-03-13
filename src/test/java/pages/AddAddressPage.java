package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddAddressPage extends BasePage{

    private static final By SAVE_BUTTON_LOCATOR = By.cssSelector("#submitAddress");


    public AddAddressPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void clickSaveButton(){
        logger.info("Clicking Save button");
        driver.findElement(SAVE_BUTTON_LOCATOR).click();
    }
}
