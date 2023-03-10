package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage  extends BasePage{

    private static final By SIGN_IN_LOCATOR = By.cssSelector("a.login");
    private static final By SEARCH_INPUT_LOCATOR = By.cssSelector("#search_query_top");
    private static final By WOMEN_BUTTON_LOCATOR = By.cssSelector(".sf-with-ul[title='Women']");
    private static final By SIGN_OUT_LOCATOR = By.cssSelector("a.logout");
    private static final By MY_ACCOUNT_LOCATOR = By.cssSelector(".account");
    private static final By SEARCH_BUTTON_LOCATOR = By.cssSelector(".btn.btn-default.button-search");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void clickLoginButton() {
        logger.info("Clicking SignIn button");
        driver.findElement(SIGN_IN_LOCATOR).click();
    }

    @Step
    public void clickMyAccountButton() {
        logger.info("Clicking MyAccount button");
        driver.findElement(MY_ACCOUNT_LOCATOR).click();
    }

    @Step
    public void setItemNameToSearchInput(String itemName){
        logger.info("Input ItemName {}", itemName);
        driver.findElement(SEARCH_INPUT_LOCATOR).sendKeys(itemName);
    }

    @Step
    public void clickWomenButton() {
        logger.info("Clicking womenPage button");
        driver.findElement(WOMEN_BUTTON_LOCATOR).click();
    }

    @Step
    public void clickSignOutButton() {
        logger.info("Clicking SignOut button");
        driver.findElement(SIGN_OUT_LOCATOR).click();
    }

    @Step
    public void clickSearchButton() {
        logger.info("Clicking search button");
        driver.findElement(SEARCH_BUTTON_LOCATOR).click();
    }

    @Step
    public boolean signInIsDisplayed() {
        logger.info("SignIn button is displayed");
        return driver.findElement(SIGN_IN_LOCATOR).isDisplayed();
    }
}
