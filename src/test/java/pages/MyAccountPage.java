package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage{

    private static final By ACCOUNT_HAS_BEEN_CREATED_MESSAGE = By.cssSelector(".alert.alert-success");
    private static final By ADD_ADDRESS_LOCATOR = By.cssSelector(".icon-building");
    private static final By SIGN_IN_MESSAGE = By.cssSelector(".page-heading");
    private static final By WISH_LIST_LOCATOR = By.cssSelector(".lnk_wishlist");


    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public boolean successfulCreatedMessage(){
        logger.info("Message about successful created account is displayed");
        return driver.findElement(ACCOUNT_HAS_BEEN_CREATED_MESSAGE).isDisplayed();
    }

    @Step
    public void addMyFirstAddress(){
        logger.info("Clicking add address button");
        driver.findElement(ADD_ADDRESS_LOCATOR).click();
    }

    @Step
    public boolean successfulSignInMessage(){
        logger.info("Message about successful LogIn is displayed");
        return driver.findElement(SIGN_IN_MESSAGE).isDisplayed();
    }

    @Step
    public void clickWishListButton() {
        logger.info("Clicking wishlist button");
        driver.findElement(WISH_LIST_LOCATOR).click();
    }
}
